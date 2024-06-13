(ns gurps.pages.character.utils.spells)

(def spells [{:name :air-jet, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] {:fire 1 :water 1 :earth 1 :ether 1}], :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :college :air, :ref "Basic Set p. 250}; Magic p. 189"}
             ;;{:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :cloud, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             ;;{:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             ;;{:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-missiles, :prerequisites [:electric-weapon], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Classic: Grimoire p 28"}
             ;;{:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [[6 :air]], :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :college :air, :ref "Magic: Artillery Spells p. 9"}
             ;;{:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :college :air, :ref "Magic: Artillery Spells p. 25"}
             ;;{:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :jolt, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :other]], :college :air, :ref "Basic Set p. 244}; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning :resist-lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :mighty-breath, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :mass-resist-lightning, :prerequisites [[:iq 13] :resist-lightning], :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :college :air, :ref "Magic p. 24"}
             ;;{:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :college :air, :ref "Basic Set p. 243}; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :college :air, :ref "Basic Set p. 243}; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :college :air, :ref "Magic p. 195}; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :college :air, :ref "Magic p. 196"}
             ;;{:name :safe-boarding, :prerequisites [[8 :air]], :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :college :air, :ref "Magic p. 23"}
             ;;{:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :static-charge, :prerequisites [:purify-air [1 :air]], :college :air, :ref "Classic: Technomancer p 17"}
             ;;{:name :steal-breath, :prerequisites [[:skills/magery 3] [7 :air] :devitalize-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 244}; Magic p. 23"}
             ;;{:name :stinkguard, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :college :air, :ref "Magic p. 195"}
             ;;{:name :storm-shelter, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] [4 :air] #{:summon-fire-elemental :summon-water-elemental :summon-earth-elemental}], :college :air, :ref "Magic p. 27"}
             ;;{:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [#{:beast-summoning :seeker}], :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :call, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :creeping-plague, :prerequisites [#{[[:skills/magery 5] :beast-summoning :vermin-control]  [[:skills/magery 4] :create-animal]}], :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting]], :college :animal, :ref "Magic p. 34"}
             ;;{:name :groom, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :hybrid-control, :prerequisites [:animal-control], :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             ;;{:name :insect-repellent, :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] #{:partial-shapeshifting :permanent-shapeshifting :shapeshifting :great-shapeshifting} :animal-control], :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :shapeshifting], :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdog :animal-spells], :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :animal]], :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :college :animal, :ref "Magic p. 32"}
             ;;{:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :shapeshift-others], :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :college :body-control, :ref "Spell: Bio-Tech, p. 30}; Item: Classic: Technomancer pg 17"}
             ;;{:name :ache, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :analgesic, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :belch, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :birth-control, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :blend-in, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40}; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :body-control]], :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :curse], :college :body-control, :ref "Classic: Magic p 24"}
             ;;{:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch], :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             ;;{:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :college :body-control, :ref "Basic Set, p. 245}; Magic, p. 41"}
             {:name :debility, :prerequisites [], :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :college :body-control, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ease-labor, :prerequisites [:lend-vitality], :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             ;;{:name :eat-crow, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :elvish-grace, :prerequisites [:clumsiness], :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :college :body-control, :ref "Magic, p. 43}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :college :body-control, :ref "Classic: Technomancer p. 17"}
             ;;{:name :flexibility, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :body-control]], :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :college :body-control, :ref "Magic, p. 42}; b: Classic Grimoire p. 18"}
             ;;{:name :ley-running, :prerequisites [:seek-ley-line :haste], :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             ;;{:name :stand-out, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :strike-anosmic, :prerequisites [:spasm], :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :stifle, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-light :darkness-spells], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :college :body-control, :ref "Magic, p. 38"}
             ;;{:name :throw-voice, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object :flesh-to-stone.], :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :college :body-control, :ref "Magic, p. 37"}
             ;;{:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :absorb-book, :prerequisites [#{[:iq 13] :gift-of-letters}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             ;;{:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ack, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :college :communication-and-empathy, :ref "Magic, p. 46"}
             ;;{:name :borrow-number, :prerequisites [:seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :delete-commercials, :prerequisites [[:world/tl 7]], :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :college :communication-and-empathy, :ref "Magic p. 49"}
             ;;{:name :drama, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46"}
             ;;{:name :identify-caller, :prerequisites [:mind-reading :seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             ;;{:name :illuminated-writing, :prerequisites [[:skills/magery 2] #{:mind-sending :fascinate [:skills/writing 12]}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :college :communication-and-empathy, :ref "Magic, p. 176"}
             ;;{:name :magic-switchboard, :prerequisites [:identify-caller], :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :college :communication-and-empathy, :ref "Magic, p. 173"}
             ;;{:name :mer-speech, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 47}; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy :thunderclap], :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :sorcerous-signal, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :speed-data, :prerequisites [[:world/tl 7] #{:haste :lightning}], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :college :communication-and-empathy, :ref "4e spell chart"}
             ;;{:name :telepathic-overload, :prerequisites [[:skills/magery 3] [10 :communication-and-empathy] :telepathy], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :wrong-number, :prerequisites [[:world/tl 6] #{:sense-foes :seek-number}], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             ;;{:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             ;;{:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-fire :shape-stone :shape-water :shape-air], :college :earth, :ref "Magic, p. 55"}
             ;;{:name :badger-paws, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :college :earth, :ref "Magic, p. 54"}
             ;;{:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :college :earth, :ref "Magic, p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :college :earth, :ref "Magic, p. 22"}
             ;;{:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :earth, :ref "Basic Set, p. 243}; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :college :earth, :ref "Magic, p. 51}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :college :earth, :ref "Magic, p. 53}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             ;;{:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             ;;{:name :gargoyle-skin, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             ;;{:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :pebble, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :college :earth, :ref "Magic, p. 54}; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :college :earth, :ref "Magic, p. 53"}
             ;;{:name :sand-blast, :prerequisites [[:skills/magery 4] :sand-jet :sandstorm], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :college :earth, :ref "Magic, p. 51"}
             ;;{:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :earth]], :college :earth, :ref "Fantasy, p. 169"}
             ;;{:name :spotless-hands, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :college :earth, :ref "Magic, p. 54}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{[[8 :earth]] [4 :earth #{:summon-fire-elemental :summon-water-elemental :summon-air-elemental}]}], :college :earth, :ref "Magic, p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :college :earth, :ref "Magic, p. 52}; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :college :enchantment, :ref "Magic p. 58}; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             ;;{:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             ;;{:name :doom-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 23]], :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :college :enchantment, :ref "Magic p. 62}; Classic: Magic p 40"}
             ;;{:name :dwarfish-reinforcement, :prerequisites [:enchant], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             ;;{:name :electric-power, :prerequisites [:lend-power :power :steal-power], :college :enchantment, :ref "Classic: Technomancer p. 20"}
             ;;{:name :emergency-staff, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] [:gate 1] [:body-control 1] [:movement 1] [:food 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:protection-and-warning 1] [:meta 1] [:light-and-darkness 1]], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :college :enchantment, :ref "Magic p. 66}; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  [5 :communication-and-empathy]], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             ;;{:name :live-libram, :prerequisites [:enchant :apportation], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :magician's-minion, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             ;;{:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :college :enchantment, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             ;;{:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :resilient-golem, :prerequisites [:golem :shatterproof], :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [], :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] [:skills/writing 12]], :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :sorcerer's-stand-in, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :spellbook-enchantment, :prerequisites [:scroll], :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             ;;{:name :spellgraft, :prerequisites [:enchant], :college :enchantment, :ref "Bio-Tech, p. 32"}
             ;;{:name :spellprocessor, :prerequisites [:scroll [:skills/computer-programming 15]], :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 56}; Fantasy, p. 23"}
             ;;{:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :college :fire, :ref "Magic p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :college :fire, :ref "Magic p. 22"}
             ;;{:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 73"}
             ;;{:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :ember, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :college :fire, :ref "Basic Set, p. 247}; Magic p. 75"}
             ;;{:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :college :fire, :ref "Magic p. 75"}
             ;;{:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Magic p. 73"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :college :fire, :ref "Magic p. 75"}
             ;;{:name :great-deflect-energy, :prerequisites [[:skills/magery 2] :deflect-energy], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             ;;{:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             ;;{:name :mass-detonate, :prerequisites [:detonate], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             ;;{:name :oven-mitts, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :college :fire, :ref "Magic p. 73"}
             ;;{:name :puff, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :college :fire, :ref "Magic p. 74}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :college :fire, :ref "Classic: Technomancer p 21"}
             ;;{:name :self-destruct, :prerequisites [[:skills/magery 1] [1 :fire] [1 :necromantic] [1 :meta] :explode], :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :college :fire, :ref "Magic p. 73"}
             ;;{:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{[[8 :fire]] [[4 :fire] #{:summon-water-elemental :summon-earth-elemental :summon-air-elemental}]}], :college :fire, :ref "Magic p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             ;;{:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :college :fire, :ref "Magic p. 74"}
             {:name :air-jet, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] [1 :earth] [1 :fire] [1 :water] [1 :meta]], :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :college :air, :ref "Basic Set p. 250}; Magic p. 189"}
             ;;{:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :cloud, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             ;;{:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             ;;{:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-missiles, :prerequisites [:electric-weapon], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Classic: Grimoire p 28"}
             ;;{:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [:6-air-spells], :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :college :air, :ref "Magic: Artillery Spells p. 9"}
             ;;{:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :college :air, :ref "Magic: Artillery Spells p. 25"}
             ;;{:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :jolt, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :air]], :college :air, :ref "Basic Set p. 244}; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning :resist-lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :mighty-breath, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :mass-resist-lightning, :prerequisites [[:attributes/int 13]  :resist-lightning], :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :college :air, :ref "Magic p. 24"}
             ;;{:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :college :air, :ref "Basic Set p. 243}; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :college :air, :ref "Basic Set p. 243}; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :college :air, :ref "Magic p. 195}; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :college :air, :ref "Magic p. 196"}
             ;;{:name :safe-boarding, :prerequisites [[8 :air]], :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :college :air, :ref "Magic p. 23"}
             ;;{:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :static-charge, :prerequisites [:purify-air [1 :air]], :college :air, :ref "Classic: Technomancer p 17"}
             ;;{:name :steal-breath, :prerequisites [[:skills/magery 3] [7 :air] :devitalize-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 244}; Magic p. 23"}
             ;;{:name :stinkguard, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :college :air, :ref "Magic p. 195"}
             ;;{:name :storm-shelter, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] #{[8 :air] [4 :air]} :another-summon-elemental-spell], :college :air, :ref "Magic p. 27"}
             ;;{:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [:beast-summoning [2 :seek] :or-seeker], :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :call, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :creeping-plague, :prerequisites [[:skills/magery 5] :beast-summoning #{:vermin-control [:skills/magery 4]} :create-animal], :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting] [10 :other]], :college :animal, :ref "Magic p. 34"}
             ;;{:name :groom, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :hybrid-control, :prerequisites [[2 :animal]], :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             ;;{:name :insect-repellent, :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] :2-shapeshift-other :2-body-control :2-animal-control], :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :appropriate-shapeshifting], :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdog :animal-spells], :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:the-appropriate-animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :appropriate-shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :other]], :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :college :animal, :ref "Magic p. 32"}
             ;;{:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :any-one-shapeshift-others-spell], :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :college :body-control, :ref "Spell: Bio-Tech, p. 30}; Item: Classic: Technomancer pg 17"}
             ;;{:name :ache, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :analgesic, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :belch, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :birth-control, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :blend-in, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40}; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :other]], :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :spell-used-in-missile], :college :body-control, :ref "Classic: Magic p 24"}
             ;;{:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch :choke :entombment :rotting-death :curse-evisceration :steal-beauty :deathtouch :frostbite :steal-skill :dehydrate :pestilence :stop-healing], :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             ;;{:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :college :body-control, :ref "Basic Set, p. 245}; Magic, p. 41"}
             {:name :debility, :prerequisites [], :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :college :body-control, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ease-labor, :prerequisites [:lend-vitality], :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             ;;{:name :eat-crow, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :elvish-grace, :prerequisites [:clumsiness], :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :college :body-control, :ref "Magic, p. 43}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :college :body-control, :ref "Classic: Technomancer p. 17"}
             ;;{:name :flexibility, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :other]], :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :college :body-control, :ref "Magic, p. 42}; b: Classic Grimoire p. 18"}
             ;;{:name :ley-running, :prerequisites [:seek-ley-line :haste], :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             ;;{:name :stand-out, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :strike-anosmic, :prerequisites [:spasm], :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :stifle, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-ligh  :darkness], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :college :body-control, :ref "Magic, p. 38"}
             ;;{:name :throw-voice, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object], :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :college :body-control, :ref "Magic, p. 37"}
             ;;{:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :absorb-book, :prerequisites [#{[:attributes/int 13] :gift-of-letters}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             ;;{:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ack, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :college :communication-and-empathy, :ref "Magic, p. 46"}
             ;;{:name :borrow-number, :prerequisites [:seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :delete-commercia, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :college :communication-and-empathy, :ref "Magic p. 49"}
             ;;{:name :drama, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language #{:3-languages-written-at-accented :better}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language #{:3-languages-spoken-at-accented :better}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46"}
             ;;{:name :identify-caller, :prerequisites [:mind-reading :seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             ;;{:name :illuminated-writing, :prerequisites [[:skills/magery 2] :one-of-mind-sending :fascinate [:or-writing 12]], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :college :communication-and-empathy, :ref "Magic, p. 176"}
             ;;{:name :magic-switchboard, :prerequisites [:identify-caller], :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :college :communication-and-empathy, :ref "Magic, p. 173"}
             ;;{:name :mer-speech, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 47}; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy], :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :sorcerous-signal, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :speed-data, :prerequisites [[:world/tl 7] :haste :lightning], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :college :communication-and-empathy, :ref "4e spell chart"}
             ;;{:name :telepathic-overload, :prerequisites [[:skills/magery 3] :any-10-communicatio [:empathy :telepathy]], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :wrong-number, :prerequisites [[:world/tl 6] #{:sense-foes :seek-number}], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             ;;{:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             ;;{:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-water :shape-fire :shape-air :shape-stone], :college :earth, :ref "Magic, p. 55"}
             ;;{:name :badger-paws, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :college :earth, :ref "Magic, p. 54"}
             ;;{:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :college :earth, :ref "Magic, p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :college :earth, :ref "Magic, p. 22"}
             ;;{:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :earth, :ref "Basic Set, p. 243}; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :college :earth, :ref "Magic, p. 51}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :college :earth, :ref "Magic, p. 53}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             ;;{:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             ;;{:name :gargoyle-skin, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             ;;{:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :pebble, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :college :earth, :ref "Magic, p. 54}; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :college :earth, :ref "Magic, p. 53"}
             ;;{:name :sand-blast, :prerequisites [[:skills/magery 4] :s :jet :s :storm], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :college :earth, :ref "Magic, p. 51"}
             ;;{:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :other]], :college :earth, :ref "Fantasy, p. 169"}
             ;;{:name :spotless-hands, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :college :earth, :ref "Magic, p. 54}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :earth] [4 :earth]} :another-summon-elemental-spell], :college :earth, :ref "Magic, p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :college :earth, :ref "Magic, p. 52}; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :college :enchantment, :ref "Magic p. 58}; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman-for-the-appropriate-spell], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             ;;{:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             ;;{:name :doom-wish, :prerequisites [[:skills/magery 3] :wish :iq-+-magery-of-23+], :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :college :enchantment, :ref "Magic p. 62}; Classic: Magic p 40"}
             ;;{:name :dwarfish-reinforcement, :prerequisites [:enchant], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             ;;{:name :electric-power, :prerequisites [:lend-power :power :steal-power], :college :enchantment, :ref "Classic: Technomancer p. 20"}
             ;;{:name :emergency-staff, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] :one-spell-from-10-other-colleges], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :college :enchantment, :ref "Magic p. 66}; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  :five-communicatio  :empathy], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             ;;{:name :live-libram, :prerequisites [:enchant :apportation], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :magician's-minion, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             ;;{:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :college :enchantment, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             ;;{:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :resilient-golem, :prerequisites [:golem :shatterproof], :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [:any-limiting-enchantment-spell], :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] #{:1-written-language-at-accented :better}], :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :sorcerer's-stand-in, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :spellbook-enchantment, :prerequisites [:scroll], :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             ;;{:name :spellgraft, :prerequisites [:enchant], :college :enchantment, :ref "Bio-Tech, p. 32"}
             ;;{:name :spellprocessor, :prerequisites [:scroll [:computer-programming 15]], :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant :spell-to-be-opposed], :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 56}; Fantasy, p. 23"}
             ;;{:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :college :fire, :ref "Magic p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :college :fire, :ref "Magic p. 22"}
             ;;{:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 73"}
             ;;{:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :ember, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :college :fire, :ref "Basic Set, p. 247}; Magic p. 75"}
             ;;{:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :college :fire, :ref "Magic p. 75"}
             ;;{:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Magic p. 73"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :college :fire, :ref "Magic p. 75"}
             ;;{:name :great-deflect-energy, :prerequisites [[:skills/magery 2]  :deflect-energy], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             ;;{:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             ;;{:name :mass-detonate, :prerequisites [:detonate], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             ;;{:name :oven-mitts, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :college :fire, :ref "Magic p. 73"}
             ;;{:name :puff, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :college :fire, :ref "Magic p. 74}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :college :fire, :ref "Classic: Technomancer p 21"}
             ;;{:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :college :fire, :ref "Magic p. 73"}
             ;;{:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :fire] [4 :fire]} :another-summon-elemental-spell], :college :fire, :ref "Magic p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             ;;{:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :college :fire, :ref "Magic p. 74"}
             {:name :accelerate-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-each-from-10-colleges], :college :gate, :ref "Magic p. 86"}
             {:name :beacon, :prerequisites [:teleport :timeport :plane-shift], :college :gate, :ref "Magic p. 83}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :blink, :prerequisites [:teleport], :college :gate, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :college :gate, :ref "Magic p. 148"}
             {:name :control-gate, :prerequisites [[:skills/magery 3] :seek-gate], :college :gate, :ref "Magic p. 85"}
             {:name :create-door, :prerequisites [:teleport :any-1-walk-through-spell], :college :gate, :ref "Magic p. 84"}
             ;;{:name :create-gate, :prerequisites [:control-gate :teleport :timeport :or-plane-shift], :college :gate, :ref "Magic p. 85/Classic: Grimoire p 50"}
             ;;{:name :dimensional-dissection, :prerequisites [[:skills/magery 3] :one-of-plane-shift-other :teleport-other :or-timeport-other], :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :college :gate, :ref "Magic p. 84"}
             ;;{:name :easy-rider, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :hell-zone, :prerequisites [[:skills/magery 4] :beacon :planar-summons-for], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :hide-object, :prerequisites [:hideaway :teleport], :college :gate, :ref "Magic p. 86"}
             ;;{:name :invoke, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 14-15"}
             ;;{:name :null-sphere, :prerequisites [[:skills/magery 5] :create-gate], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :phase, :prerequisites [[:skills/magery 3] #{:plane-shift :ethereal-body}], :college :gate, :ref "Magic p. 83"}
             {:name :phase-other, :prerequisites [:phase], :college :gate, :ref "Magic p. 83"}
             {:name :planar-summons, :prerequisites [[:skills/magery 1] :1-spell-from-10-other-colleges], :college :gate, :ref "Basic Set p. 247}; Magic p. 82"}
             {:name :planar-visit, :prerequisites [[:skills/magery 2] #{:projection :planar-summons}], :college :gate, :ref "Magic p. 82"}
             {:name :plane-shift, :prerequisites [:planar-summons], :college :gate, :ref "Basic Set p. 247}; Magic p. 83"}
             {:name :plane-shift-other, :prerequisites [[:skills/magery 3] :plane-shift], :college :gate, :ref "Magic p. 83"}
             {:name :rapid-journey, :prerequisites [[:skills/magery 3] #{:teleport :timeport}], :college :gate, :ref "Magic p. 82"}
             ;;{:name :reorient, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :sanctuary, :prerequisites [:hide-object], :college :gate, :ref "Magic p. 86"}
             {:name :scry-gate, :prerequisites [:seek-gate], :college :gate, :ref "Magic p. 85"}
             {:name :seek-gate, :prerequisites [[:skills/magery 2] :seek-magic :1-spell-from-each-of-10-colleges], :college :gate, :ref "Magic p. 85"}
             {:name :slow-time, :prerequisites [[:skills/magery 2] [:attributes/int 13] :2-from-each-of-10-colleges], :college :gate, :ref "Magic p. 86"}
             ;;{:name :splat, :prerequisites [[:skills/magery 4] :create-door], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :suspend-time, :prerequisites [[:skills/magery 3] :slow-time], :college :gate, :ref "Magic p. 86"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :college :gate, :ref "Magic p. 147}; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:skills/magery 3] :teleport], :college :gate, :ref "Magic p. 147"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :college :gate, :ref "Magic p. 170"}
             {:name :time-out, :prerequisites [[:skills/magery 3] :accelerate-time], :college :gate, :ref "Magic p. 87"}
             {:name :timeport, :prerequisites [[:skills/magery 3] :teleport], :college :gate, :ref "Magic p. 81"}
             {:name :timeport-other, :prerequisites [:timeport], :college :gate, :ref "Magic p. 81"}
             {:name :timeslip, :prerequisites [:timeport], :college :gate, :ref "Magic p. 81"}
             {:name :timeslip-other, :prerequisites [:timeslip], :college :gate, :ref "Magic p. 81"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :college :gate, :ref "Magic p. 84"}
             ;;{:name :underworld-imprisonment, :prerequisites [[:skills/magery 3] :one-plane-shift-other-spell], :college :gate, :ref "Magic: Death Spells, p. 13"}
             ;;{:name :aid, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :aide, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :analgesic, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :archmagi's-recuperation, :prerequisites [:prerequisites:-iq-14+ [:skills/magery 4] :lend-energy], :college :healing, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :awaken, :prerequisites [:lend-vitality], :college :healing, :ref "Basic Set, p. 248}; Magic p. 90"}
             ;;{:name :bender-defender, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :birth-control, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :body-reading, :prerequisites [#{:sense-life :awaken}], :college :healing, :ref "Magic p. 91"}
             {:name :cleansing, :prerequisites [:minor-healing :purify-earth], :college :healing, :ref "Magic p. 94"}
             ;;{:name :cure-addiction, :prerequisites [:relieve-addiction], :college :healing, :ref "Classic: Grimoire p. 55"}
             ;;{:name :cure-dehydration, :prerequisites [[:skills/magery 1] :minor-healing :create-water], :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :cure-disease, :prerequisites [:major-healing :relieve-sickness], :college :healing, :ref "Magic p. 91}; Fantasy, p. 170"}
             ;;{:name :cure-insanity, :prerequisites [:major-healing :relieve-madness [5 :mind]], :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-radiation, :prerequisites [:resist-radiation :major-healing], :college :healing, :ref "Magic p. 182"}
             ;;{:name :cure-starvation, :prerequisites [[:skills/magery 1] :minor-healing :create-food], :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :detect-poison, :prerequisites [#{:sense-danger :test-food}], :college :healing, :ref "Magic p. 166"}
             ;;{:name :disinfect, :prerequisites [[:skills/magery 4] [10 :healing] :cure-disease :remove-contagion], :college :healing, :ref "Magic: Artillery Spells p. 17"}
             ;;{:name :ease-labor, :prerequisites [:lend-vitality], :college :healing, :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
             ;;{:name :euthanize, :prerequisites [[1 :communication-and-empathy] [:skills/magery 1] :spirit-empathy], :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :final-rest, :prerequisites [#{[:skills/magery 1] :spirit-empathy}], :college :healing, :ref "Magic p. 89"}
             {:name :great-healing, :prerequisites [[:skills/magery 3] :major-healing], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             {:name :halt-aging, :prerequisites [[:skills/magery 2] [8 :healing]], :college :healing, :ref "Magic p. 94"}
             {:name :healing-slumber, :prerequisites [[:skills/magery 2] :sleep :minor-healing], :college :healing, :ref "Magic p. 94"}
             {:name :instant-neutralize-poison, :prerequisites [[:skills/magery 2] :neutralize-poison], :college :healing, :ref "Magic p. 92"}
             {:name :instant-regeneration, :prerequisites [[:skills/magery 3] :regeneration], :college :healing, :ref "Magic p. 93"}
             {:name :instant-restoration, :prerequisites [[:skills/magery 2] :restoration], :college :healing, :ref "Magic p. 93"}
             {:name :lend-energy, :prerequisites [#{[:skills/magery 1] :empathy}], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :lend-vitality, :prerequisites [:lend-energy], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :major-healing, :prerequisites [[:skills/magery 1] :minor-healing], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             ;;{:name :mass-resist-disease, :prerequisites [[:attributes/int 13]  :resist-disease], :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             ;;{:name :mass-resist-poison, :prerequisites [[:attributes/int 13]  :resist-poison], :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :minor-healing, :prerequisites [:lend-vitality], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             {:name :neutralize-poison, :prerequisites [#{:cure-disease [:skills/magery 3]} :test-food], :college :healing, :ref "Magic p. 92"}
             {:name :recover-energy, :prerequisites [[:skills/magery 1] :lend-energy], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :regeneration, :prerequisites [[:skills/magery 2] :restoration], :college :healing, :ref "Magic p. 93"}
             {:name :relieve-addiction, :prerequisites [:neutralize-poison], :college :healing, :ref "Magic p. 92|-"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :college :healing, :ref "Magic p. 92"}
             {:name :relieve-paralysis, :prerequisites [:stop-paralysis], :college :healing, :ref "Magic p. 93"}
             {:name :relieve-sickness, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 90"}
             {:name :remove-contagion, :prerequisites [:decay :clean :or-cure-disease], :college :healing, :ref "Magic p. 90"}
             ;;{:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :healing, :ref "Bio-Tech, p. 32; Technomancer p. 22"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :college :healing, :ref "Magic p. 90"}
             {:name :resist-poison, :prerequisites [:vigor], :college :healing, :ref "Magic p. 91"}
             {:name :restoration, :prerequisites [:major-healing :relieve-paralysis :restore], :college :healing, :ref "Magic p. 93"}
             {:name :restore-hearing, :prerequisites [:minor-healing #{:keen-hearing :strike-deaf}], :college :healing, :ref "Magic p. 92"}
             {:name :restore-memory, :prerequisites [:awaken [:iq 11]], :college :healing, :ref "Magic p. 92"}
             {:name :restore-sight, :prerequisites [:minor-healing #{:keen-vision :strike-blind}], :college :healing, :ref "Magic p. 92"}
             {:name :restore-speech, :prerequisites [:minor-healing #{:great-voice :strike-dumb}], :college :healing, :ref "Magic p. 93"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :college :healing, :ref "Magic p. 94"}
             ;;{:name :resuscitate, :prerequisites [[:skills/magery 2] :awaken :stop-spasm], :college :healing, :ref "Magic: Death Spells, p. 14"}
             ;;{:name :sea-legs, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 17"}
             ;;{:name :sense-disease, :prerequisites [#{:sense-life [2 :healing]}], :college :healing, :ref "Bio-Tech, p. 32; Technomaner p 22"}
             {:name :share-energy, :prerequisites [:lend-energy], :college :healing, :ref "Magic p. 89"}
             {:name :share-vitality, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 90"}
             {:name :stop-bleeding, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 91}; Fantasy, p. 169"}
             {:name :stop-paralysis, :prerequisites [:minor-healing :paralyze-limb :or-strike-dumb], :college :healing, :ref "Magic p. 93"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :college :healing, :ref "Magic p. 35"}
             {:name :suspended-animation, :prerequisites [:sleep [4 :healing]], :college :healing, :ref "Magic p. 94"}
             ;;{:name :test, :type :area :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :healing, :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
             {:name :transference-bolt, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :healing, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :youth, :prerequisites [[:skills/magery 3] :halt-aging], :college :healing, :ref "Magic p. 94"}
             ;;{:name :blend-in, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :complex-illusion, :prerequisites [:sound :simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :control-creation, :prerequisites [#{:create-animal :create-servant}], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :control-illusion, :prerequisites [:perfect-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :create-animal, :prerequisites [:create-water :create-object [:attributes/int 12]], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :create-foreign-body, :prerequisites [[:skills/magery 3] :body-reading :create-object], :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :create-mount, :prerequisites [[:skills/magery 3] :create-animal], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :create-object, :prerequisites [[:skills/magery 2] :create-earth :perfect-illusion], :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-servant, :prerequisites [[:skills/magery 3] [:attributes/int 12] :create-object], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :create-trap, :prerequisites [[:skills/magery 4] [10 :illusion-and-create]], :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17"}
             {:name :create-warrior, :prerequisites [:create-servant], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :disbelieve, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :dispel-creation, :prerequisites [:control-creation], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :dispel-illusion, :prerequisites [:control-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :duplicate, :prerequisites [:create-object :copy], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :gargoyle-skin, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 8"}
             {:name :illusion-disguise, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170"}
             {:name :illusion-shell, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :image, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :independence, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96"}
             {:name :initiative, :prerequisites [:independence :wisdom], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :know-illusion, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             ;;{:name :mirror, :prerequisites [[:skills/magery 4] :initiative :phantom], :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17-18"}
             {:name :perfect-illusion, :prerequisites [[:skills/magery 1] :complex-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; 'Social Engineering: Back to School, p. 24"}
             {:name :phantom, :prerequisites [[:skills/magery 2] :perfect-illusion :hinder :apportation], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :college :illusion-and-creation, :ref "Magic p. 73"}
             ;;{:name :phantom-killer, :prerequisites [[:skills/magery 3] :phantom], :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             ;;{:name :shadowplay, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :simple-illusion, :prerequisites [:no-blindness [:iq 11]], :college :illusion-and-creation, :ref "Magic p. 95}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             ;;{:name :stand-out, :type :area :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :air-vision, :prerequisites [:shape-air], :college :knowledge, :ref "Magic, p. 24"}
             {:name :alarm, :prerequisites [:tell-time], :college :knowledge, :ref "Magic, p. 100"}
             {:name :analyze-magic, :prerequisites [:identify-spell], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 102"}
             ;;{:name :analyze-heredity, :prerequisites [#{:seeker :sense-life}], :college :knowledge, :ref "Bio-Tech, p. 30; Technomancer p 23"}
             {:name :ancient-history, :prerequisites [:history], :college :knowledge, :ref "Magic, p. 106"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :college :knowledge, :ref "Magic, p. 105"}
             {:name :aura, :prerequisites [:detect-magic], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 101"}
             {:name :detect-magic, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 101"}
             {:name :divination, :prerequisites [:skills/history], :college :knowledge, :ref "Magic, p. 108}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-vision, :prerequisites [:shape-earth], :college :knowledge, :ref "Magic, p. 51"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :college :knowledge, :ref "Magic, p. 107"}
             {:name :far-feeling, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Magic, p. 100"}
             {:name :far-hearing, :prerequisites [[:skills/magery 1] [4 :sound]], :college :knowledge, :ref "Magic, p. 173"}
             {:name :far-tasting, :prerequisites [[:skills/magery 1] #{:seek-food :seek-air}], :college :knowledge, :ref "Magic, p. 77"}
             {:name :find-direction, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Magic, p. 101"}
             ;;{:name :forbidden-wisdom, :prerequisites [[:skills/magery 3] :recall :see-secrets], :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :glass-wall, :prerequisites [#{[5 :knowledge] :earth-vision}], :college :knowledge, :ref "Magic, p. 103"}
             {:name :history, :prerequisites [:trace], :college :knowledge, :ref "Magic, p. 104"}
             ;;{:name :identify-loot, :prerequisites [[:skills/magery 2]  [7 :fourth-level]], :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :identify-spell, :prerequisites [:detect-magic], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 102"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :college :knowledge, :ref "Magic, p. 105"}
             {:name :invisible-wizard-eye, :prerequisites [:wizard-eye :invisibility], :college :knowledge, :ref "Magic, p. 104"}
             ;;{:name :keyfinder, :type :area :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-location, :prerequisites [[:skills/magery 1] :tell-position], :college :knowledge, :ref "Magic, p. 103"}
             {:name :know-recipe, :prerequisites [:far-tasting :season], :college :knowledge, :ref "Magic, p. 78"}
             ;;{:name :know-thyself, :type :area :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-true-shape, :prerequisites [[:skills/magery 1] [1 :shifting] #{:aura :know-illusion}], :college :knowledge, :ref "Magic, p. 104"}
             {:name :mage-sense, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             {:name :mage-sight, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             {:name :measurement, :prerequisites [], :college :knowledge, :ref "Magic, p. 100"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :college :knowledge, :ref "Magic, p. 105}; Social Engineering: Back to School, p. 24"}
             {:name :metal-vision, :prerequisites [:shape-metal], :college :knowledge, :ref "Magic, p. 183"}
             {:name :mind-over-matter, :prerequisites [[:skills/magery 2] [1 :divination]], :college :knowledge, :ref "Magic Styles: Dungeon Magic, p. 27"}
             {:name :necrovision, :prerequisites [:lightning :seek-emitter], :college :knowledge, :ref "Technomancer p 23"}
             {:name :pathfinder, :prerequisites [[:skills/magery 1] [:attributes/int 12] [2 :seek]], :college :knowledge, :ref "Magic, p. 105"}
             {:name :plant-vision, :prerequisites [:shape-plant], :college :knowledge, :ref "Magic, p. 162"}
             {:name :plastic-vision, :prerequisites [:shape-plastic], :college :knowledge, :ref "Magic, p. 183"}
             {:name :prehistory, :prerequisites [:ancient-history], :college :knowledge, :ref "Magic, p. 104"}
             {:name :projection, :prerequisites [:sense-spirit [4 :knowledge]], :college :knowledge, :ref "Magic, p. 105"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :college :knowledge, :ref "Magic, p. 104"}
             {:name :reconstruct-spell, :prerequisites [[:skills/magery 2] :history :identify-spell], :college :knowledge, :ref "Magic, p. 104"}
             {:name :remember-path, :prerequisites [:find-direction :memorize], :college :knowledge, :ref "Magic, p. 105"}
             ;;{:name :retro-reading, :prerequisites [:trace], :college :knowledge, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :scents-of-the-past, :prerequisites [[:skills/magery 2] :history :odor], :college :knowledge, :ref "Magic, p. 107"}
             {:name :schematic, :prerequisites [:reveal-function :history], :college :knowledge, :ref "Magic, p. 177"}
             {:name :see-secrets, :prerequisites [:seeker :aura], :college :knowledge, :ref "Magic, p. 105}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :seek-ley-line, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :seek-magic, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             ;;{:name :seek-navy, :prerequisites [[8 :third-level]], :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :college :knowledge, :ref "Technomancer p. 18"}
             {:name :seeker, :prerequisites [[:skills/magery 1] [:attributes/int 12] :2-'seek-'spells], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 105"}
             {:name :sense-mana, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 101"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :knowledge, :ref "Magic, p. 111"}
             {:name :summon-shade, :prerequisites [#{:summon-spirit :divination}], :college :knowledge, :ref "Magic, p. 102"}
             ;;{:name :sweet-oblivion, :type :area :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :televisomancy, :prerequisites [[:skills/magery 1] #{[6 :knowledge] [:skills/electronics-operation_communications 15]}], :college :knowledge, :ref "Classic: Technomancer p 23"}
             {:name :tell-position, :prerequisites [:measurement], :college :knowledge, :ref "Magic, p. 101"}
             {:name :tell-time, :prerequisites [], :college :knowledge, :ref "Magic, p. 100"}
             ;;{:name :test, :type :area :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 10"}
             {:name :test-load, :prerequisites [:measurement], :college :knowledge, :ref "Magic, p. 101"}
             ;;{:name :thaumatomancy, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 12"}
             {:name :trace, :prerequisites [:seeker], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 106"}
             ;;{:name :vision-of-doom, :prerequisites [[:skills/magery 3] :summon-shade], :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :water-vision, :prerequisites [:shape-water], :college :knowledge, :ref "Magic, p. 187"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-eye, :prerequisites [:apportation :keen-vision], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-nose, :prerequisites [:apportation :far-tasting], :college :knowledge, :ref "Magic, p. 104"}
             {:name :blackout, :prerequisites [:darkness], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :blur, :prerequisites [:darkness], :college :light-and-darkness, :ref "Basic Set p. 250}; Magic p. 113"}
             {:name :body-of-shadow, :prerequisites [[:skills/magery 2] :shape-darkness], :college :light-and-darkness, :ref "M114"}
             {:name :bright-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             ;;{:name :cleansing-light, :prerequisites [[:skills/magery 3] [10 :light-and-darkness] :flash :light-jet :sunbolt], :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             ;;{:name :coherent-light-jet, :prerequisites [:light-jet], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :colors, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :continual-light, :prerequisites [:light], :college :light-and-darkness, :ref "Basic Set p. 249}; Magic p. 110"}
             {:name :continual-mage-light, :prerequisites [:mage-light :continual-light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :continual-sunlight, :prerequisites [:sunlight], :college :light-and-darkness, :ref "Classic: Magic p 64/Magic, p. 114"}
             {:name :dark-vision, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :darkness, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Basic Set p. 250}; Magic p. 111"}
             {:name :disruption-bolt, :prerequisites [:spectrum-vision [6 :light-and-darkness] :radiation], :college :light-and-darkness, :ref "Technomancer p 24"}
             {:name :flash, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :gloom, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :glow, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             ;;{:name :goggles, :type :area :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :hawk-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :hide, :prerequisites [#{:blur :forgetfulness}], :college :light-and-darkness, :ref "Magic p. 113}; Fantasy, p. 170"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :college :light-and-darkness, :ref "Magic p. 105"}
             ;;{:name :infrared-flash, :prerequisites [:flash :colors], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :infravision, :prerequisites [#{:keen-vision [5 :light]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13]], :college :light-and-darkness, :ref "Magic p. 114}; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :invisible-sunbolt, :prerequisites [[:skills/magery 3] :spectrum-vision :sunbolt], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :light, :prerequisites [], :college :light-and-darkness, :ref "Basic Set p. 253}; Magic p. 110"}
             {:name :light-jet, :prerequisites [#{:continual-light :shape-light}], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :mage-light, :prerequisites [:mage-sight :light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :mass-invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :college :light-and-darkness, :ref "Magic Styles: Dungeon Magic, p. 32"}
             ;;{:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :college :light-and-darkness, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :mirror, :prerequisites [:colors], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :night-vision, :prerequisites [[5 :light-and-darkness] :keen-vision], :college :light-and-darkness, :ref "Magic p. 111}; Fantasy, p. 170"}
             ;;{:name :phosphorescence, :type :area :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :remove-reflection, :prerequisites [:remove-shadow], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :remove-shadow, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :see-invisible, :prerequisites [#{:dark-vision :infravision :invisibility}], :college :light-and-darkness, :ref "Magic p. 113"}
             ;;{:name :shadowplay, :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :shadow-slay, :prerequisites [[:skills/magery 3] :body-of-shadow :remove-shadow], :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :college :light-and-darkness, :ref "Magic p. 169"}
             {:name :shape-darkness, :prerequisites [:darkness], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shape-light, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :sunbolt, :prerequisites [:6-ligh [:darkness :sunlight]], :college :light-and-darkness, :ref "Magic p. 114"}
             ;;{:name :sunburst, :prerequisites [[:skills/magery 4] [10 :light-and-darkness] :sunbolt], :college :light-and-darkness, :ref "Magic: Artillery Spells p. 18"}
             {:name :sunlight, :prerequisites [[:skills/magery 1] :glow :colors], :college :light-and-darkness, :ref "Magic p. 114"}
             ;;{:name :twinkle, :type :area :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :wall-of-light, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :animate-object, :prerequisites [[:skills/magery 2] [3 :shape]], :college :making-and-breaking, :ref "Magic p. 117"}
             ;;{:name :annihilation, :prerequisites [[:skills/magery 3] :disintegrate #{:deathtouch :steal-vitality}], :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :clean, :prerequisites [:restore], :college :making-and-breaking, :ref "Magic p. 116}; Classic: Technomancer p 25"}
             {:name :contract-object, :prerequisites [[:skills/magery 3] :transform-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :copy, :prerequisites [:dye :1-written-language-at-accented], :college :making-and-breaking, :ref "Magic p. 116"}
             ;;{:name :destabilization, :prerequisites [[:skills/magery 3] :annihilation :explode], :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :disintegrate, :prerequisites [[:skills/magery 2] :shatter :ruin :earth-to-air :destroy-air :destroy-water], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :draw-together-shards, :prerequisites [:repair :trace :apportation], :college :making-and-breaking, :ref "Alphabet Arcane, p. 9"}
             {:name :dye, :prerequisites [:restore :colors], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :enlarge-object, :prerequisites [:extend-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :explode, :prerequisites [[:skills/magery 2] :shatter :apportation], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :explosive-mine, :prerequisites [[:skills/magery 3] :10-makin [:breaking :explode]], :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :extend-object, :prerequisites [[:skills/magery 3] :transform-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :fasten, :prerequisites [:knot], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :find-weakness, :prerequisites [:1-spell-from-each-of-4-elements], :college :making-and-breaking, :ref "Magic p. 116"}
             ;;{:name :immediate-action, :prerequisites [#{:apportation :find-weakness}], :college :making-and-breaking, :ref "Classic: Technomancer p. 25"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :college :making-and-breaking, :ref "Magic p. 97"}
             {:name :inspired-creation, :prerequisites [], :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :knot, :prerequisites [:stiffen], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :mapmaker, :prerequisites [:inscribe :measurement], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :minefield, :prerequisites [[:skills/magery 4] :explosive-mine], :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :mystic-mark, :prerequisites [:dye :trace], :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :rebuild, :prerequisites [[:skills/magery 3] :repair :create-object [:3-of-each-element]], :college :making-and-breaking, :ref "Magic p. 177"}
             {:name :rejoin, :prerequisites [:weaken :restore], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :repair, :prerequisites [[:skills/magery 2] :rejoin], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :reshape, :prerequisites [[:skills/magery 1] :weaken #{:shape-earth :shape-plant}], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :restore, :prerequisites [#{:find-weakness :simple-illusion}], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :rive, :prerequisites [[:skills/magery 2] :shatter], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :ruin, :prerequisites [[:skills/magery 1] :weaken :decay], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :self-repairing, :prerequisites [[:skills/magery 2] :repair], :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :sharpen, :prerequisites [:repair], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shatter, :prerequisites [[:skills/magery 1] :weaken], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :shatterproof, :prerequisites [:repair :shatter], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shrink-object, :prerequisites [:contract-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :soilproof, :prerequisites [:materialize], :college :making-and-breaking, :ref "Magic p. 116}; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :soul-creation, :prerequisites [:inspired-creation], :college :making-and-breaking, :ref "Classic: Magic Items 3 p. 31"}
             {:name :stiffen, :prerequisites [:rejoin], :college :making-and-breaking, :ref "Magic p. 117"}
             ;;{:name :tack, :type :area :prerequisites [], :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :toughen, :prerequisites [:shatterproof], :college :making-and-breaking, :ref "Magic p. 119"}
             ;;{:name :transfigure-object, :prerequisites [[:skills/magery 3] :transform-object], :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :transform-object, :prerequisites [:m2 :reshape [4 :create]], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :transparency, :prerequisites [:dye :stone-to-earth], :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :weaken, :prerequisites [:find-weakness], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :weapon-self, :prerequisites [[:skills/magery 2] :apportation :6-makin [:breaking :reshape]], :college :making-and-breaking, :ref "Magic p. 119"}
             ;;{:name :wizardly-workshop, :type :area :prerequisites [], :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :bless, :prerequisites [[:skills/magery 2] :2-each-from-10-colleges], :college :meta, :ref "Magic p. 129"}
             {:name :catch-spell, :prerequisites [[:skills/magery 2] [:attributes/dex 12] :return-missile], :college :meta, :ref "Magic p. 123"}
             ;;{:name :charge-powerstone, :prerequisites [[:skills/magery 3] :powerstone :lend-energy], :college :meta, :ref "Magic p. 126/Classic: Grimoire p. 74"}
             {:name :conceal-magic, :prerequisites [:detect-magic], :college :meta, :ref "Magic p. 122, Thaumatology: Urban Magics"}
             {:name :counterspell, :prerequisites [[:skills/magery 1] :spell-being-countered], :college :meta, :ref "Basic Set, p. 250}; Magic p. 121"}
             {:name :curse, :prerequisites [[:skills/magery 2] :2-each-from-10-colleges], :college :meta, :ref "Magic p. 129"}
             {:name :dispel-magic, :prerequisites [:counterspell [12 :other]], :college :meta, :ref "Basic Set, p. 250}; Magic p. 126"}
             ;;{:name :dispel-spark, :prerequisites [[:skills/magery 3] :drain-mana :remove-aura], :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :displace-spell, :prerequisites [:suspend-magic], :college :meta, :ref "Magic p. 124, Thaumatology: Urban Magics"}
             {:name :drain-magery, :prerequisites [[:skills/magery 3] :suspend-magery], :college :meta, :ref "Magic p. 130"}
             {:name :drain-mana, :prerequisites [:dispel-magic :suspend-mana], :college :meta, :ref "Magic p. 127"}
             ;;{:name :dread-curse, :prerequisites [[:skills/magery 3] :curse], :college :meta, :ref "Magic: Death Spells, p. 17"}
             ;;{:name :end-scene, :prerequisites [], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :false-aura, :prerequisites [:conceal-magic :aura], :college :meta, :ref "Magic p. 122"}
             {:name :great-ward, :prerequisites [[:skills/magery 2] :ward], :college :meta, :ref "Magic p. 122"}
             {:name :hang-spell, :prerequisites [:delay], :college :meta, :ref "Magic p. 128}; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
             ;;{:name :internalize-elixir, :prerequisites [[:skills/magery 1] :detect-magic :know-recipie], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 10"}
             {:name :lend-spell, :prerequisites [[:skills/magery 1] :lend-skill :1-spell-each-from-6-colleges], :college :meta, :ref "Magic p. 126"}
             ;;{:name :ley-buffer, :prerequisites [[:skills/magery 1] :ley-tap], :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             ;;{:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :college :meta, :ref "Thaumatology: Urban Magics, p. 21"}
             ;;{:name :ley-supply, :prerequisites [:ley-tap #{:lend-energy :minor-draw-power}], :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :magic-resistance, :prerequisites [[:skills/magery 1] :1-spell-each-from-7-colleges], :college :meta, :ref "Magic p. 123"}
             ;;{:name :mana-storm, :prerequisites [[:skills/magery 4] :drain-mana :restore-man], :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :mana-vortex, :prerequisites [[:skills/magery 2] :lend-energy :sense-danger], :college :meta, :ref "Magic Styles: Dungeon Magic, p. 27}; Thaumatology: Urban Magics"}
             {:name :maintain-spell, :prerequisites [:link], :college :meta, :ref "Magic p. 128}; Thaumatology: Urban Magics"}
             {:name :penetrating-spell, :prerequisites [:delay :find-weakness], :college :meta, :ref "Magic p. 123"}
             {:name :pentagram, :prerequisites [:spell-shield], :college :meta, :ref "Magic p. 124}; Thaumatology: Urban Magics"}
             ;;{:name :preemptive-experience, :prerequisites [], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             ;;{:name :punishment-circle, :prerequisites [[:skills/magery 3] #{:pentagram :repel-spirits}], :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :raise-cone-of-power, :prerequisites [:lend-energy #{:pentagram :restore-mana}], :college :meta, :ref "GURPS Thaumatology, p. 52"}
             {:name :reflect, :prerequisites [:ward], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics"}
             {:name :remove-aura, :prerequisites [:dispel-magic :aura], :college :meta, :ref "Magic p. 127"}
             {:name :remove-curse, :prerequisites [[:skills/magery 2] :1-spell-from-each-of-15-colleges], :college :meta, :ref "Magic p. 126}; Thaumatology: Urban Magics"}
             {:name :restore-mana, :prerequisites [:dispel-magic :suspend-mana], :college :meta, :ref "Magic p. 128}; Thaumatology: Urban Magics"}
             ;;{:name :scryfool, :prerequisites [[:skills/magery 2] :sense-observation :simple-illusion], :college :meta, :ref "Magic p. 123; Classic: Grimoire p 74"}
             {:name :scryguard, :prerequisites [[:skills/magery 1]], :college :meta, :ref "GURPS Fantasy, p. 170}; Thaumatology: Urban Magics"}
             {:name :scrywall, :prerequisites [:scryguard], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics, p. 33"}
             {:name :seek-magic, :prerequisites [:detect-magic], :college :meta, :ref "Magic p. 102"}
             ;;{:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :college :meta, :ref "Magic: Artillery Spells p. 23"}
             {:name :sovereign-countermagic, :prerequisites [[:skills/magery 3] :analyze-magic :dispel-magic], :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :sovereign-ward, :prerequisites [[:skills/magery 3] :dispel-magic :ward], :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :spell-shield, :prerequisites [[:skills/magery 2] :scryguard :magic-resistance], :college :meta, :ref "Magic p. 124"}
             {:name :spell-wall, :prerequisites [:spell-shield], :college :meta, :ref "Magic p. 124}; Thaumatology: Urban Magics"}
             {:name :spellguard, :prerequisites [:dispel-magic], :college :meta, :ref "Magic p. 127}; Thaumatology: Urban Magics"}
             {:name :steal-spell, :prerequisites [:lend-spell :great-ward], :college :meta, :ref "Magic p. 127"}
             {:name :suspend-curse, :prerequisites [[:skills/magery 1] :1-spell-each-from-12-colleges], :college :meta, :ref "Magic p. 125"}
             {:name :suspend-magery, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :college :meta, :ref "Magic p. 130"}
             {:name :suspend-magic, :prerequisites [:suspend-spell [8 :other]], :college :meta, :ref "Magic p. 123"}
             {:name :suspend-mana, :prerequisites [:suspend-magic :1-spell-each-from-10-colleges], :college :meta, :ref "Magic p. 125"}
             {:name :suspend-spell, :prerequisites [[:skills/magery 1]], :college :meta, :ref "Magic p. 121}; Thaumatology: Urban Magics"}
             {:name :telecast, :prerequisites [[:skills/magery 3] :teleport :wizard-eye :1-spell-each-from-10-colleges], :college :meta, :ref "Magic p. 128"}
             ;;{:name :thaumatomancy, :type :area :prerequisites [], :college :meta, :ref "Magic: The Least of Spells p. 12"}
             {:name :throw-spell, :prerequisites [:delay :catch-spell], :college :meta, :ref "Magic p. 128"}
             ;;{:name :use-item, :type :area :prerequisites [], :college :meta, :ref "Magic: The Least of Spells p. 12-13"}
             ;;{:name :void-bolt, :prerequisites [[:skills/magery 4] :4-essentials-taken-as-prerequisites [4 :missile]], :college :meta, :ref "Pyramid 3/25: Epic Magic, p. 19"}
             {:name :ward, :prerequisites [[:skills/magery 1]], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics"}
             {:name :air-jet, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] :1-spell-from-each-of-5-different-colleges-besides-air], :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :college :air, :ref "Basic Set p. 250}; Magic p. 189"}
             ;;{:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :cloud, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             ;;{:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             ;;{:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-missiles, :prerequisites [:electric-weapon], :college :air, :ref "Classic: Grimoire p 27"}
             ;;{:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Classic: Grimoire p 28"}
             ;;{:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [[6 :air]], :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :college :air, :ref "Magic: Artillery Spells p. 9"}
             ;;{:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :college :air, :ref "Magic: Artillery Spells p. 25"}
             ;;{:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :college :air, :ref "Magic: Artillery Spells p. 29"}
             ;;{:name :jolt, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :other]], :college :air, :ref "Basic Set p. 244}; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :mighty-breath, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :mass-resist-lightning, :prerequisites [[:attributes/int 13]  :resist-lightning], :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :college :air, :ref "Magic p. 24"}
             ;;{:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             ;;{:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             ;;{:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :college :air, :ref "Basic Set p. 243}; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :college :air, :ref "Basic Set p. 243}; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :college :air, :ref "Magic p. 195}; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :college :air, :ref "Magic p. 196"}
             ;;{:name :safe-boarding, :prerequisites [[8 :second-level]], :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :college :air, :ref "Magic p. 23"}
             ;;{:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :college :air, :ref "Basic Set p. 243}; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :college :air, :ref "Magic p. 196"}
             ;;{:name :static-charge, :prerequisites [:purify-air-+-1-other-air-spell], :college :air, :ref "Classic: Technomancer p 17"}
             ;;{:name :steal-breath, :prerequisites [[:skills/magery 3] :any [7 :air] :devitalize-air], :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :college :air, :ref "Basic Set p. 244}; Magic p. 23"}
             ;;{:name :stinkguard, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :college :air, :ref "Magic p. 195"}
             ;;{:name :storm-shelter, :type :area :prerequisites [], :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :air] [4 :air]} :another-summon-elemental-spell], :college :air, :ref "Magic p. 27"}
             ;;{:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :college :air, :ref "Basic Set p. 243}; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :college :air, :ref "Magic p. 25"}
             ;;{:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [:beast-summoning [2 :seek] :or-seeker], :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :call, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :creeping-plague, :prerequisites [[:skills/magery 5] :beast-summoning #{:vermin-control [:skills/magery 4]} :create-animal], :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting] [10 :other]], :college :animal, :ref "Magic p. 34"}
             ;;{:name :groom, :type :area :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :hybrid-control, :prerequisites [[2 :animal]], :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             ;;{:name :insect-repellent, :prerequisites [], :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :college :animal, :ref "Magic p. 30"}
             ;;{:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] :2-shapeshift-other :2-body-control :2-animal-control], :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :appropriate-shapeshifting], :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdo  :animal], :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:the-appropriate-animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :appropriate-shapeshifting], :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :other]], :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :college :animal, :ref "Magic p. 32"}
             ;;{:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :any-one-shapeshift-others-spell], :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :college :body-control, :ref "Spell: Bio-Tech, p. 30}; Item: Classic: Technomancer pg 17"}
             ;;{:name :ache, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :analgesic, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :belch, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :birth-control, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :blend-in, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :college :body-control, :ref "Magic, p. 40}; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :other]], :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :spell-used-in-missile], :college :body-control, :ref "Classic: Magic p 24"}
             ;;{:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch :choke :entombment :rotting-death :curse-evisceration :steal-beauty :deathtouch :frostbite :steal-skill :dehydrate :pestilence :stop-healing], :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             ;;{:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :college :body-control, :ref "Basic Set, p. 245}; Magic, p. 41"}
             {:name :debility, :prerequisites [], :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             ;;{:name :diver's-blessing, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :college :body-control, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ease-labor, :prerequisites [:lend-vitality], :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             ;;{:name :eat-crow, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :elvish-grace, :prerequisites [:clumsiness], :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :college :body-control, :ref "Magic, p. 43}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :college :body-control, :ref "Classic: Technomancer p. 17"}
             ;;{:name :flexibility, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :other]], :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :college :body-control, :ref "Magic, p. 42}; b: Classic Grimoire p. 18"}
             ;;{:name :ley-running, :prerequisites [:seek-ley-line :haste], :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :college :body-control, :ref "Magic, p. 39"}
             ;;{:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 35"}
             ;;{:name :stand-out, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :strike-anosmic, :prerequisites [:spasm], :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :stifle, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-ligh  :darkness], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :college :body-control, :ref "Magic, p. 38"}
             ;;{:name :throw-voice, :type :area :prerequisites [], :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :college :body-control, :ref "Magic, p. 35"}
             ;;{:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object], :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :college :body-control, :ref "Magic, p. 37"}
             ;;{:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :college :body-control, :ref "Basic Set, p. 244}; Magic, p. 40"}
             ;;{:name :absorb-book, :prerequisites [#{[:attributes/int 13] :gift-of-letters}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             ;;{:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             ;;{:name :ack, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             ;;{:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :college :communication-and-empathy, :ref "Magic, p. 46"}
             ;;{:name :borrow-number, :prerequisites [:seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :delete-commercia, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :college :communication-and-empathy, :ref "Magic p. 49"}
             ;;{:name :drama, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language #{:3-languages-written-at-accented :better}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language #{:3-languages-spoken-at-accented :better}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46"}
             ;;{:name :identify-caller, :prerequisites [:mind-reading :seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             ;;{:name :illuminated-writing, :prerequisites [[:skills/magery 2] :one-of-mind-sending :fascinate [:or-writing 12]], :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :college :communication-and-empathy, :ref "Magic, p. 176"}
             ;;{:name :magic-switchboard, :prerequisites [:identify-caller], :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :college :communication-and-empathy, :ref "Magic, p. 173"}
             ;;{:name :mer-speech, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 47}; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy], :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47"}
             ;;{:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :sorcerous-signal, :type :area :prerequisites [], :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :college :communication-and-empathy, :ref "Magic, p. 49"}
             ;;{:name :speed-data, :prerequisites [[:world/tl 7] :haste :lightning], :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :college :communication-and-empathy, :ref "4e spell chart"}
             ;;{:name :telepathic-overload, :prerequisites [[:skills/magery 3] :any-10-communicatio [:empathy :telepathy]], :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :college :communication-and-empathy, :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Basic Set, p. 245}; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :college :communication-and-empathy, :ref "Magic, p. 45"}
             ;;{:name :wrong-number, :prerequisites [[:world/tl 6] :sense-foes :seek-number], :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             ;;{:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             ;;{:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-water :shape-fire :shape-air :shape-stone], :college :earth, :ref "Magic, p. 55"}
             ;;{:name :badger-paws, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :college :earth, :ref "Magic, p. 54"}
             ;;{:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :college :earth, :ref "Magic, p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :college :earth, :ref "Magic, p. 22"}
             ;;{:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :college :earth, :ref "Basic Set, p. 243}; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :college :earth, :ref "Magic, p. 51}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :college :earth, :ref "Magic, p. 53}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             ;;{:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             ;;{:name :gargoyle-skin, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             ;;{:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :college :earth, :ref "Magic, p. 52"}
             ;;{:name :pebble, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :college :earth, :ref "Magic, p. 54}; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :college :earth, :ref "Magic, p. 53"}
             ;;{:name :sand-blast, :prerequisites [[:skills/magery 4] :s :jet :s :storm], :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :college :earth, :ref "Magic, p. 51"}
             ;;{:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :college :earth, :ref "Basic Set, p. 245}; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :other]], :college :earth, :ref "Fantasy, p. 169"}
             ;;{:name :spotless-hands, :type :area :prerequisites [], :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :college :earth, :ref "Magic, p. 54}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :college :earth, :ref "Basic Set, p. 246}; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :earth] [4 :earth]} :another-summon-elemental-spell], :college :earth, :ref "Magic, p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :college :earth, :ref "Magic, p. 52}; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :college :enchantment, :ref "Magic p. 58}; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman-for-the-appropriate-spell], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             ;;{:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             ;;{:name :doom-wish, :prerequisites [[:skills/magery 3] :wish :iq-+-magery-of-23+], :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :college :enchantment, :ref "Magic p. 62}; Classic: Magic p 40"}
             ;;{:name :dwarfish-reinforcement, :prerequisites [:enchant], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             ;;{:name :electric-power, :prerequisites [:lend-power :power :steal-power], :college :enchantment, :ref "Classic: Technomancer p. 20"}
             ;;{:name :emergency-staff, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] :one-spell-from-10-other-colleges], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :college :enchantment, :ref "Magic p. 66}; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  :five-communicatio  :empathy], :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             ;;{:name :live-libram, :prerequisites [:enchant :apportation], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :magician's-minion, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             ;;{:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :college :enchantment, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             ;;{:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :college :enchantment, :ref "Basic Set, p. 480}; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             ;;{:name :resilient-golem, :prerequisites [:golem :shatterproof], :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [:any-limiting-enchantment-spell], :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] #{:1-written-language-at-accented :better}], :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :sorcerer's-stand-in, :type :area :prerequisites [], :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :college :enchantment, :ref "Magic p. 60"}
             ;;{:name :spellbook-enchantment, :prerequisites [:scroll], :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             ;;{:name :spellgraft, :prerequisites [:enchant], :college :enchantment, :ref "Bio-Tech, p. 32"}
             ;;{:name :spellprocessor, :prerequisites [:scroll [:computer-programming 15]], :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant :spell-to-be-opposed], :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :college :enchantment, :ref "Magic p. 56}; Fantasy, p. 23"}
             ;;{:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :college :enchantment, :ref "Magic p. 61"}
             ;;{:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :college :fire, :ref "Magic p. 28"}
             ;;{:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :college :fire, :ref "Magic p. 22"}
             ;;{:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 73"}
             ;;{:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :ember, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :college :fire, :ref "Basic Set, p. 247}; Magic p. 75"}
             ;;{:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :college :fire, :ref "Magic p. 75"}
             ;;{:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Magic p. 73"}
             ;;;; {:name :flameturning, :prerequisites [:resist-fire :or-both-apportation :shape-fire], :college :fire, :ref "Classic: Grimoire p. 30"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :college :fire, :ref "Magic p. 75"}
             ;;{:name :great-deflect-energy, :prerequisites [[:skills/magery 2]  :deflect-energy], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             ;;{:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             ;;{:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             ;;{:name :mass-detonate, :prerequisites [:detonate], :college :fire, :ref "Classic: Technomancer p. 21"}
             ;;{:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             ;;{:name :oven-mitts, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :college :fire, :ref "Magic p. 73"}
             ;;{:name :puff, :type :area :prerequisites [], :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :college :fire, :ref "Magic p. 74}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :college :fire, :ref "Basic Set, p. 247}; Magic p. 74"}
             ;;{:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :college :fire, :ref "Classic: Technomancer p 21"}
             ;;{:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :college :fire, :ref "Basic Set, p. 246}; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :college :fire, :ref "Magic p. 73"}
             ;;{:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :fire] [4 :fire]} :another-summon-elemental-spell], :college :fire, :ref "Magic p. 27"}
             ;;{:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             ;;{:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :college :fire, :ref "Magic p. 74"}
             {:name :accelerate-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-each-from-10-colleges], :college :gate, :ref "Magic p. 86"}
             {:name :beacon, :prerequisites [:teleport :timeport :or-plane-shift], :college :gate, :ref "Magic p. 83}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :blink, :prerequisites [:teleport], :college :gate, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :college :gate, :ref "Magic p. 148"}
             {:name :control-gate, :prerequisites [[:skills/magery 3] :seek-gate], :college :gate, :ref "Magic p. 85"}
             {:name :create-door, :prerequisites [:teleport :any-1-walk-through-spell], :college :gate, :ref "Magic p. 84"}
             ;;{:name :create-gate, :prerequisites [:control-gate :teleport :timeport :or-plane-shift], :college :gate, :ref "Magic p. 85/Classic: Grimoire p 50"}
             ;;{:name :dimensional-dissection, :prerequisites [[:skills/magery 3] :one-of-plane-shift-other :teleport-other :or-timeport-other], :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :college :gate, :ref "Magic p. 84"}
             ;;{:name :easy-rider, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :hell-zone, :prerequisites [[:skills/magery 4] :beacon :planar-summons-for], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :hide-object, :prerequisites [:hideaway :teleport], :college :gate, :ref "Magic p. 86"}
             ;;{:name :invoke, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 14-15"}
             ;;{:name :null-sphere, :prerequisites [[:skills/magery 5] :create-gate], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :phase, :prerequisites [[:skills/magery 3] #{:plane-shift :ethereal-body}], :college :gate, :ref "Magic p. 83"}
             {:name :phase-other, :prerequisites [:phase], :college :gate, :ref "Magic p. 83"}
             {:name :planar-summons, :prerequisites [[:skills/magery 1] :1-spell-from-10-other-colleges], :college :gate, :ref "Basic Set p. 247}; Magic p. 82"}
             {:name :planar-visit, :prerequisites [[:skills/magery 2] #{:projection :planar-summons}], :college :gate, :ref "Magic p. 82"}
             {:name :plane-shift, :prerequisites [:planar-summons], :college :gate, :ref "Basic Set p. 247}; Magic p. 83"}
             {:name :plane-shift-other, :prerequisites [[:skills/magery 3] :plane-shift], :college :gate, :ref "Magic p. 83"}
             {:name :rapid-journey, :prerequisites [[:skills/magery 3] #{:teleport :timeport}], :college :gate, :ref "Magic p. 82"}
             ;;{:name :reorient, :type :area :prerequisites [], :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :sanctuary, :prerequisites [:hide-object], :college :gate, :ref "Magic p. 86"}
             {:name :scry-gate, :prerequisites [:seek-gate], :college :gate, :ref "Magic p. 85"}
             {:name :seek-gate, :prerequisites [[:skills/magery 2] :seek-magic :1-spell-from-each-of-10-colleges], :college :gate, :ref "Magic p. 85"}
             {:name :slow-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-from-each-of-10-colleges], :college :gate, :ref "Magic p. 86"}
             ;;{:name :splat, :prerequisites [[:skills/magery 4] :create-door], :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :suspend-time, :prerequisites [[:skills/magery 3] :slow-time], :college :gate, :ref "Magic p. 86"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :college :gate, :ref "Magic p. 147}; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:skills/magery 3] :teleport], :college :gate, :ref "Magic p. 147"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :college :gate, :ref "Magic p. 170"}
             {:name :time-out, :prerequisites [[:skills/magery 3] :accelerate-time], :college :gate, :ref "Magic p. 87"}
             {:name :timeport, :prerequisites [[:skills/magery 3] :teleport], :college :gate, :ref "Magic p. 81"}
             {:name :timeport-other, :prerequisites [:timeport], :college :gate, :ref "Magic p. 81"}
             {:name :timeslip, :prerequisites [:timeport], :college :gate, :ref "Magic p. 81"}
             {:name :timeslip-other, :prerequisites [:timeslip], :college :gate, :ref "Magic p. 81"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :college :gate, :ref "Magic p. 84"}
             ;;{:name :underworld-imprisonment, :prerequisites [[:skills/magery 3] :one-plane-shift-other-spell], :college :gate, :ref "Magic: Death Spells, p. 13"}
             ;;{:name :aid, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :aide, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :analgesic, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :archmagi's-recuperation, :prerequisites [[:attributes/int 14] [:skills/magery 4] :lend-energy], :college :healing, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :awaken, :prerequisites [:lend-vitality], :college :healing, :ref "Basic Set, p. 248}; Magic p. 90"}
             ;;{:name :bender-defender, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :birth-control, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :body-reading, :prerequisites [#{:sense-life :awaken}], :college :healing, :ref "Magic p. 91"}
             {:name :cleansing, :prerequisites [:minor-healing :purify-earth], :college :healing, :ref "Magic p. 94"}
             ;;{:name :cure-addiction, :prerequisites [:relieve-addiction], :college :healing, :ref "Classic: Grimoire p. 55"}
             ;;{:name :cure-dehydration, :prerequisites [[:skills/magery 1] :minor-healing :create-water], :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :cure-disease, :prerequisites [:major-healing :relieve-sickness], :college :healing, :ref "Magic p. 91}; Fantasy, p. 170"}
             ;;{:name :cure-insanity, :prerequisites [:major-healing :relieve-madness [5 :mind]], :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-radiation, :prerequisites [:resist-radiation :major-healing], :college :healing, :ref "Magic p. 182"}
             ;;{:name :cure-starvation, :prerequisites [[:skills/magery 1] :minor-healing :create-food], :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :detect-poison, :prerequisites [#{:sense-danger :test-food}], :college :healing, :ref "Magic p. 166"}
             ;;{:name :disinfect, :prerequisites [[:skills/magery 4] [10 :healing] :cure-disease :remove-contagion], :college :healing, :ref "Magic: Artillery Spells p. 17"}
             ;;{:name :ease-labor, :prerequisites [:lend-vitality], :college :healing, :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
             ;;{:name :euthanize, :prerequisites [[1 :empathy] [:skills/magery 1] :spirit-empathy], :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :final-rest, :prerequisites [#{[:skills/magery 1] :spirit-empathy}], :college :healing, :ref "Magic p. 89"}
             {:name :great-healing, :prerequisites [[:skills/magery 3] :major-healing], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             {:name :halt-aging, :prerequisites [[:skills/magery 2] [8 :healing]], :college :healing, :ref "Magic p. 94"}
             {:name :healing-slumber, :prerequisites [[:skills/magery 2] :sleep :minor-healing], :college :healing, :ref "Magic p. 94"}
             {:name :instant-neutralize-poison, :prerequisites [[:skills/magery 2] :neutralize-poison], :college :healing, :ref "Magic p. 92"}
             {:name :instant-regeneration, :prerequisites [[:skills/magery 3] :regeneration], :college :healing, :ref "Magic p. 93"}
             {:name :instant-restoration, :prerequisites [[:skills/magery 2] :restoration], :college :healing, :ref "Magic p. 93"}
             {:name :lend-energy, :prerequisites [#{[:skills/magery 1] :empathy}], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :lend-vitality, :prerequisites [:lend-energy], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :major-healing, :prerequisites [[:skills/magery 1] :minor-healing], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             ;;{:name :mass-resist-disease, :prerequisites [[:attributes/int 13]  :resist-disease], :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             ;;{:name :mass-resist-poison, :prerequisites [[:attributes/int 13]  :resist-poison], :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :minor-healing, :prerequisites [:lend-vitality], :college :healing, :ref "Basic Set, p. 248}; Magic p. 91"}
             {:name :neutralize-poison, :prerequisites [#{:cure-disease [:skills/magery 3]} :test-food], :college :healing, :ref "Magic p. 92"}
             {:name :recover-energy, :prerequisites [[:skills/magery 1] :lend-energy], :college :healing, :ref "Basic Set, p. 248}; Magic p. 89"}
             {:name :regeneration, :prerequisites [[:skills/magery 2] :restoration], :college :healing, :ref "Magic p. 93"}
             {:name :relieve-addiction, :prerequisites [:neutralize-poison], :college :healing, :ref "Magic p. 92|-"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :college :healing, :ref "Magic p. 92"}
             {:name :relieve-paralysis, :prerequisites [:stop-paralysis], :college :healing, :ref "Magic p. 93"}
             {:name :relieve-sickness, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 90"}
             {:name :remove-contagion, :prerequisites [:decay :clean :or-cure-disease], :college :healing, :ref "Magic p. 90"}
             ;;{:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :healing, :ref "Bio-Tech, p. 32; Technomancer p. 22"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :college :healing, :ref "Magic p. 90"}
             {:name :resist-poison, :prerequisites [:vigor], :college :healing, :ref "Magic p. 91"}
             {:name :restoration, :prerequisites [:major-healing :relieve-paralysis :restore], :college :healing, :ref "Magic p. 93"}
             {:name :restore-hearing, :prerequisites [:minor-healing #{:keen-hearing :strike-deaf}], :college :healing, :ref "Magic p. 92"}
             {:name :restore-memory, :prerequisites [:awaken [:iq 11]], :college :healing, :ref "Magic p. 92"}
             {:name :restore-sight, :prerequisites [:minor-healing #{:keen-vision :strike-blind}], :college :healing, :ref "Magic p. 92"}
             {:name :restore-speech, :prerequisites [:minor-healing #{:great-voice :strike-dumb}], :college :healing, :ref "Magic p. 93"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :college :healing, :ref "Magic p. 94"}
             ;;{:name :resuscitate, :prerequisites [[:skills/magery 2] :awaken :stop-spasm], :college :healing, :ref "Magic: Death Spells, p. 14"}
             ;;{:name :sea-legs, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 17"}
             ;;{:name :sense-disease, :prerequisites [#{:sense-life [2 :healing]}], :college :healing, :ref "Bio-Tech, p. 32; Technomaner p 22"}
             {:name :share-energy, :prerequisites [:lend-energy], :college :healing, :ref "Magic p. 89"}
             {:name :share-vitality, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 90"}
             {:name :stop-bleeding, :prerequisites [:lend-vitality], :college :healing, :ref "Magic p. 91}; Fantasy, p. 169"}
             {:name :stop-paralysis, :prerequisites [:minor-healing :paralyze-limb :or-strike-dumb], :college :healing, :ref "Magic p. 93"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :college :healing, :ref "Magic p. 35"}
             {:name :suspended-animation, :prerequisites [:sleep [4 :healing]], :college :healing, :ref "Magic p. 94"}
             ;;{:name :test, :prerequisites [], :college :healing, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :healing, :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
             {:name :transference-bolt, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :college :healing, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :youth, :prerequisites [[:skills/magery 3] :halt-aging], :college :healing, :ref "Magic p. 94"}
             ;;{:name :blend-in, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :complex-illusion, :prerequisites [:sound :simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :control-creation, :prerequisites [#{:create-animal :create-servant}], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :control-illusion, :prerequisites [:perfect-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :create-animal, :prerequisites [:create-water :create-object [:attributes/int 12]], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :create-foreign-body, :prerequisites [[:skills/magery 3] :body-reading :create-object], :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :create-mount, :prerequisites [[:skills/magery 3] :create-animal], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :create-object, :prerequisites [[:skills/magery 2] :create-earth :perfect-illusion], :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-servant, :prerequisites [[:skills/magery 3] [:attributes/int 12] :create-object], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :create-trap, :prerequisites [[:skills/magery 4] [10 :illusion-and-create]], :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17"}
             {:name :create-warrior, :prerequisites [:create-servant], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :disbelieve, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :dispel-creation, :prerequisites [:control-creation], :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :dispel-illusion, :prerequisites [:control-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :duplicate, :prerequisites [:create-object :copy], :college :illusion-and-creation, :ref "Magic p. 98"}
             ;;{:name :gargoyle-skin, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 8"}
             {:name :illusion-disguise, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170"}
             {:name :illusion-shell, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :image, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :independence, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 96"}
             {:name :initiative, :prerequisites [:independence :wisdom], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :know-illusion, :prerequisites [:simple-illusion], :college :illusion-and-creation, :ref "Magic p. 97"}
             ;;{:name :mirror, :prerequisites [[:skills/magery 4] :initiative :phantom], :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17-18"}
             {:name :perfect-illusion, :prerequisites [[:skills/magery 1] :complex-illusion], :college :illusion-and-creation, :ref "Magic p. 96}; 'Social Engineering: Back to School, p. 24"}
             {:name :phantom, :prerequisites [[:skills/magery 2] :perfect-illusion :hinder :apportation], :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :college :illusion-and-creation, :ref "Magic p. 73"}
             ;;{:name :phantom-killer, :prerequisites [[:skills/magery 3] :phantom], :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             ;;{:name :shadowplay, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :simple-illusion, :prerequisites [:no-blindness [:iq 11]], :college :illusion-and-creation, :ref "Magic p. 95}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             ;;{:name :stand-out, :prerequisites [], :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :air-vision, :prerequisites [:shape-air], :college :knowledge, :ref "Magic, p. 24"}
             {:name :alarm, :prerequisites [:tell-time], :college :knowledge, :ref "Magic, p. 100"}
             {:name :analyze-magic, :prerequisites [:identify-spell], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 102"}
             ;;{:name :analyze-heredity, :prerequisites [#{:seeker :sense-life}], :college :knowledge, :ref "Bio-Tech, p. 30; Technomancer p 23"}
             {:name :ancient-history, :prerequisites [:history], :college :knowledge, :ref "Magic, p. 106"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :college :knowledge, :ref "Magic, p. 105"}
             {:name :aura, :prerequisites [:detect-magic], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 101"}
             {:name :detect-magic, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 101"}
             {:name :divination, :prerequisites [:skills/history], :college :knowledge, :ref "Magic, p. 108}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-vision, :prerequisites [:shape-earth], :college :knowledge, :ref "Magic, p. 51"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :college :knowledge, :ref "Magic, p. 107"}
             {:name :far-feeling, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Magic, p. 100"}
             {:name :far-hearing, :prerequisites [[:skills/magery 1] [4 :sound]], :college :knowledge, :ref "Magic, p. 173"}
             {:name :far-tasting, :prerequisites [[:skills/magery 1] #{:seek-food :seek-air}], :college :knowledge, :ref "Magic, p. 77"}
             {:name :find-direction, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Magic, p. 101"}
             ;;{:name :forbidden-wisdom, :prerequisites [[:skills/magery 3] :recall :see-secrets], :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :glass-wall, :prerequisites [#{[5 :knowledge] :earth-vision}], :college :knowledge, :ref "Magic, p. 103"}
             {:name :history, :prerequisites [:trace], :college :knowledge, :ref "Magic, p. 104"}
             ;;{:name :identify-loot, :prerequisites [[:skills/magery 2]  [7 :fourth-level]], :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :identify-spell, :prerequisites [:detect-magic], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 102"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :college :knowledge, :ref "Magic, p. 105"}
             {:name :invisible-wizard-eye, :prerequisites [:wizard-eye :invisibility], :college :knowledge, :ref "Magic, p. 104"}
             ;;{:name :keyfinder, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-location, :prerequisites [[:skills/magery 1] :tell-position], :college :knowledge, :ref "Magic, p. 103"}
             {:name :know-recipe, :prerequisites [:far-tasting :season], :college :knowledge, :ref "Magic, p. 78"}
             ;;{:name :know-thyself, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-true-shape, :prerequisites [[:skills/magery 1] [1 :shifting] #{:aura :know-illusion}], :college :knowledge, :ref "Magic, p. 104"}
             {:name :mage-sense, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             {:name :mage-sight, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             {:name :measurement, :prerequisites [], :college :knowledge, :ref "Magic, p. 100"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :college :knowledge, :ref "Magic, p. 105}; Social Engineering: Back to School, p. 24"}
             {:name :metal-vision, :prerequisites [:shape-metal], :college :knowledge, :ref "Magic, p. 183"}
             {:name :mind-over-matter, :prerequisites [[:skills/magery 2] :divination], :college :knowledge, :ref "Magic Styles: Dungeon Magic, p. 27"}
             {:name :necrovision, :prerequisites [:lightning :seek-emitter], :college :knowledge, :ref "Technomancer p 23"}
             {:name :pathfinder, :prerequisites [[:skills/magery 1] [:attributes/int 12]], :college :knowledge, :ref "Magic, p. 105"}
             {:name :plant-vision, :prerequisites [:shape-plant], :college :knowledge, :ref "Magic, p. 162"}
             {:name :plastic-vision, :prerequisites [:shape-plastic], :college :knowledge, :ref "Magic, p. 183"}
             {:name :prehistory, :prerequisites [:ancient-history], :college :knowledge, :ref "Magic, p. 104"}
             {:name :projection, :prerequisites [:sense-spirit [4 :knowledge]], :college :knowledge, :ref "Magic, p. 105"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :college :knowledge, :ref "Magic, p. 104"}
             {:name :reconstruct-spell, :prerequisites [[:skills/magery 2] :history :identify-spell], :college :knowledge, :ref "Magic, p. 104"}
             {:name :remember-path, :prerequisites [:find-direction :memorize], :college :knowledge, :ref "Magic, p. 105"}
             ;;{:name :retro-reading, :prerequisites [:trace], :college :knowledge, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :scents-of-the-past, :prerequisites [[:skills/magery 2] :history :odor], :college :knowledge, :ref "Magic, p. 107"}
             {:name :schematic, :prerequisites [:reveal-function :history], :college :knowledge, :ref "Magic, p. 177"}
             {:name :see-secrets, :prerequisites [:seeker :aura], :college :knowledge, :ref "Magic, p. 105}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :seek-ley-line, :prerequisites [[:skills/magery 1]], :college :knowledge, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :seek-magic, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 102"}
             ;;{:name :seek-navy, :prerequisites [[8 :third-level]], :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] :world/tl-6+], :college :knowledge, :ref "Technomancer p. 18"}
             {:name :seeker, :prerequisites [[:skills/magery 1] [:attributes/int 12]], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 105"}
             {:name :sense-mana, :prerequisites [:detect-magic], :college :knowledge, :ref "Magic, p. 101"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :knowledge, :ref "Magic, p. 111"}
             {:name :summon-shade, :prerequisites [#{:summon-spirit :divination}], :college :knowledge, :ref "Magic, p. 102"}
             ;;{:name :sweet-oblivion, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :televisomancy, :prerequisites [[:skills/magery 1] #{[6 :technological] :electronics-operation-communications-15+}], :college :knowledge, :ref "Classic: Technomancer p 23"}
             {:name :tell-position, :prerequisites [:measurement], :college :knowledge, :ref "Magic, p. 101"}
             {:name :tell-time, :prerequisites [], :college :knowledge, :ref "Magic, p. 100"}
             ;;{:name :test, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 10"}
             {:name :test-load, :prerequisites [:measurement], :college :knowledge, :ref "Magic, p. 101"}
             ;;{:name :thaumatomancy, :prerequisites [], :college :knowledge, :ref "Magic: The Least of Spells p. 12"}
             {:name :trace, :prerequisites [:seeker], :college :knowledge, :ref "Basic Set, p. 249}; Magic, p. 106"}
             ;;{:name :vision-of-doom, :prerequisites [[:skills/magery 3] :summon-shade], :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :water-vision, :prerequisites [:shape-water], :college :knowledge, :ref "Magic, p. 187"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-eye, :prerequisites [:apportation :keen-vision], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-nose, :prerequisites [:apportation :far-tasting], :college :knowledge, :ref "Magic, p. 104"}
             {:name :blackout, :prerequisites [:darkness], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :blur, :prerequisites [:darkness], :college :light-and-darkness, :ref "Basic Set p. 250}; Magic p. 113"}
             {:name :body-of-shadow, :prerequisites [[:skills/magery 2] :shape-darkness], :college :light-and-darkness, :ref "M114"}
             {:name :bright-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             ;;{:name :cleansing-light, :prerequisites [[:skills/magery 3] :10-ligh [:darkness :flash] :light-jet :sunbolt], :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             ;;{:name :coherent-light-jet, :prerequisites [:light-jet], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :colors, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :continual-light, :prerequisites [:light], :college :light-and-darkness, :ref "Basic Set p. 249}; Magic p. 110"}
             {:name :continual-mage-light, :prerequisites [:mage-light :continual-light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :continual-sunlight, :prerequisites [:sunlight], :college :light-and-darkness, :ref "Classic: Magic p 64/Magic, p. 114"}
             {:name :dark-vision, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :darkness, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Basic Set p. 250}; Magic p. 111"}
             {:name :disruption-bolt, :prerequisites [:spectrum-vision [6 :light-and-darkness]], :college :light-and-darkness, :ref "Technomancer p 24"}
             {:name :flash, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :gloom, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :glow, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 112"}
             ;;{:name :goggles, :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :hawk-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :hide, :prerequisites [#{:blur :forgetfulness}], :college :light-and-darkness, :ref "Magic p. 113}; Fantasy, p. 170"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :college :light-and-darkness, :ref "Magic p. 105"}
             ;;{:name :infrared-flash, :prerequisites [:flash :colors], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :infravision, :prerequisites [#{:keen-vision [5 :light]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :invisibility], :college :light-and-darkness, :ref "Magic p. 114}; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             ;;{:name :invisible-sunbolt, :prerequisites [[:skills/magery 3] :spectrum-vision :sunbolt], :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :light, :prerequisites [], :college :light-and-darkness, :ref "Basic Set p. 253}; Magic p. 110"}
             {:name :light-jet, :prerequisites [#{:continual-light :shape-light}], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :mage-light, :prerequisites [:mage-sight :light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :mass-invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :college :light-and-darkness, :ref "Magic Styles: Dungeon Magic, p. 32"}
             ;;{:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :college :light-and-darkness, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :mirror, :prerequisites [:colors], :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :night-vision, :prerequisites [5 :light-and-darkness], :college :light-and-darkness, :ref "Magic p. 111}; Fantasy, p. 170"}
             ;;{:name :phosphorescence, :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :remove-reflection, :prerequisites [:remove-shadow], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :remove-shadow, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :see-invisible, :prerequisites [:dark-vision :infravision :or-invisibility], :college :light-and-darkness, :ref "Magic p. 113"}
             ;;{:name :shadowplay, :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :shadow-slay, :prerequisites [[:skills/magery 3] :body-of-shadow :remove-shadow], :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :college :light-and-darkness, :ref "Magic p. 169"}
             {:name :shape-darkness, :prerequisites [:darkness], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shape-light, :prerequisites [:light], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :sunbolt, :prerequisites [:6-ligh [:darkness :sunlight]], :college :light-and-darkness, :ref "Magic p. 114"}
             ;;{:name :sunburst, :prerequisites [[:skills/magery 4] [10 :light-and-darkness] :sunbolt], :college :light-and-darkness, :ref "Magic: Artillery Spells p. 18"}
             {:name :sunlight, :prerequisites [[:skills/magery 1] :glow :colors], :college :light-and-darkness, :ref "Magic p. 114"}
             ;;{:name :twinkle, :prerequisites [], :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :wall-of-light, :prerequisites [:continual-light], :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :animate-object, :prerequisites [[:skills/magery 2] [3 :shape]], :college :making-and-breaking, :ref "Magic p. 117"}
             ;;{:name :annihilation, :prerequisites [[:skills/magery 3] :disintegrate #{:deathtouch :steal-vitality}], :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :clean, :prerequisites [:restore], :college :making-and-breaking, :ref "Magic p. 116}; Classic: Technomancer p 25"}
             {:name :contract-object, :prerequisites [[:skills/magery 3] :transform-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :copy, :prerequisites [:dye :1-written-language-at-accented], :college :making-and-breaking, :ref "Magic p. 116"}
             ;;{:name :destabilization, :prerequisites [[:skills/magery 3] :annihilation :explode], :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :disintegrate, :prerequisites [[:skills/magery 2] :shatter :ruin :earth-to-air :destroy-air :destroy-water], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :draw-together-shards, :prerequisites [:repair :trace :apportation], :college :making-and-breaking, :ref "Alphabet Arcane, p. 9"}
             {:name :dye, :prerequisites [:restore :colors], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :enlarge-object, :prerequisites [:extend-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :explode, :prerequisites [[:skills/magery 2] :shatter :apportation], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :explosive-mine, :prerequisites [[:skills/magery 3] :10-makin [:breaking :explode]], :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :extend-object, :prerequisites [[:skills/magery 3] :transform-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :fasten, :prerequisites [:knot], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :find-weakness, :prerequisites [:1-spell-from-each-of-4-elements], :college :making-and-breaking, :ref "Magic p. 116"}
             ;;{:name :immediate-action, :prerequisites [#{:apportation :find-weakness}], :college :making-and-breaking, :ref "Classic: Technomancer p. 25"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :college :making-and-breaking, :ref "Magic p. 97"}
             {:name :inspired-creation, :prerequisites [], :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :knot, :prerequisites [:stiffen], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :mapmaker, :prerequisites [:inscribe :measurement], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :minefield, :prerequisites [[:skills/magery 4] :explosive-mine], :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :mystic-mark, :prerequisites [:dye :trace], :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :rebuild, :prerequisites [[:skills/magery 3] :repair :create-object [:3-of-each-element]], :college :making-and-breaking, :ref "Magic p. 177"}
             {:name :rejoin, :prerequisites [:weaken :restore], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :repair, :prerequisites [[:skills/magery 2] :rejoin], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :reshape, :prerequisites [[:skills/magery 1] :weaken #{:shape-earth :shape-plant}], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :restore, :prerequisites [#{:find-weakness :simple-illusion}], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :rive, :prerequisites [[:skills/magery-2] :shatter], :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :ruin, :prerequisites [[:skills [:advantages/magery 1]] :weaken :decay], :college :making-and-breaking, :ref "Magic p. 118"}
             ;;{:name :self-repairing, :prerequisites [[:skills/magery-2] :repair], :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :sharpen, :prerequisites [:repair], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shatter, :prerequisites [[:skills/killsmagery 1] :weaken], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :shatterproof, :prerequisites [:repair :shatter], :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shrink-object, :prerequisites [:contract-object], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :soilproof, :prerequisites [:materialize], :college :making-and-breaking, :ref "Magic p. 116}; Thaumatology: Urban Magics, p. 33"}
             ;;{:name :soul-creation, :prerequisites [:inspired-creation], :college :making-and-breaking, :ref "Classic: Magic Items 3 p. 31"}
             {:name :stiffen, :prerequisites [:rejoin], :college :making-and-breaking, :ref "Magic p. 117"}
             ;;{:name :tack, :prerequisites [], :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :toughen, :prerequisites [:shatterproof], :college :making-and-breaking, :ref "Magic p. 119"}
             ;;{:name :transfigure-object, :prerequisites [[:skilmagery-3] :transform-object], :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :transform-object, :prerequisites [:m2 :reshape [4 :create]], :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :transparency, :prerequisites [:dye :stone-to-earth], :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :weaken, :prerequisites [:find-weakness], :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :weapon-self, :prerequisites [[:skills/magery 2] :apportation :6-makin [:breaking :reshape]], :college :making-and-breaking, :ref "Magic p. 119"}
             ;;{:name :wizardly-workshop, :prerequisites [], :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :bless, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :college :meta, :ref "Magic p. 129"}
             {:name :catch-spell, :prerequisites [[:skills/magery 2] [:attributes/dex 12] :return-missile], :college :meta, :ref "Magic p. 123"}
             ;;{:name :charge-powerstone, :prerequisites [[:skills/magery 3] :powerstone :lend-energy], :college :meta, :ref "Magic p. 126/Classic: Grimoire p. 74"}
             {:name :conceal-magic, :prerequisites [:detect-magic], :college :meta, :ref "Magic p. 122, Thaumatology: Urban Magics"}
             {:name :counterspell, :prerequisites [[:skills/magery 1] :spell-being-countered], :college :meta, :ref "Basic Set, p. 250}; Magic p. 121"}
             {:name :curse, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :college :meta, :ref "Magic p. 129"}
             {:name :dispel-magic, :prerequisites [:counterspell [12 :other]], :college :meta, :ref "Basic Set, p. 250}; Magic p. 126"}
             ;;{:name :dispel-spark, :prerequisites [[:skills/magery 3] :drain-mana :remove-aura], :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :displace-spell, :prerequisites [:suspend-magic], :college :meta, :ref "Magic p. 124, Thaumatology: Urban Magics"}
             {:name :drain-magery, :prerequisites [[[:skills/magery 3]] :suspend-magery], :college :meta, :ref "Magic p. 130"}
             {:name :drain-mana, :prerequisites [:dispel-magic :suspend-mana], :college :meta, :ref "Magic p. 127"}
             ;;{:name :dread-curse, :prerequisites [[:skills/magery 1] :curse], :college :meta, :ref "Magic: Death Spells, p. 17"}
             ;;{:name :end-scene, :prerequisites [], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :false-aura, :prerequisites [:conceal-magic :aura], :college :meta, :ref "Magic p. 122"}
             {:name :great-ward, :prerequisites [[:skills/magery 1] :ward], :college :meta, :ref "Magic p. 122"}
             {:name :hang-spell, :prerequisites [:delay], :college :meta, :ref "Magic p. 128}; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
             ;;{:name :internalize-elixir, :prerequisites [[:skills/magery 1] :detect-magic :know-recipie], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 10"}
             {:name :lend-spell, :prerequisites [[:skills/magery 1] :lend-skill :1-spell-each-from-6-colleges], :college :meta, :ref "Magic p. 126"}
             ;;{:name :ley-buffer, :prerequisites [[:skills/magery 1] :ley-tap], :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             ;;{:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :college :meta, :ref "Thaumatology: Urban Magics, p. 21"}
             ;;{:name :ley-supply, :prerequisites [:ley-tap #{:lend-energy :minor-draw-power}], :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :magic-resistance, :prerequisites [[:skills/magery 1] :1-spell-each-from-7-colleges], :college :meta, :ref "Magic p. 123"}
             ;;{:name :mana-storm, :prerequisites [[:skills/magery 4] :drain-mana :restore-man], :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :mana-vortex, :prerequisites [[:skills/magery 2] :lend-energy :sense-danger], :college :meta, :ref "Magic Styles: Dungeon Magic, p. 27}; Thaumatology: Urban Magics"}
             {:name :maintain-spell, :prerequisites [:link], :college :meta, :ref "Magic p. 128}; Thaumatology: Urban Magics"}
             {:name :penetrating-spell, :prerequisites [:delay :find-weakness], :college :meta, :ref "Magic p. 123"}
             {:name :pentagram, :prerequisites [:spell-shield], :college :meta, :ref "Magic p. 124}; Thaumatology: Urban Magics"}
             ;;{:name :preemptive-experience, :prerequisites [], :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             ;;{:name :punishment-circle, :prerequisites [[:skills/magery 3] #{:pentagram :repel-spirits}], :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :raise-cone-of-power, :prerequisites [:lend-energy #{:pentagram :restore-mana}], :college :meta, :ref "GURPS Thaumatology, p. 52"}
             {:name :reflect, :prerequisites [:ward], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics"}
             {:name :remove-aura, :prerequisites [:dispel-magic :aura], :college :meta, :ref "Magic p. 127"}
             {:name :remove-curse, :prerequisites [[:skills/magery 2] :1-spell-from-each-of-15-colleges], :college :meta, :ref "Magic p. 126}; Thaumatology: Urban Magics"}
             {:name :restore-mana, :prerequisites [:dispel-magic :suspend-mana], :college :meta, :ref "Magic p. 128}; Thaumatology: Urban Magics"}
             ;;{:name :scryfool, :prerequisites [[:skills/magery 2] :sense-observation :simple-illusion], :college :meta, :ref "Magic p. 123; Classic: Grimoire p 74"}
             {:name :scryguard, :prerequisites [[:skills/magery 1]], :college :meta, :ref "GURPS Fantasy, p. 170}; Thaumatology: Urban Magics"}
             {:name :scrywall, :prerequisites [:scryguard], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics, p. 33"}
             {:name :seek-magic, :prerequisites [:detect-magic], :college :meta, :ref "Magic p. 102"}
             ;;{:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :college :meta, :ref "Magic: Artillery Spells p. 23"}
             {:name :sovereign-countermagic, :prerequisites [[:skills/magery 3] :analyze-magic :dispel-magic], :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :sovereign-ward, :prerequisites [:skills/magery 3] :dispel-magic :ward, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :spell-shield, :prerequisites [[:skills/magery 2] :scryguard :magic-resistance], :college :meta, :ref "Magic p. 124"}
             {:name :spell-wall, :prerequisites [:spell-shield], :college :meta, :ref "Magic p. 124}; Thaumatology: Urban Magics"}
             {:name :spellguard, :prerequisites [:dispel-magic], :college :meta, :ref "Magic p. 127}; Thaumatology: Urban Magics"}
             {:name :steal-spell, :prerequisites [:lend-spell :great-ward], :college :meta, :ref "Magic p. 127"}
             {:name :suspend-curse, :prerequisites [[:skills/magery 1] :1-spell-each-from-12-colleges], :college :meta, :ref "Magic p. 125"}
             {:name :suspend-magery, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :college :meta, :ref "Magic p. 130"}
             {:name :suspend-magic, :prerequisites [:suspend-spell [8 :meta]], :college :meta, :ref "Magic p. 123"}
             {:name :suspend-mana, :prerequisites [:suspend-magic :1-spell-each-from-10-colleges], :college :meta, :ref "Magic p. 125"}
             {:name :suspend-spell, :prerequisites [[:skills/magery 1]], :college :meta, :ref "Magic p. 121}; Thaumatology: Urban Magics"}
             {:name :telecast, :prerequisites [[:skills/magery 3] :teleport :wizard-eye :1-spell-each-from-10-colleges], :college :meta, :ref "Magic p. 128"}
             ;;{:name :thaumatomancy, :prerequisites [], :college :meta, :ref "Magic: The Least of Spells p. 12"}
             {:name :throw-spell, :prerequisites [:delay :catch-spell], :college :meta, :ref "Magic p. 128"}
             ;;{:name :use-item, :prerequisites [], :college :meta, :ref "Magic: The Least of Spells p. 12-13"}
             ;;{:name :void-bolt, :prerequisites [[:skills/magery 4] :4-essentials-taken-as-prerequisites [4 :missile]], :college :meta, :ref "Pyramid 3/25: Epic Magic, p. 19"}
             {:name :ward, :prerequisites [[:skills/magery 1]], :college :meta, :ref "Magic p. 122}; Thaumatology: Urban Magics"}
             ;;{:name :adjuration, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :alertness, :prerequisites [[:skills/magery 2] :create-acid], :college :mind-control, :ref "Magic p. 133}; Classic: Magic p 69"}
             {:name :avoid, :prerequisites [:hide :fear :forgetfulness], :college :mind-control, :ref "Magic p. 140"}
             {:name :berserker, :prerequisites [:bravery], :college :mind-control, :ref "Magic p. 134"}
             {:name :boost-intelligence, :prerequisites [:wisdom], :college :mind-control, :ref "Magic p. 37"}
             {:name :bravery, :prerequisites [:fear], :college :mind-control, :ref "Magic p. 134"}
             {:name :charm, :prerequisites [[:skills/magery 1] :loyalty [7 :other]], :college :mind-control, :ref "Magic p. 139"}
             ;;{:name :coma, :prerequisites [[:skills/magery 3] :lesser-geas :sleep], :college :mind-control, :ref "Magic: Death Spells, p. 17"}
             {:name :command, :prerequisites [[:skills/magery 2] :forgetfulness], :college :mind-control, :ref "Basic Set, p. 251}; Magic p. 136"}
             {:name :compel-lie, :prerequisites [:emotion-control], :college :mind-control, :ref "Magic p. 137"}
             ;;{:name :confuse-memory, :prerequisites [:foolishness], :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 14"}
             {:name :daze, :prerequisites [:foolishness], :college :mind-control, :ref "Basic Set'', p. 250}; Magic p. 134"}
             ;;{:name :disbelieve, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :discord, :prerequisites [[:skills/magery 2] :emotion-control :vexation], :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 31"}
             {:name :disorient, :prerequisites [:foolishness], :college :mind-control, :ref "Magic p. 135"}
             ;;{:name :drama, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :college :mind-control, :ref "Magic p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :college :mind-control, :ref "Magic p. 45"}
             {:name :drunkenness, :prerequisites [:foolishness :clumsiness], :college :mind-control, :ref "Magic p. 136"}
             {:name :dull, :prerequisites [], :college :mind-control, :ref "Magic p. 133"}
             {:name :dullness, :prerequisites [:dull], :college :mind-control, :ref "Magic p. 134"}
             {:name :ecstasy, :prerequisites [[:skills/magery 2] :emotion-control], :college :mind-control, :ref "Magic p. 139"}
             {:name :emotion-control, :prerequisites [#{:loyalty :mental-stun}], :college :mind-control, :ref "Magic p. 137"}
             {:name :encrypt, :prerequisites [:daze], :college :mind-control, :ref "Magic p. 135"}
             {:name :enslave, :prerequisites [:charm :telepathy], :college :mind-control, :ref "Magic p. 141"}
             {:name :enthrall, :prerequisites [:forgetfulness :daze :slow], :college :mind-control, :ref "Magic p. 139"}
             {:name :false-memory, :prerequisites [:forgetfulness [6 :mind-control]], :college :mind-control, :ref "Magic p. 139"}
             {:name :fascinate, :prerequisites [:daze], :college :mind-control, :ref "Magic p. 135"}
             {:name :fear, :prerequisites [#{:sense-emotion :empathy}], :college :mind-control, :ref "Magic p. 139}; Fantasy, p. 171"}
             {:name :foolishness, :prerequisites [[:attributes/int 12]], :college :mind-control, :ref "Basic Set p. 250}; Magic p. 134"}
             {:name :forgetfulness, :prerequisites [[:skills/magery 1] :foolishness], :college :mind-control, :ref "Basic Set p. 250}; Magic p. 135"}
             ;;{:name :game-addict, :prerequisites [:charm], :college :mind-control, :ref "Classic: Technomancer p. 25"}
             {:name :glib-tongue, :prerequisites [:suggestion], :college :mind-control, :ref "Magic p. 141"}
             {:name :great-geas, :prerequisites [[:skills/magery 3] [15 :mind] :lesser-geas], :college :mind-control, :ref "Magic p. 141}; Social Engineering: Back to School, p. 24"}
             {:name :great-hallucination, :prerequisites [[:skills/magery 2] :hallucination], :college :mind-control, :ref "Magic p. 141"}
             {:name :hallucination, :prerequisites [:madness :suggestion], :college :mind-control, :ref "Magic p. 140"}
             ;;{:name :hypnotize, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :keen, :prerequisites [], :college :mind-control, :ref "Magic p. 133"}
             ;;{:name :keyfinder, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :know-thyself, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :lesser-geas, :prerequisites [[:skills/magery 2] [10 :mind]], :college :mind-control, :ref "Magic p. 140}; Social Engineering: Back to School, p. 24"}
             ;;{:name :literary-hunger, :prerequisites [[:skills/magery 1]], :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :loyalty, :prerequisites [:bravery [2 :other]], :college :mind-control, :ref "Magic p. 136"}
             ;;{:name :lure, :prerequisites [:emotion-control], :college :mind-control, :ref "Magic p. 137/Classic: Grimoire p 76"}
             {:name :madness, :prerequisites [#{:forgetfulness :drunkenness}], :college :mind-control, :ref "Magic p. 136"}
             {:name :mass-charm, :prerequisites [[:skills/magery 2] [:attributes/int 13] :charm], :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 31"}
             {:name :mass-daze, :prerequisites [:daze [:attributes/int 13]], :college :mind-control, :ref "Basic Set p. 251}; Magic p. 137"}
             {:name :mass-hallucination, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 32"}
             ;;{:name :mass-mutilation, :prerequisites [[:skills/magery 4] [10 :mind] :madness :mass-suggestion], :college :mind-control, :ref "Magic: Artillery Spells p. 20"}
             {:name :mass-sleep, :prerequisites [:sleep [:attributes/int 13]], :college :mind-control, :ref "Basic Set p. 251}; Magic p. 137"}
             {:name :mass-suggestion, :prerequisites [:suggestion], :college :mind-control, :ref "Magic p. 141"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :college :mind-control, :ref "Magic p. 105}; Social Engineering: Back to School, p. 24"}
             {:name :mental-stun, :prerequisites [#{:daze :stun}], :college :mind-control, :ref "Magic p. 135"}
             ;;{:name :mind-killer, :prerequisites [[:skills/magery 3] :sickness :strengthen-will], :college :mind-control, :ref "Magic: Death Spells, p. 17"}
             {:name :mindlessness, :prerequisites [[:skills/magery 2] :forgetfulness], :college :mind-control, :ref "Magic p. 137"}
             {:name :nightmare, :prerequisites [[:skills/magery 2] :death-vision :fear :sleep], :college :mind-control, :ref "Magic p. 140"}
             {:name :oath, :prerequisites [[:skills/magery 1] :emotion-control], :college :mind-control, :ref "Magic p. 138"}
             {:name :pacify, :prerequisites [[:skills/magery 2] :persuasion :relieve-madness], :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :panic, :prerequisites [:fear], :college :mind-control, :ref "Magic p. 134"}
             ;;{:name :patience, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :peaceful-sleep, :prerequisites [:sleep :silence], :college :mind-control, :ref "Magic p. 138"}
             {:name :permanent-forgetfulness, :prerequisites [[:skills/magery 2] :forgetfulness [:attributes/int 13]], :college :mind-control, :ref "Magic p. 138"}
             {:name :permanent-madness, :prerequisites [[:skills/magery 2] :madness [:attributes/int 13]], :college :mind-control, :ref "Magic p. 139"}
             {:name :rear-vision, :prerequisites [:alertness], :college :mind-control, :ref "Magic p. 134"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :college :mind-control, :ref "Magic p. 104"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :college :mind-control, :ref "Magic p. 92"}
             {:name :sickness, :prerequisites [#{:drunkenness :pestilence}], :college :mind-control, :ref "Magic p. 138"}
             {:name :sleep, :prerequisites [:daze], :college :mind-control, :ref "Basic Set p. 251}; Magic p. 135"}
             ;;{:name :speed-reading, :prerequisites [#{[:attributes/int 12] :gift-of-letters}], :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             ;;{:name :stabbing-party, :prerequisites [[:skills/magery 4] [10 :mind] :comm :mass-suggestion], :college :mind-control, :ref "Magic: Artillery Spells p. 20-21"}
             ;;{:name :startle, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :strengthen-will, :prerequisites [[:skills/magery 1] [6 :mind]], :college :mind-control, :ref "Magic p. 136"}
             {:name :suggestion, :prerequisites [:emotion-control :forgetfulness], :college :mind-control, :ref "Magic p. 140"}
             ;;{:name :sweet-oblivion, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             ;;{:name :transfer-loyalty, :prerequisites [:bravery #{[2 :mind-control] :enchantment}], :college :mind-control, :ref "Classic: Magic Items 3 p 33"}
             {:name :terror, :prerequisites [:fear], :college :mind-control, :ref "Magic p. 134"}
             {:name :vigil, :prerequisites [[:skills/magery 2] :sleep :lend-energy], :college :mind-control, :ref "Magic p. 138"}
             ;;{:name :volatility, :prerequisites [], :college :mind-control, :ref "Magic: The Least of Spells p. 14"}
             {:name :weaken-will, :prerequisites [[:skills/magery 1] :foolishness], :college :mind-control, :ref "Magic p. 136"}
             {:name :will-lock, :prerequisites [:emotion-control], :college :mind-control, :ref "Magic p. 138"}
             {:name :wisdom, :prerequisites [[6 :other]], :college :mind-control, :ref "Magic p. 135}; Social Engineering: Back to School, p. 24"}
             ;;{:name :writer's-block, :prerequisites [[:skills/magery 1]], :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :college :movement, :ref "Magic p. 26"}
             {:name :apportation, :prerequisites [[:skills/magery 1]], :college :movement, :ref "Basic Set, p. 251}; Magic p. 142"}
             {:name :beacon, :prerequisites [:teleport :timeport :or-plane-shift], :college :movement, :ref "Magic p. 83"}
             {:name :blink, :prerequisites [:teleport], :college :movement, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :college :movement, :ref "Magic p. 148"}
             {:name :cloud-vaulting, :prerequisites [[:skills/magery 2] :jump :walk-on-air], :college :movement, :ref "Magic p. 148"}
             {:name :cloud-walking, :prerequisites [:walk-on-air :walk-on-water], :college :movement, :ref "Magic p. 148"}
             ;;{:name :collision, :prerequisites [[:skills/magery 4] [10 :movement] :poltergeist :pull], :college :movement, :ref "Magic: Artillery Spells p. 21"}
             ;;{:name :crushing-fist, :prerequisites [[:skills/magery 4] [10 :movement] :distant-blow :wizard-han], :college :movement, :ref "Magic: Artillery Spells p. 21"}
             ;;{:name :cushion, :prerequisites [], :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :dancing-object, :prerequisites [[:skills/magery 2] :apportation], :college :movement, :ref "Magic p. 144, Classic Magic p 61"}
             {:name :deflect-missile, :prerequisites [:apportation], :college :movement, :ref ""}
             ;;{:name :disruption, :prerequisites [[:skills/magery 3] :any- [0 :movement] :manipulate :undo], :college :movement, :ref "Magic: Death Spells, p. 17"}
             {:name :distant-blow, :prerequisites [[:skills/magery 2] :apportation], :college :movement, :ref "Magic p. 144"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :college :movement, :ref "Magic p. 84"}
             {:name :ethereal-body, :prerequisites [[6 :movement] :or-magery-3 :body-of-air], :college :movement, :ref "Magic p. 146"}
             ;;{:name :flee, :prerequisites [], :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :flight, :prerequisites [[:skills/magery 2] :levitation], :college :movement, :ref "Magic p. 145}; Fantasy, p. 171"}
             {:name :flying-carpet, :prerequisites [:flight :or-magery-2 :walk-on-air], :college :movement, :ref "Magic p. 145"}
             ;;{:name :force-ball, :prerequisites [[:skills/magery 4] :catch-spell :force-dome :sense-foes], :college :movement, :ref "Magic: Artillery Spells p. 24-25"}
             {:name :freedom, :prerequisites [[3 :body] [3 :movement] :3-protectio  :warning], :college :movement, :ref "Magic p. 148"}
             {:name :glue, :prerequisites [:haste], :college :movement, :ref "Magic p. 142"}
             ;;{:name :grease, :prerequisites [:haste], :college :movement, :ref "Magic p. 142; Classic: Grimoire p 79"}
             ;;{:name :great-deflect-missile, :prerequisites [[:skills/magery 2] :deflect-missile], :college :movement, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magic Styles: Dungeon Magic"}
             {:name :great-haste, :prerequisites [[:skills/magery 1] [:attributes/int 12] :haste], :college :movement, :ref "Basic Set, p. 251}; Magic p. 146"}
             ;;{:name :hail-of-lead, :prerequisites [:haste :immediate-action], :college :movement, :ref "Classic: Technomancer p 26"}
             {:name :haste, :prerequisites [], :college :movement, :ref "Basic Set, p. 251}; Magic p. 142"}
             {:name :hawk-flight, :prerequisites [:flight], :college :movement, :ref "Magic p. 146"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :college :movement, :ref "Basic Set, p. 244}; Magic p. 36"}
             {:name :hold-fast, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143"}
             ;;{:name :homing-missile, :prerequisites [:q-13+ :seeker :curse-missile :explosive-fireball :fireball :high-explosive-fireball :ice-dagger :ice-sphere :shaped-charge-fireball #{:stone-missile :winged-knife}], :college :movement, :ref "Classic: Technomancer p. 26"}
             ;;{:name :increase-burden, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143; Classic: Grimoire p. 79"}
             {:name :jump, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143"}
             {:name :levitation, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143, Fantasy, p. 171/Classic: Magic p 70"}
             ;;{:name :ley-float, :prerequisites [[:skilmager3] :enchant :ley-supply], :college :movement, :ref "Thaumatology: Urban Magics, p. 20"}
             ;;{:name :ley-running, :prerequisites [:seek-ley-line :haste], :college :movement, :ref "Thaumatology: Urban Magics, p. 19"}
             ;;{:name :ley-vehicle, :prerequisites [:ley-float :ley-running], :college :movement, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :light-tread, :prerequisites [:apportation :shape-earth], :college :movement, :ref "Magic p. 145"}
             {:name :lighten-burden, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143}; Fantasy, p. 171"}
             {:name :lockmaster, :prerequisites [[:skills/magery 2] :apportation], :college :movement, :ref "Basic Set, p. 251}; Magic p. 144"}
             {:name :locksmith, :prerequisites [:apportation], :college :movement, :ref "Magic p. 143"}
             {:name :long-march, :prerequisites [[:advantages/magery 1] #{:clumsiness :debility}], :college :movement, :ref "Magic p. 143"}
             ;;{:name :magic-bullet, :prerequisites [:poltergeist], :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :manipulate, :prerequisites [:locksmith], :college :movement, :ref "Magic p. 145"}
             ;;{:name :open-door, :prerequisites [], :college :movement, :ref "Magic: The Least of Spells p. 14"}
             ;;{:name :quarter, :prerequisites [[:advantages/magery 3] :any- [0 :movement] :pull :repel], :college :movement, :ref "Magic: Death Spells, p. 18"}
             {:name :quick-march, :prerequisites [[:advantages/magery 1] :haste], :college :movement, :ref "Magic p. 144}; Fantasy, p. 171"}
             {:name :poltergeist, :prerequisites [:apportation], :college :movement, :ref "Magic p. 144"}
             {:name :pull, :prerequisites [[:skills/magery 2] [4 :movement] :levitation], :college :movement, :ref "Magic p. 146"}
             {:name :rapid-journey, :prerequisites [[:advantages/magery 3] #{:teleport :timeport}], :college :movement, :ref "Magic p. 82"}
             ;;{:name :reduce-recoil, :prerequisites [], :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :college :movement, :ref "GURPS Bio-Tech, p. 32"}
             {:name :repel, :prerequisites [[:skills/magery 2] [4 :movement] :levitation], :college :movement, :ref "Magic p. 146"}
             ;;{:name :reorient, :prerequisites [], :college :movement, :ref "Magic: The Least of Spells p. 10"}
             ;;{:name :sink, :prerequisites [], :college :movement, :ref "Magic: The Least of Spells p. 14"}
             ;;{:name :slasher, :prerequisites [[:advantages/magery 4] [10 :movement] :dancing-object :winged-knife], :college :movement, :ref "Magic: Artillery Spells p. 22"}
             {:name :slide, :prerequisites [:apportation :grease], :college :movement, :ref "Magic p. 145"}
             {:name :slow, :prerequisites [[:advantages/magery 1] :haste :hinder], :college :movement, :ref "Magic p. 145"}
             {:name :slow-fall, :prerequisites [:apportation], :college :movement, :ref "Magic p. 144"}
             ;;{:name :steady-hand, :prerequisites [], :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :swim, :prerequisites [:shape-water :levitation], :college :movement, :ref "Magic p. 147"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :college :movement, :ref "GURPS Bio-Tech, p. 32"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :college :movement, :ref "Magic p. 147}; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:advantages/magery 3] :teleport], :college :movement, :ref "Magic p. 147"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :college :movement, :ref "Magic p. 84"}
             {:name :undo, :prerequisites [:locksmith], :college :movement, :ref "Magic p. 145"}
             {:name :wallwalker, :prerequisites [:apportation], :college :movement, :ref "Magic p. 144"}
             {:name :winged-knife, :prerequisites [:poltergeist], :college :movement, :ref "Magic p. 145"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :college :movement, :ref "Magic p. 104"}
             {:name :affect-spirits, :prerequisites [:solidify], :college :necromantic, :ref "Magic p. 151"}
             {:name :age, :prerequisites [#{:youth [6 :necromantic]}], :college :necromantic, :ref "Magic p. 154"}
             {:name :animate-shadow, :prerequisites [:skull-spirit :shape-darkness], :college :necromantic, :ref "Magic p. 154"}
             {:name :animation, :prerequisites [:summon-spirit], :college :necromantic, :ref "Magic p. 150"}
             {:name :astral-block, :prerequisites [:summon-spirit :repel-spirits], :college :necromantic, :ref "Magic p. 159"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :college :necromantic, :ref "Magic p. 105"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :college :necromantic, :ref "Magic p. 115"}
             {:name :banish, :prerequisites [[:advantages/magery 1] :1-spell-each-from-10-colleges], :college :necromantic, :ref "Magic p. 156"}
             {:name :bind-spirit, :prerequisites [:comm :spirit :soul-jar], :college :necromantic, :ref "Magic p. 158"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :college :necromantic, :ref "Magic p. 76"}
             {:name :command-spirit, :prerequisites [:summon-spirit :turn-spirit], :college :necromantic, :ref "Magic p. 153"}
             {:name :control-zombie, :prerequisites [:zombie], :college :necromantic, :ref "Magic p. 152"}
             {:name :death-vision, :prerequisites [[:advantages/magery 1]], :college :necromantic, :ref "Basic Set, p. 251}; Magic p. 149"}
             ;;{:name :dramatic-departure, :prerequisites [], :college :necromantic, :ref "Magic: The Least of Spells p. 14"}
             {:name :entrap-spirit, :prerequisites [[:advantages/magery 1] :soul-jar :turn-spirit], :college :necromantic, :ref "Magic p. 157"}
             {:name :evisceration, :prerequisites [[:advantages/magery 3] :apportation :steal-vitality], :college :necromantic, :ref "Magic p. 154"}
             {:name :final-rest, :prerequisites [#{[:advantages/magery 1] :spirit-empathy}], :college :necromantic, :ref "Magic p. 89"}
             {:name :grasping-doom, :prerequisites [:mass-zombie], :college :necromantic, :ref "Magic Styles: Dungeon Magic, p. 15"}
             {:name :hellspawn, :prerequisites [:summon-demon], :college :necromantic, :ref "GURPS Bio-Tech, p. 32}; Technomander p. 27"}
             ;;{:name :invoke, :prerequisites [], :college :necromantic, :ref "Magic: The Least of Spells p. 14-15"}
             {:name :lich, :prerequisites [[:advantages/magery 3] [:attributes/int 13] :enchant :soul-jar :zombie], :college :necromantic, :ref "Magic p. 159"}
             {:name :mass-zombie, :prerequisites [:zombie :charisma-2+], :college :necromantic, :ref "Magic p. 153}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :materialize, :prerequisites [:summon-spirit], :college :necromantic, :ref "Magic p. 150"}
             {:name :pestilence, :prerequisites [[:advantages/magery 1] :steal-vitality :decay], :college :necromantic, :ref "Magic p. 154"}
             ;;{:name :plant-zombie, :prerequisites [:zombie [4 :plant]], :college :necromantic, :ref "Pyramid 3/68: Natural Magic, p. 10"}
             ;;{:name :punishment-circle, :prerequisites [[:advantages/magery 3] #{:pentagram :repel-spirits}], :college :necromantic, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :repel-spirits, :prerequisites [:banish :turn-spirit], :college :necromantic, :ref "Magic p. 158"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :college :necromantic, :ref "Magic p. 94"}
             ;;{:name :reverie-of-ruin, :prerequisites [], :college :necromantic, :ref "Magic: The Least of Spells p. 15"}
             {:name :rotting-death, :prerequisites [[:skills/magery 2] :sickness :pestilence], :college :necromantic, :ref "Magic p. 154"}
             ;;{:name :self-destruct, :prerequisites [[:advantages/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :college :necromantic, :ref "Magic: Artillery Spells p. 23"}
             {:name :sense-spirit, :prerequisites [:death-vision], :college :necromantic, :ref "Basic Set, p. 252}; Magic p. 149"}
             {:name :skull-spirit, :prerequisites [[4 :necromantic]], :college :necromantic, :ref "Magic p. 151"}
             {:name :slow-healing, :prerequisites [[:advantages/magery 1] :frailty :steal-vitality], :college :necromantic, :ref "Magic p. 153"}
             {:name :solidify, :prerequisites [:materialize], :college :necromantic, :ref "Magic p. 151"}
             {:name :soul-jar, :prerequisites [[:advantages/magery 1] [6 :necromantic] :steal-vitality], :college :necromantic, :ref "Magic p. 154"}
             {:name :soul-prison, :prerequisites [[:advantages/magery 3] :banish :soul-jar :banish :soul-jar :any-four-of-animate-shadow :possession :repel-spirits :divination :mass-zombie :summon-demon :pentagram :summon-earth-elemental :phase-other] :college :necromantic :ref ""}
             ;;{:name :mass-resist-lightning, :prerequisites [[:attributes/int 13] :resist-lightning], :college :protection-and-warning, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
             ;;{:name :mass-resist-poison, :prerequisites [[:attributes/int 13] :resist-poison], :college :protection-and-warning, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             ;;{:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :college :protection-and-warning, :ref "Pyramid 3/76: Dungeon Fantasy IV p. 14"}
             {:name :missile-shield, :prerequisites [[:advantages/magery 2] #{:apportation :shield}], :college :protection-and-warning, :ref "Magic p. 168}; Thaumatology: Urban Magics, p. 33"}
             {:name :mystic-mist, :prerequisites [[:advantages/magery 1] #{:watchdog :shield}], :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :nightingale, :prerequisites [:sense-danger], :college :protection-and-warning, :ref "Magic p. 167"}
             ;;{:name :oven-mitts, :prerequisites [], :college :protection-and-warning, :ref "Magic: The Least of Spells p. 9"}
             ;;{:name :prismatic-mist-area, :prerequisites [:mystic-mist :sand-jet], :college :protection-and-warning, :ref "Classic: Technomancer p. 27"}
             {:name :protect-animal, :prerequisites [:armor :watchdog], :college :protection-and-warning, :ref "Magic, p. 32"}
             {:name :reflect-gaze, :prerequisites [:mirror], :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :resist-acid, :prerequisites [:create-acid], :college :protection-and-warning, :ref "Magic p. 190"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :college :protection-and-warning, :ref "Magic p. 90"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :college :protection-and-warning, :ref "Magic p. 196"}
             {:name :resist-poison, :prerequisites [:vigor], :college :protection-and-warning, :ref "Magic p. 91"}
             {:name :resist-pressure, :prerequisites [:weather-dome], :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :resist-radiation, :prerequisites [[3 :radiation]], :college :protection-and-warning, :ref "Magic p. 182"}
             {:name :resist-sound, :prerequisites [[4 :sound]], :college :protection-and-warning, :ref "Magic p. 173"}
             {:name :resist-water, :prerequisites [#{:umbrella :shape-water} :destroy-water], :college :protection-and-warning, :ref "Magic p. 186"}
             {:name :return-missile, :prerequisites [:catch-missile], :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :reverse-missiles, :prerequisites [#{:missile-shield :force-dome}], :college :protection-and-warning, :ref "Magic p. 168}; Pyramid 3/60: Dungeon Fantasy III p. 5"}
             ;;{:name :selective-hearing, :prerequisites [], :college :protection-and-warning, :ref "Magic: The Least of Spells p. 15"}
             {:name :sense-danger, :prerequisites [#{:sense-foes :danger-sense}], :college :protection-and-warning, :ref "Magic p. 166"}
             {:name :sense-observation, :prerequisites [#{:sense-danger :scryguard}], :college :protection-and-warning, :ref "Magic p. 167"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :shield, :prerequisites [[:skills/magery 2]], :college :protection-and-warning, :ref "Basic Set, p. 252}; Magic p. 167"}
             ;;{:name :spoof-sensor, :prerequisites [:blind-sensor], :college :protection-and-warning, :ref "Classic: Technomancer p. 27"}
             ;;{:name :stinkguard, :prerequisites [], :college :protection-and-warning, :ref "Magic: The Least of Spells p. 6"}
             ;;{:name :storm-shelter, :prerequisites [], :college :protection-and-warning, :ref "Magic: The Least of Spells p. 17"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :turn-blade, :prerequisites [#{:apportation :spasm}], :college :protection-and-warning, :ref "Magic p. 167"}
             {:name :umbrella, :prerequisites [#{:shape-water :shield}], :college :protection-and-warning, :ref "Magic p. 185"}
             {:name :utter-dome, :prerequisites [[:skills/magery 2] :force-dome :spell-shield], :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :utter-wall, :prerequisites [:utter-dome :spell-wall], :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :warmth, :prerequisites [:heat], :college :protection-and-warning, :ref "Magic p. 74"}
             {:name :watchdog, :prerequisites [:sense-danger], :college :protection-and-warning, :ref "Magic p. 167}; Thaumatology: Urban Magics, p. 33"}
             {:name :weather-dome, :prerequisites [:2-from-each-of-4-elements], :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :alter-voice, :prerequisites [[4 :body] [4 :sound]], :college :sound, :ref "Magic p. 41"}
             ;;{:name :call, :prerequisites [], :college :sound, :ref "Magic: The Least of Spells p. 6"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :college :sound, :ref "Magic p. 26"}
             {:name :converse, :prerequisites [[:advantages/magery 1] :garble :silence], :college :sound, :ref "Magic p. 173"}
             {:name :delayed-message, :prerequisites [[:advantages/magery 1] :voices :sense-life], :college :sound, :ref "Magic p. 173"}
             {:name :disrupt, :prerequisites [[:skills/magery 2] :concussion :sound-jet :secret-spell], :college :sound, :ref "Magic Styles: Dungeon Magic p. 23"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :college :sound, :ref "Magic p. 107"}
             {:name :far-hearing, :prerequisites [[:advantages/magery 1] [4 :sound]], :college :sound, :ref "Magic p. 173"}
             {:name :garble, :prerequisites [:voices], :college :sound, :ref "Magic p. 172"}
             {:name :great-voice, :prerequisites [:voices :thunderclap], :college :sound, :ref "Magic p. 173"}
             {:name :hush, :prerequisites [:silence], :college :sound, :ref "Magic p. 172"}
             {:name :imitate-voice, :prerequisites [:voices], :college :sound, :ref "Magic p. 172"}
             ;;{:name :improved-concussion, :prerequisites [[:advantages/magery 4] [7 :sound] :concussion :great-voice], :college :sound, :ref "Magic: Artillery Spells p. 25"}
             {:name :invisible-wizard-ear, :prerequisites [:wizard-ear :invisibility], :college :sound, :ref "Magic p. 174"}
             ;;{:name :ley-speech, :prerequisites [:seek-ley-line :voices], :college :sound, :ref "Thaumatology: Urban Magics p. 19"}
             ;;{:name :fatal-frequency, :prerequisites [[:advantages/magery 3] :concussion :sound-jet], :college :sound, :ref "Magic: Death Spells p. 20"}
             {:name :keen-hearing, :prerequisites [], :college :sound, :ref "Magic p. 133"}
             {:name :mage-stealth, :prerequisites [:hush], :college :sound, :ref "Magic p. 172"}
             ;;{:name :mer-speech, :prerequisites [], :college :sound, :ref "Magic: The Least of Spells p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :college :sound, :ref "Magic p. 173"}
             {:name :musical-scribe, :prerequisites [:scribe], :college :sound, :ref "Magic p. 174"}
             {:name :noise, :prerequisites [:wall-of-silence], :college :sound, :ref "Magic p. 173"}
             ;;{:name :perilous-pulsations, :prerequisites [[:advantages/magery 4] [7 :sound] :concussion :sound-jet], :college :sound, :ref "Magic: Artillery Spells p. 24"}
             {:name :resist-sound, :prerequisites [[4 :sound]], :college :sound, :ref "Magic p. 173"}
             {:name :scribe, :prerequisites [:voices :dancing-object #{:1-written-language-at-accented :better}], :college :sound, :ref "Magic p. 174"}
             ;;{:name :selective-hearing, :prerequisites [], :college :sound, :ref "Magic: The Least of Spells p. 15"}
             {:name :silence, :prerequisites [:sound], :college :sound, :ref "Magic p. 171}; Fantasy p. 172"}
             {:name :silver-tongue, :prerequisites [:voices :emotion-control], :college :sound, :ref "Magic p. 174"}
             {:name :sound, :prerequisites [], :college :sound, :ref "Magic p. 171}; Fantasy p. 172"}
             {:name :sound-jet, :prerequisites [:great-voice], :college :sound, :ref "Magic p. 173"}
             {:name :sound-vision, :prerequisites [#{:keen-hearing :acute-hearing}], :college :sound, :ref "Magic p. 171"}
             ;;{:name :squeak, :prerequisites [], :college :sound, :ref "Magic: The Least of Spells p. 15"}
             ;;{:name :throw-voice, :prerequisites [], :college :sound, :ref "Magic: The Least of Spells p. 16"}
             {:name :thunderclap, :prerequisites [:sound], :college :sound, :ref "Magic p. 171"}
             {:name :voices, :prerequisites [:sound], :college :sound, :ref "Magic p. 172"}
             ;;{:name :volume-control, :prerequisites [:great-voice], :college :sound, :ref "Classic: Technomancer p. 28"}
             ;;{:name :wail-of-the-banshee, :prerequisites [[:advantages/magery 3] :any- [0 :sound] :message], :college :sound, :ref "Magic: Death Spells p. 20"}
             {:name :wall-of-silence, :prerequisites [:silence], :college :sound, :ref "Magic p. 172"}
             ;;{:name :withering-wail, :prerequisites [[:advantages/magery 4] [10 :sound] :great-voice :noise], :college :sound, :ref "Magic: Artillery Spells p. 25"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :college :sound, :ref "Magic p. 174"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :college :sound, :ref "Magic p. 104"}
             {:name :animate-machine, :prerequisites [:machine-control #{:animation :animate-object}], :college :technological, :ref "Magic p. 177"}
             ;;{:name :awaken-building, :prerequisites [], :college :technological, :ref "Thaumatology: Urban Magics, p. 33"}
             {:name :awaken-computer, :prerequisites [:animation :wisdom], :college :technological, :ref "Magic p. 178"}
             ;;{:name :blind-sensor, :prerequisites [:glitch :seek-emitter], :college :technological, :ref "Classic: Technomancer p. 27"}
             ;;{:name :confound-firearm, :prerequisites [:glitch], :college :technological, :ref "Classic: Technomancer p. 34"}
             ;;{:name :create-mana-co-processor, :prerequisites [:awaken-computer :enchant], :college :technological, :ref "Classic: Magic Items 3 p 30"}
             ;;{:name :delete-commercials, :prerequisites [[:world/tl 7]], :college :technological, :ref "Classic: Technomancer p 18"}
             ;;{:name :essential-paper, :prerequisites [], :college :technological, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :glitch, :prerequisites [:machine-control], :college :technological, :ref "Magic p. 178"}
             ;;{:name :guide-missile, :prerequisites [:machine-control :any-'seek'-spell], :college :technological, :ref "Classic: Technomancer p. 34"}
             ;;{:name :ley-vehicle, :prerequisites [:ley-float :ley-running], :college :technological, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :machine-control, :prerequisites [:reveal-function :locksmith :lightning], :college :technological, :ref "Magic p. 176"}
             {:name :machine-possession, :prerequisites [:machine-control #{:rider-within :soul-rider}], :college :technological, :ref "Magic p. 178"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :college :technological, :ref "Magic p. 176"}
             {:name :machine-summoning, :prerequisites [:machine-control], :college :technological, :ref "Magic, p. 176"}
             ;;{:name :mad-machine, :prerequisites [:machine-control #{:animation :summon-demon}], :college :technological, :ref "Classic: Technomancer p. 35"}
             {:name :malfunction, :prerequisites [[:skills/magery 2] :glitch], :college :technological, :ref "Magic p. 177"}
             ;;{:name :magnetic-finger, :prerequisites [], :college :technological, :ref "Magic: The Least of Spells p. 16"}
             ;;{:name :manipulate-dna, :prerequisites [:sequence-dna :apportation :or-create-chimera], :college :technological, :ref "Bio-Tech, p. 32"}
             {:name :permanent-machine-possession, :prerequisites [[:advantages/magery 3] :machine-possession], :college :technological, :ref "Magic p. 178"}
             ;;{:name :program, :prerequisites [:machine-speech--17+ :or-machine-control], :college :technological, :ref "Classic: Technomancer p. 33"}
             ;;{:name :purify-signal, :prerequisites [:purify-air :tl6+], :college :technological, :ref "Classic: Technomancer p. 17"}
             {:name :rebuild, :prerequisites [[:advantages/magery 3] :repair :create-object [:3-of-each-element]], :college :technological, :ref "Magic p. 177"}
             ;;{:name :reckless-reconstitution, :prerequisites [:rebuild], :college :technological, :ref "Magic: Death Spells, p. 21"}
             ;;{:name :remote-start, :prerequisites [], :college :technological, :ref "Magic: The Least of Spells p. 16"}
             {:name :reveal-function, :prerequisites [:seek-machine], :college :technological, :ref "Magic p. 176"}
             {:name :schematic, :prerequisites [:reveal-function :history], :college :technological, :ref "Magic p. 177"}
             {:name :seek-machine, :prerequisites [], :college :technological, :ref "Magic p. 175"}
             ;;{:name :sense-nano, :prerequisites [:sense-disease [:attributes/int 15] :or-seek-machine :small-vision], :college :technological, :ref "Bio-Tech, p. 32"}
             ;;{:name :sequence-dna, :prerequisites [[:skills/magery 2] :divination :analyze-heredity], :college :technological, :ref "Bio-Tech, p. 32"}
             ;;{:name :spoof-sensor, :prerequisites [:blind-sensor], :college :technological, :ref "Classic: Technomancer p. 27"}
             ;;{:name :televisomancy, :prerequisites [#{[:6 :technological] [:skills/electronics-operation_communications 15]}], :college :technological, :ref "Classic: Technomancer p 23"}
             ;;{:name :upgrade-computer, :prerequisites [:inscribe :repair #{:schematic [:skills/electronics_computers 15]}], :college :technological, :ref "Classic: Technomancer p. 35"}
             ;;{:name :wizardly-workshop, :prerequisites [], :college :technological, :ref "Magic: The Least of Spells p. 12"}
             {:name :acid-ball, :prerequisites [[:skills/magery 2] :create-acid], :college :water, :ref "Magic p. 191"}
             {:name :acid-jet, :prerequisites [[:skills/magery 2] :water-jet :create-acid], :college :water, :ref "Magic p. 192"}
             ;;{:name :arctic-blast, :prerequisites [[:advantages/magery 4] :frostbite :icy-breath], :college :water, :ref "Magic: Artillery Spells p. 27"}
             ;;{:name :alkahest-jet, :prerequisites [[:advantages/magery 4] :essential-acid :acid-jet], :college :water, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             ;;{:name :alkahest-sphere, :prerequisites [[:advantages/magery 4] :essential-acid :acid-ball], :college :water, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :boil-water, :prerequisites [:shape-water :heat], :college :water, :ref "Magic p. 192"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :college :water, :ref "Magic p. 26"}
             {:name :breathe-steam, :prerequisites [[:advantages/magery 1] :steam-jet :resist-fire], :college :water, :ref "Magic p. 192"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :college :water, :ref "Basic Set, p. 243}; Magic p. 189"}
             {:name :body-of-ice, :prerequisites [[:skills/magery 2] :body-of-water :freeze], :college :water, :ref "Magic p. 189"}
             {:name :body-of-water, :prerequisites [:shape-water], :college :water, :ref "Magic p. 185"}
             {:name :boil-water, :prerequisites [:shape-water :heat], :college :water, :ref "Magic p. 189"}
             ;;{:name :cloud, :prerequisites [], :college :water, :ref "Magic: The Least of Spells p. 17"}
             {:name :condense-steam, :prerequisites [#{:cold :boil-water}], :college :water, :ref "Magic p. 189"}
             ;;{:name :cone-of-corrosion, :prerequisites [[:advantages/magery 4] :acid-jet], :college :water, :ref "Magic: Artillery Spells p. 27"}
             {:name :control-water-elemental, :prerequisites [:summon-water-elemental], :college :water, :ref "Magic p. 28"}
             {:name :coolness, :prerequisites [:cold], :college :water, :ref "Magic p. 187"}
             {:name :create-acid, :prerequisites [:create-water :create-earth], :college :water, :ref "Magic p. 190}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-ice, :prerequisites [:freeze], :college :water, :ref "Magic p. 188}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-spring, :prerequisites [:dry-spring :shape-water], :college :water, :ref "Magic p. 190"}
             {:name :create-steam, :prerequisites [:boil-water], :college :water, :ref "Magic p. 190"}
             {:name :create-water, :prerequisites [:purify-water], :college :water, :ref "Basic Set, p. 253}; Magic p. 184; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-water-elemental, :prerequisites [[:skills/magery 2] :control-water-elemental], :college :water, :ref "Magic p. 22"}
             {:name :current, :prerequisites [[6 :water]], :college :water, :ref "Magic p. 194"}
             {:name :dehydrate, :prerequisites [[5 :water] :destroy-water], :college :water, :ref "Magic p. 188"}
             {:name :destroy-water, :prerequisites [:create-water], :college :water, :ref "Basic Set, p. 253}; Magic p. 185"}
             ;;{:name :dissipate, :prerequisites [#{[[:advantages/magery 3] #{:body-of-water :earth-to-water :flesh-to-ice} :melt-ice] [[:advantages/magery 3] :body-of-fluid :earth-to-fluid]}] :college :water, :ref "Magic: Death Spells, p. 21 and Magical Styles: Dungeon Magic, p.8"}
             {:name :distill, :prerequisites [:mature :destroy-water], :college :water, :ref "[1]"}
             ;;{:name :drown, :prerequisites [[:advantages/magery 3] :breathe-air :breathe-water], :college :water, :ref "Magic: Death Spells, p. 21"}
             {:name :dry-spring, :prerequisites [:destroy-water :shape-earth], :college :water, :ref "Magic p. 188"}
             {:name :earth-to-water, :prerequisites [[:advantages/magery 1] :create-water :shape-earth], :college :water, :ref "Magic p. 52"}
             ;;{:name :elemental-plumbing, :prerequisites [:control-water-elemental], :college :water, :ref "Classic: Technomancer p. 38"}
             {:name :essential-acid, :prerequisites [[:advantages/magery 3] :all [6 :acid]], :college :water, :ref "Magic p. 192}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :essential-water, :prerequisites [[6 :water]], :college :water, :ref "Magic p. 189}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :flow, :prerequisites [:body-of-fluid], :college :water, :ref "Magical Styles: Dungeon Magic, p.9"}
             {:name :flesh-to-ice, :prerequisites [[:advantages/magery 1] :frostbite :body-of-water], :college :water, :ref "Magic p. 190"}
             {:name :fog, :prerequisites [:shape-water], :college :water, :ref "Basic Set, p. 253}; Magic p. 193"}
             {:name :foul-water, :prerequisites [:purify-water :decay], :college :water, :ref "Magic p. 185"}
             {:name :freeze, :prerequisites [:shape-water], :college :water, :ref "Magic p. 185"}
             {:name :frost, :prerequisites [#{:create-water :cold}], :college :water, :ref "Magic p. 193"}
             {:name :frostbite, :prerequisites [:frost :freeze], :college :water, :ref "Magic p. 189"}
             {:name :geyser, :prerequisites [[6 :water] :create-spring #{[4 :earth] [4 :fire]}], :college :water, :ref "Magic p. 190"}
             {:name :hail, :prerequisites [:snow], :college :water, :ref "Magic p. 195"}
             {:name :ice-dagger, :prerequisites [#{:ice-sphere :water-jet}], :college :water, :ref "Magic p. 188"}
             {:name :ice-slick, :prerequisites [:frost], :college :water, :ref "Magic p. 186"}
             {:name :ice-sphere, :prerequisites [:shape-water], :college :water, :ref "Magic p. 186"}
             {:name :ice-vision, :prerequisites [:shape-water], :college :water, :ref "Classic: Magic p. 37"}
             {:name :icy-breath, :prerequisites [[:advantages/magery 1] :snow-jet :resist-cold], :college :water, :ref "Magic p. 192"}
             ;;{:name :ice-storm, :prerequisites [[:advantages/magery 4] :hail :storm], :college :water, :ref "Magic: Artillery Spells p. 29"}
             {:name :icy-missile, :prerequisites [:icy-weapon], :college :water, :ref "Magic p. 186"}
             {:name :icy-touch, :prerequisites [[:advantages/magery 1] [5 :water]], :college :water, :ref "Magic p. 188"}
             {:name :icy-weapon, :prerequisites [:create-water], :college :water, :ref "Basic Set, p. 253}; Magic p. 185"}
             ;;{:name :mass-coolness, :prerequisites [[:attributes/int 12] :coolness], :college :water, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :infiltrate, :prerequisites [:body-of-fluid], :college :water, :ref "Magical Styles: Dungeon Magic, p. 9"}])

(def spells-by-name
  (reduce (fn [acc kv] (assoc acc (:name kv) (dissoc kv :name))) spells))

(def spells-by-college {:fire #{:warmth :resist-fire :seek-fire :flaming-missiles :rain-of-fire :summon-fire-elemental :explosive-fireball :slow-fire :deflect-energy :fire-cloud :phantom-flame :shape-fire :blast-ball :fireproof :ignite-fire :flaming-armor :create-fire-elemental :heat :resist-cold :cold :control-fire-elemental :create-fire :burning-death :smoke :fireball :essential-flame :body-of-flames :flame-jet :fast-fire :flaming-weapon :extinguish-fire :burning-touch :breathe-fire},
                        :necromantic #{:slow-healing :awaken-craft-spirit :astral-vision :soul-prison :animation :age :pestilence :bind-spirit :banish :animate-shadow :soul-jar :repel-spirits :astral-block :death-vision :final-rest :entrap-spirit :sense-spirit :control-zombie :solidify :hellspawn :mass-zombie :materialize :evisceration :skull-spirit :grasping-doom :burning-death :rotting-death :command-spirit :resurrection :lich :affect-spirits},
                        :movement #{:swim :transfer-pregnancy :cloud-walking :blink :lockmaster :manipulate :blink-other :great-haste :beacon :glue :hinder :flying-carpet :rapid-journey :locksmith :levitation :freedom :dancing-object :air-vortex :ethereal-body :remove-fetus :distant-blow :hawk-flight :trace-teleport :haste :divert-teleport :light-tread :cloud-vaulting :undo :slow :poltergeist :slide :wizard-hand :deflect-missile :winged-knife :teleport :flight :apportation :quick-march :pull :hold-fast :repel :slow-fall :jump :teleport-other :lighten-burden :long-march :wallwalker},
                        :sound #{:sound :wizard-ear :delayed-message :far-hearing :silver-tongue :resist-sound :invisible-wizard-ear :imitate-voice :converse :thunderclap :silence :echoes-of-the-past :alter-voice :noise :scribe :sound-jet :hush :sound-vision :great-voice :concussion :mage-stealth :wizard-mouth :wall-of-silence :garble :musical-scribe :keen-hearing :voices :message :disrupt},
                        :knowledge #{:small-vision :astral-vision :alarm :wizard-ear :far-hearing :tell-time :far-feeling :detect-magic :know-recipe :identify-spell :analyze-magic :remember-path :seek-magic :trace :echoes-of-the-past :memorize :history :tell-position :summon-shade :know-location :ancient-history :recall :earth-vision :plastic-vision :aura :mage-sight :test-load :measurement :divination :invisible-wizard-eye :pathfinder :wizard-eye :far-tasting :images-of-the-past :sense-mana :glass-wall :prehistory :wizard-hand :seeker :air-vision :necrovision :mage-sense :scents-of-the-past :seek-number :know-true-shape :wizard-nose :wizard-mouth :water-vision :see-secrets :schematic :mind-over-matter :find-direction :reconstruct-spell :metal-vision :projection :plant-vision},
                        :meta #{:spellguard :suspend-magery :counterspell :hang-spell :restore-mana :ward :remove-curse :dispel-magic :scryguard :curse :catch-spell :raise-cone-of-power :seek-magic :suspend-curse :great-ward :scrywall :telecast :false-aura :penetrating-spell :drain-magery :bless :sovereign-countermagic :suspend-mana :conceal-magic :pentagram :suspend-magic :magic-resistance :maintain-spell :throw-spell :lend-spell :spell-wall :displace-spell :spell-shield :drain-mana :suspend-spell :sovereign-ward :mana-vortex :reflect :remove-aura :steal-spell},
                        :air #{:shape-air :lightning-whip :predict-weather :destroy-air :cool :spark-cloud :earth-to-air :explosive-lightning :breathe-air :spark-storm :summon-air-elemental :lightning :air-vortex :storm :resist-lightning :body-of-wind :walk-on-air :purify-signal :windstorm :air-jet :wind :essential-air :atmosphere-dome :snow :warm :odor :shocking-touch :body-of-air :stroke-of-lightning :devitalize-air :wall-of-lightning :air-vision :create-air :concussion :stench :lightning-stare :lightning-missiles :sandstorm :clouds :seek-air :control-air-elemental :no-smell :lightning-armor :wall-of-wind :purify-air :ball-of-lightning :rain :breathe-water :lightning-weapon :body-of-lightning :create-air-elemental},
                        :enchantment #{:curse-virus :great-wish :simulacrum :suspend-enchantment :lesser-wish :speed :doppelganger :adjustable-clothing :golem :wish :ensorcel :amulet :talisman :temporary-enchantment :power :hex :costume :scroll :remove-enchantment :enchant :leak :impression-blocker :spell-stone :hideaway :resist-enchantment :malefice},
                        :healing #{:suspended-animation :stop-spasm :recover-energy :remove-contagion :cleansing :awaken :major-healing :relieve-paralysis :relieve-madness :halt-aging :cure-disease :resist-poison :restore-speech :restore-hearing :restoration :relieve-sickness :final-rest :restore-memory :resist-disease :lend-energy :stop-bleeding :transference-bolt :share-energy :cure-radiation :minor-healing :youth :instant-regeneration :share-vitality :regeneration :relieve-addiction :neutralize-poison :detect-poison :great-healing :lend-vitality :healing-slumber :instant-neutralize-poison :instant-restoration :resurrection :stop-paralysis :body-reading :restore-sight},
                        :light-and-darkness #{:small-vision :mass-invisibility :mage-light :gloom :continual-mage-light :wall-of-light :bright-vision :continual-sunlight :flash :colors :remove-shadow :disruption-bolt :hide :images-of-the-past :blur :remove-reflection :invisibility :continual-light :infravision :night-vision :shape-light :shape-darkness :light-jet :see-invisible :mirror :light :darkness :glow :sunbolt :body-of-shadow :shade :blackout :sunlight :dark-vision :hawk-vision},
                        :communication-and-empathy #{:exchange-bodies :mind-sending :broadcast-spell :persuasion :presence :switch-bodies :hide-emotion :gift-of-tongues :dream-viewing :control-person :hide-thoughts :possession :gift-of-letters :dispel-possession :compel-lie :sense-emotion :truthsayer :retrogression :dream-projection :borrow-skill :compel-truth :permanent-possession :communication :lend-language :telepathy :dream-sending :vexation :mind-reading :insignificance :lend-skill :sense-life :soul-rider :sense-foes :machine-speech :mind-whip :message :borrow-language :mind-search},
                        :earth #{:stone-to-earth :essential-earth :control-earth-elemental :volcano :alter-terrain :partial-petrification :move-terrain :rain-of-stones :purify-earth :earth-to-air :predict-earth-movement :seek-earth :seek-pass :sand-jet :entombment :shape-stone :shape-earth :walk-through-earth :earth-vision :stone-missile :flesh-to-stone :body-of-stone :summon-earth-elemental :earthquake :sandstorm :create-earth-elemental :earth-to-water :mud-jet :stone-to-flesh :create-earth :steelwraith :earth-to-stone},
                        :gate #{:phase-other :hide-object :blink :blink-other :timeslip-other :timeport :beacon :rapid-journey :accelerate-time :seek-gate :create-door :suspend-time :phase :plane-shift :time-out :trace-teleport :divert-teleport :slow-time :timeslip :planar-summons :scry-gate :timeport-other :teleport :teleport-shield :plane-shift-other :planar-visit :sanctuary :control-gate :teleport-other},
                        :animal #{:repel-animal :great-shapeshift :repel-hybrids :protect-animal :shapeshift-others :beast-summoning :spider-silk :beast-speech :permanent-shapeshifting :partial-shapeshifting :beast-rouser :rider-within :beast-seeker :beast-soother :animal-control :beast-possession :permanent-beast-possession :master :rider :beast-link :shapeshifting},
                        :making-and-breaking #{:weaken :awaken-craft-spirit :copy :shatterproof :knot :stiffen :mapmaker :transform-object :soilproof :dye :ruin :fasten :restore :inspired-creation :shatter :rejoin :inscribe :repair :animate-object :mystic-mark :draw-together-shards :sharpen :rive :enlarge-object :shrink-object :weapon-self :rebuild :contract-object :reshape :disintegrate :explode :find-weakness :toughen :transparency :clean :extend-object},
                        :protection-and-warning #{:utter-wall :warmth :protect-animal :sense-danger :resist-sound :mystic-mist :nightingale :reverse-missiles :missile-shield :shield :turn-blade :resist-lightning :resist-radiation :resist-poison :return-missile :umbrella :reflect-gaze :utter-dome :resist-disease :sense-observation :resist-water :watchdog :teleport-shield :resist-acid :resist-pressure :weather-dome :shade},
                        :water #{:acid-ball :icy-missile :dehydrate :condense-steam :ice-vision :body-of-ice :frost :geyser :freeze :frostbite :dry-spring :distill :ice-dagger :essential-acid :create-steam :icy-breath :flow :coolness :breathe-air :acid-jet :create-water-elemental :boil-water :create-water :icy-touch :destroy-water :icy-weapon :create-acid :hail :foul-water :infiltrate :essential-water :breathe-steam :current :ice-slick :body-of-water :create-spring :create-ice :earth-to-water :flesh-to-ice :control-water-elemental :fog :breathe-water :ice-sphere},
                        :mind-control #{:mass-charm :hallucination :permanent-madness :great-hallucination :forgetfulness :mass-suggestion :oath :panic :wisdom :charm :false-memory :rear-vision :ecstasy :relieve-madness :mass-hallucination :enslave :enthrall :memorize :command :compel-lie :suggestion :strengthen-will :boost-intelligence :encrypt :pacify :vigil :dream-projection :peaceful-sleep :recall :dull :weaken-will :permanent-forgetfulness :great-geas :disorient :madness :drunkenness :mental-stun :emotion-control :avoid :mass-daze :berserker :sickness :lesser-geas :fascinate :dream-sending :bravery :foolishness :glib-tongue :terror :loyalty :daze :alertness :will-lock :nightmare :mass-sleep :fear :sleep :dullness :keen :discord :mindlessness},
                        :illusion-and-creation #{:duplicate :illusion-disguise :create-servant :simple-illusion :create-mount :dispel-creation :phantom :control-illusion :create-animal :independence :initiative :inscribe :phantom-flame :know-illusion :create-object :perfect-illusion :illusion-shell :dispel-illusion :create-warrior :control-creation :complex-illusion},
                        :body-control #{:hold-breath :total-paralysis :boost-strength :haircut :rooted-feet :itch :stop-spasm :alter-body :transmogrification :enlarge :pain :transform-body :alter-visage :paralyze-limb :hinder :accelerate-pregnancy :might :boost-dexterity :decapitation :frailty :curse-missile :lengthen-limb :mouth-goes-away :climbing :shrink :alter-voice :spasm :perfume :vigor :clumsiness :mark-of-thieves :strike-barren :transform-other :roundabout :agonize :tickle :reflexes :cadence :resist-pain :balance :shrink-other :ambidexterity :nauseate :corpulence :gauntness :seek-emitter :debility :deathtouch :sensitize :tanglefoot :touch :weaken-blood :choke :despoil-seed :sickness :strike-blind :strike-numb :thirst :control-limb :wither-limb :grace :imp-face :boost-health :strike-dumb :strike-deaf :stun :enlarge-other :hunger :hair-growth :fumble :retch},
                        :technological #{:malfunction :awaken-computer :animate-machine :seek-machine :reveal-function :rebuild :machine-control :glitch :schematic :machine-summoning :permanent-machine-possession :machine-speech :machine-possession}})

(comment

  (defn kebab-case [s]
    (when s
      (-> s
          str
          (clojure.string/replace #"([a-z])([A-Z])" "$1-$2")
          (clojure.string/replace #"([A-Z]+)([A-Z][a-z])" "$1-$2")
          clojure.string/lower-case
          (clojure.string/replace #"\s+" "-")
          (clojure.string/replace #"[-]+$" ""))))

  (->> gurps.pages.character.utils.spells/spells
       (group-by :college)
       (map #(do {(key %) (into #{} (map (fn [e] (:name e)) (val %)))}))
       (reduce into {}))

  (+ 1 2)

  (defn get-unique-maps [key coll]
    (->> coll
         (group-by #(get % key))
         (vals)
         (map first))))

;; (-> :parsed
  ;;     (map #(str "(def ^:private '(symbol (keyword (kebab-case (get % :name)))) '" % ")"))
  ;;     (map cljs.reader/read-string))
