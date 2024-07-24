(ns gurps.widgets.base
  (:require ["react-native" :as rn]
            ["@shopify/flash-list" :as flash]
            [reagent.core :as r]))

(def view rn/View)
(def text rn/Text)
(def input rn/TextInput)
(def button rn/TouchableOpacity)
(def image rn/Image)

(def section-list-raw rn/SectionList)
(def section-list (r/adapt-react-class rn/SectionList))
(def flat-list (r/adapt-react-class flash/FlashList))
(def flat-list-old (r/adapt-react-class rn/FlatList))
(def scroll-view (r/adapt-react-class rn/ScrollView))
