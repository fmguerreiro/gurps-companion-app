(ns gurps.pages.character.utils.disadvantages)

(def disadvantages
  [{:name :absent-mindedness :type-1 :mental :type-2 :mundane :cost -15}
   {:name :alcoholism :type-1 :mental :type-2 :mundane :cost [-15 -20]}
   {:name :amnesia :type-1 :mental :type-2 :mundane :cost [-10 -25]}
   {:name :bad-back :type-1 :mental :type-2 :mundane :cost [-15 -25]}
   {:name :bad-grip :type-1 :mental :type-2 :mundane :cost -5}
   {:name :bad-sight :type-1 :mental :type-2 :mundane :cost -25}
   {:name :bad-smell :type-1 :mental :type-2 :mundane :cost -10}
   {:name :bad-temper :type-1 :mental :type-2 :mundane :cost -10}
   {:name :berserk :type-1 :mental :type-2 :mundane :cost -10}
   {:name :bestial :type-1 :mental :type-2 :exotic :cost [-10 -15]}
   {:name :blindness :type-1 :physical :type-2 :mundane :cost -50}
   {:name :bloodlust :type-1 :mental :type-2 :mundane :cost -10}
   {:name :bully :type-1 :mental :type-2 :mundane :cost -10}
   {:name :callous :type-1 :mental :type-2 :mundane :cost -5}
   {:name :cannot-learn :type-1 :mental :type-2 :mundane :cost -30}
   {:name :cannot-speak :type-1 :physical :type-2 :mundane :cost [-15 -25]}
   {:name :charitable :type-1 :mental :type-2 :mundane :cost -15}
   {:name :chronic-depression :type-1 :mental :type-2 :mundane :cost -15}
   {:name :chronic-pain :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :chummy :type-1 :mental :type-2 :mundane :cost [-5 -10]}
   {:name :clueless :type-1 :mental :type-2 :mundane :cost -10}
   {:name :code-of-honor :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :cold-blooded :type-1 :mental :type-2 :exotic :cost [-5 -10]}
   {:name :colorblindness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :combat-paralysis :type-1 :mental :type-2 :mundane :cost -15}
   {:name :compulsive-behavior :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :confused :type-1 :mental :type-2 :mundane :cost -10}
   {:name :cowardice :type-1 :mental :type-2 :mundane :cost -10}
   {:name :curious :type-1 :mental :type-2 :mundane :cost -5}
   {:name :cursed :type-1 :mental :type-2 :supernatural :cost -75}
   {:name :deafness :type-1 :physical :type-2 :mundane :cost -20}
   {:name :decreased-time-rate :type-1 :mental :type-2 :exotic :cost -100}
   {:name :delusions :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :dependency :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :dependents :type-1 :social :type-2 :mundane :cost :variable}
   {:name :destiny :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :disciplines-of-faith :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :disturbing-voice :type-1 :physical :type-2 :mundane :cost -10}
   {:name :divine-curse :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :draining :type-1 :physical :type-2 :supernatural :cost :variable}
   {:name :dread :type-1 :mental :type-2 :supernatural :cost :variable}
   {:name :duty :type-1 :social :type-2 :mundane :cost :variable}
   {:name :dyslexia :type-1 :mental :type-2 :mundane :cost -10}
   {:name :easy-to-kill :type-1 :physical :type-2 :mundane :cost -2}
   {:name :easy-to-read :type-1 :mental :type-2 :mundane :cost -10}
   {:name :electrical :type-1 :physical :type-2 :exotic :cost -20}
   {:name :enemies :type-1 :social :type-2 :mundane :cost :variable}
   {:name :epilepsy :type-1 :physical :type-2 :mundane :cost -30}
   {:name :extra-sleep :type-1 :physical :type-2 :mundane :cost -2}
   {:name :fanaticism :type-1 :mental :type-2 :mundane :cost -15}
   {:name :fearfulness :type-1 :mental :type-2 :mundane :cost -2}
   {:name :flashbacks :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :fragile :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :frightens-animals :type-1 :mental :type-2 :supernatural :cost -10}
   {:name :g-intolerance :type-1 :physical :type-2 :mundane :cost [-10 -20]}
   {:name :gluttony :type-1 :mental :type-2 :mundane :cost -5}
   {:name :greed :type-1 :mental :type-2 :mundane :cost -15}
   {:name :guilt-complex :type-1 :mental :type-2 :mundane :cost -5}
   {:name :gullibility :type-1 :mental :type-2 :mundane :cost -10}
   {:name :ham-fisted :type-1 :physical :type-2 :mundane :cost [-5 -10]}
   {:name :hard-of-hearing :type-1 :physical :type-2 :mundane :cost -10}
   {:name :hemophilia :type-1 :physical :type-2 :mundane :cost -30}
   {:name :hidebound :type-1 :mental :type-2 :mundane :cost -5}
   {:name :honesty :type-1 :mental :type-2 :mundane :cost -10}
   {:name :horizontal :type-1 :physical :type-2 :exotic :cost -10}
   {:name :hunchback :type-1 :physical :type-2 :mundane :cost -10}
   {:name :impulsiveness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :increased-consumption :type-1 :physical :type-2 :mundane :cost -10}
   {:name :increased-life-support :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :incurious :type-1 :mental :type-2 :mundane :cost -5}
   {:name :indecisive :type-1 :mental :type-2 :mundane :cost -10}
   {:name :infectious-attack :type-1 :physical :type-2 :supernatural :cost -5}
   {:name :innumerate :type-1 :mental :type-2 :mundane :cost -5}
   {:name :insomniac :type-1 :physical :type-2 :mundane :cost [-10 -15]}
   {:name :invertebrate :type-1 :physical :type-2 :exotic :cost -20}
   {:name :jealousy :type-1 :mental :type-2 :mundane :cost -10}
   {:name :intolerance :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :killjoy :type-1 :physical :type-2 :mundane :cost -15}
   {:name :kleptomania :type-1 :mental :type-2 :mundane :cost -15}
   {:name :lame :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :klutz :type-1 :mental :type-2 :mundane :cost [-5 -15]}
   {:name :laziness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :lecherousness :type-1 :mental :type-2 :mundane :cost -15}
   {:name :lifebane :type-1 :mental :type-2 :supernatural :cost -10}
   {:name :light-sleeper :type-1 :physical :type-2 :mundane :cost -5}
   {:name :loner :type-1 :mental :type-2 :mundane :cost -5}
   {:name :low-empathy :type-1 :mental :type-2 :mundane :cost -20}
   {:name :low-pain-threshold :type-1 :physical :type-2 :mundane :cost -10}
   {:name :low-self-image :type-1 :mental :type-2 :mundane :cost -10}
   {:name :lunacy :type-1 :mental :type-2 :mundane :cost -10}
   {:name :magic-susceptibility :type-1 :mental :type-2 :supernatural :cost -3}
   {:name :maintenance :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :manic-depressive :type-1 :mental :type-2 :mundane :cost -20}
   {:name :megalomania :type-1 :mental :type-2 :mundane :cost -10}
   {:name :miserliness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :missing-digit :type-1 :physical :type-2 :mundane :cost [-2 -5]}
   {:name :motion-sickness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :mundane-background :type-1 :mental :type-2 :mundane :cost -10}
   {:name :neurological-disorder :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :night-blindness :type-1 :physical :type-2 :mundane :cost -10}
   {:name :nightmares :type-1 :mental :type-2 :mundane :cost -5}
   {:name :no-depth-perception :type-1 :physical :type-2 :mundane :cost -15}
   {:name :no-fine-manipulator :type-1 :physical :type-2 :exotic :cost [-30 -50]}
   {:name :no-legs :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :no-sense-of-humor :type-1 :mental :type-2 :mundane :cost -10}
   {:name :no-sense-of-smell/taste :type-1 :physical :type-2 :mundane :cost -5}
   {:name :nocturnal :type-1 :physical :type-2 :exotic :cost -20}
   {:name :noisy :type-1 :physical :type-2 :mundane :cost -2}
   {:name :non-iconographic :type-1 :mental :type-2 :mundane :cost -10}
   {:name :numb :type-1 :physical :type-2 :mundane :cost -20}
   {:name :oblivious :type-1 :mental :type-2 :mundane :cost -5}
   {:name :obsession :type-1 :mental :type-2 :mundane :cost [-5 -10]}
   {:name :on-the-edge :type-1 :mental :type-2 :mundane :cost -15}
   {:name :one-arm :type-1 :physical :type-2 :mundane :cost -20}
   {:name :one-eye :type-1 :physical :type-2 :mundane :cost -15}
   {:name :one-hand :type-1 :physical :type-2 :mundane :cost -15}
   {:name :overconfidence :type-1 :mental :type-2 :mundane :cost -5}
   {:name :pacifism :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :paranoia :type-1 :mental :type-2 :mundane :cost -10}
   {:name :phantom-voices :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :phobias :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :post-combat-shakes :type-1 :mental :type-2 :mundane :cost -5}
   {:name :pyromania :type-1 :mental :type-2 :mundane :cost -5}
   {:name :quadriplegic :type-1 :physical :type-2 :mundane :cost -80}
   {:name :reprogrammable :type-1 :mental :type-2 :exotic :cost -10}
   {:name :restricted-vision :type-1 :physical :type-2 :mundane :cost [-15 -30]}
   {:name :restricted-diet :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :revulsion :type-1 :physical :type-2 :supernatural :cost :variable}
   {:name :sadism :type-1 :mental :type-2 :mundane :cost -15}
   {:name :secret :type-1 :social :type-2 :mundane :cost :variable}
   {:name :secret-identity :type-1 :social :type-2 :mundane :cost :variable}
   {:name :self-destruct :type-1 :physical :type-2 :exotic :cost -10}
   {:name :selfish :type-1 :mental :type-2 :mundane :cost -5}
   {:name :selfless :type-1 :mental :type-2 :mundane :cost -5}
   {:name :semi-upright :type-1 :physical :type-2 :exotic :cost -5}
   {:name :sense-of-duty :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :short-attention-span :type-1 :mental :type-2 :mundane :cost -10}
   {:name :short-lifespan :type-1 :physical :type-2 :exotic :cost -10}
   {:name :shyness :type-1 :mental :type-2 :mundane :cost [-5 -10 -20]}
   {:name :slave-mentality :type-1 :mental :type-2 :mundane :cost -40}
   {:name :sleepwalker :type-1 :mental :type-2 :mundane :cost -5}
   {:name :sleepy :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :slow-eater :type-1 :physical :type-2 :exotic :cost -10}
   {:name :slow-healing :type-1 :physical :type-2 :mundane :cost -5}
   {:name :slow-riser :type-1 :physical :type-2 :mundane :cost -5}
   {:name :social-disease :type-1 :physical :type-2 :mundane :cost -5}
   {:name :social-stigma :type-1 :social :type-2 :mundane :cost :variable}
   {:name :space-sickness :type-1 :physical :type-2 :mundane :cost -10}
   {:name :split-personality :type-1 :mental :type-2 :mundane :cost -15}
   {:name :squeamish :type-1 :mental :type-2 :mundane :cost -10}
   {:name :stress-atavism :type-1 :mental :type-2 :exotic :cost :variable}
   {:name :stubbornness :type-1 :mental :type-2 :mundane :cost -5}
   {:name :stuttering :type-1 :physical :type-2 :mundane :cost -10}
   {:name :supernatural-features :type-1 :physical :type-2 :supernatural :cost :variable}
   {:name :supersensitive :type-1 :mental :type-2 :supernatural :cost -15}
   {:name :susceptible :type-1 :physical :type-2 :mundane :cost :variable}
   {:name :terminally-ill :type-1 :physical :type-2 :mundane :cost [-50 -75 -100]}
   {:name :timesickness :type-1 :physical :type-2 :mundane :cost -10}
   {:name :trademark :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :trickster :type-1 :mental :type-2 :mundane :cost -15}
   {:name :truthfulness :type-1 :mental :type-2 :mundane :cost -5}
   {:name :uncontrollable-appetite :type-1 :mental :type-2 :supernatural :cost -15}
   {:name :unfit :type-1 :physical :type-2 :mundane :cost [-5 -15]}
   {:name :unique :type-1 :mental :type-2 :supernatural :cost -5}
   {:name :unhealing :type-1 :physical :type-2 :exotic :cost [-20 -30]}
   {:name :unluckiness :type-1 :mental :type-2 :mundane :cost -10}
   {:name :unusual-biochemistry :type-1 :physical :type-2 :exotic :cost -5}
   {:name :vow :type-1 :mental :type-2 :mundane :cost :variable}
   {:name :vulnerability :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :weak-bite :type-1 :physical :type-2 :exotic :cost -2}
   {:name :weakness :type-1 :physical :type-2 :exotic :cost :variable}
   {:name :weirdness-magnet :type-1 :mental :type-2 :supernatural :cost -15}
   {:name :workaholic :type-1 :mental :type-2 :mundane :cost -5}
   {:name :wounded :type-1 :physical :type-2 :mundane :cost -5}
   {:name :xenophilia :type-1 :mental :type-2 :mundane :cost -10}
   {:name :attentive :type-1 :mental :type-2 :mundane :cost -1}
   {:name :broad-minded :type-1 :mental :type-2 :mundane :cost -1}
   {:name :careful :type-1 :mental :type-2 :mundane :cost -1}
   {:name :chauvinistic :type-1 :mental :type-2 :mundane :cost -1}
   {:name :code-of-honor :type-1 :mental :type-2 :mundane :cost -1}
   {:name :congenial :type-1 :mental :type-2 :mundane :cost -1}
   {:name :incompetence :type-1 :mental :type-2 :mundane :cost -1}
   {:name :delusions :type-1 :mental :type-2 :mundane :cost -1}
   {:name :dislikes :type-1 :mental :type-2 :mundane :cost -1}
   {:name :distractible :type-1 :mental :type-2 :mundane :cost -1}
   {:name :likes :type-1 :mental :type-2 :mundane :cost -1}
   {:name :minor-addiction :type-1 :mental :type-2 :mundane :cost -1}
   {:name :nosy :type-1 :mental :type-2 :mundane :cost -1}
   {:name :obsessions :type-1 :mental :type-2 :mundane :cost -1}
   {:name :dreamer :type-1 :mental :type-2 :mundane :cost -1}
   {:name :personality-change :type-1 :mental :type-2 :mundane :cost -1}
   {:name :proud :type-1 :mental :type-2 :mundane :cost -1}
   {:name :responsive :type-1 :mental :type-2 :mundane :cost -1}
   {:name :staid :type-1 :mental :type-2 :mundane :cost -1}
   {:name :trademark :type-1 :mental :type-2 :mundane :cost -1}
   {:name :dull :type-1 :mental :type-2 :mundane :cost -1}
   {:name :habits-or-expressions :type-1 :mental :type-2 :mundane :cost -1}
   {:name :humble :type-1 :mental :type-2 :mundane :cost -1}
   {:name :imaginative :type-1 :mental :type-2 :mundane :cost -1}
   {:name :uncongenial :type-1 :mental :type-2 :mundane :cost -1}
   {:name :bowlegged :type-1 :mental :type-2 :mundane :cost -1}
   {:name :vow :type-1 :mental :type-2 :mundane :cost -1}
   {:name :cannot-float :type-1 :physical :type-2 :mundane :cost -1}
   {:name :horrible-hangovers :type-1 :physical :type-2 :mundane :cost -1}
   {:name :alcohol-intolerance :type-1 :physical :type-2 :mundane :cost -1}
   {:name :minor-addiction :type-1 :physical :type-2 :mundane :cost -1}
   {:name :acceleration-weakness :type-1 :physical :type-2 :mundane :cost -1}
   {:name :minor-handicaps :type-1 :physical :type-2 :mundane :cost -1}
   {:name :nervous-stomach :type-1 :physical :type-2 :mundane :cost -1}])

;; NOTE: absent-mindedness doesn't seem to get added when reducing for some reason, so we add it manually
(def ^:private special-case (dissoc {:absent-mindedness (first disadvantages)} :name))

(def disadvantages-by-name
  (conj
   (reduce (fn [acc kv] (assoc acc (:name kv) (dissoc kv :name))) disadvantages)
   special-case))

(def disadvantages-by-type
  (group-by :type-1 disadvantages))

(comment (clojure.set/difference (into #{} (map :name disadvantages)) (into #{} (keys disadvantages-by-name)))
         (count (keys disadvantages-by-name)))
