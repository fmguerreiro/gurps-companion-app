(ns gurps.pages.character.widgets.point-total
  (:require [re-frame.core :as rf]
            [gurps.utils.helpers :refer [->int]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn point-total-field
  []
  [summary-field {:key :point-total, :editable? false, :on-change-text ->int}])

(rf/reg-sub
 :profile/point-total
 (fn [db]
   (let [costs (+ (->> db :attribute-costs vals (reduce +))
                  (->> db :skills (map :cost) (reduce +))
                  (->> db :languages (filter #(not (:native? %))) (map :cost) (reduce +)))]
     (or costs 0))))

(defn unspent-points-field
  [{:keys [style input-style text-align]}]
  [summary-field {:key :unspent-points, :on-change-text ->int, :style style, :input-style input-style, :text-align text-align}])

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
