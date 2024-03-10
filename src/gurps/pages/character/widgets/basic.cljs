(ns gurps.pages.character.widgets.basic
  (:require [gurps.widgets.base :refer [view text input]]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn basic
  [^js {:keys [label value upgradable?]
        :or {upgradable? false}}]
  [:> view {:className "flex flex-row flex-grow align-items-center gap-1 ml-0 mt-0"} ;; NOTE: ml-0 mt-0 counters the effects of gap-1
   [:> text {:className "text-xl text-bold"} label]
   [:> text {:className "text-xl underline"} value]
   (when upgradable?
     [:> view {:className "flex flex-row items-center justify-items-center align-items-center"}
      [:> text "["]
      [:> input {:keyboardType "numeric"
                 :className "bg-slate-200"} 0] ;; TODO cost
      [:> text "]"]])])
