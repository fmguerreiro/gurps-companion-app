(ns gurps.pages.character.stats
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.attributes :refer [attribute-group]]
            [gurps.pages.character.widgets.summary :refer [summary-group]]
            [gurps.pages.character.widgets.bases-table :refer [bases-table]]
            [gurps.pages.character.widgets.encumbrance-table :refer [encumbrance-table]]
            [gurps.pages.character.items.defenses-section :refer [defenses-section]]
            ["expo-status-bar" :refer [StatusBar]]
            ["react-native" :as rn]
            ["twrnc" :refer [style] :rename {style tw}]))

;; (defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
;; (defonce cljs-splash (js/require "../assets/cljs.png"))

(def screen-height (-> rn/Dimensions (.get "window") (.-height)))

(defn character-stats-page
  []
  [:> rn/ScrollView {:style (tw "bg-white")}
   [:> view {:style (tw "flex flex-col gap-4 m-4 items-center justify-between")}

    [:> view {:style (tw "w-full")}
     [summary-group]]

    [:> view {:style (tw "w-full")}
     [attribute-group]]

    [:> view {:style (tw "w-full")}
     [bases-table]]

    [:> view {:style (tw "w-full")}
     [encumbrance-table]]

    [:> view {:style (tw "w-full")}
     [defenses-section]]

    [:> StatusBar {:style "auto"}]]])
