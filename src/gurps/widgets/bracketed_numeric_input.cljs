(ns gurps.widgets.bracketed-numeric-input
  (:require [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn bracketed-numeric-input
  [{:keys [on-change-text val editable?]
    :or   {editable? true}}]
  [:> view {:style (tw "flex flex-1 flex-row items-center justify-center")}
   [:> text {:style (tw "text-xl font-bold")} "["]

   (if editable?
     [:> input {:style (tw "text-xl font-bold min-w-6 pb-1 bg-slate-200")
                :maxLength 3
                :keyboardType "numeric"
                :textAlign "center"
                :onChangeText (debounce/debounce #(on-change-text (js/parseInt %)) 500)
                :placeholder (str val)}]
     [:> text {:style (tw "text-xl font-bold min-w-6 text-center")} val])

   [:> text {:style (tw "text-xl font-bold")} "]"]])
