(ns gurps.pages.character.widgets.summary
  (:require [gurps.utils.i18n :as i18n]
            [gurps.widgets.base :refer [styled-view styled-text styled-input]]))

(defn- labelled-input
  ([label] (labelled-input label "max"))
  ([label max-size]
   [:> styled-view {:className "flex flex-row gap-2 justify-items-start flex-grow"}
    [:> styled-text {:className "font-bold"} label]
    [:> styled-input {:className (str "flex-grow border-b-2")}]]))

(defn- input-group
  [children]
  [:> styled-view {:className "gap-1 flex flex-row items-stretch"}
   children])

(defn summary
  [^js {}]
  [:> styled-view {:className "flex flex-col"}
   (input-group [:<>
                 (labelled-input (i18n/label :t/name))
                 (labelled-input (i18n/label :t/player))
                 (labelled-input (i18n/label :t/point-total) 2)])
   (input-group [:<>
                 (labelled-input (i18n/label :t/ht) 2)
                 (labelled-input (i18n/label :t/wt) 2)
                 (labelled-input (i18n/label :t/size-modifier) 2)
                 (labelled-input (i18n/label :t/unspent-points) 2)])
   (input-group [:<>
                 (labelled-input (i18n/label :t/age) 2)
                 (labelled-input (i18n/label :t/appearance))])])
