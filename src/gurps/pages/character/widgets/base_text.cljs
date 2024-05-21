(ns gurps.pages.character.widgets.base-text
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [gurps.utils.i18n :as i18n]
            ["twrnc" :refer [style] :rename {style tw}]
            [gurps.widgets.bracketed-numeric-input :refer [bracketed-numeric-input]]
            [gurps.widgets.base :refer [view text]]))

(defonce cost-to-point
  {:basic-move {:cost 5 :incr 1}
   :basic-speed {:cost 1 :incr 0.05}})

(defn calc-val
  [attr val cost]
  (let [cost-per-incr (get-in cost-to-point [attr :cost])
        incr          (get-in cost-to-point [attr :incr])]
    (when cost-per-incr
      (let [added-val (* incr (/ cost cost-per-incr))]
        (+ (js/parseFloat val) added-val)))))

(defn base-text
  [^js {:keys [attr upgradable?]
        :or   {upgradable? false}}]
  (let [value (or (some-> (rf/subscribe [(keyword :attributes attr)]) deref) 0)
        cost  (if upgradable? (some-> (rf/subscribe [(keyword :attribute-costs attr)]) deref) 0)]
    [:> view {:style (tw "flex flex-row flex-grow items-center gap-1")}
     [:> text {:style (tw "text-lg font-bold")} (i18n/label (keyword :t attr))]
     [:> text {:style (tw "text-lg underline")} (if upgradable? (calc-val attr value cost) value)]
     (when upgradable?
       [bracketed-numeric-input {:val            cost
                                 :on-change-text #(rf/dispatch [:attribute-costs/update attr (js/parseInt %)])}])]))
