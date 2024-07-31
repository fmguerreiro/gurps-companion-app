(ns gurps.pages.character.info
  (:require ["expo-status-bar" :refer [StatusBar]]
            ["react-native" :as rn]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.summary :refer [summary-group]]
            [gurps.pages.character.info.widgets.portrait :refer [portrait]]
            [gurps.pages.character.info.widgets.tech-level-dropdown :refer [tech-level-dropdown]]
            [gurps.pages.character.info.widgets.reaction-modifiers-section :refer [reaction-modifiers-section]]
            [gurps.pages.character.info.widgets.languages-section :refer [languages-section]]
            [gurps.pages.character.info.widgets.notes :refer [notes-section]]))

(defn character-info-page
  []
  [:> rn/ScrollView {:style (tw "bg-white")}
   [:> view {:style (tw "flex flex-col gap-4 py-4 bg-white items-center justify-between px-4")}

    [:> view {:style (tw "w-full")}
     [summary-group]]

    [:> view
     [portrait]]

    [:> view {:style (tw "w-full")}
     [tech-level-dropdown]]

    [:> view {:style (tw "w-full")}
     [reaction-modifiers-section]]

    [:> view {:style (tw "w-full")}
     [languages-section]]

    [:> view {:style (tw "w-full")}
     [notes-section]]

    [:> StatusBar {:style "auto"}]]])
