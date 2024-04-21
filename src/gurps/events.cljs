(ns gurps.events
  (:require [re-frame.core :as rf]
            [taoensso.timbre :refer [info]]
            [gurps.events.profile]
            [react-native.async-storage :as async-storage]
            [gurps.db :as db :refer [app-db]]))

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(defn- get-flattened-db-keys
  "Get all keys in the db, including nested keys
   e.g. (:profile :attributes :attribute-costs :skill-costs) => (:profile/name :profile/age :attributes/str ...)"
  [db]
  (let [keys (keys db)]
    (mapcat (fn [k]
              (if (map? (db k))
                (map #(keyword k (symbol %)) (get-flattened-db-keys (db k)))
                [k]))
            keys)))

(rf/reg-event-fx
 :initialize-storage
 (fn [{:keys [db]} [_]]
   ;; (info "Initializing storage" (keys db))
   {:db db
    :effects.async-storage/get {:keys (get-flattened-db-keys db)
                                :cb #(do
                                       ;; (info "Got storage" (:attribute-costs %)) ;; TODO remove
                                       (rf/dispatch [:initialize-storage/set %]))}}))

(rf/reg-event-db
 :initialize-storage/set
 (fn [db [_ res]]
   (merge db res)))

(rf/reg-event-db
 :navigation/set-root-state
 (fn [db [_ navigation-root-state]]
   (assoc-in db [:navigation :root-state] navigation-root-state)))
