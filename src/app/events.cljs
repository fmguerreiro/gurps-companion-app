(ns app.events
  (:require [re-frame.core :as rf]
            [taoensso.timbre :refer [error]]
            [cljs.spec.alpha :as s]
            [app.db :as db :refer [app-db]]))

(defn check-and-throw
  "Throws an exception if `db` doesn't match the Spec `a-spec`."
  [a-spec db]
  (when-not (s/valid? a-spec db)
    (error (ex-info (str "spec check failed: " (s/explain-str a-spec db)) {}))))

(def check-spec-interceptor (rf/after (partial check-and-throw :app.db/db)))

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
   (merge db res)))

(rf/reg-event-fx
 :navigation/set-root-state
 (fn [{:keys [db]} [_ root-state]]
   {:db (assoc-in db [:navigation :root-state] root-state)
    :effects.async-storage/set {:k     :navigation/root-state
                                :value root-state}}))

(rf/reg-event-db
 :counter/increment
 (fn [db [_]]
   (update db :counter inc)))
