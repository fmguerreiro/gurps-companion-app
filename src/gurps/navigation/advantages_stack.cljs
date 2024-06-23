(ns gurps.navigation.advantages-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            ["@react-navigation/material-top-tabs" :as rnn-top-tabs]
            [cljs-bean.core :refer [->js]]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.helpers :refer [singularize-key]]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.advantages.character :refer [character-advantages-page]]
            [gurps.pages.character.advantages.details :refer [advantage-details-page]]
            [gurps.pages.character.advantages.groups :refer [advantage-groups-page]]
            [gurps.pages.character.advantages.events]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defonce Tab (rnn-top-tabs/createMaterialTopTabNavigator))

(defn advantage-details-screen
  ([] (advantage-details-screen :advantages {}))
  ([type opts]
   (r/with-let [advantage-details-component (fn [props] (r/as-element [advantage-details-page props type]))]
     [:> Stack.Screen {:name      (i18n/label (keyword :t (str (singularize-key type) "-details")))
                       :component advantage-details-component
                       :options   (fn [props]
                                    (let [id (-> ^js props .-route .-params .-id)]
                                      (-> {:title (i18n/label (keyword :t (str (singularize-key type) "-" id)))}
                                          (merge options)
                                          (merge opts)
                                          ->js)))}])))

(defn- advantages-tab
  ([] (advantages-tab :advantages))
  ([type]
   (r/with-let [groups-component     #(r/as-element [advantage-groups-page type])
                advantages-component #(r/as-element [character-advantages-page type])]

     [:> Stack.Navigator {:initialRouteName (i18n/label (keyword :t (str "character-" type)))}

      [:> Stack.Screen {:name      (i18n/label (keyword :t (str "character-" type)))
                        :component advantages-component
                        :options   {:headerShown false}}]

      [:> Stack.Screen {:name      (i18n/label (keyword :t (str (singularize-key type) "-list")))
                        :component groups-component
                        :options   {:headerShown false}}]

      (advantage-details-screen type {:headerShown false})])))

(defn advantages-stack
  []
  (r/with-let [advantages-stack-component (fn [] (r/as-element [advantages-tab]))
               disadvantages-stack-component (fn [] (r/as-element (advantages-tab :disadvantages)))]

    [:> Tab.Navigator

     [:> Tab.Screen {:name      (str (i18n/label :t/advantages) "Tab")
                     :component advantages-stack-component
                     :options   (merge options
                                       {:tabBarLabel (i18n/label :t/advantages)})}]

     [:> Tab.Screen {:name      (str (i18n/label :t/disadvantages) "Tab")
                     :component disadvantages-stack-component
                     :options   (merge options
                                       {:tabBarLabel (i18n/label :t/disadvantages)})}]]))
