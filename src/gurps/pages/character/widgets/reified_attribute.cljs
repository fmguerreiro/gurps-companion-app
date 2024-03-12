(ns gurps.pages.character.widgets.reified-attribute
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute]]))

(def cost-per-point
  {:t/attr-strength 10
   :t/attr-dexterity 20
   :t/attr-intelligence 20
   :t/attr-health 10})

(defn- calc-cost [label value]
  (let [incr (label cost-per-point)
        val  (default-to value 10)]
    (* incr (- val 10))))

(defn reified-attribute
  [^js {:keys [attr]}]
  (let [key      (keyword "t" (str "attr-" attr))
        key-cost (keyword "t" (str "attr-" attr "-cost"))
        val      @(rf/subscribe [key])
        on-change-text (fn [v]
                         (update-attribute key v)
                         (update-attribute key-cost (calc-cost key v)))]
    [attribute {:label key
                :val val
                :on-change-text on-change-text}]))
