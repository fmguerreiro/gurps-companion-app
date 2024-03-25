(ns gurps.db)

;; initial state of app-db
(defonce app-db {:counter 0
                 :counter-tappable? true

                 :attributes {:strength 10
                              :dexterity 10
                              :intelligence 10
                              :health 10

                              :hp-cost 0
                              :will-cost 0
                              :per-cost 0
                              :fp-cost 0}

                 :skills {}

                 :t/attr-strength 10
                 :t/attr-dexterity 10
                 :t/attr-intelligence 10
                 :t/attr-health 10
                 :t/attr-hitpoints-cost 0
                 :t/attr-will-cost 0
                 :t/attr-perception-cost 0
                 :t/attr-fatigue-cost 0})
