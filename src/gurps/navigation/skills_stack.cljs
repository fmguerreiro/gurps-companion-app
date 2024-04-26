(ns gurps.navigation.skills-stack
  (:require [reagent.core :as r]
            ["@react-navigation/native-stack" :as rnn-stack]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.skills :refer [character-skills-page character-add-skill-page]]
            [gurps.pages.character.skills.specialization :refer [character-add-skill-spec-page]]))

(defonce SkillStack (rnn-stack/createNativeStackNavigator))

(defn skills-stack
  []
  (r/with-let [character-skills-component (fn [props] (r/as-element [character-skills-page props]))
               character-add-skill-component (fn [props] (r/as-element [character-add-skill-page props]))
               character-add-skill-spec-component (fn [props] (r/as-element [character-add-skill-spec-page props]))]
    [:> SkillStack.Navigator
     [:> SkillStack.Screen {:name      (i18n/label :t/skills)
                            :component character-skills-component
                            :options   {:headerShown false}}]
     [:> SkillStack.Screen {:name      (i18n/label :t/add-skill)
                            :component character-add-skill-component
                            :options   {:headerShown false}}]
     [:> SkillStack.Screen {:name      (i18n/label :t/add-skill-specialization)
                            :component character-add-skill-spec-component
                            :options   {:headerShown false}}]]))
