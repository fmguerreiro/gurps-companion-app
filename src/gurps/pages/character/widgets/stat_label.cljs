(ns gurps.pages.character.widgets.stat-label
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text]]))

(defn- box
  [children]
  [:> view {:className "h-14 w-14 items-center justify-center flex-row"} children])

(defn- box-border
  [children]
  [:> view {:className "box-border h-14 w-14 align-middle border-2 items-center justify-center"}
   children])

(defn stat-label
  [^js {:keys [label value current cost add-current-space?]
        :or   {cost 0, add-current-space? true}}]
  [:> view {:className "flex flex-row gap-0 bg-gray-200"}
   (box
    [:> text {:className "text-2xl font-bold"} label])

   (box-border
    [:> text {:className "text-2xl"} value])

   (if (not (nil? current))
     [:> view
      [:> text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
       (i18n/label :t/current)]
      (box-border [:> text {:className "text-2xl"} current])]
     (when add-current-space?
       (box [:<>])))

   (box [:> view {:className "flex flex-row"}
         [:> text {:className "text-2xl font-bold"} "["]
         [:> text {:className "text-2xl"} cost]
         [:> text {:className "text-2xl font-bold"} "]"]])])
