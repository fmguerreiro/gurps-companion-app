(ns gurps.pages.character.widgets.reified-secondary-attribute
  (:require [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute-input]]))

(def point-per-cost
  {:hp   2
   :will 5
   :per  5
   :fp   3})

(defn- calc-attr-val
  [attr cost based-on-val]
  (js/Math.floor
   (+ (/ (default-to cost 0) (attr point-per-cost))
      based-on-val)))

(defn reified-secondary-attribute
  [^js {:keys [attr based-on has-current?]
        :or   {has-current? false}}]
  (let [cost           (some-> (rf/subscribe [(keyword :attribute-costs attr)]) deref)
        based-on-val   (or (some-> (rf/subscribe [(keyword :attributes based-on)]) deref js/parseInt) 10)
        val            (calc-attr-val attr cost based-on-val)
        current        (when has-current? (or (some-> (rf/subscribe [(keyword :attribute-current attr)]) deref) val))
        on-change-text (partial update-attribute (keyword :attribute-costs attr))]
    [attribute-input {:attr attr
                      :cost cost
                      :val val
                      :secondary? true
                      :on-change-text on-change-text
                      :current current}]))
