(ns app.navigation.common
  (:require ["twrnc" :refer [style] :rename {style tw}]))

(def header-title-style (tw "text-xl font-bold text-center capitalize"))

(def options
  {:headerTitleStyle header-title-style
   :headerTitleAlign "center"})
