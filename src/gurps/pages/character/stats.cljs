(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [gurps.pages.character.widgets.stat-label :refer [stat-label]]
   [gurps.pages.character.widgets.summary :refer [summary]]
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   [reagent.core :as r]
   ["nativewind" :as nw]))

(def styled-text (nw/styled rn/Text))
(def styled-view (nw/styled rn/View))

;; (defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
;; (defonce cljs-splash (js/require "../assets/cljs.png"))

(defn character-stats-page [^js props]
  (r/with-let [counter (rf/subscribe [:get-counter])
               tap-enabled? (rf/subscribe [:counter-tappable?])]

    [:> rn/ScrollView
     [:> styled-view {:className "flex flex-col gap-4 py-4 bg-white items-center justify-between"}

      [:> styled-view {:className "w-full px-4"}
       [summary]]

      [:> styled-view {:className "flex flex-row gap-0"}
       [:> styled-view {:className "flex flex-col"}
        [stat-label {:label (i18n/label :t/stat-strength) :value 12 :cost 20 :add-current-space? false}]
        [stat-label {:label (i18n/label :t/stat-dexterity) :value 12 :cost 20 :add-current-space? false}]
        [stat-label {:label (i18n/label :t/stat-intelligence) :value 12 :cost 20 :add-current-space? false}]
        [stat-label {:label (i18n/label :t/stat-health) :value 12 :cost 20 :add-current-space? false}]]
       [:> styled-view {:className "flex flex-col"}
        [stat-label {:label (i18n/label :t/stat-hitpoints) :value 12 :current 11 :cost 20}]
        [stat-label {:label (i18n/label :t/stat-will) :value 12 :cost 20}]
        [stat-label {:label (i18n/label :t/stat-perception) :value 12 :cost 20}]
        [stat-label {:label (i18n/label :t/stat-fatigue) :value 12 :current 11 :cost 20}]]]

      [:> styled-view {:className "items-center gap-y-4"}
       [:> styled-text {:className "text-4xl color-blue-500 font-bold"} @counter]
       [button {:on-press #(rf/dispatch [:inc-counter]) :disabled? (not @tap-enabled?) :style {:background-color :red}} "Tap me, I'll count"]]
      [:> rn/View {:style {:align-items :center}}
       [button {:on-press (fn [] (-> props .-navigation (.navigate (i18n/label :t/items))))} "Tap me, I'll navigate"]]
      [:> rn/View
      ;; [:> styled-view {:className "flex-1 items-center gap-y-4"}
      ;;  [:> rn/Image {:className "w-8 h-8" :source cljs-splash}]
      ;;  [:> rn/Image {:className "w-8 h-8" :source shadow-splash}]]
       [:> styled-text {:style {:font-weight :normal :font-size 15 :color :blue}}
        "Using: shadow-cljs+expo+reagent+re-frame"]]

      [:> StatusBar {:style "auto"}]]]))
