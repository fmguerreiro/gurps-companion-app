(ns gurps.widgets.underlined-input
  (:require [gurps.widgets.base :refer [input]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn underlined-input
  [{:keys [val on-change-text disabled? style]
    :or   {disabled? false}}]
  [:> input {:style #js [(tw "border-b-2 flex-1"), style]
             :onChangeText on-change-text
             :placeholder (str val)
             :editable (not disabled?)}
   val])
