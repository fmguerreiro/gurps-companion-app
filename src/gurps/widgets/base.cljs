(ns gurps.widgets.base
  (:require ["nativewind" :as nw]
            ["react-native" :as rn]))

(def view (nw/styled rn/View))
(def text (nw/styled rn/Text))
(def input (nw/styled rn/TextInput))
