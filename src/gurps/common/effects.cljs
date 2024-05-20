(ns gurps.common.effects
  (:require [re-frame.core :as rf]
            [taoensso.timbre :as log]))

;; TODO: not needed, remove. 1.10 has :fx which does this
;; Chains effects together
;; Example: (rf/reg-event-fx
;;           :event
;;           (fn [{:keys [db]} _]
;;            {:db db
;;             :fx [[:fx1] [:fx2]]}))
(rf/reg-fx
 :chain
 (fn [fxs]
   (log/info "Effects: " fxs)
   (doseq [fx fxs]
     (log/info "Dispatching" fx)
     (rf/dispatch fx))))
