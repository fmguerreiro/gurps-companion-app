(ns gurps.widgets.base
  (:require ["react-native" :as rn]
            [reagent.core :as r]))

(def view rn/View)
(def text rn/Text)
(def input rn/TextInput)
(def button rn/TouchableHighlight)
(def image rn/Image)

(def section-list rn/SectionList)
(def flat-list (r/adapt-react-class rn/FlatList))
(def scroll-view (r/adapt-react-class rn/ScrollView))
