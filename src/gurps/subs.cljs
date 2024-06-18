(ns gurps.subs
  (:require [cljs-bean.core :refer [->js]]
            [re-frame.core :as rf]))

(rf/reg-sub
 :initialized?
 (fn  [db _]
   (seq db)))

(rf/reg-sub
 :navigation/root-state
 (fn [db _]
   (->js (get-in db [:navigation :root-state]))))
