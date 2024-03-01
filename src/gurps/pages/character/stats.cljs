(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [gurps.pages.character.widgets.stat_label :refer [stat-label]]
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
    [:> styled-view {:className "flex-1 py-8 bg-white items-center justify-between"}
     [:> styled-view {:style {:flex 1 :flex-wrap :wrap}}
      [stat-label {;; :className "w-1/2"
                   :label (i18n/label :t/stat-strength) :value 12 :current 11 :cost 20}]
      [stat-label {;; :className "w-1/2"
                   :label (i18n/label :t/stat-dexterity) :value 12 :current 11 :cost 20}]
      ]

     [:> styled-view {:className "items-center gap-y-4"}
      [:> styled-text {:className "text-4xl color-blue-500 font-bold"} @counter]
      [button {:on-press #(rf/dispatch [:inc-counter]) :disabled? (not @tap-enabled?) :style {:background-color :red}} "Tap me, I'll count"]
      ]
     [:> rn/View {:style {:align-items :center}}
      [button {:on-press (fn [] (-> props .-navigation (.navigate (i18n/label :t/items))))} "Tap me, I'll navigate"]
      ]
     [:> rn/View
      ;; [:> styled-view {:className "flex-1 items-center gap-y-4"}
      ;;  [:> rn/Image {:className "w-8 h-8" :source cljs-splash}]
      ;;  [:> rn/Image {:className "w-8 h-8" :source shadow-splash}]]
      [:> styled-text {:style {:font-weight :normal :font-size 15 :color :blue}}
       "Using: shadow-cljs+expo+reagent+re-frame"]]
     [:> StatusBar {:style "auto"}]]))
