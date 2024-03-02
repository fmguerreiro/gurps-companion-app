(ns gurps.widgets.base
  (:require ["nativewind" :as nw]
            ["react-native" :as rn]))

(def styled-view (nw/styled rn/View))
(def styled-text (nw/styled rn/Text))
(def styled-input (nw/styled rn/TextInput))
