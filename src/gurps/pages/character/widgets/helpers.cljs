(ns gurps.pages.character.widgets.helpers
  (:require [re-frame.core :as rf]))

;; TODO: stop using this
(defn update-attribute
  [label value]
  (let [int-val (js/parseInt value)]
    (rf/dispatch [:attrs/update label int-val])))
