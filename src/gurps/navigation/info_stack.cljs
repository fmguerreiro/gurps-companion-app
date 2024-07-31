(ns gurps.navigation.info-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.info :refer [character-info-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn info-stack
  []
  (r/with-let [info-component (fn [props] (r/as-element [character-info-page props]))]

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/background)
                       :component info-component
                       :options   options}]]))
