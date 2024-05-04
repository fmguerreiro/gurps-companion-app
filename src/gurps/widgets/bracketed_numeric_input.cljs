(ns gurps.widgets.bracketed-numeric-input
  (:require [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn bracketed-numeric-input
  [{:keys [on-change-text val editable?]}]
  [:> view {:style (tw "flex flex-1 flex-row items-center justify-center")}
   [:> text {:style (tw "text-xl font-bold")} "["]

   (if editable?
     [:> input {:style (tw "text-xl font-bold bg-slate-200 min-w-6 text-center")
                :maxLength 3
                :keyboardType "numeric"
                :onChangeText (debounce/debounce #(on-change-text %) 500)
                :placeholder val}]
     [:> text {:style (tw "text-xl font-bold min-w-6 text-center")} val])

   [:> text {:style (tw "text-xl font-bold")} "]"]])
