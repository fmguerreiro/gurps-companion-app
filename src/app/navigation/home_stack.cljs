(ns app.navigation.home-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [app.utils.i18n :as i18n]
            [app.pages.home :refer [home-page]]
            [app.navigation.common :refer [options]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn home-stack
  []
  (r/with-let [home-component (fn [props] (r/as-element [home-page props]))]
    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/home)
                       :component home-component
                       :options   options}]]))
