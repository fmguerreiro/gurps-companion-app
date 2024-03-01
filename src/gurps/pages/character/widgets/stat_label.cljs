(ns gurps.pages.character.widgets.stat-label
  (:require ["nativewind" :as nw]
            ["react-native" :as rn]))

(def styled-view (nw/styled rn/View))
(def styled-text (nw/styled rn/Text))

(defn stat-label
  [^js {:keys [label value current cost]
        :or   {current value cost 0}}]
  [:> styled-view {:className "flex-row"}
   [:> styled-text {:className "text-xl color-blue-500"} label]
   [:> styled-view {:className "box-border border-4 p-4 h-32 w-32"}
    [:> styled-text {:className "text-xl color-blue-500"} (str " " value)]
    ]
   [:> styled-text {:className "text-xl color-blue-500"} (str " (" current ")")]
   [:> styled-text {:className "text-xl color-blue-500"} (str " [" cost "]")]])
