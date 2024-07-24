(ns gurps.pages.character.widgets.encumbrance-table
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [text view]]
            [gurps.utils.helpers :refer [->int positions]]
            [gurps.utils.i18n :as i18n]))

;; TODO: use gurps.widgets.underlined-row/labelled-underlined-input widget instead
(defn labeled-underlined-row
  [^js {:keys [label value style]}]
  [:> view {:style #js [(tw "flex flex-row gap-0.5 justify-center"), style]}
   [:> text {:style (tw "flex-grow")} label]
   [:> text {:style (tw "underline grow-0 text-center")} value]]) ;; TODO: width should be 3 digits wide

(defn- column
  [label row1 row2 row3 row4 row5]
  [:> view {:style (tw "flex flex-col gap-1")}
   [:> text {:style (tw "uppercase text-center font-bold")} label]
   [labeled-underlined-row row1]
   [labeled-underlined-row row2]
   [labeled-underlined-row row3]
   [labeled-underlined-row row4]
   [labeled-underlined-row row5]])

(rf/reg-sub
 :attributes/emcumbrance-weight-class
 :<- [:items/weight]
 :<- [:attributes/basic-lift]
 (fn [[weight lift]]
   (first (positions #{weight} (sort [weight lift (* 2 lift) (* 3 lift) (* 6 lift) (* 10 lift)])))))

(def highlight-style (tw "bg-green-100"))

(defn encumbrance-column []
  (let [weight-class (some-> (rf/subscribe [:attributes/emcumbrance-weight-class]) deref)
        basic-lift   (some-> (rf/subscribe [:attributes/basic-lift]) deref)
        light-lift   (* 2 basic-lift)
        medium-lift  (* 3 basic-lift)
        heavy-lift   (* 6 basic-lift)
        x-heavy-lift (* 10 basic-lift)]
    [column
     (i18n/label :t/encumbrance)
     {:label (i18n/label :t/encumbrance-none) :value basic-lift :style (when (= 0 weight-class) highlight-style)}
     {:label (i18n/label :t/encumbrance-light) :value light-lift :style (when (= 1 weight-class) highlight-style)}
     {:label (i18n/label :t/encumbrance-medium) :value medium-lift :style (when (= 2 weight-class) highlight-style)}
     {:label (i18n/label :t/encumbrance-heavy) :value heavy-lift :style (when (= 3 weight-class) highlight-style)}
     {:label (i18n/label :t/encumbrance-x-heavy) :value x-heavy-lift :style (when (>= weight-class 4) highlight-style)}]))

(rf/reg-sub
 :attributes/basic-lift
 :<- [:attributes/str]
 (fn [str]
   (js/Math.floor (/ (* str str) 5))))

(defn move-column []
  (let [weight-class (some-> (rf/subscribe [:attributes/emcumbrance-weight-class]) deref)
        basic-move  (some-> (rf/subscribe [:attributes/basic-move]) deref)
        light-move  (- basic-move 1)
        medium-move (- basic-move 2)
        heavy-move  (- basic-move 3)
        x-heavy-move (- basic-move 4)]
    [column
     (i18n/label :t/move)
     {:label (i18n/label :t/move-encumbrance-none) :value basic-move :style (when (= 0 weight-class) highlight-style)}
     {:label (i18n/label :t/move-encumbrance-light) :value light-move :style (when (= 1 weight-class) highlight-style)}
     {:label (i18n/label :t/move-encumbrance-medium) :value medium-move :style (when (= 2 weight-class) highlight-style)}
     {:label (i18n/label :t/move-encumbrance-heavy) :value heavy-move :style (when (= 3 weight-class) highlight-style)}
     {:label (i18n/label :t/move-encumbrance-x-heavy) :value x-heavy-move :style (when (>= weight-class 4) highlight-style)}]))

(rf/reg-sub
 :attributes/basic-move
 :<- [:attributes/ht]
 :<- [:attributes/dex]
 (fn [[ht dx]]
   (js/Math.floor (/ (+ ht dx) 4))))

(defn dodge-column []
  (let [weight-class (some-> (rf/subscribe [:attributes/emcumbrance-weight-class]) deref)
        basic-dodge  (some-> (rf/subscribe [:attributes/basic-dodge]) deref)
        light-dodge  (- basic-dodge 1)
        medium-dodge (- basic-dodge 2)
        heavy-dodge  (- basic-dodge 3)
        x-heavy-dodge (- basic-dodge 4)]
    [column (i18n/label :t/dodge)
     {:label (i18n/label :t/dodge-encumbrance-none) :value basic-dodge :style (when (= 0 weight-class) highlight-style)}
     {:label (i18n/label :t/dodge-encumbrance-light) :value light-dodge :style (when (= 1 weight-class) highlight-style)}
     {:label (i18n/label :t/dodge-encumbrance-medium) :value medium-dodge :style (when (= 2 weight-class) highlight-style)}
     {:label (i18n/label :t/dodge-encumbrance-heavy) :value heavy-dodge :style (when (= 3 weight-class) highlight-style)}
     {:label (i18n/label :t/dodge-encumbrance-x-heavy) :value x-heavy-dodge :style (when (>= weight-class 4) highlight-style)}]))

(rf/reg-sub
 :attributes/basic-dodge
 :<- [:attributes/basic-move]
 (fn [bm]
   (+ 3 bm)))

(defn encumbrance-table []
  [:> view {:style (tw "flex flex-row w-full px-2 py-1 gap-2 border-2 border-black justify-between")}
   [encumbrance-column]
   [move-column]
   [dodge-column]])

(rf/reg-sub
 :items/weight
 :<- [:items/possessions]
 :<- [:items/melee-weapons]
 :<- [:items/ranged-weapons]
 (fn [[possessions melee-weapons ranged-weapons]]
   ;; NOTE: melee weapons sometimes have a :var weight, so we need to convert it to an integer
   (let [melee-weapons' (map (fn [item] (assoc item :weight (->int (:weight item)))) melee-weapons)]
     (reduce (fn [acc item] (+ acc (:weight item)))
             0
             (concat possessions melee-weapons' ranged-weapons)))))
