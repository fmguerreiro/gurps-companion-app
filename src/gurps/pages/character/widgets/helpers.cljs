(ns gurps.pages.character.widgets.helpers
  (:require [re-frame.core :as rf]
            [react-native.async-storage :as async-storage]))

(defn update-attribute
  [label value]
  (let [callback #(rf/dispatch [:attrs/update label (js/parseInt value)])]
    (async-storage/set-item! label value callback)))
