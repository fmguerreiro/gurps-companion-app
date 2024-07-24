(ns gurps.db
  (:require [cljs.spec.alpha :as s]))

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

(s/def ::str number?)
(s/def ::dex number?)
(s/def ::int number?)
(s/def ::ht-attr number?) ;; NOTE: ht is already used above in ::profile
(s/def ::per number?)
(s/def ::will number?)
(s/def ::attributes (s/keys :opt-un [::str ::dex ::int ::ht-attr ::per ::will]))
(s/def ::attribute-costs (s/keys :opt-un [::str ::dex ::int ::ht-attr ::per ::will ::fp ::hp ::basic-move ::basic-speed]))
(s/def ::attribute-current (s/keys :opt-un [::hp ::fp]))

(s/def ::k keyword?)
(s/def ::cost number?)
(s/def ::skill (s/keys :req-un [::name ::k ::cost]))
(s/def ::skills (s/coll-of ::skill))

(s/def ::lvl number?)
(s/def ::spell (s/keys :req-un [::lvl]))
(s/def ::spells (s/or :nil nil? :m (s/map-of ::k ::spell)))
(s/def ::spell-cost (s/keys :opt-un [::cost]))
(s/def ::spell-costs (s/or :nil nil? :m (s/map-of ::k ::spell-cost)))

(s/def ::advantage (s/keys :req [::cost ::lvl]))
(s/def ::advantages (s/map-of ::k ::advantage))
(s/def ::disadvantages (s/map-of ::k ::advantage))

(s/def ::spoken  #{"native" "accented" "broken"})
(s/def ::written #{"native" "accented" "broken"})
(s/def ::native? boolean?)
(s/def ::language (s/keys :req-un [::name ::spoken ::written ::native?] :opt-un [::cost]))
(s/def ::languages (s/coll-of ::language))

(s/def ::location #{"bag", "head", "torso", "arm", "hand", "leg", "foot"})
(s/def ::dr (s/or :n number? :nil nil?))
(s/def ::weight (s/or :n number? :nil nil?))
(s/def ::possession (s/keys :req-un [::name ::location ::dr] :opt-un [::weight]))
(s/def ::possessions (s/coll-of ::possession))

(s/def ::swg-mod string?)
(s/def ::thr-mod string?)
(s/def ::reach (s/or :s string? :nil nil?))
(s/def ::parry (s/or :s string? :nil nil?))
(s/def ::melee-weapon (s/keys :req-un [::name ::weight ::thr-mod ::swg-mod ::reach ::parry]))
(s/def ::melee-weapons (s/coll-of ::melee-weapon))

(s/def ::dmg (s/or :s string? :n number?))
(s/def ::acc number?)
(s/def ::rof number?)
(s/def ::shots (s/or :s string? :n number?))
(s/def ::ranged-weapon (s/keys :req-un [::name ::weight ::dmg ::acc ::rof ::shots]))
(s/def ::ranged-weapons (s/coll-of ::ranged-weapon))

(s/def ::items (s/keys :opt-un [::possessions ::melee-weapons ::ranged-weapons]))

(s/def ::tech-level number?)
(s/def ::world (s/keys :req-un [::tech-level]))

(s/def ::db
  (s/keys :req-un [::profile ::attributes ::attribute-costs ::attribute-current
                   ::skills ::languages ::world ::spells ::spell-costs
                   ;; ::items
                   ;; TODO: not sure what's wrong with ::advantages
                   ::navigation]))

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

   :attribute-current {:hp 10
                       :fp 10}

   :skills []

   :spells {}
   :spell-costs {}

   :advantages {}
   :disadvantages {}

   :languages []

   :items {:possessions []
           :melee-weapons []
           :ranged-weapons []}

   :world {:tech-level 3}

   ;; for reloading state on app re-start
   :navigation {:root-state #js {}}})
