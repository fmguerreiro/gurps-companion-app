(ns gurps.db)

;; initial state of app-db
(defonce app-db
  {:attributes {:str 10
                :dx 10
                :int 10
                :ht 10}

   :attribute-costs {:hp 0
                     :will 0
                     :per 0
                     :fp 0}

   :skill-costs {:acrobatics 10}

;; TODO remove
   :t/attr-strength 10
   :t/attr-dexterity 10
   :t/attr-intelligence 10
   :t/attr-health 10
   :t/attr-hitpoints-cost 0
   :t/attr-will-cost 0
   :t/attr-perception-cost 0
   :t/attr-fatigue-cost 0
   ;;
   })
