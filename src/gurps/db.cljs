(ns gurps.db)

;; initial state of app-db
;; TODO: write spec
(defonce app-db
  {:profile {:name ""
             :player ""
             :portrait nil
             :point-total 0
             :ht nil
             :wt nil
             :size-modifier nil
             :unspent-points 150
             :age nil
             :appearance ""}

   :attributes {:str 10
                :dex 10
                :int 10
                :ht 10}

   :attribute-costs {:hp 0
                     :will 0
                     :per 0
                     :fp 0

                     :basic-move 0
                     :basic-speed 0

                     :str 0
                     :dex 0
                     :int 0
                     :ht 0}

   :attribute-current {:hp 0
                       :fp 0}

   :skill-costs {:acrobatics 10}

   ;; for reloading state on app re-start
   :navigation {:root-state #js {}}})

(comment (reduce + (vals (merge (:skill-costs app-db) (:attribute-costs app-db)))))
