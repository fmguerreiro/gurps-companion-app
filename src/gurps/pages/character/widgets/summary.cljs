(ns gurps.pages.character.widgets.summary
  (:require [gurps.utils.i18n :as i18n]
            [gurps.utils.debounce :as debounce]
            [gurps.widgets.base :refer [view text input]]
            [re-frame.core :as rf]))

(defn- labelled-input
  [^js {:keys [key max-size]
        :or   {max-size "max"}}]
  (let [value (rf/subscribe [(keyword "profile" key)])]
    (js/console.log @value)
    [:> view {:className "flex flex-row gap-2 justify-items-start flex-grow"}
     [:> text {:className "font-bold"} (i18n/label (keyword "t" key))]
     [:> input {:className (str "flex-grow border-b-2")
                :defaultValue @value
                :onChangeText #(debounce/debounce-and-dispatch
                                [:profile/update key %] 1000)}]]))

(defn- input-group
  [children]
  [:> view {:className "gap-1 flex flex-row items-stretch"}
   children])

(defn summary
  [^js {}]
  [:> view {:className "flex flex-col"}
   [input-group [:<>
                 [labelled-input {:key "name"}]
                 [labelled-input {:key "player"}]
                 [labelled-input {:key "point-total", :max-size 2}]]]
   [input-group [:<>
                 [labelled-input {:key "ht", :max-size 2}]
                 [labelled-input {:key "wt", :max-size 2}]
                 [labelled-input {:key "size-modifier", :max-size 2}]
                 [labelled-input {:key "unspent-points", :max-size 2}]]]
   [input-group [:<>
                 [labelled-input {:key "age", :max-size 2}]
                 [labelled-input {:key "appearance"}]]]])
