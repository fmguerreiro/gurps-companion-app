(ns gurps.root
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            [taoensso.timbre :refer [info]]
            ["@react-navigation/native" :as rnn]
            ["@react-navigation/native-stack" :as rnn-stack]
            ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.stats :refer [character-stats-page]]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.skills :refer [character-skills-page character-add-skill-page]]
            [gurps.pages.character.skills.specialization :refer [character-add-skill-spec-page]]))

(defonce RootTab (rnn-bottom-tabs/createBottomTabNavigator))
(defonce SkillStack (rnn-stack/createNativeStackNavigator))

(def header-title-style {:textTransform "uppercase"}) ;; TODO: headerTitleStyle doesnt work here

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

(defn root []
  ;; The save and restore of the navigation root state is for development time bliss
  (r/with-let [!root-state (rf/subscribe [:navigation/root-state])
               save-root-state! (fn [^js state] (rf/dispatch [:navigation/set-root-state state]))
               add-listener! (fn [^js navigation-ref]
                               (when navigation-ref
                                 (.addListener navigation-ref "state" save-root-state!)))
               skill-stack-component (fn [] (r/as-element [skills-stack]))]
    [:> rnn/NavigationContainer {:ref add-listener!
                                 :initialState (when @!root-state (some-> @!root-state .-data .-state))}
     [:> RootTab.Navigator
      ;; TODO: should be stats > skills > items in the end
      [:> RootTab.Screen {:name      (str (i18n/label :t/skills) "-Root")
                          :component skill-stack-component
                          :options   {:title (i18n/label :t/skills) :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (i18n/label :t/stats)
                          :component (fn [props] (r/as-element [character-stats-page props]))
                          :options   {:title (i18n/label :t/stats) :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (i18n/label :t/items)
                          :component (fn [props] (r/as-element [character-items-page props]))
                          :options   {:title (i18n/label :t/items) :headerTitleStyle header-title-style}}]]]))
