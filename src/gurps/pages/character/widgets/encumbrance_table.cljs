(ns gurps.pages.character.widgets.encumbrance-table
  (:require [re-frame.core :as rf]
            [gurps.widgets.base :refer [text view]]
            [gurps.utils.helpers :refer [default-to]]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]))

(defn labeled-underlined-row
  [^js {:keys [label value]}]
  [:> view {:style (tw "flex flex-row gap-1 justify-center ml-0 mt-0")}
   [:> text {:style (tw "flex-grow")} label]
   [:> text {:style (tw "underline grow-0 w-7 text-center")} value]]) ;; TODO: width should be 3 digits wide

(defn encumbrance-column []
  (let [basic-lift (default-to @(rf/subscribe [:character/basic-lift]) 0)
        light-lift (* 2 basic-lift)
        medium-lift (* 3 basic-lift)
        heavy-lift (* 6 basic-lift)
        extra-heavy-lift (* 10 basic-lift)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/encumbrance)]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-none) :value basic-lift}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-light) :value light-lift}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-medium) :value medium-lift}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-heavy) :value heavy-lift}]
     [labeled-underlined-row {:label (i18n/label :t/encumbrance-extra-heavy) :value extra-heavy-lift}]]))

(rf/reg-sub
 :character/basic-lift
 :<- [:attributes/str]
 (fn [str]
   (js/Math.floor (/ (* str str) 5)))) ;; TODO: use a helper calc-basic-lift function instead

(defn move-column []
  (let [basic-move (default-to @(rf/subscribe [:character/basic-move]) 0)
        light-move (- basic-move 1)
        medium-move (- basic-move 2)
        heavy-move (- basic-move 3)
        extra-heavy-move (- basic-move 4)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/move)]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-none) :value basic-move}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-light) :value light-move}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-medium) :value medium-move}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-heavy) :value heavy-move}]
     [labeled-underlined-row {:label (i18n/label :t/move-encumbrance-extra-heavy) :value extra-heavy-move}]]))

(rf/reg-sub
 :character/basic-move
 :<- [:attributes/ht]
 :<- [:attributes/dex]
 (fn [[ht dx]]
   (js/Math.floor (/ (+ ht dx) 4)))) ;; TODO: use a helper calc-basic-move function instead

(defn dodge-column []
  (let [basic-dodge @(rf/subscribe [:character/basic-dodge])
        light-dodge (- basic-dodge 1)
        medium-dodge (- basic-dodge 2)
        heavy-dodge (- basic-dodge 3)
        extra-heavy-dodge (- basic-dodge 4)]
    [:> view {:style (tw "flex flex-col gap-1 ml-0 mt-0")}
     [:> text {:style (tw "uppercase text-center font-bold")} (i18n/label :t/dodge)]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-none) :value basic-dodge}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-light) :value light-dodge}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-medium) :value medium-dodge}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-heavy) :value heavy-dodge}]
     [labeled-underlined-row {:label (i18n/label :t/dodge-encumbrance-extra-heavy) :value extra-heavy-dodge}]]))

(rf/reg-sub
 :character/basic-dodge
 :<- [:character/basic-move]
 (fn [bm]
   (+ 3 bm))) ;; TODO: use a helper calc-basic-dodge function instead

(defn encumbrance-table []
  [:> view {:style (tw "flex flex-row gap-2 border-2 border-black p-1")}
   [encumbrance-column]
   [move-column]
   [dodge-column]])
