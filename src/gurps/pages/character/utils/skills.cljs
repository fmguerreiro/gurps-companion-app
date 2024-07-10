(ns gurps.pages.character.utils.skills
  (:require [clojure.string :as str]
            [gurps.utils.i18n :as i18n]))

(defn- get-in-any
  "Like get-in, but takes a sequence of keys and returns the max value of the last key's starting name in the sequence.
   e.g. (get-in-any {:skills {:combat-melee {:shield/small 12 :shield/large 10}}} [:skills :combat-melee :shield])
        => 12"
  [m ks]
  (->> (get-in m (butlast ks))
       seq
       (map val)
       (reduce max)))

(defn skill->txt
  "Converts a skill key to a human-readable string.
  e.g. (skill->txt :fast-draw/two-handed-axe-or-mace) => \"Fast Draw (Two Handed Axe/Mace)\""
  [key]
  (let [category (namespace key)
        skill    (name key)]
    (str/join " "
              (if (some? category)
                [(i18n/label (keyword :t (str "skill-" category))) (when (not= "sp" skill) (str "(" (i18n/label (keyword :t (str "skill-" skill))) ")"))]
                [(i18n/label (keyword :t (str "skill-" skill)))]))))

(def difficulties {:e :easy :a :average :h :hard :v :very-hard})

(defn lvl-with-difficulty
  "Adjusts the lvl based on the difficulty"
  [lvl diff]
  (cond (= diff :e) lvl
        (= diff :a) (dec lvl)
        (= diff :h) (- lvl 2)
        (= diff :v) (- lvl 3)))

(defn lvl-with-cost
  "Adjusts the lvl based on the cost"
  [curr-lvl cost]
  (let [increment (cond
                    (<= cost 1) 0
                    (<= cost 3) 1
                    (<= cost 4) 2
                    (<= cost 8) 3
                    (<= cost 12) 4
                    (<= cost 16) 5
                    :else (+ 5 (quot (- cost 16) 4)))]
    (+ curr-lvl increment)))

(def categories [:animal :arts :athletics :business :combat-melee :combat-ranged :craft :criminal :invention :esoteric :everyman :knowledge :medical :military :science :occult :outdoor :plant :police :repair :scholar :social :humanities :spy :technical :transportation])

(defn calc-hoc [keys subtrahend]
  (fn [char] (- (get-in char keys) subtrahend)))

(defn calc-any-hoc [keys subtrahend]
  (fn [char] (- (get-in-any char keys) subtrahend)))

(def skills
  {:animal-handling/sp {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)] :specializations [:big-cats :dogs :equines :raptors]}
   :falconry {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :animal :animal-handling-raptor] 3)]}
   :mimicry/animal-sounds {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :mimicry/bird-calls {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :mount {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5)]}
   :naturalist {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                              (calc-any-hoc [:skills :science :biology] 3),
                                              (calc-any-hoc [:skills :plant :biology] 3)]}
   :packing {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                           (calc-hoc [:skills :animal :animal-handling/equines] 5)]}
   :riding/sp {:diff :a :attr :dex :specializations [:horse :bovines :camel :elephant :dolphin :dragon :bear :pigs-or-hogs :rams :hadrosaur :sauropod-or-big-raptor :bird :gheap]
               :default [(calc-hoc [:attributes :dex] 5),
                         (calc-hoc [:skills :animal :animal-handling/same] 3)]}
   :teamster/sp {:diff :a :attr :int :specializations [:horse :bovines :camel :elephant :dolphin :dragon :bear :pigs-or-hogs :rams :hadrosaur :sauropod-or-big-raptor :bird :gheap]
                 :default [(calc-hoc [:skills :animal :animal-handling/same] 4),
                           (calc-hoc [:skills :animal :riding/same] 2)]}
   :veterinary {:diff :a :attr :int :default [(calc-hoc [:skills :animal :animal-handling] 6),
                                              (calc-hoc [:skills :medical :physician] 5),
                                              (calc-hoc [:skills :medical :surgery] 5)]}
   :artist/sp {:diff :h :attr :int :specializations [:body-art :calligraphy :drawing :featherworking :illumination :illusion :interior-decorating :needlecraft :painting :pottery :scene-design :sculpting :sensie-interface :woodworking]
               :default [(calc-hoc [:attributes :int] 6)]}
   :connoisseur/sp {:diff :a :attr :int :specializations [:art :literature :music :visual-arts :weapons :luxuries]
                    :default [(calc-hoc [:attributes :int] 5)]}
   :current-affairs/high-culture {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4), (calc-hoc [:skills :scholar :research] 4)]}
   :current-affairs/popular-culture {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4), (calc-hoc [:skills :scholar :research] 4)]}
   :dancing {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5)]}
   :electronics-operation/sp {:diff :a :attr :int
                              :specializations [:communications :electronic-warfare :force-shields :matter-transmitters :media :medical :parachronic :psychotronics :scientific :security :sensors :sonar :surveillance :temporal]
                              :default [(calc-hoc [:attributes :int] 5),
                                        (calc-hoc [:skills :invention :engineer/electrical] 3),
                                        (calc-hoc [:skills :military :electronics-repair] 5),
                                        (calc-hoc [:skills :invention :engineer/electronics] 5)]}
   :fire-eating {:diff :a :attr :dex}
   :group-performance/sp {:diff :a :attr :int
                          :specializations [:choreography :conducting :directing :fight-choreography]
                          :default [(calc-hoc [:attributes :int] 5)]
                          :prerequisites {:and [{:or [:diplomacy :intimidation :leadership]}
                                                {:or [:choreography :conducting :directing :fight-choreography]}]}}
   :choreography {:diff :a :attr :int :default [(calc-hoc [:skills :arts :dancing] 2)] :prerequisites {:and [:dancing]}}
   :conducting   {:diff :a :attr :int :default [(calc-hoc [:skills :arts :musical-instrument/sp] 2)
                                                (calc-hoc [:skills :arts :singing] 2)]
                  :prerequisites {:and [:singing :musical-instrument]}}
   :directing    {:diff :a :attr :int :default [(calc-hoc [:skills :arts :performance] 5)]
                  :prerequisites {:and [:performance]}}
   :fight-choreography {:diff :a :attr :int :default [(calc-hoc [:skills :arts :stage-combat] 2)]
                        :prerequisites {:and [:stage-combat]}}

   :makeup {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                          (calc-hoc [:skills :criminal :disguise] 2)]}
   :mimicry/sp {:diff :h :attr :int
                :specializations [:animal-sounds :bird-calls :speech]
                :default [(calc-hoc [:attributes :int] 6)]}
   :musical-composition {:diff :h :attr :int :default [(calc-hoc [:skills :arts :musical-instrument] 2),
                                                       (calc-hoc [:skills :arts :poetry] 2)]}
   :musical-instrument/sp {:diff :h :attr :int
                           :specializations [:brass :keyboard :percussion :string :wind]}
   :performance {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                               (calc-hoc [:skills :social :acting] 2),
                                               (calc-hoc [:skills :business :public-speaking] 2)]}
   :photography {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                               (calc-hoc [:skills :arts :electronics-operation/media] 2)]}
   :poetry {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                          (calc-hoc [:skills :arts :writing] 2)]}
   :singing {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :sleight-of-hand {:diff :a :attr :dex :default [(calc-hoc [:skills :criminal :filch] 5)]}
   :stage-combat {:diff :a :attr :dex :default [(calc-hoc [:skills :athletic :combat-art] 2),
                                                (calc-hoc [:skills :athletic :sports] 2),
                                                (calc-hoc [:skills :arts :performance] 3)]}
   :ventriloquism {:diff :h :attr :int}
   :writing {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}

   :acrobatics {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :aeronautics {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :aquabatics {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :bicycling {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4),
                                             (calc-hoc [:skills :transporation :driving/motorcycle] 4)]}
   :body-sense {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6),
                                              (calc-hoc [:skills :athletic :acrobatics] 3)]}
   :breath-control {:diff :h :attr :ht}
   :climbing {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5)]}
   ;; :combat-art/sp :: TODO: fukin varies?
   :flight {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :free-fall {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                             (calc-hoc [:attributes :ht] 5)]}
   :hiking {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :jumping {:diff :e :attr :dex}
   :lifting {:diff :a :attr :ht}
   :parachuting {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :running {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :scuba {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                         (calc-hoc [:skills :technical :diving-suit] 2)]
           :prerequisites {:and [:swimming]}}
   :sports/sp {:diff :a :attr :dex
               :specializations [:baseball :basketball :football :golf :hockey :soccer :tennis :track-and-field :bull-fighting :darts :skating :skiing :swimming]}
   :swimming {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :throwing {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 3)
                                            (calc-hoc [:skills :combat-ranged :dropping] 2)]}
   :accounting {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                              (calc-hoc [:skills :business :finance] 4),
                                              (calc-hoc [:skills :business :mathematics/statistics] 5),
                                              (calc-hoc [:skills :business :merchant] 5)]}
   :administration {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                  (calc-hoc [:skills :business :merchant] 3)]}
   :current-affairs/business {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                                            (calc-hoc [:skills :scholarly :research] 4)]}
   :diplomacy {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :business :politics] 6)]}
   :economics {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :business :finance] 3),
                                             (calc-hoc [:skills :business :market-analysis] 5),
                                             (calc-hoc [:skills :business :merchant] 6)]}
   :finance {:diff :h :attr :int :default [(calc-hoc [:skills :business :merchant] 6),
                                           (calc-hoc [:skills :business :accounting] 4),
                                           (calc-hoc [:skills :business :economics] 3)]}
   :market-analysis {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                                   (calc-hoc [:skills :business :economics] 5),
                                                   (calc-hoc [:skills :business :merchant] 4)]}
   :mathematics/statistics {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :merchant {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :business :finance] 6),
                                            (calc-hoc [:skills :business :market-analysis] 4)]}
   :politics {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :business :diplomacy] 5)]}
   :public-speaking {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                   (calc-hoc [:skills :business :politics] 5),
                                                   (calc-hoc [:skills :social :acting] 5),
                                                   (calc-hoc [:skills :arts :performance] 2)]}
   :savoir-faire/high-society {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]} ;; TODO: and others?

   :axe-or-mace {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :flail] 4),
                                               (calc-hoc [:skills :combat-melee :two-handed-axe-or-mace] 3)]}
   :boxing {:diff :a :attr :dex}
   :brawling {:diff :e :attr :dex}
   :broadsword {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :force-sword] 4),
                                              (calc-hoc [:skills :combat-melee :rapier] 4),
                                              (calc-hoc [:skills :combat-melee :saber] 4),
                                              (calc-hoc [:skills :combat-melee :shortsword] 2),
                                              (calc-hoc [:skills :combat-melee :two-handed-sword] 4)]}
   :cloak {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                         (calc-hoc [:skills :combat-ranged :net] 4),
                                         (calc-any-hoc [:skills :combat-melee :shield] 4)]}
   :fast-draw/sp {:diff :e :attr :dex
                  :specializations [:arrow :ammo :knife :pistol :long-arm :force-sword :sword :two-handed-sword]}
   :flail {:diff :h :attr :dex :default [(calc-hoc [:skills :combat-melee :axe-or-mace] 4),
                                         (calc-hoc [:skills :combat-melee :two-handed-flail] 3)]}
   :force-sword {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :broadsword] 3),
                                               (calc-hoc [:skills :combat-melee :rapier] 3),
                                               (calc-hoc [:skills :combat-melee :saber] 3),
                                               (calc-hoc [:skills :combat-melee :shortsword] 3),
                                               (calc-hoc [:skills :combat-melee :smallsword] 3),
                                               (calc-hoc [:skills :combat-melee :two-handed-sword] 3)]}
   :force-whip {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :kusari] 3),
                                              (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                              (calc-hoc [:skills :combat-melee :whip] 3)]}
   :garrote {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :jitte-sai {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :force-sword] 4),
                                             (calc-hoc [:skills :combat-melee :main-gauche] 4),
                                             (calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :judo {:diff :h :attr :dex}
   :karate {:diff :h :attr :dex}
   :knife {:diff :e :attr :dex :default [(calc-hoc [:skills :combat-melee :force-sword] 3),
                                         (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                         (calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :kusari {:diff :h :attr :dex :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                          (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                          (calc-hoc [:skills :combat-melee :two-handed-flail] 4),
                                          (calc-hoc [:skills :combat-melee :whip] 3)]}
   :lance {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :spear] 3),
                                         (calc-hoc [:attributes :dex] 5)]}
   :main-gauche {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :knife] 4),
                                               (calc-hoc [:skills :combat-melee :jitte-sai] 4),
                                               (calc-hoc [:skills :combat-melee :rapier] 3),
                                               (calc-hoc [:skills :combat-melee :saber] 3),
                                               (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :monowire-whip {:diff :h :attr :dex :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                                 (calc-hoc [:skills :combat-melee :kusari] 3),
                                                 (calc-hoc [:skills :combat-melee :whip] 3)]}
   :parry-missile-weapons {:diff :h :attr :dex}
   :polearm {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :spear] 4),
                                           (calc-hoc [:skills :combat-melee :staff] 4),
                                           (calc-hoc [:skills :combat-melee :two-handed-axe-or-mace] 4)]}
   :rapier {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :broadsword] 3),
                                          (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                          (calc-hoc [:skills :combat-melee :saber] 3),
                                          (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :saber {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :broadsword] 4),
                                         (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                         (calc-hoc [:skills :combat-melee :rapier] 3),
                                         (calc-hoc [:skills :combat-melee :shortsword] 4),
                                         (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :shield/sp {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)] :specializations [:buckler :shield :force]}
   :shortsword {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :broadsword] 2),
                                              (calc-hoc [:skills :combat-melee :force-sword] 4),
                                              (calc-hoc [:skills :combat-melee :jitte-sai] 3),
                                              (calc-hoc [:skills :combat-melee :knife] 4),
                                              (calc-hoc [:skills :combat-melee :saber] 4),
                                              (calc-hoc [:skills :combat-melee :smallsword] 4),
                                              (calc-hoc [:skills :combat-melee :tonfa] 3)]}
   :smallsword {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :main-gauche] 3),
                                              (calc-hoc [:skills :combat-melee :rapier] 3),
                                              (calc-hoc [:skills :combat-melee :saber] 3),
                                              (calc-hoc [:skills :combat-melee :shortsword] 4)]}
   :spear {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                         (calc-hoc [:skills :combat-melee :staff] 2)]}
   :staff {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                         (calc-hoc [:skills :combat-melee :spear] 2)]}
   :sumo-wrestling {:diff :a :attr :dex}
   :tonfa {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :two-handed-axe-or-mace {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                                          (calc-hoc [:skills :combat-melee :axe-or-mace] 3),
                                                          (calc-hoc [:skills :combat-melee :two-handed-flail] 4)]}
   :two-handed-flail {:diff :h :attr :dex :default [(calc-hoc [:skills :combat-melee :flail] 3),
                                                    (calc-hoc [:skills :combat-melee :kusari] 4),
                                                    (calc-hoc [:skills :combat-melee :two-handed-axe-or-mace] 4)]}
   :two-handed-sword {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :broadsword] 4),
                                                    (calc-hoc [:skills :combat-melee :force-sword] 4)]}
   :whip {:diff :a :attr :dex :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                        (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                        (calc-hoc [:skills :combat-melee :kusari] 3)]}
   :wrestling {:diff :a :attr :dex}

   :artillery/sp {:diff :a :attr :int
                  :default [(calc-hoc [:attributes :int] 5)]
                  :specializations [:beam :bomb :cannon :guided-missile :torpedo]}
   :beam-weapons/sp {:diff :e :attr :dex
                     :default [(calc-hoc [:attributes :dex] 4)]
                     :specializations [:pistol :projector :rifle]}
   :blowpipe {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :bolas {:diff :a :attr :dex}
   :bow {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5)]}
   :crossbow {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :dropping {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 3),
                                            (calc-hoc [:skills :combat-ranged :throwing] 4)]}
   :gunner/sp {:diff :e :attr :dex
               :default [(calc-hoc [:attributes :dex] 4)]
               :specializations [:beam :cannon :catapult :machine-gun :rocket]}
   :guns/sp {:diff :e :attr :dex
             :default [(calc-hoc [:attributes :dex] 4)]
             :specializations [:grenade-launcher :gyroc :light-antiarmor-weapon :light-machine-gun :musket :pistol :rifle :shotgun :submachine-gun :wrist-gun]}
   :innate-attack/sp {:diff :e :attr :dex
                      :default [(calc-hoc [:attributes :dex] 4)]
                      :specializations [:beam :breath :gaze :projectile]}
   :lasso {:diff :a :attr :dex}
   :liquid-projector/sp {:diff :e :attr :dex
                         :default [(calc-hoc [:attributes :dex] 4)]
                         :specializations [:flamethrower :sprayer :squirt-gun :water-cannon]}
   :net {:diff :h :attr :dex :default [(calc-hoc [:skills :combat-melee :cloak] 5)]}
   :sling {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :spear-thrower {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                                 (calc-hoc [:skills :combat-ranged :thrown-weapon/spear] 4)]}
   :throwing-art {:diff :h :attr :dex :prerequisites {:or [:advantages/trained-by-a-master :advantages/weapon-master]}}
   :thrown-weapon/sp {:diff :e :attr :dex
                      :default [(calc-hoc [:attributes :dex] 4)]
                      :specializations [:axe-or-mace :dart :harpoon :knife :shuriken :spear :stick]}

   :artist/pottery {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :artist/sculpting {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :artist/woodworking {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :bone-carving {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 2),
                                                (calc-hoc [:skills :military :armoury] 2)]}
   :carpentry {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :jeweler {:diff :h :attr :int
             :default [(calc-hoc [:attributes :int] 6),
                       (calc-hoc [:skills :craft :smith/copper] 4),
                       (calc-hoc [:skills :craft :smith/lead-and-tin] 4)]}
   :leatherworking {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :masonry {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :smith/sp {:diff :a :attr :int
              :default [(calc-hoc [:attributes :int] 5)]
              :specializations [:copper :iron :lead-and-tin]}

   :carousing {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :computer-hacking {:diff :v :attr :int}
   :counterfeiting {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                                  (calc-hoc [:skills :criminal :forgery] 2)]}
   :disguise/sp {:diff :a :attr :int
                 :specializations []
                 :default [(calc-hoc [:attributes :int] 5),
                           (calc-hoc [:skills :arts :makeup] 3)]}
   :electronics-operation/security {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                                  (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                  (calc-hoc [:skills :repair :electronics-repair/security] 5),
                                                                  (calc-hoc [:skills :invention :engineer/electronics] 5)]}
   :escape {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :explosives/demolition {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :fast-talk {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                             (calc-hoc [:skills :social :acting] 5),
                                             (calc-hoc [:skills :spy :acting] 5)]}
   :filch {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                         (calc-hoc [:skills :criminal :pickpocket] 4),
                                         (calc-hoc [:skills :criminal :sleight-of-hand] 4)]}
   :forced-entry {:diff :e :attr :dex}
   :forgery {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                           (calc-hoc [:skills :criminal :counterfeiting] 2)]}
   :gambling {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :science :mathematics/statistics] 5),
                                            (calc-hoc [:skills :business :mathematics/statistics] 5)]}
   :holdout {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                           (calc-hoc [:skills :criminal :sleight-of-hand] 3)]}
   :intimidation {:diff :a :attr :will :default [(calc-hoc [:attributes :will] 5),
                                                 (calc-hoc [:skills :spy :acting] 3),
                                                 (calc-hoc [:skills :social :acting] 3)]}
   :lockpicking {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :observation {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                               (calc-hoc [:skills :police :shadowing] 5),
                                               (calc-hoc [:skills :spy :shadowing] 5),
                                               (calc-hoc [:skills :criminal :shadowing] 5)]}
   :panhandling {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                               (calc-hoc [:skills :criminal :fast-talk] 2),
                                               (calc-hoc [:skills :social :fast-talk] 2),
                                               (calc-hoc [:skills :business :public-speaking] 3),
                                               (calc-hoc [:skills :scholar :public-speaking] 3),
                                               (calc-hoc [:skills :social :public-speaking] 3)]}
   :pickpocket {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6),
                                              (calc-hoc [:skills :criminal :filch] 5),
                                              (calc-hoc [:skills :criminal :sleight-of-hand] 4)]}
   :poisons {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                           (calc-hoc [:skills :science :chemistry] 5),
                                           (calc-any-hoc [:skills :science :pharmacy] 3),
                                           (calc-hoc [:skills :medical :physician] 3)]}
   :savoir-faire/mafia {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]} ;; TODO: others
   :scrounging {:diff :e :attr :per :default [(calc-hoc [:attributes :per] 4)]}
   :shadowing {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                             (calc-hoc [:skills :military :observation] 5),
                                             (calc-hoc [:skills :spy :observation] 5),
                                             (calc-hoc [:skills :criminal :observation] 5),
                                             (calc-hoc [:skills :criminal :stealth] 4),
                                             (calc-hoc [:skills :police :stealth] 4),
                                             (calc-hoc [:skills :spy :stealth] 4)]}
   :streetwise {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :traps {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                         (calc-hoc [:skills :police :lockpicking] 3),
                                         (calc-hoc [:skills :criminal :lockpicking] 3),
                                         (calc-hoc [:skills :spy :lockpicking] 3),
                                         (calc-hoc [:skills :technical :lockpicking] 3)]}
   :urban-survival {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5)]}
   :architecture {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                (calc-hoc [:skills :invention :engineer/civil] 5)]}
   :bioengineering/sp {:diff :h :attr :int
                       :specializations [:cloning :genetic-engineering :tissue-regeneration]
                       :default [(calc-any-hoc [:skills :science :biology] 5),
                                 (calc-any-hoc [:skills :plant :biology] 5)]}
   :computer-programming {:diff :h :attr :int}
   :engineer/sp {:diff :h :attr :int
                 :specializations [:artillery :civil :clockwork :combat :electrical :materials :microtechnology :mining :nanotechnology :parachronic :psychothronics :robotics :small-arms :temporal :transportation]}
   :pharmacy/sp {:diff :h :attr :int
                 :default [(calc-hoc [:attributes :int] 6)]
                 :specializations [:herbal :synthetic]}
   :weird-science {:diff :v :attr :int}

   :autohypnosis {:diff :h :attr :will :default [(calc-hoc [:skills :esoteric :meditation] 4)]}
   :blind-fighting {:diff :v :attr :per}
   :body-control {:diff :v, :attr :ht, :prerequisites {:and [:advantages/trained-by-a-master :breath-control :meditation]}}
   :breaking-blow {:diff :h, :attr :int :prerequisites {:and [:advantages/trained-by-a-master]}}
   :captivate {:diff :h :attr :will}
   :dreaming {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6)]}
   :enthrallment/sp {:diff :h :attr :will
                     :specializations []}
   :flying-leap {:diff :h, :attr :int, :prerequisites {:and [{:or [:advantages/trained-by-a-master :advantages/weapon-master]}, :jumping, :power-blow]}}
   :immovable-stance {:diff :h :attr :dex, :prerequisites {:and [:advantages/trained-by-a-master]}}
   :invisibility-art {:diff :v :attr :int, :prerequisites {:and [:advantages/trained-by-a-master, {:hypnotism 14}, {:stealth 14}]}}
   :kiai {:diff :h :attr :ht, :prerequisites {:or [:advantages/trained-by-a-master, :advantages/weapon-master]}}
   :light-walk {:diff :h :attr :dex :prerequisites {:and [:advantages/trained-by-a-master, {:acrobatics 14}, {:stealth 14}]}}
   :meditation {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6),
                                               (calc-hoc [:skills :esoteric :autohypnosis] 4)]}
   :mental-strength {:diff :e :attr :will :prerequisites {:or [:advantages/trained-by-a-master :advantages/weapon-master]}}
   :mind-block {:diff :a :attr :will :default [(calc-hoc [:attributes :will] 5),
                                               (calc-hoc [:skills :esoteric :meditation] 5)]}
   :musical-influence {:diff :v :attr :int :prerequisites {:and [{:talents/musical-ability 1}, {:or [{:musical-instrument/sp 12} {:singing 12}]}]}}
   :persuade {:diff :h :attr :will}
   :power-blow {:diff :h :attr :will :prerequisites {:or [:advantages/trained-by-a-master :advantages/weapon-master]}}
   :pressure-points {:diff :h :attr :int :prerequisites {:or [:advantages/trained-by-a-master :advantages/weapon-master]}}
   :pressure-secrets {:diff :v :attr :int :prerequisites {:and [:advantages/trained-by-a-master {:pressure-points 16}]}}
   :push {:diff :h :attr :dex :prerequisites {:and [:advantages/trained-by-a-master]}}
   :suggest {:diff :h :attr :will}
   :sway-emotions {:diff :h :attr :will}
   :zen-archery {:diff :v :attr :int :prerequisites {:and [{:or [:advantages/trained-by-a-master :advantages/weapon-master]},
                                                           {:or [:meditation {:advantages/heroic-archer 18}]}]}}
   :zen-marksmanship {:diff :v :attr :int}

   :area-knowledge/sp {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                                     (calc-hoc [:skills :humanities :geography/same] 3)]
                       :specializations [:city :country :region :world]}
   :computer-operation {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :cooking {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5), (calc-hoc [:skills :everyman :housekeeping] 5)]}
   :housekeeping {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :knot-tying {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4),
                                              (calc-hoc [:skills :transportation :seamanship] 4),
                                              (calc-hoc [:skills :outdoor :climbing] 4),
                                              (calc-hoc [:skills :criminal :climbing] 4),
                                              (calc-hoc [:skills :athletic :climbing] 4)]}
   :savoir-faire/servant {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :sewing {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :typing {:diff :e :attr :dex :default [(calc-hoc [:attributes :dex] 4)]}
   :weather-sense {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :current-affairs/sp {:diff :e :attr :int
                        :default [(calc-hoc [:attributes :int] 4),
                                  (calc-hoc [:skills :spy :research] 4)
                                  (calc-hoc [:skills :scholar :research] 4)]
                        :specializations [:business :celebrities :crime :entertainment :politics :sports :war]}
   :games/sp {:diff :e :attr :int
              :default [(calc-hoc [:attributes :int] 4)]
              :specializations [:cards :chess :dice :go :mahjong :poker :shogi]}
   :heraldry {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :business :savoir-faire/high-society] 3),
                                            (calc-hoc [:skills :knowledge :savoir-faire/high-society] 3)
                                            (calc-hoc [:skills :social :savoir-faire/high-society] 3)]}
   :hidden-lore/sp {:diff :a :attr :int
                    :specializations [:conspiracies :demon-lore :faerie-lore :spirit-lore]}
   :hobby-skill/sp {:diff :e :attr [:int :dex]
                    :default [(calc-hoc [:attributes :int] 4), (calc-hoc [:attributes :dex] 4)]
                    :specializations []}
   :professional-skill/sp {:diff :e :attr [:int :dex]
                           :specializations [:bartender :cooper :prostitute :distiller :dyer :florist :glassblower :sonar-imaging :tanning :weaver]}
   :savoir-faire/sp {:diff :e :attr :int
                     :default [(calc-hoc [:attributes :int] 4)]
                     :specializations [:dojo :high-society :military :mafia :police :servant]}

   :diagnosis {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :medical :first-aid] 8),
                                             (calc-hoc [:skills :medical :physician] 4),
                                             (calc-hoc [:skills :medical :veterinary] 5),
                                             (calc-hoc [:skills :animal :veterinary] 5)]}
   :electronics-operation/medical {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                                 (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                 (calc-hoc [:skills :invention :engineer/electronics] 5),
                                                                 (calc-hoc [:skills :repair :electronics-repair/medical] 5)]}
   :esoteric-medicine {:diff :h :attr :per :default [(calc-hoc [:attributes :per] 6)]}
   :expert-skill/epidemiology {:diff :h :attr :int}
   :first-aid {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                             (calc-hoc [:skills :medical :esoteric-medicine] 0),
                                             (calc-hoc [:skills :medical :physician] 0),
                                             (calc-hoc [:skills :medical :veterinary] 4)]}
   :hypnotism {:diff :h :attr :int}
   :physician {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 7),
                                             (calc-hoc [:skills :medical :first-aid] 11),
                                             (calc-hoc [:skills :medical :veterinary] 5),
                                             (calc-hoc [:skills :animal :veterinary] 5)]}
   :psychology {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                              (calc-hoc [:skills :humanities :sociology] 4)]}
   :surgery {:diff :v :attr :int :default [(calc-hoc [:skills :medical :first-aid] 12),
                                           (calc-hoc [:skills :medical :physician] 5),
                                           (calc-hoc [:skills :science :physiology] 8),
                                           (calc-hoc [:skills :medical :veterinary] 5),
                                           (calc-hoc [:skills :animal :veterinary] 5)]
             :prerequisites {:or [:first-aid :physician]}}
   :armoury/sp {:diff :a :attr :int
                :default [(calc-hoc [:attributes :int] 5),
                          (calc-hoc [:skills :invention :engineer/same] 3)]
                :specializations [:battlesuits :body-armor :force-shields :heavy-weapons :melee-weapons :missile-weapons :small-arms :vehicles]}
   :brain-hacking {:diff :h :attr :int} ;; TODO: special
   :brainwashing {:diff :h :attr :int} ;; TODO: special
   :camouflage {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)
                                              (calc-hoc [:skills :outdoor :survival] 2)]}
   :cryptography {:diff :h :attr :int :default [(calc-hoc [:attributes :science :mathematics/cryptology] 5)]}
   :electronics-operation/electronic-warfare {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                                            (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                            (calc-hoc [:skills :invention :engineer/electronics] 5),
                                                                            (calc-hoc [:skills :spy :electronics-repair/electronic-warfare] 3),
                                                                            (calc-hoc [:skills :repair :electronics-repair/electronic-warfare] 3),
                                                                            (calc-hoc [:skills :technical :electronics-repair/electronic-warfare] 3),
                                                                            (calc-hoc [:skills :military :electronics-repair/electronic-warfare] 3)]}
   :expert-skill/military-science {:diff :h :attr :int}
   :explosives/sp {:diff :a :attr :int
                   :specializations [:demolition :explosive-ordnance-disposal :fireworks :nuclear-ordnance-disposal :underwater-demolition]
                   :default [(calc-hoc [:attributes :int] 5)]}
   :forward-observer {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                    (calc-hoc [:skills :combat-ranged :artillery] 5)]}
   :intelligence-analysis {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                                         (calc-any-hoc [:skills :military :strategy] 6)]}
   :interrogation {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                 (calc-hoc [:skills :police :intimidation] 3),
                                                 (calc-hoc [:skills :social :intimidation] 3),
                                                 (calc-hoc [:skills :criminal :intimidation] 3),
                                                 (calc-hoc [:skills :humanities :psychology] 4),
                                                 (calc-hoc [:skills :medical :psychology] 4)]}
   :leadership {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :nbc-suit {:diff :a :attr :dex :default [(calc-hoc [:skills :technical :battlesuit] 2),
                                            (calc-hoc [:skills :transportation :battlesuit] 2),
                                            (calc-hoc [:skills :technical :diving-suit] 4),
                                            (calc-hoc [:skills :technical :vacc-suit] 2)]}
   :propaganda {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                              (calc-hoc [:skills :social :merchant] 5),
                                              (calc-hoc [:skills :business :merchant] 5),
                                              (calc-hoc [:skills :humanities :psychology] 4),
                                              (calc-hoc [:skills :medical :psychology] 4)]}
   :savoir-faire/military {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]} ;; TODO: and others
   :soldier {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :strategy/sp {:diff :h :attr :int
                 :specializations [:naval :land :air :space :police :security]
                 :default [(calc-hoc [:attributes :int] 6),
                           (calc-hoc [:skills :military :intelligence-analysis] 6),
                           (calc-hoc [:skills :spy :intelligence-analysis] 6),
                           (calc-hoc [:skills :military :tactics] 6),
                           (calc-hoc [:skills :police :tactics] 6)]}
   :tactics {:diff :h :attr :int
             :default [(calc-hoc [:attributes :int] 6),
                       (calc-any-hoc [:skills :military :strategy] 6)]}
   :alchemy {:diff :v :attr :int}
   :astronomy {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]
               :prerequisites {:and [:mathematics/sp]}}
   :biology/sp {:diff :v :attr :int
                :specializations [:terrestrial]
                :default [(calc-hoc [:attributes :int] 6),
                          (calc-hoc [:skills :science :naturalist] 6),
                          (calc-hoc [:skills :outdoor :naturalist] 6),
                          (calc-hoc [:skills :plant :naturalist] 6),
                          (calc-hoc [:skills :animal :naturalist] 6)]}
   :chemistry {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :science :alchemy] 3)]}
   :expert-skill/hydrology {:diff :h :attr :int}
   :expert-skill/natural-philosofy {:diff :h :attr :int}
   :geology/sp {:diff :h :attr :int
                :specializations [:terrestrial :ice-giant :gas-giant :asteroid]
                :default [(calc-hoc [:attributes :int] 6),
                          (calc-hoc [:skills :humanities :geography/physical] 4),
                          (calc-hoc [:skills :outdoor :prospecting] 5)]}
   :mathematics/sp {:diff :h :attr :int
                    :specializations [:algebra :arithmetic :calculus :geometry :statistics :surveying :trigonometry]
                    :default [(calc-hoc [:attributes :int] 6)]}
   :metallurgy {:diff :h :attr :int :default [(calc-hoc [:skills :science :chemistry] 5),
                                              (calc-hoc [:skills :craft :jeweller] 8),
                                              (calc-any-hoc [:skills :craft :smith] 8)]}
   :meteorology/sp {:diff :a :attr :int
                    :specializations [:terrestrial :ice-giant :gas-giant :asteroid]
                    :default [(calc-hoc [:attributes :int] 5)]}
   :paleontology/sp {:diff :h :attr :int
                     :specializations [:micropaleontology :paleoanthropology :paleobotany :paleozoology]
                     :default [(calc-any-hoc [:skills :science :biology] 4),
                               (calc-any-hoc [:skills :plant :biology] 4)]}
   :physics {:diff :v :attr :int :default [(calc-hoc [:attributes :int] 6)]
             :prerequisites {:and [:mathematics/sp]}}
   :physiology/sp {:diff :h :attr :int
                   :specializations [:terrestrial :demon :faerie :undead :elemental :cyborg :mutant :psionic :spiritual :astral :ethereal :celestial]
                   :default [(calc-hoc [:attributes :int] 6),
                             (calc-hoc [:skills :medical :diagnosis] 5),
                             (calc-hoc [:skills :medical :physician] 5),
                             (calc-hoc [:skills :medical :surgery] 5)]}
   :exorcism {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6)
                                             (calc-any-hoc [:skills :occult :religious-ritual] 3),
                                             (calc-any-hoc [:skills :occult :religious-magic] 3),
                                             (calc-any-hoc [:skills :humanities :theology] 3)]}
   :expert-skill/psionics {:diff :h :attr :int}
   :herb-lore {:diff :v :attr :int, :prerequisites {:and [:naturalist]}}
   :hidden-lore/demon-lore {:diff :a :attr :int}
   :hidden-lore/faerie-lore {:diff :a :attr :int}
   :hidden-lore/spirit-lore {:diff :a :attr :int}
   :occultism {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :religious-ritual/sp {:diff :h :attr :int
                         :specializations [:christian :islamic :jewish :hindu :buddhist :shinto :taoist :zoroastrian :pagan :druid :shaman]
                         :default [(calc-hoc [:skills :occult :religious-magic/same] 6)
                                   (calc-hoc [:skills :humanities :theology/same] 4)]}
   :ritual-magic/sp {:diff :v :attr :int
                     :specializations [:christian :islamic :jewish :hindu :buddhist :shinto :taoist :zoroastrian :pagan :druid :shaman]
                     :default [(calc-hoc [:skills :occult :religious-ritual/same] 6)]}
   :symbol-drawing/sp {:diff :h :attr :int
                       :specializations []
                       :default []}
   :thaumatology {:diff :v :attr :int :default [(calc-hoc [:attributes :int] 7)]}
   :cartography {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)
                                               (calc-any-hoc [:skills :humanities :geography] 2),
                                               (calc-hoc [:skills :science :mathematics/surveying] 2),
                                               (calc-hoc [:skills :technical :mathematics/surveying] 2),
                                               (calc-any-hoc [:skills :outdoor :navigation] 4),
                                               (calc-any-hoc [:skills :technical :navigation] 4)]}
   :fishing {:diff :e :attr :per :default [(calc-hoc [:attributes :per] 4)]}
   :navigation/sp {:diff :a :attr :int
                   :specializations [:sea :air :land :space :hyperspace]
                   :default []}
   :prospecting {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                               (calc-any-hoc [:skills :science :geology] 4)]}
   :skating {:diff :h :attr :ht :default [(calc-hoc [:attributes :ht] 6)]}
   :skiing {:diff :h :attr :ht :default [(calc-hoc [:attributes :ht] 6)]}
   :survival/sp {:diff :a :attr :per
                 :specializations [:arctic :desert :forest :jungle :mountain :plains :swamp :urban :subterranean :fresh-water :salt-water]
                 :default [(calc-hoc [:attributes :per] 5),
                           (calc-hoc [:skills :science :naturalist] 3),
                           (calc-hoc [:skills :outdoor :naturalist] 3)
                           (calc-hoc [:skills :animal :naturalist] 3)]}
   :tracking {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                            (calc-hoc [:skills :science :naturalist] 5),
                                            (calc-hoc [:skills :outdoor :naturalist] 5)
                                            (calc-hoc [:skills :animal :naturalist] 5)]}
   :farming {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                           (calc-any-hoc [:skills :plant :biology] 5),
                                           (calc-any-hoc [:skills :science :biology] 5),
                                           (calc-hoc [:skills :plant :gardening] 3)]}
   :gardening {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4),
                                             (calc-hoc [:skills :plant :farming] 3)]}
   :paleontology/paleobotany {:diff :h :attr :int :default [(calc-any-hoc [:skills :plant :biology] 4),
                                                            (calc-any-hoc [:skills :science :biology] 4)]}
   :pharmacy/herbal {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}

   :body-language {:diff :a :attr :per :default [(calc-hoc [:skills :police :detect-lies] 4),
                                                 (calc-hoc [:skills :social :detect-lies] 4),
                                                 (calc-hoc [:skills :spy :detect-lies] 4),
                                                 (calc-hoc [:skills :humanities :psychology] 4),
                                                 (calc-hoc [:skills :medical :psychology] 4)]}
   :criminology {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                               (calc-hoc [:skills :humanities :psychology] 4),
                                               (calc-hoc [:skills :medical :psychology] 4)]}
   :detect-lies {:diff :h :attr :per :default [(calc-hoc [:attributes :per] 6),
                                               (calc-hoc [:skills :police :body-language] 4),
                                               (calc-hoc [:skills :social :body-language] 4),
                                               (calc-hoc [:skills :spy :body-language] 4),
                                               (calc-hoc [:skills :humanities :psychology] 4),
                                               (calc-hoc [:skills :medical :psychology] 4)]}
   :electronics-operation/surveillance {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                                                      (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                      (calc-hoc [:skills :repair :electronics-repair/surveillance] 5),
                                                                      (calc-hoc [:skills :invention :engineer/electronics] 5)]}
   :explosives/explosive-ordnance-disposal {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :forensics {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :police :criminology] 4),
                                             (calc-hoc [:skills :humanities :criminology] 4)]}
   :law/sp {:diff :h :attr :int
            :specializations [:criminal :corporate :family :international :military :tax :tort :traffic]
            :default [(calc-hoc [:attributes :int] 6)]}
   :savoir-faire/police {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]} ;; TODO others
   :search {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                          (calc-hoc [:skills :police :criminology] 5),
                                          (calc-hoc [:skills :humanities :criminology] 5)]}
   :stealth {:diff :a :attrb :dex :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:attributes :dex] 5)]}
   :electrician {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                               (calc-hoc [:skills :invention :engineer/electrical] 3)]}
   :electronics-repair/sp {:diff :a :attr :int
                           :specializations [:audio :communications :computers :control-systems :electronic-warfare :medical :military :power :sensors :surveillance :video :weapons]
                           :default [(calc-hoc [:attributes :int] 5),
                                     (calc-hoc [:skills :arts :electronics-operation/same] 3),
                                     (calc-hoc [:skills :spy :electronics-operation/same] 3),
                                     (calc-hoc [:skills :technical :electronics-operation/same] 3),
                                     (calc-hoc [:skills :criminal :electronics-operation/same] 3),
                                     (calc-hoc [:skills :medical :electronics-operation/same] 3),
                                     (calc-hoc [:skills :military :electronics-operation/same] 3),
                                     (calc-hoc [:skills :police :electronics-operation/same] 3),
                                     (calc-hoc [:skills :invention :engineer/electronics] 3)]}
   :flint-knapping {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 2),
                                                  (calc-hoc [:skills :repair :armoury] 1),
                                                  (calc-hoc [:skills :humanities :anthropology] 4)]}
   :machinist {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                             (calc-any-hoc [:skills :repair :mechanic] 5)]}
   :mechanic/sp {:diff :a :attr :int
                 :specializations [:machine :motive-system :power-plant :vehicle]
                 :default [(calc-hoc [:attributes :int] 5),
                           (calc-hoc [:skills :invention :engineer/same] 4)
                           (calc-hoc [:skills :repair :machinist] 5)]}
   :expert-skill/sp {:diff :h :attr :int
                     :specializations [:computer-security :conspiracy-theory :egyptology :epidemiology :hydrology :military-science :natural-philosophy :political-science :psionics :thanatology :xenology]}
   :literature {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :research {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                            (calc-hoc [:skills :scholar :writing] 3),
                                            (calc-hoc [:skills :arts :writing] 3)]}
   :speed-reading {:diff :a :attr :int}
   :teaching {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :acting {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5),
                                          (calc-hoc [:skills :arts :performance] 2),
                                          (calc-hoc [:skills :business :public-speaking] 5),
                                          (calc-hoc [:skills :scholar :public-speaking] 5),
                                          (calc-hoc [:skills :social :public-speaking] 5)]}
   :erotic-art {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                              (calc-hoc [:skills :athletics :accrobatics] 5)]}
   :fortune-telling/sp {:diff :a :attr :int
                        :specializations [:astrology :cartomancy :crystal-gazing :dream-interpretation :numerology :palmistry :phrenology :psychometry :rune-casting :tarot-reading :tea-leaf-reading :tasseography :yarrow-sticks]
                        :default [(calc-hoc [:attributes :int] 5),
                                  (calc-hoc [:skills :social :fast-talk] 3),
                                  (calc-hoc [:skills :spy :fast-talk] 3),
                                  (calc-hoc [:skills :criminal :fast-talk] 3),
                                  (calc-hoc [:skills :occultist :occultism] 3)]}
   :gesture {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :sex-appeal {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 3)]}
   :anthropology/sp {:diff :h :attr :int
                     :specializations [:african-american :african :american :ancient :asian :european :latin-american :middle-eastern :native-american :prehistoric :contemporary-art :asian-art :design-history :natural-history :us-postal-service]
                     :default [(calc-hoc [:attributes :int] 6),
                               (calc-hoc [:skills :humanities :sociology] 3),
                               (calc-hoc [:skills :sciences :paleontology/paleoanthropology] 2),
                               (calc-hoc [:skills :humanities :paleontology/paleoanthropology] 2)]}
   :archaeology {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :expert-skill/egyptology {:diff :h :attr :int}
   :expert-skill/political-science {:diff :h :attr :int}
   :expert-skill/thanatology {:diff :h :attr :int}
   :expert-skill/xenology {:diff :h :attr :int}
   :geography/sp {:diff :h :attr :int
                  :specializations [:physical :political :regional]
                  :default [(calc-hoc [:attributes :int] 6)]}
   :history/sp {:diff :h :attr :int
                :specializations [:ancient :medieval :modern :contemporary :american :asian :european :latin-american :middle-eastern :native-american :prehistoric]
                :default [(calc-hoc [:attributes :int] 6)]}
   :linguistics {:diff :h :attr :int}
   :paleontology/paleoanthropology {:diff :h :attr :int :default [(calc-any-hoc [:skills :science :biology] 3),
                                                                  (calc-any-hoc [:skills :plant :biology] 3)]}
   :philosophy/sp {:diff :h :attr :int
                   :specializations [:aesthetics :epistemology :ethics :logic :metaphysics :philosophy-of-science :political-philosophy :social-philosophy]
                   :default [(calc-hoc [:attributes :int] 6)]}
   :sociology {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6),
                                             (calc-hoc [:skills :humanities :anthropology] 3),
                                             (calc-hoc [:skills :humanities :psychology] 4),
                                             (calc-hoc [:skills :medical :psychology] 4)]}
   :theology/sp {:diff :h :attr :int
                 :specializations [:christian :islamic :jewish :hindu :buddhist :shinto :taoist :zoroastrian :pagan :druid :shaman]
                 :default [(calc-hoc [:attributes :int] 6),
                           (calc-hoc [:skills :occultist :religious-ritual/same] 4)]}
   :expert-skill/computer-security {:diff :h :attr :int}
   :lip-reading {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 10)]}
   :smuggling {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :battlesuit {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                              (calc-hoc [:skills :technical :diving-suit] 4),
                                              (calc-hoc [:skills :technical :vacc-suit] 2),
                                              (calc-hoc [:skills :technical :nbc-suit] 2)]}
   :diving-suit {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                               (calc-hoc [:skills :technical :battlesuit] 4),
                                               (calc-hoc [:skills :technical :scuba] 2),
                                               (calc-hoc [:skills :technical :vacc-suit] 4),
                                               (calc-hoc [:skills :technical :nbc-suit] 4)]}
   :freight-handling {:diff :a :attr :int :default [(calc-hoc [:attributes :int] 5)]}
   :hazardous-materials/sp {:diff :a :attr :int
                            :specializations [:biological :chemical :nuclear :radiological :toxicological :explosives :flammables :gases :liquids :solids :corrosives :oxidizers :poisons]
                            :default [(calc-hoc [:attributes :int] 5)]}
   :mathematics/surveying {:diff :h :attr :int :default [(calc-hoc [:attributes :int] 6)]}
   :vacc-suit {:diff :a :attr :dex :default [(calc-hoc [:attributes :dex] 5),
                                             (calc-hoc [:skills :technical :battlesuit] 2),
                                             (calc-hoc [:skills :technical :diving-suit] 4),
                                             (calc-hoc [:skills :technical :nbc-suit] 2)]}

   :airshipman {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :boating/sp {:diff :a :attr :dex
                :specializations [:large-powerboat :motorboat :sailboat :unpowered]
                :default [(calc-hoc [:attributes :dex] 5),
                          (calc-hoc [:attributes :int] 5)]}
   :crewman {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :driving/sp {:diff :a :attr :dex
                :specializations [:automobile :construction-equipment :half-track :heavy-wheeled :hovercraft :locomotive :mecha :motorcycle :tracked]
                :default [(calc-hoc [:attributes :dex] 5),
                          (calc-hoc [:attributes :int] 5)]}
   :piloting/sp {:diff :a :attr :dex
                 :specializations [:aerospace :autogyro :contragravity :flight-pack :glider :heavy-airplane :helicopter :spacecraft :lightsail :ornithopter :vertol]
                 :default [(calc-hoc [:attributes :dex] 6)]}
   :seamanship {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :shiphandling/sp {:diff :h :attr :int
                     :specializations [:airship :ship :spaceship :starship :submarine]
                     :default [(calc-hoc [:attributes :int] 6)]}
   :spacer {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}
   :submarine {:diff :h :attr :dex :default [(calc-hoc [:attributes :dex] 6)]}
   :submariner {:diff :e :attr :int :default [(calc-hoc [:attributes :int] 4)]}})

;; TODO: modifiers, like, riding (+5 if the animal knows and likes you)
;; TODO: techlevel
;; TODO: same-type default
;; (def skills {:animal animal-skills
;;              :arts art-skills
;;              :athletic athletics-skills
;;              :business business-skills
;;              :combat-melee combat-melee-skills
;;              :combat-ranged combat-ranged-skills
;;              :craft craft-skills
;;              :criminal criminal-skills
;;              :invention invention-skills
;;              :esoteric esoteric-skills
;;              :everyman everyman-skills
;;              :knowledge knowledge-skills
;;              :medical medical-skills
;;              :military military-skills
;;              :science science-skills
;;              :occult occult-skills
;;              :outdoor outdoor-skills
;;              :plant plant-skills
;;              :police police-skills
;;              :repair repair-skills
;;              :scholar scholar-skills
;;              :social social-skills
;;              :humanities humanities-skills
;;              :spy spy-skills
;;              :technical technical-skills
;;              :transportation transportation-skills})

(def grouped-skills
  {:animal (select-keys skills [:animal-handling :falconry :mimicry/animal-sounds :mimicry/bird-calls :mount :naturalist :packing :riding/sp :teamster/sp :veterinary])
   :arts (select-keys skills [:artist/sp :connoisseur/sp :current-affairs/high-culture :current-affairs/popular-culture :dancing :electronics-operation/media :fire-eating :group-performance/sp :makeup :mimicry/sp :musical-composition :musical-instrument/sp :performance :photography :poetry :singing :sleight-of-hand :stage-combat :ventriloquism :writing :fight-choreography :choreography :directing :conducting])
   :athletic (select-keys skills [:acrobatics :aerobatics :aquabatics :bicycling :body-sense :breath-control :climbing :combat-art/sp :flight :free-fall :hiking :jumping :lifting :mount :parachuting :running :scuba :sports/sp :swimming :throwing])
   :business (select-keys skills [:accounting :administration :current-affairs/business :diplomacy :economics :finance :law/sp :market-analysis :mathematics/statistics :merchant :politics :public-speaking :savoir-faire/high-society])
   :combat-melee (select-keys skills [:axe-or-mace :boxing :brawling :broadsword :cloak :fast-draw/sp :flail :force-sword :force-whip :garrote :jitte-sai :judo :karate :knife :kusari :lance :main-gauche :melee-weapon :monowire-whip :parry-missile-weapons :polearm :rapier :saber :shield/sp :shortsword :smallsword :spear :staff :sumo-wrestling :tonfa :two-handed-axe-or-mace :two-handed-flail :two-handed-sword :whip :wrestling])
   :combat-ranged (select-keys skills [:artillery/sp :beam-weapons/sp :blowpipe :bolas :bow :crossbow :dropping :fast-draw/sp :gunner/sp :guns/sp :innate-attack/sp :lasso :liquid-projector/sp :net :sling :spear-thrower :throwing-art :thrown-weapon/sp])
   :craft (select-keys skills [:artist/pottery :artist/sculpting :artist/woodworking :bone-carving :carpentry :jeweler :leatherworking :masonry :smith/sp])
   :criminal (select-keys skills [:carousing :climbing :computer-hacking :counterfeiting :disguise/sp :electronics-operation/security :escape :explosives/demolition :fast-talk :filch :forced-entry :forgery :gambling :holdout :intimidation :lockpicking :observation :panhandling :pickpocket :poisons :savoir-faire/mafia :scrounging :shadowing :sleight-of-hand :smuggling :stealth :streetwise :traps :urban-survival])
   :invention (select-keys skills [:architecture :bioengineering/sp :computer-programming :engineer/sp :pharmacy/sp :weird-science])
   :esoteric (select-keys skills [:autohypnosis :blind-fighting :body-control :breaking-blow :captivate :dreaming :enthralment :flying-leap :immovable-stance :invisibility-art :kiai :light-walk :meditation :mental-strength :mind-block :musical-influence :persuade :power-blow :pressure-points :pressure-secrets :push :suggest :sway-emotions :throwing-art :zen-archery])
   :everyman (select-keys skills [:area-knowledge/sp :computer-operation :cooking :housekeeping :knot-tying :savoir-faire/servant :sewing :typing :weather-sense])
   :knowledge (select-keys skills [:area-knowledge/sp :connoisseur/sp :current-affairs/sp :games/sp :heraldry :hidden-lore/sp :hobby-skill/sp :professional-skill/sp :savoir-faire/sp])
   :medical (select-keys skills [:diagnosis :electronics-operation/medical :esoteric-medicine :expert-skill/epidemiology :first-aid :hypnotism :pharmacy/sp :physician :poisons :psychology :surgery :veterinary])
   :military (select-keys skills [:armory/sp :brain-hacking :brainwashing :camouflage :cryptography :electronics-operation/electronic-warfare :electronics-repair/electronic-warfare :expert-skill/military-science :explosives/sp :forward-observer :intelligence-analysis :interrogation :leadership :nbc-suit :observation :parachuting :propaganda :savoir-faire/military :scuba :soldier :strategy/sp :tactics :traps])
   :science (select-keys skills [:alchemy :astronomy :biology/sp :chemistry :expert-skill/epidemiology :expert-skill/hydrology :expert-skill/natural-philosophy :geology/sp :mathematics/sp :metallurgy :meteorology/sp :naturalist :paleontology :physics :physiology/sp])
   :occult (select-keys skills [:alchemy :exorcism :expert-skill/psionics :herb-lore :hidden-lore/demon-lore :hidden-lore/faerie-lore :hidden-lore/spirit-lore :occultism :religious-ritual/sp :ritual-magic/sp :symbol-drawing :thaumatology])
   :outdoor (select-keys skills [:camouflage :cartography :climbing :fishing :hiking :mimicry/animal-sounds :mimicry/bird-calls :naturalist :navigation/sp :prospecting :scuba :skating :skiing :survival/sp :swimming :tracking :weather-sense])
   :plant (select-keys skills [:biology/sp :farming :gardening :herb-lore :naturalist :paleontology/paleobotany :pharmacy/herbal])
   :police (select-keys skills [:body-language :criminology :detect-lies :diplomacy :electronics-operation/surveillance :explosives/explosive-ordnance-disposal :forced-entry :forensics :intelligence-analysis :interrogation :law/sp :lockpicking :observation :savoir-faire/police :search :shadowing :stealth :streetwise :tactics :urban-survival])
   :repair (select-keys skills [:armoury/sp :electrician :electronics-repair/sp :flint-knapping :machinist :mechanic/sp])
   :scholar (select-keys skills [:computer-operation :expert-skill/sp :literature :public-speaking :research :speed-reading :teaching :typing :writing])
   :social (select-keys skills [:acting :administration :body-language :carousing :connoisseur/sp :current-affairs/sp :detect-lies :diplomacy :erotic-art :fast-talk :fortune-telling/sp :gambling :intimidation :gesture :heraldry :leadership :merchant :panhandling :politics :propaganda :public-speaking :savoir-faire/high-society :sex-appeal :streetwise :teaching])
   :humanities (select-keys skills [:anthropology :archaeology :cartography :criminology :economics :expert-skill/egyptology :expert-skill/political-science :expert-skill/thanatology :expert-skill/xenology :geography/sp :history/sp :law/sp :linguistics :literature :paleontology/paleoanthropology :philosophy/sp :psychology :sociology :theology/sp])
   :spy (select-keys skills [:acting :body-language :brain-hacking :brainwashing :computer-hacking :cryptography :detect-lies :disguise/sp :electronics-operation/electronic-warfare :electronics-operation/security :electronics-operation/surveillance :escape :expert-skill/computer-security :fast-talk :filch :forced-entry :forgery :holdout :intelligence-analysis :interrogation :lip-reading :lockpicking :observation :photography :poisons :propaganda :research :search :shadowing :smuggling :stealth])
   :technical (select-keys skills [:battlesuit :computer-operation :diving-suit :electronics-operation/sp :explosives/sp :freight-handling :hazardous-materials/sp :lockpicking :mathematics/surveying :navigation/sp :parachuting :photography :scuba :vacc-suit])
   :transportation (select-keys skills [:airshipman :battlesuit :bicycling :boating :crewman :driving/sp :freight-handling :piloting :seamanship :shiphandling/sp :spacer :spacemarine/sp :submariner :teamster/sp])})

(defn default-skill-lvl
  [char skill]
  (let [default-funs (get-in skills [skill :default])]
    (->> (concat [(fn [_] 0)] default-funs)
         (map #(% char))
         (filter number?)
         (filter #(not (js/isNaN %)))
         (reduce max))))
