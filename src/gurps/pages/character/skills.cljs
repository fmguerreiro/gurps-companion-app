(ns gurps.pages.character.skills
  (:require ["react-native" :as rn]
            ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [key->str ->int flatten-key]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.widgets.helpers :refer [generify-key]]
            [gurps.pages.character.utils.skills :refer [skills difficulties] :rename {skills skill-map}]
            [gurps.pages.character.widgets.attribute :refer [key->i18n-label]]
            [gurps.pages.character.widgets.attributes] ;; NOTE: makes sure the subs are registered
            [clojure.string :as str]
            [taoensso.timbre :as log]))

(defn- row
  [col1 col2 col3 col4 col5]
  [:> view {:style (tw "flex flex-row gap-1 h-8")}
   [:> view {:style (tw "w-5/12 my-auto bg-red-100")} col1]
   [:> view {:style (tw "w-1/12 my-auto bg-blue-100")} col2]
   [:> view {:style (tw "w-2/12 my-auto bg-green-100")} col3]
   [:> view {:style (tw "w-1/12 my-auto bg-green-100")} col4]
   [:> view {:style (tw "w-3/12 my-auto bg-indigo-100 pr-3")} col5]])

(defn- header
  []
  [row
   [:> text {:style (tw "font-bold text-left capitalize")} (i18n/label :t/name)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/level)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/attribute)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/diff)]
   [:> text {:style (tw "font-bold text-center capitalize")} (i18n/label :t/cost)]])

(defn- add-skill-button
  []
  (when-let [navigation (rnn/useNavigation)]
    [:> view {:style (tw "")}
     ;; TODO: put this button into a design library and use it here
     [:> button {:style (tw "p-0 w-14 h-14 bg-red-600 rounded-full hover:bg-red-700 active:shadow-lg shadow focus:outline-none align-middle justify-center items-center")
                 :onPress (fn [] (-> navigation (.navigate (i18n/label :t/add-skill))))}
      [:> text {:style (tw "text-white font-bold text-xl")} "+"]]]))

(defn- best-attr
  "Get the highest attribute value"
  [attr-map attrs]
  (apply max (map (fn [attr] (get attr-map attr)) (if (seqable? attrs) attrs [attrs]))))

(defn- difficulty-mod
  "Adjusts the value based on the difficulty level"
  [val diff]
  (cond (= diff :e) val
        (= diff :a) (dec val)
        (= diff :h) (- 2 val)
        (= diff :v) (- 3 val)))

(defn cost-mod
  "Adjusts the value based on the cost"
  [base n]
  (let [increment (cond
                    (<= n 1) 0
                    (<= n 3) 1
                    (<= n 4) 2
                    (<= n 8) 3
                    (<= n 12) 4
                    (<= n 16) 5
                    :else (+ 5 (quot (- n 16) 4)))]
    (+ base increment)))

;; TODO: refactor this to use :skill/lvl subscription instead
(defn- skill-lvl
  [skill-key idx]
  (let [skill (-> skill-key generify-key skill-map)
        cost  (some-> (rf/subscribe [:skill idx]) deref :cost)
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
    [underlined-input {:val (cost-mod lvl cost)
                       :text-align "center"
                       :disabled? true}]))

(defn- attr->label
  [attr]
  (str/join ","
            (map #(i18n/label (key->i18n-label %))
                 (if (seq? attr) attr [attr]))))

(defn- diff->label
  [diff]
  (i18n/label (keyword :t (diff difficulties))))

(defn character-skills-page
  []
  (let [skills (some-> (rf/subscribe [:skills]) deref)
        navigation (rnn/useNavigation)]
    [:> view {:style (tw "flex flex-1 flex-col px-2 bg-white")}
     [:> rn/ScrollView {:style (tw "flex flex-1 flex-col bg-white flex-grow")}
      [header]

      ;; skills
      (map-indexed (fn [i {:keys [k name cost]}]
                     (let [{:keys [diff attr]} (-> k generify-key skill-map)]
                       ^{:key (str "skill-" i)}
                       [row
                        ;; name
                        [underlined-input {:val name
                                           :style (tw "capitalize")
                                           :on-press #(let [k' (generify-key k)]
                                                        (-> navigation (.navigate (i18n/label :t/add-skill-specialization) #js {:id (key->str k')})))
                                           :disabled? true}]
                        ;; lvl
                        [skill-lvl k i]
                        ;; main attr(s)
                        [underlined-input {:val (attr->label attr)
                                           :text-align "center"
                                           :disabled? true}]
                        ;; difficulty
                        [underlined-input {:val (diff->label diff)
                                           :text-align "center"
                                           :disabled? true}]
                        ;; cost
                        [bracketed-numeric-input {:val cost
                                                  :input-mode "numeric"
                                                  :max-length 2
                                                  :on-change-text #(debounce-and-dispatch [:skills.update/cost i (->int %)] 500)}]]))
                   skills)]

     ;; add-skill button
     [:> view {:style (tw "absolute bottom-4 right-4")}
      [add-skill-button]]]))

;; register all skill-cost subs
(doseq [skill (keys skill-map)]
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

(rf/reg-sub
 :skill
 :<- [:skills]
 (fn [skills [_ idx]]
   (get-in skills [idx])))

(rf/reg-sub
 :skills/lvls
 :<- [:skills]
 :<- [:attributes/str]
 :<- [:attributes/int]
 :<- [:attributes/dex]
 :<- [:attributes/per]
 :<- [:attributes/will]
 :<- [:attributes/ht]
 (fn [[skills str int dex per will ht]]
   ;; => {:k :staff, :lvl 17, ...}
   (let [attrs {:str str :int int :dex dex :per per :will will :ht ht}]
     (->> skills
          (map #(merge % ((generify-key (:k %)) skill-map)))
          (map #(merge % {:attr-lvl (best-attr attrs (:attr %))}))
          (map #(merge % {:diff-lvl (difficulty-mod (:attr-lvl %) (:diff %))}))
          (map #(merge % {:lvl (cost-mod (:diff-lvl %) (:cost %))}))
          (reduce #(assoc %1 (:k %2) %2) {})))))

(rf/reg-event-fx
 :skills.update/cost
 (fn [{:keys [db]} [_ idx cost]]
   (let [new-db (assoc-in db [:skills idx :cost] cost)]
     {:db new-db
      :effects.async-storage/set {:k     :skills
                                  :value (get-in new-db [:skills])}})))
