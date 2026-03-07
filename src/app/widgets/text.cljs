(ns app.widgets.text
  (:require [app.widgets.base :refer [text]]
            [clojure.string :as str]))

(def ^:private tabbed-text-tab "  ")

(defn tabbed-text
  "A text widget with tabs on each new line."
  [content]
  (let [content' (->> content
                      (str/split-lines)
                      (map #(str tabbed-text-tab %))
                      (str/join "\n"))]
    [:> text content']))
