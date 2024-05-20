(ns gurps.pages.character.widgets.point-total
  (:require [taoensso.timbre :refer [info]]
            [re-frame.core :as rf]
            [gurps.pages.character.widgets.summary-field :refer [summary-field]]))

(defn point-total-field
  []
  [summary-field {:key :point-total, :editable? false}])

(rf/reg-sub
 :profile/point-total
 (fn [db]
   (let [costs (+ (->> db :attribute-costs vals (reduce +))
                  (->> db :skills (map :cost) (reduce +))
                  (->> db :languages (filter #(not (:native? %))) (map :cost) (reduce +)))]
     (or costs 0))))

(defn unspent-points-field
  [style]
  [summary-field {:key :unspent-points, :style style}])

(rf/reg-sub
 :profile/unspent-points
 (fn [db]
   (get-in db [:profile :unspent-points] 0)))

(comment
  ;; TODO: move this somewhere else/delete?
  (def a {:profile {:unspent-points nil, :age nil, :name "Asdasd", :ht nil, :point-total nil, :size-modifier nil, :wt nil, :appearance nil, :player nil},
          :attributes {:ht nil, :dex nil, :int nil, :str 10},
          :attribute-costs {:will "10", :int nil, :per nil, :ht nil, :str 0, :dex nil, :hp "10", :basic-move nil, :basic-speed nil, :fp nil},
          :skill-costs {:acrobatics nil},
          :navigation {:root-state #js {:type "state",
                                        :data #js {:state #js {:stale false, :type "tab", :key "tab-48xoJewgDG1DKnKo-Xzg9", :index 1,
                                                               :routeNames #js ["Skills-Root" "Stats" "Items"],
                                                               :history #js [#js {:type "route", :key "Skills-Root-c6IFb-EXfL9_8qotdOyxi"} #js {:type "route", :key "Stats-a_jDJsn-UzSBjCiXZ2k7X"}], :routes #js [#js {:name "Skills-Root", :key "Skills-Root-c6IFb-EXfL9_8qotdOyxi", :params nil} #js {:name "Stats", :key "Stats-a_jDJsn-UzSBjCiXZ2k7X", :params nil} #js {:name "Items", :key "Items-cCU-vLH2pap8WNOLpELRH", :params nil}]}}}}})

  (reduce + (map js/parseInt (filter number? (vals (:attribute-costs a))))))
