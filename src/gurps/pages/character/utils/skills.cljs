(ns gurps.pages.character.utils.skills)

(defn- get-in-any [m ks]
  "Like get-in, but takes a sequence of keys and returns the max value of the last key's starting name in the sequence.
   e.g. (get-in-any {:skills {:combat-melee {:shield-small 12 :shield-large 10}}} [:skills :combat-melee :shield])
        => 12"
  (->> (get-in m (butlast ks))
       seq
       (filter #(clojure.string/starts-with? (name (key %)) (name (last ks))))
       (map val)
       (reduce max)))

(def difficulties {:e :easy :a :average :h :hard :v :very-hard})

(def categories [:animal :arts :athletics :business :combat-melee :combat-ranged :craft :criminal :invention :esoteric :everyman :knowledge :medical :military :science :occult :outdoor :plant :police :repair :scholar :social :humanities :spy :technical :transportation])

(defn calc-hoc [keys subtrahend]
  (fn [char] (- (get-in char keys) subtrahend)))

(defn calc-any-hoc [keys subtrahend]
  (fn [char] (- (get-in-any char keys) subtrahend)))

(def animal-skills
  {:animal-handling/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]} ;; TODO: specializations
   :falconry {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                           (calc-hoc [:skills :animal :animal-handling-raptor] 3)]}
   :mimicry/animal-sounds {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :mimicry/bird-calls {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :mount {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :naturalist {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                             (calc-hoc [:skills :science :biology] 3)]}
   :packing {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                          (calc-hoc [:skills :animal :animal-handling/equines] 5)]}
   :riding/sp {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5),
                                            (calc-hoc [:skills :animal :animal-handling/same] 3)]}
   :teamster/sp {:diff :a :attr :iq :default [(calc-hoc [:skills :animal :animal-handling/same] 4),
                                              (calc-hoc [:skills :animal :riding/same] 2)]}
   :veterinary {:diff :a :attr :iq :default [(calc-hoc [:skills :animal :animal-handling] 6),
                                             (calc-hoc [:skills :medical :physician] 5),
                                             (calc-hoc [:skills :medical :surgery] 5)]}})

(def art-skills
  {:artist/sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)] :specializations []} ;; TODO: specs
   :connoisseur/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]} ;; TODO: specializations
   :current-affairs/high-culture {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4), (calc-hoc [:skills :scholar :research] 4)]}
   :current-affairs/popular-culture {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4), (calc-hoc [:skills :scholar :research] 4)]}
   :dancing {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :electronics-operation/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                           (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                           (calc-hoc [:skills :military :electronics-repair] 5),
                                                           (calc-hoc [:skills :invention :engineer/electronics] 5)]}
   :fire-eating {:diff :a :attr :dx}
   :group-performance/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]} ;; TODO: specs
   :makeup {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                         (calc-hoc [:skills :criminal :disguise] 2)]}
   :mimicry/sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]} ;; TODO: mimicry
   :musical-composition {:diff :h :attr :iq :default [(calc-hoc [:skills :arts :musical-instrument] 2),
                                                      (calc-hoc [:skills :arts :poetry] 2)]}
   :musical-instrument {:diff :h :attr :iq}
   :performance {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                              (calc-hoc [:skills :social :acting] 2),
                                              (calc-hoc [:skills :business :public-speaking] 2)]}
   :photography {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                              (calc-hoc [:skills :arts :electronics-operation/media] 2)]}
   :poetry {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                         (calc-hoc [:skills :arts :writing] 2)]}
   :singing {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :sleight-of-hand {:diff :a :attr :dx :default [(calc-hoc [:skills :criminal :filch] 5)]}
   :stage-combat {:diff :a :attr :dx :default [(calc-hoc [:skills :athletic :combat-art] 2),
                                               (calc-hoc [:skills :athletic :sports] 2),
                                               (calc-hoc [:skills :arts :performance] 3)]}
   :ventriloquism {:diff :h :attr :iq}
   :writing {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}})

(def athletics-skills
  {:acrobatics {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :aeronautics {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :aquabatics {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :bicycling {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4),
                                            (calc-hoc [:skills :transporation :driving/motorcycle] 4)]}
   :body-sense {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6),
                                             (calc-hoc [:skills :athletic :acrobatics] 3)]}
   :breath-control {:diff :h :attr :ht}
   :climbing {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   ;; :combat-art/sp :: TODO: fukin varies?
   :flight {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :free-fall {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5),
                                            (calc-hoc [:attributes :ht] 5)]}
   :hiking {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :jumping {:diff :e :attr :dx}
   :lifting {:diff :a :attr :ht}
   :mount {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :parachuting {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :running {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :scuba {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                        (calc-hoc [:skills :technical :diving-suit] 2)]}
   :sports/sp {:diff :a :attr :dx} ;; TODO: fuking special?
   :swimming {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :throwing {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 3)
                                           (calc-hoc [:skills :combat-ranged :dropping] 2)]}})

(def business-skills {:accounting {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                                (calc-hoc [:skills :business :finance] 4),
                                                                (calc-hoc [:skills :business :mathematics/statistics] 5),
                                                                (calc-hoc [:skills :business :merchant] 5)]}
                      :administration {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                                    (calc-hoc [:skills :business :merchant] 3)]}
                      :current-affairs/business {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                                                              (calc-hoc [:skills :scholarly :research] 4)]}
                      :diplomacy {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                               (calc-hoc [:skills :business :politics] 6)]}
                      :economics {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                               (calc-hoc [:skills :business :finance] 3),
                                                               (calc-hoc [:skills :business :market-analysis] 5),
                                                               (calc-hoc [:skills :business :merchant] 6)]}
                      :finance {:diff :h :attr :iq :default [(calc-hoc [:skills :business :merchant] 6),
                                                             (calc-hoc [:skills :business :accounting] 4),
                                                             (calc-hoc [:skills :business :economics] 3)]}
                      :law {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
                      :market-analysis {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                                     (calc-hoc [:skills :business :economics] 5),
                                                                     (calc-hoc [:skills :business :merchant] 4)]}
                      :mathematics/statistics {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
                      :merchant {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                              (calc-hoc [:skills :business :finance] 6),
                                                              (calc-hoc [:skills :business :market-analysis] 4)]}
                      :politics {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                              (calc-hoc [:skills :business :diplomacy] 5)]}
                      :public-speaking {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                                     (calc-hoc [:skills :business :politics] 5),
                                                                     (calc-hoc [:skills :social :acting] 5),
                                                                     (calc-hoc [:skills :arts :performance] 2)]}
                      :savoir-faire/high-society {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]} ;; TODO: and others?
                      })

(def combat-melee-skills
  {:axe-mace {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :flail] 4),
                                           (calc-hoc [:skills :combat-melee :two-handed-axe-mace] 3)]}
   :boxing {:diff :a :attr :dx}
   :brawling {:diff :e :attr :dx}
   :broadsword {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :force-sword] 4),
                                             (calc-hoc [:skills :combat-melee :rapier] 4),
                                             (calc-hoc [:skills :combat-melee :saber] 4),
                                             (calc-hoc [:skills :combat-melee :shortsword] 2),
                                             (calc-hoc [:skills :combat-melee :two-handed-sword] 4)]}
   :cloak {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5),
                                        (calc-hoc [:skills :combat-ranged :net] 4),
                                        (calc-any-hoc [:skills :combat-melee :shield] 4)]}
   :fast-draw/sp {:diff :e :attr :dx} ;; TODO specializations
   :flail {:diff :h :attr :dx :default [(calc-hoc [:skills :combat-melee :axe-mace] 4),
                                        (calc-hoc [:skills :combat-melee :two-handed-flail] 3)]}
   :force-sword {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :broadsword] 3),
                                              (calc-hoc [:skills :combat-melee :rapier] 3),
                                              (calc-hoc [:skills :combat-melee :saber] 3),
                                              (calc-hoc [:skills :combat-melee :shortsword] 3),
                                              (calc-hoc [:skills :combat-melee :smallsword] 3),
                                              (calc-hoc [:skills :combat-melee :two-handed-sword] 3)]}
   :force-whip {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :kusari] 3),
                                             (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                             (calc-hoc [:skills :combat-melee :whip] 3)]}
   :garrote {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :jitte-sai {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :force-sword] 4),
                                            (calc-hoc [:skills :combat-melee :main-gauche] 4),
                                            (calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :judo {:diff :h :attr :dx}
   :karate {:diff :h :attr :dx}
   :knife {:diff :e :attr :dx :default [(calc-hoc [:skills :combat-melee :force-sword] 3),
                                        (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                        (calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :kusari {:diff :h :attr :dx :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                         (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                         (calc-hoc [:skills :combat-melee :two-handed-flail] 4),
                                         (calc-hoc [:skills :combat-melee :whip] 3)]}
   :lance {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :spear] 3),
                                        (calc-hoc [:attributes :dx] 5)]}
   :main-gauche {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :knife] 4),
                                              (calc-hoc [:skills :combat-melee :jitte-sai] 4),
                                              (calc-hoc [:skills :combat-melee :rapier] 3),
                                              (calc-hoc [:skills :combat-melee :saber] 3),
                                              (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :monowire-whip {:diff :h :attr :dx :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                                (calc-hoc [:skills :combat-melee :kusari] 3),
                                                (calc-hoc [:skills :combat-melee :whip] 3)]}
   :parry-missile-weapons {:diff :h :attr :dx}
   :polearm {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :spear] 4),
                                          (calc-hoc [:skills :combat-melee :staff] 4),
                                          (calc-hoc [:skills :combat-melee :two-handed-axe-mace] 4)]}
   :rapier {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :broadsword] 3),
                                         (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                         (calc-hoc [:skills :combat-melee :saber] 3),
                                         (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :saber {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :broadsword] 4),
                                        (calc-hoc [:skills :combat-melee :main-gauche] 3),
                                        (calc-hoc [:skills :combat-melee :rapier] 3),
                                        (calc-hoc [:skills :combat-melee :shortsword] 4),
                                        (calc-hoc [:skills :combat-melee :smallsword] 3)]}
   :shield/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:buckler :shield :force]}
   :shortsword {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :broadsword] 2),
                                             (calc-hoc [:skills :combat-melee :force-sword] 4),
                                             (calc-hoc [:skills :combat-melee :jitte-sai] 3),
                                             (calc-hoc [:skills :combat-melee :knife] 4),
                                             (calc-hoc [:skills :combat-melee :saber] 4),
                                             (calc-hoc [:skills :combat-melee :smallsword] 4),
                                             (calc-hoc [:skills :combat-melee :tonfa] 3)]}
   :smallsword {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :main-gauche] 3),
                                             (calc-hoc [:skills :combat-melee :rapier] 3),
                                             (calc-hoc [:skills :combat-melee :saber] 3),
                                             (calc-hoc [:skills :combat-melee :shortsword] 4)]}
   :spear {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                        (calc-hoc [:skills :combat-melee :staff] 2)]}
   :staff {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                        (calc-hoc [:skills :combat-melee :spear] 2)]}
   :sumo-wrestling {:diff :a :attr :dx}
   :tonfa {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :shortsword] 3)]}
   :two-handed-axe-mace {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :polearm] 4),
                                                      (calc-hoc [:skills :combat-melee :axe-mace] 3),
                                                      (calc-hoc [:skills :combat-melee :two-handed-flail] 4)]}
   :two-handed-flail {:diff :h :attr :dx :default [(calc-hoc [:skills :combat-melee :flail] 3),
                                                   (calc-hoc [:skills :combat-melee :kusari] 4),
                                                   (calc-hoc [:skills :combat-melee :two-handed-axe-mace] 4)]}
   :two-handed-sword {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :broadsword] 4),
                                                   (calc-hoc [:skills :combat-melee :force-sword] 4)]}
   :whip {:diff :a :attr :dx :default [(calc-hoc [:skills :combat-melee :force-whip] 3),
                                       (calc-hoc [:skills :combat-melee :monowire-whip] 3),
                                       (calc-hoc [:skills :combat-melee :kusari] 3)]}
   :wrestling {:diff :a :attr :dx}})

(def combat-ranged-skills
  {:artillery/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)] :specializations [:beam :bomb :cannon :guided-missile :torpedo]}
   :beam-weapons/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:pistol :projector :rifle]}
   :blowpipe {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :bolas {:diff :a :attr :dx}
   :bow {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :crossbow {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :dropping {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 3),
                                           (calc-hoc [:skills :combat-ranged :throwing] 4)]}
   :fast-draw/sp {:diff :e :attr :dx :specializations [;; TODO
                                                       ]}
   :gunner/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:beam :cannon :catapult :machine-gun :rocket]}
   :guns/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:grenade-launcher :gyroc :light-antiarmor-weapon :light-machine-gun :musket :pistol :rifle :shotgun :submachine-gun :wrist-gun]}
   :innate-attack/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:beam :breath :gaze :projectile]}
   :lasso {:diff :a :attr :dx}
   :liquid-projector/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [:flamethrower :sprayer :squirt-gun :water-cannon]}
   :net {:diff :h :attr :dx :default [(calc-hoc [:skills :combat-melee :cloak] 5)]}
   :sling {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :spear-thrower {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5),
                                                (calc-hoc [:skills :combat-ranged :thrown-weapon/spear] 4)]}
   :throwing-art {:diff :h :attr :dx}
   :thrown-weapon/sp {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)] :specializations [;; TODO: melee weapons
                                                                                                     ]}})

(def craft-skills
  {:artist/pottery {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :artist/sculpting {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :artist/woodworking {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :bone-carving {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 2),
                                               (calc-hoc [:skills :military :armoury] 2)]}
   :carpentry {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :jeweler {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-hoc [:skills :craft :smith/copper] 4),
                                          (calc-hoc [:skills :craft :smith/lead-and-tin] 4)]}
   :leatherworking {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :masonry {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :smith/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)] :specializations [:copper :iron :lead-and-tin]}})

(def criminal-skills
  {:carousing {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :climbing {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :computer-hacking {:diff :v :attr :iq}
   :counterfeiting {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                 (calc-hoc [:skills :criminal :forgery] 2)]}
   :disguise/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                              (calc-hoc [:skills :arts :makeup] 3)]} ;; TODO: spec
   :electronics-operation/security {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                                 (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                 (calc-hoc [:skills :repair :electronics-repair/security] 5),
                                                                 (calc-hoc [:skills :invention :engineer/electronics] 5)]}
   :escape {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6)]}
   :explosives/demolition {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :fast-talk {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                            (calc-hoc [:skills :social :acting] 5),
                                            (calc-hoc [:skills :spy :acting] 5)]}
   :filch {:diff :a :attr :dx :default [(calc-hoc [:attributes :dx] 5),
                                        (calc-hoc [:skills :criminal :pickpocket] 4),
                                        (calc-hoc [:skills :criminal :sleight-of-hand] 4)]}
   :forced-entry {:diff :e :attr :dx}
   :forgery {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-hoc [:skills :criminal :counterfeiting] 2)]}
   :gambling {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                           (calc-hoc [:skills :science :mathematics/statistics] 5),
                                           (calc-hoc [:skills :business :mathematics/statistics] 5)]}
   :holdout {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                          (calc-hoc [:skills :criminal :sleight-of-hand] 3)]}
   :intimidation {:diff :a :attr :will :default [(calc-hoc [:attributes :will] 5),
                                                 (calc-hoc [:skills :spy :acting] 3),
                                                 (calc-hoc [:skills :social :acting] 3)]}
   :lockpicking {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :observation {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                               (calc-hoc [:skills :police :shadowing] 5),
                                               (calc-hoc [:skills :spy :shadowing] 5),
                                               (calc-hoc [:skills :criminal :shadowing] 5)]}
   :panhandling {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                              (calc-hoc [:skills :criminal :fast-talk] 2),
                                              (calc-hoc [:skills :business :public-speaking] 3),
                                              (calc-hoc [:skills :scholar :public-speaking] 3),
                                              (calc-hoc [:skills :social :public-speaking] 3)]}
   :pickpocket {:diff :h :attr :dx :default [(calc-hoc [:attributes :dx] 6),
                                             (calc-hoc [:skills :criminal :filch] 5),
                                             (calc-hoc [:skills :criminal :sleight-of-hand] 4)]}
   :poisons {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-hoc [:skills :science :chemistry] 5),
                                          (calc-any-hoc [:skills :science :pharmacy] 3),
                                          (calc-hoc [:skills :medical :physician] 3)]}
   :savoir-faire/mafia {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :scrounging {:diff :e :attr :per :default [(calc-hoc [:attributes :per] 4)]}
   :shadowing {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                            (calc-hoc [:skills :military :observation] 5),
                                            (calc-hoc [:skills :spy :observation] 5),
                                            (calc-hoc [:skills :criminal :observation] 5),
                                            (calc-hoc [:skills :criminal :stealth] 4),
                                            (calc-hoc [:skills :police :stealth] 4),
                                            (calc-hoc [:skills :spy :stealth] 4)]}
   :streetwise {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                             (calc-hoc [:attributes :dx] 5)]}
   :traps {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                        (calc-hoc [:skills :police :lockpicking] 3),
                                        (calc-hoc [:skills :criminal :lockpicking] 3),
                                        (calc-hoc [:skills :spy :lockpicking] 3),
                                        (calc-hoc [:skills :technical :lockpicking] 3)]}
   :urban-survival {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5)]}})

(def invention-skills
  {:architecture {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                               (calc-hoc [:skills :invention :engineer-civil] 5)]}
   :bioengineering/sp {:diff :h :attr :iq :default [(calc-hoc [:skills :science :biology] 5),
                                                    (calc-hoc [:skills :plant :biology] 5)]} ;; TODO: spec
   :computer-programming {:diff :h :attr :iq}
   :engineer/sp {:diff :h :attr :iq, :specializations [:artillery :civil :clockwork :combat :electrical :materials :microtechnology :mining :nanotechnology :parachronic :psychothronics :robotics :small-arms :temporal :vehicle]}
   :pharmacy/sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)], :specializations [:herbal :synthetic]}
   :weird-science {:diff :v :attr :iq}})

(def esoteric-skills
  {:autohypnosis {:diff :h :attr :will :default [(calc-hoc [:skills :esoteric :meditation] 4)]}
   :blind-fighting {:diff :v :attr :per}
   :body-control {:diff :v :attr :ht}
   :breaking-blow {:diff :h :attr :iq}
   :captivate {:diff :h :attr :will}
   :dreaming {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6)]}
   ;; :enthralment TODO
   :flying-leap {:diff :h :attr :iq}
   :immovable-stance {:diff :h :attr :dx}
   :invisibility-art {:diff :v :attr :iq}
   :kiai {:diff :h :attr :ht}
   :light-walk {:diff :h :attr :dx}
   :meditation {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6),
                                               (calc-hoc [:skills :esoteric :autohypnosis] 4)]}
   :mental-strength {:diff :e :attr :will}
   :mind-block {:diff :a :attr :will :default [(calc-hoc [:attributes :will] 5),
                                               (calc-hoc [:skills :esoteric :meditation] 5)]}
   :musical-influence {:diff :v :attr :iq}
   :persuade {:diff :h :attr :will}
   :power-blow {:diff :h :attr :will}
   :pressure-points {:diff :h :attr :iq}
   :pressure-secrets {:diff :v :attr :iq}
   :push {:diff :h :attr :dx}
   :suggest {:diff :h :attr :will}
   :sway-emotions {:diff :h :attr :will}
   :throwing-art {:diff :h :attr :dx}
   :zen-archery {:diff :v :attr :iq}
   :zen-marksmanship {:diff :v :attr :iq}})

(def everyman-skills
  {:area-knowledge/sp {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                                    (calc-hoc [:skills :humanities :geography/same] 3)],
                       :specializations [:city :country :region :world]}
   :computer-operation {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :cooking {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5), (calc-hoc [:skills :everyman :housekeeping] 5)]}
   :housekeeping {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :knot-tying {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4),
                                             (calc-hoc [:skills :transportation :seamanship] 4),
                                             (calc-hoc [:skills :outdoor :climbing] 4),
                                             (calc-hoc [:skills :criminal :climbing] 4),
                                             (calc-hoc [:skills :athletic :climbing] 4)]}
   :savoir-faire/servant {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]}
   :sewing {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :typing {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :weather-sense {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}})

(def knowledge-skills
  {:area-knowledge/sp {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                                    (calc-hoc [:skills :humanities :geography/same] 3)],
                       :specializations [:city :country :region :world]}
   :connoisseur/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)] :specializations []} ;; TODO specializations
   :current-affairs/sp {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                                     (calc-hoc [:skills :spy :research] 4)
                                                     (calc-hoc [:skills :scholar :research] 4)] ;; TODO: spec
                        :specializations []} ;; TODO
   :games/sp {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)], :specializations []} ;; TODO specializations
   :heraldry {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                           (calc-hoc [:skills :business :savoir-faire/high-society] 3),
                                           (calc-hoc [:skills :knowledge :savoir-faire/high-society] 3)
                                           (calc-hoc [:skills :social :savoir-faire/high-society] 3)]}
   :hidden-lore/sp {:diff :a :attr :iq :specializations []} ;; TODO specializations
   :hobby-skill/sp {:diff :e :attr [:iq :dx] :default [(calc-hoc [:attributes :iq] 4), (calc-hoc [:attributes :dx] 4)] :specializations []} ;; TODO specializations
   :professional-skill/sp {:diff :e :attr [:iq :dx] :specializations []} ;; TODO default/specializations
   :savoir-faire/sp {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)] :specializations []} ;; TODO specializations
   })

(def medical-skills
  {:diagnosis {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                            (calc-hoc [:skills :medical :first-aid] 8),
                                            (calc-hoc [:skills :medical :physician] 4),
                                            (calc-hoc [:skills :medical :veterinary] 5),
                                            (calc-hoc [:skills :animal :veterinary] 5)]}
   :electronics-operation/medical {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                                (calc-hoc [:skills :invention :engineer/electrical] 3),
                                                                (calc-hoc [:skills :invention :engineer/electronics] 5),
                                                                (calc-hoc [:skills :repair :electronics-repair/medical] 5)]}
   :esoteric-medicine {:diff :h :attr :per :default [(calc-hoc [:attributes :per] 6)]}
   :expert-skill-epidemiology {:diff :h :attr :iq}
   :first-aid {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4),
                                            (calc-hoc [:skills :medical :esoteric-medicine] 0),
                                            (calc-hoc [:skills :medical :physician] 0),
                                            (calc-hoc [:skills :medical :veterinary] 4)]}
   :hypnotism {:diff :h :attr :iq}
   :pharmacy-sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)] :specializations []} ;; TODO: specializations
   :physician {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 7),
                                            (calc-hoc [:skills :medical :first-aid] 11),
                                            (calc-hoc [:skills :medical :veterinary] 5),
                                            (calc-hoc [:skills :animal :veterinary] 5)]}
   :poisons {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-hoc [:skills :science :chemistry] 5),
                                          (calc-any-hoc [:skills :medical :pharmacy] 3),
                                          (calc-hoc [:skills :medical :physician] 3)]}
   :psychology {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                             (calc-hoc [:skills :humanities :sociology] 4)]}
   :surgery {:diff :v :attr :iq :default [(calc-hoc [:skills :medical :first-aid] 12),
                                          (calc-hoc [:skills :medical :physician] 5),
                                          (calc-hoc [:skills :science :physiology] 8),
                                          (calc-hoc [:skills :medical :veterinary] 5),
                                          (calc-hoc [:skills :animal :veterinary] 5)]}
   :veterinary {:diff :h :attr :iq :default [(calc-any-hoc [:skills :animal :animal-handling] 6),
                                             (calc-hoc [:skills :medical :physician] 5),
                                             (calc-hoc [:skills :medical :surgery] 5)]}})

(def military-skills
  {:armoury/sp {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                             (calc-hoc [:skills :invention :engineer/same] 3) ;; TODO: same calculation
                                             ]:specializations []} ;; TODO spec
   :brain-hacking {:diff :h :attr :iq} ;; TODO: special
   :brainwashing {:diff :h :attr :iq} ;; TODO: special
   :camouflage {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)
                                             (calc-hoc [:skills :outdoor :survival] 2)]}
   :cryptography {:diff :h :attr :iq :default [(calc-hoc [:attributes :science :mathematics/cryptology] 5)]}
   :electronics-operation/electronic-warfare {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                                           (calc-hoc [:skills :science :engineer/electrical] 3),
                                                                           (calc-hoc [:skills :science :engineer/electronics] 5),
                                                                           (calc-hoc [:skills :spy :electronics-repair/electronic-warfare] 3),
                                                                           (calc-hoc [:skills :repair :electronics-repair/electronic-warfare] 3),
                                                                           (calc-hoc [:skills :technical :electronics-repair/electronic-warfare] 3),
                                                                           (calc-hoc [:skills :military :electronics-repair/electronic-warfare] 3)]}
   :expert-skill/military-science {:diff :h :attr :iq}
   :explosives {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :forward-observer {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                   (calc-hoc [:skills :combat-ranged :artillery] 5)]}
   :intelligence-analysis {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                        (calc-any-hoc [:skills :military :strategy] 6)]}
   :interrogation {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                                (calc-hoc [:skills :police :intimidation] 3),
                                                (calc-hoc [:skills :social :intimidation] 3),
                                                (calc-hoc [:skills :criminal :intimidation] 3),
                                                (calc-hoc [:skills :humanities :psychology] 4),
                                                (calc-hoc [:skills :medical :psychology] 4)]}
   :leadership {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :nbc-suit {:diff :a :attr :dx :default [(calc-hoc [:skills :technical :battlesuit] 2),
                                           (calc-hoc [:skills :vehicle :battlesuit] 2),
                                           (calc-hoc [:skills :technical :diving-suit] 4),
                                           (calc-hoc [:skills :technical :vacc-suit] 2)]} ;; TODO vacc suit comes from where
   :observation {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                               (calc-hoc [:skills :spy :shadowing] 5),
                                               (calc-hoc [:skills :police :shadowing] 5),
                                               (calc-hoc [:skills :criminal :shadowing] 5)]}
   :parachuting {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 4)]}
   :propaganda {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                             (calc-hoc [:skills :social :merchant] 5),
                                             (calc-hoc [:skills :business :merchant] 5),
                                             (calc-hoc [:skills :humanities :psychology] 4),
                                             (calc-hoc [:skills :medical :psychology] 4)]}
   :savoir-faire/military {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)]} ;; TODO: and others
   :scuba {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                        (calc-hoc [:skills :technical :diving-suit] 2)]}
   :soldier {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :strategy/sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                              (calc-hoc [:skills :military :intelligence-analysis] 6),
                                              (calc-hoc [:skills :spy :intelligence-analysis] 6),
                                              (calc-hoc [:skills :military :tactics] 6),
                                              (calc-hoc [:skills :police :tactics] 6)]}
   :tactics {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-any-hoc [:skills :military :strategy] 6)]}
   :traps {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                        (calc-hoc [:skills :police :lockpicking] 6),
                                        (calc-hoc [:skills :spy :lockpicking] 6),
                                        (calc-hoc [:skills :technical :lockpicking] 6),
                                        (calc-hoc [:skills :criminal :lockpicking] 6)]}})

(def science-skills
  {:alchemy {:diff :v :attr :iq}
   :astronomy {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :biology {:diff :v :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                          (calc-hoc [:skills :science :naturalist] 6),
                                          (calc-hoc [:skills :outdoor :naturalist] 6),
                                          (calc-hoc [:skills :plant :naturalist] 6),
                                          (calc-hoc [:skills :animal :naturalist] 6)]}
   :chemistry {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                            (calc-hoc [:skills :science :alchemy] 3)]}
   :expert-skill/epidemiology {:diff :h :attr :iq}
   :expert-skill/hydrology {:diff :h :attr :iq}
   :expert-skill/natural-philosofy {:diff :h :attr :iq}
   :geology/sp {:diff :h :attr :iq :specializations [] :default [(calc-hoc [:attributes :iq] 6),
                                                                 (calc-hoc [:skills :humanities :geography/physical] 4),
                                                                 (calc-hoc [:skills :outdoor :prospecting] 5)]} ;; TODO: specializations
   :mathematics/sp {:diff :h :attr :iq :specializations [] :default [(calc-hoc [:attributes :iq] 6)]} ;; TODO: specializations
   :metallurgy {:diff :h :attr :iq :default [(calc-hoc [:skills :science :chemistry] 5),
                                             (calc-hoc [:skills :craft :jeweller] 8),
                                             (calc-any-hoc [:skills :craft :smith] 8)]}
   :meteorology/sp {:diff :a :attr :iq :specializations [] :default [(calc-hoc [:attributes :iq] 5)]} ;; TODO: specializations
   :naturalist {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                             (calc-hoc [:skills :science :biology] 3),
                                             (calc-hoc [:skills :plant :biology] 3)]}
   :paleontology/sp {:diff :h :attr :iq :default [(calc-hoc [:skills :science :biology] 4),
                                                  (calc-hoc [:skills :plant :biology] 4)] :specializations []} ;; TODO: specializations
   :physics {:diff :v :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :physiology/sp {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                                (calc-hoc [:skills :medical :diagnosis] 5),
                                                (calc-hoc [:skills :medical :physician] 5),
                                                (calc-hoc [:skills :medical :surgery] 5)] :specializations []} ;; TODO: specializations
   })

(def occult-skills
  {:alchemy {:diff :v :attr :iq}
   :exorcism {:diff :h :attr :will :default [(calc-hoc [:attributes :will] 6)
                                             (calc-any-hoc [:skills :occult :religious-ritual] 3),
                                             (calc-any-hoc [:skills :occult :religious-magic] 3),
                                             (calc-any-hoc [:skills :humanities :theology] 3)]}
   :expert-skill/psionics {:diff :h :attr :iq}
   :herb-lore {:diff :v :attr :iq}
   :hidden-lore/demon-lore {:diff :a :attr :iq}
   :hidden-lore/faerie-lore {:diff :a :attr :iq}
   :hidden-lore/spirit-lore {:diff :a :attr :iq}
   :occultism {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   :religious-ritual/sp {:diff :h :attr :iq :default [(calc-hoc [:skills :occult :religious-magic/same] 6)
                                                      (calc-hoc [:skills :humanities :theology/same] 4)]} ;; TODO: specializations
   :ritual-magic/sp {:diff :v :attr :iq :default [(calc-hoc [:skills :occult :religious-ritual/same] 6)]}
   :symbol-drawing/sp {:diff :h :attr :iq :default []} ;; TODO: special, spec
   :thaumatology {:diff :v :attr :iq :default [(calc-hoc [:attributes :iq] 7)]}})

(def outdoor-skills
  {:camouflage {:diff :e :attr :iq :default [(calc-hoc [:attributes :iq] 4)
                                             (calc-hoc [:skills :outdoor :survival] 2)]}
   :cartography {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)
                                              (calc-any-hoc [:skills :humanities :geography] 2),
                                              (calc-hoc [:skills :science :mathematics/surveying] 2),
                                              (calc-hoc [:skills :technical :mathematics/surveying] 2),
                                              (calc-any-hoc [:skills :outdoor :navigation] 4),
                                              (calc-any-hoc [:skills :technical :navigation] 4)]}
   :climbing {:diff :e :attr :dx :default [(calc-hoc [:attributes :dx] 5)]}
   :fishing {:diff :e :attr :per :default [(calc-hoc [:attributes :per] 4)]}
   :hiking {:diff :a :attr :ht :default [(calc-hoc [:attributes :ht] 5)]}
   :mimicry/animal-sounds {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :mimicry/bird-calls {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6)]}
   :naturalist {:diff :h :attr :iq :default [(calc-hoc [:attributes :iq] 6),
                                             (calc-hoc [:skills :science :biology] 3),
                                             (calc-hoc [:skills :plant :biology] 3)]}
   :navigation/sp {:diff :a :attr :iq :default []} ;; TODO: specializations, special
   :prospecting {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                              (calc-any-hoc [:skills :science :geology] 4)]}
   :scuba {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5),
                                        (calc-hoc [:skills :technical :diving-suit] 2)]}
   :skating {:diff :h :attr :ht :default [(calc-hoc [:attributes :ht] 6)]}
   :skiing {:diff :h :attr :ht :default [(calc-hoc [:attributes :ht] 6)]}
   :survival/sp {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                               (calc-hoc [:skills :science :naturalist] 3),
                                               (calc-hoc [:skills :outdoor :naturalist] 3)
                                               (calc-hoc [:skills :animal :naturalist] 3)]} ;; TODO: same planet
   :swimming {:diff :e :attr :ht :default [(calc-hoc [:attributes :ht] 4)]}
   :tracking {:diff :a :attr :per :default [(calc-hoc [:attributes :per] 5),
                                            (calc-hoc [:skills :science :naturalist] 5),
                                            (calc-hoc [:skills :outdoor :naturalist] 5)
                                            (calc-hoc [:skills :animal :naturalist] 5)]}
   :weather-sense {:diff :a :attr :iq :default [(calc-hoc [:attributes :iq] 5)]}
   ;;
   })

;; TODO: specializations
;; TODO: techlevel
;; TODO: prerequisites
;; TODO: same-type default
;; TODO: change all specializations from -sp to /sp
(def skills {:animal animal-skills
             :arts art-skills
             :athletic athletics-skills
             :business business-skills
             :combat-melee combat-melee-skills
             :combat-ranged combat-ranged-skills
             :craft craft-skills
             :criminal criminal-skills
             :invention invention-skills
             :esoteric esoteric-skills
             :everyman everyman-skills
             :knowledge knowledge-skills
             :medical medical-skills
             :military military-skills
             :science science-skills
             :occult occult-skills
             :outdoor outdoor-skills})
