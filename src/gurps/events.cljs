(ns gurps.events
  (:require
   [gurps.events.profile]
   [react-native.async-storage :as async-storage]
   [re-frame.core :as rf]
   [taoensso.timbre :refer [info]]
   [gurps.db :as db :refer [app-db]]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(rf/reg-event-fx
 :initialize-storage
 (fn [{:keys [db]} [_]]
   (info "Initializing storage" (keys db))
   {:db db
    :effects.async-storage/get {:keys [(keys db)]
                                :cb #(rf/dispatch [:initialize-storage/set %])}}))

(rf/reg-event-db
 :initialize-storage/set
 (fn [db [_ res]]
   (merge db res)))

(rf/reg-event-db
 :navigation/set-root-state
 (fn [db [_ navigation-root-state]]
   (assoc-in db [:navigation :root-state] navigation-root-state)))
