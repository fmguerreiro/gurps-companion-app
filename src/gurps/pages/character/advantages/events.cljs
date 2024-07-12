(ns gurps.pages.character.advantages.events
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :disadvantages
 (fn [db]
   (get-in db [:disadvantages] {})))

(rf/reg-event-fx
 :disadvantages/update
 (fn [{db :db} [_ k id v]]
   (let [new-db (assoc-in db [:disadvantages id k] v)]
     (merge {:db new-db
             :effects.async-storage/set {:k     :disadvantages
                                         :value (get-in new-db [:disadvantages])}}
            (when (= :cost k)
              (let [cost' (- v (get-in db [:disadvantages id k]))]
                {:fx [[:dispatch [:profile.update/unspent-points cost']]]}))))))

(rf/reg-sub
 :disadvantage-list/expanded
 (fn [db]
   (get-in db [:disadvantage-list] {})))

(rf/reg-event-db
 :disadvantage-list/toggle-section
 (fn [db [_ advantage]]
   (update-in db [:disadvantage-list advantage :expanded?] not)))

(rf/reg-sub
 :advantages
 (fn [db]
   (get-in db [:advantages] {})))

(rf/reg-event-fx
 :advantages/update
 (fn [{db :db} [_ k id v]]
   (let [new-db (assoc-in db [:advantages id k] v)]
     (merge {:db new-db
             :effects.async-storage/set {:k     :advantages
                                         :value (get-in new-db [:advantages])}}
            (when (= :cost k)
              (let [cost' (- v (get-in db [:advantages id k]))]
                {:fx [[:dispatch [:profile.update/unspent-points cost']]]}))))))

(rf/reg-sub
 :advantage-list/expanded
 (fn [db]
   (get-in db [:advantage-list] {})))

(rf/reg-event-db
 :advantage-list/toggle-section
 (fn [db [_ advantage]]
   (update-in db [:advantage-list advantage :expanded?] not)))

(rf/reg-event-fx
 :advantages/add
 (fn [{:keys [db]} [_ id {cost :cost}]]
   (let [cost'  (cond (coll? cost) (first cost), (= :variable cost) 0, :else cost)
         new-db (update-in db [:advantages id] (fnil #(conj % {:cost cost' :lvl 1}) {}))]
     {:db new-db
      :fx [[:dispatch [:profile.update/unspent-points cost']]]
      :effects.async-storage/set {:k     :advantages
                                  :value (get-in new-db [:advantages])}})))

(rf/reg-event-fx
 :disadvantages/add
 (fn [{:keys [db]} [_ id {cost :cost}]]
   (let [cost'  (cond (coll? cost) (first cost), (= :variable cost) 0, :else cost)
         new-db (update-in db [:disadvantages id] (fnil #(conj % {:cost cost' :lvl 1}) {}))]
     {:db new-db
      :fx [[:dispatch [:profile.update/unspent-points cost']]]
      :effects.async-storage/set {:k     :disadvantages
                                  :value (get-in new-db [:disadvantages])}})))
