(ns gurps.navigation.character-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.stats :refer [character-stats-page]]
            [gurps.navigation.common :refer [options]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn character-stack
  []
  (r/with-let [character-component   (fn [props] (r/as-element [character-stats-page props]))]

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/stats)
                       :component character-component
                       :options   options}]]))
