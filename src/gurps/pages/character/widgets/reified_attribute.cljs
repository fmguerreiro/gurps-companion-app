(ns gurps.pages.character.widgets.reified-attribute
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
            [gurps.pages.character.widgets.helpers :refer [update-attribute]]
            [gurps.pages.character.widgets.attribute :refer [attribute]]))

(defn reified-attribute
  [^js {:keys [attr]}]
  (let [key      (keyword "t" (str "attr-" attr))
        key-cost (keyword "t" (str "attr-" attr "-cost"))
        val      @(rf/subscribe [key])
        on-change-text (partial update-attribute key)]
    [attribute {:label key
                :val val
                :on-change-text on-change-text}]))
