(ns gurps.pages.character.widgets.summary
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.point-total :refer [point-total-field unspent-points-field]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn- input-group
  [{:keys [key]} & children]
  [:> view {:key key :style (tw "flex flex-row flex-1 gap-2")}
   children])

(defn summary-group
  []
  [:> view {:style (tw "flex flex-col gap-1")}
   [input-group {:key "summary-1"}
    ^{:key "summary-name"} [summary-field {:key :name}]
    ^{:key "summary-player"} [summary-field {:key :player}]
    ^{:key "summary-point-total"} [point-total-field]]

   [input-group {:key "summary-2"}
    ^{:key "summary-ht"} [summary-field {:key :ht, :style (tw "max-w-12")}]
    ^{:key "summary-wt"} [summary-field {:key :wt, :style (tw "max-w-12")}]
    ;; TODO: [summary-field {:key :size-modifier}]
    ^{:key "summary-unspent-points"} [unspent-points-field]]

   [input-group {:key "summary-3"}
    ^{:key "summary-age"} [summary-field {:key :age, :style (tw "max-w-14")}]
    ^{:key "summary-appearance"} [summary-field {:key :appearance}]]])

;; [input-group [:<>
   ;;               [summary-field {:key "ht", :max-size 2}]
   ;;               [summary-field {:key "wt", :max-size 2}]
   ;;               [summary-field {:key "size-modifier", :max-size 2}]
   ;;               [summary-field {:key "unspent-points", :max-size 2}]]]
   ;; [input-group [:<>
   ;;               [summary-field {:key "age", :max-size 2}]
   ;;               [summary-field {:key "appearance"}]]]
