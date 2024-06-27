(ns gurps.navigation.items-stack
  (:require ["twrnc" :refer [style] :rename {style tw}]
            ["@react-navigation/native-stack" :as rnn-stack]
            ["@react-navigation/material-top-tabs" :as rnn-top-tabs]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.items.melee-weapons-page :refer [melee-weapons-page]]
            [gurps.pages.character.items.melee-list-page :refer [melee-list-page]]
            [gurps.pages.character.items.melee-edit-page :refer [melee-edit-page]]
            [gurps.pages.character.items.ranged-weapons-page :refer [ranged-weapons-page]]))

(defonce Tab (rnn-top-tabs/createMaterialTopTabNavigator))
(defonce Stack (rnn-stack/createNativeStackNavigator))

(def header-title-style (tw "font-bold text-center capitalize"))

(defn- melee-weapons-stack
  []
  (r/with-let [owned-component (fn [props] (r/as-element [melee-weapons-page props]))
               list-component  (fn [props] (r/as-element [melee-list-page props]))
               edit-component  (fn [props] (r/as-element [melee-edit-page props]))]

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/melee-weapons-owned)
                       :component owned-component
                       :options   {:headerShown false}}]
     [:> Stack.Screen {:name      (i18n/label :t/melee-weapons-list)
                       :component list-component
                       :options   {:headerShown false}}]
     [:> Stack.Screen {:name      (i18n/label :t/melee-weapons-edit)
                       :component edit-component
                       :options   {:headerShown false}}]]))

(defn items-stack
  []
  (r/with-let [possessions-component (fn [props] (r/as-element [character-items-page props]))
               melee-weapons-component (fn [props] (r/as-element [melee-weapons-stack props]))
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
