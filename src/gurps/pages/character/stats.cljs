(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [gurps.widgets.base :refer [text view]]
   [gurps.pages.character.widgets.attributes :refer [attributes]]
   [gurps.pages.character.widgets.summary :refer [summary]]
   [gurps.pages.character.widgets.basics :refer [basics]]
   [gurps.pages.character.widgets.encumbrance-table :refer [encumbrance-table]]
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   [reagent.core :as r]))

;; (defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
;; (defonce cljs-splash (js/require "../assets/cljs.png"))

(defn character-stats-page
  [^js props]
  (r/with-let [counter (rf/subscribe [:get-counter])
               tap-enabled? (rf/subscribe [:counter-tappable?])]

    [:> rn/ScrollView
     [:> view {:className "flex flex-col gap-4 py-4 bg-white items-center justify-between"}

      [:> view {:className "w-full px-4"}
       [summary]]

      [:> view {:className "my-0"}
       [attributes]]

      [:> view {:className "my-0"}
       [basics]]

      [:> view {:className "my-0 px-2"}
       [encumbrance-table]]

      [:> StatusBar {:style "auto"}]]]))
