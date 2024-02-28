(ns gurps.root
  (:require
   [gurps.utils.i18n :as i18n]
   [gurps.pages.character.stats :refer [character-stats-page]]
   [gurps.pages.character.items :refer [character-items-page]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   [reagent.core :as r]
   ["@react-navigation/native" :as rnn]
   ["@react-navigation/bottom-tabs" :as rnn-bottom-tabs]))

(defonce Tab (rnn-bottom-tabs/createBottomTabNavigator))

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
      [:> Tab.Screen {:name (i18n/label :t/stats)
                      :component (fn [props] (r/as-element [character-stats-page props]))
                      :options {:title (i18n/label :t/stats)}}]
      [:> Tab.Screen {:name (i18n/label :t/items)
                      :component (fn [props] (r/as-element [character-items-page props]))
                      :options {:title (i18n/label :t/items)}}]]]))
