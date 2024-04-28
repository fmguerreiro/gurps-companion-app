(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [gurps.widgets.base :refer [text view]]
   [gurps.pages.character.widgets.attributes :refer [attribute-group]]
   [gurps.pages.character.widgets.summary :refer [summary-group]]
   [gurps.pages.character.widgets.basics :refer [basics]]
   [gurps.pages.character.widgets.encumbrance-table :refer [encumbrance-table]]
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   ["twrnc" :refer [style] :rename {style tw}]
   [reagent.core :as r]))

;; (tw "bg-blue-100 text-2xl flex")

;; (defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
;; (defonce cljs-splash (js/require "../assets/cljs.png"))

(defn character-stats-page
  [^js props]
  [:> rn/ScrollView
   [:> view {:style (tw "flex flex-col gap-4 py-4 bg-white items-center justify-between")}

    [:> view {:style (tw "w-full px-4")}
     [summary-group]]

    [:> view {:style (tw "my-0")}
     [attribute-group]]

    [:> view {:style (tw "my-0")}
     [basics]]

    [:> view {:style (tw "my-0 px-2")}
     [encumbrance-table]]

    [:> StatusBar {:style "auto"}]]])
