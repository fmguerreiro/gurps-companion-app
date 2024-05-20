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
(s/def ::portrait (s/or :s string? :nil nil?))
(s/def ::point-total number?)
(s/def ::ht (s/or :s string? :nil nil?))
(s/def ::wt (s/or :s string? :nil nil?))
(s/def ::size-modifier number?)
(s/def ::unspent-points number?)
(s/def ::age number?)
(s/def ::appearance string?)
(s/def ::status string?)
(s/def ::reputation string?)
(s/def ::notes string?)
(s/def ::profile (s/keys :req-un [(or ::name ::player ::portrait ::point-total ::ht ::wt ::size-modifier ::unspent-points ::age ::appearance ::status ::reputation ::notes)]))
(s/def ::db
  (s/keys :req-un [::profile ::attributes ::attribute-costs ::attribute-current ::languages ::navigation]))

;; initial state of app-db
(defonce app-db
  {:profile {:name ""
             :player ""
             :portrait nil
             :point-total 0
             :ht nil
             :wt nil
             :size-modifier 0
             :unspent-points 150
             :age 20
             :appearance ""
             :status ""
             :reputation ""
             :notes ""}

   :attributes {:str  10
                :dex  10
                :int  10
                :ht   10
                :per  10
                :will 10}

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

   :skills []

   :languages []

   :items {:possessions []
           :melee-weapons []
           :ranged-weapons []}

   :world {:tech-level 3}

   ;; for reloading state on app re-start
   :navigation {:root-state #js {}}})
