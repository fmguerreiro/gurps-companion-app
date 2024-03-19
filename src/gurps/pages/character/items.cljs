(ns gurps.pages.character.items
  (:require
   ["expo-status-bar" :refer [StatusBar]]
   [re-frame.core :as rf]
   [reagent.core :as r]
   [gurps.utils.i18n :as i18n]
   [gurps.widgets.base :refer [view text]]))

(defn character-items-page
  []
  (r/with-let [counter (rf/subscribe [:get-counter])]
    [:> view {:style {:flex 1
                         :padding-vertical 50
                         :padding-horizontal 20
                         :justify-content :space-between
                         :align-items :flex-start
                         :background-color :white}}
     [:> view {:style {:align-items :flex-start}}
      [:> text {:style {:font-weight   :bold
                              :font-size     54
                              :margin-bottom 20}
                      :className "text-blue-500"}
       "About Gurps App"]
      [:> text {:style {:font-weight   :bold
                           :font-size     20
                           :color         :blue
                           :margin-bottom 20}}
       (str "Counter is at: " @counter)]
      [:> text {:style {:font-weight :normal
                           :font-size   15
                           :color       :blue}}
       "Built with React Native, Expo, Reagent, re-frame, and React Navigation"]]
     [:> StatusBar {:style "auto"}]]))
