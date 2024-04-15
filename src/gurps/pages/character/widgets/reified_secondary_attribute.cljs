(ns gurps.pages.character.widgets.reified-secondary-attribute
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute]]))

(def point-per-cost
  {:hp   2
   :will 5
   :per  5
   :fp   3})

(defn reified-secondary-attribute
  [^js {:keys [attr based-on has-current?]
        :or   {has-current? false}}]
  (let [cost @(rf/subscribe [(keyword :attribute-costs attr)])
        val (js/Math.floor (+ (/ (default-to cost 0) (attr point-per-cost))
                              (js/parseInt (default-to @(rf/subscribe [(keyword :attributes based-on)]) 10))))
        current (if has-current? @(rf/subscribe [(keyword :attributes (str (symbol attr) "-current"))]) nil)
        on-change-text (partial update-attribute (keyword :attribute-costs attr))]
    [attribute {:attr attr
                :cost cost
                :val val
                :secondary? true
                :on-change-text on-change-text
                :current current}]))
