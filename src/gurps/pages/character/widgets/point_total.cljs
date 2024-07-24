(ns gurps.pages.character.widgets.point-total
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.utils.helpers :refer [->int]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn point-total-field
  []
  [summary-field {:key :point-total,
                  :text-align "right",
                  :editable? false,
                  :on-change-text ->int,
                  :input-mode "numeric",
                  :max-length 4,
                  :input-style (tw "w-16")}])

(rf/reg-sub
 :profile/point-total
 (fn [db]
   (let [costs (+ (->> db :attribute-costs vals (reduce +))
                  (->> db :skills (map :cost) (reduce +))
                  (->> db :spell-costs vals (map :cost) (reduce +))
                  (->> db :advantages vals (map :cost) (reduce +))
                  (->> db :disadvantages vals (map :cost) (reduce +))
                  (->> db :languages (filter #(not (:native? %))) (map :cost) (reduce +)))]
     (or costs 0))))

(defn unspent-points-field
  [{:keys [style]}]
  [summary-field {:key :unspent-points,
                  :on-change-text ->int,
                  :style style,
                  :input-style (tw "w-16 bg-slate-100"),
                  :input-mode "numeric",
                  :max-length 4,
                  :text-align "right"}])

(rf/reg-sub
 :profile/unspent-points
 (fn [db]
   (get-in db [:profile :unspent-points] 0)))

(rf/reg-event-fx
 :profile.update/unspent-points
 (fn [{:keys [db]} [_ diff]]
   (let [new-db (update-in db [:profile :unspent-points] #(- % diff))]
     {:db new-db
      :effects.async-storage/set {:k     :profile/unspent-points
                                  :value (get-in new-db [:profile :unspent-points])}})))
