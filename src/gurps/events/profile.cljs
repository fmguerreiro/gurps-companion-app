(ns gurps.events.profile
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]))

(rf/reg-event-fx
 :profile/update
 (fn [{:keys [db]} [_ k v]]
   {:db                        (assoc-in db [:profile k] v)
    :effects.async-storage/set {:k     (keyword :profile k)
                                :value v}}))

(defn- generate-profile-sub [param]
  (rf/reg-sub
   (keyword :profile param)
   (fn [db _]
     (get-in db [:profile param]))))
(doseq [i [:name :player :portrait :point-total :ht :wt :size-modifier :age :appearance]]
  (generate-profile-sub i))
