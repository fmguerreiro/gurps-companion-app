(ns gurps.events
  (:require [re-frame.core :as rf]
            [taoensso.timbre :refer [error]]
            [cljs.spec.alpha :as s]
            [gurps.events.profile]
            [gurps.db :as db :refer [app-db]]))

(defn check-and-throw
  "Throws an exception if `db` doesn't match the Spec `a-spec`."
  [a-spec db]
  (when-not (s/valid? a-spec db)
    (error (ex-info (str "spec check failed: " (s/explain-str a-spec db)) {}))))

(def check-spec-interceptor (rf/after (partial check-and-throw :gurps.db/db)))

;; TODO: inject spec interceptor
;; https://github.com/day8/re-frame/blob/master/examples/todomvc/src/todomvc/events.cljs

(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   app-db))

(defn flatten-map
  ([form separator]
   (into {} (flatten-map form separator nil)))
  ([form separator pre]
   (mapcat (fn [[k v]]
             (let [prefix (if pre (str pre separator (name k)) (name k))]
               (if (and (map? v) (seq v))
                 (flatten-map v separator prefix)
                 [[(keyword prefix) v]])))
           form)))

(rf/reg-event-fx
 :initialize-storage
 [check-spec-interceptor]
 (fn [{:keys [db]} [_]]
   {:db db
    :effects.async-storage/get {:keys (keys (flatten-map db "/"))
                                :cb   #(rf/dispatch [:initialize-storage/set %])}}))

(rf/reg-event-db
 :initialize-storage/set
 [check-spec-interceptor]
 (fn [db [_ res]]
   ;; (info "initialize-storage" res)
   (merge db res)))

(rf/reg-event-fx
 :navigation/set-root-state
 (fn [{:keys [db]} [_ root-state]]
   {:db (assoc-in db [:navigation :root-state] root-state)
    :effects.async-storage/set {:k     :navigation/root-state
                                :value root-state}}))

(comment

  (contains? (into #{} (keys (flatten-map app-db "/"))) :spell-costs)

  (def pre-process #js {:type "state", :data #js {:state #js {:stale false, :type "tab", :key "tab-gTuB1_sKhODGh83aPktB4", :index 1, :routeNames #js ["Skills-Root" "Stats" "Items"], :history #js [#js {:type "route", :key "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S"} #js {:type "route", :key "Stats-PV-3SHFTWsT63FbCt8XIj"}], :routes #js [#js {:name "Skills-Root", :key "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S", :params nil} #js {:name "Stats", :key "Stats-PV-3SHFTWsT63FbCt8XIj", :params nil} #js {:name "Items", :key "Items-c2mc0i77aoybuhCI-LFvj", :params nil}]}}})

  (def post-process {"type" "state", "data" {"state" {"stale" false, "type" "tab", "key" "tab-gTuB1_sKhODGh83aPktB4", "index" 1, "routeNames" ["Skills-Root" "Stats" "Items"], "history" [{"type" "route", "key" "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S"} {"type" "route", "key" "Stats-PV-3SHFTWsT63FbCt8XIj"}], "routes" [{"name" "Skills-Root", "key" "Skills-Root-m0VkiI9Z_bgThxv3ZVO6S", "params" nil} {"name" "Stats", "key" "Stats-PV-3SHFTWsT63FbCt8XIj", "params" nil} {"name" "Items", "key" "Items-c2mc0i77aoybuhCI-LFvj", "params" nil}]}}})

  (equiv-map pre-process (clj->js post-process))

  (-> (clj->js post-process) .-data .-state))
