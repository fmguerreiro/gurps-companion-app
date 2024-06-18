(ns gurps.pages.character.utils.spells-parsed
  (:require [gurps.pages.character.utils.spells :refer [spells kebab-case]]
            [clojure.string :as s]))

;; (def spells-2 {
;;    :air-jet, {:ref "Magic p. 24", :prereqs [:shape-air]}
;;    :air-vision, {:ref "Magic p. 24", :prereqs [:shape-air]}
;;    :air-vortex, {:ref "Magic p. 26", :prereqs [[:talents/magery,2],:body-of-air,:windstorm]}
;;    :atmosphere-dome, {:ref "Magic p. 169", :prereqs [:purify-air,:weather-dome]}
;;    :ball-of-lightning, {:ref "Magic p. 197", :prereqs [:apportation,:lightning]}
;;    :body-of-air, {:ref "Magic p. 24", :prereqs [:shape-air]}
;;    :body-of-lightning, {:ref "Magic p. 198", :prereqs [[:talents/magery,2],:lightning]}
;;    :body-of-wind, {:ref "Magic p. 27", :prereqs [[:talents/magery,3],[:body-of-air,16],[:windstorm,16],:1-spell-from-each-of-5-different-colleges]}
;;    :breath-adaption, {:ref "Underground Adventures p. 22", :prereqs [:resist-poison,:shape-air]}
;;    :breathe-air, {:ref "Magic p. 26", :prereqs [:create-water,:destroy-air]}
;;    :breathe-water, {:ref "Basic Set p. 250}; GURPS Magic p. 189", :prereqs [:create-air,:destroy-water]}
;;    :chain-lightning, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:talents/magery,4],:ball-of-lightning,:resist-lightning]}
;;    :cloud-of-doom, {:ref "Magic: Artillery Spells p. 9", :prereqs [[:talents/magery,4],[10,:air],:devitalize-air,:stench]}
;;    :clouds, {:ref "Magic p. 194", :prereqs [[2,:water],[2,:air]]}
;;    :concussion, {:ref "Magic p. 26", :prereqs [:shape-air,:thunderclap]}
;;    :cool, {:ref "Magic p. 195", :prereqs [:cold,[4,:air]]}
;;    :control-air-elemental, {:ref "Magic p. 28", :prereqs [:summon-air-elemental]}
;;    :create-air, {:ref "Basic Set p. 243}; GURPS Magic p. 23", :prereqs [:purify-air]}
;;    :create-air-elemental, {:ref "Magic p. 22", :prereqs [[:talents/magery,2],:control-air-elemental]}
;;    :destroy-air, {:ref "Magic p. 43", :prereqs [:purify-air]}
;;    :devitalize-air, {:ref "Magic p. 25", :prereqs [:destroy-air]}
;;    :earth-to-air, {:ref "Basic Set p. 243}; GURPS Magic p. 25", :prereqs [:create-air,:shape-earth]}
;;    :embolism, {:ref "Magic: Death Spells p. 9", :prereqs [[:talents/magery,3],:body-of-air,:essential-air]}
;;    :essential-air, {:ref "Magic p. 26", :prereqs [[6,:air]]}
;;    :explosive-lightning, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :falling-sky, {:ref "Magic: Artillery Spells p. 9", :prereqs [[:talents/magery,4],[8,:air],:concussion,:destory-air]}
;;    :improved-concussion, {:ref "Magic: Artillery Spells p. 25", :prereqs [[:talents/magery,4],[7,:sound],:concussion,:great-voice]}
;;    :improved-explosive-lightning, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:or #{[:talents/magery,4],[10,:air],[10,:weather]}],:explosive-lightning]}
;;    :lightning, {:ref "Basic Set p. 244}; GURPS Magic p. 196", :prereqs [[:talents/magery,1],[6,:air]]}
;;    :lightning-armor, {:ref "Magic p. 198", :prereqs [[6,:lightning,:resist-lightning]]}
;;    :lightning-missiles, {:ref "Magic p. 198", :prereqs [:lightning-weapon]}
;;    :lightning-weapon, {:ref "Magic p. 198", :prereqs [[:talents/magery,2],:lightning]}
;;    :lightning-whip, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :mass-resist-lightning, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-lightning]}
;;    :monitor-air, {:ref "Underground Adventures p. 22", :prereqs [[:talents/magery,1],:test-air]}
;;    :no-smell, {:ref "Basic Set p. 243}; GURPS Magic p. 24", :prereqs [:purify-air]}
;;    :odor, {:ref "Magic p. 24", :prereqs [:no-smell]}
;;    :phlogiston-arc, {:ref "3/25: Epic Magic p. 15", :prereqs [[:talents/magery,4],:essential-air,:lightning-whip]}
;;    :phlogiston-detonation, {:ref "3/25: Epic Magic p. 15", :prereqs [[:talents/magery,4],:essential-air,:explosive-lightning]}
;;    :phlogiston-discharge, {:ref "3/25: Epic Magic p. 15", :prereqs [[:talents/magery,4],:essential-air,:lightning]}
;;    :phlogiston-sphere, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-air,:ball-of-lightning]}
;;    :phlogiston-stare, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-air,:lightning-stare]}
;;    :phlogiston-touch, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-air,:shocking-touch]}
;;    :predict-weather, {:ref "Basic Set p. 243}; GURPS Magic p. 193", :prereqs [[4,:air]]}
;;    :purify-air, {:ref "Basic Set p. 243}; GURPS Magic p. 23", :prereqs []}
;;    :rain, {:ref "Magic p. 195}; GURPS Fantasy p. 168", :prereqs [:clouds]}
;;    :resist-lightning, {:ref "Magic p. 196", :prereqs [[6,:air]]}
;;    # :safe-boarding, {:ref "3/64: Pirates and Swashbucklers p. 14", :prereqs ,:8-2nd-level}
;;    :sandstorm, {:ref "Magic p. 27", :prereqs [:windstorm,:create-earth]}
;;    :seek-air, {:ref "Magic p. 23", :prereqs []}
;;    :shape-air, {:ref "Basic Set p. 243}; GURPS Magic p. 24", :prereqs [:create-air]}
;;    :shocking-touch, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :snow, {:ref "Magic p. 193", :prereqs [:clouds,:frost]}
;;    :spark-cloud, {:ref "Magic p. 196", :prereqs [:shape-air,:lightning]}
;;    :spark-storm, {:ref "Magic p. 196", :prereqs [:windstorm,:lightning]}
;;    :steal-breath, {:ref "Magic: Death Spells p. 9", :prereqs [[:talents/magery,3],[7,:air],:devitalize-air]}
;;    :stench, {:ref "Basic Set p. 244}; GURPS Magic p. 23", :prereqs [:purify-air]}
;;    :storm, {:ref "Magic p. 195", :prereqs [:rain,:hail]}
;;    :stroke-of-lightning, {:ref "Magic Styles: Dungeon Magic p. 19", :prereqs [[:pick 3 [:ball-of-lightning,:flaming-armor,:rain-of-acid,:breathe-fire,:flaming-missiles,:rain-of-fire,:breathe-steam,:flaming-weapon-rive,:burning-touch,:lightning-armor,:shocking-touch,:continual-sunlight,:lightning-missiles,:spark-cloud,:explosive-fireball,:lightning-stare,:spark-storm,:explosive-lightning,:lightning-weapon,:spit-acid,:fire-cloud,:lightning-whip,:wall-of-lightning]]]}
;;    :summon-air-elemental, {:ref "Magic p. 27", :prereqs [[:or #{[:talents/magery,1][8,:air],[4,:air],:another-summon-elemental-spell}]]}
;;    :test-air, {:ref "Underground Adventures p. 22", :prereqs []}
;;    :twisting-terror, {:ref "Magic: Artillery Spells p. 10", :prereqs [[:talents/magery,4],[10,:air],:windstorm]}
;;    :walk-on-air, {:ref "Basic Set p. 243}; GURPS Magic p. 25", :prereqs [:shape-air]}
;;    :wall-of-lightning, {:ref "Magic p. 197", :prereqs [:lightning]}
;;    :wall-of-wind, {:ref "Magic p. 25", :prereqs [:shape-air]}
;;    :warm, {:ref "Magic p. 195", :prereqs [:heat,[4,:air]]}
;;    :wind, {:ref "Magic p. 193", :prereqs [:windstorm]}
;;    :windstorm, {:ref "Magic p. 25", :prereqs [:shape-air]}
;;    :abominable-alteration, {:ref "Magic: Death Spells p. 9", :prereqs [[:talents/magery,3],:alter-body,:shapeshift-others-for-the-appropriate-animal]}
;;    :animal-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :bird-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :fish-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :mammal-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :reptile-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :vermin-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :beast-link, {:ref "Magic p. 30", :prereqs [:beast-summoning]}
;;    :beast-possession, {:ref "Magic p. 32", :prereqs [[:or #{:rider-within,:possession}]]}
;;    :beast-rouser, {:ref "Magic p. 30", :prereqs [[:or #{:vexation,:animal-empathy}]]}
;;    :beast-soother, {:ref "Magi p. 29", :prereqs [[:or #{:persuasion,:animal-empathy}]]}
;;    :beast-seeker, {:ref "Magic p. 32", :prereqs [:or #{[:beast-summoning,[:pick 2,[:seek-fire,:seek-water,:seek-air,:seek-food,:seek-gate,:seek-earth,:seek-navy,:seek-ley-line,:seek-landform,:seek-magic,:seek-plant,:seek-fungus,:seek-machine,:seek-fuel,:seek-machine,:seek-power,seek-radiation,:seek-metal,:seek-plastic,:seek-coastline]]],:seeker}]}
;;    :beast-speech, {:ref "Magic p. 31", :prereqs [:beast-summoning]}
;;    :beast-summoning, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :creeping-plague, {:ref "Magic: Artillery Spells p. 10", :prereqs [[:talents/magery,5],:beast-summoning,[:or #{:vermin-control,[:talents/magery,4],:create-animal}]]}
;;    :great-shapeshift, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,[4,:shapeshifting],:10-other]}
;;    :hybrid-control, {:ref "Magic p. 30", :prereqs [[2,:animal-control]]}
;;    :master, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :partial-shapeshifting, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:appropriate-shapeshifting]}
;;    :chameleon-eyes, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-chameleon]}
;;    :crocodile-jaws, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-crocodile]}
;;    :elephant-trunk, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-elephant]}
;;    :feathered-arms, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-giant-eagle]}
;;    :fish-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-fish]}
;;    :mountain-goat-hooves, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-mountain-goat]}
;;    :saber-teeth, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-saber-tooth-tiger]}
;;    :scorpion-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-scorpion]}
;;    :serpents-fangs, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-viper]}
;;    :skunk-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-skunk]}
;;    :spider-arms, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-giant-spider]}
;;    :tiger-paws, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-tiger]}
;;    :toad-tongue, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-toad]}
;;    :turtle-shell, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-turtle]}
;;    :permanent-beast-possession, {:ref "Magic p. 32", :prereqs [[:talents/magery,2],:beast-possession]}
;;    :permanent-shapeshifting, {:ref "Magic p. 33", :prereqs [[:talents/magery,3],:appropriate-shapeshifting]}
;;    :permanent-shapeshifting-anaconda, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-anaconda]}
;;    :permanent-shapeshifting-bear, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-bear]}
;;    :permanent-shapeshifting-boar, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-boar]}
;;    :permanent-shapeshifting-cheetah, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-cheetah]}
;;    :permanent-shapeshifting-giant-eagle, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-giant-eagle]}
;;    :permanent-shapeshifting-gorilla, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-gorilla]}
;;    :permanent-shapeshifting-hound, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-hound]}
;;    :permanent-shapeshifting-insect-swarm, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-insect-swarm]}
;;    :permanent-shapeshifting-kangaroo, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-kangaroo]}
;;    :permanent-shapeshifting-kraken, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,3],:shapeshifting-kraken]}
;;    :permanent-shapeshifting-lion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-lion]}
;;    :permanent-shapeshifting-panther, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-panther]}
;;    :permanent-shapeshifting-shark, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,3],:shapeshifting-shark]}
;;    :permanent-shapeshifting-skunk, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-skunk]}
;;    :permanent-shapeshifting-stallion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-stallion]}
;;    :permanent-shapeshifting-tiger, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-tiger]}
;;    :permanent-shapeshifting-timber-wolf, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-timber-wolf]}
;;    :permanent-shapeshifting-wolverine, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-wolverine]}
;;    :protect-animal, {:ref "Magic p. 32", :prereqs [:armor,:watchdog,:animal]}
;;    :repel-animal, {:ref "Magic p. 31", :prereqs [:the-appropriate-animal-control]}
;;    :repel-bird, {:ref "Magic p. 31", :prereqs [:bird-control]}
;;    :repel-fish, {:ref "Magic p. 31", :prereqs [:fish-control]}
;;    :repel-mammal, {:ref "Magic p. 31", :prereqs [:mammal-control]}
;;    :repel-reptile, {:ref "Magic p. 31", :prereqs [:reptile-control]}
;;    :repel-vermin, {:ref "Magic p. 31", :prereqs [:vermin-control]}
;;    :repel-hybrids, {:ref "Magic p. 31", :prereqs [:hybrid-control]}
;;    :rider, {:ref "Magic p. 31", :prereqs [:animal-control]}
;;    :rider-within, {:ref "Magic p. 31", :prereqs [[2,:animal-control]]}
;;    :shapeshift-others, {:ref "Magic p. 33", :prereqs [[:talents/magery,2],:appropriate-shapeshifting]}
;;    :shapeshift-others-anaconda, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-anaconda]}
;;    :shapeshift-others-bear, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-bear]}
;;    :shapeshift-others-boar, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-boar]}
;;    :shapeshift-others-cheetah, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-cheetah]}
;;    :shapeshift-others-giant-eagle, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-giant-eagle]}
;;    :shapeshift-others-gorilla, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-gorilla]}
;;    :shapeshift-others-hound, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-hound]}
;;    :shapeshift-others-insect-swarm, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-insect-swarm]}
;;    :shapeshift-others-kangaroo, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-kangaroo]}
;;    :shapeshift-others-kraken, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,2],:shapeshifting-kraken]}
;;    :shapeshift-others-lion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-lion]}
;;    :shapeshift-others-panther, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-panther]}
;;    :shapeshift-others-shark, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,2],:shapeshifting-shark]}
;;    :shapeshift-others-skunk, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-skunk]}
;;    :shapeshift-others-stallion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-stallion]}
;;    :shapeshift-others-tiger, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-tiger]}
;;    :shapeshift-others-timber-wolf, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-timber-wolf]}
;;    :shapeshift-others-wolverine, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-wolverine]}
;;    :shapeshifting, {:ref "Magic p. 32", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-anaconda, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-bear, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-boar, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-cheetah, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-giant-eagle, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-gorilla, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-hound, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-insect-swarm, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-kangaroo, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-kraken, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-lion, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-panther, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-shark, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-skunk, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-stallion, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-tiger, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-timber-wolf, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-wolverine, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :spider-silk, {:ref "Magic p. 32", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :thousand-legged-demise, {:ref "Magic: Death Spells p. 10", :prereqs [[:talents/magery,3],:vermin-control,:shapeshift-others]} ;; TODO
;;    :bird-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :fish-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :mammal-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :reptile-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :vermin-control, {:ref "Magic p. 30", :prereqs [:beast-soother]}
;;    :chameleon-eyes, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-chameleon]}
;;    :crocodile-jaws, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-crocodile]}
;;    :elephant-trunk, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-elephant]}
;;    :feathered-arms, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-giant-eagle]}
;;    :fish-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-fish]}
;;    :mountain-goat-hooves, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-mountain-goat]}
;;    :saber-teeth, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-saber-tooth-tiger]}
;;    :scorpion-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-scorpion]}
;;    :serpents-fangs, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-viper]}
;;    :skunk-tail, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-skunk]}
;;    :spider-arms, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-giant-spider]}
;;    :tiger-paws, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-tiger]}
;;    :toad-tongue, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-toad]}
;;    :turtle-shell, {:ref "Magic p. 34", :prereqs [[:talents/magery,3],:alter-body,:shapeshifting-turtle]}
;;    :permanent-shapeshifting-anaconda, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-anaconda]}
;;    :permanent-shapeshifting-bear, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-bear]}
;;    :permanent-shapeshifting-boar, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,3],:shapeshifting-boar]}
;;    :permanent-shapeshifting-cheetah, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-cheetah]}
;;    :permanent-shapeshifting-giant-eagle, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-giant-eagle]}
;;    :permanent-shapeshifting-gorilla, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-gorilla]}
;;    :permanent-shapeshifting-hound, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-hound]}
;;    :permanent-shapeshifting-insect-swarm, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-insect-swarm]}
;;    :permanent-shapeshifting-kangaroo, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-kangaroo]}
;;    :permanent-shapeshifting-kraken, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,3],:shapeshifting-kraken]}
;;    :permanent-shapeshifting-lion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-lion]}
;;    :permanent-shapeshifting-panther, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,3],:shapeshifting-panther]}
;;    :permanent-shapeshifting-shark, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,3],:shapeshifting-shark]}
;;    :permanent-shapeshifting-skunk, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-skunk]}
;;    :permanent-shapeshifting-stallion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-stallion]}
;;    :permanent-shapeshifting-tiger, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,3],:shapeshifting-tiger]}
;;    :permanent-shapeshifting-timber-wolf, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,3],:shapeshifting-timber-wolf]}
;;    :permanent-shapeshifting-wolverine, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,3],:shapeshifting-wolverine]}
;;    :repel-bird, {:ref "Magic p. 31", :prereqs [:bird-control]}
;;    :repel-fish, {:ref "Magic p. 31", :prereqs [:fish-control]}
;;    :repel-mammal, {:ref "Magic p. 31", :prereqs [:mammal-control]}
;;    :repel-reptile, {:ref "Magic p. 31", :prereqs [:reptile-control]}
;;    :repel-vermin, {:ref "Magic p. 31", :prereqs [:vermin-control]}
;;    :shapeshift-others-anaconda, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-anaconda]}
;;    :shapeshift-others-bear, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-bear]}
;;    :shapeshift-others-boar, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,2],:shapeshifting-boar]}
;;    :shapeshift-others-cheetah, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-cheetah]}
;;    :shapeshift-others-giant-eagle, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-giant-eagle]}
;;    :shapeshift-others-gorilla, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-gorilla]}
;;    :shapeshift-others-hound, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-hound]}
;;    :shapeshift-others-insect-swarm, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-insect-swarm]}
;;    :shapeshift-others-kangaroo, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-kangaroo]}
;;    :shapeshift-others-kraken, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,2],:shapeshifting-kraken]}
;;    :shapeshift-others-lion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-lion]}
;;    :shapeshift-others-panther, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,2],:shapeshifting-panther]}
;;    :shapeshift-others-shark, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,2],:shapeshifting-shark]}
;;    :shapeshift-others-skunk, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-skunk]}
;;    :shapeshift-others-stallion, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-stallion]}
;;    :shapeshift-others-tiger, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,2],:shapeshifting-tiger]}
;;    :shapeshift-others-timber-wolf, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,2],:shapeshifting-timber-wolf]}
;;    :shapeshift-others-wolverine, {:ref "Magic p. 33}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,2],:shapeshifting-wolverine]}
;;    :shapeshifting-anaconda, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-bear, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-boar, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 6", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-cheetah, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-giant-eagle, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-gorilla, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-hound, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-insect-swarm, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-kangaroo, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-kraken, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-lion, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-panther, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 7", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-shark, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 10", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-skunk, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-stallion, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-tiger, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 8", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-timber-wolf, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 9", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :shapeshifting-wolverine, {:ref "Magic p. 32}; GURPS Dungeon Fantasy 5: Allies p. 11", :prereqs [[:talents/magery,1],[2,:animal]]}
;;    :accelerate-pregnancy, {:ref "Bio-Tech p. 30", :prereqs [:ease-labor,:haste]}
;;    :agonize, {:ref "Magic p. 40", :prereqs [[:talents/magery,2],:sensitize]}
;;    :alter-body, {:ref "Magic p. 41", :prereqs [:alter-visage]}
;;    :alter-visage, {:ref "Magic p. 41", :prereqs [[:or #{:shapeshifting,:perfect-illusion}],[8,:body-control]]}
;;    :alter-voice, {:ref "Magic p. 41", :prereqs [[4,:body-control--and-4-sound]]}
;;    :ambidexterity, {:ref "Magic p. 39", :prereqs [:grace]}
;;    :balance, {:ref "Magic p. 39", :prereqs [:grace]}
;;    :boost-dexterity, {:ref "Magic p. 37", :prereqs [:grace]}
;;    :boost-health, {:ref "Magic p. 37", :prereqs [:vigor]}
;;    :boost-strength, {:ref "Magic p. 37", :prereqs [:might]}
;;    :breath-adaption, {:ref "Underground Adventures p. 22", :prereqs [:resist-poison,:shape-air]}
;;    :cadence, {:ref "Magic p. 39", :prereqs [:grace,:haste]}
;;    :choke, {:ref "Magic p. 40", :prereqs [[:talents/magery,1],[5,:body-control],:spasm]}
;;    :climbing, {:ref "Magic p. 35", :prereqs []}
;;    :clumsiness, {:ref "Basic Set p. 244}; GURPS Magic p. 36", :prereqs [:spasm]}
;;    :control-limb, {:ref "Magic p. 40", :prereqs [[:talents/magery,1],[5,:body-control],:spasm]}
;;    :corpulence, {:ref "Magic p. 43", :prereqs [[:talents/magery,2],:create-earth,:create-water,:alter-body,[3,:body-control]]}
;;    :death, {:ref "Magic: Death Spells p. 10 and GURPS Magic Styles: Dungeon Magic p. 15", :prereqs [[:talents/magery,3],:choke,:deathtouch,:choke,:rotting-death,:curse-evisceration,:steal-beauty,:deathtouch,:frostbite,:steal-skill,:dehydrate,:pestilence,:stop-healing]}
;;    :death-field, {:ref "Magic: Artillery Spells p. 11", :prereqs [[:talents/magery,4],:10-body-control,:deathtouch]}
;;    :deathtouch, {:ref "Basic Set p. 245}; GURPS Magic p. 41", :prereqs [:wither-limb]}
;;    :debility, {:ref "Magic p. 36", :prereqs []}
;;    :decapitation, {:ref "Magic p. 42", :prereqs [[:talents/magery,2],:alter-body]}
;;    :despoil-seed, {:ref "Alphabet Arcane p. 17", :prereqs [[:talents/magery,1],:alter-body,:strike-barren]}
;;    :doomtouch, {:ref "Magic: Death Spells p. 11", :prereqs [[:talents/magery,3],:deathtouch,:weaken-blood]}
;;    :ease-labor, {:ref "Bio-Tech p. 31", :prereqs [:lend-vitality]}
;;    :elvish-grace, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [:clumsiness]}
;;    :enlarge, {:ref "Magic p. 42}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:talents/magery,2],:alter-body]}
;;    :enlarge-other, {:ref "Magic p. 43}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:talents/magery,3],:enlarge]}
;;    :frailty, {:ref "Magic p. 37", :prereqs [:lend-energy]}
;;    :fumble, {:ref "Magic p. 38", :prereqs [:clumsiness]}
;;    :gauntness, {:ref "Magic p. 43", :prereqs [[:talents/magery,2],:earth-to-air,:destroy-water,:hunger,[3,:body-control]]}
;;    :grace, {:ref "Magic p. 37", :prereqs [:clumsiness]}
;;    :hair-growth, {:ref "Magic p. 39", :prereqs [[5,:body-control]]}
;;    :haircut, {:ref "Magic p. 39", :prereqs [:hair-growth]}
;;    :hinder, {:ref "Basic Set p. 244}; GURPS Magic p. 36", :prereqs [[:or #{:clumsiness,:haste}]]}
;;    :hold-breath, {:ref "Magic p. 39", :prereqs [[:talents/magery,1],:vigor]}
;;    :hunger, {:ref "Magic p. 38", :prereqs [[:talents/magery,1],:debility,:decay]}
;;    :imp-face, {:ref "Alphabet Arcane p. 17", :prereqs [[:talents/magery,1],:planar-summons,:alter-visage]}
;;    :itch, {:ref "Basic Set p. 244}; GURPS Magic p. 35", :prereqs []}
;;    :lengthen-limb, {:ref "Magic p. 42", :prereqs [[:talents/magery,3],:shapeshifting]}
;;    :ley-running, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:seek-ley-line,:haste]}
;;    :mark-of-thieves, {:ref "Alphabet Arcane p. 17", :prereqs [[:talents/magery,1],:pestilence]}
;;    :might, {:ref "Magic p. 37", :prereqs [:lend-energy]}
;;    :mouth-goes-away, {:ref "Alphabet Arcane p. 17", :prereqs [[:talents/magery,1],:alter-visage,[4,:body-control]]}
;;    :nauseate, {:ref "Magic p. 38", :prereqs [:perfume,:1-other-body-control-spell]}
;;    :pain, {:ref "Basic Set p. 244}; GURPS Magic p. 36", :prereqs [:spasm]}
;;    :paralyze-limb, {:ref "Basic Set p. 244}; GURPS Magic p. 40", :prereqs [[:talents/magery,1],:pain,[4,:other-body-control]]}
;;    :perfume, {:ref "Magic p. 35", :prereqs [:odor]}
;;    :plague-touch, {:ref "Magic: Artillery Spells p. 11", :prereqs [[:talents/magery,4],:deathtouch,:pestilence,:sense-foes]}
;;    :reflexes, {:ref "Magic p. 39", :prereqs [:grace,:haste]}
;;    :remove-fetus, {:ref "Bio-Tech p. 32", :prereqs [[:or #{:ease-labor,:minor-healing,:apportation}]]}
;;    :resist-pain, {:ref "Magic p. 38", :prereqs [[:talents/magery,2],:pain]}
;;    :retch, {:ref "Magic p. 38", :prereqs [:nauseate,:spasm]}
;;    :rooted-feet, {:ref "Basic Set p. 244}; GURPS Magic p. 36", :prereqs [:hinder]}
;;    :roundabout, {:ref "Magic p. 36", :prereqs [:tanglefoot]}
;;    :sensitize, {:ref "Magic p. 39", :prereqs [[:talents/magery,1],:stun]}
;;    :shrink, {:ref "Magic p. 42", :prereqs [[:talents/magery,2],:alter-body]}
;;    :shrink-other, {:ref "Magic p. 42", :prereqs [[:talents/magery,3],:shrink]}
;;    :sickness, {:ref "Magic p. 138", :prereqs [[:or #{:drunkenness,:pestilence}]]}
;;    :spasm, {:ref "Basic Set p. 244}; GURPS Magic p. 35", :prereqs [:itch]}
;;    :stop-spasm, {:ref "Magic p. 35", :prereqs [[:or #{:spasm,:lend-vitality}]]}
;;    :strike-barren, {:ref "Magic p. 41", :prereqs [[:talents/magery,1],:steal-vitality,:decay]}
;;    :strike-blind, {:ref "Magic p. 38", :prereqs [:spasm,2-light,:darkness]}
;;    :strike-deaf, {:ref "Magic p. 38", :prereqs [:spasm,[2,:sound]]}
;;    :strike-dumb, {:ref "Magic p. 38", :prereqs [:spasm]}
;;    :strike-numb, {:ref "Magic p. 40", :prereqs [:resist-pain]}
;;    :stun, {:ref "Magic p. 37", :prereqs [:pain]}
;;    :tanglefoot, {:ref "Magic p. 36", :prereqs [:clumsiness]}
;;    :thirst, {:ref "Magic p. 38", :prereqs [[:talents/magery,1],:debility,:destroy-water]}
;;    :tickle, {:ref "Magic p. 36", :prereqs [:spasm]}
;;    :total-paralysis, {:ref "Magic p. 40", :prereqs [:paralyze-limb]}
;;    :touch, {:ref "Magic p. 35", :prereqs []}
;;    :transfer-pregnancy, {:ref "Bio-Tech p. 32", :prereqs [[:talents/magery,2],:remove-fetus]}
;;    :transform-body, {:ref "Magic p. 43", :prereqs [:alter-body,[3,:shapeshifting]]}
;;    :transform-other, {:ref "Magic p. 43", :prereqs [:shapeshift-others,:appropriate-transform-body]}
;;    :transmogrification, {:ref "Magic p. 43", :prereqs [[:talents/magery,3],:transform-other,:transform-object,:flesh-to-stone]}
;;    :vigor, {:ref "Magic p. 37", :prereqs [[:or #{:lend-vitality,:frailty}]]}
;;    :warp-fetus, {:ref "Bio-Tech p. 33", :prereqs [[:or #{:strike-barren,:wither-limb}]]}
;;    :weaken-blood, {:ref "Magic p. 40", :prereqs [[:or #{:sickness,:steal-vitality}]]}
;;    :wither-limb, {:ref "Basic Set p. 244}; GURPS Magic p. 40", :prereqs [[:talents/magery,2],:paralyze-limb]}
;;    :absorb-book, {:ref "3/48: Secret Magic p. 20", :prereqs [[:or #{[:attributes/int,13],:gift-of-letters}]]}
;;    :accursed-triangle, {:ref "Magic: Death Spells p. 11", :prereqs [[:talents/magery,3],:exchange-bodies]}
;;    :bedtime-reading, {:ref "3/48: Secret Magic p. 20", :prereqs [[:or #{:dream-viewing,:sleep}]]}
;;    :borrow-language, {:ref "Magic p. 46", :prereqs [:lend-language]}
;;    :borrow-skill, {:ref "Magic p. 47", :prereqs [:lend-skill]}
;;    :communication, {:ref "Magic p. 48", :prereqs [:wizard-eye,:far-hearing,:voices,:simple-illusion]}
;;    :compel-lie, {:ref "Magic p. 137", :prereqs [:emotion-control]}
;;    :compel-truth, {:ref "Magic p. 47", :prereqs [[:talents/magery,2],:truthsayer]}
;;    :compel-written-truth, {:ref "3/48: Secret Magic p. 21", :prereqs [[:talents/magery,2],:truthsayer]}
;;    :control-person, {:ref "Magic p. 49", :prereqs [[:or #{:soul-rider,:telepathy}]]}
;;    :dispel-possession, {:ref "Magic p. 49", :prereqs [[:or #{:soul-rider,:possession}]]}
;;    :dream-projection, {:ref "Magic p. 46", :prereqs [:dream-sending]}
;;    :dream-sending, {:ref "Magic p. 45", :prereqs [[:or #{:dream-viewing,:sleep}]]}
;;    :dream-viewing, {:ref "Magic p. 45", :prereqs [[:or #{:truthsayer,:sleep}]]}
;;    :exchange-bodies, {:ref "Magic p. 49", :prereqs [:permanent-possession,:soul-jar]}
;;    :gift-of-letters, {:ref "Magic p. 46", :prereqs [[:or #{:borrow-language,:3-languages-written-at-accented-better}]]}
;;    :gift-of-tongues, {:ref "Magic p. 46", :prereqs [[:or #{:borrow-language,:3-languages-spoken-at-accented-better}]]}
;;    :hide-emotion, {:ref "Magic p. 45", :prereqs [:sense-emotion]}
;;    :hide-thoughts, {:ref "Basic Set p. 245}; GURPS Magic p. 46", :prereqs [:truthsayer]}
;;    :illuminated-writing, {:ref "3/48: Secret Magic p. 21", :prereqs [[:talents/magery,2],[:or #{:mind-sending,:fascinate,[:writing,12]}]]}
;;    :insignificance, {:ref "Magic p. 48", :prereqs [:persuasion,:avoid]}
;;    :lend-language, {:ref "Magic p. 46", :prereqs [[:or #{:beast-speech,[3,:communication],:empathy}]]}
;;    :lend-skill, {:ref "Magic p. 47}; GURPS Social Engineering: Back to School p. 24", :prereqs [:mind-sending,[:attributes/int,11]]}
;;    :machine-speech, {:ref "Magic p. 176", :prereqs [:machine-summoning]}
;;    :message, {:ref "Magic p. 173", :prereqs [:great-voice,:seeker]}
;;    :mind-reading, {:ref "Basic Set p. 245}; GURPS Magic p. 46; GURPS Social Engineering: Back to School p. 24", :prereqs [[:or #{:truthsayer,:borrow-language}]]}
;;    :mind-search, {:ref "Magic p. 46", :prereqs [:mind-reading]}
;;    :mind-sending, {:ref "Magic p. 47}; GURPS Fantasy p. 169; GURPS Social Engineering: Back to School p. 24", :prereqs [:mind-reading]}
;;    :mind-whip, {:ref "Magic Styles: Dungeon Magic p. 24", :prereqs [[:talents/magery,2],:telepathy,:thunderclap]}
;;    :permanent-possession, {:ref "Magic p. 49", :prereqs [[:talents/magery,3],:possession]}
;;    :persuasion, {:ref "Magic p. 45", :prereqs [:sense-emotion]}
;;    :possession, {:ref "Magic p. 49", :prereqs [[:or #{[:talents/magery,1],:control-person,:beast-possession}]]}
;;    :presence, {:ref "Magic p. 48", :prereqs [:persuasion,:lure]}
;;    :psychic-scream, {:ref "Magic: Artillery Spells p. 12", :prereqs [[:talents/magery,4],:10-communication,:empathy,:mind-sending]}
;;    :retrogression, {:ref "Magic p. 47", :prereqs [:mind-search,:mind-sending]}
;;    :sense-emotion, {:ref "Basic Set p. 245}; GURPS Magic p. 45; GURPS Social Engineering: Back to School p. 24", :prereqs [:sense-foes]}
;;    :sense-foes, {:ref "Basic Set p. 245}; GURPS Magic p. 44", :prereqs []}
;;    :sense-life, {:ref "Magic p. 45", :prereqs []}
;;    :soul-rider, {:ref "Magic p. 49", :prereqs [:mind-reading]}
;;    :telepathic-overload, {:ref "Magic: Death Spells p. 9", :prereqs [[:talents/magery,3],:any-10-communication,:empathy,:telepathy]}
;;    :telepathy, {:ref "Magic p. 47}; GURPS Social Engineering: Back to School p. 24", :prereqs [:mind-sending]}
;;    :truthsayer, {:ref "Basic Set p. 245}; GURPS Magic p. 45", :prereqs [:sense-emotion]}
;;    :vexation, {:ref "Magic p. 45", :prereqs [:sense-emotion]}
;;    :adamant-hail, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-earth,:rain-of-stones]}
;;    :adamant-missile, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-earth,:stone-missile]}
;;    :alter-terrain, {:ref "Magic p. 55", :prereqs [[:talents/magery,3],:all-4-elemental-shape,:shape-stone]}
;;    :boulder-barrage, {:ref "Magic: Artillery Spells p. 12", :prereqs [[:talents/magery,4],[10,:earth],:rain-of-stones,:stone-missile]}
;;    :break-rock, {:ref "Underground Adventures p. 23", :prereqs [:shape-earth]}
;;    :body-of-stone, {:ref "Magic p. 54", :prereqs [:stone-to-flesh]}
;;    :control-earth-elemental, {:ref "Magic p. 28", :prereqs [:summon-earth-elemental]}
;;    :control-lava-lizard, {:ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic p. 12", :prereqs [:summon-lava-lizard]}
;;    :create-earth, {:ref "Basic Set p. 246}; GURPS Magic p. 51; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:earth-to-stone]}
;;    :create-earth-elemental, {:ref "Magic p. 22", :prereqs [[:talents/magery,2],:control-earth-elemental]}
;;    :dust-to-dust, {:ref "Magic: Death Spells p. 11", :prereqs [[:talents/magery,3],:earth-to-air,:flesh-to-stone]}
;;    :earth-to-air, {:ref "Basic Set p. 243}; GURPS Magic p. 25", :prereqs [:create-air,:shape-earth]}
;;    :earth-to-stone, {:ref "Magic p. 51}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[:talents/magery,1],:shape-earth]}
;;    :earth-to-water, {:ref "Magic p. 52", :prereqs [[:talents/magery,1],:create-water,:shape-earth]}
;;    :earth-vision, {:ref "Magic p. 51", :prereqs [:shape-earth]}
;;    :earthquake, {:ref "Magic p. 54", :prereqs [[:talents/magery,2],[6,:earth],:earth-vision]}
;;    :entombment, {:ref "Basic Set p. 246}; GURPS Magic p. 53", :prereqs [[:talents/magery,2],[5,:earth]]}
;;    :essential-earth, {:ref "Magic p. 53}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[6,:earth]]}
;;    :flesh-to-adamant, {:ref "3/25: Epic Magic p. 16", :prereqs [[:talents/magery,4],:essential-earth,:flesh-to-stone]}
;;    :flesh-to-stone, {:ref "Basic Set p. 246}; GURPS Magic p. 51", :prereqs [:earth-to-stone]}
;;    :heart-of-stone, {:ref "Magic: Death Spells p. 11", :prereqs [[:talents/magery,3],:partial-petrification]}
;;    :move-terrain, {:ref "Magic p. 55", :prereqs [:alter-terrain,:hide-object]}
;;    :mud-jet, {:ref "Magic p. 52", :prereqs [:water-jet,:create-earth,:or-create-water,:sand-jet]}
;;    :orichalcum-edge, {:ref "3/25: Epic Magic p. 17", :prereqs [[:talents/magery,4],:essential-earth,:earth-to-stone]}
;;    :orichalcum-missiles, {:ref "3/25: Epic Magic p. 17", :prereqs [:orichalcum-edge]}
;;    :partial-petrification, {:ref "Magic p. 52", :prereqs [[:talents/magery,2],:flesh-to-stone]}
;;    :predict-earth-movement, {:ref "Magic p. 51", :prereqs [[4,:earth]]}
;;    :purify-earth, {:ref "Magic p. 54}; GURPS Fantasy p. 169", :prereqs [:apportation,:shape-earth]}
;;    :rain-of-stones, {:ref "Magic p. 53", :prereqs [[:talents/magery,2],:create-earth]}
;;    :sand-blast, {:ref "Magic: Artillery Spells p. 12", :prereqs [[:talents/magery,4],:sand-jet,:storm]}
;;    :sand-jet, {:ref "Magic p. 52", :prereqs [:create-earth]}
;;    :sandstorm, {:ref "Magic p. 27", :prereqs [:windstorm,:create-earth]}
;;    :seek-earth, {:ref "Basic Set p. 245}; GURPS Magic p. 50", :prereqs []}
;;    :seek-landform, {:ref "Underground Adventures p. 22", :prereqs [:seek-earth]}
;;    :seek-path, {:ref "Magic p. 51", :prereqs [:seek-earth]}
;;    :seismic-shock, {:ref "Magic: Artillery Spells p. 13", :prereqs [[:talents/magery,4],[10,:earth],:earthquake]}
;;    :shape-earth, {:ref "Basic Set p. 245}; GURPS Magic p. 50", :prereqs [:seek-earth]}
;;    :shape-stone, {:ref "Fantasy p. 169", :prereqs [:shape-earth,[3,:other]]}
;;    :steelwraith, {:ref "Magic p. 54}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:talents/magery,2],:walk-through-earth]}
;;    :stone-missile, {:ref "Magic p. 52", :prereqs [:create-earth]}
;;    :stone-to-earth, {:ref "Basic Set p. 246}; GURPS Magic p. 51", :prereqs [[:or #{:earth-to-stone,[4,:earth]}]]}
;;    :stone-to-flesh, {:ref "Basic Set p. 246}; GURPS Magic p. 53", :prereqs [[:talents/magery,2],:flesh-to-stone,:stone-to-earth]}
;;    :summon-earth-elemental, {:ref "Magic p. 27", :prereqs [[:or #{[:talents/magery,1],[8,:earth],[4,:earth],:another-summon-elemental-spell}]]}
;;    :summon-lava-lizard, {:ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic p. 12", :prereqs [[:talents/magery,1],[4,:earth],[4,:fire]]}
;;    :trace-labyrinth, {:ref "Underground Adventures p. 22", :prereqs [[:talents/magery,1],:seek-landform]}
;;    :volcano, {:ref "Magic p. 54", :prereqs [:earthquake,[6,:fire]]}
;;    :walk-through-earth, {:ref "Magic p. 52}; GURPS Fantasy p. 169; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [:shape-stone]}
;;    :adjustable-clothing, {:ref "Magic p. 58}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:enchant,:reshape]}
;;    :amulet, {:ref "Magic p. 58", :prereqs [:talisman-for-the-appropriate-spell]}
;;    :compulsive-reader, {:ref "3/48: Secret Magic p. 21", :prereqs [[:or #{:enchant,[3,:mind-control],[:skills/writing,15]}]]}
;;    :create-chimera, {:ref "Bio-Tech p. 31", :prereqs [:analyze-heredity,:enchant,[:or #{:alter-body,:lightning}]]}
;;    :doom-wish, {:ref "Magic: Artillery Spells p. 13", :prereqs [[:talents/magery,3],:wish,[:attributes/int,23]]}
;;    :doppelgänger, {:ref "Magic p. 62", :prereqs [[:talents/magery,3],:golem,:history,:enslave]}
;;    :dwarfish-reinforcement, {:ref "3/76: Dungeon Fantasy IV p. 13", :prereqs [:enchant]}
;;    :enchant, {:ref "Basic Set p. 480}; GURPS Magic p. 56", :prereqs [[:talents/magery,2],:one-spell-from-10-other-colleges]}
;;    :ensorcel, {:ref "Magic p. 60", :prereqs [:malefice]}
;;    :golem, {:ref "Magic p. 59", :prereqs [:enchant,:shape-earth,:animation]}
;;    :great-wish, {:ref "Magic p. 61", :prereqs [[:talents/magery,3],:wish,:dx+iq-30]}
;;    :hex, {:ref "Magic p. 57", :prereqs [:enchant]}
;;    :hideaway, {:ref "Magic p. 66}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:enchant,:create-object,:lighten]}
;;    :impart-skill, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [[:talents/magery,3],:enchant,:lend-skill,:wisdom,:five-communication,:empathy]}
;;    :impression-blocker, {:ref "Magic p. 60", :prereqs [:enchant,:seeker,:scrywall]}
;;    :leak, {:ref "Magic p. 61", :prereqs [:hideaway]}
;;    :lesser-wish, {:ref "Magic p. 61", :prereqs [:enchant]}
;;    :ley-line-creation, {:ref "Thaumatology: Urban Magics p. 21", :prereqs [:seek-ley-line,:apportation]}
;;    :live-libram, {:ref "3/48: Secret Magic p. 22", :prereqs [:enchant,:apportation]}
;;    :malefice, {:ref "Magic p. 60", :prereqs [:enchant,:seeker]}
;;    :mortal-malefice, {:ref "Magic: Death Spells p. 9", :prereqs [[:talents/magery,3],:malefice,:soul-jar]}
;;    :narrative-conveyance, {:ref "3/48: Secret Magic p. 22", :prereqs [:plane-shift,:timeport,:writing-15]}
;;    :power, {:ref "Basic Set p. 480}; GURPS Magic p. 57", :prereqs [:enchant,:recover-energy]}
;;    :remove-enchantment, {:ref "Magic p. 58", :prereqs [:enchant]}
;;    :resist-enchantment, {:ref "Magic p. 58", :prereqs [:any-limiting-enchantment-spell]}
;;    :scroll, {:ref "Magic p. 57", :prereqs [[:or #{[:talents/magery,1],:1-written-language-at-accented-better}]]}
;;    :simulacrum, {:ref "Magic p. 61", :prereqs [[:talents/magery,3],:golem,:perfect-illusion,:illusion-disguise]}
;;    :speed, {:ref "Magic p. 57", :prereqs [:enchant,:haste]}
;;    :spell-stone, {:ref "Magic p. 60", :prereqs [:enchant,:delay]}
;;    :spellgraft, {:ref "Bio-Tech p. 32", :prereqs [:enchant]}
;;    :suspend-enchantment, {:ref "Magic p. 58", :prereqs [:enchant]}
;;    :talisman, {:ref "Magic p. 58", :prereqs [:enchant,:spell-to-be-opposed]}
;;    :temporary-enchantment, {:ref "Magic p. 56}; GURPS Fantasy p. 23", :prereqs [:enchant]}
;;    :vengeful-staff, {:ref "Magic: Artillery Spells p. 14", :prereqs [[:talents/magery,3],:enchant,:explode]}
;;    :wish, {:ref "Magic p. 61", :prereqs [:lesser-wish,:1-spell-each-from-15-colleges]}
;;    :accuracy, {:ref "Basic Set p. 480}; GURPS Magic p. 65", :prereqs [:enchant,[4,:air]]}
;;    :assassins-weapon, {:ref "Magic: Death Spells p. 12", :prereqs [[:talents/magery,3],:penetrating-weapon,:puissance]}
;;    :bane, {:ref "Magic p. 69", :prereqs [:enchant]}
;;    :blank-spell-arrow, {:ref "Magic p. 66", :prereqs [:spell-arrow]}
;;    :cornucopia, {:ref "Magic p. 64", :prereqs [:enchant,[:pick 2 [:accuracy,:assassins-weapons,:bane,:blank-spell-arrow,:dancing-weapon,:ghost-weapon,:graceful-weapon,:loyal-sword,:penetrating-weapon,:puissance,:quick-aim,:quick-draw,:speed-spell-arrow,:spell-arrow,:weapon-spirit]]]}
;;    :dancing-weapon, {:ref "Magic p. 63", :prereqs [:enchant,:dancing-object]}
;;    :defending-weapon, {:ref "Magic p. 64", :prereqs [:enchant,:dancing-object]}
;;    :ghost-weapon, {:ref "Magic p. 65", :prereqs [:enchant,:solidify]}
;;    :graceful-weapon, {:ref "Magic p. 63", :prereqs [:enchant,:apportation]}
;;    :loyal-sword, {:ref "Magic p. 63", :prereqs [:enchant,:apportation]}
;;    :penetrating-weapon, {:ref "Magic p. 63", :prereqs [:enchant,:find-weakness]}
;;    :puissance, {:ref "Basic Set p. 480}; GURPS Magic p. 65", :prereqs [:enchant,[5,:earth]]}
;;    :quick-aim, {:ref "Magic p. 63", :prereqs [:enchant,:grace]}
;;    :quick-draw, {:ref "Magic p. 63", :prereqs [:enchant,:apportation]}
;;    :speed-spell-arrow, {:ref "Magic p. 66", :prereqs [:speed,:spell-arrow]}
;;    :spell-arrow, {:ref "Magic p. 65", :prereqs [:spell-stone]}
;;    :weapon-spirit, {:ref "Magic p. 64", :prereqs [:enchant,:summon-spirit]}
;;    :dancing-shield, {:ref "Magic p. 67", :prereqs [:enchant,:dancing-object]}
;;    :defending-shield, {:ref "Magic p. 67", :prereqs [:enchant,:grace]}
;;    :deflect, {:ref "Basic Set p. 480}; GURPS Magic p. 67", :prereqs [:enchant]}
;;    :fortify, {:ref "Basic Set p. 480}; GURPS Magic p. 66; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:enchant]}
;;    :lighten, {:ref "Magic p. 67", :prereqs [:enchant]}
;;    :attune, {:ref "Magic p. 69", :prereqs [:bane]}
;;    :limit, {:ref "Magic p. 68", :prereqs [:enchant]}
;;    :link, {:ref "Magic p. 131", :prereqs [:delay]}
;;    :name, {:ref "Magic p. 68", :prereqs [:enchant]}
;;    :password, {:ref "Magic p. 68", :prereqs [:enchant]}
;;    :crystal-ball, {:ref "Magic p. 71", :prereqs [:enchant,:divination-crystal-gazing]}
;;    :effigy, {:ref "Magic p. 71", :prereqs [[:talents/magery,2],:enchant,:scryfool,:ward]}
;;    :homunculus, {:ref "Magic p. 70", :prereqs [:enchant,:mind-sending]}
;;    :lich, {:ref "Magic p. 159", :prereqs [[:talents/magery,3],[:attributes/int,13],:enchant,:soul-jar,:zombie]}
;;    :manastone, {:ref "Magic p. 70", :prereqs [:enchant]}
;;    :one-college-powerstone, {:ref "Magic p. 70", :prereqs [:enchant]}
;;    :powerstone, {:ref "Magic p. 69", :prereqs [:enchant]}
;;    :soul-stone, {:ref "Magic p. 71", :prereqs [[:talents/magery,3],:enchant,:soul-jar]}
;;    :staff, {:ref "Basic Set p. 481}; GURPS Magic p. 70", :prereqs [:enchant]}
;;    :wraith, {:ref "Magic p. 160", :prereqs [[:talents/magery,3],[:attributes/int,13],:enchant,:halt-aging,:soul-jar]}
;;    :balors-eye-fire, {:ref "3/76: Dungeon Fantasy IV p. 13", :prereqs [[:talents/magery,1],:flame-jet,:resist-fire,[:or #{:balors-eye-fire,:tome-of-power-balors-treatise}]]}
;;    :blast-ball, {:ref "Magic Styles: Dungeon Magic p. 19", :prereqs [[:pick 3 [:ball-of-lightning,:flaming-armor,:rain-of-acid,:breathe-fire,:flaming-missiles,:rain-of-fire,:breathe-steam,:flaming-weapon-rive,:burning-touch,:lightning-armor,:shocking-touch,:continual-sunlight,:lightning-missiles,:spark-cloud,:explosive-fireball,:lightning-stare,:spark-storm,:explosive-lightning,:lightning-weapon,:spit-acid,:fire-cloud,:lightning-whip,:wall-of-lightning]]]}
;;    :body-of-flames, {:ref "Magic p. 76", :prereqs [:breathe-fire]}
;;    :breathe-fire, {:ref "Magic p. 76", :prereqs [[:talents/magery,1],:flame-jet,:resist-fire]}
;;    :burning-death, {:ref "Magic p. 76", :prereqs [[:talents/magery,2],:heat,:sickness]}
;;    :burning-touch, {:ref "Magic p. 76", :prereqs [[:talents/magery,2],[6,:fire],:heat]}
;;    :cold, {:ref "Basic Set p. 247}; GURPS Magic p. 74", :prereqs [:heat]}
;;    :control-fire-elemental, {:ref "Magic p. 28", :prereqs [:summon-fire-elemental]}
;;    :control-lava-lizard, {:ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic p. 12", :prereqs [:summon-lava-lizard]}
;;    :create-fire, {:ref "Basic Set p. 246}; GURPS Magic p. 72", :prereqs [:ignite-fire]}
;;    :create-fire-elemental, {:ref "Magic p. 22", :prereqs [[:talents/magery,2],:control-fire-elemental]}
;;    :cremate, {:ref "Magic: Death Spells p. 12", :prereqs [[:talents/magery,3],:burning-touch,:essential-flame,:fast-fire]}
;;    :deflect-energy, {:ref "Basic Set p. 246}; GURPS Magic p. 73", :prereqs [[:talents/magery,1],:shape-fire]}
;;    :essential-flame, {:ref "Magic p. 75", :prereqs [[6,:fire]]}
;;    :explosive-fireball, {:ref "Basic Set p. 247}; GURPS Magic p. 75", :prereqs [:fireball]}
;;    :explosive-hellfire-orb, {:ref "3/25: Epic Magic p. 17", :prereqs [[:talents/magery,4],:essential-flame,:explosive-fireball]}
;;    :extinguish-fire, {:ref "Basic Set p. 247}; GURPS Magic p. 72", :prereqs [:ignite-fire]}
;;    :fast-fire, {:ref "Magic p. 73", :prereqs [:slow-fire]}
;;    :fire-cloud, {:ref "Magic p. 75", :prereqs [:shape-air,:fireball]}
;;    :fire-swarm, {:ref "Magic: Artillery Spells p. 14", :prereqs [[:talents/magery,4],[10,:fire],:fireball,:flame-jet]}
;;    :fireball, {:ref "Basic Set p. 247}; GURPS Magic p. 74", :prereqs [[:talents/magery,1],:create-fire,:shape-fire]}
;;    :fireproof, {:ref "Magic p. 73", :prereqs [:extinguish-fire]}
;;    :flame-jet, {:ref "Magic p. 73", :prereqs [:create-fire,:shape-fire]}
;;    :flaming-armor, {:ref "Magic p. 75", :prereqs [[:talents/magery,1],:resist-fire,:flame-jet]}
;;    :flaming-missiles, {:ref "Magic p. 75", :prereqs [:flaming-weapon]}
;;    :flaming-weapon, {:ref "Magic p. 75", :prereqs [[:talents/magery,2],:heat]}
;;    :flammability, {:ref "Magic: Artillery Spells p. 26", :prereqs [[:talents/magery,3],:essential-fuel,:purify-fuel]}
;;    :great-deflect-energy, {:ref "3/4: Magic on the Battlefield p. 9", :prereqs [[:talents/magery,2],:deflect-energy]}
;;    :heat, {:ref "Basic Set p. 247}; GURPS Magic p. 74", :prereqs [:create-fire,:shape-fire]}
;;    :hellfire-breath, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-flame,:breathe-fire]}
;;    :hellfire-jet, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-flame,:flame-jet]}
;;    :hellfire-orb, {:ref "3/25: Epic Magic p. 17", :prereqs [[:talents/magery,4],:essential-flame,:fireball]}
;;    :hellfire-rain, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-flame,:rain-of-fire]}
;;    :ignite-fire, {:ref "Basic Set p. 246}; GURPS Magic p. 72", :prereqs []}
;;    :improved-explosive-fireball, {:ref "Magic: Artillery Spells p. 15", :prereqs [[:talents/magery,4],[10,:fire],:explosive-fireball]}
;;    :mass-resist-fire, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-fire]}
;;    :phantom-flame, {:ref "Magic p. 73", :prereqs [[:or #{:shape-fire,simple-illusion}]]}
;;    :rain-of-fire, {:ref "Magic p. 74}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:talents/magery,2],:create-fire]}
;;    :resist-cold, {:ref "Basic Set p. 247}; GURPS Magic p. 74", :prereqs [:heat]}
;;    :resist-fire, {:ref "Basic Set p. 247}; GURPS Magic p. 74", :prereqs [:extinguish-fire,:cold]}
;;    :seek-fire, {:ref "Magic p. 72", :prereqs []}
;;    :shape-fire, {:ref "Basic Set p. 246}; GURPS Magic p. 72", :prereqs [:ignite-fire]}
;;    :slow-fire, {:ref "Magic p. 73", :prereqs [:extinguish-fire]}
;;    :smoke, {:ref "Magic p. 73", :prereqs [:shape-fire,:extinguish-fire]}
;;    :snuff-lifes-flame, {:ref "Magic: Death Spells p. 12", :prereqs [[:talents/magery,3],:body-of-flames]}
;;    :summon-fire-elemental, {:ref "Magic p. 27", :prereqs [[:or #{[:talents/magery,1],[8,:fire],[4,:fire],:another-summon-elemental-spell}]]}
;;    :summon-lava-lizard, {:ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic p. 12", :prereqs [[:talents/magery,1],[4,:earth],[4,:fire]]}
;;    :towering-inferno, {:ref "Magic: Artillery Spells p. 15", :prereqs [[:talents/magery,4],[7,:fire],:fire-cloud,:rain-of-fire]}
;;    :warmth, {:ref "Magic p. 74", :prereqs [:heat]}
;;    :butcher, {:ref "Magic: Death Spells p. 12", :prereqs [[:talents/magery,3],:prepare-game]}
;;    :cook, {:ref "Magic p. 78", :prereqs [:test-food,:create-food]}
;;    :create-food, {:ref "Magic p. 79}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:cook,:seek-food]}
;;    :deaths-banquet, {:ref "Magic: Death Spells p. 13", :prereqs [[:talents/magery,3],:essential-food,:poison-food]}
;;    :decay, {:ref "Magic p. 77", :prereqs [:test-food]}
;;    :distill, {:ref "Magic p. 89", :prereqs [:mature,:destroy-water]}
;;    :far-tasting, {:ref "Magic p. 77", :prereqs [[:or #{[:talents/magery,1],:seek-food,:seek-air}]]}
;;    :essential-food, {:ref "Magic p. 79}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[6,:food,:create-food]]}
;;    :fools-banquet, {:ref "Magic p. 79", :prereqs [[:talents/magery,1],:cook,:foolishness]}
;;    :foul-water, {:ref "Magic p. 185", :prereqs [:purify-water,:decay]}
;;    :fount-of-wine, {:ref "3/43: Thaumatology III p. 8", :prereqs [[:talents/magery,3],:five-tríto]}
;;    :hunger, {:ref "Magic p. 38", :prereqs [[:talents/magery,1],:debility,:decay]}
;;    :know-recipe, {:ref "Magic p. 78", :prereqs [:far-tasting,:season]}
;;    :mature, {:ref "Magic p. 78", :prereqs [[:or #{:decay,:season}]]}
;;    :poison-food, {:ref "Magic p. 78", :prereqs [:purify-food,:decay]}
;;    :prepare-game, {:ref "Magic p. 78", :prereqs [:purify-food]}
;;    :preserve-food, {:ref "Magic p. 79", :prereqs [:decay]}
;;    :purify-food, {:ref "Magic p. 78", :prereqs [:decay]}
;;    :scents-of-the-past, {:ref "Magic p. 107", :prereqs [[:talents/magery,2],:history,:odor]}
;;    :season, {:ref "Magic p. 77", :prereqs [:test-food]}
;;    :seek-food, {:ref "Magic p. 77", :prereqs []}
;;    :test-food, {:ref "Magic p. 77}; GURPS Fantasy p. 169", :prereqs []}
;;    :thirst, {:ref "Magic p. 38", :prereqs [[:talents/magery,1],:debility,:destroy-water]}
;;    :water-to-wine, {:ref "Magic p. 79}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:purify-water,:mature]}
;;    :wizard-mouth, {:ref "Magic p. 104", :prereqs [:apportation,:far-tasting,:great-voice]}
;;    :wizard-nose, {:ref "Magic p. 104", :prereqs [:apportation,:far-tasting]}
;;    :accelerate-time, {:ref "Magic p. 86", :prereqs [[:talents/magery,2],[:attributes/int,13],:2-spell-from-10-colleges]}
;;    :beacon, {:ref "Magic p. 83}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [:teleport,:timeport,:or-plane-shift]}
;;    :blink, {:ref "Magic p. 148", :prereqs [:teleport]}
;;    :blink-other, {:ref "Magic p. 148", :prereqs [:blink]}
;;    :control-gate, {:ref "Magic p. 85", :prereqs [[:talents/magery,3],:seek-gate]}
;;    :create-door, {:ref "Magic p. 84", :prereqs [:teleport,[:or #{:walk-through-plants,:walk-through-wood,:walk-through-metal,:walk-through-water}]]}
;;    :create-gate, {:ref "Magic p. 85", :prereqs [[:or #{:control-gate,:teleport}],:timeport,:or-plane-shift]}
;;    :dimensional-dissection, {:ref "Magic: Death Spells p. 13", :prereqs [[:talents/magery,3],[:or #{:plane-shift-other,:teleport-other,:timeport-other}]]}
;;    :divert-teleport, {:ref "Magic p. 84", :prereqs [:mager-3,:trace-teleport]}
;;    :hell-zone, {:ref "Magic: Artillery Spells p. 16", :prereqs [[:talents/magery,4],:beacon]}
;;    :hide-object, {:ref "Magic p. 86", :prereqs [:hideaway,:teleport]}
;;    :null-sphere, {:ref "Magic: Artillery Spells p. 16", :prereqs [[:talents/magery,5],:create-gate]}
;;    :phase, {:ref "Magic p. 83", :prereqs [[:or #{[:talents/magery,3],:plane-shift,:ethereal-body}]]}
;;    :phase-other, {:ref "Magic p. 83", :prereqs [:phase]}
;;    :planar-summons, {:ref "Basic Set p. 247}; GURPS Magic p. 82", :prereqs [[:talents/magery,1],:1-spell-from-10-colleges]}
;;    :planar-visit, {:ref "Magic p. 82", :prereqs [[:or #{[:talents/magery,2],:projection,:planar-summons}]]}
;;    :plane-shift, {:ref "Basic Set p. 247}; GURPS Magic p. 83", :prereqs [:planar-summons]}
;;    :plane-shift-other, {:ref "Magic p. 83", :prereqs [[:talents/magery,3],:plane-shift]}
;;    :rapid-journey, {:ref "Magic p. 82", :prereqs [[:or #{[:talents/magery,3],:teleport,:timeport}]]}
;;    :sanctuary, {:ref "Magic p. 86", :prereqs [:hide-object]}
;;    :scry-gate, {:ref "Magic p. 85", :prereqs [:seek-gate]}
;;    :seek-gate, {:ref "Magic p. 85", :prereqs [[:talents/magery,2],:seek-magic,:1-spell-from-each-of-10-colleges]}
;;    :slow-time, {:ref "Magic p. 86", :prereqs [[:talents/magery,2],[:attributes/int,13],:2-spell-from-each-of-10-colleges]}
;;    :splat, {:ref "Magic: Artillery Spells p. 16", :prereqs [[:talents/magery,4],:create-door]}
;;    :suspend-time, {:ref "Magic p. 86", :prereqs [[:talents/magery,3],:slow-time]}
;;    :teleport, {:ref "Magic p. 147}; GURPS Fantasy p. 171", :prereqs [[:or #{:hawk-flight,[:attributes/int,15]}],:1-spell-from-10-colleges]}
;;    :teleport-other, {:ref "Magic p. 147", :prereqs [[:talents/magery,3],:teleport]}
;;    :teleport-shield, {:ref "Magic p. 170", :prereqs [[:or #{:watchdog,:spell-shield,:teleport}]]}
;;    :time-out, {:ref "Magic p. 87", :prereqs [[:talents/magery,3],:accelerate-time]}
;;    :timeport, {:ref "Magic p. 81", :prereqs [[:talents/magery,3],:teleport]}
;;    :timeport-other, {:ref "Magic p. 81", :prereqs [:timeport]}
;;    :timeslip, {:ref "Magic p. 81", :prereqs [:timeport]}
;;    :timeslip-other, {:ref "Magic p. 81", :prereqs [:timeslip]}
;;    :trace-teleport, {:ref "Magic p. 84", :prereqs [:teleport,[:or #{:timeport,:plane-shift}]]}
;;    :underworld-imprisonment, {:ref "Magic: Death Spells p. 13", :prereqs [[:talents/magery,3],:plane-shift-other]}
;;    :archmagis-recuperation, {:ref "3/76: Dungeon Fantasy IV p. 13", :prereqs []}
;;    :awaken, {:ref "Basic Set p. 248}; GURPS Magic p. 90", :prereqs [:lend-vitality]}
;;    :body-reading, {:ref "Magic p. 91", :prereqs [[:or #{:sense-life,:awaken}]]}
;;    :cleansing, {:ref "Magic p. 94", :prereqs [:minor-healing,:purify-earth]}
;;    :cure-disease, {:ref "Magic p. 91}; GURPS Fantasy p. 170", :prereqs [:major-healing,:relieve-sickness]}
;;    :cure-radiation, {:ref "Magic p. 182", :prereqs [:resist-radiation,:major-healing]}
;;    :detect-poison, {:ref "Magic p. 166", :prereqs [[:or #{:sense-danger,:test-food}]]}
;;    :disinfect, {:ref "Magic: Artillery Spells p. 17", :prereqs [[:talents/magery,4],[10,:healing],:cure-disease,:remove-contagion]}
;;    :ease-labor, {:ref "Bio-Tech p. 31", :prereqs [:lend-vitality]}
;;    :euthanize, {:ref "Magic: Death Spells p. 14", :prereqs [:empathy,[:talents/magery,1],:spirit-empathy]}
;;    :final-rest, {:ref "Magic p. 89", :prereqs [[:or #{[:talents/magery,1],:spirit-empathy}]]}
;;    :great-healing, {:ref "Basic Set p. 248}; GURPS Magic p. 91", :prereqs [[:talents/magery,3],:major-healing]}
;;    :halt-aging, {:ref "Magic p. 94", :prereqs [[:talents/magery,2],[8,:healing]]}
;;    :healing-slumber, {:ref "Magic p. 94", :prereqs [[:talents/magery,2],:sleep,:minor-healing]}
;;    :instant-neutralize-poison, {:ref "Magic p. 92", :prereqs [[:talents/magery,2],:neutralize-poison]}
;;    :instant-regeneration, {:ref "Magic p. 93", :prereqs [[:talents/magery,3],:regeneration]}
;;    :instant-restoration, {:ref "Magic p. 93", :prereqs [[:talents/magery,2],:restoration]}
;;    :lend-energy, {:ref "Basic Set p. 248}; GURPS Magic p. 89", :prereqs [[:or #{[:talents/magery,1],:empathy}]]}
;;    :lend-vitality, {:ref "Basic Set p. 248}; GURPS Magic p. 89", :prereqs [:lend-energy]}
;;    :major-healing, {:ref "Basic Set p. 248}; GURPS Magic p. 91", :prereqs [[:talents/magery,1],:minor-healing]}
;;    :mass-resist-disease, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-disease]}
;;    :mass-resist-poison, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-poison]}
;;    :minor-healing, {:ref "Basic Set p. 248}; GURPS Magic p. 91", :prereqs [:lend-vitality]}
;;    :neutralize-poison, {:ref "Magic p. 92", :prereqs [[:or #{:cure-disease,[:talents/magery,3],:test-food}]]}
;;    :recover-energy, {:ref "Basic Set p. 248}; GURPS Magic p. 89", :prereqs [[:talents/magery,1],:lend-energy]}
;;    :regeneration, {:ref "Magic p. 93", :prereqs [[:talents/magery,2],:restoration]}
;;    :relieve-madness, {:ref "Magic p. 92", :prereqs [:lend-vitality,:wisdom]}
;;    :relieve-paralysis, {:ref "Magic p. 93", :prereqs [:stop-paralysis]}
;;    :relieve-sickness, {:ref "Magic p. 90", :prereqs [:lend-vitality]}
;;    :remove-contagion, {:ref "Magic p. 90", :prereqs [:decay,:clean,:or-cure-disease]}
;;    :remove-fetus, {:ref "Bio-Tech p. 32", :prereqs [[:or #{:ease-labor,:minor-healing,:apportation}]]}
;;    :resist-disease, {:ref "Magic p. 90", :prereqs [[:or #{:remove-contagion,:vigor}]]}
;;    :resist-poison, {:ref "Magic p. 91", :prereqs [:vigor]}
;;    :restoration, {:ref "Magic p. 93", :prereqs [[:or #{:major-healing,[:pick 2 [:relieve-paralysis,:relieve-sickness,:relieve-madness]],[:pick 2 [:restore-sight,:restore-hearing,:restore-speech,:restore-memory]]}]]}
;;    :restore-hearing, {:ref "Magic p. 92", :prereqs [[:or #{:minor-healing,:keen-hearing,:strike-deaf}]]}
;;    :restore-memory, {:ref "Magic p. 92", :prereqs [:awaken,[:attributes/int,11]]}
;;    :restore-sight, {:ref "Magic p. 92", :prereqs [[:or #{:minor-healing,:keen-vision,:strike-blind}]]}
;;    :restore-speech, {:ref "Magic p. 93", :prereqs [[:or #{:minor-healing,:great-voice,:strike-dumb}]]}
;;    :resurrection, {:ref "Magic p. 94", :prereqs [:instant-regeneration,:summon-spirit]}
;;    :resuscitate, {:ref "Magic: Death Spells p. 14", :prereqs [[:talents/magery,2],:awaken,:stop-spasm]}
;;    :sense-disease, {:ref "Bio-Tech p. 32", :prereqs [[:or #{:sense-life,[2,:healing]}]]}
;;    :share-energy, {:ref "Magic p. 89", :prereqs [:lend-energy]}
;;    :share-vitality, {:ref "Magic p. 90", :prereqs [:lend-vitality]}
;;    :stop-bleeding, {:ref "Magic p. 91}; GURPS Fantasy p. 169", :prereqs [:lend-vitality]}
;;    :stop-paralysis, {:ref "Magic p. 93", :prereqs [:minor-healing,[:or #{:paralyze-limb,:strike-dumb}]]}
;;    :stop-spasm, {:ref "Magic p. 35", :prereqs [[:or #{:spasm,lend-vitality}]]}
;;    :suspended-animation, {:ref "Magic p. 94", :prereqs [:sleep,[4,:healing]]}
;;    :transference-bolt, {:ref "Magic Styles: Dungeon Magic p. 19", :prereqs [[:pick 3 [:ball-of-lightning,:flaming-armor,:rain-of-acid,:breathe-fire,:flaming-missiles,:rain-of-fire,:breathe-steam,:flaming-weapon-rive,:burning-touch,:lightning-armor,:shocking-touch,:continual-sunlight,:lightning-missiles,:spark-cloud,:explosive-fireball,:lightning-stare,:spark-storm,:explosive-lightning,:lightning-weapon,:spit-acid,:fire-cloud,:lightning-whip,:wall-of-lightning]]]}
;;    :youth, {:ref "Magic p. 94", :prereqs [[:talents/magery,3],:halt-aging]}
;;    :complex-illusion, {:ref "Magic p. 96}; GURPS Fantasy p. 170; GURPS Social Engineering: Back to School p. 24", :prereqs [:sound,:simple-illusion]}
;;    :control-creation, {:ref "Magic p. 99", :prereqs [[:or #{:create-animal,:create-servant}]]}
;;    :control-illusion, {:ref "Magic p. 97", :prereqs [:perfect-illusion]}
;;    :create-animal, {:ref "Magic p. 98", :prereqs [:create-water,:create-object,[:attributes/int,12]]}
;;    :create-foreign-body, {:ref "Magic: Death Spells p. 14", :prereqs [[:talents/magery,3],:body-reading,:create-object]}
;;    :create-mount, {:ref "Magic p. 99", :prereqs [[:talents/magery,3],:create-animal]}
;;    :create-object, {:ref "Magic p. 98", :prereqs [[:talents/magery,2],:create-earth,:perfect-illusion]}
;;    :create-servant, {:ref "Magic p. 98", :prereqs [[:talents/magery,3],[:attributes/int,12],:create-object]}
;;    :create-trap, {:ref "Magic: Artillery Spells p. 17", :prereqs [[:talents/magery,4],:10-illusion,:creation,:create-object]}
;;    :create-warrior, {:ref "Magic p. 98", :prereqs [:create-servant]}
;;    :dispel-creation, {:ref "Magic p. 99", :prereqs [:control-creation]}
;;    :dispel-illusion, {:ref "Magic p. 97", :prereqs [:control-illusion]}
;;    :duplicate, {:ref "Magic p. 98", :prereqs [:create-object,:copy]}
;;    :illusion-disguise, {:ref "Magic p. 96}; GURPS Fantasy p. 170", :prereqs [:simple-illusion]}
;;    :illusion-shell, {:ref "Magic p. 96}; GURPS Fantasy p. 170; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:simple-illusion]}
;;    :independence, {:ref "Magic p. 96", :prereqs [:simple-illusion]}
;;    :initiative, {:ref "Magic p. 97", :prereqs [:independence,:wisdom]}
;;    :inscribe, {:ref "Magic p. 97", :prereqs [:simple-illusion,:copy]}
;;    :know-illusion, {:ref "Magic p. 97", :prereqs [:simple-illusion]}
;;    :mirror,:{mirror, :ref "Magic: Artillery Spells p. 17", :prereqs [[:talents/magery,4],:initiative,:phantom]}
;;    :perfect-illusion, {:ref "Magic p. 96}; GURPS Social Engineering: Back to School p. 24", :prereqs [[:talents/magery,1],:complex-illusion]}
;;    :phantom, {:ref "Magic p. 97", :prereqs [[:talents/magery,2],:perfect-illusion,:hinder,:apportation]}
;;    :phantom-flame, {:ref "Magic p. 73", :prereqs [[:or #{:shape-fire,simple-illusion}]]}
;;    :phantom-killer, {:ref "Magic: Death Spells p. 14", :prereqs [[:talents/magery,3],:phantom]}
;;    :simple-illusion, {:ref "Magic p. 95}; GURPS Fantasy p. 170; GURPS Social Engineering: Back to School p. 24", :prereqs [:no-blindness,[:attributes/int,11]]}
;;    :air-vision, {:ref "Magic p. 24", :prereqs [:shape-air]}
;;    :alarm, {:ref "Magic p. 100", :prereqs [:tell-time]}
;;    :analyze-magic, {:ref "Basic Set p. 249}; GURPS Magic p. 102", :prereqs [:identify-spell]}
;;    :analyze-heredity, {:ref "Bio-Tech p. 30", :prereqs [[:or #{:seeker,sense-life}]]}
;;    :ancient-history, {:ref "Magic p. 106", :prereqs [:history]}
;;    :astral-vision, {:ref "Magic p. 105", :prereqs [:sense-spirit,:see-invisible]}
;;    :aura, {:ref "Basic Set p. 249}; GURPS Magic p. 101", :prereqs [:detect-magic]}
;;    :detect-magic, {:ref "Basic Set p. 249}; GURPS Magic p. 101", :prereqs [[:talents/magery,1]]}
;;    # :divination, {:ref "Magic p. 108", :prereqs [:history,:other-by-specialty]}
;;    :astrology, {:ref "Magic p. 108}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:history,:predict-weather,:astronomy-15]}
;;    :augury, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :bibliomancy, {:ref "3/48: Secret Magic p. 21", :prereqs [[5,:book-]]};-literature-12+-may-substitute-for-1]]}
;;    :cartomancy, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :crystal-gazing, {:ref "Magic p. 108", :prereqs ,[[:or #{:history,:earth-vision,water-vision}]]}
;;    :dactylomancy, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :extispicy, {:ref "Magic p. 108}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:history,[4,:animal]]}
;;    :gastromancy, {:ref "Magic p. 109", :prereqs [:history,[:skills/hypnotism,15],[3,:mind-control]]}
;;    :genomancy, {:ref "Bio-Tech p. 32", :prereqs [:analyze-heredity,[2,:healing],[2,:body-control]]}
;;    :geomancy, {:ref "Magic p. 109", :prereqs [:history,[4,:earth]]}
;;    :lecanomancy, {:ref "Magic p. 109", :prereqs [:history,[4,:water]]}
;;    :numerology,:{or-arithmancy, :ref "Magic p. 109", :prereqs [:history,:talents/mathematical-ability]}
;;    :oenomancy, {:ref "3/43: Thaumatology III p. 8", :prereqs ,:five-tétarto}
;;    :oneiromancy, {:ref "Magic p. 109", :prereqs [:history,[4,:communication],[4,:empathy]]}
;;    :physiognomy, {:ref "Magic p. 109", :prereqs [:history,[4,:body-control]]}
;;    :pyromancy, {:ref "Magic p. 109", :prereqs [:history,[4,:fire]]}
;;    :rhabdomancy, {:ref "Underground Adventures p. 23", :prereqs [:seek-air,:seek-earth,:seek-fire,:seek-water]}
;;    :sortilege, {:ref "Magic p. 109", :prereqs [:history,:1-from-4-elements]}
;;    :symbol-casting, {:ref "Magic p. 109", :prereqs [:history,[:skills/symbol-drawing,15]]}
;;    :earth-vision, {:ref "Magic p. 51", :prereqs [:shape-earth]}
;;    :echoes-of-the-past, {:ref "Magic p. 107", :prereqs [[:talents/magery,2],:history,:voices]}
;;    :far-feeling, {:ref "Magic p. 100", :prereqs [[:talents/magery,1]]}
;;    :far-hearing, {:ref "Magic p. 173", :prereqs [[:or #{[:talents/magery,1],[4,:sound]}]]};-may-not-have-deafness,hard-of-hearing}]]}
;;    :far-tasting, {:ref "Magic p. 77", :prereqs [[:or #{[:talents/magery,1],seek-food,seek-air}]]};-cannot-have-no-sense-of-taste/smell}]]}
;;    :find-direction, {:ref "Magic p. 101", :prereqs [[:talents/magery,1]]}
;;    :forbidden-wisdom, {:ref "Magic: Death Spells p. 15", :prereqs [[:talents/magery,3],:recall,:see-secrets]}
;;    :glass-wall, {:ref "Magic p. 103", :prereqs [[:or #{[5,:other-knowledge,:earth-vision]}]]}
;;    :history, {:ref "Magic p. 104", :prereqs [:trace]}
;;    :identify-loot, {:ref "3/64: Pirates and Swashbucklers p. 14", :prereqs [[:talents/magery,2],:7-4th-level]}
;;    :identify-spell, {:ref "Basic Set p. 249}; GURPS Magic p. 102", :prereqs [:detect-magic]}
;;    :images-of-the-past, {:ref "Magic p. 105", :prereqs [[:talents/magery,2],:history,:simple-illusion]}
;;    :invisible-wizard-eye, {:ref "Magic p. 104", :prereqs [:wizard-eye,:invisibility]}
;;    :know-location, {:ref "Magic p. 103", :prereqs [[:talents/magery,1],:tell-position]}
;;    :know-recipe, {:ref "Magic p. 78", :prereqs [:far-tasting,:season]}
;;    :know-true-shape, {:ref "Magic p. 104", :prereqs [[:talents/magery,1],[:1,:shifting],[:or #{aura,know-illusion}]]}
;;    :mage-sense, {:ref "Magic p. 102", :prereqs [:detect-magic]}
;;    :mage-sight, {:ref "Magic p. 102", :prereqs [:detect-magic]}
;;    :measurement, {:ref "Magic p. 100", :prereqs []}
;;    :memorize, {:ref "Magic p. 105}; GURPS Social Engineering: Back to School p. 24", :prereqs [[:or #{:wisdom,6-knowledge}]]}
;;    :metal-vision, {:ref "Magic p. 183", :prereqs [:shape-metal]}
;;    :mind-over-matter, {:ref "Magic Styles: Dungeon Magic p. 27", :prereqs [[:talents/magery,2],:divination-any,:mage-sight]}
;;    :pathfinder, {:ref "Magic p. 105", :prereqs [[:talents/magery,1],[:attributes/int,12],[2,:seek]]};-also-a-license-from-paizo]}
;;    :plant-vision, {:ref "Magic p. 162", :prereqs [:shape-plant]}
;;    :plastic-vision, {:ref "Magic p. 183", :prereqs [:shape-plastic]}
;;    :prehistory, {:ref "Magic p. 104", :prereqs [:ancient-history]}
;;    :projection, {:ref "Magic p. 105", :prereqs [:sense-spirit,[4,:knowledge]]}
;;    :recall, {:ref "Magic p. 104", :prereqs [[:talents/magery,2],:memorize,:history]}
;;    :reconstruct-spell, {:ref "Magic p. 104", :prereqs [[:talents/magery,2],:history,:identify-spell]}
;;    :remember-path, {:ref "Magic p. 105", :prereqs [:find-direction,:memorize]}
;;    :retro-reading, {:ref "3/48: Secret Magic p. 22", :prereqs [:trace]}
;;    :scents-of-the-past, {:ref "Magic p. 107", :prereqs [[:talents/magery,2],:history,:odor]}
;;    :schematic, {:ref "Magic p. 177", :prereqs [:reveal-function,:history]}
;;    :see-secrets, {:ref "Magic p. 105}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [:seeker,:aura]}
;;    :seek-ley-line, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [[:talents/magery,1]]}
;;    :seek-magic, {:ref "Magic p. 102", :prereqs [:detect-magic]}
;;    :seek-navy, {:ref "3/64: Pirates and Swashbucklers p. 14", :prereqs ,:8-third-level}
;;    :seeker, {:ref "Basic Set p. 249}; GURPS Magic p. 105", :prereqs [[:talents/magery,1],[:attributes/int,12],2-"seek"]}
;;    :sense-mana, {:ref "Magic p. 101", :prereqs [:detect-magic]}
;;    :small-vision, {:ref "Magic p. 111", :prereqs [[:or #{:keen-vision,[5,:light],:darkness}]]};-subject-cannot-have-blindness,:bad-sight}]]}
;;    :summon-shade, {:ref "Magic p. 102", :prereqs [[:or #{:summon-spirit,:divination}]]}
;;    :tell-position, {:ref "Magic p. 101", :prereqs [:measurement]}
;;    :tell-time, {:ref "Magic p. 100", :prereqs []}
;;    :test-load, {:ref "Magic p. 101", :prereqs [:measurement]}
;;    :trace, {:ref "Basic Set p. 249}; GURPS Magic p. 106", :prereqs [:seeker]}
;;    :trace-labyrinth, {:ref "Underground Adventures p. 22", :prereqs [[:talents/magery,1],:seek-l,form]}
;;    :vision-of-doom, {:ref "Magic: Death Spells p. 15", :prereqs [[:talents/magery,3],:summon-shade]}
;;    :water-vision, {:ref "Magic p. 187", :prereqs [:shape-water]}
;;    :wizard-ear, {:ref "Magic p. 104", :prereqs [:apportation,:far-hearing,:sound-vision]}
;;    :wizard-eye, {:ref "Magic p. 104", :prereqs [:apportation,:keen-vision]}
;;    :wizard-hand, {:ref "Magic p. 104", :prereqs [:manipulate,:far-feeling]}
;;    :wizard-mouth, {:ref "Magic p. 104", :prereqs [:apportation,:far-tasting,:great-voice]}
;;    :wizard-nose, {:ref "Magic p. 104", :prereqs [:apportation,:far-tasting]}
;;    :astrology, {:ref "Magic p. 108}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:history,:predict-weather,:astronomy-15]}
;;    :augury, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :bibliomancy, {:ref "3/48: Secret Magic p. 21", :prereqs [[5,:book-]]};-literature-12+-may-substitute-for-1]]}
;;    :cartomancy, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :crystal-gazing, {:ref "Magic p. 108", :prereqs [[:or #{:history,:earth-vision,water-vision}]]}
;;    :dactylomancy, {:ref "Magic p. 108", :prereqs [:history,:1-from-4-elements]}
;;    :extispicy, {:ref "Magic p. 108}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:history,[4,:animal]]}
;;    :gastromancy, {:ref "Magic p. 109", :prereqs [:history,[:skills/hypnotism,15],[3,:mind-control]]}
;;    :genomancy, {:ref "Bio-Tech p. 32", :prereqs [:analyze-heredity,[2,:healing],2-body-control]}
;;    :geomancy, {:ref "Magic p. 109", :prereqs [:history,[4,:earth]]}
;;    :lecanomancy, {:ref "Magic p. 109", :prereqs [:history,[4,:water]]}
;;    :numerology,:{or-arithmancy, :ref "Magic p. 109", :prereqs [:history,:mathematical-ability]}
;;    :oenomancy, {:ref "3/43: Thaumatology III p. 8", :prereqs ,:five-tétarto}
;;    :oneiromancy, {:ref "Magic p. 109", :prereqs [:history,[4,:communication],:empathy]}
;;    :physiognomy, {:ref "Magic p. 109", :prereqs [:history,[4,:body-control]]}
;;    :pyromancy, {:ref "Magic p. 109", :prereqs [:history,[4,:fire]]}
;;    :rhabdomancy, {:ref "Underground Adventures p. 23", :prereqs [:seek-air,:seek-earth,:seek-fire,:seek-water]}
;;    :sortilege, {:ref "Magic p. 109", :prereqs [:history,:1-from-4-elements]}
;;    :symbol-casting, {:ref "Magic p. 109", :prereqs [:history,[:skills/symbol-drawing,15]]}
;;    :ley-buffer, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:talents/magery,1],:ley-tap]}
;;    :ley-float, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:talents/magery,3],:enchant,:ley-supply]}
;;    :ley-line-creation, {:ref "Thaumatology: Urban Magics p. 21", :prereqs [:seek-ley-line,:apportation]}
;;    :ley-running, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:seek-ley-line,:haste]}
;;    :ley-speech, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:seek-ley-line,:voices]}
;;    :ley-supply, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:or #{:ley-tap,lend-energy,minor-draw-power}]]}
;;    :ley-tap, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [:seek-ley-line]}
;;    :ley-vehicle, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:ley-float,:ley-running]}
;;    :seek-ley-line, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [[:talents/magery,1]]}
;;    :blackout, {:ref "Magic p. 112", :prereqs [:darkness]}
;;    :blur, {:ref "Basic Set p. 250}; GURPS Magic p. 113", :prereqs [:darkness]}
;;    :body-of-shadow, {:ref "Magic p. 114", :prereqs [[:talents/magery,2],:shape-darkness]}
;;    :bright-vision, {:ref "Magic p. 111", :prereqs [[:or #{:keen-vision,[5,:light]}]]}
;;    :cleansing-light, {:ref "Magic: Death Spells p. 16", :prereqs [[:talents/magery,3],[10,:light],:darkness,:flash,:light-jet,:sunbolt]}
;;    :colors, {:ref "Magic p. 110", :prereqs [:light]}
;;    :continual-light, {:ref "Basic Set p. 249}; GURPS Magic p. 110", :prereqs [:light]}
;;    :continual-mage-light, {:ref "Magic p. 113", :prereqs [:mage-light,:continual-light]}
;;    :continual-sunlight, {:ref "Magic p. 114", :prereqs [:sunlight]}
;;    :dark-vision, {:ref "Magic p. 111", :prereqs [:continual-light]}
;;    :darkness, {:ref "Basic Set p. 250}; GURPS Magic p. 111", :prereqs [:continual-light]}
;;    :flash, {:ref "Magic p. 112", :prereqs [:continual-light]}
;;    :gloom, {:ref "Magic p. 112", :prereqs [:continual-light]}
;;    :glow, {:ref "Magic p. 112", :prereqs [:continual-light]}
;;    :hawk-vision, {:ref "Magic p. 111", :prereqs [[:or #{:keen-vision,[5,:light]}]]}
;;    :hide, {:ref "Magic p. 113}; GURPS Fantasy p. 170", :prereqs [[:or #{:blur,forgetfulness}]]}
;;    :images-of-the-past, {:ref "Magic p. 105", :prereqs [[:talents/magery,2],:history,:simple-illusion]}
;;    :infravision, {:ref "Magic p. 111", :prereqs [[:or #{:keen-vision,[5,:light]}]]}
;;    :invisibility, {:ref "Magic p. 114}; GURPS Fantasy p. 170; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:talents/magery,2],[:attributes/int,13],:invisibility]}
;;    :light, {:ref "Basic Set p. 253}; GURPS Magic p. 110", :prereqs []}
;;    :light-jet, {:ref "Magic p. 112", :prereqs [[:or #{:continual-light,shape-light}]]}
;;    :mage-light, {:ref "Magic p. 113", :prereqs [:mage-sight,:light]}
;;    :mass-invisibility, {:ref "Magic Styles: Dungeon Magic p. 32", :prereqs [[:talents/magery,2],[:attributes/int,13],:hallucination]}
;;    :mass-shade, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [[:attributes/int,12],:shade]}
;;    :mirror, {:ref "Magic p. 112", :prereqs [:colors]}
;;    :night-vision, {:ref "Magic p. 111}; GURPS Fantasy p. 170", :prereqs [[5,:light-and-darkness]]}
;;    :remove-reflection, {:ref "Magic p. 113", :prereqs [:remove-shadow]}
;;    :remove-shadow, {:ref "Magic p. 110", :prereqs [:light]}
;;    :see-invisible, {:ref "Magic p. 113", :prereqs [:or #{[:dark-vision,:infravision],:invisibility}]}
;;    :shadow-slay, {:ref "Magic: Death Spells p. 16", :prereqs [[:talents/magery,3],:body-of-shadow,:remove-shadow]}
;;    :shade, {:ref "Magic p. 169", :prereqs [[:or #{:continual-light,shield}]]}
;;    :shape-darkness, {:ref "Magic p. 113", :prereqs [:darkness]}
;;    :shape-light, {:ref "Magic p. 111", :prereqs [:light]}
;;    :small-vision, {:ref "Magic p. 111", :prereqs [[:or #{:keen-vision,[5,:light],:darkness}]]};-subject-cannot-have-blindness,:bad-sight}]]}
;;    :sunbolt, {:ref "Magic p. 114", :prereqs [[6,:light-and-darkness,sunlight]]}
;;    :sunburst, {:ref "Magic: Artillery Spells p. 18", :prereqs [[:talents/magery,3],[10,:light],:darkness,:flash,:sunbolt]}
;;    :sunlight, {:ref "Magic p. 114", :prereqs [[:talents/magery,1],:glow,:colors]}
;;    :suns-arc, {:ref "Magic: Artillery Spells p. 18", :prereqs [[:talents/magery,4],[10,:light],:darkness,:light-jet,:sunbolt]}
;;    :wall-of-light, {:ref "Magic p. 113", :prereqs [:continual-light]}
;;    :animate-object, {:ref "Magic p. 117", :prereqs [[:talents/magery,2],3-shape]}
;;    :annihilation, {:ref "Magic: Death Spells p. 16", :prereqs [[:talents/magery,3],:disintegrate,[:or #{deathtouch,steal-vitality}]]}
;;    :awaken-craft-spirit, {:ref "Magic p. 115", :prereqs [:inspired-creation,:sense-spirit]}
;;    :clean, {:ref "Magic p. 116", :prereqs [:restore]}
;;    :contract-object, {:ref "Magic p. 120", :prereqs [[:talents/magery,3],:transform-object]}
;;    :copy, {:ref "Magic p. 116", :prereqs [:dye,:1-written-language-at-accented]}
;;    :destabilization, {:ref "Magic: Death Spells p. 16", :prereqs [[:talents/magery,3],:annihilation,:explode]}
;;    :disintegrate, {:ref "Magic p. 120", :prereqs [[:talents/magery,2],:shatter,:ruin,:earth-to-air,:destroy-air,:destroy-water]}
;;    :draw-together-shards, {:ref "Alphabet Arcane p. 9", :prereqs [:repair,:trace,:apportation]}
;;    :dye, {:ref "Magic p. 116", :prereqs [:restore,:colors]}
;;    :enlarge-object, {:ref "Magic p. 120", :prereqs [:extend-object]}
;;    :explode, {:ref "Magic p. 118", :prereqs [[:talents/magery,2],:shatter,:apportation]}
;;    :explosive-mine, {:ref "Magic: Artillery Spells p. 19", :prereqs [[:talents/magery,3],:10-making,:breaking,:explode]}
;;    :extend-object, {:ref "Magic p. 120", :prereqs [[:talents/magery,3],:transform-object]}
;;    :fasten, {:ref "Magic p. 118", :prereqs [:knot]}
;;    :find-weakness, {:ref "Magic p. 116", :prereqs [[:1,:1-from-4-elements]]}
;;    :inscribe, {:ref "Magic p. 97", :prereqs [:simple-illusion,:copy]}
;;    :inspired-creation, {:ref "Magic p. 115", :prereqs []}
;;    :knot, {:ref "Magic p. 117", :prereqs [:stiffen]}
;;    :mapmaker, {:ref "Magic p. 118", :prereqs [:inscribe,:measurement]}
;;    :minefield, {:ref "Magic: Artillery Spells p. 19", :prereqs [[:talents/magery,4],:explosive-mine]}
;;    :mystic-mark, {:ref "Magic p. 119", :prereqs [:dye,:trace]}
;;    :rebuild, {:ref "Magic p. 177", :prereqs [[:talents/magery,3],:repair,:create-object,3-of-each-element]}
;;    :rejoin, {:ref "Magic p. 116", :prereqs [:weaken,:restore]}
;;    :repair, {:ref "Magic p. 118", :prereqs [[:talents/magery,2],:rejoin]}
;;    :reshape, {:ref "Magic p. 117", :prereqs [[:talents/magery,1],:weaken,[:or #{shape-earth,shape-plant}]]}
;;    :restore, {:ref "Magic p. 116", :prereqs [[:or #{:find-weakness,simple-illusion}]]}
;;    :rive, {:ref "Magic p. 117", :prereqs [[:talents/magery,2],:shatter]}
;;    :ruin, {:ref "Magic p. 118", :prereqs [[:talents/magery,1],:weaken,:decay]}
;;    :self-repairing, {:ref "3/76: Dungeon Fantasy IV p. 15", :prereqs [[:talents/magery,2],:repair]}
;;    :sharpen, {:ref "Magic p. 118", :prereqs [:repair]}
;;    :shatter, {:ref "Magic p. 116", :prereqs [[:talents/magery,1],:weaken]}
;;    :shatterproof, {:ref "Magic p. 118", :prereqs [:repair,:shatter]}
;;    :shrink-object, {:ref "Magic p. 120", :prereqs [:contract-object]}
;;    :soilproof, {:ref "Magic p. 116}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:materialize]}
;;    :stiffen, {:ref "Magic p. 117", :prereqs [:rejoin]}
;;    :toughen, {:ref "Magic p. 119", :prereqs [:shatterproof]}
;;    :transfigure-object, {:ref "3/76: Dungeon Fantasy IV p. 15", :prereqs [[:talents/magery,3],:transform-object]}
;;    :transparency, {:ref "Magic p. 119", :prereqs [:dye,:stone-to-earth]}
;;    :weaken, {:ref "Magic p. 116", :prereqs [:find-weakness]}
;;    :weapon-self, {:ref "Magic p. 119", :prereqs [[:talents/magery,2],:apportation,:6-making,:breaking,:reshape]}
;;    :bless, {:ref "Magic p. 129", :prereqs [[:talents/magery,2],2-each-from-10-colleges]}
;;    :catch-spell, {:ref "Magic p. 123", :prereqs [[:talents/magery,2],:dx-12+,:return-missile]}
;;    :charge-powerstone, {:ref "Magic p. 126", :prereqs [[:talents/magery,3],:powerstone,:lend-energy]}
;;    :conceal-magic, {:ref "Magic p. 122", :prereqs [:detect-magic]}
;;    :counterspell, {:ref "Basic Set p. 250}; GURPS Magic p. 121", :prereqs [[:talents/magery,1],:spell-being-countered]}
;;    :curse, {:ref "Magic p. 129", :prereqs [[:talents/magery,2],2-each-from-10-colleges]}
;;    :dispel-magic, {:ref "Basic Set p. 250}; GURPS Magic p. 126", :prereqs [:counterspell,[12,:meta]]}
;;    :dispel-spark, {:ref "Magic: Death Spells p. 17", :prereqs [[:talents/magery,3],:drain-mana,:remove-aura]}
;;    :displace-spell, {:ref "Magic p. 124", :prereqs [:suspend-magic]}
;;    :drain-magery, {:ref "Magic p. 130", :prereqs [[:talents/magery,3],:suspend-magery]}
;;    :drain-mana, {:ref "Magic p. 127", :prereqs [:dispel-magic,:suspend-mana]}
;;    :dread-curse, {:ref "Magic: Death Spells p. 17", :prereqs [[:talents/magery,3],:curse]}
;;    :end-scene, {:ref "3/28: Thaumatology II p. 37", :prereqs []}
;;    :false-aura, {:ref "Magic p. 122", :prereqs [:conceal-magic,:aura]}
;;    :great-ward, {:ref "Magic p. 122", :prereqs [[:talents/magery,2],:ward]}
;;    :hang-spell, {:ref "Magic p. 128}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:delay]}
;;    :internalize-elixir, {:ref "3/28: Thaumatology II p. 10", :prereqs [[:talents/magery,1],:detect-magic,:know-recipie]}
;;    :lend-spell, {:ref "Magic p. 126", :prereqs [[:talents/magery,1],:lend-skill,:1-spell-each-from-6-colleges]}
;;    :ley-buffer, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:talents/magery,1],:ley-tap]}
;;    :ley-line-creation, {:ref "Thaumatology: Urban Magics p. 21", :prereqs [:seek-ley-line,:apportation]}
;;    :ley-supply, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:or #{:ley-tap,lend-energy,minor-draw-power}]]}
;;    :magic-resistance, {:ref "Magic p. 123", :prereqs [[:talents/magery,1],:1-spell-each-from-7-colleges]}
;;    :mana-vortex, {:ref "Magic Styles: Dungeon Magic p. 27", :prereqs [[:talents/magery,2],:lend-energy,:sense-danger,:sense-mana]}
;;    :maintain-spell, {:ref "Magic p. 128", :prereqs [:link]}
;;    :mana-storm, {:ref "Magic: Artillery Spells p. 19", :prereqs [[:talents/magery,4],:drain-mana,:restore-mana]}
;;    :penetrating-spell, {:ref "Magic p. 123", :prereqs [:delay,:find-weakness]}
;;    :pentagram, {:ref "Magic p. 124", :prereqs [:spell-shield]}
;;    :preemptive-experience, {:ref "3/28: Thaumatology II p. 37", :prereqs []}
;;    :punishment-circle, {:ref "Magic: Artillery Spells p. 19", :prereqs [[:or #{[:talents/magery,3],pentagram,:repel-spirits}]]}
;;    :raise-cone-of-power, {:ref "Thaumatology p. 52", :prereqs [[:or #{:lend-energy,pentagram,:restore-mana}]]}
;;    :reflect, {:ref "Magic p. 122", :prereqs [:ward]}
;;    :remove-aura, {:ref "Magic p. 127", :prereqs [:dispel-magic,:aura]}
;;    :remove-curse, {:ref "Magic p. 126", :prereqs [[:talents/magery,2],:1-spell-from-each-of-15-colleges]}
;;    :restore-mana, {:ref "Magic p. 128", :prereqs [:dispel-magic,:suspend-mana]}
;;    :scryfool, {:ref "Magic p. 123", :prereqs [[:talents/magery,2],:sense-observation,:simple-illusion]}
;;    :scryguard, {:ref "Fantasy p. 170", :prereqs [[:talents/magery,1]]}
;;    :scrywall, {:ref "Magic p. 122}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:scryguard]}
;;    :seek-magic, {:ref "Magic p. 102", :prereqs [:detect-magic]}
;;    :sovereign-countermagic, {:ref "Magic Styles: Dungeon Magic p. 28", :prereqs [[:talents/magery,3],:analyze-magic,:dispel-magic]}
;;    :sovereign-ward, {:ref "Magic Styles: Dungeon Magic p. 28", :prereqs [[:talents/magery,3],:dispel-magic,:ward]}
;;    :spellguard, {:ref "Magic p. 127", :prereqs [:dispel-magic]}
;;    :spell-shield, {:ref "Magic p. 124", :prereqs [[:talents/magery,2],:scryguard,:magic-resistance]}
;;    :spell-wall, {:ref "Magic p. 124", :prereqs [:spell-shield]}
;;    :steal-spell, {:ref "Magic p. 127", :prereqs [:lend-spell,:great-ward]}
;;    :suspend-curse, {:ref "Magic p. 125", :prereqs [[:talents/magery,1],:1-spell-each-from-12-colleges]}
;;    :suspend-magery, {:ref "Magic p. 130", :prereqs [[:talents/magery,2],2-each-from-10-colleges]}
;;    :suspend-magic, {:ref "Magic p. 123", :prereqs [:suspend-spell,:8-other]}
;;    :suspend-mana, {:ref "Magic p. 125", :prereqs [:suspend-magic,:1-spell-each-from-10-colleges]}
;;    :suspend-spell, {:ref "Magic p. 121", :prereqs [[:talents/magery,1]]}
;;    :telecast, {:ref "Magic p. 128", :prereqs [[:talents/magery,3],:teleport,:wizard-eye,:1-spell-each-from-10-colleges]}
;;    :throw-spell, {:ref "Magic p. 128", :prereqs [:delay,:catch-spell]}
;;    :void-bolt, {:ref "3/25: Epic Magic p. 19", :prereqs [[:talents/magery,4],[4,:essential-element--of-different-colleges],[4,:missile],[:1,:from-each-of-the-essential-element--taken-as-prerequisites]]}
;;    :ward, {:ref "Magic p. 122", :prereqs [[:talents/magery,1]]}
;;    :delay, {:ref "Magic p. 130}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[:talents/magery,3],:15]}
;;    :link, {:ref "Magic p. 131}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:delay]}
;;    :reflex, {:ref "Magic p. 132}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:delay,:ward]}
;;    :alertness, {:ref "Magic p. 133", :prereqs [[:talents/magery,2],:create-acid]}
;;    :avoid, {:ref "Magic p. 140", :prereqs [:hide,:fear,:forgetfulness]}
;;    :berserker, {:ref "Magic p. 134", :prereqs [:bravery]}
;;    :boost-intelligence, {:ref "Magic p. 37", :prereqs [:wisdom]}
;;    :bravery, {:ref "Magic p. 134", :prereqs [:fear]}
;;    :charm, {:ref "Magic p. 139", :prereqs [:m1,:loyalty,:7-other-mind-control]}
;;    :coma, {:ref "Magic: Death Spells p. 17", :prereqs [[:talents/magery,3],:lesser-geas,:sleep]}
;;    :command, {:ref "Basic Set p. 251}; GURPS Magic p. 136", :prereqs [[:talents/magery,2],:forgetfulness]}
;;    :compel-lie, {:ref "Magic p. 137", :prereqs [:emotion-control]}
;;    :confuse-memory, {:ref "3/48: Secret Magic p. 14", :prereqs [:foolishness]}
;;    :daze, {:ref "Basic Set p. 250}; GURPS Magic p. 134", :prereqs [:foolishness]}
;;    :discord, {:ref "Magic Styles: Dungeon Magic p. 31", :prereqs [[:talents/magery,2],:emotion-control,:vexation]}
;;    :disorient, {:ref "Magic p. 135", :prereqs [:foolishness]}
;;    :dream-projection, {:ref "Magic p. 46", :prereqs [:dream-sending]}
;;    :dream-sending, {:ref "Magic p. 45", :prereqs [[:or #{:dream-viewing,sleep}]]}
;;    :drunkenness, {:ref "Magic p. 136", :prereqs [:foolishness,:clumsiness]}
;;    :dull-sense, {:ref "Magic p. 133", :prereqs []}
;;    :dull-hearing, {:ref "Magic p. 133", :prereqs []}
;;    :dull-taste-and-smell, {:ref "Magic p. 133", :prereqs []}
;;    :dull-vision, {:ref "Magic p. 133", :prereqs []}
;;    :dullness, {:ref "Magic p. 134", :prereqs [[2,:dull]]}
;;    :ecstasy, {:ref "Magic p. 139", :prereqs [[:talents/magery,2],:emotion-control]}
;;    :emotion-control, {:ref "Magic p. 137", :prereqs [[:or #{:loyalty,mental-stun}]]}
;;    :encrypt, {:ref "Magic p. 135", :prereqs [:daze]}
;;    :enslave, {:ref "Magic p. 141", :prereqs [:charm,:telepathy]}
;;    :enthrall, {:ref "Magic p. 139", :prereqs [:forgetfulness,:daze,:slow]}
;;    :false-memory, {:ref "Magic p. 139", :prereqs [:forgetfulness,:6-other-mind-control]}
;;    :fascinate, {:ref "Magic p. 135", :prereqs [:daze]}
;;    :fear, {:ref "Magic p. 139}; GURPS Fantasy p. 171", :prereqs [[:or #{:sense-emotion,:empathy}]]}
;;    :foolishness, {:ref "Basic Set p. 250}; GURPS Magic p. 134", :prereqs [[:attributes/int,12]]}
;;    :forgetfulness, {:ref "Basic Set p. 250}; GURPS Magic p. 135", :prereqs [[:talents/magery,1],:foolishness]}
;;    :glib-tongue, {:ref "Magic p. 141", :prereqs [:suggestion]}
;;    :great-geas, {:ref "Magic p. 141}; GURPS Social Engineering: Back to School p. 24", :prereqs [[:talents/magery,3],:15-mind-control,lesser-geas]}
;;    :great-hallucination, {:ref "Magic p. 141", :prereqs [[:talents/magery,2],:hallucination]}
;;    :hallucination, {:ref "Magic p. 140", :prereqs [:madness,:suggestion]}
;;    :keen-sense, {:ref "Magic p. 133", :prereqs []}
;;    :keen-hearing, {:ref "Magic p. 133", :prereqs []}
;;    :keen-taste-and-smell, {:ref "Magic p. 133", :prereqs []}
;;    :keen-vision, {:ref "Magic p. 133", :prereqs []}
;;    :lesser-geas, {:ref "Magic p. 140}; GURPS Social Engineering: Back to School p. 24", :prereqs [[:talents/magery,2],:10-mind-control]}
;;    :literary-hunger, {:ref "3/48: Secret Magic p. 21", :prereqs [[:talents/magery,1]]}
;;    :loyalty, {:ref "Magic p. 136", :prereqs [:bravery,2-other-mind-control]}
;;    :lure, {:ref "Magic p. 137", :prereqs [:emotion-control]}
;;    :madness, {:ref "Magic p. 136", :prereqs [[:or #{:forgetfulness,:drunkenness}]]}
;;    :mass-charm, {:ref "Magic Styles: Dungeon Magic p. 31", :prereqs [[:talents/magery,2],[:attributes/int,13],:charm]}
;;    :mass-daze, {:ref "Basic Set p. 251}; GURPS Magic p. 137", :prereqs [:daze,[:attributes/int,13]]}
;;    :mass-hallucination, {:ref "Magic Styles: Dungeon Magic p. 32", :prereqs [[:talents/magery,2],[:attributes/int,13],:hallucination]}
;;    :mass-mutiliation, {:ref "Magic: Artillery Spells p. 20", :prereqs [[:talents/magery,4],:10-mind-control,:madness,:mass-suggestion]}
;;    :mass-sleep, {:ref "Basic Set p. 251}; GURPS Magic p. 137", :prereqs [:sleep,[:attributes/int,13]]}
;;    :mass-suggestion, {:ref "Magic p. 141", :prereqs [:suggestion]}
;;    :memorize, {:ref "Magic p. 105}; GURPS Social Engineering: Back to School p. 24", :prereqs [[:or #{:wisdom,6-knowledge}]]}
;;    :mental-stun, {:ref "Magic p. 135", :prereqs [[:or #{:daze,stun}]]}
;;    :mind-killer, {:ref "Magic: Death Spells p. 17", :prereqs [[:talents/magery,3],:sickness,:strengthen-will]}
;;    :mindlessness, {:ref "Magic p. 137", :prereqs [[:talents/magery,2],:forgetfulness]}
;;    :nightmare, {:ref "Magic p. 140", :prereqs [[:talents/magery,2],:death-vision,:fear,:sleep]}
;;    :oath, {:ref "Magic p. 138", :prereqs [[:talents/magery,1],:emotion-control]}
;;    :pacify, {:ref "Magic Styles: Dungeon Magic p. 24", :prereqs [[:talents/magery,2],:persuasion,:relieve-madness]}
;;    :panic, {:ref "Magic p. 134", :prereqs [:fear]}
;;    :peaceful-sleep, {:ref "Magic p. 138", :prereqs [:sleep,:silence]}
;;    :permanent-forgetfulness, {:ref "Magic p. 138", :prereqs [[:talents/magery,2],:forgetfulness,[:attributes/int,13]]}
;;    :permanent-madness, {:ref "Magic p. 139", :prereqs [[:talents/magery,2],:madness,[:attributes/int,13]]}
;;    :rear-vision, {:ref "Magic p. 134", :prereqs [:alertness]}
;;    :recall, {:ref "Magic p. 104", :prereqs [[:talents/magery,2],:memorize,:history]}
;;    :relieve-madness, {:ref "Magic p. 92", :prereqs [:lend-vitality,:wisdom]}
;;    :sickness, {:ref "Magic p. 138", :prereqs [[:or #{:drunkenness,pestilence}]]}
;;    :sleep, {:ref "Basic Set p. 251}; GURPS Magic p. 135", :prereqs [:daze]}
;;    :speed-reading, {:ref "3/48: Secret Magic p. 22", :prereqs [[:or #{[:attributes/int,12],gift-of-letters}]]}
;;    :stabbing-party, {:ref "Magic: Artillery Spells p. 20", :prereqs [[:talents/magery,4],:10-mind-control,:comm,:mass-suggestion]}
;;    :strengthen-will, {:ref "Magic p. 136", :prereqs [[:talents/magery,1],:6-mind-control]}
;;    :suggestion, {:ref "Magic p. 140", :prereqs [:emotion-control,:forgetfulness]}
;;    :terror, {:ref "Magic p. 134", :prereqs [:fear]}
;;    :vigil, {:ref "Magic p. 138", :prereqs [[:talents/magery,2],:sleep,:lend-energy]}
;;    :wallwalker, {:ref "Magic p. 144", :prereqs [:apportation]}
;;    :weaken-will, {:ref "Magic p. 136", :prereqs [[:talents/magery,1],:foolishness]}
;;    :will-lock, {:ref "Magic p. 138", :prereqs [:emotion-control]}
;;    :wisdom, {:ref "Magic p. 135}; GURPS Social Engineering: Back to School p. 24", :prereqs [[6,:other-mind-control]]}
;;    :writers-block, {:ref "3/48: Secret Magic p. 22", :prereqs [[:talents/magery,1]]}
;;    :dull-hearing, {:ref "Magic p. 133", :prereqs []}
;;    :dull-taste-and-smell, {:ref "Magic p. 133", :prereqs []}
;;    :dull-vision, {:ref "Magic p. 133", :prereqs []}
;;    :keen-hearing, {:ref "Magic p. 133", :prereqs []}
;;    :keen-taste-and-smell, {:ref "Magic p. 133", :prereqs []}
;;    :keen-vision, {:ref "Magic p. 133", :prereqs []}
;;    :air-vortex, {:ref "Magic p. 26", :prereqs [[:talents/magery,2],:body-of-air,:windstorm]}
;;    :apportation, {:ref "Basic Set p. 251}; GURPS Magic p. 142", :prereqs [[:talents/magery,1]]}
;;    :beacon, {:ref "Magic p. 83", :prereqs [:teleport,:timeport,:or-plane-shift]}
;;    :blink, {:ref "Magic p. 148", :prereqs [:teleport]}
;;    :blink-other, {:ref "Magic p. 148", :prereqs [:blink]}
;;    :cloud-vaulting, {:ref "Magic p. 148", :prereqs [[:talents/magery,2],:jump,:walk-on-air]}
;;    :cloud-walking, {:ref "Magic p. 148", :prereqs [:walk-on-air,:walk-on-water]}
;;    :collision, {:ref "Magic: Artillery Spells p. 21", :prereqs [[:talents/magery,4],:10-movement,:poltergeist,:pull]}
;;    :crushing-fist, {:ref "Magic: Artillery Spells p. 21", :prereqs [[:talents/magery,4],:10-movement,:distant-blow,:wizard-h,]}
;;    :dancing-object, {:ref "Magic p. 144", :prereqs [[:talents/magery,2],:apportation]}
;;    :deflect-missile, {:ref "Basic Set p. 251}; GURPS Magic p. 143", :prereqs [:apportation]}
;;    :disruption, {:ref "Magic: Death Spells p. 17", :prereqs [[:talents/magery,3],:any-10-movement,:manipulate,:undo]}
;;    :distant-blow, {:ref "Magic p. 144", :prereqs [[:talents/magery,2],:apportation]}
;;    :divert-teleport, {:ref "Magic p. 84", :prereqs [:mager-3,:trace-teleport]}
;;    :ethereal-body, {:ref "Magic p. 146", :prereqs [[6,:movement],:or-magery-3,:body-of-air]}
;;    :flight, {:ref "Magic p. 145}; GURPS Fantasy p. 171", :prereqs [[:talents/magery,2],:levitation]}
;;    :flying-carpet, {:ref "Magic p. 145", :prereqs [:flight,:or-magery-2,:walk-on-air]}
;;    :force-ball, {:ref "Magic: Artillery Spells p. 24", :prereqs [[:talents/magery,4],:catch-spell,:force-dome,:sense-foes]}
;;    :freedom, {:ref "Magic p. 148", :prereqs [[3,:body-control],[3,:movement],3-protection,:warning]}
;;    :glue, {:ref "Magic p. 142", :prereqs [:haste]}
;;    :grease, {:ref "Magic p. 142", :prereqs [:haste]}
;;    :great-deflect-missile, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magic Styles: Dungeon Magic", :prereqs [[:talents/magery,2],:deflect-missile]}
;;    :great-haste, {:ref "Basic Set p. 251}; GURPS Magic p. 146", :prereqs [[:talents/magery,1],[:attributes/int,12],:haste]}
;;    :haste, {:ref "Basic Set p. 251}; GURPS Magic p. 142", :prereqs []}
;;    :hawk-flight, {:ref "Magic p. 146", :prereqs [:flight]}
;;    :hinder, {:ref "Basic Set p. 244}; GURPS Magic p. 36", :prereqs [[:or #{:clumsiness,haste}]]}
;;    :hold-fast, {:ref "Magic p. 143", :prereqs [:apportation]}
;;    :increase-burden, {:ref "Magic p. 143", :prereqs [:apportation]}
;;    :jump, {:ref "Magic p. 143", :prereqs [:apportation]}
;;    :levitation, {:ref "Magic p. 143}; GURPS Fantasy p. 171", :prereqs [:apportation]}
;;    :ley-float, {:ref "Thaumatology: Urban Magics p. 20", :prereqs [[:talents/magery,3],:enchant,:ley-supply]}
;;    :ley-running, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:seek-ley-line,:haste]}
;;    :ley-vehicle, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:ley-float,:ley-running]}
;;    :light-tread, {:ref "Magic p. 145", :prereqs [:apportation,:shape-earth]}
;;    :lighten-burden, {:ref "Magic p. 143}; GURPS Fantasy p. 171", :prereqs [:apportation]}
;;    :lockmaster, {:ref "Basic Set p. 251}; GURPS Magic p. 144", :prereqs [[:talents/magery,2],:apportation]}
;;    :locksmith, {:ref "Magic p. 143", :prereqs [:apportation]}
;;    :long-march, {:ref "Magic p. 143", :prereqs [[:or #{[:talents/magery,1],:clumsiness,:debility}]]}
;;    :manipulate, {:ref "Magic p. 145", :prereqs [:locksmith]}
;;    :quarter, {:ref "Magic: Death Spells p. 18", :prereqs [[:talents/magery,3],:any-10-movement,:pull,:repel]}
;;    :quick-march, {:ref "Magic p. 144}; GURPS Fantasy p. 171", :prereqs [[:talents/magery,1],:haste]}
;;    :poltergeist, {:ref "Magic p. 144", :prereqs [:apportation]}
;;    :pull, {:ref "Magic p. 146", :prereqs [[:talents/magery,2],[4,:movement],levitation]}
;;    :rapid-journey, {:ref "Magic p. 82", :prereqs [[:or #{[:talents/magery,3],teleport,timeport}]]}
;;    :remove-fetus, {:ref "Bio-Tech p. 32", :prereqs [[:or #{:ease-labor,minor-healing,:apportation}]]}
;;    :repel, {:ref "Magic p. 146", :prereqs [[:talents/magery,2],[4,:movement],levitation]}
;;    :slasher, {:ref "Magic: Artillery Spells p. 22", :prereqs [[:talents/magery,4],:10-movement,:dancing-object,:winged-knife]}
;;    :slide, {:ref "Magic p. 145", :prereqs [:apportation,:grease]}
;;    :slow, {:ref "Magic p. 145", :prereqs [[:talents/magery,1],:haste,:hinder]}
;;    :slow-fall, {:ref "Magic p. 144", :prereqs [:apportation]}
;;    :splat, {:ref "Magic: Artillery Spells p. 16", :prereqs [[:talents/magery,4],:create-door]}
;;    :swim, {:ref "Magic p. 147", :prereqs [:shape-water,:levitation]}
;;    :transfer-pregnancy, {:ref "Bio-Tech p. 32", :prereqs [[:talents/magery,2],:remove-fetus]}
;;    :teleport, {:ref "Magic p. 147}; GURPS Fantasy p. 171", :prereqs [[:or #{:hawk-flight,[:attributes/int,15]}],:1-spell-from-10-colleges]}
;;    :teleport-other, {:ref "Magic p. 147", :prereqs [[:talents/magery,3],:teleport]}
;;    :trace-teleport, {:ref "Magic p. 84", :prereqs [:teleport,:timeport,:or-plane-shift]}
;;    :undo, {:ref "Magic p. 145", :prereqs [:locksmith]}
;;    :winged-knife, {:ref "Magic p. 145", :prereqs [:poltergeist]}
;;    :wizard-hand, {:ref "Magic p. 104", :prereqs [:manipulate,:far-feeling]}
;;    :affect-spirits, {:ref "Magic p. 151", :prereqs [:solidify]}
;;    :age, {:ref "Magic p. 154", :prereqs [[or,#{:youth,[6,:necromantic]}]]}
;;    :animate-shadow, {:ref "Magic p. 154", :prereqs [:skull-spirit,:shape-darkness]}
;;    :animation, {:ref "Magic p. 150", :prereqs [:summon-spirit]}
;;    :astral-block, {:ref "Magic p. 159", :prereqs [:summon-spirit,:repel-spirits]}
;;    :astral-vision, {:ref "Magic p. 105", :prereqs [:sense-spirit,:see-invisible]}
;;    :awaken-craft-spirit, {:ref "Magic p. 115", :prereqs [:inspired-creation,:sense-spirit]}
;;    :banish, {:ref "Magic p. 156", :prereqs [[:talents/magery,1],:1-spell-each-from-10-colleges]}
;;    :bind-spirit, {:ref "Magic p. 158", :prereqs [:comm,:spirit,:soul-jar]}
;;    :burning-death, {:ref "Magic p. 76", :prereqs [[:talents/magery,2],:heat,:sickness]}
;;    :command-spirit, {:ref "Magic p. 153", :prereqs [:summon-spirit,:turn-spirit]}
;;    :control-zombie, {:ref "Magic p. 152", :prereqs [:zombie]}
;;    :death-vision, {:ref "Basic Set p. 251}; GURPS Magic p. 149", :prereqs [[:talents/magery,1]]}
;;    :entrap-spirit, {:ref "Magic p. 157", :prereqs [[:talents/magery,1],:soul-jar,:turn-spirit]}
;;    :evisceration, {:ref "Magic p. 154", :prereqs [[:talents/magery,3],:apportation,:steal-vitality]}
;;    :final-rest, {:ref "Magic p. 89", :prereqs [[:or #{[:talents/magery/spirit-empat,y]}]]}
;;    :grasping-doom, {:ref "Magic Styles: Dungeon Magic p. 15", :prereqs [:mass-zombie]}
;;    :hellspawn, {:ref "Bio-Tech p. 32", :prereqs [:summon-demon]}
;;    :lich, {:ref "Magic p. 159", :prereqs [[:talents/magery,3],[:attributes/int,13],:enchant,:soul-jar,:zombie]}
;;    :mass-zombie, {:ref "Magic p. 153}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:zombie,:charisma-2]}
;;    :materialize, {:ref "Magic p. 150", :prereqs [:summon-spirit]}
;;    :pestilence, {:ref "Magic p. 154", :prereqs [[:talents/magery,1],:steal-vitality,:decay]}
;;    :plague-touch, {:ref "Magic: Artillery Spells p. 11", :prereqs [[:talents/magery,4],:deathtouch,:pestilence,:sense-foes]}
;;    :plant-zombie, {:ref "3/68: Natural Magic p. 10", :prereqs [:zombie,[4,:plant]]}
;;    :punishment-circle, {:ref "Magic: Artillery Spells p. 19", :prereqs [[:or #{[:talents/magery,3],:pentagram,:repel-spirits}]]}
;;    :repel-spirits, {:ref "Magic p. 158", :prereqs [:banish,:turn-spirit]}
;;    :resurrection, {:ref "Magic p. 94", :prereqs [:instant-regeneration,:summon-spirit]}
;;    :rotting-death, {:ref "Magic p. 154", :prereqs [[:talents/magery,2],:sickness,:pestilence]}
;;    :sense-spirit, {:ref "Basic Set p. 252}; GURPS Magic p. 149", :prereqs [:death-vision]}
;;    :skull-spirit, {:ref "Magic p. 151", :prereqs [[4,:necromantic]]}
;;    :slow-healing, {:ref "Magic p. 153", :prereqs [[:talents/magery,1],:frailty,:steal-vitality]}
;;    :solidify, {:ref "Magic p. 151", :prereqs [:materialize]}
;;    :soul-jar, {:ref "Magic p. 154", :prereqs [[:talents/magery,1],[6,:necromantic],:steal-vitality]}
;;    :soul-prison, {:ref "Magic: Death Spells p. 18 and GURPS Magic Styles: Dungeon Magic p. 16", :prereqs [[:talents/magery,3],:banish,:soul-jar-magery-3,:banish,:soul-jar,:any-4-of-animate-shadow,:possession,:repel-spirits,:divination-dactylomancy,:mass-zombie,:summon-demon,:pentagram,:summon-earth-elemental,:phase-other,:or-zombie-summoning]}
;;    :spirit-incursion, {:ref "Magic: Artillery Spells p. 22", :prereqs [[:talents/magery,4],[10,:necromantic],:skull-spirit]}
;;    :steal-attribute, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:varies]}
;;    :steal-might, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:debility]}
;;    :steal-dexterity, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:clumsiness]}
;;    :steal-wisdom, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:foolishness]}
;;    :steal-vigor, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-energy,:frailty]}
;;    :steal-beauty, {:ref "Magic p. 159", :prereqs [[:talents/magery,3],:alter-visage,:steal-vitality]}
;;    :steal-energy, {:ref "Magic p. 150", :prereqs [:minor-healing]}
;;    :steal-skill, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:borrow-skill,:daze]}
;;    :steal-vitality, {:ref "Magic p. 150", :prereqs [:steal-energy]}
;;    :steal-youth, {:ref "Magic p. 158", :prereqs [:youth,:age,:steal-vitality]}
;;    :stop-healing, {:ref "Magic p. 153", :prereqs [:slow-healing]}
;;    :strike-barren, {:ref "Magic p. 41", :prereqs [[:talents/magery,1],:steal-vitality,:decay]}
;;    :suicide, {:ref "Magic: Death Spells p. 19", :prereqs [[:talents/magery,1]]}
;;    :summon-demon, {:ref "Basic Set p. 252}; GURPS Magic p. 155", :prereqs [[:talents/magery,1],:1-spell-from-10-colleges]}
;;    :summon-spirit, {:ref "Basic Set p. 252}; GURPS Magic p. 150", :prereqs [[:talents/magery,2],:death-vision]}
;;    :turn-spirit, {:ref "Magic p. 151", :prereqs [:fear,:sense-spirit]}
;;    :turn-zombie, {:ref "Basic Set p. 252}; GURPS Magic p. 152", :prereqs [:zombie]}
;;    :weaken-blood, {:ref "Magic p. 40", :prereqs [[:or #{:sickness,:steal-vitality}]]}
;;    :wraith, {:ref "Magic p. 160", :prereqs [[:talents/magery,3],[:attributes/int,13],:enchant,:halt-aging,:soul-jar]}
;;    :zombify, {:ref "Magic: Death Spells p. 18", :prereqs [[:talents/magery,3],:pestilence,:zombie]}
;;    :zombie, {:ref "Basic Set p. 252}; GURPS Magic p. 151; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:summon-spirit,:lend-vitality]}
;;    :zombie-summoning, {:ref "Magic p. 153", :prereqs [:zombie]}
;;    :steal-might, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:debility]}
;;    :steal-dexterity, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:clumsiness]}
;;    :steal-wisdom, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-vitality,:foolishness]}
;;    :steal-vigor, {:ref "Magic p. 158", :prereqs [[:talents/magery,3],:steal-energy,:frailty]}
;;    :animate-plant, {:ref "Magic p. 164", :prereqs [[:7,:plant]]}
;;    :arboreal-immurement, {:ref "Magic p. 165", :prereqs [[:talents/magery,2],:walk-through-wood]}
;;    :blade-of-grass, {:ref "Magic: Plant Spells p. 10", :prereqs [:shape-plant]}
;;    :bless-plants, {:ref "Magic p. 161}; GURPS Fantasy p. 172", :prereqs [:heal-plant]}
;;    :blight, {:ref "Magic p. 162", :prereqs [:plant-growth]}
;;    :bloodsucking-branches, {:ref "Magic: Plant Spells p. 11", :prereqs [[:talents/magery,1],[6,:plant],:weaken-blood]}
;;    :blossom, {:ref "Magic p. 162", :prereqs [:plant-growth]}
;;    :body-of-leaves, {:ref "Magic: Plant Spells p. 11", :prereqs [:body-of-slime,:plant-form-other]}
;;    :body-of-slime, {:ref "Magic p. 165", :prereqs [[:talents/magery,2],:plant-form,:shape-water]}
;;    :body-of-wood, {:ref "Magic p. 165", :prereqs [[:talents/magery,2],:plant-form]}
;;    :breakfall-plants, {:ref "Magic p. 144 Slow Fall}; GURPS Magic: Plant Spells p. 13", :prereqs [[:talents/magery,1],:apportation,:walk-through-plants]}
;;    :buoyant-plant-life, {:ref "Magic: Plant Spells p. 11", :prereqs [[:talents/magery,1],:identify-plant]}
;;    :capturing-vines, {:ref "Magic: Plant Spells p. 12", :prereqs [:grasping-branch]}
;;    :change-species, {:ref "Magic: Plant Spells p. 12", :prereqs [[:talents/magery,2],:reverse-plant-growth]}
;;    :conceal, {:ref "Magic p. 162", :prereqs [:plant-growth]}
;;    :create-paper, {:ref "Magic: Plant Spells p. 12", :prereqs [[:talents/magery,2],:heal-plant]}
;;    :create-plant, {:ref "Magic p. 163", :prereqs [[:talents/magery,1],:plant-growth]}
;;    :devils-dust, {:ref "Magic: Artillery Spells p. 23", :prereqs [[:talents/magery,4],:10-plant,:pollen-cloud]}
;;    :druids-panacea, {:ref "Magic: Plant Spells p. 12", :prereqs [[:talents/magery,3],:body-of-wood,:plant-empathy]}
;;    :essential-paper, {:ref "3/48: Secret Magic p. 21", :prereqs []}
;;    :essential-wood, {:ref "Magic p. 164", :prereqs [[6,:plant]]}
;;    :exploding-vegetable, {:ref "Magic p. 118 Explode}; GURPS Magic: Plant Spells p. 13", :prereqs [:shape-plant]}
;;    :false-tracks, {:ref "Magic p. 163", :prereqs [:shape-plant,:shape-earth]}
;;    :fast-plant-growth, {:ref "Magic: Plant Spells p. 12", :prereqs [[:talents/magery,1],:plant-growth]}
;;    :fling-fruit, {:ref "Magic p. 144 Poltergeist}; GURPS Magic: Plant Spells p. 13", :prereqs [[:talents/magery,1],:apportation,:shape-plant]}
;;    :forest-defense, {:ref "Magic: Plant Spells p. 13", :prereqs [:animate-plant]}
;;    :forest-warning, {:ref "Magic p. 162", :prereqs [[:or #{:sense-danger,[4,:plant]}]]}
;;    :gather-moss, {:ref "Magic: Plant Spells p. 13", :prereqs [:fast-plant-growth,:hair-growth]}
;;    :grant-plant-intelligence, {:ref "Magic p. 135 Wisdom}; GURPS Magic: Plant Spells p. 13", :prereqs [[:talents/magery,2],:plant-speech]}
;;    :grasping-branch, {:ref "Magic: Plant Spells p. 14", :prereqs [[:talents/magery,2],:animate-plant]}
;;    :green-death, {:ref "Magic: Plant Spells p. 14", :prereqs [[:talents/magery,2],:create-plant,:sickness]}
;;    :green-telurgy, {:ref "Magic: Plant Spells p. 14", :prereqs [:plant-speech]}
;;    :harvest, {:ref "Magic: Plant Spells p. 14", :prereqs [[:talents/magery,1],:apportation,:identify-plant,:measurement]}
;;    :heal-plant, {:ref "Magic p. 161}; GURPS Fantasy p. 171", :prereqs [:identify-plant]}
;;    :hide-path, {:ref "Magic p. 162", :prereqs [:heal-plant]}
;;    :hypnotic-leaves, {:ref "Magic: Plant Spells p. 15", :prereqs [[:talents/magery,1],:daze,:plant-sense]}
;;    :identify-plant, {:ref "Magic p. 161}; GURPS Fantasy p. 171", :prereqs [:seek-plant]}
;;    :improved-firewood, {:ref "Magic: Plant Spells p. 15", :prereqs [:identify-plant]}
;;    :invoke-fence, {:ref "Magic: Plant Spells p. 15", :prereqs [[:talents/magery,2],:heal-plant]}
;;    :ironweed, {:ref "Magic: Artillery Spells p. 23", :prereqs [[:talents/magery,1],:essential-wood,:plant-growth]}
;;    :join-plants, {:ref "Magic: Plant Spells p. 15", :prereqs [:shape-plant]}
;;    :miniaturize-plant, {:ref "Magic: Plant Spells p. 16", :prereqs [[:talents/magery,2],:reverse-plant-growth]}
;;    :murder-blossom, {:ref "Magic: Death Spells p. 19", :prereqs [[:talents/magery,3],:create-plant,:pollen-cloud]}
;;    :plant-control, {:ref "Magic p. 164", :prereqs [:plant-sense]}
;;    :plant-form, {:ref "Magic p. 164", :prereqs [[:talents/magery,1],:6-plant]}
;;    :plant-form-other, {:ref "Magic p. 165", :prereqs [[:talents/magery,2],:plant-form]}
;;    :plant-growth, {:ref "Magic p. 162", :prereqs [:heal-plant]}
;;    :plant-to-object, {:ref "Magic: Plant Spells p. 16", :prereqs [[:talents/magery,1],:shape-plants]}
;;    :plant-sense, {:ref "Magic p. 163", :prereqs [:forest-warning,:hide-path]}
;;    :plant-speech, {:ref "Magic p. 164", :prereqs [:identify-sense]}
;;    :plant-vision, {:ref "Magic p. 162", :prereqs [:shape-plant]}
;;    :plant-zombie, {:ref "3/68: Natural Magic p. 10", :prereqs [:zombie,[4,:plant]]}
;;    :poison-thorns, {:ref "3/68: Natural Magic p. 10", :prereqs [[:talents/magery,1],:6-plant]}
;;    :pollen-cloud, {:ref "Magic p. 162", :prereqs [:shape-plant]}
;;    :process-plant, {:ref "Magic: Plant Spells p. 16", :prereqs [[:talents/magery,2],:distill,:heal-plant]}
;;    :purify-earth, {:ref "Magic p. 54", :prereqs [:create-earth,:plant-growth]}
;;    :rain-of-nuts, {:ref "Magic p. 165", :prereqs [[:talents/magery,1],:6-plant,:shape-plant]}
;;    :rain-of-thorns, {:ref "3/68: Natural Magic p. 10", :prereqs [:poison-thorns]}
;;    :razor-grass, {:ref "Magic: Plant Spells p. 16", :prereqs [[:talents/magery,1],:essential-wood,:plant-growth]}
;;    :rejuvenate-plant, {:ref "Magic p. 163", :prereqs [[:talents/magery,1],:plant-growth]}
;;    :resilient-vegetation, {:ref "Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:shape-plant]}
;;    :reverse-plant-growth, {:ref "Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:plant-growth]}
;;    :run-across-treetops, {:ref "Magic: Plant Spells p. 17", :prereqs [:breakfall-plants,:levitation]}
;;    :searching-roots, {:ref "Magic: Plant Spells p. 18", :prereqs [[:talents/magery,2],:animate-plant]}
;;    :see-plant-health, {:ref "Magic: Plant Spells p. 19", :prereqs []}
;;    :seek-plant, {:ref "Magic p. 161}; GURPS Fantasy p. 171", :prereqs []}
;;    :shape-plant, {:ref "Magic p. 161", :prereqs [:identify-plant]}
;;    :shuriken-leaf, {:ref "Magic: Plant Spells p. 19", :prereqs [[:talents/magery,1],:blade-of-grass]}
;;    :slimy-skin, {:ref "Magic: Plant Spells p. 19", :prereqs [:shape-water,:wooden-arm]}
;;    :spying-blossom, {:ref "Magic: Plant Spells p. 19", :prereqs [:plant-sense]}
;;    :summon-dryad, {:ref "Magic pp. 27-28 Summon Air Elemental}; GURPS Magic: Plant Spells p. 13", :prereqs [[:talents/magery,1],:sense-spirit,:7-plant]}
;;    :swamp-rot, {:ref "Magic: Death Spells p. 19", :prereqs [[:talents/magery,3],:body-of-slime]}
;;    :tangle-growth, {:ref "Magic p. 162", :prereqs [:plant-growth]}
;;    :toxic-plant, {:ref "Magic: Plant Spells p. 19", :prereqs [[:talents/magery,1],:plant-growth,:sickness]}
;;    :trapped-light, {:ref "Magic: Plant Spells p. 20", :prereqs [:flash,:plant-growth]}
;;    :tree-bark-armor, {:ref "Magic: Plant Spells p. 20", :prereqs [[:talents/magery,1],:essential-wood,:shape-plant]}
;;    :treetop-blink, {:ref "Magic: Plant Spells p. 20", :prereqs [[:talents/magery,2],:forest-defense,:run-across-treetops]}
;;    :undergrowth-ambush, {:ref "Magic: Plant Spells p. 21", :prereqs [:searching-roots]}
;;    :vine-to-snake, {:ref "Magic pp. 98-99 Create Animal}; GURPS Magic: Plant Spells p. 13", :prereqs [[:talents/magery,2],:create-plant]}
;;    :walk-through-plants, {:ref "Magic p. 163", :prereqs [:hide-path,:shape-plant]}
;;    :walk-through-wood, {:ref "Magic p. 164", :prereqs [:walk-through-plants]}
;;    :wither-plant, {:ref "Magic p. 163", :prereqs [:blight]}
;;    :wooden-arm, {:ref "Magic: Plant Spells p. 21", :prereqs [[:talents/magery,1],:6-plant]}
;;    :woodfall, {:ref "Magic: Plant Spells p. 21", :prereqs [:rain-of-nuts]}
;;    :wood-golem, {:ref "Magic p. 59 Golem}; GURPS Magic: Plant Spells p. 13", :prereqs [:animation,:enchant,:shape-plant]}
;;    :animate-fungus, {:ref "Magic p. 164 Animate Plant}; GURPS Magic: Plant Spells p. 17", :prereqs [:fungus-control]}
;;    :bless-fungus, {:ref "Magic p. 161 Bless Plants}; GURPS Magic: Plant Spells p. 17", :prereqs [:heal-fungus]}
;;    :blight, {:ref "Magic p. 162}; GURPS Magic: Plant Spells p. 17", :prereqs [:fungus-growth]}
;;    :body-of-fungus, {:ref "Magic p. 165 Body of Wood}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,2],:fungus-form]}
;;    :body-of-slime, {:ref "Magic p. 165}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,2],:fungus-form]}
;;    :choke, {:ref "Magic p. 40}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:spore-cloud]}
;;    :create-fungus, {:ref "Magic p. 163 Create Plant}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:fungus-growth]}
;;    :cure-disease, {:ref "Magic p. 91}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,3],:identify-fungus]}
;;    :decay, {:ref "Magic p. 77}; GURPS Magic: Plant Spells p. 17 Fungus Growth", :prereqs [:fungus-growth]}
;;    :foul-water, {:ref "Magic p. 185}; GURPS Magic: Plant Spells p. 17", :prereqs [:decay]}
;;    :fungus-control, {:ref "Magic p. 164 Plant Control}; GURPS Magic: Plant Spells p. 17", :prereqs [[6,:fungus]]}
;;    :fungus-form, {:ref "Magic p. 164 Plant Form}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:6-fungus]}
;;    :fungus-form-other, {:ref "Magic p. 165 Plant Form Other}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,2],:fungus-form]}
;;    :fungus-growth, {:ref "Magic p. 162 Plant Growth}; GURPS Magic: Plant Spells p. 17", :prereqs [:heal-fungus]}
;;    :fungus-speech, {:ref "Magic p. 164 Plant Speech}; GURPS Magic: Plant Spells p. 17", :prereqs [:identify-fungus]}
;;    :heal-fungus, {:ref "Magic p. 161 Heal Plant}; GURPS Magic: Plant Spells p. 17", :prereqs [:identify-fungus]}
;;    :identify-fungus, {:ref "Magic p. 161 Identify Plant}; GURPS Magic: Plant Spells p. 17", :prereqs [:seek-fungus]}
;;    :instant-neutralize-poison, {:ref "Magic p. 92}; GURPS Magic: Plant Spells p. 17", :prereqs [:neutralize-poison]}
;;    :itch, {:ref "Magic p. 35}; GURPS Magic: Plant Spells p. 17", :prereqs [:fungus-growth]}
;;    :mature, {:ref "Magic p. 78}; GURPS Magic: Plant Spells p. 17", :prereqs [:decay]}
;;    :neutralize-poison, {:ref "Magic p. 92}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,3],:identify-fungus]}
;;    :pestilence, {:ref "Magic p. 154}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:sickness]}
;;    :poison-food, {:ref "Magic p. 78}; GURPS Magic: Plant Spells p. 17", :prereqs [:decay]}
;;    :rotting-death, {:ref "Magic p. 154}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,2],:pestilence]}
;;    :ruin, {:ref "Magic p. 118}; GURPS Magic: Plant Spells p. 17", :prereqs [[:talents/magery,1],:decay]}
;;    :seek-fungus, {:ref "Magic p. 161 Seek Plant}; GURPS Magic: Plant Spells p. 17", :prereqs []}
;;    :shape-fungus, {:ref "Magic p. 161 Shape Plant}; GURPS Magic: Plant Spells p. 17", :prereqs [:identify-fungus]}
;;    :sickness, {:ref "Magic p. 138}; GURPS Magic: Plant Spells p. 17", :prereqs [:itch]}
;;    :spore-cloud, {:ref "Magic p. 162 Pollen Cloud}; GURPS Magic: Plant Spells p. 17", :prereqs [:fungus-growth]}
;;    :wither-plant, {:ref "Magic p. 163}; GURPS Magic: Plant Spells p. 17", :prereqs [:blight]}
;;    :armor, {:ref "Basic Set p. 253}; GURPS Magic p. 167", :prereqs [[:talents/magery,2],:shield]}
;;    :atmosphere-dome, {:ref "Magic p. 169", :prereqs [:purify-air,:weather-dome]}
;;    :black-sphere, {:ref "Magic: Death Spells p. 20", :prereqs [[:talents/magery,3],:utter-dome]}
;;    :bladeturning, {:ref "Magic p. 168", :prereqs [[:or #{:shield,:turn-blade}]]}
;;    :block, {:ref "Magic p. 166", :prereqs [[:talents/magery,1]]}
;;    :book-binding, {:ref "3/48: Secret Magic p. 20", :prereqs []}
;;    :catch-missile, {:ref "Magic p. 168", :prereqs [:deflect-missile]}
;;    :coolness, {:ref "Magic p. 187", :prereqs [:cold]}
;;    :deflect-missile, {:ref "Basic Set p. 251}; GURPS Magic p. 143", :prereqs [:apportation]}
;;    :detect-poison, {:ref "Magic p. 166", :prereqs [[:or #{:sense-danger,:test-food}]]}
;;    :diminishing-dome, {:ref "Magic: Artillery Spells p. 24", :prereqs [[:talents/magery,4],:force-dome]}
;;    :force-ball, {:ref "Magic: Artillery Spells p. 24", :prereqs [[:talents/magery,4],:catch-spell,:force-dome,:sense-foes]}
;;    :force-dome, {:ref "Magic p. 170", :prereqs [[:talents/magery,1],:weather-dome,:apportation]}
;;    :force-wall, {:ref "Magic p. 170", :prereqs [:force-dome]}
;;    :force-guillotine, {:ref "Magic: Death Spells p. 20", :prereqs [[:talents/magery,3],:force-wall]}
;;    :freedom, {:ref "Magic p. 148", :prereqs [[3,:body-control],[3,:movement],3-protection,:warning]}
;;    :great-deflect-missile, {:ref "3/4: Magic on the Battlefield p. 9", :prereqs [[:talents/magery,2],:deflect-missile]}
;;    :hardiness, {:ref "Magic p. 167", :prereqs [:block]}
;;    :iron-arm, {:ref "Magic p. 169", :prereqs [:resist-pain,:dx-11]}
;;    :magelock, {:ref "Basic Set p. 253}; GURPS Magic p. 166", :prereqs [[:talents/magery,1]]}
;;    :mass-coolness, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [[:attributes/int,12],:coolness]}
;;    :mass-resist-acid, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-acid]}
;;    :mass-resist-disease, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-disease]}
;;    :mass-resist-lightning, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-lightning]}
;;    :mass-resist-poison, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-poison]}
;;    :mass-shade, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [[:attributes/int,12],:shade]}
;;    :missile-shield, {:ref "Magic p. 168}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [[:or #{:apportation,:shield}]]}
;;    :mystic-mist, {:ref "Magic p. 168", :prereqs [[:or #{[:talents/magery,1],:watchdog,:shield}]]}
;;    :nightingale, {:ref "Magic p. 167", :prereqs [:sense-danger]}
;;    :protect-animal, {:ref "Magic p. 32", :prereqs [:armor,:watchdog,:animal]}
;;    :reflect-gaze, {:ref "Magic p. 168", :prereqs [:mirror]}
;;    :resist-acid, {:ref "Magic p. 190", :prereqs [:create-acid]}
;;    :resist-disease, {:ref "Magic p. 90", :prereqs [[:or #{:remove-contagion,:vigor}]]}
;;    :resist-lightning, {:ref "Magic p. 196", :prereqs [[6,:air]]}
;;    :resist-poison, {:ref "Magic p. 91", :prereqs [:vigor]}
;;    :resist-pressure, {:ref "Magic p. 169", :prereqs [:weather-dome]}
;;    :resist-radiation, {:ref "Magic p. 182", :prereqs [[3,:radiation]]}
;;    :resist-sound, {:ref "Magic p. 173", :prereqs [[4,:sound]]}
;;    :resist-water, {:ref "Magic p. 186", :prereqs [:umbrella,:or-shape-water,:destroy-water]}
;;    :return-missile, {:ref "Magic p. 168", :prereqs [:catch-missile]}
;;    :reverse-missiles, {:ref "Magic p. 168}; Pyramid 3/60: Dungeon Fantasy III p. 5", :prereqs [[:or #{:missile-shield,:force-dome}]]}
;;    :sense-danger, {:ref "Magic p. 166", :prereqs [[:or #{:sense-foes,:danger-sense}]]}
;;    :sense-observation, {:ref "Magic p. 167", :prereqs [[:or #{:sense-danger,:scryguard}]]}
;;    :shade, {:ref "Magic p. 169", :prereqs [[:or #{:continual-light,:shield}]]}
;;    :shield, {:ref "Basic Set p. 252}; GURPS Magic p. 167", :prereqs [[:talents/magery,2]]}
;;    :warmth, {:ref "Magic p. 74", :prereqs [:heat]}
;;    :watchdog, {:ref "Magic p. 167}; GURPS Thaumatology: Urban Magics p. 33", :prereqs [:sense-danger]}
;;    :weather-dome, {:ref "Magic p. 169", :prereqs [[2,:1-from-4-elements]]}
;;    :teleport-shield, {:ref "Magic p. 170", :prereqs [[:or #{:watchdog,:spell-shield,:teleport}]]}
;;    :turn-blade, {:ref "Magic p. 167", :prereqs [[:or #{:apportation,:spasm}]]}
;;    :umbrella, {:ref "Magic p. 185", :prereqs [[:or #{:shape-water,:shield}]]}
;;    :utter-dome, {:ref "Magic p. 170", :prereqs [[:talents/magery,2],:force-dome,:spell-shield]}
;;    :utter-wall, {:ref "Magic p. 170", :prereqs [:utter-dome,:spell-wall]}
;;    :alter-voice, {:ref "Magic p. 41", :prereqs [[4,:body-control--and-4-sound]]}
;;    :concussion, {:ref "Magic p. 26", :prereqs [:shape-air,:thunderclap]}
;;    :converse, {:ref "Magic p. 173", :prereqs [[:talents/magery,1],:garble,:silence]}
;;    :delayed-message, {:ref "Magic p. 173", :prereqs [[:talents/magery,1],:voices,:sense-life]}
;;    :disrupt, {:ref "Magic Styles: Dungeon Magic p. 23", :prereqs [[:talents/magery,2],:concussion,:sound-jet]}
;;    :echoes-of-the-past, {:ref "Magic p. 107", :prereqs [[:talents/magery,2],:history,:voices]}
;;    :far-hearing, {:ref "Magic p. 173", :prereqs [[:talents/magery,1],[4,:sound]]}
;;    :garble, {:ref "Magic p. 172", :prereqs [:voices]}
;;    :great-voice, {:ref "Magic p. 173", :prereqs [:voices,:thunderclap]}
;;    :hush, {:ref "Magic p. 172", :prereqs [:silence]}
;;    :imitiate-voice, {:ref "Magic p. 172", :prereqs [:voices]}
;;    :improved-concussion, {:ref "Magic: Artillery Spells p. 25", :prereqs [[:talents/magery,4],[7,:sound],:concussion,:great-voice]}
;;    :invisible-wizard-ear, {:ref "Magic p. 174", :prereqs [:wizard-ear,:invisibility]}
;;    :ley-speech, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:seek-ley-line,:voices]}
;;    :fatal-frequency, {:ref "Magic: Death Spells p. 20", :prereqs [[:talents/magery,3],:concussion,:sound-jet]}
;;    :keen-hearing, {:ref "Magic p. 133", :prereqs []}
;;    :mage-stealth, {:ref "Magic p. 172", :prereqs [:hush]}
;;    :message, {:ref "Magic p. 173", :prereqs [:great-voice,:seeker]}
;;    :musical-scribe, {:ref "Magic p. 174", :prereqs [:scribe]}
;;    :noise, {:ref "Magic p. 173", :prereqs [:wall-of-silence]}
;;    :perilous-pulsations, {:ref "Magic: Artillery Spells p. 25", :prereqs [[:talents/magery,4],[7,:sound],:concussion,:sound-jet]}
;;    :resist-sound, {:ref "Magic p. 173", :prereqs [[4,:sound]]}
;;    :scribe, {:ref "Magic p. 174", :prereqs [:voices,:dancing-object,:1-written-language-at-accented-better]}
;;    :silence, {:ref "Magic p. 171}; GURPS Fantasy p. 172", :prereqs [:sound]}
;;    :silver-tongue, {:ref "Magic p. 174", :prereqs [:voices,:emotion-control]}
;;    :sound, {:ref "Magic p. 171}; GURPS Fantasy p. 172", :prereqs []}
;;    :sound-jet, {:ref "Magic p. 173", :prereqs [:great-voice]}
;;    :sound-vision, {:ref "Magic p. 171", :prereqs [[:or #{:keen-hearing,:acute-hearing}]]}
;;    :thunderclap, {:ref "Magic p. 171", :prereqs [:sound]}
;;    :voices, {:ref "Magic p. 172", :prereqs [:sound]}
;;    :wail-of-the-banshee, {:ref "Magic: Death Spells p. 20", :prereqs [[:talents/magery,3],[10,:sound],:message]}
;;    :wall-of-silence, {:ref "Magic p. 172", :prereqs [:silence]}
;;    :withering-wall, {:ref "Magic: Artillery Spells p. 25", :prereqs [[:talents/magery,4],[10,:sound],:great-voice,:noise]}
;;    :wizard-ear, {:ref "Magic p. 174", :prereqs [:apportation,:far-hearing,:sound-vision]}
;;    :wizard-mouth, {:ref "Magic p. 104", :prereqs [:apportation,:far-tasting,:great-voice]}
;;    ;;:awaken-building, {:ref "Thaumatology: Urban Magics p. 33", :prereqs [:animation,:5-from-a-college-appropriate-to-its-main-material]}
;;    :awaken-computer, {:ref "Magic p. 178", :prereqs [:animation,:wisdom]}
;;    :animate-machine, {:ref "Magic p. 177", :prereqs [[:or #{:machine-control,:animation,:animate-object}]]}
;;    :essential-paper, {:ref "3/48: Secret Magic p. 21", :prereqs []}
;;    :glitch, {:ref "Magic p. 178", :prereqs [:machine-control]}
;;    :ley-vehicle, {:ref "Thaumatology: Urban Magics p. 19", :prereqs [:ley-float,:ley-running]}
;;    :machine-control, {:ref "Magic p. 176", :prereqs [:reveal-function,:locksmith,:lightning]}
;;    :machine-possession, {:ref "Magic p. 178", :prereqs [[:or #{:machine-control,:rider-within,:soul-rider}]]}
;;    :machine-speech, {:ref "Magic p. 176", :prereqs [:machine-summoning]}
;;    :machine-summoning, {:ref "Magic p. 176", :prereqs [:machine-control]}
;;    :malfunction, {:ref "Magic p. 177", :prereqs [[:talents/magery,2],:glitch]}
;;    :permanent-machine-possession, {:ref "Magic p. 178", :prereqs [[:talents/magery,3],:machine-possession]}
;;    :rebuild, {:ref "Magic p. 177", :prereqs [[:talents/magery,3],:repair,:create-object,3-of-each-element]}
;;    :reckless-reconstitution, {:ref "Magic: Death Spells p. 21", :prereqs [:rebuild]}
;;    :reveal-function, {:ref "Magic p. 176", :prereqs [:seek-machine]}
;;    :schematic, {:ref "Magic p. 177", :prereqs [:reveal-function,:history]}
;;    :seek-machine, {:ref "Magic p. 175", :prereqs []}
;;    :sense-nano, {:ref "Bio-Tech p. 32", :prereqs [:sense-disease,[:attributes/int,15],:or-seek-machine,:small-vision]}
;;    :sequence-dna, {:ref "Bio-Tech p. 32", :prereqs [[:or #{[:talents/magery,2],:divination-genomancy,:analyze-heredity}]]}
;;    :alter-nanovirus, {:ref "Bio-Tech p. 30", :prereqs [:sense-nano,:manipulate-dna]}
;;    :conduct-power, {:ref "Magic p. 180", :prereqs [[:talents/magery,1],:seek-power]}
;;    :create-fuel, {:ref "Magic p. 179", :prereqs [:seek-fuel,[2,:transmutation]]}
;;    :death-ray, {:ref "Magic: Artillery Spells p. 26", :prereqs [[:talents/magery,4],:lightning,:radiation-jet]}
;;    :draw-power, {:ref "Magic p. 180", :prereqs [:steal-power,2-from-10-different-colleges]}
;;    :essential-fuel, {:ref "Magic p. 179", :prereqs [[6,:energy]]}
;;    :lend-power, {:ref "Magic p. 180", :prereqs [[:talents/magery,2],:seek-power]}
;;    :magnetic-vision, {:ref "Magic p. 181", :prereqs [:keen-vision]}
;;    :minor-conduct-power, {:ref "Thaumatology: Urban Magics p. 26", :prereqs [:seek-power]}
;;    :minor-draw-power, {:ref "Thaumatology: Urban Magics p. 26", :prereqs [:minor-conduct-power,:1-spell-from-10-different-colleges]}
;;    :preserve-fuel, {:ref "Magic p. 179", :prereqs [:test-fuel]}
;;    :propel, {:ref "Magic p. 180", :prereqs [:create-fuel,:dancing-object]}
;;    :purify-fuel, {:ref "Magic p. 179", :prereqs [[:or #{:purify-water,:decay}]]}
;;    :radio-hearing, {:ref "Magic p. 181", :prereqs [:keen-hearing]}
;;    :seek-fuel, {:ref "Magic p. 179", :prereqs []}
;;    :seek-power, {:ref "Magic p. 179", :prereqs []}
;;    :spectrum-vision, {:ref "Magic p. 181", :prereqs [:infravision]}
;;    :steal-power, {:ref "Magic p. 180", :prereqs [[:talents/magery,2],:minor-healing,:conduct-power]}
;;    :stop-power, {:ref "Magic p. 179", :prereqs []}
;;    :stop-impulse, {:ref "Magic: Death Spells p. 21", :prereqs [[:talents/magery,3],:stop-power,:total-paralysis]}
;;    :test-fuel, {:ref "Magic p. 179", :prereqs []}
;;    :breathe-radiation, {:ref "Magic p. 182", :prereqs [[:talents/magery,2],:radiation-jet]}
;;    :cure-radiation, {:ref "Magic p. 182", :prereqs [:resist-radiation,:major-healing]}
;;    :extinguish-radiation, {:ref "Magic p. 181", :prereqs [[:talents/magery,2],:extinguish-fire,:earth-to-air,:irradiate]}
;;    :flammability, {:ref "Magic: Artillery Spells p. 26", :prereqs [[:talents/magery,3],:essential-fuel,:purify-fuel]}
;;    :irradiate, {:ref "Magic p. 181", :prereqs [[2,:earth] [2,:fire]]}
;;    :manipulate-dna, {:ref "Bio-Tech p. 32", :prereqs [:sequence-dna,:apportation,:or-create-chimera]}
;;    :mass-resist-radiation, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-radiation]}
;;    :radiation-jet, {:ref "Magic p. 182", :prereqs [:irradiate,:resist-radiation]}
;;    :resist-radiation, {:ref "Magic p. 182", :prereqs [[3,:radiation]]}
;;    :see-radiation, {:ref "Magic p. 181", :prereqs []}
;;    :seek-radiation, {:ref "Magic p. 181", :prereqs []}
;;    :alloy-metal, {:ref "3/91: Thaumatology IV p. 22", :prereqs [[:talents/magery,1],:shape-metal]}
;;    :anvil-strike, {:ref "3/91: Thaumatology IV p. 23", :prereqs [[:talents/magery,3],:rain-of-shards,:teleport]}
;;    :arrow, {:ref "3/91: Thaumatology IV p. 23", :prereqs [:create-metal]}
;;    :bloody-iron, {:ref "3/91: Thaumatology IV p. 23", :prereqs [:move-metal]}
;;    :blunderbuss, {:ref "3/91: Thaumatology IV p. 23", :prereqs [:arrow]}
;;    :body-of-metal, {:ref "Magic p. 183", :prereqs [[:talents/magery,2],:shape-metal]}
;;    :body-of-plastic, {:ref "Magic p. 183", :prereqs [[:talents/magery,2],:shape-plastic]}
;;    :celestial-shotgun, {:ref "3/91: Thaumatology IV p. 24", :prereqs [[:talents/magery,2],:blunderbuss]}
;;    :conjure-shield, {:ref "3/91: Thaumatology IV p. 24", :prereqs [:create-metal]}
;;    :control-metal-elemental, {:ref "3/91: Thaumatology IV p. 27", :prereqs [:summon-metal-elemental]}
;;    :create-metal, {:ref "3/91: Thaumatology IV p. 24", :prereqs [:earth-to-stone]}
;;    :create-metal-elemental, {:ref "3/91: Thaumatology IV p. 27", :prereqs [[:talents/magery,2],:control-metal-elemental]}
;;    :essential-metal, {:ref "3/91: Thaumatology IV p. 24", :prereqs [[6, :metal]]}
;;    :flesh-to-metal, {:ref "3/91: Thaumatology IV p. 25", :prereqs [[:talents/magery,2],:create-metal]}
;;    :identify-metal, {:ref "Magic p. 182", :prereqs []}
;;    :identify-metal-variant, {:ref "3/91: Thaumatology IV p. 25", :prereqs [:seek-metal]}
;;    :identify-plastic, {:ref "Magic p. 182", :prereqs [:seek-plastic]}
;;    :metal-to-flesh, {:ref "3/91: Thaumatology IV p. 25", :prereqs [:flesh-to-metal]}
;;    :flesh-to-stone, {:ref "3/91: Thaumatology IV p. 25", :prereqs [[:or #{:stone-to-metal,[4,:metal]}]]}
;;    :metal-vision, {:ref "Magic p. 183", :prereqs [:shape-metal]}
;;    :move-metal, {:ref "3/91: Thaumatology IV p. 25", :prereqs [:shape-metal]}
;;    :plastic-vision, {:ref "Magic p. 183", :prereqs [:shape-plastic]}
;;    :purify-metal, {:ref "3/91: Thaumatology IV p. 26", :prereqs [:restore-metal]}
;;    :rain-of-shards, {:ref "3/91: Thaumatology IV p. 26", :prereqs [:celestial-shotgun]}
;;    :restore-metal, {:ref "3/91: Thaumatology IV p. 26", :prereqs [:rust]}
;;    :rust, {:ref "3/91: Thaumatology IV p. 27", :prereqs [[:talents/magery,1],:create-metal]}
;;    :seek-metal, {:ref "3/91: Thaumatology IV p. 27", :prereqs []}
;;    :seek-plastic, {:ref "Magic p. 182", :prereqs []}
;;    :shape-metal, {:ref "Magic p. 182", :prereqs [[:or #{[:talents/magery,1],:shape-plant,[6 :tech]}]]}
;;    :sharpen-blade, {:ref "3/91: Thaumatology IV p. 27", :prereqs [:shape-metal]}
;;    :smelt-ore, {:ref "3/91: Thaumatology IV p. 27", :prereqs [:shape-metal,:shape-earth]}
;;    :stone-to-metal, {:ref "3/91: Thaumatology IV p. 27", :prereqs [[:talents/magery,2],:shape-metal]}
;;    :summon-metal-elemental, {:ref "3/91: Thaumatology IV p. 27", :prereqs [[:or #{[:talents/magery,1],[8, :metal],[4, :metal],:another-summon-elemental-spell}]]}
;;    :transmute-metal, {:ref "3/91: Thaumatology IV p. 28", :prereqs [:create-metal,:alloy-metal]}
;;    :walk-through-metal, {:ref "3/91: Thaumatology IV p. 28", :prereqs [[4, :metal]]}
;;    :acid-ball, {:ref "Magic p. 191", :prereqs [[:talents/magery,2],:create-acid]}
;;    :acid-jet, {:ref "Magic p. 192", :prereqs [[:talents/magery,2],:water-jet,:create-acid]}
;;    :alkahest-jet, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-acid,:acid-jet]}
;;    :alkahest-sphere, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-acid,:acid-ball]}
;;    :arctic-blast, {:ref "Magic: Artillery Spells p. 27", :prereqs [[:talents/magery,4],:frostbite,:icy-breath]}
;;    :boil-water, {:ref "Magic p. 192", :prereqs [:shape-water,:heat]}
;;    :breathe-air, {:ref "Magic p. 26", :prereqs [:create-water,:destroy-air]}
;;    :breathe-steam, {:ref "Magic p. 192", :prereqs [[:talents/magery,1],:steam-jet,:resist-fire]}
;;    :breathe-water, {:ref "Basic Set p. 243}; GURPS Magic p. 189", :prereqs [:create-air,:destroy-water]}
;;    :body-of-ice, {:ref "Magic p. 189", :prereqs [[:talents/magery,2],:body-of-water,:freeze]}
;;    :body-of-water, {:ref "Magic p. 185", :prereqs [:shape-water]}
;;    :boil-water, {:ref "Magic p. 189", :prereqs [:shape-water,:heat]}
;;    :control-water-elemental, {:ref "Magic p. 28", :prereqs [:summon-water-elemental]}
;;    :condense-steam, {:ref "Magic p. 189", :prereqs [[:or #{:cold,:boil-water}]]}
;;    :cone-of-corrosion, {:ref "Magic: Artillery Spells p. 27", :prereqs [[:talents/magery,4],:acid-jet]}
;;    :coolness, {:ref "Magic p. 187", :prereqs [:cold]}
;;    :create-acid, {:ref "Magic p. 190}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:create-water,:create-earth]}
;;    :create-ice, {:ref "Magic p. 188}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:freeze]}
;;    :create-spring, {:ref "Magic p. 190", :prereqs [:dry-spring,:shape-water]}
;;    :create-steam, {:ref "Magic p. 190", :prereqs [:boil-water]}
;;    :create-water, {:ref "Basic Set p. 253}; GURPS Magic p. 184; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [:purify-water]}
;;    :create-water-elemental, {:ref "Magic p. 22", :prereqs [[:talents/magery,2],:control-water-elemental]}
;;    :current, {:ref "Magic p. 194", :prereqs [[6,:water]]}
;;    :dehydrate, {:ref "Magic p. 188", :prereqs [[5,:water],:destroy-water]}
;;    :destroy-water, {:ref "Basic Set p. 253}; GURPS Magic p. 185", :prereqs [:create-water]}
;;    :dissipate, {:ref "Magic: Death Spells p. 21 and GURPS Magical Styles: Dungeon Magic p.8", :prereqs [[:talents/magery,3],[:or #{[:body-of-water,:earth-to-water],[:flesh-to-ice,:melt-ice],[:body-of-fluid,:earth-to-fluid]}]]}
;;    :distill, {:ref "Magic p. 89", :prereqs [:mature,:destroy-water]}
;;    :drown, {:ref "Magic: Death Spells p. 21", :prereqs [[:talents/magery,3],:breathe-air,:breathe-water]}
;;    :dry-spring, {:ref "Magic p. 188", :prereqs [:destroy-water,:shape-earth]}
;;    :earth-to-water, {:ref "Magic p. 52", :prereqs [[:talents/magery,1],:create-water,:shape-earth]}
;;    :essential-acid, {:ref "Magic p. 192}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[:talents/magery,3],:all-6-acid]}
;;    :essential-water, {:ref "Magic p. 189}; Pyramid 3/60: Dungeon Fantasy III p. 6", :prereqs [[6,:water]]}
;;    :flow, {:ref "Magical Styles: Dungeon Magic p.9", :prereqs [:body-of-fluid]}
;;    :fog, {:ref "Basic Set p. 253}; GURPS Magic p. 193", :prereqs [:shape-water]}
;;    :foul-water, {:ref "Magic p. 185", :prereqs [:purify-water,:decay]}
;;    :flesh-to-ice, {:ref "Magic p. 190", :prereqs [[:talents/magery,1],:frostbite,:body-of-water]}
;;    :freeze, {:ref "Magic p. 185", :prereqs [:shape-water]}
;;    :frost, {:ref "Magic p. 193", :prereqs [[:or #{:create-water,:cold}]]}
;;    :frostbite, {:ref "Magic p. 189", :prereqs [:frost,:freeze]}
;;    :geyser, {:ref "Magic p. 190", :prereqs [[6,:water,:create-spring],[:or #{[4,:earth],[4,:fire]}]]}
;;    :hail, {:ref "Magic p. 195", :prereqs [:snow]}
;;    :ice-dagger, {:ref "Magic p. 188", :prereqs [[:or #{:ice-sphere,:water-jet}]]}
;;    :ice-slick, {:ref "Magic p. 186", :prereqs [:frost]}
;;    :ice-sphere, {:ref "Magic p. 186", :prereqs [:shape-water]}
;;    :ice-storm, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:talents/magery,4],:hail,:storm]}
;;    :icy-breath, {:ref "Magic p. 192", :prereqs [[:talents/magery,1],:snow-jet,:resist-cold]}
;;    :icy-missile, {:ref "Magic p. 186", :prereqs [:icy-weapon]}
;;    :icy-touch, {:ref "Magic p. 188", :prereqs [[:talents/magery,1],[5,:water]]}
;;    :icy-weapon, {:ref "Basic Set p. 253}; GURPS Magic p. 185", :prereqs [:create-water]}
;;    :infiltrate, {:ref "Magical Styles: Dungeon Magic p. 9", :prereqs [:body-of-fluid]}
;;    :mass-coolness, {:ref "3/76: Dungeon Fantasy IV p. 14", :prereqs [[:attributes/int,12],:coolness]}
;;    :mass-resist-acid, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-acid]}
;;    :melt-ice, {:ref "Magic p. 186", :prereqs [[:or #{:heat,freeze}]]}
;;    :mud-jet, {:ref "Magic p. 52", :prereqs [:or #{[:water-jet,:create-earth] :create-water,:sand-jet}]}
;;    :purify-water, {:ref "Basic Set p. 253}; GURPS Magic p. 184", :prereqs [:seek-water]}
;;    :rain, {:ref "Magic p. 195", :prereqs [:clouds]}
;;    :rain-of-acid, {:ref "Magic p. 191", :prereqs [[:talents/magery,2],:create-water,:create-earth]}
;;    :rain-of-alkahest, {:ref "3/25: Epic Magic p. 19", :prereqs [[:talents/magery,4],:essential-acid,:rain-of-acid]}
;;    :rain-of-ice-daggers, {:ref "Magic p. 192", :prereqs [[:talents/magery,2],:hail,:ice-dagger]}
;;    :resist-acid, {:ref "Magic p. 190", :prereqs [:create-acid]}
;;    :resist-water, {:ref "Magic p. 186", :prereqs [:or #{:umbrella},#{:shape-water,:destroy-water}]}
;;    :scald, {:ref "Magic: Artillery Spells p. 27", :prereqs [[:talents/magery,4],:create-steam,:steam-jet]}
;;    :seek-coastline, {:ref "Magic p. 184", :prereqs [:seek-water]}
;;    :seek-water, {:ref "Basic Set p. 253}; GURPS Magic p. 184", :prereqs []}
;;    :shape-water, {:ref "Basic Set p. 253}; GURPS Magic p. 185", :prereqs [:create-water]}
;;    :snow, {:ref "Magic p. 193", :prereqs [:clouds,:frost]}
;;    :snow-jet, {:ref "Magic p. 189", :prereqs [:water-jet,:freeze]}
;;    :snow-shoes, {:ref "Magic p. 186", :prereqs [:shape-water]}
;;    :spit-acid, {:ref "Magic p. 192", :prereqs [[:talents/magery,3],:acid-jet,:resist-acid]}
;;    :spit-alkahest, {:ref "3/25: Epic Magic p. 19", :prereqs [[:talents/magery,4],:essential-flame,:spit-acid]}
;;    :steam-jet, {:ref "Magic p. 191", :prereqs [:water-jet,:boil-water]}
;;    :storm, {:ref "Magic p. 195", :prereqs [:rain,:hail]}
;;    :stygian-cold, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-water,:frostbite]}
;;    :stygian-ice-dagger, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-water,:ice-dagger]}
;;    :stygian-ice-sphere, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-water,:ice-sphere]}
;;    :stygian-touch, {:ref "3/25: Epic Magic p. 18", :prereqs [[:talents/magery,4],:essential-water,:icy-touch]}
;;    :summon-water-elemental, {:ref "Magic p. 27", :prereqs [[:or #{[:talents/magery,1],[8,:water],[4,:water],:another-summon-elemental-spell}]]}
;;    :swim, {:ref "Magic p. 147", :prereqs [:shape-water,:levitation]}
;;    :tide, {:ref "Magic p. 194", :prereqs [[:8,:water]]}
;;    :transfer-water, {:ref "Thaumatology: Urban Magics p. 34", :prereqs [[:talents/magery,1],:shape-water]}
;;    :umbrella, {:ref "Magic p. 185", :prereqs [[:or #{:shape-water,:shield}]]}
;;    :walk-on-water, {:ref "Magic p. 186", :prereqs [:shape-water]}
;;    :walk-through-water, {:ref "Magic p. 188", :prereqs [[:talents/magery,1],:shape-water]}
;;    :water-jet, {:ref "Magic p. 187", :prereqs [:shape-water]}
;;    :water-vision, {:ref "Magic p. 187", :prereqs [:shape-water]}
;;    :waves, {:ref "Magic p. 194", :prereqs [:shape-water]}
;;    :whirlpool, {:ref "Magic p. 187", :prereqs [:shape-water]}
;;    :wilting, {:ref "Magic: Artillery Spells p. 28", :prereqs [[:talents/magery,4],[10,:water],:dehydrate]}
;;    :ball-of-lightning, {:ref "Magic p. 197", :prereqs [:apportation,:lightning]}
;;    :body-of-lightning, {:ref "Magic p. 198", :prereqs [[:talents/magery,2],:lightning]}
;;    :chain-lightning, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:talents/magery,4],:ball-of-lightning,:resist-lightning]}
;;    :cloud-vaulting, {:ref "Magic p. 148", :prereqs [[:talents/magery,2],:jump,:walk-on-air]}
;;    :cloud-walking, {:ref "Magic p. 148", :prereqs [:walk-on-air,:walk-on-water]}
;;    :clouds, {:ref "Magic p. 194", :prereqs [[2,:water] [2,:air]]}
;;    :cool, {:ref "Magic p. 195", :prereqs [:cold,[4,:air]]}
;;    :current, {:ref "Magic p. 194", :prereqs [[6,:water]]}
;;    :explosive-lightning, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :fog, {:ref "Magic p. 193", :prereqs [:shape-water]}
;;    :frost, {:ref "Magic p. 193", :prereqs [[:or #{:create-water,:cold}]]}
;;    :grave-grounding, {:ref "Magic: Death Spells p. 22", :prereqs [[:talents/magery,3],:body-of-lightning,:resist-lightning]}
;;    :hail, {:ref "Magic p. 195", :prereqs [:snow]}
;;    :ice-storm, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:talents/magery,4],:hail,:storm]}
;;    :improved-explosive-lightning, {:ref "Magic: Artillery Spells p. 29", :prereqs [[:or #{[:talents/magery,4],[10,:air],[10,:weather]}],:explosive-lightning]}
;;    :lethal-lightning, {:ref "Magic: Death Spells p. 22", :prereqs [[:talents/magery,3],:annihilation,:explode]}
;;    :lightning, {:ref "Basic Set p. 244}; GURPS Magic p. 196", :prereqs [[:talents/magery,1],[6,:air]]}
;;    :lightning-armor, {:ref "Magic p. 198", :prereqs [[6,:lightning,:resist-lightning]]}
;;    :lightning-missiles, {:ref "Magic p. 198", :prereqs [:lightning-weapon]}
;;    :lightning-weapon, {:ref "Magic p. 198", :prereqs [[:talents/magery,2],:lightning]}
;;    :lightning-whip, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :mass-resist-lightning, {:ref "3/4: Magic on the Battlefield p. 9 and GURPS Magical Styles: Dungeon Magic p. 13", :prereqs [[:attributes/int,13],:resist-lightning]}
;;    :predict-weather, {:ref "Basic Set p. 243}; GURPS Magic p. 193", :prereqs [[4,:air]]}
;;    :rain, {:ref "Magic p. 195}; GURPS Fantasy p. 168", :prereqs [:clouds]}
;;    :resist-lightning, {:ref "Magic p. 196", :prereqs [[6,:air]]}
;;    :shocking-touch, {:ref "Magic p. 196", :prereqs [:lightning]}
;;    :snow, {:ref "Magic p. 193", :prereqs [:clouds,:frost]}
;;    :spark-cloud, {:ref "Magic p. 196", :prereqs [:shape-air,:lightning]}
;;    :spark-storm, {:ref "Magic p. 196", :prereqs [:windstorm,:lightning]}
;;    :storm, {:ref "Magic p. 195", :prereqs [:rain,:hail]}
;;    :stroke-of-lightning, {:ref "Magic Styles: Dungeon Magic p. 19", :prereqs [[:pick 3 [:ball-of-lightning,:flaming-armor,:rain-of-acid,:breathe-fire,:flaming-missiles,:rain-of-fire,:breathe-steam,:flaming-weapon-rive,:burning-touch,:lightning-armor,:shocking-touch,:continual-sunlight,:lightning-missiles,:spark-cloud,:explosive-fireball,:lightning-stare,:spark-storm,:explosive-lightning,:lightning-weapon,:spit-acid,:fire-cloud,:lightning-whip,:wall-of-lightning]]]}
;;    :tide, {:ref "Magic p. 194", :prereqs [[:8,:water]]}
;;    :wall-of-lightning, {:ref "Magic p. 197", :prereqs [:lightning]}
;;    :warm, {:ref "Magic p. 195", :prereqs [:heat,[4,:air]]}
;;    :waves, {:ref "Magic p. 194", :prereqs [:shape-water]}
;;    :weather-dome, {:ref "Magic p. 169", :prereqs [[2,:1-from-4-elements]]}
;;    :wind, {:ref "Magic p. 193", :prereqs [:windstorm]}
;;    :alter-gender, {:ref "3/28: Thaumatology II p. 14", :prereqs [,:rogyny]}
;;    :androgyny, {:ref "3/28: Thaumatology II p. 14", :prereqs [:sense-man,:great-voice]}
;;    :dye-yellow, {:ref "3/28: Thaumatology II p. 14", :prereqs [[2,:yellow-goblin-magic]]}
;;    :sense-goblin, {:ref "3/28: Thaumatology II p. 15", :prereqs [[2,:yellow-goblin-magic]]}
;;    :sense-man, {:ref "3/28: Thaumatology II p. 15", :prereqs [[2,:yellow-goblin-magic]]}
;;    :spark-of-eros, {:ref "3/28: Thaumatology II p. 15", :prereqs [:trusted-fellow]}
;;    :sunburst, {:ref "3/28: Thaumatology II p. 15", :prereqs [:sunbolt]}
;;    :true-king, {:ref "3/28: Thaumatology II p. 16", :prereqs [:trusted-fellow]}
;;    :trusted-fellow, {:ref "3/28: Thaumatology II p. 16", :prereqs [:sense-man,:great-voice]}
;;    :exclude-ethical-category, {:ref "Thaumatology p. 50", :prereqs [:gms-choice]}
;;    :loyalty-of-ethical-category, {:ref "Thaumatology p. 50", :prereqs [:gms-choice]}
;;    :protection-from-ethical-category, {:ref "Thaumatology p. 49", :prereqs [:gms-choice]}
;;    :repel-ethical-category, {:ref "Thaumatology p. 49", :prereqs [:gms-choice]}
;;    :seek-ethical-category, {:ref "Thaumatology p. 49", :prereqs [:gms-choice]}
;;    :self-destruct, {:ref "Magic: Artillery Spells p. 23", :prereqs [[:talents/magery,1],:1-spell-from-10-different-colleges]}
;;    :sense-ethical-category, {:ref "Thaumatology p. 49", :prereqs [:gms-choice]}
;;              })

(defn- parse-spell-count
  [e]
  (if (and (string? e) (re-matches #"^\d+ .* spells?$" e))
    (let [[n college _] (clojure.string/split e #" ")]
      [(js/parseInt n) (keyword (clojure.string/lower-case college))])
    e))

(defn- parse-spell-lvl
  [e]
  (if (and (string? e) (re-matches #".*-\d+\+?$" e))
    (let [[spell lvl] (clojure.string/split e #"-")]
      [(-> spell kebab-case keyword) (js/parseInt lvl)])
    e))

(->> spells
     (take 10)
     (map #(merge % {:college (keyword (kebab-case (get % :college)))})))

;; TODO: "10 other"
;; or-
;; any-
;; -each-
;; -and-
;; either-
;; 6-air-spells
;; :second-level
;; other air skill
;; any air spells
;; 1 spell from each college
;; secret-spell
;; ;#{....

;; (parse-spell-lvl "Body of Air-16+")
;; (parse-spell-lvl "Magery 2")
;; (parse-spell-lvl [4 :air])

;; (defn- parse-this-mess-and-hope-they-use-the-same-format-in-other-same-types-of-prerequisite-text
;;   "Takes '1 spell from each of 5 different colleges besides Air' as input
;;   => {:fire 1, :air 1, :water 1, :earth 1}"
;;   [e]
;;   (if (string? e)
;;     (let [[spell-from-each besides college] (clojure.string/split e #"besides")]
;;       [])
;;     e))

;; (clojure.string/split "1 spell from each of 5 different colleges besides Air" #"besides")

;; (parse-this-mess-and-hope-they-use-the-same-format-in-other-same-types-of-prerequisite-text "1 spell from each of 5 different colleges besides Air")

;; (->> gurps.pages.character.utils.spells/spells
;;      (map :prerequisites)
;;      (take 20)
;;      (map #(clojure.string/split % #"[,]|and|including|at least"))
;;      (map #(map clojure.string/trim %))
;;      (map #(filter (fn [e] (not (clojure.string/blank? e))) %))
;;      ;; catch "10 Air spells" sort of dependencies and codify it
;;      (map #(map parse-spell-count %))
;;      ;; codify "Body of Air-16+" type of dependencies
;;      (map #(map parse-spell-lvl %))
;;      ;; codify rest of dependencies
;;      (map #(map (fn [e] (if (vector? e) e (-> e kebab-case keyword))) %)))

;; (->> gurps.pages.character.utils.spells/spells
;;      (take 20)
;;      (map #(merge % {:prerequisites (clojure.string/split (:prerequisites %) #"[,]|and|including|at least")}))
;;      (map #(merge % {:prerequisites (map clojure.string/trim (:prerequisites %))}))
;;      (map #(merge % {:prerequisites (map (fn [e] (clojure.string/replace e #")))}));" "")) (:prerequisites %))}))
;;      (map #(merge % {:prerequisites (filter (fn [e] (not (clojure.string/blank? e))) (:prerequisites %))}))
;;      ;; catch "10 Air spells" sort of dependencies and codify it
;;      (map #(merge % {:prerequisites (map parse-spell-count (:prerequisites %))}))
;;      ;; codify "Body of Air-16+" type of dependencies
;;      (map #(merge % {:prerequisites (map parse-spell-lvl (:prerequisites %))}))
;;      ;; codify rest of dependencies
;;      (map #(merge % {:prerequisites (map (fn [e] (if (vector? e) e (-> e kebab-case keyword))) (:prerequisites %))}))
;;      (map #(merge % {:prerequisites (vec (:prerequisites %))})
;;           (map #(merge % (-> (:name %) kebab-case keyword)))))

(+ 1 2)

;; TODO (re-matches #"^\d+ .* spells?$" "1 spell from each of 5 different colleges besides Air")

(let [[spell lvl] (clojure.string/split (re-matches #".*-\d+\+?$" "Body of Air-16+") #"-")]
  [spell (js/parseInt lvl)])

;; (->> parsed-spells
;;      (map #(str "(def " (kebab-case (get % :name)) " " % ")")))
;;      ;; (map cljs.reader/read-string)

(->> spells
     (map #(merge % {:college (keyword (kebab-case (get % :college)))})))

;; (def colleges [:air :animal :body-control :communication-and-empathy :earth :enchantment :fire :gate :healing :illusion-and-creation :knowledge :light-and-darkness :making-and-breaking :meta-spell :mind-control :movement :necromantic :plant :protection-and-warning :sound :technological :water :weather :food]

;; (cljs.reader/read-string "(def air-jet \"Air Jet\", {:prerequisites \"Shape Air\", :prerequisite_count 3, :college \"Air\", :ref \"Magic p. 24\"})")
