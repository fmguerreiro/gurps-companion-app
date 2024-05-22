(ns gurps.widgets.character-icon
  (:require ["twrnc" :refer [style] :rename {style tw}]
            [re-frame.core :as rf]
            [gurps.widgets.base :refer [view image]]
            ;; NOTE: making sure we have our events registered
            [gurps.events.profile]))

(defn character-icon
  []
  (when-let [portrait-img (some-> (rf/subscribe [:profile/portrait]) deref)]
    [:> view {:style (tw "flex items-center justify-center")}
     [:> image {:style (tw "w-8 h-8 rounded-full")
                :source {:uri portrait-img}}]]))
