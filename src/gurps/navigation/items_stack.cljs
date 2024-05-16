(ns gurps.navigation.items-stack
  (:require [reagent.core :as r]
            ["@react-navigation/native-stack" :as rnn-stack]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.items.melee-weapons-page :refer [melee-weapons-page]]
            [gurps.pages.character.items.ranged-weapons-page :refer [ranged-weapons-page]]))

(defonce ItemsStack (rnn-stack/createNativeStackNavigator))

(defn items-stack
  []
  (r/with-let [possessions-component (fn [props] (r/as-element [character-items-page props]))
               melee-weapons-component (fn [props] (r/as-element [melee-weapons-page props]))
               ranged-weapons-component (fn [props] (r/as-element [ranged-weapons-page props]))]

    [:> ItemsStack.Navigator
     [:> ItemsStack.Screen {:name      (i18n/label :t/items)
                            :component possessions-component}]

     [:> ItemsStack.Screen {:name      (i18n/label :t/melee-weapons)
                            :component melee-weapons-component}]

     [:> ItemsStack.Screen {:name      (i18n/label :t/ranged-weapons)
                            :component ranged-weapons-component}]]))
