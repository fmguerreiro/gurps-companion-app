(ns gurps.navigation.advantages-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [cljs-bean.core :refer [->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.advantages.character :refer [character-advantages-page]]
            [gurps.pages.character.advantages.details :refer [advantage-details-page]]
            [gurps.pages.character.advantages.groups :refer [advantage-groups-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn advantage-details-screen
  []
  (r/with-let [advantage-details-component (fn [props] (r/as-element [advantage-details-page props]))]
    [:> Stack.Screen {:name      (i18n/label :t/advantage-details)
                      :component advantage-details-component
                      :options   (fn [props]
                                   (let [id (-> ^js props .-route .-params .-id)]
                                     (-> {:title (i18n/label (keyword :t (str "advantage-" id)))}
                                         (merge options)
                                         ->js)))}]))

(defn advantages-stack
  []
  (r/with-let [advantage-groups-component (fn [props] (r/as-element [advantage-groups-page props]))
               character-advantages-component (fn [props] (r/as-element [character-advantages-page props]))]

    [:> Stack.Navigator {:initialRouteName (i18n/label :t/character-advantages)}

     [:> Stack.Screen {:name      (i18n/label :t/character-advantages)
                       :component character-advantages-component
                       :options   options}]

     [:> Stack.Screen {:name      (i18n/label :t/advantage-list)
                       :component advantage-groups-component
                       :options   options}]

     (advantage-details-screen)]))
