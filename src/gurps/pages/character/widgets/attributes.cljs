(ns gurps.pages.character.widgets.attributes
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.reified-attribute :refer [reified-attribute]]
            [gurps.pages.character.widgets.reified-secondary-attribute :refer [reified-secondary-attribute]]
            [re-frame.core :as rf]))

(defn attributes []
  [:> view {:className "flex flex-row gap-0"}

   [:> view {:className "flex flex-col"}
    [reified-attribute {:attr "strength"}]
    [reified-attribute {:attr "dexterity"}]
    [reified-attribute {:attr "intelligence"}]
    [reified-attribute {:attr "health"}]]

   [:> view {:className "flex flex-col"}
    [reified-secondary-attribute {:attr "hitpoints" :based-on "strength" :has-current? true}]
    [reified-secondary-attribute {:attr "will" :based-on "intelligence"}]
    [reified-secondary-attribute {:attr "perception" :based-on "intelligence"}]
    [reified-secondary-attribute {:attr "fatigue" :based-on "health" :has-current? true}]]])

(def attrs ["strength"
            "strength-cost"
            "dexterity"
            "dexterity-cost"
            "intelligence"
            "intelligence-cost"
            "health"
            "health-cost"
            "hitpoints-cost"
            "hitpoints-current"
            "will-cost"
            "perception-cost"
            "fatigue-cost"
            "fatigue-current"])
(doseq [attr attrs]
  (rf/reg-sub
   (keyword (str "t/attr-" attr))
   (fn [db _]
     ((keyword "t" (str "attr-" attr)) db 0))))

(rf/reg-event-db
 :attrs/update
 (fn [db [_ k v]]
   (println "update attr:" k v)
   (assoc db k v)))
