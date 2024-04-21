(ns gurps.pages.character.widgets.point-total
  (:require [clojure.string :as str]
            [re-frame.core :as rf]
            [taoensso.timbre :refer [info]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]
            [gurps.utils.helpers :refer [default-to]]))

(defn point-total-field
  [^js {}]
  (let [points (or (some-> (rf/subscribe [:character/point-total]) deref) 0)]
    (info "point-total-field" points)
    [summary-field {:key "point-total" :val points :max-size 2}]))

(rf/reg-sub
 :character/point-total
 (fn [db _]
   (let [costs (vals (merge (:skill-costs db)
                            (:attribute-costs db)))] ;; TODO: other costs
     (reduce + costs))))

(comment
  (def a {:profile {:unspent-points nil, :age nil, :name "Asdasd", :ht nil, :point-total nil, :size-modifier nil, :wt nil, :appearance nil, :player nil},
          :attributes {:ht nil, :dex nil, :int nil, :str 10},
          :attribute-costs {:will "10", :int nil, :per nil, :ht nil, :str 0, :dex nil, :hp "10", :basic-move nil, :basic-speed nil, :fp nil},
          :skill-costs {:acrobatics nil},
          :navigation {:root-state #js {:type "state",
                                        :data #js {:state #js {:stale false, :type "tab", :key "tab-48xoJewgDG1DKnKo-Xzg9", :index 1,
                                                               :routeNames #js ["Skills-Root" "Stats" "Items"],
                                                               :history #js [#js {:type "route", :key "Skills-Root-c6IFb-EXfL9_8qotdOyxi"} #js {:type "route", :key "Stats-a_jDJsn-UzSBjCiXZ2k7X"}], :routes #js [#js {:name "Skills-Root", :key "Skills-Root-c6IFb-EXfL9_8qotdOyxi", :params nil} #js {:name "Stats", :key "Stats-a_jDJsn-UzSBjCiXZ2k7X", :params nil} #js {:name "Items", :key "Items-cCU-vLH2pap8WNOLpELRH", :params nil}]}}}}})

  (reduce + (map js/parseInt (filter number? (vals (:attribute-costs a))))))
