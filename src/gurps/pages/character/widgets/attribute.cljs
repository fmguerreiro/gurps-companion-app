(ns gurps.pages.character.widgets.attribute
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [react-native.async-storage :as async-storage]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn- on-change-text
  [label cost]
  (let [callback #(rf/dispatch [:attrs/update label cost])]
    (async-storage/set-item! label cost callback)))

(def cost-per-lvl
  {;; primary
   :t/attr-strength     10
   :t/attr-dexterity    20
   :t/attr-intelligence 20
   :t/attr-health       10
   ;; secondary
   :t/attr-hitpoints    2
   :t/attr-will         5
   :t/attr-perception   5
   :t/attr-fatigue      3})

(defn- calc-value [cost label]
  (js/Math.floor (+ 10 (/ cost (label cost-per-lvl)))))

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
  (r/with-let [cost (rf/subscribe [label])]
    [:> view {:className "flex flex-row gap-0 bg-gray-200"}
     (box
      [:> text {:className "text-2xl font-bold"} (i18n/label label)])

     (box-border
      [:> text {:className "text-2xl"} (calc-value @cost label)])

     (if (not (nil? current))
       [:> view
        [:> text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
         (i18n/label :t/current)]
        (box-border [:> text {:className "text-2xl"} current])]
       (when add-current-space?
         (box [:<>])))

     (box [:> view {:className "flex flex-row bg-blue-500"}
           [:> text {:className "text-2xl font-bold"} "["]
           [:> input {:className "text-2xl bg-red-500 leading-6" ;; TODO: align this crap
                      :maxLength 2
                      :onChangeText (debounce/debounce #(on-change-text label %) 500)}
            @cost]
           [:> text {:className "text-2xl font-bold"} "]"]])]))

;; TODO: apply these somewhere
(defn- basic-speed [ht dx]
  (/ (+ ht dx) 4))

(defn- basic-move [speed]
  (js/Math.floor speed))
