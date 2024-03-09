(ns gurps.pages.character.widgets.attributes
  (:require [gurps.widgets.base :refer [view]]
            [gurps.pages.character.widgets.attribute :refer [attribute]]
            [gurps.pages.character.widgets.events]))

(defn attributes []
  [:> view {:className "flex flex-row gap-0"}
   [:> view {:className "flex flex-col"}
    [attribute {:label :t/attr-strength :add-current-space? false}]
    [attribute {:label :t/attr-dexterity :add-current-space? false}]
    [attribute {:label :t/attr-intelligence :add-current-space? false}]
    [attribute {:label :t/attr-health :add-current-space? false}]]
   [:> view {:className "flex flex-col"}
    [attribute {:label :t/attr-hitpoints :current 11}]
    [attribute {:label :t/attr-will}]
    [attribute {:label :t/attr-perception}]
    [attribute {:label :t/attr-fatigue :current 11}]]])
