(ns gurps.pages.character.widgets.summary
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.point-total :refer [point-total-field]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]
            ["twrnc" :refer [style] :rename {style tw}]))

(defn- input-group
  [{:keys [key]} & children]
  [:> view {:key key :style (tw "flex flex-row flex-1 bg-green-100")}
   children])

(defn summary-group
  []
  [:> view {:style (tw "flex flex-col")}
   [input-group {:key "summary-1"}
    ^{:key "summary-name"} [summary-field {:key :name}]
    ^{:key "summary-player"} [summary-field {:key :player}]
    ^{:key "summary-point-total"} [point-total-field]]

   [input-group {:key "summary-2"}
    ^{:key "summary-ht"} [summary-field {:key :ht}]
    ^{:key "summary-wt"} [summary-field {:key :wt}]
    ;; TODO: [summary-field {:key :size-modifier}]
    ^{:key "summary-unspent-points"} [summary-field {:key :unspent-points}]]

   [input-group {:key "summary-3"}
    ^{:key "summary-unspent-points"} [summary-field {:key :age}]
    ^{:key "summary-appearance"} [summary-field {:key :appearance}]]])

;; [input-group [:<>
   ;;               [summary-field {:key "ht", :max-size 2}]
   ;;               [summary-field {:key "wt", :max-size 2}]
   ;;               [summary-field {:key "size-modifier", :max-size 2}]
   ;;               [summary-field {:key "unspent-points", :max-size 2}]]]
   ;; [input-group [:<>
   ;;               [summary-field {:key "age", :max-size 2}]
   ;;               [summary-field {:key "appearance"}]]]
