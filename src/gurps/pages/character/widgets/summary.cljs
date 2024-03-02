(ns gurps.pages.character.widgets.summary
  (:require [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [styled-view styled-text styled-input]]))

(defn- labelled-input
  [label]
  [:> styled-view {:className "flex flex-row gap-2 flex-auto justify-items-start"}
   [:> styled-text {:className "font-bold"} label]
   [:> styled-input {:className (str "bg-red-100 grow")}]])

(defn- input-group
  [children]
    [:> styled-view {:className "gap-1 flex flex-row items-stretch bg-blue-500"}
     children])

(defn summary
  [^js {}]
  [:> styled-view {:className "flex flex-col gap-1 bg-red-500"}
   (input-group [:<>
                 (labelled-input (i18n/label :t/name))
                 (labelled-input (i18n/label :t/player))
                 (labelled-input (i18n/label :t/point-total))])
   (input-group [:<>
                 (labelled-input (i18n/label :t/ht))
                 (labelled-input (i18n/label :t/wt))
                 (labelled-input (i18n/label :t/size-modifier))
                 (labelled-input (i18n/label :t/age))
                 (labelled-input (i18n/label :t/unspent-points))])
   (input-group (labelled-input (i18n/label :t/appearance)))
   ])
