(ns gurps.events.profile
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :profile/update
 (fn [db [_ k v]]
   (info "update profile" k v)
   (assoc-in db [:profile k] v)))

(defn- generate-profile-sub [param]
  (rf/reg-sub
   (keyword :profile param)
   (fn [db _]
     (get-in db [:profile param]))))
(doseq [i [:name :player :point-total :ht :wt :size-modifier :unspent-points :age :appearance]]
  (generate-profile-sub i))
