(ns gurps.pages.character.widgets.helpers
  (:require [re-frame.core :as rf]))

;; TODO: stop using this
(defn update-attribute
  [label value]
  (let [int-val (js/parseInt value)]
    (rf/dispatch [:attrs/update label int-val])))

(defn generify-key
  "Generates a generic keyword from the given keyword.
   If the input keyword has a namespace, it returns a keyword with the same namespace and the symbol :sp.
   Otherwise, it returns the input keyword unchanged."
  [k]
  (if (namespace k) (keyword (namespace k) :sp) k))
