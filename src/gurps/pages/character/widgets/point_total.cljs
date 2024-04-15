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
   (let [costs (vals (merge (:skill-costs db)
                            (:attribute-costs db)))] ;; TODO: other costs
     (reduce + costs))))
