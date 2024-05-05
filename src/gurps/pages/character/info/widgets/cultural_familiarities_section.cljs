(ns gurps.pages.character.info.widgets.cultural-familiarities-section
  (:require [gurps.widgets.base :refer [view text]]))

(defn cultural-familiarities-section []
  [:> view
   [:> text "cultural-familiarities"]])
