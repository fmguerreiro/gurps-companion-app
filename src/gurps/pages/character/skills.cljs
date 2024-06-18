(ns gurps.pages.character.skills
  (:require ["react-native" :as rn]
            ["@react-navigation/native" :as rnn]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [react-native.platform :refer [ios?]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [key->str ->int flatten-key]]
            [gurps.utils.debounce :refer [debounce-and-dispatch]]
            [gurps.widgets.base :refer [view text button]]
            [gurps.widgets.add-button :refer [add-button]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.pages.character.widgets.helpers :refer [generify-key]]
            [gurps.pages.character.utils.skills :refer [skills difficulties lvl-with-difficulty lvl-with-cost] :rename {skills skill-map}]
            [gurps.pages.character.widgets.attribute :refer [key->i18n-label]]
            [gurps.pages.character.widgets.attributes] ;; NOTE: makes sure the subs are registered
            [clojure.string :as str]
            [taoensso.timbre :as log]))

(defn- row
  [col1 col2 col3 col4 col5]
  [:> view {:style (tw "flex flex-row gap-1 h-8")}
   [:> view {:style (tw "flex-5 my-auto")} col1]
   [:> view {:style (tw "flex-1 my-auto")} col2]
   [:> view {:style (tw "flex-2 my-auto")} col3]
   [:> view {:style (tw "flex-1 my-auto")} col4]
   [:> view {:style (tw "flex-1 my-auto")} col5]])

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
    [add-button {:on-click (fn [] (-> navigation (.navigate (i18n/label :t/add-skill))))}]))

(defn- best-attr
  "Get the highest attribute value"
  [attr-map attrs]
  (apply max (map (fn [attr] (get attr-map attr)) (if (seqable? attrs) attrs [attrs]))))

(defn- skill-lvl
  [skill-key]
  (let [skills (some-> (rf/subscribe [:skills/lvls]) deref)
        skill  (skill-key skills)]
    [underlined-input {:val (:lvl skill)
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

(defn- platform-dependent-name-row
  "This row behaves differently between android and ios.
  On android, the on-press event for a text input doesnt work, so we wrap it in a button.
  This causes problems on ios, so we keep the two implementations separate."
  [name on-press]
  (if ios?
    [underlined-input {:val name
                       :style (tw "capitalize")
                       :placeholder-color "#FFF"
                       :on-press on-press
                       :disabled? true}]
    ;; android
    [:> button {:style (tw "flex-1")
                :onPress on-press}
     [underlined-input {:val name
                        :style (tw "capitalize")
                        :placeholder-color "#FFF"
                        :disabled? true}]]))

(defn character-skills-page
  []
  (let [skills     (some-> (rf/subscribe [:skills]) deref)
        navigation (rnn/useNavigation)
        on-press   #(-> navigation (.navigate (i18n/label :t/add-skill-specialization)
                                              #js {:id (key->str (generify-key %))}))]
    [:> view {:style (tw "flex flex-1 flex-col")}
     [:> rn/ScrollView {:style (tw "flex flex-1 flex-col bg-white flex-grow px-2")}

      [header]

      ;; skills
      (map-indexed (fn [i {:keys [k name cost]}]
                     (let [{:keys [diff attr]} (-> k generify-key skill-map)]
                       ^{:key (str "skill-" i)}
                       [row
                        ;; name
                        (if ios?
                          [underlined-input {:val name
                                             :style (tw "capitalize")
                                             :placeholder-color "#FFF"
                                             :on-press #(on-press k)
                                             :disabled? true}]

                          [:> button {:style (tw "flex-1")
                                      :onPress #(on-press k)}
                           [underlined-input {:val name
                                              :style (tw "capitalize")
                                              :placeholder-color "#FFF"
                                              :disabled? true}]])
                        ;; lvl
                        [skill-lvl k]
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
