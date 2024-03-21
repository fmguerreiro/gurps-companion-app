(ns gurps.pages.character.widgets.basics
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.basic :refer [basic]]
            [gurps.pages.character.utils.damage-table :refer [damage-table]]
            [gurps.utils.helpers :refer [default-to]]
            [re-frame.core :as rf]))

;; TODO: If you have less than 1/3 of your HP remaining, you reel from your wounds. Halve your Move and Dodge (round up).
;; make it show RED in that case
(defn- basic-speed [ht dx]
  (/ (+ ht dx) 4))

(defn- basic-move [speed]
  (js/Math.floor speed))

(defn- basic-lift [str]
  (/ (* str str) 5))

(defn basics
  []
  (let [ht  (js/parseInt (default-to @(rf/subscribe [:t/attr-health]) 10)) ;; TODO: need to re-write this for multiplayer
        dx  (js/parseInt (default-to @(rf/subscribe [:t/attr-dexterity]) 10))
        str (js/parseInt (default-to @(rf/subscribe [:t/attr-strength]) 10))
        speed (basic-speed ht dx)
        move (basic-move speed)
        lift (basic-lift str)
        swing (get-in damage-table [str :sw])
        thrust (get-in damage-table [str :thr])]
    [:> view {:className "flex flex-col gap-2 w-full"}

     [:> view {:className "flex flex-row gap-2 items-stretch"}
      [basic {:label :t/basic-lift :value lift}]
      [basic {:label :t/damage-thrust :value thrust}]
      [basic {:label :t/damage-swing :value swing}]]

     [:> view {:className "flex flex-row gap-2"}
      [basic {:label :t/basic-speed :value speed :upgradable? true}]
      [basic {:label :t/basic-move :value move :upgradable? true}]]]))

(def attrs ["basic-move-cost"
            "basic-speed-cost"])
(doseq [attr attrs]
  (rf/reg-sub
   (keyword "t" attr)
   (fn [db _]
     ((keyword "t" attr) db 0))))