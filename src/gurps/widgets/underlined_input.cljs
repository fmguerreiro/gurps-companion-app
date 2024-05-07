(ns gurps.widgets.underlined-input
  (:require [gurps.widgets.base :refer [view input]]
            ["twrnc" :refer [style] :rename {style tw}]
            [reagent.core :as r]
            [clojure.string :as str]))

(defn underlined-input
  [{:keys [val on-change-text disabled? style capitalize?]
    :or   {disabled? false, capitalize? true}}]
  [:> input {:style #js [(tw "border-b-2 flex-1"), style]
             :onChangeText on-change-text
             :placeholder (str val)
             :editable (not disabled?)
             :autoCapitalize (if capitalize? "sentences" "none")}
   val])

(defn multiline-underlined-input
  [{:keys [val on-change-text disabled? style n-lines]
    :or   {disabled? false, n-lines 1}}]
  (r/with-let [vals (str/split-lines val)]
    [:> view {:style #js [(tw "flex flex-col gap-1"), style]}
     (for [line (range n-lines)]
       ^{:key (str "line-" line)}
       [underlined-input {:val            (get-in vals [line] "")
                          :on-change-text #(on-change-text line %)
                          :capitalize?    (= 0 line)
                          :disabled?      disabled?}])]))
