(ns gurps.pages.character.widgets.encumbrance-table
  (:require [re-frame.core :as rf]
            [gurps.widgets.base :refer [text view]]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [taoensso.timbre :as log]))

;; TODO: use gurps.widgets.underlined-row/labelled-underlined-row widget instead
(defn labeled-underlined-row
  [^js {:keys [label value style]}]
  [:> view {:style #js [(tw "flex flex-row gap-1 justify-center ml-0 mt-0"), style]}
   [:> text {:style (tw "flex-grow")} label]
   [:> text {:style (tw "underline grow-0 w-7 text-center")} value]]) ;; TODO: width should be 3 digits wide

(defn- highlight-style
  [weight a b]
  (tw (if (<= a weight b) "bg-green-200" "")))

(defn encumbrance-column []
  (let [weight      (some-> (rf/subscribe [:items/weight]) deref)
        basic-lift  (some-> (rf/subscribe [:attributes/basic-lift]) deref)
        light-lift  (* 2 basic-lift)
        medium-lift (* 3 basic-lift)
        heavy-lift  (* 6 basic-lift)
        x-heavy-lift (* 10 basic-lift)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/encumbrance)]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-none) :value basic-lift :style (highlight-style weight 0 basic-lift)}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-light) :value light-lift :style (highlight-style weight basic-lift light-lift)}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-medium) :value medium-lift :style (highlight-style weight light-lift medium-lift)}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-heavy) :value heavy-lift :style (highlight-style weight medium-lift heavy-lift)}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-x-heavy) :value x-heavy-lift :style (highlight-style weight heavy-lift x-heavy-lift)}]]))

(rf/reg-sub
 :attributes/basic-lift
 :<- [:attributes/str]
 (fn [str]
   (js/Math.floor (/ (* str str) 5)))) ;; TODO: use a helper calc-basic-lift function instead

(defn move-column []
  (let [weight      (some-> (rf/subscribe [:items/weight]) deref)
        basic-move  (some-> (rf/subscribe [:attributes/basic-move]) deref)
        light-move  (- basic-move 1)
        medium-move (- basic-move 2)
        heavy-move  (- basic-move 3)
        x-heavy-move (- basic-move 4)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/move)]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-none) :value basic-move :style (highlight-style weight 0 basic-move)}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-light) :value light-move :style (highlight-style weight basic-move light-move)}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-medium) :value medium-move :style (highlight-style weight light-move medium-move)}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-heavy) :value heavy-move :style (highlight-style weight medium-move heavy-move)}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-x-heavy) :value x-heavy-move :style (highlight-style weight heavy-move x-heavy-move)}]]))

(rf/reg-sub
 :attributes/basic-move
 :<- [:attributes/ht]
 :<- [:attributes/dex]
 (fn [[ht dx]]
   (js/Math.floor (/ (+ ht dx) 4)))) ;; TODO: use a helper calc-basic-move function instead

(defn dodge-column []
  (let [weight       (some-> (rf/subscribe [:items/weight]) deref)
        basic-dodge  (some-> (rf/subscribe [:attributes/basic-dodge]) deref)
        light-dodge  (- basic-dodge 1)
        medium-dodge (- basic-dodge 2)
        heavy-dodge  (- basic-dodge 3)
        x-heavy-dodge (- basic-dodge 4)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/dodge)]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-none) :value basic-dodge :style (highlight-style weight 0 basic-dodge)}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-light) :value light-dodge :style (highlight-style weight basic-dodge light-dodge)}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-medium) :value medium-dodge :style (highlight-style weight light-dodge medium-dodge)}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-heavy) :value heavy-dodge :style (highlight-style weight medium-dodge heavy-dodge)}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-x-heavy) :value x-heavy-dodge :style (highlight-style weight heavy-dodge x-heavy-dodge)}]]))

(rf/reg-sub
 :attributes/basic-dodge
 :<- [:attributes/basic-move]
 (fn [bm]
   (+ 3 bm))) ;; TODO: use a helper calc-basic-dodge function instead

(defn encumbrance-table []
  [:> view {:style (tw "flex flex-row gap-2 border-2 border-black p-1")}
   [encumbrance-column]
   [move-column]
   [dodge-column]])

(rf/reg-sub
 :items/weight
 :<- [:items/possessions] ;; TODO: add melee + ranged weapons
 (fn [possessions]
   (reduce (fn [acc item] (+ acc (:weight item))) 0 possessions)))
