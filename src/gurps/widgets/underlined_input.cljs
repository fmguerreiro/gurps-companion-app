(ns gurps.widgets.underlined-input
  (:require [gurps.widgets.base :refer [view text input]]
            ["twrnc" :refer [style] :rename {style tw}]
            [reagent.core :as r]
            [clojure.string :as str]))

(defn underlined-input
  [{:keys [val on-change-text disabled? style capitalize? input-mode max-length text-align clear-on-input? get-ref on-press]
    :or   {disabled? false, capitalize? true, input-mode "text", max-length nil, text-align "left", clear-on-input? false}}]
  (let [ref (atom nil)]
    [:> input {:style #js [(tw "border-b-2 flex-1"), style]
               :onChangeText on-change-text
               :onPressIn on-press
               :ref (fn [r]
                      (reset! ref r)
                      (when get-ref (get-ref r)))
               :placeholder (str val)
               :editable (not disabled?)
               :inputMode input-mode
               :maxLength max-length
               :textAlign text-align
               :autoCapitalize (if capitalize? "sentences" "none")}
     (when (not clear-on-input?) val)]))

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

(defn labelled-underlined-input
  [{:keys [label val on-change-text disabled? style label-style input-style capitalize? text-align]
    :or   {disabled? false, capitalize? true}}]
  [:> view {:style #js [(tw "flex flex-row gap-1 items-end h-5"), style]}
   [:> text {:style #js [(tw "capitalize font-bold"), label-style]} label]
   [underlined-input {:val            val
                      :on-change-text on-change-text
                      :disabled?      disabled?
                      :style          input-style
                      :text-align     text-align
                      :capitalize?    capitalize?}]])

(defn labelled-multiline-underlined-input
  [{:keys [label val on-change-text disabled? style n-lines]
    :or   {disabled? false, n-lines 1}}]
  (r/with-let [vals (str/split-lines val)]
    [:> view {:style (tw "flex flex-col gap-1")}
     [labelled-underlined-input {:label label :val (get-in vals [0] "") :on-change-text on-change-text :disabled? disabled?}]
     (when (> n-lines 1)
       [multiline-underlined-input {:val (str/join "\n" (rest vals)) :on-change-text on-change-text :disabled? disabled? :style style :n-lines (dec n-lines)}])]))
