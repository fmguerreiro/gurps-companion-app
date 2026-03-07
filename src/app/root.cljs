(ns app.root
  (:require [re-frame.core :as rf]
            [reagent.core :as r]
            ["@react-navigation/native" :as rnn]
            ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]
            ["@expo/vector-icons/MaterialCommunityIcons" :default material-icon]
            ["react-native-safe-area-context" :refer (useSafeAreaInsets) :rename {SafeAreaProvider safe-area-provider}]
            ["twrnc" :refer [style] :rename {style tw}]
            [app.utils.i18n :as i18n]
            [app.widgets.base :refer [view text]]
            [app.navigation.home-stack :refer [home-stack]]
            [app.navigation.common :refer [options]]
            [react-native.platform :refer [android?]]))

(defonce RootTab (rnn-bottom-tabs/createBottomTabNavigator))

(def icon-color (.-color (tw "text-slate-400")))

(defn tab-bar-icon
  [icon-name & {:keys [size] :or {size 24}}]
  (fn []
    (r/as-element
     [:> material-icon {:name icon-name :size size :color icon-color}])))

(defn- settings-page
  []
  [:> view {:style (tw "flex-1 items-center justify-center bg-white")}
   [:> text {:style (tw "text-xl font-bold")} (i18n/label :t/settings)]])

(defn- safe-view
  [component]
  (let [insets (useSafeAreaInsets)]
    [:> view {:style #js [(tw "flex-1 bg-white"), #js {:paddingTop (.-top insets)}]}
     component]))

(defn root []
  (r/with-let [!root-state (rf/subscribe [:navigation/root-state])
               save-root-state! (fn [^js state] (when (some-> state .-data .-state)
                                                  (rf/dispatch [:navigation/set-root-state state])))
               add-listener! (fn [^js navigation-ref]
                               (when navigation-ref
                                 (.addListener navigation-ref "state" save-root-state!)))
               home-stack-component     (fn [] (r/as-element [home-stack]))
               settings-stack-component (fn [] (r/as-element (safe-view [settings-page])))]

    [:> safe-area-provider
     [:> rnn/NavigationContainer {:ref add-listener!
                                  :initialState (when @!root-state (some-> @!root-state .-data .-state))}

      [:> RootTab.Navigator (when android? {:screenOptions {:tabBarStyle (tw "h-16 py-2 bg-white")}})

       [:> RootTab.Screen {:name      (str (i18n/label :t/home) "Stack")
                           :component home-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/home)
                                        :tabBarIcon (tab-bar-icon "home")
                                        :headerShown false})}]

       [:> RootTab.Screen {:name      (str (i18n/label :t/settings) "Stack")
                           :component settings-stack-component
                           :options   (merge
                                       options
                                       {:title (i18n/label :t/settings)
                                        :tabBarIcon (tab-bar-icon "cog")
                                        :headerShown false})}]]]]))
