(ns gurps.pages.character.widgets.summary-field
  (:require [taoensso.timbre :refer [info]]
            [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text]]
            [gurps.widgets.underlined-input :refer [underlined-input]]
            [re-frame.core :as rf]
            ["twrnc" :refer [style] :rename {style tw}]
            [clojure.string :as str]))

(defn summary-field
  [{:keys [key editable? style on-change-text]
    :or   {editable? true, on-change-text identity}}]
  (let [val (some-> (rf/subscribe [(keyword :profile key)]) deref)]
    [:> view {:key key
              :style #js [style, (tw (str/join " " ["flex-row gap-1" (if editable? "flex-1" "flex-initial")]))]}

     ;; label
     [:> text {:key (str key "-label")
               :style (tw "font-bold")}
      (i18n/label (keyword :t key))]

     ;; input
     (if editable?
       [underlined-input {:val val
                          :on-change-text #(debounce/debounce-and-dispatch [:profile/update key (on-change-text %)] 800)}]
       [:> text val])]))
