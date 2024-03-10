(ns gurps.pages.character.widgets.basic
  (:require [gurps.widgets.base :refer [view text input]]
            [reagent.core :as r]
            [re-frame.core :as rf]))

(defn basic
  [^js {:keys [label value upgradable?]
        :or {upgradable? false}}]
  [:> view {:className "flex flex-row flex-grow align-items-center"}
   [:> text {:className "text-xl text-bold"} label]
   [:> text {:className "underline"} value]
   (when upgradable?
     [:> input {:className "bg-slate-200"} "[  ]"])])
