(ns gurps.root
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["@react-navigation/native" :as rnn]
            ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]
            ["@expo/vector-icons/MaterialCommunityIcons" :default material-icon]
            ["@expo/vector-icons/Fontisto" :default fontisto-icon]
            ["@expo/vector-icons/Ionicons" :default ion-icon]
            ["react-native-safe-area-context" :refer (useSafeAreaInsets) :rename {SafeAreaProvider safe-area-provider}]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.info :refer [character-info-page]]
            [gurps.navigation.items-stack :refer [items-stack]]
            [gurps.navigation.common :refer [options]]
            [gurps.navigation.character-stack :refer [character-stack]]
            [gurps.navigation.skills-stack :refer [skills-stack]]
            [gurps.navigation.spells-stack :refer [spells-stack]]
            [gurps.navigation.advantages-stack :refer [advantages-stack]]))

(defonce RootTab (rnn-bottom-tabs/createBottomTabNavigator))

(def icon-color (.-color (tw "text-slate-400")))

(defn tab-bar-icon
  ([icon] (tab-bar-icon icon :material))
  ([icon variant]
   (let [icon-comp (cond (= :fontisto variant) fontisto-icon, (= :ionicons variant) ion-icon :else material-icon)]
     (fn [] (r/as-element [:> icon-comp {:name icon :size 20 :color icon-color}])))))

(defn- safe-view
  [component]
  (let [insets (useSafeAreaInsets)]
    [:> view {:style #js [(tw "flex-1 bg-white"), #js {:paddingTop (.-top insets)}]}
     component]))

(defn root []
  ;; The save and restore of the navigation root state is for development time bliss
  (r/with-let [!root-state (rf/subscribe [:navigation/root-state])
               save-root-state! (fn [^js state] (when (some-> state .-data .-state)
                                                  (rf/dispatch [:navigation/set-root-state state])))
               add-listener! (fn [^js navigation-ref]
                               (when navigation-ref
                                 (.addListener navigation-ref "state" save-root-state!)))
               character-stack-component (fn [] (r/as-element [character-stack]))
               skill-stack-component     (fn [] (r/as-element [skills-stack]))
               items-stack-component     (fn [] (r/as-element (safe-view [items-stack])))
               spell-stack-component     (fn [] (r/as-element [spells-stack]))
               advan-stack-component     (fn [] (r/as-element (safe-view [advantages-stack])))]

    [:> safe-area-provider
     [:> rnn/NavigationContainer {:ref add-listener!
                                  :initialState (when @!root-state (some-> @!root-state .-data .-state))}
      [:> RootTab.Navigator

       [:> RootTab.Screen {:name      (str (i18n/label :t/stats) "Stack")
                           :component character-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/stats)
                                        :tabBarIcon (tab-bar-icon "persons" :fontisto)
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/skills) "Stack")
                           :component skill-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/skills)
                                        :tabBarIcon (tab-bar-icon "arm-flex")
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/advantages) "Stack")
                           :component advan-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/advantages)
                                        :tabBarIcon (tab-bar-icon "star")
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/spells) "Stack")
                           :component spell-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/spells)
                                        :tabBarIcon (tab-bar-icon "fire")
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/items) "Stack")
                           :component items-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/items)
                                        :tabBarIcon (tab-bar-icon "shield-sword")
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/background))
                           :component (fn [props] (r/as-element [character-info-page props]))
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/background)
                                        :tabBarIcon (tab-bar-icon "book" :ionicons)})}]]]]))
