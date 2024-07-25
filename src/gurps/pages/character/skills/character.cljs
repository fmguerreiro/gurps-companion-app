(ns gurps.pages.character.skills.character
  (:require ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [cljs-bean.core :refer [->js ->clj]]
            [re-frame.core :as rf]
            [reagent.core :as r]
            [react-native.platform :refer [ios?]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [key->str ->int flatten-key]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            [gurps.widgets.base :refer [keyboard-avoiding-view view flat-list text button]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.widgets.helpers :refer [generify-key]]
            [gurps.pages.character.utils.skills :refer [skills difficulties lvl-with-difficulty lvl-with-cost] :rename {skills skill-map}]
            [gurps.pages.character.widgets.attribute :refer [key->t]]
            [gurps.pages.character.widgets.attributes])) ;; NOTE: makes sure the subs are registered

(defn- row
  [col1 col2 col3 col4 col5]
  [:> view {:style (tw "flex flex-row h-6 gap-2 mx-2 my-1")}
   [:> view {:style (tw "flex-4 justify-center items-start")} col1]
   [:> view {:style (tw "flex-1 justify-center items-center")} col2]
   [:> view {:style (tw "flex-1.5 justify-center items-center")} col3]
   [:> view {:style (tw "flex-0.8 justify-center items-center")} col4]
   [:> view {:style (tw "flex-1 justify-center items-end")} col5]])

(defn- header
  []
  (r/as-element
   [row
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/name)]
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/level)]
    [:> text {:style (tw "capitalize font-bold"), :numberOfLines 1} (i18n/label :t/attribute)]
    [:> text {:style (tw "capitalize font-bold"), :numberOfLines 1} (i18n/label :t/diff)]
    [:> text {:style (tw "capitalize font-bold")} (i18n/label :t/cost)]]))

(defn- best-attr
  "Get the highest attribute value"
  [attr-map attrs]
  (apply max (map (fn [attr] (get attr-map attr)) (if (seqable? attrs) attrs [attrs]))))

(defn- skill-lvl
  [skill-key]
  (let [skills (some-> (rf/subscribe [:skills/lvls]) deref)
        skill  (skill-key skills)]
    [:> text {:style (tw "text-center")} (:lvl skill)]))

(defn- diff->label
  [diff]
  (i18n/label (keyword :t (diff difficulties))))

(defn- item
  [{:keys [k name cost]} idx nav]
  (let [{:keys [diff attr]} (-> k generify-key skill-map)
        on-press  #(-> nav (.push (i18n/label :t/add-skill-specialization) #js {:id (key->str (generify-key %))}))]
    (r/as-element
     [row
      ;; name
      (if ios?
        [:> text {:onPress #(on-press k), :numberOfLines 1, :style (tw "capitalize")} name]
        [:> button {:style (tw "flex-1"), :onPress #(on-press k)}
         [:> text {:style (tw "capitalize"), :numberOfLines 1} name]])

      ;; lvl
      [skill-lvl k]

      ;; main attr(s)
      [:> text {:style (tw "text-center")} (key->t attr)]

      ;; difficulty
      [:> text {:style (tw "text-center")} (diff->label diff)]

      ;; cost
      [bracketed-numeric-input {:val cost
                                :input-mode "numeric"
                                :max-length 2
                                :on-change-text #(debounce-and-dispatch [:skills.update/cost idx (->int %)] 500)}]])))

(defn character-skills-page
  []
  (let [nav      (rnn/useNavigation)
        skills   (some-> (rf/subscribe [:skills]) deref)]
    [keyboard-avoiding-view {:behavior :padding, :style (tw "flex-1")}
     [:> view {:style (tw "bg-white flex flex-col grow")}

      [flat-list
       {:data (->> skills (map #(merge % {:id (:k %)})) ->js)

        :key-extractor
        (fn [item]
          (:id (->clj item :keywordize-keys true)))

        :estimated-item-size 40

        :render-item
        (fn [item-info-js]
          (let [item-info (->clj item-info-js :keywordize-keys true)
                {data :item} item-info
                idx (:index item-info)
                data' (merge data {:k (keyword (:k data))})]
            (item data' idx nav)))

        :ListHeaderComponent header}]

      [:> view {:style (tw "absolute bottom-4 right-4")}
       [add-button {:on-click #(-> nav (.push (i18n/label :t/add-skill)))}]]]]))

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
 :skill-map
 :<- [:skills]
 (fn [skills]
   (->> skills
        (map #(:k %))
        set)))

(rf/reg-sub
 :skill
 :<- [:skills]
 (fn [skills [_ idx]]
   (get-in skills [idx])))

(defn- debug
  [exp & tag]
  (println tag exp)
  exp)

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
   ;; => [{:k :staff, :lvl 17, ...}]
   (let [attrs {:str str :int int :dex dex :per per :will will :ht ht}]
     (->> skills
          (map #(merge % ((generify-key (:k %)) skill-map)))
          (map #(merge % {:attr-lvl (best-attr attrs (:attr %))}))
          (map #(merge % {:diff-lvl (lvl-with-difficulty (:attr-lvl %) (:diff %))}))
          (map #(merge % {:lvl (lvl-with-cost (:diff-lvl %) (:cost %))}))
          (reduce #(assoc %1 (:k %2) %2) {})))))

(rf/reg-event-fx
 :skills.update/cost
 (fn [{:keys [db]} [_ idx cost]]
   (let [old-c  (get-in db [:skills idx :cost] 0)
         new-db (assoc-in db [:skills idx :cost] cost)]
     {:db new-db
      :fx [[:dispatch [:profile.update/unspent-points (- cost old-c)]]]
      :effects.async-storage/set {:k     :skills
                                  :value (get-in new-db [:skills])}})))
