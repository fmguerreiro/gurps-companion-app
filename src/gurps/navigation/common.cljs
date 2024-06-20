(ns gurps.navigation.common
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [reagent.core :as r]
            [gurps.widgets.base :refer [view]]
            [gurps.widgets.character-icon :refer [character-icon]]))

(def header-title-style (tw "text-xl font-bold text-center capitalize"))

(defn header-icon
  []
  (fn [] (r/as-element [:> view [character-icon]])))

(def options
  {:headerRight (header-icon)
   :headerTitleStyle header-title-style
   :headerTitleAlign "center"})
