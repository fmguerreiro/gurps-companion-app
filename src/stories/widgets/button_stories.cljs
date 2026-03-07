(ns stories.widgets.button-stories
  (:require [reagent.core :as r]
            [app.widgets.button :refer [button]]))

(def ^:export default
  #js {:title "Widgets/Button"
       :component (r/reactify-component
                   (fn [] [button {:on-press #(js/alert "Pressed!")} "Example"]))})

(defn ^:export Primary []
  (r/as-element
   [button {:on-press #(js/alert "Primary pressed!")} "Primary"]))

(defn ^:export Disabled []
  (r/as-element
   [button {:on-press #() :disabled? true} "Disabled"]))

(defn ^:export CustomStyle []
  (r/as-element
   [button {:on-press #(js/alert "Custom!")
            :style {:background-color :green}
            :text-style {:font-size 14}} "Custom Style"]))
