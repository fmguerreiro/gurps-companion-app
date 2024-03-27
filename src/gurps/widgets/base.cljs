(ns gurps.widgets.base
  (:require ["nativewind" :as nw]
            ["react-native" :as rn]
            [reagent.core :as r]))

(def view (nw/styled rn/View))
(def text (nw/styled rn/Text))
(def input (nw/styled rn/TextInput))
(def button (nw/styled rn/TouchableHighlight))

;; lists are not supported by nativewind
(def section-list rn/SectionList)
(def flat-list (r/adapt-react-class rn/FlatList))
