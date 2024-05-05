(ns gurps.root
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["@react-navigation/native" :as rnn]
            ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]
            ["@expo/vector-icons/Feather" :default icon]
            ["@expo/vector-icons/MaterialCommunityIcons" :default material-icon]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.stats :refer [character-stats-page]]
            [gurps.pages.character.items :refer [character-items-page]]
            [gurps.pages.character.info :refer [character-info-page]]
            [gurps.navigation.skills-stack :refer [skills-stack]]))

(defonce RootTab (rnn-bottom-tabs/createBottomTabNavigator))

(def icon-color (.-color (tw "text-slate-400")))

(def header-title-style {:textTransform "uppercase"}) ;; TODO: headerTitleStyle doesnt work here

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

      [:> RootTab.Screen {:name      (i18n/label :t/stats)
                          :component (fn [props] (r/as-element [character-stats-page props]))
                          :options   {:title (i18n/label :t/stats)
                                      :tabBarIcon (fn [] (r/as-element [:> material-icon {:name "arm-flex" :size 20 :color icon-color}]))
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (str (i18n/label :t/skills))
                          :component skill-stack-component
                          :options   {:title (i18n/label :t/skills)
                                      :tabBarIcon (fn [] (r/as-element [:> material-icon {:name "dice-multiple" :size 20 :color icon-color}]))
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (i18n/label :t/items)
                          :component (fn [props] (r/as-element [character-items-page props]))
                          :options   {:title (i18n/label :t/items)
                                      :tabBarIcon (fn [] (r/as-element [:> material-icon {:name "shield-sword" :size 20 :color icon-color}]))
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (str (i18n/label :t/info))
                          :component (fn [props] (r/as-element [character-info-page props]))
                          :options   {:title (i18n/label :t/info)
                                      :tabBarIcon (fn [] (r/as-element [:> icon {:name "info" :size 20 :color icon-color}]))
                                      :headerTitleStyle header-title-style}}]]]))
