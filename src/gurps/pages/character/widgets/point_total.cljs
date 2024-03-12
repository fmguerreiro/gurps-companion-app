(ns gurps.pages.character.widgets.point-total
  (:require [clojure.string :as str]
            [re-frame.core :as rf]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]
            [gurps.utils.helpers :refer [default-to]]))

(defn point-total
  [^js {}]
  (let [points @(rf/subscribe [:character/point-total])]
    [summary-field {:key "point-total" :val points :max-size 2}]))

(rf/reg-sub
 :character/point-total
 (fn [db _]
   (let [cost-keys (filter #(str/ends-with? (str %) "-cost") (keys db))]
     (js/console.log "character/point-total" (str/join " " (map str cost-keys)))
     (reduce + (map #(js/parseInt (default-to (get db %) 0)) cost-keys)))))
