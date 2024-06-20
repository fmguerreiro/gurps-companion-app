(ns gurps.navigation.items-stack
  (:require ["@react-navigation/material-top-tabs" :as rnn-top-tabs]
            ["twrnc" :refer [style] :rename {style tw}]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.items.melee-weapons-page :refer [melee-weapons-page]]
            [gurps.pages.character.items.ranged-weapons-page :refer [ranged-weapons-page]]))

(defonce Tab (rnn-top-tabs/createMaterialTopTabNavigator))

(def header-title-style (tw "font-bold text-center capitalize"))

(defn items-stack
  []
  (r/with-let [possessions-component (fn [props] (r/as-element [character-items-page props]))
               melee-weapons-component (fn [props] (r/as-element [melee-weapons-page props]))
               ranged-weapons-component (fn [props] (r/as-element [ranged-weapons-page props]))]
    [:> Tab.Navigator {:initialRouteName (i18n/label :t/items)
                       :screenOptions {:tabBarLabelStyle header-title-style
                                       :headerTitleAlign "center"}}

     [:> Tab.Screen {:name      (i18n/label :t/melee-weapons)
                     :component melee-weapons-component
                     :options   options}]

     [:> Tab.Screen {:name      (i18n/label :t/items)
                     :component possessions-component
                     :options   (merge options
                                       {:title (i18n/label :t/armor-possessions)})}]

     [:> Tab.Screen {:name      (i18n/label :t/ranged-weapons)
                     :component ranged-weapons-component
                     :options   options}]]))
