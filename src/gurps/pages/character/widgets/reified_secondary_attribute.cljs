(ns gurps.pages.character.widgets.reified-secondary-attribute
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute-input]]))

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
                              (or (some-> (rf/subscribe [(keyword :attributes based-on)]) deref js/parseInt) 10)))
        current (if has-current? @(rf/subscribe [(keyword :attributes (str (symbol attr) "-current"))]) nil)
        on-change-text (partial update-attribute (keyword :attribute-costs attr))]
    [attribute-input {:attr attr
                      :cost cost
                      :val val
                      :secondary? true
                      :on-change-text on-change-text
                      :has-current-space? (or (= attr :will) (= attr :per))
                      :current current}]))
