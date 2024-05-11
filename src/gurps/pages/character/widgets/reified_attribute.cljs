(ns gurps.pages.character.widgets.reified-attribute
  (:require [re-frame.core :as rf]
            [gurps.utils.helpers :refer [default-to]]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute-input]]))

(def cost-per-point
  {:str 10
   :dex 20
   :int 20
   :ht  10})

(defn- calc-cost [attr value]
  (let [incr (attr cost-per-point)
        val  (default-to value 10)]
    (* incr (- val 10))))

(defn reified-attribute
  [^js {:keys [attr]}]
  (let [key      (keyword :attributes attr)
        key-cost (keyword :attribute-costs attr)
        val      (some-> (rf/subscribe [key]) deref)
        on-change-text (fn [text]
                         (let [parsed (js/parseInt text)
                               v (if (js/isNaN parsed) 10 parsed)]
                           (update-attribute key v)
                           (update-attribute key-cost (calc-cost attr v))))]
    [attribute-input {:attr attr
                      :val val
                      :on-change-text on-change-text}]))
