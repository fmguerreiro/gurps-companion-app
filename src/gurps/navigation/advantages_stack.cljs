(ns gurps.navigation.advantages-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.advantages.details :refer [advantage-details-page]]
            [gurps.pages.character.advantages.list :refer [advantage-list-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn advantage-details-screen
  []
  (r/with-let [advantage-details-component (fn [props] (r/as-element [advantage-details-page props]))]
    [:> Stack.Screen {:name      (i18n/label :t/advantage-details)
                      :component advantage-details-component
                      :options   options}]))

(defn advantages-stack
  []
  (r/with-let [advantage-list-component (fn [props] (r/as-element [advantage-list-page props]))]
    [:> Stack.Navigator {:initialRouteName (i18n/label :t/advantage-list)}
     [:> Stack.Screen {:name      (i18n/label :t/advantage-list)
                       :component advantage-list-component
                       :options   options}]

     (advantage-details-screen)]))
