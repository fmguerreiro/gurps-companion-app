(ns gurps.pages.character.info
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.summary :refer [summary-group]]
            [gurps.pages.character.info.widgets.portrait :refer [portrait]]
            [gurps.pages.character.info.widgets.cultural-familiarities-section :refer [cultural-familiarities-section]]
            [gurps.pages.character.info.widgets.reaction-modifiers-section :refer [reaction-modifiers-section]]
            [gurps.pages.character.info.widgets.languages-section :refer [languages-section]]
            [gurps.pages.character.info.widgets.notes :refer [notes-section]]
            ["expo-status-bar" :refer [StatusBar]]
            ["react-native" :as rn]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn character-info-page
  []
  [:> rn/ScrollView
   [:> view {:style (tw "flex flex-col gap-4 py-4 bg-white items-center justify-between px-4")}

    [:> view {:style (tw "w-full")}
     [summary-group]]

    [:> view
     [portrait]]

    [:> view
     [cultural-familiarities-section]]

    [:> view
     [reaction-modifiers-section]]

    [:> view {:style (tw "w-full")}
     [languages-section]]

    [:> view {:style (tw "w-full")}
     [notes-section]]

    [:> StatusBar {:style "auto"}]]])
