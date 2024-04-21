(ns gurps.pages.character.widgets.summary
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.point-total :refer [point-total-field]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn- input-group
  [children]
  [:> view {:className "gap-1 flex flex-row items-stretch"}
   children])

(defn summary-group
  [^js {}]
  [:> view {:className "flex flex-col"}
   [input-group [:<>
                 [summary-field {:key "name"}]
                 ;; [summary-field {:key "player"}]
                 [point-total-field]]

   ;; [input-group [:<>
   ;;               [summary-field {:key "ht", :max-size 2}]
   ;;               [summary-field {:key "wt", :max-size 2}]
   ;;               [summary-field {:key "size-modifier", :max-size 2}]
   ;;               [summary-field {:key "unspent-points", :max-size 2}]]]
   ;; [input-group [:<>
   ;;               [summary-field {:key "age", :max-size 2}]
   ;;               [summary-field {:key "appearance"}]]]
    ]])
