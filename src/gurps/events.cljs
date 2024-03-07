(ns gurps.events
  (:require
   [gurps.events.profile]
   [react-native.async-storage :as async-storage]
   [re-frame.core :as rf]
   [gurps.db :as db :refer [app-db]]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(rf/reg-event-fx
 :initialize-storage
 (fn [{:keys [db]} [_]]
   {:db db
    :effects.async-storage/get {:keys [:profile/name :profile/player] ;; TODO: add more keys
                                :cb #(rf/dispatch [:initialize-storage/set %])}}))

(rf/reg-event-db
 :initialize-storage/set
 (fn [db [_ res]]
   (merge db res)))

(rf/reg-event-db
 :inc-counter
 (fn [db [_ _]]
   (update db :counter inc)))

(rf/reg-event-db
 :navigation/set-root-state
 (fn [db [_ navigation-root-state]]
   (assoc-in db [:navigation :root-state] navigation-root-state)))
