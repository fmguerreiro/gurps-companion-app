(ns gurps.pages.character.info.widgets.languages-section
  (:require [taoensso.timbre :refer [info]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.widgets.dropdown :refer [dropdown]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            ["@expo/vector-icons/MaterialIcons" :default icon]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [clojure.string :as str]))

;; TODO: written may be less if TL is low (less than 3?)
;; TODO: dyslexia makes you illiterate

(def dropdown-data
  [{:label (i18n/label :t/lang-lvl-native)   :value "native"},
   {:label (i18n/label :t/lang-lvl-accented) :value "accented"},
   {:label (i18n/label :t/lang-lvl-broken)   :value "broken"}])

(defn row
  [col1 col2 col3 col4 col5]
  [:> view {:style (tw "flex flex-row grow w-full")}
   col1

   [:> view {:style (tw "flex-1 flex flex-row")}
    col2
    col3]

   [:> view {:style (tw "flex flex-row")}
    col4
    col5]])

(def num->key
  (comp keyword str))

(defn- native-icon
  [{:keys [i native?]}]
  (let [color (-> (tw (if native? "text-black" "text-slate-400")) .-color)]
    [:> button {:style (tw "items-center justify-center")
                :onPress #(rf/dispatch [:languages/update, (num->key i), :native?, (not native?)])}
     [:> icon {:name "hourglass-bottom" :size 20 :color color}]]))

(defn- get-lang-skill-label
  [skill]
  (->> dropdown-data
       (filter #(= skill (:value %)))
       first
       :label))

(def lang-skill-cost {:native 3, :accented 2, :broken 1})
(defn lang-cost
  [{:keys [native? spoken written]}]
  (if native?
    0
    (+ ((keyword spoken) lang-skill-cost)
       ((keyword written) lang-skill-cost))))

(defn- language-row
  [{:keys [i name spoken written native?]}]
  [row
   ;; language name underline (adds a "(Native)" to the right if native button is pressed)
   [underlined-input {:val (str name (when (and native?
                                                (not (str/includes? name (i18n/label :t/lang-lvl-native))))
                                       (str " (" (i18n/label :t/lang-lvl-native) ")")))
                      :style (when native? (tw "text-slate-400"))
                      :disabled? native?
                      :on-change-text #(debounce-and-dispatch [:languages/update, (num->key i), :name, %] 500)}]

   ;; spoken skill dropdown
   ^{:key (str i "-spoken")}
   [dropdown {:style (tw "flex-1")
              :placeholder-style (tw "text-center text-xs")
              :selected-style (tw "text-center")
              :on-change #(rf/dispatch [:languages/update, (num->key i), :spoken, %])
              :placeholder (get-lang-skill-label spoken)
              :disabled? native?
              :data dropdown-data}]

   ;; written skill dropdown
   ^{:key (str i "-written")}
   [dropdown {:style (tw "flex-1")
              :placeholder-style (tw "text-center text-xs")
              :selected-style (tw "text-center")
              :on-change #(rf/dispatch [:languages/update, (num->key i), :written, %])
              :placeholder (get-lang-skill-label written)
              :disabled? native?
              :data dropdown-data}]

   ;; turn native button
   [native-icon {:i i :native? native?}]

   ;; cost (0 if native)
   [bracketed-numeric-input {:max-length 2
                             :val        (lang-cost {:native? native? :written written :spoken spoken})
                             :editable?  false}]])

(defn header
  []
  [row
   [:> text {:style (tw "flex-1 font-bold")} (i18n/label :t/languages)]
   [:> text {:style (tw "flex-1 text-center font-bold")} (i18n/label :t/lang-spoken)]
   [:> text {:style (tw "flex-1 text-center font-bold")} (i18n/label :t/lang-written)]
   [:> view {:style (tw "w-5")}]
   [:> view {:style (tw "w-10")}]])

(defn languages-section []
  (let [languages (some-> (rf/subscribe [:languages]) deref)
        lang-array (vec (sort-by :i (filter map? (apply concat languages))))]
    [:> view {:style (tw "flex flex-col gap-1")}

     [header]

     (for [lang lang-array]
       ^{:key (str (:i lang) "-lang")}
       [language-row lang])]))

     ;; TODO: dynamic number of languages, for now just keep 4 (because we set the keys we want to fetch statically from app-db)
     ;; (when (or (empty? languages)
     ;;           (not-any? #(seq (:name %)) lang-array)) ;; or all filled-in
     ;;   ^{:key (str (:i (count lang-array)) "-lang")}
     ;;   [language-row (merge default-lang {:i (count lang-array)})])

(rf/reg-sub
 :languages
 (fn [db _]
   (get-in db [:languages])))

(def lang-keys [:spoken :native? :i :name :cost :written])
(rf/reg-event-fx
 :languages/update
 (fn [{:keys [db]} [_ i k v]]
   (let [new-db (update-in db [:languages i] #(merge % {k v}))]
     {:db                                 new-db
      :effects.async-storage/set-multiple {:items (for [k' lang-keys]
                                                    {:k     (keyword (str "languages/" (symbol i) "/" (symbol k')))
                                                     :value (get-in new-db [:languages i k'])})}})))

(comment

  (def a {:0 {:i 0 :name "a" :spoken "broken", :written "broken", :native? false, :cost 0}
          :1 {:i 1 :name "" :spoken "broken", :written "broken", :native? false, :cost 0}})

  (vec (sort-by :i (filter map? (apply concat (:languages gurps.db/app-db)))))

  (def lang-array (vec (filter map? (apply concat a))))
  (not-any? #(seq (:name %)) lang-array))
