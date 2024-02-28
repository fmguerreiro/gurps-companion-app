(ns gurps.pages.character.stats
  (:require
   [gurps.widgets.button :refer [button]]
   [gurps.utils.i18n :as i18n]
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   ["react-native" :as rn]
   [reagent.core :as r]
   ["nativewind" :as nw]))

(def StyledText (nw/styled rn/Text))
(def StyledView (nw/styled rn/View))

(defonce shadow-splash (js/require "../assets/shadow-cljs.png"))
(defonce cljs-splash (js/require "../assets/cljs.png"))

(defn character-stats-page [^js props]
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
