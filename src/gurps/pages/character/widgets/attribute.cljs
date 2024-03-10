(ns gurps.pages.character.widgets.attribute
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [react-native.async-storage :as async-storage]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn- on-change-text
  [label value]
  (let [callback #(rf/dispatch [:attrs/update label value])]
    (async-storage/set-item! label value callback)))

;; TODO: apply modifier functions
(def value-per-lvl
  {;; primary
   :t/attr-strength     {:incr 10 :modifier (fn [size]
                                              (js/Math.max -0.8 (* -0.1 size)))}
   :t/attr-dexterity    {:incr 20}
   :t/attr-intelligence {:incr 20}
   :t/attr-health       {:incr 10}
   ;; secondary
   :t/attr-hitpoints    {:incr 2}
   :t/attr-will         {:incr 5}
   :t/attr-perception   {:incr 5}
   :t/attr-fatigue      {:incr 3}})

(defn- calc-cost [label value]
  (let [incr (:incr (label value-per-lvl))]
    (* incr (- (if (nil? value) 10 value) 10))))

(defn- box
  [children]
  [:> view {:className "h-14 w-14 items-center justify-center flex-row"} children])

(defn- box-border
  [children]
  [:> view {:className "box-border h-14 w-14 align-middle border-2 items-center justify-center"}
   children])

(defn attribute
  [^js {:keys [label current add-current-space?]
        :or   {add-current-space? true}}]
  (r/with-let [value (rf/subscribe [label])]
    [:> view {:className "flex flex-row gap-0"}
     (box
      [:> text {:className "text-2xl font-bold"} (i18n/label label)])

     (box-border
      [:> input {:className "text-2xl bg-slate-100"
                 :maxLength 3
                 :keyboardType "numeric"
                 :onChangeText (debounce/debounce #(on-change-text label %) 500)} @value])

     (if (not (nil? current))
       [:> view
        [:> text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
         (i18n/label :t/current)]
        (box-border [:> text {:className "text-2xl"} current])]
       (when add-current-space?
         (box [:<>])))

     (box [:> view {:className "flex flex-row bg-blue-500"}
           [:> text {:className "text-2xl font-bold"} "["]
           [:> text {:className "text-2xl font-bold"} (calc-cost label @value)]

           ; [:> input {:className "bg-green-500 leading-6" ;; TODO: align this crap
           ;            :maxLength 3
           ;            :onChangeText (debounce/debounce #(on-change-text label %) 500)}
           ;  @value]
           [:> text {:className "text-2xl font-bold"} "]"]])]))
