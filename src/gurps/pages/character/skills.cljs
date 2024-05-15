(ns gurps.pages.character.skills
  (:require ["react-native" :as rn]
            ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [key->str flatten-key]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.utils.skills :refer [skills]]
            [gurps.pages.character.widgets.attributes] ;; NOTE: makes sure the subs are registered
            [taoensso.timbre :as log]))

(defn- row
  [col1 col2 col3 col4]
  [:> view {:style (tw "flex flex-row gap-1 h-6")}
   [:> view {:style (tw "w-5/12 my-auto bg-red-100")} col1]
   [:> view {:style (tw "w-1/12 my-auto bg-blue-100")} col2]
   [:> view {:style (tw "w-3/12 my-auto bg-green-100")} col3]
   [:> view {:style (tw "w-3/12 my-auto bg-indigo-100")} col4]])

(defn- header
  []
  [row
   [:> text {:style (tw "font-bold text-left capitalize")} (i18n/label :t/name)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/level)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/relative-level)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/cost)]])

(defn- add-skill-button
  []
  (when-let [navigation (rnn/useNavigation)]
    [:> view {:style (tw "")}
     ;; TODO: put this button into a design library and use it here
     [:> button {:style (tw "p-0 w-14 h-14 bg-red-600 rounded-full hover:bg-red-700 active:shadow-lg shadow focus:outline-none align-middle justify-center items-center")
                 :onPress (fn [] (-> navigation (.navigate (i18n/label :t/add-skill))))}
      [:> text {:style (tw "text-white font-bold text-xl")} "+"]]]))
(defn- generify-key
  [k]
  (if (namespace k) (keyword (namespace k) :sp) k))

(defn- best-attr
  "Get the highest attribute value"
  [attrs attr]
  (apply max (map (fn [attr] (get attrs attr)) attr)))

(defn- difficulty-mod
  [val diff]
  (cond (= diff :e) val
        (= diff :a) (dec val)
        (= diff :h) (- 2 val)
        (= diff :v) (- 3 val)))

(defn- skill-lvl
  [skill-key]
  (let [skill (-> skill-key generify-key skills)
        attr  (:attr skill)
        attrs {:str   (some-> (rf/subscribe [:attributes/str]) deref)
               :int   (some-> (rf/subscribe [:attributes/int]) deref)
               :dex   (some-> (rf/subscribe [:attributes/dex]) deref)
               :per   (some-> (rf/subscribe [:attributes/per]) deref)
               :will  (some-> (rf/subscribe [:attributes/will]) deref)
               :ht    (some-> (rf/subscribe [:attributes/ht]) deref)}
        attr-lvl      (if (seq? attr) (best-attr attrs attr) (attr attrs))
        diff          (:diff skill)
        lvl           (difficulty-mod attr-lvl diff)]
    [underlined-input {:val lvl
                       :text-align "center"
                       :disabled? true}]))

(defn character-skills-page
  []
  (let [skills (some-> (rf/subscribe [:skills]) deref)
        navigation (rnn/useNavigation)]
    [:> view {:style (tw "flex flex-1 flex-col px-2 bg-white")}
     [:> rn/ScrollView {:style (tw "flex flex-1 flex-col bg-white flex-grow")}
      [header]

      ;; TODO: show which attribute it's based from
      ;;       show difficulty!
      ;;       remove relative lvl

      ;; skills
      (map-indexed (fn [i {:keys [k name rel-lvl cost]}]
                     ^{:key (str "skill-" i)}
                     [row
                      ;; name
                      [underlined-input {:val name
                                         :style (tw "capitalize")
                                         :on-press #(let [k' (generify-key k)]
                                                      (-> navigation (.navigate (i18n/label :t/add-skill-specialization) #js {:id (key->str k')})))
                                         :disabled? true}]
                      ;; lvl
                      [skill-lvl k]
                      ;; relative-lvl
                      [underlined-input {:val rel-lvl
                                         :text-align "center"
                                         :disabled? true
                                         :on-change-text #()}]
                      ;; cost
                      [bracketed-numeric-input {:val cost
                                                :on-change-text #()}]])
                   skills)]

     ;; add-skill button
     [:> view {:style (tw "absolute bottom-4 right-4")}
      [add-skill-button]]]))

;; register all skill-cost subs
(doseq [skill (keys skills)]
  (when (not (= "sp" (name skill)))
    (let [skill-key (flatten-key skill)]
      ;; (info "registering sub" (str (keyword :skill-costs skill-key)))
      (rf/reg-sub
       (keyword :skill-costs skill-key)
       (fn [db _]
         (get-in db [:skill-costs skill-key] 0))))))

(rf/reg-sub
 :skills
 (fn [db]
   (get-in db [:skills] [])))
