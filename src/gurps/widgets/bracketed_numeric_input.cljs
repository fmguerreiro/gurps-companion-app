(ns gurps.widgets.bracketed-numeric-input
  (:require [gurps.utils.debounce :as debounce]
            [react-native.platform :refer [ios?]]
            [gurps.widgets.base :refer [view text input]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn bracketed-numeric-input
  [{:keys [on-change-text val editable? max-length]
    :or   {editable? true, max-length 3}}]
  [:> view {:style (tw "flex flex-none flex-row items-center justify-center h-7")}
   [:> text {:style (tw "text-xl font-bold h-7")} "["]

   (if editable?
     [:> input {:style #js [(tw "text-xl font-bold min-w-6 bg-slate-100 h-7"), (when ios? (tw "pb-0.5"))]
                :maxLength max-length
                :keyboardType "numeric"
                :textAlign "center"
                :onChangeText (debounce/debounce #(on-change-text (js/parseInt %)) 500)
                :placeholder (str val)}]
     [:> text {:style (tw "text-xl font-bold min-w-6 text-center h-7")} val])

   [:> text {:style (tw "text-xl font-bold h-7")} "]"]])
