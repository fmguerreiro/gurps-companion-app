(ns gurps.pages.character.widgets.reified-secondary-attribute
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute]]))

(def point-per-cost
  {:t/attr-hitpoints 2
   :t/attr-will 5
   :t/attr-perception 5
   :t/attr-fatigue 3})

(defn reified-secondary-attribute
  [^js {:keys [attr based-on has-current?]
        :or   {has-current? false}}]
  (let [key-val (keyword "t" (str "attr-" based-on))
        key-attr (keyword "t" (str "attr-" attr))
        key-cost (keyword "t" (str "attr-" attr "-cost"))
        key-current (keyword "t" (str "attr-" attr "-current"))
        cost @(rf/subscribe [key-cost])
        val (js/Math.floor (+ (/ (default-to cost 0) (key-attr point-per-cost))
                              (js/parseInt (default-to @(rf/subscribe [key-val]) 10))))
        current (if has-current? @(rf/subscribe [key-current]) nil)
        on-change-text (partial update-attribute key-cost)]
    [attribute {:label key-attr
                :cost cost
                :val val
                :secondary? true
                :on-change-text on-change-text
                :current current}]))
