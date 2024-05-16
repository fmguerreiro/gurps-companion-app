(ns gurps.root
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["@react-navigation/native" :as rnn]
            ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]
            ["@expo/vector-icons/MaterialCommunityIcons" :default material-icon]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [gurps.pages.character.stats :refer [character-stats-page]]
            [gurps.pages.character.info :refer [character-info-page]]
            [gurps.navigation.items-stack :refer [items-stack]]
            [gurps.navigation.skills-stack :refer [skills-stack]]))

(defonce RootTab (rnn-bottom-tabs/createBottomTabNavigator))

(def icon-color (.-color (tw "text-slate-400")))

(def header-title-style {:textTransform "uppercase"}) ;; TODO: headerTitleStyle doesnt work here

;; (clj->js {:navigation {:root-state {"type" "state", "data" {"state" nil}}}})
;; => #js {:navigation #js {:root-state #js {:type "state", :data #js {:state nil}}}}

(defn tab-bar-icon
  [icon]
  (fn [] (r/as-element [:> material-icon {:name icon :size 20 :color icon-color}])))

(defn root []
  ;; The save and restore of the navigation root state is for development time bliss
  (r/with-let [!root-state (rf/subscribe [:navigation/root-state])
               save-root-state! (fn [^js state] (when (some-> state .-data .-state)
                                                  (rf/dispatch [:navigation/set-root-state state])))
               add-listener! (fn [^js navigation-ref]
                               (when navigation-ref
                                 (.addListener navigation-ref "state" save-root-state!)))
               skill-stack-component (fn [] (r/as-element [skills-stack]))
               items-stack-component (fn [] (r/as-element [items-stack]))]

    [:> rnn/NavigationContainer {:ref add-listener!
                                 :initialState (when @!root-state (some-> @!root-state .-data .-state))}
     [:> RootTab.Navigator

      [:> RootTab.Screen {:name      (i18n/label :t/stats)
                          :component (fn [props] (r/as-element [character-stats-page props]))
                          :options   {:title (i18n/label :t/stats)
                                      :tabBarIcon (tab-bar-icon "arm-flex")
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (str (i18n/label :t/skills) "Stack")
                          :component skill-stack-component
                          :options   {:title (i18n/label :t/skills)
                                      :tabBarIcon (tab-bar-icon "dice-multiple")
                                      :headerShown false
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (str (i18n/label :t/items) "Stack")
                          :component items-stack-component
                          :options   {:title (i18n/label :t/items)
                                      :tabBarIcon (tab-bar-icon "shield-sword")
                                      :headerShown false
                                      :headerTitleStyle header-title-style}}]
      [:> RootTab.Screen {:name      (str (i18n/label :t/info))
                          :component (fn [props] (r/as-element [character-info-page props]))
                          :options   {:title (i18n/label :t/info)
                                      :tabBarIcon (tab-bar-icon "information-outline")
                                      :headerTitleStyle header-title-style}}]]]))
