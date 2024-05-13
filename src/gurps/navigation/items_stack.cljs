(ns gurps.navigation.items-stack
  (:require [reagent.core :as r]
            ["@react-navigation/native-stack" :as rnn-stack]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.items.melee-weapons-page :refer [melee-weapons-page]]))

(defonce ItemsStack (rnn-stack/createNativeStackNavigator))

(defn items-stack
  []
  (r/with-let [possessions-component (fn [props] (r/as-element [character-items-page props]))
               melee-weapons-component (fn [props] (r/as-element [melee-weapons-page props]))]

    [:> ItemsStack.Navigator
     [:> ItemsStack.Screen {:name      (i18n/label :t/items)
                            :component possessions-component
                            :options   {:headerShown false}}]
     [:> ItemsStack.Screen {:name      (i18n/label :t/melee-weapons)
                            :component melee-weapons-component
                            :options   {:headerShown false}}]]))
