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

(def categories [:animal :arts :athletics :business :combat-melee :combat-ranged :craft :criminal :invention :esoteric :everyman :knowledge :medical :military :science :occult :outdoors :plant :police :repair :scholar :social :humanities :spy :technical :transportation])

;; TODO: specializations
;; TODO: techlevel
(def skills {:animal {:animal-handling {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                      :falconry {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                              (fn [char]
                                                                (if-let [raptor-skill (get-in char [:skills :animal :animal-handling-raptor])]
                                                                  (- raptor-skill 3)))]} ;; TODO: raptor sub-skill
                      :mimicry {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]} ;; TODO animal sounds, bird calls, etc
                      :mount {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                      :naturalist {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)), (fn [char] (- (get-in char [:skills :science :biology]) 3))]}
                      :packing {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)), (fn [char] (- (get-in char [:skills :animal :animal-handling-equine]) 5))]}
                      :riding {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)), (fn [char] (- (get-in char [:skills :animal :animal-handling-equine]) 3))]}
                      :teamster {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:skills :animal :animal-handling]) 4)), (fn [char] (- (get-in char [:skills :animal :riding]) 2))]}
                      :veterinary {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:skills :animal :animal-handling]) 6)),
                                                                (fn [char] (- (get-in char [:skills :medical :physician]) 5)),
                                                                (fn [char] (- (get-in char [:skills :medical :surgery]) 5))]}}

             :arts {:artist {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                    :connoisseur {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                    :current-affairs {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)), (fn [char] (- (get-in char [:skills :scholar :research]) 4))]}
                    :dancing {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                    :electronics-op {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :invention :engineer :electrical]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :military :electronics-repair]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :invention :engineer :electronics]) 5))]}
                    :fire-eating {:diff :a :attr :dx :default []}
                    :group-performance {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}
                    :makeup {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)),
                                                          (fn [char] (- (get-in char [:skills :criminal :disguise]) 2))]}
                    :mimicry {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                    :musical-composition {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:skills :arts :musical-instrument]) 2)),
                                                                       (fn [char] (- (get-in char [:skills :arts :poetry]) 2))]}
                    :musical-instrument {:diff :h :attr :iq :default []}
                    :performance {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                               (fn [char] (- (get-in char [:skills :social :acting]) 2)),
                                                               (fn [char] (- (get-in char [:skills :business :public-speaking]) 2))]}
                    :photography {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                               (fn [char] (- (get-in char [:skills :arts :electronics-op]) 2))]}
                    :poetry {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                          (fn [char] (- (get-in char [:skills :arts :writing]) 2))]}
                    :singing {:diff :e :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 4))]}
                    :sleight-of-hand {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :criminal :filch]) 5))]}
                    :stage-combat {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :athletic :combat-art]) 2)),
                                                                (fn [char] (- (get-in char [:skills :athletic :sports]) 2)),
                                                                (fn [char] (- (get-in char [:skills :arts :performance]) 3))]}
                    :ventriloquism {:diff :h :attr :iq :default []}
                    :writing {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))]}}

             :athletic {:acrobatics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :aeronautics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :aquabatics {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                        :bicycling {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :vehicle :driving :motorcycle]) 4))]}
                        :body-sense {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6)),
                                                                  (fn [char] (- (get-in char [:skills :athletic :acrobatics]) 3))]}
                        :breath-control {:diff :h :attr :ht :default []}
                        :climbing {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                        ;; :combat-art :: TODO: fukin varies?
                        :flight {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :free-fall {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)),
                                                                 (fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :hiking {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :jumping {:diff :e :attr :dx :default []}
                        :lifting {:diff :a :attr :ht :default []}
                        :mount {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                        :parachuting {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))]}
                        :running {:diff :a :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 5))]}
                        :scuba {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                             (fn [char] (- (get-in char [:skills :technical :diving-suit]) 2))]}
                        :sports {:diff :a :attr :dx :default []} ;; TODO: fuking special?
                        :swimming {:diff :e :attr :ht :default [(fn [char] (- (get-in char [:attributes :ht]) 4))]}
                        :throwing {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 3))
                                                                (fn [char] (- (get-in char [:skills :combat-ranged :dropping]) 2))]}}

             :business {:accounting {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                  (fn [char] (- (get-in char [:skills :business :finance]) 4)),
                                                                  (fn [char] (- (get-in char [:skills :business :mathematics-statistics]) 5)),
                                                                  (fn [char] (- (get-in char [:skills :business :merchant]) 5))]}
                        :administration {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                      (fn [char] (- (get-in char [:skills :business :merchant]) 3))]}
                        :current-affairs-business {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4)),
                                                                                (fn [char] (- (get-in char [:skills :scholarly :research]) 4))]}
                        :diplomacy {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                 (fn [char] (- (get-in char [:skills :business :politics]) 6))]}
                        :economics {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                 (fn [char] (- (get-in char [:skills :business :finance]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :business :market-analysis]) 5)),
                                                                 (fn [char] (- (get-in char [:skills :business :merchant]) 6))]}
                        :finance {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:skills :business :merchant]) 6)),
                                                               (fn [char] (- (get-in char [:skills :business :accounting]) 4)),
                                                               (fn [char] (- (get-in char [:skills :business :economics]) 3))]}
                        :law {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                        :market-analysis {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6)),
                                                                       (fn [char] (- (get-in char [:skills :business :economics]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :business :merchant]) 4))]}
                        :mathematics-statistics {:diff :h :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 6))]}
                        :merchant {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                (fn [char] (- (get-in char [:skills :business :finance]) 6)),
                                                                (fn [char] (- (get-in char [:skills :business :market-analysis]) 4))]}
                        :politics {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                (fn [char] (- (get-in char [:skills :business :diplomacy]) 5))]}
                        :public-speaking {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :business :politics]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :social :acting]) 5)),
                                                                       (fn [char] (- (get-in char [:skills :arts :performance]) 2))]}
                        :savoir-faire-high-society {:diff :e :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 4))]} ;; TODO: and others?
                        }

             :combat-melee {:axe-mace {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :flail]) 4)),
                                                                    (fn [char] (- (get-in char [:skills :combat-melee :two-handed-axe-mace]) 3))]}
                            :boxing {:diff :a :attr :dx :default []}
                            :brawling {:diff :e :attr :dx :default []}
                            :broadsword {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-sword]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :rapier]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :saber]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 2)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :two-handed-sword]) 4))]}
                            :cloak {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)),
                                                                 (fn [char] (- (get-in char [:skills :combat-ranged :net]) 4)),
                                                                 (fn [char] (- (get-in-any char [:skills :combat-melee :shield]) 4))]}
                            :fast-draw-sp {:diff :e :attr :dx :default []}
                            :flail {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :axe-mace]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :two-handed-flail]) 3))]}
                            :force-sword {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :broadsword]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :rapier]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :saber]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :smallsword]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :two-handed-sword]) 3))]}
                            :force-whip {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :kusari]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :monowire-whip]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :whip]) 3))]}
                            :garrote {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))]}
                            :jitte-sai {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-sword]) 4)),
                                                                     (fn [char] (- (get-in char [:skills :combat-melee :main-gauche]) 4)),
                                                                     (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 3))]}
                            :judo {:diff :h :attr :dx :default []}
                            :karate {:diff :h :attr :dx :default []}
                            :knife {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-sword]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :main-gauche]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 3))]}
                            :kusari {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-whip]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :monowire-whip]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :two-handed-flail]) 4)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :whip]) 3))]}
                            :lance {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :spear]) 3)),
                                                                 (fn [char] (- (get-in char [:attributes :dx]) 5))]}
                            :main-gauche {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :knife]) 4)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :jitte-sai]) 4)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :rapier]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :saber]) 3)),
                                                                       (fn [char] (- (get-in char [:skills :combat-melee :smallsword]) 3))]}
                            :monowire-whip {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-whip]) 3)),
                                                                         (fn [char] (- (get-in char [:skills :combat-melee :kusari]) 3)),
                                                                         (fn [char] (- (get-in char [:skills :combat-melee :whip]) 3))]}
                            :parry-missile-weapons {:diff :h :attr :dx :default []}
                            :polearm {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :spear]) 4)),
                                                                   (fn [char] (- (get-in char [:skills :combat-melee :staff]) 4)),
                                                                   (fn [char] (- (get-in char [:skills :combat-melee :two-handed-axe-mace]) 4))]}
                            :rapier {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :broadsword]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :main-gauche]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :saber]) 3)),
                                                                  (fn [char] (- (get-in char [:skills :combat-melee :smallsword]) 3))]}
                            :saber {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :broadsword]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :main-gauche]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :rapier]) 3)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :smallsword]) 3))]}
                            :shield-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:buckler :shield :force]}
                            :shortsword {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :broadsword]) 2)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :force-sword]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :jitte-sai]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :knife]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :saber]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :smallsword]) 4)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :tonfa]) 3))]}
                            :smallsword {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :main-gauche]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :rapier]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :saber]) 3)),
                                                                      (fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 4))]}
                            :spear {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :polearm]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :staff]) 2))]}
                            :staff {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :polearm]) 4)),
                                                                 (fn [char] (- (get-in char [:skills :combat-melee :spear]) 2))]}
                            :sumo-wrestling {:diff :a :attr :dx :default []}
                            :tonfa {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :shortsword]) 3))]}
                            :two-handed-axe-mace {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :polearm]) 4)),
                                                                               (fn [char] (- (get-in char [:skills :combat-melee :axe-mace]) 3)),
                                                                               (fn [char] (- (get-in char [:skills :combat-melee :two-handed-flail]) 4))]}
                            :two-handed-flail {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :flail]) 3)),
                                                                            (fn [char] (- (get-in char [:skills :combat-melee :kusari]) 4)),
                                                                            (fn [char] (- (get-in char [:skills :combat-melee :two-handed-axe-mace]) 4))]}
                            :two-handed-sword {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :broadsword]) 4)),
                                                                            (fn [char] (- (get-in char [:skills :combat-melee :force-sword]) 4))]}
                            :whip {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :force-whip]) 3)),
                                                                (fn [char] (- (get-in char [:skills :combat-melee :monowire-whip]) 3)),
                                                                (fn [char] (- (get-in char [:skills :combat-melee :kusari]) 3))]}
                            :wrestling {:diff :a :attr :dx :default []}}

             :combat-ranged {:artillery-sp {:diff :a :attr :iq :default [(fn [char] (- (get-in char [:attributes :iq]) 5))] :specializations [:beam :bomb :cannon :guided-missile :torpedo]}
                             :beam-weapons-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:pistol :projector :rifle]}
                             :blowpipe {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                             :bolas {:diff :a :attr :dx :default []}
                             :bow {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5))]}
                             :crossbow {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))]}
                             :dropping {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 3)),
                                                                     (fn [char] (- (get-in char [:skills :combat-ranged :throwing]) 4))]}
                             :fast-draw-sp {:diff :e :attr :dx :default [] :specializations [;; TODO
                                                                                             ]}
                             :gunner-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:beam :cannon :catapult :machine-gun :rocket]}
                             :guns-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:grenade-launcher :gyroc :light-antiarmor-weapon :light-machine-gun :musket :pistol :rifle :shotgun :submachine-gun :wrist-gun]}
                             :innate-attack-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:beam :breath :gaze :projectile]}
                             :lasso {:diff :a :attr :dx :default []}
                             :liquid-projector-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [:flamethrower :sprayer :squirt-gun :water-cannon]}
                             :net {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:skills :combat-melee :cloak]) 5))]}
                             :sling {:diff :h :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 6))]}
                             :spear-thrower {:diff :a :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 5)),
                                                                          (fn [char] (- (get-in char [:skills :combat-ranged :thrown-weapon-spear]) 4))]}
                             :throwing-art {:diff :h :attr :dx :default []}
                             :thrown-weapon-sp {:diff :e :attr :dx :default [(fn [char] (- (get-in char [:attributes :dx]) 4))] :specializations [;; TODO: melee weapons
                                                                                                                                                  ]}}
             :craft {}})
