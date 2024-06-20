(ns gurps.navigation.skills-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.navigation.common :refer [options]]
            [gurps.pages.character.skills :refer [character-skills-page]]
            [gurps.pages.character.skills.groups :refer [character-add-skill-page]]
            [gurps.pages.character.skills.specialization :refer [character-add-skill-spec-page]]))

(defonce Stack (rnn-stack/createNativeStackNavigator))

(defn skill-details-screen
  []
  (r/with-let [skill-details-component (fn [props] (r/as-element [character-add-skill-spec-page props]))]
    [:> Stack.Screen {:name      (i18n/label :t/add-skill-specialization)
                      :component skill-details-component
                      :options   options}]))

(defn skills-stack
  []
  (r/with-let [character-skills-component (fn [props] (r/as-element [character-skills-page props]))
               character-add-skill-component (fn [props] (r/as-element [character-add-skill-page props]))]

    [:> Stack.Navigator
     [:> Stack.Screen {:name      (i18n/label :t/skills)
                       :component character-skills-component
                       :options   options}]

     [:> Stack.Screen {:name      (i18n/label :t/add-skill)
                       :component character-add-skill-component
                       :options   options}]

     (skill-details-screen)]))
