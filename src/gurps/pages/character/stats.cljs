(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   [gurps.widgets.base :refer [text view]]
   [gurps.pages.character.widgets.attributes :refer [attributes]]
   [gurps.pages.character.widgets.summary :refer [summary]]
   [gurps.pages.character.widgets.basics :refer [basics]]
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

      ;; TODO: remove this
      [:> view {:className "items-center gap-y-4"}
       [:> text {:className "text-4xl color-blue-500 font-bold"} @counter]
       [button {:on-press #(rf/dispatch [:inc-counter]) :disabled? (not @tap-enabled?) :style {:background-color :red}} "Tap me, I'll count"]]
      [:> rn/View {:style {:align-items :center}}
       [button {:on-press (fn [] (-> props .-navigation (.navigate (i18n/label :t/items))))} "Tap me, I'll navigate"]]
      [:> rn/View
      ;; [:> view {:className "flex-1 items-center gap-y-4"}
      ;;  [:> rn/Image {:className "w-8 h-8" :source cljs-splash}]
      ;;  [:> rn/Image {:className "w-8 h-8" :source shadow-splash}]]
       [:> text {:style {:font-weight :normal :font-size 15 :color :blue}}
        "Using: shadow-cljs+expo+reagent+re-frame"]]

      [:> StatusBar {:style "auto"}]]]))
