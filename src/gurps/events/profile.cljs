(ns gurps.events.profile
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]))

(rf/reg-event-fx
 :profile/update
 (fn [{:keys [db]} [_ k v]]
   {:db                        (assoc-in db [:profile k] v)
    :effects.async-storage/set {:k     (keyword :profile k)
                                :value v}}))

(doseq [idx [:name :player :portrait :point-total :ht :wt :size-modifier :age :appearance :status :reputation :notes]]
  (rf/reg-sub
   (keyword :profile idx)
   (fn [db _]
     (get-in db [:profile idx]))))
