(ns gurps.pages.character.widgets.basics
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.basic :refer [basic]]
            [gurps.pages.character.utils.damage-table :refer [damage-table]]
            [gurps.utils.i18n :as i18n]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(def increases {:speed {:cost 5 :incr 0.25}
                :move  {:cost 5 :incr 1}}) ;; TODO: encumbrance

;; TODO: If you have less than 1/3 of your HP remaining, you reel from your wounds. Halve your Move and Dodge (round up).
(defn- basic-speed [ht dx]
  (/ (+ ht dx) 4))

(defn- basic-move [speed]
  (js/Math.floor speed))

(defn- basic-lift [str]
  (/ (* str str) 5))

(defn basics
  []
  (r/with-let [ht  (rf/subscribe [:t/attr-health]) ;; TODO: need to re-write this for multiplayer
               dx  (rf/subscribe [:t/attr-dexterity])
               str (rf/subscribe [:t/attr-strength])
               speed (basic-speed @ht @dx)
               move (basic-move speed)
               lift (basic-lift @str)
               swing (get-in damage-table [@str :sw])
               thrust (get-in damage-table [@str :thr])]
    (js/console.log "swing" @str (get damage-table @str))
    [:> view {:className "flex flex-col gap-2 w-full"}

     [:> view {:className "flex flex-row gap-2 items-stretch"}
      [basic {:label (i18n/label :t/basic-lift) :value lift}]
      [basic {:label (i18n/label :t/damage-thrust) :value thrust}]
      [basic {:label (i18n/label :t/damage-swing) :value swing}]]

     [:> view {:className "flex flex-row gap-2 items-stretch"}
      [basic {:label (i18n/label :t/basic-speed) :value speed :upgradable? true}]
      [basic {:label (i18n/label :t/basic-move)  :value move  :upgradable? true}]]

     ]))
