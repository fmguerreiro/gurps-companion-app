(ns gurps.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
 :initialized?
 (fn  [db _]
   (seq db)))

(rf/reg-sub
 :navigation/root-state
 (fn [db _]
   (get-in db [:navigation :root-state])))
