(ns gurps.pages.character.widgets.summary
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.point-total :refer [point-total-field unspent-points-field]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn- input-group
  [{:keys [key style]} & children]
  [:> view {:key key :style #js [(tw "flex flex-row flex-1 gap-2"), style]}
   children])

(defn summary-group
  []
  [:> view {:style (tw "flex flex-col gap-1")}
   [input-group {:key "summary-1"}
    ^{:key "summary-name"}
    [:> view {:style (tw "flex-1.6")}
     [summary-field {:key :name}]]

    ^{:key "summary-point-total"}
    [:> view {:style (tw "min-w-32")}
     [point-total-field]]]

   [input-group {:key "summary-2" :style (tw "justify-end")}

    ^{:key "summary-player"}
    [:> view {:style (tw "flex-1.6")}
     [summary-field {:key :player}]]

    ^{:key "summary-unspent-points"}
    [:> view {:style (tw "min-w-32")}
     [unspent-points-field]]]])

;; [input-group {:key "summary-2"}
   ;;  ^{:key "summary-ht"} [summary-field {:key :ht, :style (tw "max-w-12")}]
   ;;  ^{:key "summary-wt"} [summary-field {:key :wt, :style (tw "max-w-12")}]
   ;;  ;; TODO: [summary-field {:key :size-modifier}]
   ;;  ^{:key "summary-unspent-points"} [unspent-points-field]]

   ;; [input-group {:key "summary-3"}
   ;;  ^{:key "summary-age"} [summary-field {:key :age, :style (tw "max-w-14")}]
   ;;  ^{:key "summary-appearance"} [summary-field {:key :appearance}]]

;; [input-group [:<>
   ;;               [summary-field {:key "ht", :max-size 2}]
   ;;               [summary-field {:key "wt", :max-size 2}]
   ;;               [summary-field {:key "size-modifier", :max-size 2}]
   ;;               [summary-field {:key "unspent-points", :max-size 2}]]]
   ;; [input-group [:<>
   ;;               [summary-field {:key "age", :max-size 2}]
   ;;               [summary-field {:key "appearance"}]]]
