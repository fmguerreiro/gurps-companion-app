(ns gurps.pages.character.stats
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.attributes :refer [attribute-group]]
            [gurps.pages.character.widgets.summary :refer [summary-group]]
            [gurps.pages.character.widgets.basics :refer [basics-table]]
            [gurps.pages.character.widgets.encumbrance-table :refer [encumbrance-table]]
            ["expo-status-bar" :refer [StatusBar]]
            ["react-native" :as rn]
            ["twrnc" :refer [style] :rename {style tw}]))

;; (defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
;; (defonce cljs-splash (js/require "../assets/cljs.png"))

(defn character-stats-page
  []
  [:> rn/ScrollView
   [:> view {:style (tw "flex flex-col gap-4 py-4 bg-white items-center justify-between px-4")}

    [:> view {:style (tw "w-full")}
     [summary-group]]

    [:> view
     [attribute-group]]

    [:> view
     [basics-table]]

    [:> view
     [encumbrance-table]]

    [:> StatusBar {:style "auto"}]]])
