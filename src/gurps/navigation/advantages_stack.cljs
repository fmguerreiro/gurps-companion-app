(ns gurps.navigation.advantages-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            ["@react-navigation/material-top-tabs" :as rnn-top-tabs]
            [cljs-bean.core :refer [->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.advantages.character :refer [character-advantages-page]]
            [gurps.pages.character.advantages.details :refer [advantage-details-page]]
            [gurps.pages.character.advantages.groups :refer [advantage-groups-page]]
            [gurps.pages.character.disadvantages.groups :refer [disadvantage-groups-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defonce Tab (rnn-top-tabs/createMaterialTopTabNavigator))

(defn advantage-details-screen
  ([] (advantage-details-screen {}))
  ([opts]
   (r/with-let [advantage-details-component (fn [props] (r/as-element [advantage-details-page props]))]
     [:> Stack.Screen {:name      (i18n/label :t/advantage-details)
                       :component advantage-details-component
                       :options   (fn [props]
                                    (let [id (-> ^js props .-route .-params .-id)]
                                      (-> {:title (i18n/label (keyword :t (str "advantage-" id)))}
                                          (merge options)
                                          (merge opts)
                                          ->js)))}])))

(defn advantages-tab
  []
  (r/with-let [advantage-groups-component (fn [props] (r/as-element [advantage-groups-page props]))
               character-advantages-component (fn [props] (r/as-element [character-advantages-page props]))]

    [:> Stack.Navigator {:initialRouteName (i18n/label :t/character-advantages)}

     [:> Stack.Screen {:name      (i18n/label :t/character-advantages)
                       :component character-advantages-component
                       :options   {:headerShown false}}]

                       ;; :options   options

     [:> Stack.Screen {:name      (i18n/label :t/advantage-list)
                       :component advantage-groups-component
                       :options   {:headerShown false}}]
                       ;; :options   options

     (advantage-details-screen {:headerShown false})]))

(defn disadvantages-tab
  []
  (r/with-let [disadvantage-groups-component (fn [props] (r/as-element [disadvantage-groups-page props]))]

    [:> Stack.Navigator

     [:> Stack.Screen {:name      (i18n/label :t/disadvantage-list)
                       :component disadvantage-groups-component
                       :options   {:headerShown false}}]]))
                       ;; :options   options

(defn advantages-stack
  []
  (r/with-let [advantages-stack-component (fn [] (r/as-element [advantages-tab]))
               disadvantages-stack-component (fn [] (r/as-element [disadvantages-tab]))]

    [:> Tab.Navigator

     [:> Tab.Screen {:name      (str (i18n/label :t/advantages) "Tab")
                     :component advantages-stack-component
                     :options   options}]

     [:> Tab.Screen {:name      (str (i18n/label :t/disadvantages) "Tab")
                     :component disadvantages-stack-component
                     :options   options}]]))
