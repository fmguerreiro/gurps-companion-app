(ns gurps.db
  (:require [cljs.spec.alpha :as s]))

;; (s/def ::todos (s/and                                       ;; should use the :kind kw to s/map-of (not supported yet)
;;                 (s/map-of ::id ::todo)                      ;; in this map, each todo is keyed by its :id
;;                 #(instance? PersistentTreeMap %)))            ;; is a sorted-map (not just a map)

;; (s/def ::showing                                            ;; what todos are shown to the user?
;;   #{:all                                                    ;; all todos are shown
;;     :active                                                 ;; only todos whose :done is false
;;     :done})                                                   ;; only todos whose :done is true

;; TODO: finish writing spec
(s/def ::name string?)
(s/def ::player string?)
(s/def ::portrait string?)
(s/def ::point-total number?)
(s/def ::ht string?)
(s/def ::wt string?)
(s/def ::size-modifier number?)
(s/def ::unspent-points number?)
(s/def ::age number?)
(s/def ::appearance string?)
(s/def ::notes string?)
(s/def ::profile (s/keys :req-un [::name ::player ::portrait ::point-total ::ht ::wt ::size-modifier ::unspent-points ::age ::appearance ::notes]))
(s/def ::db
  (s/keys :req-un [::profile ::attributes ::attribute-costs ::attribute-current ::skill-costs ::languages ::navigation]))

;; initial state of app-db
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
             :appearance ""
             :notes ""}

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

   :languages {:0 {:i 0 :name "" :spoken "native", :written "native", :native? true , :cost 0}
               :1 {:i 1 :name "" :spoken "broken", :written "broken", :native? false, :cost 0}
               :2 {:i 2 :name "" :spoken "broken", :written "broken", :native? false, :cost 0}
               :3 {:i 3 :name "" :spoken "broken", :written "broken", :native? false, :cost 0}}

   ;; for reloading state on app re-start
   :navigation {:root-state #js {}}})

(comment (reduce + (vals (merge (:skill-costs app-db) (:attribute-costs app-db)))))
