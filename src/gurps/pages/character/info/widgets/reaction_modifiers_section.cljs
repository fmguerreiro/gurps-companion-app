(ns gurps.pages.character.info.widgets.reaction-modifiers-section
  (:require [gurps.widgets.base :refer [view text]]))

(defn reaction-modifiers-section []
  [:> view
   [:> text "reaction-modifiers"]])
