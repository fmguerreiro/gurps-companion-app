(ns gurps.pages.character.widgets.helpers
  (:require [re-frame.core :as rf]
            [react-native.async-storage :as async-storage]))

(defn update-attribute
  [label value]
  (let [int-val (js/parseInt value)
        callback #(rf/dispatch [:attrs/update label int-val])]
    (async-storage/set-item! label int-val callback)))
