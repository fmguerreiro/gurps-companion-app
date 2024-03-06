(ns gurps.events.profile
  (:require-macros
   [gurps.events.profile :as macro])
  (:require
   [re-frame.core :as rf]
   [gurps.db :as db :refer [app-db]]))

(rf/reg-event-db
 :profile/update
 (fn [db [_ k v]]
   (println "update profile:" k v)
   (assoc-in db [:profile k] v)))

(defn- generate-profile-sub [param]
  (rf/reg-sub
   (keyword "profile" param)
   :<- [(keyword "profile")]
   (fn [db _]
     (js/console.log "profile" param (get-in db [:profile param]))
     ((keyword param) db))))
(doseq [i ["name" "player" "point-total" "ht" "wt" "size-modifier" "unspent-points" "age" "appearance"]]
  (generate-profile-sub i))
