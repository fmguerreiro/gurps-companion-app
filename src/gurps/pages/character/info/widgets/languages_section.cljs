(ns gurps.pages.character.info.widgets.languages-section
  (:require [gurps.widgets.base :refer [view text button]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            ["@expo/vector-icons/FontAwesome" :default icon]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [clojure.string :as str]
            [taoensso.timbre :as log]))

;; TODO: "written" skill may be less if TL is low (less than 3?)
;; TODO: dyslexia makes you illiterate ??

(def dropdown-data
  [{:label (i18n/label :t/lang-lvl-native)   :value "native"},
   {:label (i18n/label :t/lang-lvl-accented) :value "accented"},
   {:label (i18n/label :t/lang-lvl-broken)   :value "broken"}])

(defn- row
  [col1 col2 col3 col4 col5]
  [:> view {:style (tw "flex flex-row grow gap-2 w-full h-6")}
   [:> view {:style (tw "w-4/12")} col1]
   col2
   col3
   col4
   col5])

(defn- native-icon
  [{:keys [i native?]}]
  (let [color (-> (tw (if native? "text-black" "text-slate-400")) .-color)]
    [:> button {:style (tw "items-center justify-center")
                :onPress #(rf/dispatch [:languages/update, i, :native?, (not native?)])}
     [:> icon {:style (tw "align-middle mt-1") :name "language" :size 20 :color color}]]))

(defn- get-lang-skill-label
  [skill]
  (->> dropdown-data
       (filter #(= skill (:value %)))
       first
       :label))

(def ^:private lang-skill-cost {:native 3, :accented 2, :broken 1})
(defn- lang-cost
  [{:keys [native? spoken written name]}]
  (if (or native? (empty? name))
    0
    (+ ((keyword spoken) lang-skill-cost)
       ((keyword written) lang-skill-cost))))

(defn- language-row
  [{:keys [name spoken written native?]} idx]
  [row
   ;; language name underline (adds a "(Native)" to the right if native button is pressed)
   [underlined-input {:val (str name (when (and native?
                                                (not (str/includes? name (i18n/label :t/lang-lvl-native))))
                                       (str " (" (i18n/label :t/lang-lvl-native) ")")))
                      :style (when native? (tw "text-slate-400"))
                      :disabled? native?
                      :on-change-text #(debounce-and-dispatch [:languages/update, idx, :name, %] 500)}]

   ;; spoken skill dropdown
   ^{:key (str idx "-spoken")}
   [dropdown {:style (tw "flex-1")
              :placeholder-style (tw "text-right text-xs")
              :selected-style (tw "text-right")
              :on-change #(rf/dispatch [:languages/update, idx, :spoken, %])
              :placeholder (get-lang-skill-label spoken)
              :disabled? native?
              :data dropdown-data}]

   ;; written skill dropdown
   ^{:key (str idx "-written")}
   [dropdown {:style (tw "flex-1")
              :placeholder-style (tw "text-right text-xs")
              :selected-style (tw "text-right")
              :on-change #(rf/dispatch [:languages/update, idx, :written, %])
              :placeholder (get-lang-skill-label written)
              :disabled? native?
              :data dropdown-data}]

   ;; turn native button
   [native-icon {:i idx :native? native?}]

   ;; cost (0 if native) or not yet filled in
   [bracketed-numeric-input {:max-length 2
                             :val        (lang-cost {:native? native? :written written :spoken spoken :name name})
                             :editable?  false}]])

(defn- header
  []
  [row
   [:> text {:style (tw "flex-1 font-bold")} (i18n/label :t/languages)]
   [:> text {:style (tw "flex-1 text-center font-bold")} (i18n/label :t/lang-spoken)]
   [:> text {:style (tw "flex-1 text-center font-bold")} (i18n/label :t/lang-written)]
   [:> view {:style (tw "w-5")}]
   [:> view {:style (tw "w-10")}]])

(def ^:private default-lang {:name "" :spoken "broken" :written "broken" :native? false})

(defn languages-section []
  (let [languages (some-> (rf/subscribe [:languages]) deref)]
    [:> view {:style (tw "flex flex-col gap-1")}

     [header]

     (map-indexed
      (fn [idx lang]
        ^{:key (str idx "-lang")}
        [language-row (conj lang {:i idx}) idx])
      (conj languages default-lang))]))

(rf/reg-sub
 :languages
 (fn [db _]
   (get-in db [:languages] [])))

(rf/reg-event-fx
 :languages/update
 (fn [{:keys [db]} [_ i k v]]
   (let [existing-language (get-in db [:languages i] default-lang)
         old-cost          (lang-cost existing-language)
         new-language      (merge existing-language {k v})
         new-db            (assoc-in db [:languages i] (merge new-language {:cost (lang-cost new-language)}))
         cost              (get-in new-db [:languages i :cost])]
     {:db                        new-db
      :fx [[:dispatch [:profile.update/unspent-points (- cost old-cost)]]]
      :effects.async-storage/set {:k     :languages
                                  :value (get-in new-db [:languages])}})))

(comment
  (def a {:0 {:i 0 :name "a" :spoken "broken", :written "broken", :native? false, :cost 0}
          :1 {:i 1 :name "" :spoken "broken", :written "broken", :native? false, :cost 0}})

  (vec (sort-by :i (filter map? (apply concat (:languages gurps.db/app-db)))))

  (def lang-array (vec (filter map? (apply concat a))))
  (not-any? #(seq (:name %)) lang-array))
