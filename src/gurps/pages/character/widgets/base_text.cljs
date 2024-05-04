(ns gurps.pages.character.widgets.base-text
  (:require [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.widgets.base :refer [view text]]))

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
    (when cost-per-incr
      (let [added-val (* incr (/ cost cost-per-incr))]
        (+ (js/parseFloat val) added-val)))))

(defn base-text
  [^js {:keys [label value upgradable?]
        :or   {upgradable? false}}]
  (let [cost (if upgradable? (some-> (rf/subscribe [(keyword :attribute-costs (name label))]) deref) 0)]
    [:> view {:style (tw "flex flex-row flex-grow items-center gap-1 bg-indigo-100")}
     [:> text {:style (tw "text-lg font-bold")} (i18n/label label)]
     [:> text {:style (tw "text-lg underline")} (if upgradable? (calc-val label value cost) value)]
     (when upgradable?
       [bracketed-numeric-input {:val            cost
                                 :on-change-text #(rf/dispatch [:attribute-costs/update (name label) %])}])]))
