(ns gurps.pages.character.info.widgets.character-notes
  (:require [gurps.widgets.base :refer [view text]]))

(defn character-notes []
  [:> view
   [:> text "notes"]])
