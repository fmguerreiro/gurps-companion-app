(ns gurps.navigation.advantages-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.advantages.details :refer [advantage-details-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn advantage-details-screen
  []
  (r/with-let [advantage-details-component (fn [props] (r/as-element [advantage-details-page props]))]
    [:> Stack.Screen {:name      (i18n/label :t/advantage-details)
                      :component advantage-details-component
                      :options   {}}]))

(defn advantages-stack
  []
  [:> Stack.Navigator
   (advantage-details-screen)])
