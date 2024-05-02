(ns gurps.pages.character.widgets.basics
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.basic :refer [basic]]
            [gurps.pages.character.utils.damage-table :refer [damage-table]]
            [gurps.utils.helpers :refer [default-to]]
            ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]))

;; TODO: If you have less than 1/3 of your HP remaining, you reel from your wounds. Halve your Move and Dodge (round up).
;; make it show RED in that case
(defn- basic-speed [ht dx]
  (/ (+ ht dx) 4))

(defn- basic-move [speed]
  (js/Math.floor speed))

(defn- basic-lift [str]
  (/ (* str str) 5))

;; TODO: push subscriptions down to individual components
(defn basics
  []
  (let [ht  (js/parseInt (or (some-> (rf/subscribe [:attributes/ht]) deref) 10))
        dx  (js/parseInt (or (some-> (rf/subscribe [:attributes/dex]) deref) 10))
        str (js/parseInt (or (some-> (rf/subscribe [:attributes/str]) deref) 10))
        speed (basic-speed ht dx)
        move (basic-move speed)
        lift (basic-lift str)
        swing (get-in damage-table [str :sw])
        thrust (get-in damage-table [str :thr])]
    [:> view {:style (tw "flex flex-col gap-2 w-full")}

     [:> view {:style (tw "flex flex-row gap-2 items-stretch")}
      [basic {:label :t/basic-lift :value lift}]
      [basic {:label :t/damage-thrust :value thrust}]
      [basic {:label :t/damage-swing :value swing}]]

     [:> view {:style (tw "flex flex-row gap-2")}
      [basic {:label :t/basic-speed :value speed :upgradable? true}]
      [basic {:label :t/basic-move :value move :upgradable? true}]]]))

(def attrs [:basic-move
            :basic-speed])
(doseq [attr attrs]
  (rf/reg-sub
   (keyword :attribute-costs attr)
   (fn [db _]
     (get-in db [:attribute-costs attr] 0))))
