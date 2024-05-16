(ns gurps.navigation.items-stack
  (:require [reagent.core :as r]
            ["@react-navigation/material-top-tabs" :as rnn-top-tabs]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.items.melee-weapons-page :refer [melee-weapons-page]]
            [gurps.pages.character.items.ranged-weapons-page :refer [ranged-weapons-page]]))

(defonce Stack (rnn-top-tabs/createMaterialTopTabNavigator))

(defn items-stack
  []
  (r/with-let [possessions-component (fn [props] (r/as-element [character-items-page props]))
               melee-weapons-component (fn [props] (r/as-element [melee-weapons-page props]))
               ranged-weapons-component (fn [props] (r/as-element [ranged-weapons-page props]))]
    [:> Stack.Navigator {:initialRouteName (i18n/label :t/items)}
     [:> Stack.Screen {:name      (i18n/label :t/melee-weapons)
                       :component melee-weapons-component}]

     [:> Stack.Screen {:name      (i18n/label :t/items)
                       :component possessions-component}]

     [:> Stack.Screen {:name      (i18n/label :t/ranged-weapons)
                       :component ranged-weapons-component}]]))
