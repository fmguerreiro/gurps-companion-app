(ns gurps.pages.character.widgets.basic
  (:require [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [view text input]]))

(defonce cost-to-point
  {:t/basic-move {:cost 5 :incr 1}
   :t/basic-speed {:cost 1 :incr 0.05}})

(defn add-suffix-to-keyword [kw suffix]
  (let [name (name kw)
        namespace (namespace kw)]
    (keyword (str namespace "/" name suffix))))

(defn calc-val
  [label val cost]
  (let [cost-per-incr (get-in cost-to-point [label :cost])
        incr (get-in cost-to-point [label :incr])]
    (if cost-per-incr
      (let [added-val (* incr (/ cost cost-per-incr))]
        (+ (js/parseFloat val) added-val)))))

(defn basic
  [^js {:keys [label value upgradable?]
        :or   {upgradable? false}}]
  (let [cost (if upgradable? @(rf/subscribe [(keyword :attribute-costs (name label))]) 0)]
    [:> view {:className "flex flex-row flex-grow align-items-center gap-1 ml-0 mt-0"} ;; NOTE: ml-0 mt-0 counters the effects of gap-1
     [:> text {:className "text-xl text-bold"} (i18n/label label)]
     [:> text {:className "text-xl underline"} (if upgradable? (calc-val label value cost) value)]
     (when upgradable?
       [:> view {:className "flex flex-row items-center justify-items-center align-items-center"}
        [:> text "["]
        ; [:> input {:keyboardType "numeric"
        ;            :maxLength 3
        ;            :className "bg-slate-200"} cost]
        [:> text "]"]])]))
