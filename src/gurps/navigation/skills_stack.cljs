(ns gurps.navigation.skills-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [cljs-bean.core :refer [->js]]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.advantages-stack :refer [advantage-details-screen]]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.skills.character :refer [character-skills-page]]
            [gurps.pages.character.skills.groups :refer [skill-groups-page]]
            [gurps.pages.character.skills.details :refer [skill-details-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn skill-details-screen
  []
  (r/with-let [details-component (fn [props] (r/as-element [skill-details-page props]))]
    [:> Stack.Screen {:name      (i18n/label :t/add-skill-specialization)
                      :component details-component
                      :options   (fn [props]
                                   (let [id  (-> ^js props .-route .-params .-id)
                                         id' (or (-> id keyword namespace) id)]
                                     (-> {:title (i18n/label (keyword :t (str "skill-" id')))}
                                         (merge options)
                                         ->js)))}]))

(defn skills-stack
  []
  (r/with-let [character-component (fn [props] (r/as-element [character-skills-page props]))
               groups-component (fn [props] (r/as-element [skill-groups-page props]))]

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/skills)
                       :component character-component
                       :options   options}]

     [:> Stack.Screen {:name      (i18n/label :t/add-skill)
                       :component groups-component
                       :options   options}]

     (skill-details-screen)

     ;; some skills have advantage requirements
     (advantage-details-screen)]))
