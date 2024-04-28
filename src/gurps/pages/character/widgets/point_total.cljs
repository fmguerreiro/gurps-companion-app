(ns gurps.pages.character.widgets.point-total
  (:require [re-frame.core :as rf]
            [taoensso.timbre :refer [info]]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn point-total-field
  []
  [summary-field {:key :point-total
                  :editable? false}])

(rf/reg-sub
 :profile/point-total
 (fn [db]
   (let [costs (vals (merge (:skill-costs db)
                            (:attribute-costs db)))] ;; TODO: other costs
     (or (reduce + costs) 0))))

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
