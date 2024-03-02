(ns gurps.pages.character.widgets.stat-label
  (:require [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [styled-view styled-text]]))

(defn- box
  [children]
  [:> styled-view {:className "h-14 w-14 items-center justify-center flex-row"} children])

(defn- box-border
  [children]
  [:> styled-view {:className "box-border h-14 w-14 align-middle border-2 items-center justify-center"}
   children])

(defn stat-label
  [^js {:keys [label value current cost add-current-space?]
        :or   {cost 0, add-current-space? true}}]
  [:> styled-view {:className "flex flex-row gap-0 bg-gray-200"}
   (box
    [:> styled-text {:className "text-2xl font-bold"} label])

   (box-border
    [:> styled-text {:className "text-2xl"} value])

   (if (not (nil? current))
     [:> styled-view
      [:> styled-text {:className "text-xs text-center w-14 capitalize font-bold absolute -top-4"}
       (i18n/label :t/current)]
      (box-border [:> styled-text {:className "text-2xl"} current])]
     (when add-current-space?
       (box [:<>])))

   (box [:> styled-view {:className "flex flex-row"}
         [:> styled-text {:className "text-2xl font-bold"} "["]
         [:> styled-text {:className "text-2xl"} cost]
         [:> styled-text {:className "text-2xl font-bold"} "]"]])])
