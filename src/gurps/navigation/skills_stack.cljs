(ns gurps.navigation.skills-stack
  (:require ["@react-navigation/native-stack" :as rnn-stack]
            ["twrnc" :refer [style] :rename {style tw}]
            [reagent.core :as r]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view]]
            [gurps.widgets.character-icon :refer [character-icon]]
            [gurps.pages.character.skills :refer [character-skills-page]]
            [gurps.pages.character.skills.groups :refer [character-add-skill-page]]
            [gurps.pages.character.skills.specialization :refer [character-add-skill-spec-page]]))

(defonce SkillStack (rnn-stack/createNativeStackNavigator))

(def header-title-style {:textTransform "uppercase"})

(defn header-icon
  []
  (fn [] (r/as-element [:> view
                        [character-icon]])))

(defn skills-stack
  []
  (r/with-let [character-skills-component (fn [props] (r/as-element [character-skills-page props]))
               character-add-skill-component (fn [props] (r/as-element [character-add-skill-page props]))
               character-add-skill-spec-component (fn [props] (r/as-element [character-add-skill-spec-page props]))]
    [:> SkillStack.Navigator
     [:> SkillStack.Screen {:name      (i18n/label :t/skills)
                            :component character-skills-component
                            :options   {:headerRight (header-icon)
                                        :headerTitleStyle header-title-style}}]

     [:> SkillStack.Screen {:name      (i18n/label :t/add-skill)
                            :component character-add-skill-component
                            :options   {:headerRight (header-icon)
                                        :headerTitleStyle header-title-style}}]

     [:> SkillStack.Screen {:name      (i18n/label :t/add-skill-specialization)
                            :component character-add-skill-spec-component
                            :options   {:headerRight (header-icon)
                                        :headerTitleStyle header-title-style}}]]))
