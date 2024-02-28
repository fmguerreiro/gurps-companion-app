(ns gurps.app
  (:require
   ;; NOTE: Do NOT sort i18n-resources because it MUST be loaded first.
   [gurps.setup.i18n-resources :as i18n-resources]
   [gurps.events]
   [gurps.subs]
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [expo.root :as expo-root]
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   [reagent.core :as r]
   ["nativewind" :as nw]
   ["@react-navigation/native" :as rnn]
   ["@react-navigation/native-stack" :as rnn-stack]
   ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]))

(defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
(defonce cljs-splash (js/require "../assets/cljs.png"))

(defonce Stack (rnn-stack/createNativeStackNavigator))
(defonce Tab (rnn-bottom-tabs/createBottomTabNavigator))

(def StyledText (nw/styled rn/Text))
(def StyledView (nw/styled rn/View))

(defn home [^js props]
  (r/with-let [counter (rf/subscribe [:get-counter])
               tap-enabled? (rf/subscribe [:counter-tappable?])]
    [:> rn/View {:style {:flex 1
                         :padding-vertical 50
                         :justify-content :space-between
                         :align-items :center
                         :background-color :white}}
     [:> rn/View {:style {:align-items :center}}
      [:> rn/Text {:style {:font-weight   :bold
                           :font-size     72
                           :color         :blue
                           :margin-bottom 20}} @counter]
      [button {:on-press #(rf/dispatch [:inc-counter])
               :disabled? (not @tap-enabled?)
               :style {:background-color :red}}
       "Tap me, I'll count"]]
     [:> rn/View {:style {:align-items :center}}
      [button {:on-press (fn []
                           (-> props .-navigation (.navigate "About")))}
       "Tap me, I'll navigate"]]
     [:> rn/View
      [:> StyledView {:className "flex-1 items-center"
                      :style {;; :flex-direction :row
                              ;; :align-items :center
                              :margin-bottom 20}}
       [:> rn/Image {:style {:width  160
                             :height 160}
                     :source cljs-splash}]
       [:> rn/Image {:style {:width  160
                             :height 160}
                     :source shadow-splash}]]
      [:> StyledText
       {:style
        {:font-weight :normal :font-size 15 :color :blue}
        ;; :className "text-[#50d71e]"
        }
       "Using: shadow-cljs+expo+reagent+re-frame"]]
     [:> StatusBar {:style "auto"}]]))

(defn- about 
  []
  (r/with-let [counter (rf/subscribe [:get-counter])]
    [:> rn/View {:style {:flex 1
                         :padding-vertical 50
                         :padding-horizontal 20
                         :justify-content :space-between
                         :align-items :flex-start
                         :background-color :white}}
     [:> rn/View {:style {:align-items :flex-start}}
      [:> StyledText {:style {:font-weight   :bold
                              :font-size     54
                              :margin-bottom 20}
                      :className "text-purple-500"}
       "About Gurps App"]
      [:> rn/Text {:style {:font-weight   :bold
                           :font-size     20
                           :color         :blue
                           :margin-bottom 20}}
       (str "Counter is at: " @counter)]
      [:> rn/Text {:style {:font-weight :normal
                           :font-size   15
                           :color       :blue}}
       "Built with React Native, Expo, Reagent, re-frame, and React Navigation"]]
     [:> StatusBar {:style "auto"}]]))

(defn root []
  ;; The save and restore of the navigation root state is for development time bliss
  (r/with-let [!root-state (rf/subscribe [:navigation/root-state])
               save-root-state! (fn [^js state]
                                  (rf/dispatch [:navigation/set-root-state state]))
               add-listener! (fn [^js navigation-ref]
                               (when navigation-ref
                                 (.addListener navigation-ref "state" save-root-state!)))]
    [:> rnn/NavigationContainer {:ref add-listener!
                                 :initialState (when @!root-state (-> @!root-state .-data .-state))}
     [:> Tab.Navigator
      [:> Tab.Screen {:name "Home"
                      :component (fn [props] (r/as-element [home props]))
                      :options {:title (i18n/label :t/header)}}]
      [:> Tab.Screen {:name "About"
                      :component (fn [props] (r/as-element [about props]))
                      :options {:title "About"}}]]]))

(defn start
  {:dev/after-load true}
  []
  (i18n/set-language "en")
  (i18n-resources/load-language "en")
  (expo-root/render-root (r/as-element [root])))

(defn init []
  (rf/dispatch-sync [:initialize-db])
  (start))
