(ns gurps.pages.character.widgets.events
  (:require [re-frame.core :as rf]))

(def attrs ["strength"
            "dexterity"
            "intelligence"
            "health"
            "hitpoints"
            "will"
            "perception"
            "fatigue"])
(doseq [attr attrs]
  (rf/reg-sub
   (keyword (str "t/attr-" attr))
   (fn [db _]
     (js/console.log (str "t/attr-" attr))
     ((keyword "t" (str "attr-" attr)) db 0))))

(rf/reg-event-db
 :attrs/update
 (fn [db [_ k v]]
   (println "update attr:" k v)
   (assoc db k v)))
