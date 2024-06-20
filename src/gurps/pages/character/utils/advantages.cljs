(ns gurps.pages.character.utils.advantages)

(def advantages
  [{:name :360°-vision :type-1 :physical :type-2 :exotic :cost 25}
   {:name :absolute-timing :type-1 :mental :type-2 :mundane :cost [2 5]}
   {:name :acute-senses :type-1 :physical :type-2 :mundane :cost 2}
   {:name :affliction :type-1 :physical :type-2 :exotic :cost 10}
   {:name :allies :type-1 :social :type-2 :mundane :cost :variable}
   {:name :altered-time-rate :type-1 :mental :type-2 :exotic :cost 100}
   {:name :alternate-identity :type-1 :social :type-2 :mundane :cost :variable}
   {:name :ambidexterity :type-1 :physical :type-2 :mundane :cost 5}
   {:name :amphibious :type-1 :physical :type-2 :exotic :cost 10}
   {:name :animal-empathy :type-1 :mental :type-2 :mundane :cost 5}
   {:name :arm-dx :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :arm-st :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :binding :type-1 :physical :type-2 :exotic :cost 2}
   {:name :blessed :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :brachiator :type-1 :physical :type-2 :exotic :cost 5}
   {:name :breath-holding :type-1 :physical :type-2 :exotic :cost 2}
   {:name :catfall :type-1 :physical :type-2 :exotic :cost 10}
   {:name :chameleon :type-1 :physical :type-2 :exotic :cost 5}
   {:name :channeling :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :charisma :type-1 :social :type-2 :mundane :cost 5}
   {:name :claim-to-hospitality :type-1 :social :type-2 :mundane :cost :variable}
   {:name :clairsentience :type-1 :mental :type-2 :supernatural :cost 50}
   {:name :claws :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :clerical-investment :type-1 :social :type-2 :mundane :cost 5}
   {:name :clinging :type-1 :physical :type-2 :exotic :cost 20}
   {:name :combat-reflexes :type-1 :mental :type-2 :mundane :cost 15}
   {:name :common-sense :type-1 :mental :type-2 :mundane :cost 10}
   {:name :compartmentalized-mind :type-1 :mental :type-2 :exotic :cost 50}
   {:name :constriction-attack :type-1 :physical :type-2 :exotic :cost 15}
   {:name :contact-group :type-1 :social :type-2 :mundane :cost :variable}
   {:name :contacts :type-1 :social :type-2 :mundane :cost :variable}
   {:name :cultural-adaptability :type-1 :mental :type-2 :mundane :cost [10 20]}
   {:name :cybernetics :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :damage-resistance :type-1 :physical :type-2 :exotic :cost 5}
   {:name :danger-sense :type-1 :mental :type-2 :mundane :cost 15}
   {:name :daredevil :type-1 :mental :type-2 :mundane :cost 15}
   {:name :dark-vision :type-1 :physical :type-2 :exotic :cost 25}
   {:name :destiny :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :digital-mind :type-1 :physical :type-2 :exotic :cost 5}
   {:name :discriminatory-hearing :type-1 :physical :type-2 :exotic :cost 15}
   {:name :discriminatory-smell :type-1 :physical :type-2 :exotic :cost 15}
   {:name :discriminatory-taste :type-1 :physical :type-2 :exotic :cost 10}
   {:name :doesn't-breathe :type-1 :physical :type-2 :exotic :cost 20}
   {:name :doesn't-eat-or-drink :type-1 :physical :type-2 :exotic :cost 10}
   {:name :doesn't-sleep :type-1 :physical :type-2 :exotic :cost 20}
   {:name :dominance :type-1 :mental :type-2 :supernatural :cost 20}
   {:name :eidetic-memory :type-1 :mental :type-2 :mundane :cost [5 10]}
   {:name :elastic-skin :type-1 :physical :type-2 :exotic :cost 20}
   {:name :empathy :type-1 :mental :type-2 :mundane :cost [5 15]}
   {:name :enhanced-defenses :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :enhanced-move :type-1 :physical :type-2 :exotic :cost 20}
   {:name :enhanced-time-sense :type-1 :mental :type-2 :exotic :cost 45}
   {:name :enhanced-tracking :type-1 :physical :type-2 :exotic :cost 5}
   {:name :extended-lifespan :type-1 :physical :type-2 :exotic :cost 2}
   {:name :extra-arms :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :extra-attack :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :extra-head :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :extra-legs :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :extra-life :type-1 :mental :type-2 :exotic :cost :variable}
   {:name :extra-mouth :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :favor :type-1 :social :type-2 :mundane :cost :variable}
   {:name :fearlessness :type-1 :mental :type-2 :mundane :cost 2}
   {:name :filter-lungs :type-1 :physical :type-2 :exotic :cost 5}
   {:name :fit :type-1 :physical :type-2 :mundane :cost [5 15]}
   {:name :flexibility :type-1 :physical :type-2 :mundane :cost [5 15]}
   {:name :flight :type-1 :physical :type-2 :exotic :cost 40}
   {:name :gadgeteer :type-1 :mental :type-2 :mundane :cost [25 50]}
   {:name :gizmos :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :g-experience :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :growth :type-1 :physical :type-2 :exotic :cost 10}
   {:name :gunslinger :type-1 :mental :type-2 :mundane :cost 25}
   {:name :hard-to-kill :type-1 :physical :type-2 :mundane :cost 2}
   {:name :hard-to-subdue :type-1 :physical :type-2 :mundane :cost 2}
   {:name :healing :type-1 :mental :type-2 :exotic :cost 30}
   {:name :high-pain-threshold :type-1 :physical :type-2 :mundane :cost 10}
   {:name :hermaphromorph :type-1 :physical :type-2 :exotic :cost 5}
   {:name :high-manual-dexterity :type-1 :physical :type-2 :mundane :cost 5}
   {:name :higher-purpose :type-1 :mental :type-2 :supernatural :cost 5}
   {:name :hyperspectral-vision :type-1 :physical :type-2 :exotic :cost 25}
   {:name :illuminated :type-1 :mental :type-2 :supernatural :cost 15}
   {:name :improved-g-tolerance :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :indomitable :type-1 :mental :type-2 :mundane :cost 15}
   {:name :infravision :type-1 :physical :type-2 :exotic :cost [0 10]}
   {:name :injury-tolerance :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :innate-attack :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :intuition :type-1 :mental :type-2 :mundane :cost 15}
   {:name :jumper :type-1 :mental :type-2 :supernatural :cost 100}
   {:name :language-talent :type-1 :mental :type-2 :mundane :cost 10}
   {:name :legal-enforcement-powers :type-1 :social :type-2 :mundane :cost [5 10 15]}
   {:name :legal-immunity :type-1 :social :type-2 :mundane :cost :variable}
   {:name :less-sleep :type-1 :physical :type-2 :mundane :cost 2}
   {:name :lifting-st :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :lightning-calculator :type-1 :mental :type-2 :mundane :cost [2 5]}
   {:name :longevity :type-1 :physical :type-2 :mundane :cost 2}
   {:name :luck :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :magery :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :mana-damper :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :magic-resistance :type-1 :mental :type-2 :supernatural :cost 2}
   {:name :mana-enhancer :type-1 :mental :type-2 :supernatural :cost 50}
   {:name :medium :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :metabolism-control :type-1 :physical :type-2 :exoctic :cost 5}
   {:name :microscopic-vision :type-1 :physical :type-2 :exotic :cost 5}
   {:name :mimicry :type-1 :mental :type-2 :exotic :cost 10}
   {:name :mind-control :type-1 :mental :type-2 :exotic :cost 50}
   {:name :mind-probe :type-1 :mental :type-2 :exotic :cost 20}
   {:name :mind-reading :type-1 :mental :type-2 :exotic :cost 30}
   {:name :mind-shield :type-1 :mental :type-2 :exotic :cost 4}
   {:name :mindlink :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :neutralize :type-1 :mental :type-2 :exotic :cost 50}
   {:name :nictitating-membrane :type-1 :physical :type-2 :exotic :cost 1}
   {:name :night-vision :type-1 :physical :type-2 :mundane :cost 1}
   {:name :obscure :type-1 :physical :type-2 :exotic :cost 2}
   {:name :oracle :type-1 :mental :type-2 :supernatural :cost 15}
   {:name :patrons :type-1 :social :type-2 :mundane :cost :variable}
   {:name :parabolic-hearing :type-1 :physical :type-2 :exotic :cost 4}
   {:name :payload :type-1 :physical :type-2 :exotic :cost 1}
   {:name :perfect-balance :type-1 :physical :type-2 :mundane :cost 15}
   {:name :penetrating-vision :type-1 :physical :type-2 :exotic :cost 10}
   {:name :peripheral-vision :type-1 :physical :type-2 :mundane :cost 15}
   {:name :permeation :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :plant-empathy :type-1 :mental :type-2 :mundane :cost 5}
   {:name :possession :type-1 :mental :type-2 :exotic :cost 100}
   {:name :power-investiture :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :precognition :type-1 :mental :type-2 :supernatural :cost 25}
   {:name :pressure-support :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :protected-sense :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :psi-static :type-1 :mental :type-2 :supernatural :cost 30}
   {:name :psychometry :type-1 :mental :type-2 :supernatural :cost 20}
   {:name :puppet :type-1 :mental :type-2 :exotic :cost [5 10]}
   {:name :racial-memory :type-1 :mental :type-2 :exotic :cost [15 40]}
   {:name :radiation-tolerance :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :rapid-healing :type-1 :physical :type-2 :mundane :cost [5 15]}
   {:name :rapier-wit :type-1 :mental :type-2 :mundane :cost 5}
   {:name :reawakened :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :recovery :type-1 :physical :type-2 :exotic :cost 10}
   {:name :reduced-consumption :type-1 :physical :type-2 :mundane :cost 2}
   {:name :regeneration :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :regrowth :type-1 :physical :type-2 :exotic :cost 40}
   {:name :resistant :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :scanning-sense :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :sealed :type-1 :physical :type-2 :exotic :cost 15}
   {:name :security-clearance :type-1 :social :type-2 :mundane :cost :variable}
   {:name :see-invisible :type-1 :physical :type-2 :exotic :cost 15}
   {:name :sensitive-touch :type-1 :physical :type-2 :exotic :cost 10}
   {:name :serendipity :type-1 :mental :type-2 :mundane :cost 15}
   {:name :shadow-form :type-1 :physical :type-2 :exotic :cost 50}
   {:name :shapeshifting :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :alternate-form :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :morph :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :shrinking :type-1 :physical :type-2 :exotic :cost 5}
   {:name :signature-gear :type-1 :social :type-2 :mundane :cost :variable}
   {:name :silence :type-1 :physical :type-2 :exotic :cost 5}
   {:name :single-minded :type-1 :mental :type-2 :mundane :cost 5}
   {:name :slippery :type-1 :physical :type-2 :exotic :cost 2}
   {:name :snatcher :type-1 :mental :type-2 :supernatural :cost 80}
   {:name :social-chameleon :type-1 :social :type-2 :mundane :cost 5}
   {:name :social-regard :type-1 :social :type-2 :mundane :cost :variable}
   {:name :speak-underwater :type-1 :physical :type-2 :exotic :cost 5}
   {:name :speak-with-animals :type-1 :mental :type-2 :exotic :cost 25}
   {:name :speak-with-plants :type-1 :mental :type-2 :exotic :cost 15}
   {:name :special-rapport :type-1 :mental :type-2 :supernatural :cost 5}
   {:name :spines :type-1 :physical :type-2 :exotic :cost [1 3]}
   {:name :spirit-empathy :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :stretching :type-1 :physical :type-2 :exotic :cost 6}
   {:name :striker :type-1 :physical :type-2 :exotic :cost [5 6 7 8]}
   {:name :striking-st :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :subsonic-hearing :type-1 :physical :type-2 :exotic :cost [0 5]}
   {:name :subsonic-speech :type-1 :physical :type-2 :exotic :cost [0 10]}
   {:name :super-climbing :type-1 :physical :type-2 :exotic :cost 3}
   {:name :super-jump :type-1 :physical :type-2 :exotic :cost 10}
   {:name :super-luck :type-1 :mental :type-2 :supernatural :cost 100}
   {:name :supernatural-durability :type-1 :physical :type-2 :supernatural :cost 150}
   {:name :talent :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :teeth :type-1 :physical :type-2 :exotic :cost [0 1 2]}
   {:name :telescopic-vision :type-1 :physical :type-2 :exotic :cost 5}
   {:name :temperature-tolerance :type-1 :physical :type-2 :mundane :cost 1}
   {:name :temporal-inertia :type-1 :mental :type-2 :supernatural :cost 15}
   {:name :tenure :type-1 :social :type-2 :mundane :cost 5}
   {:name :terrain-adaptation :type-1 :physical :type-2 :exotic :cost [0 5]}
   {:name :terror :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :trained-by-a-master :type-1 :mental :type-2 :mundane :cost 30}
   {:name :true-faith :type-1 :mental :type-2 :supernatural :cost 15}
   {:name :ultrahearing :type-1 :physical :type-2 :exotic :cost [0 5]}
   {:name :ultravision :type-1 :physical :type-2 :exotic :cost [0 10]}
   {:name :tunneling :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :ultrasonic-speech :type-1 :physical :type-2 :exotic :cost [0 10]}
   {:name :unaging :type-1 :physical :type-2 :exotic :cost 15}
   {:name :unkillable :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :unfazeable :type-1 :mental :type-2 :mundane :cost 15}
   {:name :universal-digestion :type-1 :physical :type-2 :exotic :cost 5}
   {:name :unusual-background :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :vampiric-bite :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :vacuum-support :type-1 :physical :type-2 :exotic :cost 5}
   {:name :versatile :type-1 :mental :type-2 :mundane :cost 5}
   {:name :vibration-sense :type-1 :physical :type-2 :exotic :cost 10}
   {:name :visualization :type-1 :mental :type-2 :supernatural :cost 10}
   {:name :voice :type-1 :physical :type-2 :mundane :cost 10}
   {:name :walk-on-air :type-1 :physical :type-2 :exotic :cost 20}
   {:name :walk-on-liquid :type-1 :physical :type-2 :exotic :cost 15}
   {:name :warp :type-1 :mental :type-2 :supernatural :cost 100}
   {:name :weapon-master :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :wild-talent :type-1 :mental :type-2 :supernatural :cost 20}
   {:name :zeroed :type-1 :social :type-2 :mundane :cost 10}
   {:name :accessory :type-1 :physical :type-2 :exotic :cost 1}
   {:name :alcohol-tolerance :type-1 :physical :type-2 :mundane :cost 1}
   {:name :autotrance :type-1 :mental :type-2 :mundane :cost 1}
   {:name :deep-sleeper :type-1 :physical :type-2 :mundane :cost 1}
   {:name :fur :type-1 :physical :type-2 :exotic :cost 1}
   {:name :honest-face :type-1 :physical :type-2 :mundane :cost 1}
   {:name :no-hangover :type-1 :physical :type-2 :mundane :cost 1}
   {:name :penetrating-voice :type-1 :physical :type-2 :mundane :cost 1}])

(def advantages-by-name
  (reduce (fn [acc kv] (assoc acc (:name kv) (dissoc kv :name))) advantages))

(def advantages-by-type
  (group-by :type-1 advantages))
