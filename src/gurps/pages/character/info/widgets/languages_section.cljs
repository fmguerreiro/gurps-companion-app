(ns gurps.pages.character.info.widgets.languages-section
  (:require [gurps.widgets.base :refer [view text]]))

(defn languages-section []
  [:> view
   [:> text "languages"]])
