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
                                       (info "Got storage" (:navigation %)) ;; TODO remove
                                       (rf/dispatch [:initialize-storage/set %]))}}))

(rf/reg-event-db
 :initialize-storage/set
 (fn [db [_ res]]
   (merge db res)))

;; (rf/reg-event-db
;;  :navigation/set-root-state
;;  (fn [db [_ navigation-root-state]]
;;    (assoc-in db [:navigation :root-state] navigation-root-state)))

(rf/reg-event-fx
 :navigation/set-root-state
 (fn [{:keys [db]} [_ root-state]]
   {:db (assoc-in db [:navigation :root-state] root-state)
    :effects.async-storage/set {:k     :navigation/root-state
                                :value root-state}}))

(comment

  (def pre-process #js {:type "state", :data #js {:state #js {:stale false, :type "tab", :key "tab-gTuB1_sKhODGh83aPktB4", :index 1, :routeNames #js ["Skills-Root" "Stats" "Items"], :history #js [#js {:type "route", :key "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S"} #js {:type "route", :key "Stats-PV-3SHFTWsT63FbCt8XIj"}], :routes #js [#js {:name "Skills-Root", :key "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S", :params nil} #js {:name "Stats", :key "Stats-PV-3SHFTWsT63FbCt8XIj", :params nil} #js {:name "Items", :key "Items-c2mc0i77aoybuhCI-LFvj", :params nil}]}}})

  (def post-process {"type" "state", "data" {"state" {"stale" false, "type" "tab", "key" "tab-gTuB1_sKhODGh83aPktB4", "index" 1, "routeNames" ["Skills-Root" "Stats" "Items"], "history" [{"type" "route", "key" "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S"} {"type" "route", "key" "Stats-PV-3SHFTWsT63FbCt8XIj"}], "routes" [{"name" "Skills-Root", "key" "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S", "params" nil} {"name" "Stats", "key" "Stats-PV-3SHFTWsT63FbCt8XIj", "params" nil} {"name" "Items", "key" "Items-c2mc0i77aoybuhCI-LFvj", "params" nil}]}}})

  (equiv-map pre-process (clj->js post-process))

  (-> (clj->js post-process) .-data .-state))
