(ns gurps.pages.character.utils.spells)

(def spells [{:name :air-jet, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :prerequisite_count 9, :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] {:fire 1 :water 1 :earth 1 :ether 1}], :prerequisite_count 10, :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :prerequisite_count 4, :college :air, :ref "Basic Set p. 250; Magic p. 189"}
             {:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :cloud, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :prerequisite_count 4, :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :prerequisite_count 9, :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :prerequisite_count 9, :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :prerequisite_count 10, :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :prerequisite_count 2, :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-missiles, :prerequisites [:electric-weapon], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 28"}
             {:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [[6 :air]], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :prerequisite_count 8, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :prerequisite_count 7, :college :air, :ref "Magic: Artillery Spells p. 25"}
             {:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :jolt, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :other]], :prerequisite_count 6, :college :air, :ref "Basic Set p. 244; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :prerequisite_count 12, :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning :resist-lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :mighty-breath, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :mass-resist-lightning, :prerequisites [[:iq 13] :resist-lightning], :prerequisite_count nil, :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :prerequisite_count 2, :college :air, :ref "Magic p. 24"}
             {:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :prerequisite_count 7, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :prerequisite_count 1, :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :prerequisite_count 5, :college :air, :ref "Magic p. 195; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :safe-boarding, :prerequisites [[8 :air]], :prerequisite_count nil, :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic p. 23"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :prerequisite_count 2, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :prerequisite_count 2, :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :static-charge, :prerequisites [:purify-air [1 :air]], :prerequisite_count 2, :college :air, :ref "Classic: Technomancer p 17"}
             {:name :steal-breath, :prerequisites [[:skills/magery 3] [7 :air] :devitalize-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 244; Magic p. 23"}
             {:name :stinkguard, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :prerequisite_count 10, :college :air, :ref "Magic p. 195"}
             {:name :storm-shelter, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count nil, :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] [4 :air] #{:summon-fire-elemental :summon-water-elemental :summon-earth-elemental}], :prerequisite_count 5, :college :air, :ref "Magic p. 27"}
             {:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :prerequisite_count 8, :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :prerequisite_count 4, :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :prerequisite_count 4, :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [#{:beast-summoning :seeker}], :prerequisite_count 3, :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :call, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :creeping-plague, :prerequisites [#{[[:skills/magery 5] :beast-summoning :vermin-control]  [[:skills/magery 4] :create-animal]}], :prerequisite_count 13, :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting]], :prerequisite_count 15, :college :animal, :ref "Magic p. 34"}
             {:name :groom, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :hybrid-control, :prerequisites [:animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             {:name :insect-repellent, :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] #{:partial-shapeshifting :permanent-shapeshifting :shapeshifting :great-shapeshifting} :animal-control], :prerequisite_count 0, :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :shapeshifting], :prerequisite_count 12, :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdog :animal-spells], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :prerequisite_count 4, :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :animal]], :prerequisite_count 6, :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 32"}
             {:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :shapeshift-others], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :prerequisite_count 0, :college :body-control, :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
             {:name :ache, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :prerequisite_count 10, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :prerequisite_count 9, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :analgesic, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :belch, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :birth-control, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :blend-in, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :body-control]], :prerequisite_count 16, :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :curse], :prerequisite_count 0, :college :body-control, :ref "Classic: Magic p 24"}
             {:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             {:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :prerequisite_count 10, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :prerequisite_count 7, :college :body-control, :ref "Basic Set, p. 245; Magic, p. 41"}
             {:name :debility, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             {:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 11"}
             {:name :ease-labor, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             {:name :eat-crow, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             {:name :elvish-grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :prerequisite_count 2, :college :body-control, :ref "Classic: Technomancer p. 17"}
             {:name :flexibility, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :body-control]], :prerequisite_count 15, :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
             {:name :ley-running, :prerequisites [:seek-ley-line :haste], :prerequisite_count 1, :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :prerequisite_count 5, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 35"}
             {:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :prerequisite_count 9, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :stand-out, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-anosmic, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 35"}
             {:name :stifle, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-light :darkness-spells], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :throw-voice, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :prerequisite_count 13, :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :prerequisite_count 14, :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object :flesh-to-stone.], :prerequisite_count 32, :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :prerequisite_count 7, :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :absorb-book, :prerequisites [#{[:iq 13] :gift-of-letters}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             {:name :ack, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :borrow-number, :prerequisites [:seek-number], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :prerequisite_count 9, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :delete-commercials, :prerequisites [[:world/tl 7]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic p. 49"}
             {:name :drama, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :prerequisite_count 17, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46"}
             {:name :identify-caller, :prerequisites [:mind-reading :seek-number], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :illuminated-writing, :prerequisites [[:skills/magery 2] #{:mind-sending :fascinate [:skills/writing 12]}], :prerequisite_count 1, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :prerequisite_count 11, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :prerequisite_count 13, :college :communication-and-empathy, :ref "Magic, p. 176"}
             {:name :magic-switchboard, :prerequisites [:identify-caller], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :prerequisite_count 7, :college :communication-and-empathy, :ref "Magic, p. 173"}
             {:name :mer-speech, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy :thunderclap], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :prerequisite_count 1, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :sorcerous-signal, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :speed-data, :prerequisites [[:world/tl 7] #{:haste :lightning}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "4e spell chart"}
             {:name :telepathic-overload, :prerequisites [[:skills/magery 3] [10 :communication-and-empathy] :telepathy], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :wrong-number, :prerequisites [[:world/tl 6] #{:sense-foes :seek-number}], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-fire :shape-stone :shape-water :shape-air], :prerequisite_count 11, :college :earth, :ref "Magic, p. 55"}
             {:name :badger-paws, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :prerequisite_count 9, :college :earth, :ref "Magic, p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :prerequisite_count 10, :college :earth, :ref "Magic, p. 22"}
             {:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :earth, :ref "Basic Set, p. 243; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :prerequisite_count 6, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :prerequisite_count 6, :college :earth, :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :prerequisite_count 7, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :gargoyle-skin, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :prerequisite_count 29, :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :prerequisite_count 8, :college :earth, :ref "Magic, p. 52"}
             {:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :pebble, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :prerequisite_count 4, :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 53"}
             {:name :sand-blast, :prerequisites [[:skills/magery 4] :sand-jet :sandstorm], :prerequisite_count 0, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Magic, p. 51"}
             {:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :earth]], :prerequisite_count 5, :college :earth, :ref "Fantasy, p. 169"}
             {:name :spotless-hands, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :prerequisite_count 5, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{[[8 :earth]] [4 :earth #{:summon-fire-elemental :summon-water-elemental :summon-air-elemental}]}], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :prerequisite_count 13, :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             {:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :prerequisite_count 0, :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :prerequisite_count 0, :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             {:name :doom-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 23]], :prerequisite_count 18, :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :prerequisite_count 29, :college :enchantment, :ref "Magic p. 62; Classic: Magic p 40"}
             {:name :dwarfish-reinforcement, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :electric-power, :prerequisites [:lend-power :power :steal-power], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 20"}
             {:name :emergency-staff, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] [:gate 1] [:body-control 1] [:movement 1] [:food 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:protection-and-warning 1] [:meta 1] [:light-and-darkness 1]], :prerequisite_count 10, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :prerequisite_count 15, :college :enchantment, :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
             {:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  [5 :communication-and-empathy]], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :prerequisite_count 16, :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 61"}
             {:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :prerequisite_count 0, :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             {:name :live-libram, :prerequisites [:enchant :apportation], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 60"}
             {:name :magician's-minion, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             {:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 21"}
             {:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :prerequisite_count 0, :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             {:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :prerequisite_count 12, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :resilient-golem, :prerequisites [:golem :shatterproof], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] [:skills/writing 12]], :prerequisite_count 0, :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :sorcerer's-stand-in, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             {:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :prerequisite_count 0, :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :prerequisite_count 8, :college :enchantment, :ref "Magic p. 60"}
             {:name :spellbook-enchantment, :prerequisites [:scroll], :prerequisite_count 1, :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             {:name :spellgraft, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Bio-Tech, p. 32"}
             {:name :spellprocessor, :prerequisites [:scroll [:skills/computer-programming 15]], :prerequisite_count 1, :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 56; Fantasy, p. 23"}
             {:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :prerequisite_count 12, :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :prerequisite_count 17, :college :enchantment, :ref "Magic p. 61"}
             {:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count 0, :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :prerequisite_count 8, :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 7, :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :prerequisite_count 10, :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :prerequisite_count 6, :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :prerequisite_count 9, :college :fire, :ref "Magic p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :prerequisite_count 1, :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :prerequisite_count 10, :college :fire, :ref "Magic p. 22"}
             {:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :prerequisite_count 0, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :prerequisite_count 2, :college :fire, :ref "Basic Set, p. 246; Magic p. 73"}
             {:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ember, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :prerequisite_count 6, :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 75"}
             {:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 247; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :flameturning, :prerequisites [#{:resist-fire [:apportation :shape-fire]}], :prerequisite_count 0, :college :fire, :ref "Classic: Grimoire p. 30"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :prerequisite_count 5, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 75"}
             {:name :great-deflect-energy, :prerequisites [[:skills/magery 2] :deflect-energy], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :prerequisite_count 5, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :mass-detonate, :prerequisites [:detonate], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :oven-mitts, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :puff, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p 21"}
             {:name :self-destruct, :prerequisites [[:skills/magery 1] [1 :fire] [1 :necromantic] [1 :meta] :explode], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :prerequisite_count 9, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{[[8 :fire]] [[4 :fire] #{:summon-water-elemental :summon-earth-elemental :summon-air-elemental}]}], :prerequisite_count 8, :college :fire, :ref "Magic p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :prerequisite_count 7, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 74"}
             {:name :air-jet, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :prerequisite_count 9, :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] [1 :earth] [1 :fire] [1 :water] [1 :meta]], :prerequisite_count 10, :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :prerequisite_count 4, :college :air, :ref "Basic Set p. 250; Magic p. 189"}
             {:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :cloud, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :prerequisite_count 4, :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :prerequisite_count 9, :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :prerequisite_count 9, :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :prerequisite_count 10, :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :prerequisite_count 2, :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-missiles, :prerequisites [:electric-weapon], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 28"}
             {:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [:6-air-spells], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :prerequisite_count 8, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :prerequisite_count 7, :college :air, :ref "Magic: Artillery Spells p. 25"}
             {:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :jolt, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :air]], :prerequisite_count 6, :college :air, :ref "Basic Set p. 244; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :prerequisite_count 12, :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning :resist-lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :mighty-breath, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :mass-resist-lightning, :prerequisites [[:attributes/int 13]  :resist-lightning], :prerequisite_count nil, :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :prerequisite_count 2, :college :air, :ref "Magic p. 24"}
             {:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :prerequisite_count 7, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :prerequisite_count 1, :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :prerequisite_count 5, :college :air, :ref "Magic p. 195; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :safe-boarding, :prerequisites [[8 :air]], :prerequisite_count nil, :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic p. 23"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :prerequisite_count 2, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :prerequisite_count 2, :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :static-charge, :prerequisites [:purify-air [1 :air]], :prerequisite_count 2, :college :air, :ref "Classic: Technomancer p 17"}
             {:name :steal-breath, :prerequisites [[:skills/magery 3] [7 :air] :devitalize-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 244; Magic p. 23"}
             {:name :stinkguard, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :prerequisite_count 10, :college :air, :ref "Magic p. 195"}
             {:name :storm-shelter, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count nil, :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] #{[8 :air] [4 :air]} :another-summon-elemental-spell], :prerequisite_count 8, :college :air, :ref "Magic p. 27"}
             {:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :prerequisite_count 8, :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :prerequisite_count 4, :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :prerequisite_count 4, :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [:beast-summoning [2 :seek] :or-seeker], :prerequisite_count 3, :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :call, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :creeping-plague, :prerequisites [[:skills/magery 5] :beast-summoning #{:vermin-control [:skills/magery 4]} :create-animal], :prerequisite_count 13, :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting] [10 :other]], :prerequisite_count 15, :college :animal, :ref "Magic p. 34"}
             {:name :groom, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :hybrid-control, :prerequisites [[2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             {:name :insect-repellent, :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] :2-shapeshift-other :2-body-control :2-animal-control], :prerequisite_count 0, :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :appropriate-shapeshifting], :prerequisite_count 12, :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdog :animal-spells], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:the-appropriate-animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :prerequisite_count 4, :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :appropriate-shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :other]], :prerequisite_count 6, :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 32"}
             {:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :any-one-shapeshift-others-spell], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :prerequisite_count 0, :college :body-control, :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
             {:name :ache, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :prerequisite_count 10, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :prerequisite_count 9, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :analgesic, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :belch, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :birth-control, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :blend-in, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :other]], :prerequisite_count 16, :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :spell-used-in-missile], :prerequisite_count 0, :college :body-control, :ref "Classic: Magic p 24"}
             {:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch :choke :entombment :rotting-death :curse-evisceration :steal-beauty :deathtouch :frostbite :steal-skill :dehydrate :pestilence :stop-healing], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             {:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :prerequisite_count 10, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :prerequisite_count 7, :college :body-control, :ref "Basic Set, p. 245; Magic, p. 41"}
             {:name :debility, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             {:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 11"}
             {:name :ease-labor, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             {:name :eat-crow, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             {:name :elvish-grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :prerequisite_count 2, :college :body-control, :ref "Classic: Technomancer p. 17"}
             {:name :flexibility, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :other]], :prerequisite_count 15, :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
             {:name :ley-running, :prerequisites [:seek-ley-line :haste], :prerequisite_count 1, :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :prerequisite_count 5, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 35"}
             {:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :prerequisite_count 9, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :stand-out, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-anosmic, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 35"}
             {:name :stifle, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-ligh  :darkness], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :throw-voice, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :prerequisite_count 13, :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :prerequisite_count 14, :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object], :prerequisite_count 32, :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :prerequisite_count 7, :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :absorb-book, :prerequisites [#{[:attributes/int 13] :gift-of-letters}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             {:name :ack, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :borrow-number, :prerequisites [:seek-number], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :prerequisite_count 9, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :delete-commercia, :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic p. 49"}
             {:name :drama, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :prerequisite_count 17, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language #{:3-languages-written-at-accented :better}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language #{:3-languages-spoken-at-accented :better}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46"}
             {:name :identify-caller, :prerequisites [:mind-reading :seek-number], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :illuminated-writing, :prerequisites [[:skills/magery 2] :one-of-mind-sending :fascinate [:or-writing 12]], :prerequisite_count 1, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :prerequisite_count 11, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :prerequisite_count 13, :college :communication-and-empathy, :ref "Magic, p. 176"}
             {:name :magic-switchboard, :prerequisites [:identify-caller], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :prerequisite_count 7, :college :communication-and-empathy, :ref "Magic, p. 173"}
             {:name :mer-speech, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :prerequisite_count 1, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :sorcerous-signal, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :speed-data, :prerequisites [[:world/tl 7] :haste :lightning], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "4e spell chart"}
             {:name :telepathic-overload, :prerequisites [[:skills/magery 3] :any-10-communicatio [:empathy :telepathy]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :wrong-number, :prerequisites [[:world/tl 6] #{:sense-foes :seek-number}], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-water :shape-fire :shape-air :shape-stone], :prerequisite_count 11, :college :earth, :ref "Magic, p. 55"}
             {:name :badger-paws, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :prerequisite_count 9, :college :earth, :ref "Magic, p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :prerequisite_count 10, :college :earth, :ref "Magic, p. 22"}
             {:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :earth, :ref "Basic Set, p. 243; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :prerequisite_count 6, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :prerequisite_count 6, :college :earth, :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :prerequisite_count 7, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :gargoyle-skin, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :prerequisite_count 29, :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :prerequisite_count 8, :college :earth, :ref "Magic, p. 52"}
             {:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :pebble, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :prerequisite_count 4, :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 53"}
             {:name :sand-blast, :prerequisites [[:skills/magery 4] :s :jet :s :storm], :prerequisite_count 0, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Magic, p. 51"}
             {:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :other]], :prerequisite_count 5, :college :earth, :ref "Fantasy, p. 169"}
             {:name :spotless-hands, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :prerequisite_count 5, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :earth] [4 :earth]} :another-summon-elemental-spell], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :prerequisite_count 13, :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman-for-the-appropriate-spell], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             {:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :prerequisite_count 0, :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :prerequisite_count 0, :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             {:name :doom-wish, :prerequisites [[:skills/magery 3] :wish :iq-+-magery-of-23+], :prerequisite_count 18, :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :prerequisite_count 29, :college :enchantment, :ref "Magic p. 62; Classic: Magic p 40"}
             {:name :dwarfish-reinforcement, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :electric-power, :prerequisites [:lend-power :power :steal-power], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 20"}
             {:name :emergency-staff, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] :one-spell-from-10-other-colleges], :prerequisite_count 10, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :prerequisite_count 15, :college :enchantment, :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
             {:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  :five-communicatio  :empathy], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :prerequisite_count 16, :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 61"}
             {:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :prerequisite_count 0, :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             {:name :live-libram, :prerequisites [:enchant :apportation], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 60"}
             {:name :magician's-minion, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             {:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 21"}
             {:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :prerequisite_count 0, :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             {:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :prerequisite_count 12, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :resilient-golem, :prerequisites [:golem :shatterproof], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [:any-limiting-enchantment-spell], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] #{:1-written-language-at-accented :better}], :prerequisite_count 0, :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :sorcerer's-stand-in, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             {:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :prerequisite_count 0, :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :prerequisite_count 8, :college :enchantment, :ref "Magic p. 60"}
             {:name :spellbook-enchantment, :prerequisites [:scroll], :prerequisite_count 1, :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             {:name :spellgraft, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Bio-Tech, p. 32"}
             {:name :spellprocessor, :prerequisites [:scroll [:computer-programming 15]], :prerequisite_count 1, :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant :spell-to-be-opposed], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 56; Fantasy, p. 23"}
             {:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :prerequisite_count 12, :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :prerequisite_count 17, :college :enchantment, :ref "Magic p. 61"}
             {:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count 0, :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :prerequisite_count 8, :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 7, :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :prerequisite_count 10, :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :prerequisite_count 6, :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :prerequisite_count 9, :college :fire, :ref "Magic p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :prerequisite_count 1, :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :prerequisite_count 10, :college :fire, :ref "Magic p. 22"}
             {:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :prerequisite_count 0, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :prerequisite_count 2, :college :fire, :ref "Basic Set, p. 246; Magic p. 73"}
             {:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ember, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :prerequisite_count 6, :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 75"}
             {:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 247; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :flameturning, :prerequisites [:resist-fire :or-both-apportation :shape-fire], :prerequisite_count 0, :college :fire, :ref "Classic: Grimoire p. 30"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :prerequisite_count 5, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 75"}
             {:name :great-deflect-energy, :prerequisites [[:skills/magery 2]  :deflect-energy], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :prerequisite_count 5, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :mass-detonate, :prerequisites [:detonate], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :oven-mitts, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :puff, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p 21"}
             {:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :prerequisite_count 9, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :fire] [4 :fire]} :another-summon-elemental-spell], :prerequisite_count 8, :college :fire, :ref "Magic p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :prerequisite_count 7, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 74"}
             {:name :accelerate-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-each-from-10-colleges], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :beacon, :prerequisites [:teleport :timeport :plane-shift], :prerequisite_count 5, :college :gate, :ref "Magic p. 83; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :blink, :prerequisites [:teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :prerequisite_count 6, :college :gate, :ref "Magic p. 148"}
             {:name :control-gate, :prerequisites [[:skills/magery 3] :seek-gate], :prerequisite_count 12, :college :gate, :ref "Magic p. 85"}
             {:name :create-door, :prerequisites [:teleport :any-1-walk-through-spell], :prerequisite_count 10, :college :gate, :ref "Magic p. 84"}
             {:name :create-gate, :prerequisites [:control-gate :teleport :timeport :or-plane-shift], :prerequisite_count 14, :college :gate, :ref "Magic p. 85/Classic: Grimoire p 50"}
             {:name :dimensional-dissection, :prerequisites [[:skills/magery 3] :one-of-plane-shift-other :teleport-other :or-timeport-other], :prerequisite_count 0, :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :prerequisite_count 6, :college :gate, :ref "Magic p. 84"}
             {:name :easy-rider, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :hell-zone, :prerequisites [[:skills/magery 4] :beacon :planar-summons-for], :prerequisite_count 0, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :hide-object, :prerequisites [:hideaway :teleport], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :invoke, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 14-15"}
             {:name :null-sphere, :prerequisites [[:skills/magery 5] :create-gate], :prerequisite_count 15, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :phase, :prerequisites [[:skills/magery 3] #{:plane-shift :ethereal-body}], :prerequisite_count 5, :college :gate, :ref "Magic p. 83"}
             {:name :phase-other, :prerequisites [:phase], :prerequisite_count 6, :college :gate, :ref "Magic p. 83"}
             {:name :planar-summons, :prerequisites [[:skills/magery 1] :1-spell-from-10-other-colleges], :prerequisite_count 10, :college :gate, :ref "Basic Set p. 247; Magic p. 82"}
             {:name :planar-visit, :prerequisites [[:skills/magery 2] #{:projection :planar-summons}], :prerequisite_count 11, :college :gate, :ref "Magic p. 82"}
             {:name :plane-shift, :prerequisites [:planar-summons], :prerequisite_count 11, :college :gate, :ref "Basic Set p. 247; Magic p. 83"}
             {:name :plane-shift-other, :prerequisites [[:skills/magery 3] :plane-shift], :prerequisite_count 12, :college :gate, :ref "Magic p. 83"}
             {:name :rapid-journey, :prerequisites [[:skills/magery 3] #{:teleport :timeport}], :prerequisite_count 5, :college :gate, :ref "Magic p. 82"}
             {:name :reorient, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :sanctuary, :prerequisites [:hide-object], :prerequisite_count 21, :college :gate, :ref "Magic p. 86"}
             {:name :scry-gate, :prerequisites [:seek-gate], :prerequisite_count 11, :college :gate, :ref "Magic p. 85"}
             {:name :seek-gate, :prerequisites [[:skills/magery 2] :seek-magic :1-spell-from-each-of-10-colleges], :prerequisite_count 10, :college :gate, :ref "Magic p. 85"}
             {:name :slow-time, :prerequisites [[:skills/magery 2] [:attributes/int 13] :2-from-each-of-10-colleges], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :splat, :prerequisites [[:skills/magery 4] :create-door], :prerequisite_count 0, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :suspend-time, :prerequisites [[:skills/magery 3] :slow-time], :prerequisite_count 21, :college :gate, :ref "Magic p. 86"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :prerequisite_count 4, :college :gate, :ref "Magic p. 147; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:skills/magery 3] :teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 147"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :prerequisite_count 7, :college :gate, :ref "Magic p. 170"}
             {:name :time-out, :prerequisites [[:skills/magery 3] :accelerate-time], :prerequisite_count 21, :college :gate, :ref "Magic p. 87"}
             {:name :timeport, :prerequisites [[:skills/magery 3] :teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 81"}
             {:name :timeport-other, :prerequisites [:timeport], :prerequisite_count 6, :college :gate, :ref "Magic p. 81"}
             {:name :timeslip, :prerequisites [:timeport], :prerequisite_count 6, :college :gate, :ref "Magic p. 81"}
             {:name :timeslip-other, :prerequisites [:timeslip], :prerequisite_count 7, :college :gate, :ref "Magic p. 81"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :prerequisite_count 5, :college :gate, :ref "Magic p. 84"}
             {:name :underworld-imprisonment, :prerequisites [[:skills/magery 3] :one-plane-shift-other-spell], :prerequisite_count 13, :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :aid, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :aide, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :analgesic, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :archmagi's-recuperation, :prerequisites [:prerequisites:-iq-14+ [:skills/magery 4] :lend-energy], :prerequisite_count 0, :college :healing, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :awaken, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Basic Set, p. 248; Magic p. 90"}
             {:name :bender-defender, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :birth-control, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :body-reading, :prerequisites [#{:sense-life :awaken}], :prerequisite_count 1, :college :healing, :ref "Magic p. 91"}
             {:name :cleansing, :prerequisites [:minor-healing :purify-earth], :prerequisite_count 12, :college :healing, :ref "Magic p. 94"}
             {:name :cure-addiction, :prerequisites [:relieve-addiction], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-dehydration, :prerequisites [[:skills/magery 1] :minor-healing :create-water], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :cure-disease, :prerequisites [:major-healing :relieve-sickness], :prerequisite_count 5, :college :healing, :ref "Magic p. 91; Fantasy, p. 170"}
             {:name :cure-insanity, :prerequisites [:major-healing :relieve-madness [5 :mind]], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-radiation, :prerequisites [:resist-radiation :major-healing], :prerequisite_count 12, :college :healing, :ref "Magic p. 182"}
             {:name :cure-starvation, :prerequisites [[:skills/magery 1] :minor-healing :create-food], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :detect-poison, :prerequisites [#{:sense-danger :test-food}], :prerequisite_count 1, :college :healing, :ref "Magic p. 166"}
             {:name :disinfect, :prerequisites [[:skills/magery 4] [10 :healing] :cure-disease :remove-contagion], :prerequisite_count 10, :college :healing, :ref "Magic: Artillery Spells p. 17"}
             {:name :ease-labor, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
             {:name :euthanize, :prerequisites [[1 :communication-and-empathy] [:skills/magery 1] :spirit-empathy], :prerequisite_count 0, :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :final-rest, :prerequisites [#{[:skills/magery 1] :spirit-empathy}], :prerequisite_count 0, :college :healing, :ref "Magic p. 89"}
             {:name :great-healing, :prerequisites [[:skills/magery 3] :major-healing], :prerequisite_count 4, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :halt-aging, :prerequisites [[:skills/magery 2] [8 :healing]], :prerequisite_count 8, :college :healing, :ref "Magic p. 94"}
             {:name :healing-slumber, :prerequisites [[:skills/magery 2] :sleep :minor-healing], :prerequisite_count 6, :college :healing, :ref "Magic p. 94"}
             {:name :instant-neutralize-poison, :prerequisites [[:skills/magery 2] :neutralize-poison], :prerequisite_count 2, :college :healing, :ref "Magic p. 92"}
             {:name :instant-regeneration, :prerequisites [[:skills/magery 3] :regeneration], :prerequisite_count 6, :college :healing, :ref "Magic p. 93"}
             {:name :instant-restoration, :prerequisites [[:skills/magery 2] :restoration], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :lend-energy, :prerequisites [#{[:skills/magery 1] :empathy}], :prerequisite_count 0, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :lend-vitality, :prerequisites [:lend-energy], :prerequisite_count 1, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :major-healing, :prerequisites [[:skills/magery 1] :minor-healing], :prerequisite_count 3, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :mass-resist-disease, :prerequisites [[:attributes/int 13]  :resist-disease], :prerequisite_count 4, :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :mass-resist-poison, :prerequisites [[:attributes/int 13]  :resist-poison], :prerequisite_count 4, :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :minor-healing, :prerequisites [:lend-vitality], :prerequisite_count 0, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :neutralize-poison, :prerequisites [#{:cure-disease [:skills/magery 3]} :test-food], :prerequisite_count 1, :college :healing, :ref "Magic p. 92"}
             {:name :recover-energy, :prerequisites [[:skills/magery 1] :lend-energy], :prerequisite_count 1, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :regeneration, :prerequisites [[:skills/magery 2] :restoration], :prerequisite_count 5, :college :healing, :ref "Magic p. 93"}
             {:name :relieve-addiction, :prerequisites [:neutralize-poison], :prerequisite_count 2, :college :healing, :ref "Magic p. 92|-"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :prerequisite_count 9, :college :healing, :ref "Magic p. 92"}
             {:name :relieve-paralysis, :prerequisites [:stop-paralysis], :prerequisite_count 2, :college :healing, :ref "Magic p. 93"}
             {:name :relieve-sickness, :prerequisites [:lend-vitality], :prerequisite_count 9, :college :healing, :ref "Magic p. 90"}
             {:name :remove-contagion, :prerequisites [:decay :clean :or-cure-disease], :prerequisite_count 2, :college :healing, :ref "Magic p. 90"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :healing, :ref "Bio-Tech, p. 32; Technomancer p. 22"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :prerequisite_count 3, :college :healing, :ref "Magic p. 90"}
             {:name :resist-poison, :prerequisites [:vigor], :prerequisite_count 3, :college :healing, :ref "Magic p. 91"}
             {:name :restoration, :prerequisites [:major-healing :relieve-paralysis :restore], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :restore-hearing, :prerequisites [:minor-healing #{:keen-hearing :strike-deaf}], :prerequisite_count 4, :college :healing, :ref "Magic p. 92"}
             {:name :restore-memory, :prerequisites [:awaken [:iq 11]], :prerequisite_count 3, :college :healing, :ref "Magic p. 92"}
             {:name :restore-sight, :prerequisites [:minor-healing #{:keen-vision :strike-blind}], :prerequisite_count 4, :college :healing, :ref "Magic p. 92"}
             {:name :restore-speech, :prerequisites [:minor-healing #{:great-voice :strike-dumb}], :prerequisite_count 6, :college :healing, :ref "Magic p. 93"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :prerequisite_count 9, :college :healing, :ref "Magic p. 94"}
             {:name :resuscitate, :prerequisites [[:skills/magery 2] :awaken :stop-spasm], :prerequisite_count 0, :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :sea-legs, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 17"}
             {:name :sense-disease, :prerequisites [#{:sense-life [2 :healing]}], :prerequisite_count 1, :college :healing, :ref "Bio-Tech, p. 32; Technomaner p 22"}
             {:name :share-energy, :prerequisites [:lend-energy], :prerequisite_count 1, :college :healing, :ref "Magic p. 89"}
             {:name :share-vitality, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Magic p. 90"}
             {:name :stop-bleeding, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Magic p. 91; Fantasy, p. 169"}
             {:name :stop-paralysis, :prerequisites [:minor-healing :paralyze-limb :or-strike-dumb], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :prerequisite_count 2, :college :healing, :ref "Magic p. 35"}
             {:name :suspended-animation, :prerequisites [:sleep [4 :healing]], :prerequisite_count 7, :college :healing, :ref "Magic p. 94"}
             {:name :test, :type :area :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :healing, :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
             {:name :transference-bolt, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count 0, :college :healing, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :youth, :prerequisites [[:skills/magery 3] :halt-aging], :prerequisite_count 9, :college :healing, :ref "Magic p. 94"}
             {:name :blend-in, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :complex-illusion, :prerequisites [:sound :simple-illusion], :prerequisite_count 2, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :control-creation, :prerequisites [#{:create-animal :create-servant}], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :control-illusion, :prerequisites [:perfect-illusion], :prerequisite_count 2, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :create-animal, :prerequisites [:create-water :create-object [:attributes/int 12]], :prerequisite_count 12, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-foreign-body, :prerequisites [[:skills/magery 3] :body-reading :create-object], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :create-mount, :prerequisites [[:skills/magery 3] :create-animal], :prerequisite_count 13, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :create-object, :prerequisites [[:skills/magery 2] :create-earth :perfect-illusion], :prerequisite_count 8, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-servant, :prerequisites [[:skills/magery 3] [:attributes/int 12] :create-object], :prerequisite_count 9, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-trap, :prerequisites [[:skills/magery 4] [10 :illusion-and-create]], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17"}
             {:name :create-warrior, :prerequisites [:create-servant], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :disbelieve, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :dispel-creation, :prerequisites [:control-creation], :prerequisite_count 11, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :dispel-illusion, :prerequisites [:control-illusion], :prerequisite_count 5, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :duplicate, :prerequisites [:create-object :copy], :prerequisite_count 15, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :gargoyle-skin, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 8"}
             {:name :illusion-disguise, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170"}
             {:name :illusion-shell, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
             {:name :image, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :independence, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96"}
             {:name :initiative, :prerequisites [:independence :wisdom], :prerequisite_count 9, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :prerequisite_count 7, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :know-illusion, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :mirror, :prerequisites [[:skills/magery 4] :initiative :phantom], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17-18"}
             {:name :perfect-illusion, :prerequisites [[:skills/magery 1] :complex-illusion], :prerequisite_count 3, :college :illusion-and-creation, :ref "Magic p. 96; 'Social Engineering: Back to School, p. 24"}
             {:name :phantom, :prerequisites [[:skills/magery 2] :perfect-illusion :hinder :apportation], :prerequisite_count 7, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 73"}
             {:name :phantom-killer, :prerequisites [[:skills/magery 3] :phantom], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :shadowplay, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :simple-illusion, :prerequisites [:no-blindness [:iq 11]], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic p. 95; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :stand-out, :type :area :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :air-vision, :prerequisites [:shape-air], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 24"}
             {:name :alarm, :prerequisites [:tell-time], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 100"}
             {:name :analyze-magic, :prerequisites [:identify-spell], :prerequisite_count 3, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 102"}
             {:name :analyze-heredity, :prerequisites [#{:seeker :sense-life}], :prerequisite_count 1, :college :knowledge, :ref "Bio-Tech, p. 30; Technomancer p 23"}
             {:name :ancient-history, :prerequisites [:history], :prerequisite_count 5, :college :knowledge, :ref "Magic, p. 106"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :aura, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 101"}
             {:name :detect-magic, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 101"}
             {:name :divination, :prerequisites [:skills/history], :prerequisite_count nil, :college :knowledge, :ref "Magic, p. 108; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-vision, :prerequisites [:shape-earth], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 51"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 107"}
             {:name :far-feeling, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :far-hearing, :prerequisites [[:skills/magery 1] [4 :sound]], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 173"}
             {:name :far-tasting, :prerequisites [[:skills/magery 1] #{:seek-food :seek-air}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 77"}
             {:name :find-direction, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 101"}
             {:name :forbidden-wisdom, :prerequisites [[:skills/magery 3] :recall :see-secrets], :prerequisite_count 0, :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :glass-wall, :prerequisites [#{[5 :knowledge] :earth-vision}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 103"}
             {:name :history, :prerequisites [:trace], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 104"}
             {:name :identify-loot, :prerequisites [[:skills/magery 2]  [7 :fourth-level]], :prerequisite_count 0, :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :identify-spell, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 102"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :invisible-wizard-eye, :prerequisites [:wizard-eye :invisibility], :prerequisite_count 10, :college :knowledge, :ref "Magic, p. 104"}
             {:name :keyfinder, :type :area :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-location, :prerequisites [[:skills/magery 1] :tell-position], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 103"}
             {:name :know-recipe, :prerequisites [:far-tasting :season], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 78"}
             {:name :know-thyself, :type :area :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-true-shape, :prerequisites [[:skills/magery 1] [1 :shifting] #{:aura :know-illusion}], :prerequisite_count 9, :college :knowledge, :ref "Magic, p. 104"}
             {:name :mage-sense, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :mage-sight, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :measurement, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105; Social Engineering: Back to School, p. 24"}
             {:name :metal-vision, :prerequisites [:shape-metal], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 183"}
             {:name :mind-over-matter, :prerequisites [[:skills/magery 2] [1 :divination]], :prerequisite_count 0, :college :knowledge, :ref "Magic Styles: Dungeon Magic, p. 27"}
             {:name :necrovision, :prerequisites [:lightning :seek-emitter], :prerequisite_count 0, :college :knowledge, :ref "Technomancer p 23"}
             {:name :pathfinder, :prerequisites [[:skills/magery 1] [:attributes/int 12] [2 :seek]], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 105"}
             {:name :plant-vision, :prerequisites [:shape-plant], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 162"}
             {:name :plastic-vision, :prerequisites [:shape-plastic], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 183"}
             {:name :prehistory, :prerequisites [:ancient-history], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 104"}
             {:name :projection, :prerequisites [:sense-spirit [4 :knowledge]], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :prerequisite_count 9, :college :knowledge, :ref "Magic, p. 104"}
             {:name :reconstruct-spell, :prerequisites [[:skills/magery 2] :history :identify-spell], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 104"}
             {:name :remember-path, :prerequisites [:find-direction :memorize], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 105"}
             {:name :retro-reading, :prerequisites [:trace], :prerequisite_count 4, :college :knowledge, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :scents-of-the-past, :prerequisites [[:skills/magery 2] :history :odor], :prerequisite_count 8, :college :knowledge, :ref "Magic, p. 107"}
             {:name :schematic, :prerequisites [:reveal-function :history], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 177"}
             {:name :see-secrets, :prerequisites [:seeker :aura], :prerequisite_count 5, :college :knowledge, :ref "Magic, p. 105; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :seek-ley-line, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :seek-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :seek-navy, :prerequisites [[8 :third-level]], :prerequisite_count 0, :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :prerequisite_count 0, :college :knowledge, :ref "Technomancer p. 18"}
             {:name :seeker, :prerequisites [[:skills/magery 1] [:attributes/int 12] :2-'seek-'spells], :prerequisite_count 2, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 105"}
             {:name :sense-mana, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 111"}
             {:name :summon-shade, :prerequisites [#{:summon-spirit :divination}], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 102"}
             {:name :sweet-oblivion, :type :area :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :televisomancy, :prerequisites [[:skills/magery 1] #{[6 :knowledge] [:skills/electronics-operation_communications 15]}], :prerequisite_count 0, :college :knowledge, :ref "Classic: Technomancer p 23"}
             {:name :tell-position, :prerequisites [:measurement], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :tell-time, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :test, :type :area :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 10"}
             {:name :test-load, :prerequisites [:measurement], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :thaumatomancy, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 12"}
             {:name :trace, :prerequisites [:seeker], :prerequisite_count 3, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 106"}
             {:name :vision-of-doom, :prerequisites [[:skills/magery 3] :summon-shade], :prerequisite_count 0, :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :water-vision, :prerequisites [:shape-water], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 187"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-eye, :prerequisites [:apportation :keen-vision], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-nose, :prerequisites [:apportation :far-tasting], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 104"}
             {:name :blackout, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :blur, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Basic Set p. 250; Magic p. 113"}
             {:name :body-of-shadow, :prerequisites [[:skills/magery 2] :shape-darkness], :prerequisite_count 4, :college :light-and-darkness, :ref "M114"}
             {:name :bright-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :cleansing-light, :prerequisites [[:skills/magery 3] [10 :light-and-darkness] :flash :light-jet :sunbolt], :prerequisite_count 10, :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :coherent-light-jet, :prerequisites [:light-jet], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :colors, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :continual-light, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Basic Set p. 249; Magic p. 110"}
             {:name :continual-mage-light, :prerequisites [:mage-light :continual-light], :prerequisite_count 5, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :continual-sunlight, :prerequisites [:sunlight], :prerequisite_count 5, :college :light-and-darkness, :ref "Classic: Magic p 64/Magic, p. 114"}
             {:name :dark-vision, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :darkness, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Basic Set p. 250; Magic p. 111"}
             {:name :disruption-bolt, :prerequisites [:spectrum-vision [6 :light-and-darkness] :radiation], :prerequisite_count 0, :college :light-and-darkness, :ref "Technomancer p 24"}
             {:name :flash, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :gloom, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :glow, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :goggles, :type :area :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :hawk-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :hide, :prerequisites [#{:blur :forgetfulness}], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113; Fantasy, p. 170"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 105"}
             {:name :infrared-flash, :prerequisites [:flash :colors], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :infravision, :prerequisites [#{:keen-vision [5 :light]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13]], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 114; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :invisible-sunbolt, :prerequisites [[:skills/magery 3] :spectrum-vision :sunbolt], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :light, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Basic Set p. 253; Magic p. 110"}
             {:name :light-jet, :prerequisites [#{:continual-light :shape-light}], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :mage-light, :prerequisites [:mage-sight :light], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :mass-invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic Styles: Dungeon Magic, p. 32"}
             {:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :prerequisite_count 0, :college :light-and-darkness, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :mirror, :prerequisites [:colors], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :night-vision, :prerequisites [[5 :light-and-darkness] :keen-vision], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111; Fantasy, p. 170"}
             {:name :phosphorescence, :type :area :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :remove-reflection, :prerequisites [:remove-shadow], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :remove-shadow, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :see-invisible, :prerequisites [#{:dark-vision :infravision :invisibility}], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shadowplay, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 11"}
             {:name :shadow-slay, :prerequisites [[:skills/magery 3] :body-of-shadow :remove-shadow], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 169"}
             {:name :shape-darkness, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shape-light, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :sunbolt, :prerequisites [:6-ligh [:darkness :sunlight]], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 114"}
             {:name :sunburst, :prerequisites [[:skills/magery 4] [10 :light-and-darkness] :sunbolt], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: Artillery Spells p. 18"}
             {:name :sunlight, :prerequisites [[:skills/magery 1] :glow :colors], :prerequisite_count 4, :college :light-and-darkness, :ref "Magic p. 114"}
             {:name :twinkle, :type :area :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :wall-of-light, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :animate-object, :prerequisites [[:skills/magery 2] [3 :shape]], :prerequisite_count 6, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :annihilation, :prerequisites [[:skills/magery 3] :disintegrate #{:deathtouch :steal-vitality}], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :prerequisite_count 3, :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :clean, :prerequisites [:restore], :prerequisite_count 2, :college :making-and-breaking, :ref "Magic p. 116; Classic: Technomancer p 25"}
             {:name :contract-object, :prerequisites [[:skills/magery 3] :transform-object], :prerequisite_count 15, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :copy, :prerequisites [:dye :1-written-language-at-accented], :prerequisite_count 5, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :destabilization, :prerequisites [[:skills/magery 3] :annihilation :explode], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :disintegrate, :prerequisites [[:skills/magery 2] :shatter :ruin :earth-to-air :destroy-air :destroy-water], :prerequisite_count 17, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :draw-together-shards, :prerequisites [:repair :trace :apportation], :prerequisite_count 0, :college :making-and-breaking, :ref "Alphabet Arcane, p. 9"}
             {:name :dye, :prerequisites [:restore :colors], :prerequisite_count 4, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :enlarge-object, :prerequisites [:extend-object], :prerequisite_count 16, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :explode, :prerequisites [[:skills/magery 2] :shatter :apportation], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :explosive-mine, :prerequisites [[:skills/magery 3] :10-makin [:breaking :explode]], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :extend-object, :prerequisites [[:skills/magery 3] :transform-object], :prerequisite_count 15, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :fasten, :prerequisites [:knot], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :find-weakness, :prerequisites [:1-spell-from-each-of-4-elements], :prerequisite_count 4, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :immediate-action, :prerequisites [#{:apportation :find-weakness}], :prerequisite_count 0, :college :making-and-breaking, :ref "Classic: Technomancer p. 25"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 97"}
             {:name :inspired-creation, :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :knot, :prerequisites [:stiffen], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :mapmaker, :prerequisites [:inscribe :measurement], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :minefield, :prerequisites [[:skills/magery 4] :explosive-mine], :prerequisite_count 11, :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :mystic-mark, :prerequisites [:dye :trace], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :rebuild, :prerequisites [[:skills/magery 3] :repair :create-object [:3-of-each-element]], :prerequisite_count 22, :college :making-and-breaking, :ref "Magic p. 177"}
             {:name :rejoin, :prerequisites [:weaken :restore], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :repair, :prerequisites [[:skills/magery 2] :rejoin], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :reshape, :prerequisites [[:skills/magery 1] :weaken #{:shape-earth :shape-plant}], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :restore, :prerequisites [#{:find-weakness :simple-illusion}], :prerequisite_count 1, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :rive, :prerequisites [[:skills/magery 2] :shatter], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :ruin, :prerequisites [[:skills/magery 1] :weaken :decay], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :self-repairing, :prerequisites [[:skills/magery 2] :repair], :prerequisite_count 9, :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :sharpen, :prerequisites [:repair], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shatter, :prerequisites [[:skills/magery 1] :weaken], :prerequisite_count 6, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :shatterproof, :prerequisites [:repair :shatter], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shrink-object, :prerequisites [:contract-object], :prerequisite_count 16, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :soilproof, :prerequisites [:materialize], :prerequisite_count 3, :college :making-and-breaking, :ref "Magic p. 116; Thaumatology: Urban Magics, p. 33"}
             {:name :soul-creation, :prerequisites [:inspired-creation], :prerequisite_count 1, :college :making-and-breaking, :ref "Classic: Magic Items 3 p. 31"}
             {:name :stiffen, :prerequisites [:rejoin], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :tack, :type :area :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :toughen, :prerequisites [:shatterproof], :prerequisite_count 11, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :transfigure-object, :prerequisites [[:skills/magery 3] :transform-object], :prerequisite_count 0, :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :transform-object, :prerequisites [:m2 :reshape [4 :create]], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :transparency, :prerequisites [:dye :stone-to-earth], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :weaken, :prerequisites [:find-weakness], :prerequisite_count 5, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :weapon-self, :prerequisites [[:skills/magery 2] :apportation :6-makin [:breaking :reshape]], :prerequisite_count 12, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :wizardly-workshop, :type :area :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :bless, :prerequisites [[:skills/magery 2] :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 129"}
             {:name :catch-spell, :prerequisites [[:skills/magery 2] [:attributes/dex 12] :return-missile], :prerequisite_count 2, :college :meta, :ref "Magic p. 123"}
             {:name :charge-powerstone, :prerequisites [[:skills/magery 3] :powerstone :lend-energy], :prerequisite_count 12, :college :meta, :ref "Magic p. 126/Classic: Grimoire p. 74"}
             {:name :conceal-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :meta, :ref "Magic p. 122, Thaumatology: Urban Magics"}
             {:name :counterspell, :prerequisites [[:skills/magery 1] :spell-being-countered], :prerequisite_count 0, :college :meta, :ref "Basic Set, p. 250; Magic p. 121"}
             {:name :curse, :prerequisites [[:skills/magery 2] :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 129"}
             {:name :dispel-magic, :prerequisites [:counterspell [12 :other]], :prerequisite_count 13, :college :meta, :ref "Basic Set, p. 250; Magic p. 126"}
             {:name :dispel-spark, :prerequisites [[:skills/magery 3] :drain-mana :remove-aura], :prerequisite_count 0, :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :displace-spell, :prerequisites [:suspend-magic], :prerequisite_count 10, :college :meta, :ref "Magic p. 124, Thaumatology: Urban Magics"}
             {:name :drain-magery, :prerequisites [[:skills/magery 3] :suspend-magery], :prerequisite_count 21, :college :meta, :ref "Magic p. 130"}
             {:name :drain-mana, :prerequisites [:dispel-magic :suspend-mana], :prerequisite_count 14, :college :meta, :ref "Magic p. 127"}
             {:name :dread-curse, :prerequisites [[:skills/magery 3] :curse], :prerequisite_count 0, :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :end-scene, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :false-aura, :prerequisites [:conceal-magic :aura], :prerequisite_count 5, :college :meta, :ref "Magic p. 122"}
             {:name :great-ward, :prerequisites [[:skills/magery 2] :ward], :prerequisite_count 1, :college :meta, :ref "Magic p. 122"}
             {:name :hang-spell, :prerequisites [:delay], :prerequisite_count 16, :college :meta, :ref "Magic p. 128; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
             {:name :internalize-elixir, :prerequisites [[:skills/magery 1] :detect-magic :know-recipie], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 10"}
             {:name :lend-spell, :prerequisites [[:skills/magery 1] :lend-skill :1-spell-each-from-6-colleges], :prerequisite_count 11, :college :meta, :ref "Magic p. 126"}
             {:name :ley-buffer, :prerequisites [[:skills/magery 1] :ley-tap], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 21"}
             {:name :ley-supply, :prerequisites [:ley-tap #{:lend-energy :minor-draw-power}], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :magic-resistance, :prerequisites [[:skills/magery 1] :1-spell-each-from-7-colleges], :prerequisite_count 7, :college :meta, :ref "Magic p. 123"}
             {:name :mana-storm, :prerequisites [[:skills/magery 4] :drain-mana :restore-man], :prerequisite_count 0, :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :mana-vortex, :prerequisites [[:skills/magery 2] :lend-energy :sense-danger], :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 27; Thaumatology: Urban Magics"}
             {:name :maintain-spell, :prerequisites [:link], :prerequisite_count 17, :college :meta, :ref "Magic p. 128; Thaumatology: Urban Magics"}
             {:name :penetrating-spell, :prerequisites [:delay :find-weakness], :prerequisite_count 16, :college :meta, :ref "Magic p. 123"}
             {:name :pentagram, :prerequisites [:spell-shield], :prerequisite_count 9, :college :meta, :ref "Magic p. 124; Thaumatology: Urban Magics"}
             {:name :preemptive-experience, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :punishment-circle, :prerequisites [[:skills/magery 3] #{:pentagram :repel-spirits}], :prerequisite_count 0, :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :raise-cone-of-power, :prerequisites [:lend-energy #{:pentagram :restore-mana}], :prerequisite_count 0, :college :meta, :ref "GURPS Thaumatology, p. 52"}
             {:name :reflect, :prerequisites [:ward], :prerequisite_count 1, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics"}
             {:name :remove-aura, :prerequisites [:dispel-magic :aura], :prerequisite_count 14, :college :meta, :ref "Magic p. 127"}
             {:name :remove-curse, :prerequisites [[:skills/magery 2] :1-spell-from-each-of-15-colleges], :prerequisite_count 15, :college :meta, :ref "Magic p. 126; Thaumatology: Urban Magics"}
             {:name :restore-mana, :prerequisites [:dispel-magic :suspend-mana], :prerequisite_count 14, :college :meta, :ref "Magic p. 128; Thaumatology: Urban Magics"}
             {:name :scryfool, :prerequisites [[:skills/magery 2] :sense-observation :simple-illusion], :prerequisite_count 3, :college :meta, :ref "Magic p. 123; Classic: Grimoire p 74"}
             {:name :scryguard, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "GURPS Fantasy, p. 170; Thaumatology: Urban Magics"}
             {:name :scrywall, :prerequisites [:scryguard], :prerequisite_count 1, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics, p. 33"}
             {:name :seek-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :meta, :ref "Magic p. 102"}
             {:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :prerequisite_count 10, :college :meta, :ref "Magic: Artillery Spells p. 23"}
             {:name :sovereign-countermagic, :prerequisites [[:skills/magery 3] :analyze-magic :dispel-magic], :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :sovereign-ward, :prerequisites [[:skills/magery 3] :dispel-magic :ward], :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :spell-shield, :prerequisites [[:skills/magery 2] :scryguard :magic-resistance], :prerequisite_count 8, :college :meta, :ref "Magic p. 124"}
             {:name :spell-wall, :prerequisites [:spell-shield], :prerequisite_count 9, :college :meta, :ref "Magic p. 124; Thaumatology: Urban Magics"}
             {:name :spellguard, :prerequisites [:dispel-magic], :prerequisite_count 14, :college :meta, :ref "Magic p. 127; Thaumatology: Urban Magics"}
             {:name :steal-spell, :prerequisites [:lend-spell :great-ward], :prerequisite_count 13, :college :meta, :ref "Magic p. 127"}
             {:name :suspend-curse, :prerequisites [[:skills/magery 1] :1-spell-each-from-12-colleges], :prerequisite_count 12, :college :meta, :ref "Magic p. 125"}
             {:name :suspend-magery, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 130"}
             {:name :suspend-magic, :prerequisites [:suspend-spell [8 :other]], :prerequisite_count 8, :college :meta, :ref "Magic p. 123"}
             {:name :suspend-mana, :prerequisites [:suspend-magic :1-spell-each-from-10-colleges], :prerequisite_count 10, :college :meta, :ref "Magic p. 125"}
             {:name :suspend-spell, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "Magic p. 121; Thaumatology: Urban Magics"}
             {:name :telecast, :prerequisites [[:skills/magery 3] :teleport :wizard-eye :1-spell-each-from-10-colleges], :prerequisite_count 12, :college :meta, :ref "Magic p. 128"}
             {:name :thaumatomancy, :type :area :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Magic: The Least of Spells p. 12"}
             {:name :throw-spell, :prerequisites [:delay :catch-spell], :prerequisite_count 16, :college :meta, :ref "Magic p. 128"}
             {:name :use-item, :type :area :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Magic: The Least of Spells p. 12-13"}
             {:name :void-bolt, :prerequisites [[:skills/magery 4] :4-essentials-taken-as-prerequisites [4 :missile]], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/25: Epic Magic, p. 19"}
             {:name :ward, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics"}
             {:name :air-jet, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vision, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :prerequisite_count 9, :college :air, :ref "Magic p. 169"}
             {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 197"}
             {:name :body-of-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 24"}
             {:name :body-of-lightning, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :body-of-wind, :prerequisites [[:skills/magery 3] [:body-of-air 16] [:windstorm 16] :1-spell-from-each-of-5-different-colleges-besides-air], :prerequisite_count 10, :college :air, :ref "Magic p. 27"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :prerequisite_count 4, :college :air, :ref "Basic Set p. 250; Magic p. 189"}
             {:name :chain-lightning, :prerequisites [[:skills/magery 4] :ball-of-lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :cloud, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :cloud-of-doom, :prerequisites [[:skills/magery 4] [10 :air] :devitalize-air :stench], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :clouds, :prerequisites [[2 :water] [2 :air]], :prerequisite_count 4, :college :air, :ref "Magic p. 194"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :prerequisite_count 5, :college :air, :ref "Magic p. 26"}
             {:name :cool, :prerequisites [:cold [4 :air]], :prerequisite_count 9, :college :air, :ref "Magic p. 195"}
             {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :prerequisite_count 9, :college :air, :ref "Magic p. 28"}
             {:name :create-air, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 23"}
             {:name :create-air-elemental, :prerequisites [[:skills/magery 2] :control-air-elemental], :prerequisite_count 10, :college :air, :ref "Magic p. 22"}
             {:name :destroy-air, :prerequisites [:purify-air], :prerequisite_count 2, :college :air, :ref "Magic p. 43"}
             {:name :devitalize-air, :prerequisites [:destroy-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :electric-armor, :prerequisites [[:skills/magery 1] :lightning :resist-lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-missiles, :prerequisites [:electric-weapon], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 27"}
             {:name :electric-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 0, :college :air, :ref "Classic: Grimoire p 28"}
             {:name :embolism, :prerequisites [[:skills/magery 3] :body-of-air :essential-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :essential-air, :prerequisites [[6 :air]], :prerequisite_count 6, :college :air, :ref "Magic p. 26"}
             {:name :explosive-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :falling-sky, :prerequisites [[:skills/magery 4] [8 :air] :concussion :destroy-air], :prerequisite_count 8, :college :air, :ref "Magic: Artillery Spells p. 9"}
             {:name :improved-concussion, :prerequisites [[:skills/magery 4] [7 :sound] :concussion :great-voice], :prerequisite_count 7, :college :air, :ref "Magic: Artillery Spells p. 25"}
             {:name :improved-explosive-lightning, :prerequisites [[:skills/magery 4] [10 :air] :explosive-lightning], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 29"}
             {:name :jolt, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :lightning, :prerequisites [[:skills/magery 1] [6 :other]], :prerequisite_count 6, :college :air, :ref "Basic Set p. 244; Magic p. 196"}
             {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :prerequisite_count 12, :college :air, :ref "Magic p. 198"}
             {:name :lightning-missiles, :prerequisites [:lightning-weapon], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-stare, :prerequisites [:lightning], :prerequisite_count 8, :college :air, :ref "Magic p. 198"}
             {:name :lightning-weapon, :prerequisites [[:skills/magery 2] :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 198"}
             {:name :lightning-whip, :prerequisites [:lightning], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :mighty-breath, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :mass-resist-lightning, :prerequisites [[:attributes/int 13]  :resist-lightning], :prerequisite_count nil, :college :air, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :no-smell, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :odor, :prerequisites [:no-smell], :prerequisite_count 2, :college :air, :ref "Magic p. 24"}
             {:name :phlogiston-arc, :prerequisites [[:skills/magery 4] :essential-air :lightning-whip], :prerequisite_count 7, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-detonation, :prerequisites [[:skills/magery 4] :essential-air :explosive-lightning], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-discharge, :prerequisites [[:skills/magery 4] :essential-air :lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 15"}
             {:name :phlogiston-sphere, :prerequisites [[:skills/magery 4] :essential-air :ball-of-lightning], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-stare, :prerequisites [[:skills/magery 4] :essential-air :lightning-stare], :prerequisite_count 9, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :phlogiston-touch, :prerequisites [[:skills/magery 4] :essential-air :shocking-touch], :prerequisite_count 8, :college :air, :ref "Pyramid 3/25: Epic Magic p. 16"}
             {:name :predict-weather, :prerequisites [[4 :air]], :prerequisite_count 4, :college :air, :ref "Basic Set p. 243; Magic p. 193"}
             {:name :purify-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
             {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :prerequisite_count 1, :college :air, :ref "Classic: Technomanser p 17"}
             {:name :rain, :prerequisites [:clouds], :prerequisite_count 5, :college :air, :ref "Magic p. 195; Fantasy p. 168"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :prerequisite_count 6, :college :air, :ref "Magic p. 196"}
             {:name :safe-boarding, :prerequisites [[8 :second-level]], :prerequisite_count nil, :college :air, :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :air, :ref "Magic p. 27"}
             {:name :seek-air, :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic p. 23"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :air, :ref "Classic: Technomancer p. 17"}
             {:name :shape-air, :prerequisites [:create-air], :prerequisite_count 2, :college :air, :ref "Basic Set p. 243; Magic p. 24"}
             {:name :shocking-touch, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :snow, :prerequisites [:clouds :frost], :prerequisite_count 2, :college :air, :ref "Magic p. 193"}
             {:name :spark-cloud, :prerequisites [:shape-air :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :spark-storm, :prerequisites [:windstorm :lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 196"}
             {:name :static-charge, :prerequisites [:purify-air-+-1-other-air-spell], :prerequisite_count 2, :college :air, :ref "Classic: Technomancer p 17"}
             {:name :steal-breath, :prerequisites [[:skills/magery 3] :any [7 :air] :devitalize-air], :prerequisite_count 7, :college :air, :ref "Magic: Death Spells p. 9"}
             {:name :stench, :prerequisites [:purify-air], :prerequisite_count 1, :college :air, :ref "Basic Set p. 244; Magic p. 23"}
             {:name :stinkguard, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm, :prerequisites [:rain :hail], :prerequisite_count 10, :college :air, :ref "Magic p. 195"}
             {:name :storm-shelter, :type :area :prerequisites [], :prerequisite_count 0, :college :air, :ref "Magic: The Least of Spells p. 17"}
             {:name :stroke-of-lightning, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count nil, :college :air, :ref "Magic Styles: Dungeon Magic p. 19"}
             {:name :summon-air-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :air] [4 :air]} :another-summon-elemental-spell], :prerequisite_count 8, :college :air, :ref "Magic p. 27"}
             {:name :twisting-terror, :prerequisites [[:skills/magery 4] [10 :air] :windstorm], :prerequisite_count 10, :college :air, :ref "Magic: Artillery Spells p. 10"}
             {:name :walk-on-air, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Basic Set p. 243; Magic p. 25"}
             {:name :wall-of-lightning, :prerequisites [:lightning], :prerequisite_count 7, :college :air, :ref "Magic p. 197"}
             {:name :wall-of-wind, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :warm, :prerequisites [:heat [4 :air]], :prerequisite_count 8, :college :air, :ref "Magic p. 195"}
             {:name :wind, :prerequisites [:windstorm], :prerequisite_count 4, :college :air, :ref "Magic p. 193"}
             {:name :windstorm, :prerequisites [:shape-air], :prerequisite_count 3, :college :air, :ref "Magic p. 25"}
             {:name :abominable-alteration, :prerequisites [[:skills/magery 3] :alter-body :shapeshift-others-for-the-appropriate-animal], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 9)"}
             {:name :animal-control, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :beast-link, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 30"}
             {:name :beast-possession, :prerequisites [#{:rider-within :possession}], :prerequisite_count 4, :college :animal, :ref "Magic p. 32"}
             {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 30"}
             {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :prerequisite_count 0, :college :animal, :ref "Magic p. 29"}
             {:name :beast-seeker, :prerequisites [:beast-summoning [2 :seek] :or-seeker], :prerequisite_count 3, :college :animal, :ref "Magic p. 32"}
             {:name :beast-speech, :prerequisites [:beast-summoning], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :beast-summoning, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :call, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :creeping-plague, :prerequisites [[:skills/magery 5] :beast-summoning #{:vermin-control [:skills/magery 4]} :create-animal], :prerequisite_count 13, :college :animal, :ref "Magic: Artillery Spells p. 10-11"}
             {:name :great-shapeshift, :prerequisites [[:skills/magery 3] :alter-body [4 :shapeshifting] [10 :other]], :prerequisite_count 15, :college :animal, :ref "Magic p. 34"}
             {:name :groom, :type :area :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 6"}
             {:name :hybrid-control, :prerequisites [[2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 30; Classic: Grimoire p 9"}
             {:name :insect-repellent, :prerequisites [], :prerequisite_count 0, :college :animal, :ref "Magic: The Least of Spells p. 15"}
             {:name :master, :prerequisites [:beast-soother], :prerequisite_count 1, :college :animal, :ref "Magic p. 30"}
             {:name :merging-shapeshifting, :prerequisites [[:skills/magery 3] :2-shapeshift-other :2-body-control :2-animal-control], :prerequisite_count 0, :college :animal, :ref "Classic: Technomancer p 12"}
             {:name :partial-shapeshifting, :prerequisites [[:skills/magery 3] :alter-body :appropriate-shapeshifting], :prerequisite_count 12, :college :animal, :ref "Magic p. 34"}
             {:name :permanent-beast-possession, :prerequisites [[:skills/magery 2] :beast-possession], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :permanent-shapeshifting, :prerequisites [[:skills/magery 3] :appropriate-shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :protect-animal, :prerequisites [:armor :watchdo  :animal], :prerequisite_count 7, :college :animal, :ref "Magic p. 32"}
             {:name :repel-animal, :prerequisites [:the-appropriate-animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :repel-hybrids, :prerequisites [:hybrid-control], :prerequisite_count 4, :college :animal, :ref "Magic p. 31"}
             {:name :rider, :prerequisites [:animal-control], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :rider-within, :prerequisites [[2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 31"}
             {:name :shapeshift-others, :prerequisites [[:skills/magery 2] :appropriate-shapeshifting], :prerequisite_count 7, :college :animal, :ref "Magic p. 33"}
             {:name :shapeshifting, :prerequisites [[:skills/magery 1] [6 :other]], :prerequisite_count 6, :college :animal, :ref "Magic p. 32-33"}
             {:name :spider-silk, :prerequisites [[:skills/magery 1] [2 :animal]], :prerequisite_count 2, :college :animal, :ref "Magic p. 32"}
             {:name :thousand-legged-demise, :prerequisites [[:skills/magery 3] :vermin-control :any-one-shapeshift-others-spell], :prerequisite_count 0, :college :animal, :ref "Magic: Death Spells p. 10)"}
             {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :prerequisite_count 0, :college :body-control, :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
             {:name :ache, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :agonize, :prerequisites [[:skills/magery 2] :sensitize], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :alter-body, :prerequisites [:alter-visage], :prerequisite_count 10, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-visage, :prerequisites [[:skills/magery 1] #{:shapeshifting :perfect-illusion} [8 :body-control]], :prerequisite_count 9, :college :body-control, :ref "Magic, p. 41"}
             {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 41"}
             {:name :ambidexterity, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :analgesic, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :balance, :prerequisites [:grace], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :belch, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :birth-control, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 10"}
             {:name :blend-in, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :boost-dexterity, :prerequisites [:grace], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-health, :prerequisites [:vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :boost-strength, :prerequisites [:might], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :cadence, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :choke, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :climbing, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :clumsiness, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :control-limb, :prerequisites [[:skills/magery 1] [5 :body-control] :spasm], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40; Classic Grimoire p 14"}
             {:name :corpulence, :prerequisites [[:skills/magery 2] :create-earth :create-water :alter-body [3 :other]], :prerequisite_count 16, :college :body-control, :ref "Magic, p. 43"}
             {:name :curse-missile, :prerequisites [[:skills/magery 2] :spell-used-in-missile], :prerequisite_count 0, :college :body-control, :ref "Classic: Magic p 24"}
             {:name :death, :prerequisites [[:skills/magery 3] :choke :deathtouch :choke :entombment :rotting-death :curse-evisceration :steal-beauty :deathtouch :frostbite :steal-skill :dehydrate :pestilence :stop-healing], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
             {:name :death-field, :prerequisites [[:skills/magery 4] [10 :body-control] :deathtouch], :prerequisite_count 10, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :deathtouch, :prerequisites [:wither-limb], :prerequisite_count 7, :college :body-control, :ref "Basic Set, p. 245; Magic, p. 41"}
             {:name :debility, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 36"}
             {:name :decapitation, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :despoil-seed, :prerequisites [[:skills/magery 1] :alter-body :strike-barren], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :diver's-blessing, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 6"}
             {:name :doomtouch, :prerequisites [[:skills/magery 3] :deathtouch :weaken-blood], :prerequisite_count 0, :college :body-control, :ref "Magic: Death Spells, p. 11"}
             {:name :ease-labor, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :body-control, :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
             {:name :eat-crow, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 9"}
             {:name :elvish-grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :enlarge, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :enlarge-other, :prerequisites [[:skills/magery 3] :enlarge], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :ether-static, :prerequisites [#{:purify-signal :static-charge}], :prerequisite_count 2, :college :body-control, :ref "Classic: Technomancer p. 17"}
             {:name :flexibility, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :frailty, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :fumble, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :gauntness, :prerequisites [[:skills/magery 2] :earth-to-air :destroy-water :hunger [3 :other]], :prerequisite_count 15, :college :body-control, :ref "Magic, p. 43"}
             {:name :grace, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :hair-growth, :prerequisites [[5 :body-control]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :haircut, :prerequisites [:hair-growth], :prerequisite_count 8, :college :body-control, :ref "Magic, p. 39"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :hold-breath, :prerequisites [[:skills/magery 1] :vigor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 39"}
             {:name :hunger, :prerequisites [[:skills/magery 1] :debility :decay], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :imp-face, :prerequisites [[:skills/magery 1] :planar-summons :alter-visage], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :itch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :lengthen-limb, :prerequisites [[:skills/magery 3] :shapeshifting], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
             {:name :ley-running, :prerequisites [:seek-ley-line :haste], :prerequisite_count 1, :college :body-control, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :mark-of-thieves, :prerequisites [[:skills/magery 1] :pestilence], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :might, :prerequisites [:lend-energy], :prerequisite_count 1, :college :body-control, :ref "Magic, p. 37"}
             {:name :mouth-goes-away, :prerequisites [[:skills/magery 1] :alter-visage [4 :body-control]], :prerequisite_count 0, :college :body-control, :ref "Alphabet Arcane, p. 17"}
             {:name :nauseate, :prerequisites [:perfume [1 :other]], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :pain, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :paralyze-limb, :prerequisites [[:skills/magery 1] :pain [4 :other]], :prerequisite_count 5, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :partial-mechamorphosis, :prerequisites [[:skills/magery 2] :alter-body :machine-control [:world/tl 7]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomancer p 17"}
             {:name :perfume, :prerequisites [:odor], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 35"}
             {:name :plague-touch, :prerequisites [[:skills/magery 4] :deathtouch :pestilence :sense-foes], :prerequisite_count 9, :college :body-control, :ref "Magic: Artillery Spells p. 11"}
             {:name :reflexes, :prerequisites [:grace :haste], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 39"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32"}
             {:name :resist-pain, :prerequisites [[:skills/magery 2] :pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 38"}
             {:name :retch, :prerequisites [:nauseate :spasm], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 38"}
             {:name :rooted-feet, :prerequisites [:hinder], :prerequisite_count 2, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 36"}
             {:name :roundabout, :prerequisites [:tanglefoot], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 36"}
             {:name :seek-emitter, :prerequisites [[:world/tl 6]], :prerequisite_count 0, :college :body-control, :ref "Classic: Technomanser p 17"}
             {:name :sensitize, :prerequisites [[:skills/magery 1] :stun], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 39"}
             {:name :shrink, :prerequisites [[:skills/magery 2] :alter-body], :prerequisite_count 11, :college :body-control, :ref "Magic, p. 42"}
             {:name :shrink-other, :prerequisites [[:skills/magery 3] :shrink], :prerequisite_count 12, :college :body-control, :ref "Magic, p. 42"}
             {:name :sickness, :prerequisites [#{:drunkenness [:skills/magery 1]} :pestilence], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 138"}
             {:name :spasm, :prerequisites [:itch], :prerequisite_count 1, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 35"}
             {:name :stand-out, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-anosmic, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Classic: Grimoire p 14"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 35"}
             {:name :stifle, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :strike-barren, :prerequisites [[:skills/magery 1] :steal-vitality :decay], :prerequisite_count 7, :college :body-control, :ref "Magic, p. 41"}
             {:name :strike-blind, :prerequisites [:spasm :2-ligh  :darkness], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-dumb, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 38"}
             {:name :strike-numb, :prerequisites [:resist-pain], :prerequisite_count 4, :college :body-control, :ref "Magic, p. 40"}
             {:name :stun, :prerequisites [:pain], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 37"}
             {:name :tanglefoot, :prerequisites [:clumsiness], :prerequisite_count 3, :college :body-control, :ref "Magic, p. 36"}
             {:name :thirst, :prerequisites [[:skills/magery 1] :debility :destroy-water], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 38"}
             {:name :throw-voice, :type :area :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic: The Least of Spells p. 16"}
             {:name :tickle, :prerequisites [:spasm], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 36"}
             {:name :total-paralysis, :prerequisites [:paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Magic, p. 40"}
             {:name :touch, :prerequisites [], :prerequisite_count 0, :college :body-control, :ref "Magic, p. 35"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :body-control, :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
             {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :prerequisite_count 13, :college :body-control, :ref "Magic, p. 43"}
             {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :prerequisite_count 14, :college :body-control, :ref "Magic, p. 43"}
             {:name :transmogrification, :prerequisites [[:skills/magery 3] :transform-other :transform-object], :prerequisite_count 32, :college :body-control, :ref "Magic, p. 43"}
             {:name :vigor, :prerequisites [#{:lend-vitality :frailty}], :prerequisite_count 2, :college :body-control, :ref "Magic, p. 37"}
             {:name :warp-fetus, :prerequisites [#{:strike-barren :wither-limb}], :prerequisite_count 7, :college :body-control, :ref "Bio-Tech, p. 33"}
             {:name :weaken-blood, :prerequisites [[:skills/magery 1] #{:sickness :steal-vitality}], :prerequisite_count 5, :college :body-control, :ref "Magic, p. 40"}
             {:name :wither-limb, :prerequisites [[:skills/magery 2] :paralyze-limb], :prerequisite_count 6, :college :body-control, :ref "Basic Set, p. 244; Magic, p. 40"}
             {:name :absorb-book, :prerequisites [#{[:attributes/int 13] :gift-of-letters}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :accursed-triangle, :prerequisites [[:skills/magery 3] :exchange-bodies], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 11"}
             {:name :ack, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :bedtime-reading, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 0, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 20"}
             {:name :borrow-language, :prerequisites [:lend-language], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :borrow-number, :prerequisites [:seek-number], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :borrow-skill, :prerequisites [:lend-skill], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :broadcast-spell, :prerequisites [[:skills/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomander p. 19"}
             {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :prerequisite_count 9, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :compel-lie, :prerequisites [:emotion-control], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 137"}
             {:name :compel-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :compel-written-truth, :prerequisites [[:skills/magery 2] :truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :control-person, :prerequisites [#{:soul-rider :telepathy}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :delete-commercia, :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 18"}
             {:name :dispel-possession, :prerequisites [#{:soul-rider :possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic p. 49"}
             {:name :drama, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :prerequisite_count 17, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :gift-of-letters, :prerequisites [:borrow-language #{:3-languages-written-at-accented :better}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :gift-of-tongues, :prerequisites [:borrow-language #{:3-languages-spoken-at-accented :better}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :hide-emotion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :hide-thoughts, :prerequisites [:truthsayer], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46"}
             {:name :identify-caller, :prerequisites [:mind-reading :seek-number], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :illuminated-writing, :prerequisites [[:skills/magery 2] :one-of-mind-sending :fascinate [:or-writing 12]], :prerequisite_count 1, :college :communication-and-empathy, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :insignificance, :prerequisites [:persuasion :avoid], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :lend-skill, :prerequisites [:mind-sending [:iq 11]], :prerequisite_count 11, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :prerequisite_count 13, :college :communication-and-empathy, :ref "Magic, p. 176"}
             {:name :magic-switchboard, :prerequisites [:identify-caller], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :prerequisite_count 7, :college :communication-and-empathy, :ref "Magic, p. 173"}
             {:name :mer-speech, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 17"}
             {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :prerequisite_count 3, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
             {:name :mind-search, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 46"}
             {:name :mind-sending, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
             {:name :mind-whip, :prerequisites [[:skills/magery 2] :telepathy], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :permanent-possession, :prerequisites [[:skills/magery 3] :possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :persuasion, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :possession, :prerequisites [[:skills/magery 1] #{:control-person :beast-possession}], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :presence, :prerequisites [:persuasion :lure], :prerequisite_count 8, :college :communication-and-empathy, :ref "Magic, p. 48"}
             {:name :retrogression, :prerequisites [:mind-search :mind-sending], :prerequisite_count 6, :college :communication-and-empathy, :ref "Magic, p. 47"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] [:world/tl 6]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :sense-emotion, :prerequisites [:sense-foes], :prerequisite_count 1, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
             {:name :sense-foes, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 44"}
             {:name :sense-life, :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :sorcerous-signal, :type :area :prerequisites [], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: The Least of Spells p. 8"}
             {:name :soul-rider, :prerequisites [:mind-reading], :prerequisite_count 4, :college :communication-and-empathy, :ref "Magic, p. 49"}
             {:name :speed-data, :prerequisites [[:world/tl 7] :haste :lightning], :prerequisite_count 0, :college :communication-and-empathy, :ref "Classic: Technomancer p 19"}
             {:name :switch-bodies, :prerequisites [:permanent-possession], :prerequisite_count 5, :college :communication-and-empathy, :ref "4e spell chart"}
             {:name :telepathic-overload, :prerequisites [[:skills/magery 3] :any-10-communicatio [:empathy :telepathy]], :prerequisite_count 0, :college :communication-and-empathy, :ref "Magic: Death Spells, p. 9"}
             {:name :telepathy, :prerequisites [:mind-sending], :prerequisite_count 5, :college :communication-and-empathy, :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
             {:name :truthsayer, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Basic Set, p. 245; Magic, p. 45"}
             {:name :vexation, :prerequisites [:sense-emotion], :prerequisite_count 2, :college :communication-and-empathy, :ref "Magic, p. 45"}
             {:name :wrong-number, :prerequisites [[:world/tl 6] :sense-foes :seek-number], :prerequisite_count 1, :college :communication-and-empathy, :ref "Classic: Technomancer p. 18"}
             {:name :adamant-hail, :prerequisites [[:skills/magery 4] :essential-earth :rain-of-stones], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :adamant-missile, :prerequisites [[:skills/magery 4] :essential-earth :stone-missile], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :alter-terrain, :prerequisites [[:skills/magery 3] :shape-water :shape-fire :shape-air :shape-stone], :prerequisite_count 11, :college :earth, :ref "Magic, p. 55"}
             {:name :badger-paws, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :body-of-stone, :prerequisites [:stone-to-flesh], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :boulder-barrage, :prerequisites [[:skills/magery 4] [10 :earth] :rain-of-stones :stone-missile], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :prerequisite_count 9, :college :earth, :ref "Magic, p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-earth, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-earth-elemental, :prerequisites [[:skills/magery 2] :control-earth-elemental], :prerequisite_count 10, :college :earth, :ref "Magic, p. 22"}
             {:name :dust-to-dust, :prerequisites [[:skills/magery 3] :earth-to-air :flesh-to-stone], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :prerequisite_count 4, :college :earth, :ref "Basic Set, p. 243; Magic, p. 25"}
             {:name :earth-to-stone, :prerequisites [[:skills/magery 1] :shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-to-water, :prerequisites [[:skills/magery 1] :create-water :shape-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 52"}
             {:name :earth-vision, :prerequisites [:shape-earth], :prerequisite_count 2, :college :earth, :ref "Magic, p. 51"}
             {:name :earthquake, :prerequisites [[:skills/magery 2] [6 :earth] :earth-vision], :prerequisite_count 6, :college :earth, :ref "Magic, p. 54"}
             {:name :entombment, :prerequisites [[:skills/magery 2] [5 :earth]], :prerequisite_count 6, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :essential-earth, :prerequisites [[6 :earth]], :prerequisite_count 6, :college :earth, :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :flesh-to-adamant, :prerequisites [[:skills/magery 4] :essential-earth :flesh-to-stone], :prerequisite_count 7, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 16"}
             {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :gargoyle-skin, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :heart-of-stone, :prerequisites [[:skills/magery 3] :partial-petrification], :prerequisite_count 0, :college :earth, :ref "Magic: Death Spells, p. 11"}
             {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :prerequisite_count 29, :college :earth, :ref "Magic, p. 55"}
             {:name :mud-jet, :prerequisites [:water-jet :create-earth :or-create-water :s :jet], :prerequisite_count 8, :college :earth, :ref "Magic, p. 52"}
             {:name :orichalcum-edge, :prerequisites [[:skills/magery 4] :essential-earth :earth-to-stone], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :orichalcum-missiles, :prerequisites [:orichalcum-edge], :prerequisite_count 0, :college :earth, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :partial-petrification, :prerequisites [[:skills/magery 2] :flesh-to-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :pebble, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :predict-earth-movement, :prerequisites [[4 :earth]], :prerequisite_count 4, :college :earth, :ref "Magic, p. 51"}
             {:name :purify-earth, :prerequisites [:apportation :shape-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
             {:name :rain-of-stones, :prerequisites [[:skills/magery 2] :create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 53"}
             {:name :sand-blast, :prerequisites [[:skills/magery 4] :s :jet :s :storm], :prerequisite_count 0, :college :earth, :ref "Magic: Artillery Spells p. 12"}
             {:name :sand-jet, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :sandstorm, :prerequisites [:windstorm :create-earth], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :seek-earth, :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :seek-pass, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Magic, p. 51"}
             {:name :seismic-shock, :prerequisites [[:skills/magery 4] [10 :earth] :earthquake], :prerequisite_count 10, :college :earth, :ref "Magic: Artillery Spells p. 13"}
             {:name :shape-earth, :prerequisites [:seek-earth], :prerequisite_count 1, :college :earth, :ref "Basic Set, p. 245; Magic, p. 50"}
             {:name :shape-stone, :prerequisites [:shape-earth [3 :other]], :prerequisite_count 5, :college :earth, :ref "Fantasy, p. 169"}
             {:name :spotless-hands, :type :area :prerequisites [], :prerequisite_count 0, :college :earth, :ref "Magic: The Least of Spells p. 8"}
             {:name :steelwraith, :prerequisites [[:skills/magery 2] :walk-through-earth], :prerequisite_count 5, :college :earth, :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :stone-missile, :prerequisites [:create-earth], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52"}
             {:name :stone-to-earth, :prerequisites [#{:earth-to-stone [4 :earth]}], :prerequisite_count 3, :college :earth, :ref "Basic Set, p. 246; Magic, p. 51"}
             {:name :stone-to-flesh, :prerequisites [[:skills/magery 2] :flesh-to-stone :stone-to-earth], :prerequisite_count 5, :college :earth, :ref "Basic Set, p. 246; Magic, p. 53"}
             {:name :summon-earth-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :earth] [4 :earth]} :another-summon-elemental-spell], :prerequisite_count 8, :college :earth, :ref "Magic, p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :earth, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :volcano, :prerequisites [:earthquake [6 :fire]], :prerequisite_count 13, :college :earth, :ref "Magic, p. 54"}
             {:name :walk-through-earth, :prerequisites [:shape-stone], :prerequisite_count 4, :college :earth, :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
             {:name :amulet, :prerequisites [:talisman-for-the-appropriate-spell], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :compulsive-reader, :prerequisites [:enchant [#{[3 :mind-control] [:skills/writing 15]}]], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :costume, :prerequisites [:adjustable-clothing], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Item 3 p 30"}
             {:name :create-chimera, :prerequisites [:analyze-heredity :enchant #{:alter-body :lightning}], :prerequisite_count 0, :college :enchantment, :ref "Bio-Tech, p. 31"}
             {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :prerequisite_count 0, :college :enchantment, :ref "Classic: Tenchnomancer p. 20"}
             {:name :doom-wish, :prerequisites [[:skills/magery 3] :wish :iq-+-magery-of-23+], :prerequisite_count 18, :college :enchantment, :ref "Magic: Artillery Spells p. 13-14"}
             {:name :doppelganger, :prerequisites [[:skills/magery 3] :golem :history :enslave], :prerequisite_count 29, :college :enchantment, :ref "Magic p. 62; Classic: Magic p 40"}
             {:name :dwarfish-reinforcement, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :electric-power, :prerequisites [:lend-power :power :steal-power], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 20"}
             {:name :emergency-staff, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8"}
             {:name :enchant, :prerequisites [[:skills/magery 2] :one-spell-from-10-other-colleges], :prerequisite_count 10, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 56"}
             {:name :ensorcel, :prerequisites [:malefice], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :golem, :prerequisites [:enchant :shape-earth :animation], :prerequisite_count 14, :college :enchantment, :ref "Magic p. 59"}
             {:name :great-wish, :prerequisites [[:skills/magery 3] :wish [:attributes/int 20]], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :hex, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :prerequisite_count 15, :college :enchantment, :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
             {:name :impart-skill, :prerequisites [[:skills/magery 3] :enchant :lend-skill :wisdom  :five-communicatio  :empathy], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 60"}
             {:name :leak, :prerequisites [:hideaway], :prerequisite_count 16, :college :enchantment, :ref "Magic p. 61"}
             {:name :lesser-wish, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 61"}
             {:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :prerequisite_count 0, :college :enchantment, :ref "Thaumatology: Urban Magics, p. 21"}
             {:name :live-libram, :prerequisites [:enchant :apportation], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :malefice, :prerequisites [:enchant :seeker], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 60"}
             {:name :magician's-minion, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 8-9"}
             {:name :mana-warhead, :prerequisites [:curse-missile :spell-in-warhead], :prerequisite_count 0, :college :enchantment, :ref "Classic: Technomancer p. 21"}
             {:name :mortal-malefice, :prerequisites [[:skills/magery 3] :malefice :soul-jar], :prerequisite_count 0, :college :enchantment, :ref "Magic: Death Spells, p. 9"}
             {:name :narrative-conveyance, :prerequisites [:plane-shift :timeport [:writing 15]], :prerequisite_count 0, :college :enchantment, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :power, :prerequisites [:enchant :recover-energy], :prerequisite_count 12, :college :enchantment, :ref "Basic Set, p. 480; Magic p. 57"}
             {:name :remove-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :resilient-golem, :prerequisites [:golem :shatterproof], :prerequisite_count 0, :college :enchantment, :ref "Classic: Magic Items 3 p 32"}
             {:name :resist-enchantment, :prerequisites [:any-limiting-enchantment-spell], :prerequisite_count 12, :college :enchantment, :ref "Magic p. 58"}
             {:name :scroll, :prerequisites [[:skills/magery 1] #{:1-written-language-at-accented :better}], :prerequisite_count 0, :college :enchantment, :ref "Magic p. 57"}
             {:name :simulacrum, :prerequisites [[:skills/magery 3] :golem :perfect-illusion :illusion-disguise], :prerequisite_count 18, :college :enchantment, :ref "Magic p. 61"}
             {:name :sorcerer's-stand-in, :type :area :prerequisites [], :prerequisite_count 0, :college :enchantment, :ref "Magic: The Least of Spells p. 9"}
             {:name :soul-golem, :prerequisites [[:skills/magery 3] :soul-jet :golem [:attributes/int 13]], :prerequisite_count 0, :college :enchantment, :ref "Classic: Grimoire p 42"}
             {:name :speed, :prerequisites [:enchant :haste], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 57"}
             {:name :spell-stone, :prerequisites [:enchant :delay], :prerequisite_count 8, :college :enchantment, :ref "Magic p. 60"}
             {:name :spellbook-enchantment, :prerequisites [:scroll], :prerequisite_count 1, :college :enchantment, :ref "Classic: Magic Items 2 p. 40"}
             {:name :spellgraft, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Bio-Tech, p. 32"}
             {:name :spellprocessor, :prerequisites [:scroll [:computer-programming 15]], :prerequisite_count 1, :college :enchantment, :ref "Classic: Technomancer p 19"}
             {:name :suspend-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 58"}
             {:name :talisman, :prerequisites [:enchant :spell-to-be-opposed], :prerequisite_count nil, :college :enchantment, :ref "Magic p. 58"}
             {:name :temporary-enchantment, :prerequisites [:enchant], :prerequisite_count 11, :college :enchantment, :ref "Magic p. 56; Fantasy, p. 23"}
             {:name :vengeful-staff, :prerequisites [[:skills/magery 3] :enchant :explode], :prerequisite_count 12, :college :enchantment, :ref "Magic: Artillery Spells p. 14"}
             {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :prerequisite_count 17, :college :enchantment, :ref "Magic p. 61"}
             {:name :balor's-eye-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :blast-ball, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count 0, :college :fire, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :body-of-flames, :prerequisites [:breathe-fire], :prerequisite_count 8, :college :fire, :ref "Magic p. 76"}
             {:name :breathe-fire, :prerequisites [[:skills/magery 1] :flame-jet :resist-fire], :prerequisite_count 7, :college :fire, :ref "Magic p. 76"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :prerequisite_count 10, :college :fire, :ref "Magic p. 76"}
             {:name :burning-touch, :prerequisites [[:skills/magery 2] [6 :fire] :heat], :prerequisite_count 6, :college :fire, :ref "Magic p. 76"}
             {:name :cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
             {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :prerequisite_count 9, :college :fire, :ref "Magic p. 28"}
             {:name :control-lava-lizard, :prerequisites [:summon-lava-lizard], :prerequisite_count 9, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :create-fire, :prerequisites [#{:ignite-fire :seek-fire}], :prerequisite_count 1, :college :fire, :ref "Magic p. 72"}
             {:name :create-fire-elemental, :prerequisites [[:skills/magery 2] :control-fire-elemental], :prerequisite_count 10, :college :fire, :ref "Magic p. 22"}
             {:name :cremate, :prerequisites [[:skills/magery 3] :burning-touch :essential-flame :fast-fire], :prerequisite_count 0, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :deflect-energy, :prerequisites [[:skills/magery 1] :shape-fire], :prerequisite_count 2, :college :fire, :ref "Basic Set, p. 246; Magic p. 73"}
             {:name :detonate, :prerequisites [:ignite-fire :shape-plastic], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ember, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :essential-flame, :prerequisites [[6 :fire]], :prerequisite_count 6, :college :fire, :ref "Magic p. 75"}
             {:name :explosive-fireball, :prerequisites [:fireball], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 75"}
             {:name :explosive-hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :explosive-fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :extinguish-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 247; Magic p. 72"}
             {:name :fast-fire, :prerequisites [:slow-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :fire-cloud, :prerequisites [:shape-air :fireball], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :fire-swarm, :prerequisites [[:skills/magery 4] [10 :fire] :fireball :flame-jet], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :fireball, :prerequisites [[:skills/magery 1] :create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :fireproof, :prerequisites [:extinguish-fire], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :flameturning, :prerequisites [:resist-fire :or-both-apportation :shape-fire], :prerequisite_count 0, :college :fire, :ref "Classic: Grimoire p. 30"}
             {:name :flaming-armor, :prerequisites [[:skills/magery 1] :resist-fire :flame-jet], :prerequisite_count 7, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-missiles, :prerequisites [:flaming-weapon], :prerequisite_count 5, :college :fire, :ref "Magic p. 75"}
             {:name :flaming-weapon, :prerequisites [[:skills/magery 2] :heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 75"}
             {:name :great-deflect-energy, :prerequisites [[:skills/magery 2]  :deflect-energy], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
             {:name :heat, :prerequisites [:create-fire :shape-fire], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :hellfire-breath, :prerequisites [[:skills/magery 4] :essential-flame :breathe-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-jet, :prerequisites [[:skills/magery 4] :essential-flame :flame-jet], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :hellfire-orb, :prerequisites [[:skills/magery 4] :essential-flame :fireball], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 17"}
             {:name :hellfire-rain, :prerequisites [[:skills/magery 4] :essential-flame :rain-of-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :high-explosive-fireball, :prerequisites [:explosive-fireball [:world/tl 7]], :prerequisite_count 5, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :ignite-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :improved-explosive-fireball, :prerequisites [[:skills/magery 4] [10 :fire] :explosive-fireball], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :mass-detonate, :prerequisites [:detonate], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p. 21"}
             {:name :mass-resist-fire, :prerequisites [[:attributes/int 13]  :resist-fire], :prerequisite_count 0, :college :fire, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :oven-mitts, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :prerequisite_count 1, :college :fire, :ref "Magic p. 73"}
             {:name :puff, :type :area :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic: The Least of Spells p. 9"}
             {:name :rain-of-fire, :prerequisites [[:skills/magery 2] :create-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :resist-cold, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :prerequisite_count 3, :college :fire, :ref "Basic Set, p. 247; Magic p. 74"}
             {:name :shaped-charge-fireball, :prerequisites [[:skills/magery 1] :fireball :shape-metal], :prerequisite_count 0, :college :fire, :ref "Classic: Technomancer p 21"}
             {:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :prerequisite_count 10, :college :fire, :ref "Magic: Artillery Spells p. 23"}
             {:name :seek-fire, :prerequisites [], :prerequisite_count 0, :college :fire, :ref "Magic p. 72"}
             {:name :shape-fire, :prerequisites [:ignite-fire], :prerequisite_count 1, :college :fire, :ref "Basic Set, p. 246; Magic p. 72"}
             {:name :slow-fire, :prerequisites [:extinguish-fire], :prerequisite_count 2, :college :fire, :ref "Magic p. 73"}
             {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :prerequisite_count 3, :college :fire, :ref "Magic p. 73"}
             {:name :snuff-life's-flame, :prerequisites [[:skills/magery 3] :body-of-flames], :prerequisite_count 9, :college :fire, :ref "Magic: Death Spells, p. 12"}
             {:name :summon-fire-elemental, :prerequisites [[:skills/magery 1] #{:either [8 :fire] [4 :fire]} :another-summon-elemental-spell], :prerequisite_count 8, :college :fire, :ref "Magic p. 27"}
             {:name :summon-lava-lizard, :prerequisites [[:skills/magery 1] [4 :earth] [4 :fire]], :prerequisite_count 8, :college :fire, :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
             {:name :towering-inferno, :prerequisites [[:skills/magery 4] [7 :fire] :fire-cloud :rain-of-fire], :prerequisite_count 7, :college :fire, :ref "Magic: Artillery Spells p. 14-15"}
             {:name :warmth, :prerequisites [:heat], :prerequisite_count 4, :college :fire, :ref "Magic p. 74"}
             {:name :accelerate-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-each-from-10-colleges], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :beacon, :prerequisites [:teleport :timeport :or-plane-shift], :prerequisite_count 5, :college :gate, :ref "Magic p. 83; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :blink, :prerequisites [:teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :prerequisite_count 6, :college :gate, :ref "Magic p. 148"}
             {:name :control-gate, :prerequisites [[:skills/magery 3] :seek-gate], :prerequisite_count 12, :college :gate, :ref "Magic p. 85"}
             {:name :create-door, :prerequisites [:teleport :any-1-walk-through-spell], :prerequisite_count 10, :college :gate, :ref "Magic p. 84"}
             {:name :create-gate, :prerequisites [:control-gate :teleport :timeport :or-plane-shift], :prerequisite_count 14, :college :gate, :ref "Magic p. 85/Classic: Grimoire p 50"}
             {:name :dimensional-dissection, :prerequisites [[:skills/magery 3] :one-of-plane-shift-other :teleport-other :or-timeport-other], :prerequisite_count 0, :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :prerequisite_count 6, :college :gate, :ref "Magic p. 84"}
             {:name :easy-rider, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :hell-zone, :prerequisites [[:skills/magery 4] :beacon :planar-summons-for], :prerequisite_count 0, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :hide-object, :prerequisites [:hideaway :teleport], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :invoke, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 14-15"}
             {:name :null-sphere, :prerequisites [[:skills/magery 5] :create-gate], :prerequisite_count 15, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :phase, :prerequisites [[:skills/magery 3] #{:plane-shift :ethereal-body}], :prerequisite_count 5, :college :gate, :ref "Magic p. 83"}
             {:name :phase-other, :prerequisites [:phase], :prerequisite_count 6, :college :gate, :ref "Magic p. 83"}
             {:name :planar-summons, :prerequisites [[:skills/magery 1] :1-spell-from-10-other-colleges], :prerequisite_count 10, :college :gate, :ref "Basic Set p. 247; Magic p. 82"}
             {:name :planar-visit, :prerequisites [[:skills/magery 2] #{:projection :planar-summons}], :prerequisite_count 11, :college :gate, :ref "Magic p. 82"}
             {:name :plane-shift, :prerequisites [:planar-summons], :prerequisite_count 11, :college :gate, :ref "Basic Set p. 247; Magic p. 83"}
             {:name :plane-shift-other, :prerequisites [[:skills/magery 3] :plane-shift], :prerequisite_count 12, :college :gate, :ref "Magic p. 83"}
             {:name :rapid-journey, :prerequisites [[:skills/magery 3] #{:teleport :timeport}], :prerequisite_count 5, :college :gate, :ref "Magic p. 82"}
             {:name :reorient, :type :area :prerequisites [], :prerequisite_count 0, :college :gate, :ref "Magic: The Least of Spells p. 10"}
             {:name :sanctuary, :prerequisites [:hide-object], :prerequisite_count 21, :college :gate, :ref "Magic p. 86"}
             {:name :scry-gate, :prerequisites [:seek-gate], :prerequisite_count 11, :college :gate, :ref "Magic p. 85"}
             {:name :seek-gate, :prerequisites [[:skills/magery 2] :seek-magic :1-spell-from-each-of-10-colleges], :prerequisite_count 10, :college :gate, :ref "Magic p. 85"}
             {:name :slow-time, :prerequisites [[:skills/magery 2] [:attributes/int 13]  :2-from-each-of-10-colleges], :prerequisite_count 20, :college :gate, :ref "Magic p. 86"}
             {:name :splat, :prerequisites [[:skills/magery 4] :create-door], :prerequisite_count 0, :college :gate, :ref "Magic: Artillery Spells p. 16"}
             {:name :suspend-time, :prerequisites [[:skills/magery 3] :slow-time], :prerequisite_count 21, :college :gate, :ref "Magic p. 86"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :prerequisite_count 4, :college :gate, :ref "Magic p. 147; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:skills/magery 3] :teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 147"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :prerequisite_count 7, :college :gate, :ref "Magic p. 170"}
             {:name :time-out, :prerequisites [[:skills/magery 3] :accelerate-time], :prerequisite_count 21, :college :gate, :ref "Magic p. 87"}
             {:name :timeport, :prerequisites [[:skills/magery 3] :teleport], :prerequisite_count 5, :college :gate, :ref "Magic p. 81"}
             {:name :timeport-other, :prerequisites [:timeport], :prerequisite_count 6, :college :gate, :ref "Magic p. 81"}
             {:name :timeslip, :prerequisites [:timeport], :prerequisite_count 6, :college :gate, :ref "Magic p. 81"}
             {:name :timeslip-other, :prerequisites [:timeslip], :prerequisite_count 7, :college :gate, :ref "Magic p. 81"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :prerequisite_count 5, :college :gate, :ref "Magic p. 84"}
             {:name :underworld-imprisonment, :prerequisites [[:skills/magery 3] :one-plane-shift-other-spell], :prerequisite_count 13, :college :gate, :ref "Magic: Death Spells, p. 13"}
             {:name :aid, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :aide, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :analgesic, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :archmagi's-recuperation, :prerequisites [:prerequisites:-iq-14+ [:skills/magery 4] :lend-energy], :prerequisite_count 0, :college :healing, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
             {:name :awaken, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Basic Set, p. 248; Magic p. 90"}
             {:name :bender-defender, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :birth-control, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :body-reading, :prerequisites [#{:sense-life :awaken}], :prerequisite_count 1, :college :healing, :ref "Magic p. 91"}
             {:name :cleansing, :prerequisites [:minor-healing :purify-earth], :prerequisite_count 12, :college :healing, :ref "Magic p. 94"}
             {:name :cure-addiction, :prerequisites [:relieve-addiction], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-dehydration, :prerequisites [[:skills/magery 1] :minor-healing :create-water], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :cure-disease, :prerequisites [:major-healing :relieve-sickness], :prerequisite_count 5, :college :healing, :ref "Magic p. 91; Fantasy, p. 170"}
             {:name :cure-insanity, :prerequisites [:major-healing :relieve-madness [5 :mind]], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 55"}
             {:name :cure-radiation, :prerequisites [:resist-radiation :major-healing], :prerequisite_count 12, :college :healing, :ref "Magic p. 182"}
             {:name :cure-starvation, :prerequisites [[:skills/magery 1] :minor-healing :create-food], :prerequisite_count 0, :college :healing, :ref "Classic: Grimoire p. 52"}
             {:name :detect-poison, :prerequisites [#{:sense-danger :test-food}], :prerequisite_count 1, :college :healing, :ref "Magic p. 166"}
             {:name :disinfect, :prerequisites [[:skills/magery 4] [10 :healing] :cure-disease :remove-contagion], :prerequisite_count 10, :college :healing, :ref "Magic: Artillery Spells p. 17"}
             {:name :ease-labor, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
             {:name :euthanize, :prerequisites [[1 :empathy] [:skills/magery 1] :spirit-empathy], :prerequisite_count 0, :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :final-rest, :prerequisites [#{[:skills/magery 1] :spirit-empathy}], :prerequisite_count 0, :college :healing, :ref "Magic p. 89"}
             {:name :great-healing, :prerequisites [[:skills/magery 3] :major-healing], :prerequisite_count 4, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :halt-aging, :prerequisites [[:skills/magery 2] [8 :healing]], :prerequisite_count 8, :college :healing, :ref "Magic p. 94"}
             {:name :healing-slumber, :prerequisites [[:skills/magery 2] :sleep :minor-healing], :prerequisite_count 6, :college :healing, :ref "Magic p. 94"}
             {:name :instant-neutralize-poison, :prerequisites [[:skills/magery 2] :neutralize-poison], :prerequisite_count 2, :college :healing, :ref "Magic p. 92"}
             {:name :instant-regeneration, :prerequisites [[:skills/magery 3] :regeneration], :prerequisite_count 6, :college :healing, :ref "Magic p. 93"}
             {:name :instant-restoration, :prerequisites [[:skills/magery 2] :restoration], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :lend-energy, :prerequisites [#{[:skills/magery 1] :empathy}], :prerequisite_count 0, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :lend-vitality, :prerequisites [:lend-energy], :prerequisite_count 1, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :major-healing, :prerequisites [[:skills/magery 1] :minor-healing], :prerequisite_count 3, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :mass-resist-disease, :prerequisites [[:attributes/int 13]  :resist-disease], :prerequisite_count 4, :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :mass-resist-poison, :prerequisites [[:attributes/int 13]  :resist-poison], :prerequisite_count 4, :college :healing, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
             {:name :minor-healing, :prerequisites [:lend-vitality], :prerequisite_count 0, :college :healing, :ref "Basic Set, p. 248; Magic p. 91"}
             {:name :neutralize-poison, :prerequisites [#{:cure-disease [:skills/magery 3]} :test-food], :prerequisite_count 1, :college :healing, :ref "Magic p. 92"}
             {:name :recover-energy, :prerequisites [[:skills/magery 1] :lend-energy], :prerequisite_count 1, :college :healing, :ref "Basic Set, p. 248; Magic p. 89"}
             {:name :regeneration, :prerequisites [[:skills/magery 2] :restoration], :prerequisite_count 5, :college :healing, :ref "Magic p. 93"}
             {:name :relieve-addiction, :prerequisites [:neutralize-poison], :prerequisite_count 2, :college :healing, :ref "Magic p. 92|-"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :prerequisite_count 9, :college :healing, :ref "Magic p. 92"}
             {:name :relieve-paralysis, :prerequisites [:stop-paralysis], :prerequisite_count 2, :college :healing, :ref "Magic p. 93"}
             {:name :relieve-sickness, :prerequisites [:lend-vitality], :prerequisite_count 9, :college :healing, :ref "Magic p. 90"}
             {:name :remove-contagion, :prerequisites [:decay :clean :or-cure-disease], :prerequisite_count 2, :college :healing, :ref "Magic p. 90"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :healing, :ref "Bio-Tech, p. 32; Technomancer p. 22"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :prerequisite_count 3, :college :healing, :ref "Magic p. 90"}
             {:name :resist-poison, :prerequisites [:vigor], :prerequisite_count 3, :college :healing, :ref "Magic p. 91"}
             {:name :restoration, :prerequisites [:major-healing :relieve-paralysis :restore], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :restore-hearing, :prerequisites [:minor-healing #{:keen-hearing :strike-deaf}], :prerequisite_count 4, :college :healing, :ref "Magic p. 92"}
             {:name :restore-memory, :prerequisites [:awaken [:iq 11]], :prerequisite_count 3, :college :healing, :ref "Magic p. 92"}
             {:name :restore-sight, :prerequisites [:minor-healing #{:keen-vision :strike-blind}], :prerequisite_count 4, :college :healing, :ref "Magic p. 92"}
             {:name :restore-speech, :prerequisites [:minor-healing #{:great-voice :strike-dumb}], :prerequisite_count 6, :college :healing, :ref "Magic p. 93"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :prerequisite_count 9, :college :healing, :ref "Magic p. 94"}
             {:name :resuscitate, :prerequisites [[:skills/magery 2] :awaken :stop-spasm], :prerequisite_count 0, :college :healing, :ref "Magic: Death Spells, p. 14"}
             {:name :sea-legs, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 17"}
             {:name :sense-disease, :prerequisites [#{:sense-life [2 :healing]}], :prerequisite_count 1, :college :healing, :ref "Bio-Tech, p. 32; Technomaner p 22"}
             {:name :share-energy, :prerequisites [:lend-energy], :prerequisite_count 1, :college :healing, :ref "Magic p. 89"}
             {:name :share-vitality, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Magic p. 90"}
             {:name :stop-bleeding, :prerequisites [:lend-vitality], :prerequisite_count 2, :college :healing, :ref "Magic p. 91; Fantasy, p. 169"}
             {:name :stop-paralysis, :prerequisites [:minor-healing :paralyze-limb :or-strike-dumb], :prerequisite_count 4, :college :healing, :ref "Magic p. 93"}
             {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :prerequisite_count 2, :college :healing, :ref "Magic p. 35"}
             {:name :suspended-animation, :prerequisites [:sleep [4 :healing]], :prerequisite_count 7, :college :healing, :ref "Magic p. 94"}
             {:name :test, :prerequisites [], :prerequisite_count 0, :college :healing, :ref "Magic: The Least of Spells p. 10"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :healing, :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
             {:name :transference-bolt, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :prerequisite_count 0, :college :healing, :ref "Magic Styles: Dungeon Magic, p. 19"}
             {:name :youth, :prerequisites [[:skills/magery 3] :halt-aging], :prerequisite_count 9, :college :healing, :ref "Magic p. 94"}
             {:name :blend-in, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :complex-illusion, :prerequisites [:sound :simple-illusion], :prerequisite_count 2, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :control-creation, :prerequisites [#{:create-animal :create-servant}], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :control-illusion, :prerequisites [:perfect-illusion], :prerequisite_count 2, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :create-animal, :prerequisites [:create-water :create-object [:attributes/int 12]], :prerequisite_count 12, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-foreign-body, :prerequisites [[:skills/magery 3] :body-reading :create-object], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :create-mount, :prerequisites [[:skills/magery 3] :create-animal], :prerequisite_count 13, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :create-object, :prerequisites [[:skills/magery 2] :create-earth :perfect-illusion], :prerequisite_count 8, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-servant, :prerequisites [[:skills/magery 3] [:attributes/int 12] :create-object], :prerequisite_count 9, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :create-trap, :prerequisites [[:skills/magery 4] [10 :illusion-and-create]], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17"}
             {:name :create-warrior, :prerequisites [:create-servant], :prerequisite_count 10, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :disbelieve, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :dispel-creation, :prerequisites [:control-creation], :prerequisite_count 11, :college :illusion-and-creation, :ref "Magic p. 99"}
             {:name :dispel-illusion, :prerequisites [:control-illusion], :prerequisite_count 5, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :duplicate, :prerequisites [:create-object :copy], :prerequisite_count 15, :college :illusion-and-creation, :ref "Magic p. 98"}
             {:name :gargoyle-skin, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 8"}
             {:name :illusion-disguise, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170"}
             {:name :illusion-shell, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
             {:name :image, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :independence, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 96"}
             {:name :initiative, :prerequisites [:independence :wisdom], :prerequisite_count 9, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :prerequisite_count 7, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :know-illusion, :prerequisites [:simple-illusion], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :mirror, :prerequisites [[:skills/magery 4] :initiative :phantom], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Artillery Spells p. 17-18"}
             {:name :perfect-illusion, :prerequisites [[:skills/magery 1] :complex-illusion], :prerequisite_count 3, :college :illusion-and-creation, :ref "Magic p. 96; 'Social Engineering: Back to School, p. 24"}
             {:name :phantom, :prerequisites [[:skills/magery 2] :perfect-illusion :hinder :apportation], :prerequisite_count 7, :college :illusion-and-creation, :ref "Magic p. 97"}
             {:name :phantom-flame, :prerequisites [#{:shape-fire :simple-illusion}], :prerequisite_count 1, :college :illusion-and-creation, :ref "Magic p. 73"}
             {:name :phantom-killer, :prerequisites [[:skills/magery 3] :phantom], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: Death Spells, p. 14"}
             {:name :shadowplay, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 11"}
             {:name :simple-illusion, :prerequisites [:no-blindness [:iq 11]], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic p. 95; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
             {:name :stand-out, :prerequisites [], :prerequisite_count 0, :college :illusion-and-creation, :ref "Magic: The Least of Spells p. 7"}
             {:name :air-vision, :prerequisites [:shape-air], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 24"}
             {:name :alarm, :prerequisites [:tell-time], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 100"}
             {:name :analyze-magic, :prerequisites [:identify-spell], :prerequisite_count 3, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 102"}
             {:name :analyze-heredity, :prerequisites [#{:seeker :sense-life}], :prerequisite_count 1, :college :knowledge, :ref "Bio-Tech, p. 30; Technomancer p 23"}
             {:name :ancient-history, :prerequisites [:history], :prerequisite_count 5, :college :knowledge, :ref "Magic, p. 106"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :aura, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 101"}
             {:name :detect-magic, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 101"}
             {:name :divination, :prerequisites [:skills/history], :prerequisite_count nil, :college :knowledge, :ref "Magic, p. 108; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :earth-vision, :prerequisites [:shape-earth], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 51"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 107"}
             {:name :far-feeling, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :far-hearing, :prerequisites [[:skills/magery 1] [4 :sound]], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 173"}
             {:name :far-tasting, :prerequisites [[:skills/magery 1] #{:seek-food :seek-air}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 77"}
             {:name :find-direction, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 101"}
             {:name :forbidden-wisdom, :prerequisites [[:skills/magery 3] :recall :see-secrets], :prerequisite_count 0, :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :glass-wall, :prerequisites [#{[5 :knowledge] :earth-vision}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 103"}
             {:name :history, :prerequisites [:trace], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 104"}
             {:name :identify-loot, :prerequisites [[:skills/magery 2]  [7 :fourth-level]], :prerequisite_count 0, :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :identify-spell, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 102"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :invisible-wizard-eye, :prerequisites [:wizard-eye :invisibility], :prerequisite_count 10, :college :knowledge, :ref "Magic, p. 104"}
             {:name :keyfinder, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-location, :prerequisites [[:skills/magery 1] :tell-position], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 103"}
             {:name :know-recipe, :prerequisites [:far-tasting :season], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 78"}
             {:name :know-thyself, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-true-shape, :prerequisites [[:skills/magery 1] [1 :shifting] #{:aura :know-illusion}], :prerequisite_count 9, :college :knowledge, :ref "Magic, p. 104"}
             {:name :mage-sense, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :mage-sight, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :measurement, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105; Social Engineering: Back to School, p. 24"}
             {:name :metal-vision, :prerequisites [:shape-metal], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 183"}
             {:name :mind-over-matter, :prerequisites [[:skills/magery 2] :divination], :prerequisite_count 0, :college :knowledge, :ref "Magic Styles: Dungeon Magic, p. 27"}
             {:name :necrovision, :prerequisites [:lightning :seek-emitter], :prerequisite_count 0, :college :knowledge, :ref "Technomancer p 23"}
             {:name :pathfinder, :prerequisites [[:skills/magery 1] [:attributes/int 12]], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 105"}
             {:name :plant-vision, :prerequisites [:shape-plant], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 162"}
             {:name :plastic-vision, :prerequisites [:shape-plastic], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 183"}
             {:name :prehistory, :prerequisites [:ancient-history], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 104"}
             {:name :projection, :prerequisites [:sense-spirit [4 :knowledge]], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 105"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :prerequisite_count 9, :college :knowledge, :ref "Magic, p. 104"}
             {:name :reconstruct-spell, :prerequisites [[:skills/magery 2] :history :identify-spell], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 104"}
             {:name :remember-path, :prerequisites [:find-direction :memorize], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 105"}
             {:name :retro-reading, :prerequisites [:trace], :prerequisite_count 4, :college :knowledge, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :scents-of-the-past, :prerequisites [[:skills/magery 2] :history :odor], :prerequisite_count 8, :college :knowledge, :ref "Magic, p. 107"}
             {:name :schematic, :prerequisites [:reveal-function :history], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 177"}
             {:name :see-secrets, :prerequisites [:seeker :aura], :prerequisite_count 5, :college :knowledge, :ref "Magic, p. 105; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :seek-ley-line, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :knowledge, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :seek-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 102"}
             {:name :seek-navy, :prerequisites [[8 :third-level]], :prerequisite_count 0, :college :knowledge, :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
             {:name :seek-number, :prerequisites [[:skills/magery 1] :world/tl-6+], :prerequisite_count 0, :college :knowledge, :ref "Technomancer p. 18"}
             {:name :seeker, :prerequisites [[:skills/magery 1] [:attributes/int 12]], :prerequisite_count 2, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 105"}
             {:name :sense-mana, :prerequisites [:detect-magic], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 111"}
             {:name :summon-shade, :prerequisites [#{:summon-spirit :divination}], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 102"}
             {:name :sweet-oblivion, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 11"}
             {:name :televisomancy, :prerequisites [[:skills/magery 1] #{[6 :technological] :electronics-operation-communications-15+}], :prerequisite_count 0, :college :knowledge, :ref "Classic: Technomancer p 23"}
             {:name :tell-position, :prerequisites [:measurement], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :tell-time, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic, p. 100"}
             {:name :test, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 10"}
             {:name :test-load, :prerequisites [:measurement], :prerequisite_count 1, :college :knowledge, :ref "Magic, p. 101"}
             {:name :thaumatomancy, :prerequisites [], :prerequisite_count 0, :college :knowledge, :ref "Magic: The Least of Spells p. 12"}
             {:name :trace, :prerequisites [:seeker], :prerequisite_count 3, :college :knowledge, :ref "Basic Set, p. 249; Magic, p. 106"}
             {:name :vision-of-doom, :prerequisites [[:skills/magery 3] :summon-shade], :prerequisite_count 0, :college :knowledge, :ref "Magic: Death Spells, p. 15"}
             {:name :water-vision, :prerequisites [:shape-water], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 187"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :prerequisite_count 6, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-eye, :prerequisites [:apportation :keen-vision], :prerequisite_count 2, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :prerequisite_count 4, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :prerequisite_count 7, :college :knowledge, :ref "Magic, p. 104"}
             {:name :wizard-nose, :prerequisites [:apportation :far-tasting], :prerequisite_count 3, :college :knowledge, :ref "Magic, p. 104"}
             {:name :blackout, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :blur, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Basic Set p. 250; Magic p. 113"}
             {:name :body-of-shadow, :prerequisites [[:skills/magery 2] :shape-darkness], :prerequisite_count 4, :college :light-and-darkness, :ref "M114"}
             {:name :bright-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :cleansing-light, :prerequisites [[:skills/magery 3] :10-ligh [:darkness :flash] :light-jet :sunbolt], :prerequisite_count 10, :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :coherent-light-jet, :prerequisites [:light-jet], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :colors, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :continual-light, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Basic Set p. 249; Magic p. 110"}
             {:name :continual-mage-light, :prerequisites [:mage-light :continual-light], :prerequisite_count 5, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :continual-sunlight, :prerequisites [:sunlight], :prerequisite_count 5, :college :light-and-darkness, :ref "Classic: Magic p 64/Magic, p. 114"}
             {:name :dark-vision, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :darkness, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Basic Set p. 250; Magic p. 111"}
             {:name :disruption-bolt, :prerequisites [:spectrum-vision [6 :light-and-darkness]], :prerequisite_count 0, :college :light-and-darkness, :ref "Technomancer p 24"}
             {:name :flash, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :gloom, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :glow, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :goggles, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :hawk-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :hide, :prerequisites [#{:blur :forgetfulness}], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113; Fantasy, p. 170"}
             {:name :images-of-the-past, :prerequisites [[:skills/magery 2] :history :simple-illusion], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 105"}
             {:name :infrared-flash, :prerequisites [:flash :colors], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :infravision, :prerequisites [#{:keen-vision [5 :light]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :invisibility], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 114; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
             {:name :invisible-sunbolt, :prerequisites [[:skills/magery 3] :spectrum-vision :sunbolt], :prerequisite_count 0, :college :light-and-darkness, :ref "Classic: Technomancer p. 24"}
             {:name :light, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Basic Set p. 253; Magic p. 110"}
             {:name :light-jet, :prerequisites [#{:continual-light :shape-light}], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :mage-light, :prerequisites [:mage-sight :light], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :mass-invisibility, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic Styles: Dungeon Magic, p. 32"}
             {:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :prerequisite_count 0, :college :light-and-darkness, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
             {:name :mirror, :prerequisites [:colors], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 112"}
             {:name :night-vision, :prerequisites [5 :light-and-darkness], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111; Fantasy, p. 170"}
             {:name :phosphorescence, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :remove-reflection, :prerequisites [:remove-shadow], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :remove-shadow, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 110"}
             {:name :see-invisible, :prerequisites [:dark-vision :infravision :or-invisibility], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shadowplay, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 11"}
             {:name :shadow-slay, :prerequisites [[:skills/magery 3] :body-of-shadow :remove-shadow], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: Death Spells, p. 16"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 169"}
             {:name :shape-darkness, :prerequisites [:darkness], :prerequisite_count 3, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :shape-light, :prerequisites [:light], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :prerequisite_count 1, :college :light-and-darkness, :ref "Magic p. 111"}
             {:name :sunbolt, :prerequisites [:6-ligh [:darkness :sunlight]], :prerequisite_count 6, :college :light-and-darkness, :ref "Magic p. 114"}
             {:name :sunburst, :prerequisites [[:skills/magery 4] [10 :light-and-darkness] :sunbolt], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: Artillery Spells p. 18"}
             {:name :sunlight, :prerequisites [[:skills/magery 1] :glow :colors], :prerequisite_count 4, :college :light-and-darkness, :ref "Magic p. 114"}
             {:name :twinkle, :prerequisites [], :prerequisite_count 0, :college :light-and-darkness, :ref "Magic: The Least of Spells p. 12"}
             {:name :wall-of-light, :prerequisites [:continual-light], :prerequisite_count 2, :college :light-and-darkness, :ref "Magic p. 113"}
             {:name :animate-object, :prerequisites [[:skills/magery 2] [3 :shape]], :prerequisite_count 6, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :annihilation, :prerequisites [[:skills/magery 3] :disintegrate #{:deathtouch :steal-vitality}], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :prerequisite_count 3, :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :clean, :prerequisites [:restore], :prerequisite_count 2, :college :making-and-breaking, :ref "Magic p. 116; Classic: Technomancer p 25"}
             {:name :contract-object, :prerequisites [[:skills/magery 3] :transform-object], :prerequisite_count 15, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :copy, :prerequisites [:dye :1-written-language-at-accented], :prerequisite_count 5, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :destabilization, :prerequisites [[:skills/magery 3] :annihilation :explode], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: Death Spells, p. 16"}
             {:name :disintegrate, :prerequisites [[:skills/magery 2] :shatter :ruin :earth-to-air :destroy-air :destroy-water], :prerequisite_count 17, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :draw-together-shards, :prerequisites [:repair :trace :apportation], :prerequisite_count 0, :college :making-and-breaking, :ref "Alphabet Arcane, p. 9"}
             {:name :dye, :prerequisites [:restore :colors], :prerequisite_count 4, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :enlarge-object, :prerequisites [:extend-object], :prerequisite_count 16, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :explode, :prerequisites [[:skills/magery 2] :shatter :apportation], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :explosive-mine, :prerequisites [[:skills/magery 3] :10-makin [:breaking :explode]], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :extend-object, :prerequisites [[:skills/magery 3] :transform-object], :prerequisite_count 15, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :fasten, :prerequisites [:knot], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :find-weakness, :prerequisites [:1-spell-from-each-of-4-elements], :prerequisite_count 4, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :immediate-action, :prerequisites [#{:apportation :find-weakness}], :prerequisite_count 0, :college :making-and-breaking, :ref "Classic: Technomancer p. 25"}
             {:name :inscribe, :prerequisites [:simple-illusion :copy], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 97"}
             {:name :inspired-creation, :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic p. 115"}
             {:name :knot, :prerequisites [:stiffen], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :mapmaker, :prerequisites [:inscribe :measurement], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :minefield, :prerequisites [[:skills/magery 4] :explosive-mine], :prerequisite_count 11, :college :making-and-breaking, :ref "Magic: Artillery Spells p. 19"}
             {:name :mystic-mark, :prerequisites [:dye :trace], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :rebuild, :prerequisites [[:skills/magery 3] :repair :create-object [:3-of-each-element]], :prerequisite_count 22, :college :making-and-breaking, :ref "Magic p. 177"}
             {:name :rejoin, :prerequisites [:weaken :restore], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :repair, :prerequisites [[:skills/magery 2] :rejoin], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :reshape, :prerequisites [[:skills/magery 1] :weaken #{:shape-earth :shape-plant}], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :restore, :prerequisites [#{:find-weakness :simple-illusion}], :prerequisite_count 1, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :rive, :prerequisites [[:skills/magery-2] :shatter], :prerequisite_count 7, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :ruin, :prerequisites [[:skills [:attributes/magery 1]] :weaken :decay], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :self-repairing, :prerequisites [[:skills/magery-2] :repair], :prerequisite_count 9, :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :sharpen, :prerequisites [:repair], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shatter, :prerequisites [[:skills/killsmagery 1] :weaken], :prerequisite_count 6, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :shatterproof, :prerequisites [:repair :shatter], :prerequisite_count 10, :college :making-and-breaking, :ref "Magic p. 118"}
             {:name :shrink-object, :prerequisites [:contract-object], :prerequisite_count 16, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :soilproof, :prerequisites [:materialize], :prerequisite_count 3, :college :making-and-breaking, :ref "Magic p. 116; Thaumatology: Urban Magics, p. 33"}
             {:name :soul-creation, :prerequisites [:inspired-creation], :prerequisite_count 1, :college :making-and-breaking, :ref "Classic: Magic Items 3 p. 31"}
             {:name :stiffen, :prerequisites [:rejoin], :prerequisite_count 8, :college :making-and-breaking, :ref "Magic p. 117"}
             {:name :tack, :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :toughen, :prerequisites [:shatterproof], :prerequisite_count 11, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :transfigure-object, :prerequisites [[:skilmagery-3] :transform-object], :prerequisite_count 0, :college :making-and-breaking, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
             {:name :transform-object, :prerequisites [:m2 :reshape [4 :create]], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic p. 120"}
             {:name :transparency, :prerequisites [:dye :stone-to-earth], :prerequisite_count 9, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :weaken, :prerequisites [:find-weakness], :prerequisite_count 5, :college :making-and-breaking, :ref "Magic p. 116"}
             {:name :weapon-self, :prerequisites [[:skills/magery 2] :apportation :6-makin [:breaking :reshape]], :prerequisite_count 12, :college :making-and-breaking, :ref "Magic p. 119"}
             {:name :wizardly-workshop, :prerequisites [], :prerequisite_count 0, :college :making-and-breaking, :ref "Magic: The Least of Spells p. 12"}
             {:name :bless, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 129"}
             {:name :catch-spell, :prerequisites [[:skills/magery 2] [:attributes/dex 12] :return-missile], :prerequisite_count 2, :college :meta, :ref "Magic p. 123"}
             {:name :charge-powerstone, :prerequisites [[:skills/magery 3] :powerstone :lend-energy], :prerequisite_count 12, :college :meta, :ref "Magic p. 126/Classic: Grimoire p. 74"}
             {:name :conceal-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :meta, :ref "Magic p. 122, Thaumatology: Urban Magics"}
             {:name :counterspell, :prerequisites [[:skills/magery 1] :spell-being-countered], :prerequisite_count 0, :college :meta, :ref "Basic Set, p. 250; Magic p. 121"}
             {:name :curse, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 129"}
             {:name :dispel-magic, :prerequisites [:counterspell [12 :other]], :prerequisite_count 13, :college :meta, :ref "Basic Set, p. 250; Magic p. 126"}
             {:name :dispel-spark, :prerequisites [[:skills/magery 3] :drain-mana :remove-aura], :prerequisite_count 0, :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :displace-spell, :prerequisites [:suspend-magic], :prerequisite_count 10, :college :meta, :ref "Magic p. 124, Thaumatology: Urban Magics"}
             {:name :drain-magery, :prerequisites [[[:skills/magery 3]] :suspend-magery], :prerequisite_count 21, :college :meta, :ref "Magic p. 130"}
             {:name :drain-mana, :prerequisites [:dispel-magic :suspend-mana], :prerequisite_count 14, :college :meta, :ref "Magic p. 127"}
             {:name :dread-curse, :prerequisites [[:skills/magery 1] :curse], :prerequisite_count 0, :college :meta, :ref "Magic: Death Spells, p. 17"}
             {:name :end-scene, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :false-aura, :prerequisites [:conceal-magic :aura], :prerequisite_count 5, :college :meta, :ref "Magic p. 122"}
             {:name :great-ward, :prerequisites [[:skills/magery 1] :ward], :prerequisite_count 1, :college :meta, :ref "Magic p. 122"}
             {:name :hang-spell, :prerequisites [:delay], :prerequisite_count 16, :college :meta, :ref "Magic p. 128; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
             {:name :internalize-elixir, :prerequisites [[:skills/magery 1] :detect-magic :know-recipie], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 10"}
             {:name :lend-spell, :prerequisites [[:skills/magery 1] :lend-skill :1-spell-each-from-6-colleges], :prerequisite_count 11, :college :meta, :ref "Magic p. 126"}
             {:name :ley-buffer, :prerequisites [[:skills/magery 1] :ley-tap], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :ley-line-creation, :prerequisites [:seek-ley-line :apportation], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 21"}
             {:name :ley-supply, :prerequisites [:ley-tap #{:lend-energy :minor-draw-power}], :prerequisite_count 0, :college :meta, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :magic-resistance, :prerequisites [[:skills/magery 1] :1-spell-each-from-7-colleges], :prerequisite_count 7, :college :meta, :ref "Magic p. 123"}
             {:name :mana-storm, :prerequisites [[:skills/magery 4] :drain-mana :restore-man], :prerequisite_count 0, :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :mana-vortex, :prerequisites [[:skills/magery 2] :lend-energy :sense-danger], :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 27; Thaumatology: Urban Magics"}
             {:name :maintain-spell, :prerequisites [:link], :prerequisite_count 17, :college :meta, :ref "Magic p. 128; Thaumatology: Urban Magics"}
             {:name :penetrating-spell, :prerequisites [:delay :find-weakness], :prerequisite_count 16, :college :meta, :ref "Magic p. 123"}
             {:name :pentagram, :prerequisites [:spell-shield], :prerequisite_count 9, :college :meta, :ref "Magic p. 124; Thaumatology: Urban Magics"}
             {:name :preemptive-experience, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/28: Thaumatology II, p. 37"}
             {:name :punishment-circle, :prerequisites [[:skills/magery 3] #{:pentagram :repel-spirits}], :prerequisite_count 0, :college :meta, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :raise-cone-of-power, :prerequisites [:lend-energy #{:pentagram :restore-mana}], :prerequisite_count 0, :college :meta, :ref "GURPS Thaumatology, p. 52"}
             {:name :reflect, :prerequisites [:ward], :prerequisite_count 1, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics"}
             {:name :remove-aura, :prerequisites [:dispel-magic :aura], :prerequisite_count 14, :college :meta, :ref "Magic p. 127"}
             {:name :remove-curse, :prerequisites [[:skills/magery 2] :1-spell-from-each-of-15-colleges], :prerequisite_count 15, :college :meta, :ref "Magic p. 126; Thaumatology: Urban Magics"}
             {:name :restore-mana, :prerequisites [:dispel-magic :suspend-mana], :prerequisite_count 14, :college :meta, :ref "Magic p. 128; Thaumatology: Urban Magics"}
             {:name :scryfool, :prerequisites [[:skills/magery 2] :sense-observation :simple-illusion], :prerequisite_count 3, :college :meta, :ref "Magic p. 123; Classic: Grimoire p 74"}
             {:name :scryguard, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "GURPS Fantasy, p. 170; Thaumatology: Urban Magics"}
             {:name :scrywall, :prerequisites [:scryguard], :prerequisite_count 1, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics, p. 33"}
             {:name :seek-magic, :prerequisites [:detect-magic], :prerequisite_count 1, :college :meta, :ref "Magic p. 102"}
             {:name :self-destruct, :prerequisites [[:skills/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :prerequisite_count 10, :college :meta, :ref "Magic: Artillery Spells p. 23"}
             {:name :sovereign-countermagic, :prerequisites [[:skills/magery 3] :analyze-magic :dispel-magic], :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :sovereign-ward, :prerequisites [:skills/magery 3] :dispel-magic :ward, :prerequisite_count 0, :college :meta, :ref "Magic Styles: Dungeon Magic, p. 28"}
             {:name :spell-shield, :prerequisites [[:skills/magery 2] :scryguard :magic-resistance], :prerequisite_count 8, :college :meta, :ref "Magic p. 124"}
             {:name :spell-wall, :prerequisites [:spell-shield], :prerequisite_count 9, :college :meta, :ref "Magic p. 124; Thaumatology: Urban Magics"}
             {:name :spellguard, :prerequisites [:dispel-magic], :prerequisite_count 14, :college :meta, :ref "Magic p. 127; Thaumatology: Urban Magics"}
             {:name :steal-spell, :prerequisites [:lend-spell :great-ward], :prerequisite_count 13, :college :meta, :ref "Magic p. 127"}
             {:name :suspend-curse, :prerequisites [[:skills/magery 1] :1-spell-each-from-12-colleges], :prerequisite_count 12, :college :meta, :ref "Magic p. 125"}
             {:name :suspend-magery, :prerequisites [[:skills/magery 2]  :2-each-from-10-colleges], :prerequisite_count 20, :college :meta, :ref "Magic p. 130"}
             {:name :suspend-magic, :prerequisites [:suspend-spell [8 :meta]], :prerequisite_count 8, :college :meta, :ref "Magic p. 123"}
             {:name :suspend-mana, :prerequisites [:suspend-magic :1-spell-each-from-10-colleges], :prerequisite_count 10, :college :meta, :ref "Magic p. 125"}
             {:name :suspend-spell, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "Magic p. 121; Thaumatology: Urban Magics"}
             {:name :telecast, :prerequisites [[:skills/magery 3] :teleport :wizard-eye :1-spell-each-from-10-colleges], :prerequisite_count 12, :college :meta, :ref "Magic p. 128"}
             {:name :thaumatomancy, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Magic: The Least of Spells p. 12"}
             {:name :throw-spell, :prerequisites [:delay :catch-spell], :prerequisite_count 16, :college :meta, :ref "Magic p. 128"}
             {:name :use-item, :prerequisites [], :prerequisite_count 0, :college :meta, :ref "Magic: The Least of Spells p. 12-13"}
             {:name :void-bolt, :prerequisites [[:skills/magery 4] :4-essentials-taken-as-prerequisites [4 :missile]], :prerequisite_count 0, :college :meta, :ref "Pyramid 3/25: Epic Magic, p. 19"}
             {:name :ward, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :meta, :ref "Magic p. 122; Thaumatology: Urban Magics"}
             {:name :adjuration, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :alertness, :prerequisites [[:skills/magery 2] :create-acid], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 133; Classic: Magic p 69"}
             {:name :avoid, :prerequisites [:hide :fear :forgetfulness], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 140"}
             {:name :berserker, :prerequisites [:bravery], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 134"}
             {:name :boost-intelligence, :prerequisites [:wisdom], :prerequisite_count nil, :college :mind-control, :ref "Magic p. 37"}
             {:name :bravery, :prerequisites [:fear], :prerequisite_count 1, :college :mind-control, :ref "Magic p. 134"}
             {:name :charm, :prerequisites [[:skills/magery 1] :loyalty [7 :other]], :prerequisite_count 8, :college :mind-control, :ref "Magic p. 139"}
             {:name :coma, :prerequisites [[:skills/magery 3] :lesser-geas :sleep], :prerequisite_count 0, :college :mind-control, :ref "Magic: Death Spells, p. 17"}
             {:name :command, :prerequisites [[:skills/magery 2] :forgetfulness], :prerequisite_count 2, :college :mind-control, :ref "Basic Set, p. 251; Magic p. 136"}
             {:name :compel-lie, :prerequisites [:emotion-control], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 137"}
             {:name :confuse-memory, :prerequisites [:foolishness], :prerequisite_count 1, :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 14"}
             {:name :daze, :prerequisites [:foolishness], :prerequisite_count 1, :college :mind-control, :ref "Basic Set'', p. 250; Magic p. 134"}
             {:name :disbelieve, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :discord, :prerequisites [[:skills/magery 2] :emotion-control :vexation], :prerequisite_count 0, :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 31"}
             {:name :disorient, :prerequisites [:foolishness], :prerequisite_count 1, :college :mind-control, :ref "Magic p. 135"}
             {:name :drama, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 7"}
             {:name :dream-projection, :prerequisites [:dream-sending], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 46"}
             {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 45"}
             {:name :drunkenness, :prerequisites [:foolishness :clumsiness], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 136"}
             {:name :dull, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic p. 133"}
             {:name :dullness, :prerequisites [:dull], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 134"}
             {:name :ecstasy, :prerequisites [[:skills/magery 2] :emotion-control], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 139"}
             {:name :emotion-control, :prerequisites [#{:loyalty :mental-stun}], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 137"}
             {:name :encrypt, :prerequisites [:daze], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 135"}
             {:name :enslave, :prerequisites [:charm :telepathy], :prerequisite_count 14, :college :mind-control, :ref "Magic p. 141"}
             {:name :enthrall, :prerequisites [:forgetfulness :daze :slow], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 139"}
             {:name :false-memory, :prerequisites [:forgetfulness [6 :mind-control]], :prerequisite_count 7, :college :mind-control, :ref "Magic p. 139"}
             {:name :fascinate, :prerequisites [:daze], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 135"}
             {:name :fear, :prerequisites [#{:sense-emotion :empathy}], :prerequisite_count 0, :college :mind-control, :ref "Magic p. 139; Fantasy, p. 171"}
             {:name :foolishness, :prerequisites [[:attributes/int 12]], :prerequisite_count 0, :college :mind-control, :ref "Basic Set p. 250; Magic p. 134"}
             {:name :forgetfulness, :prerequisites [[:skills/magery 1] :foolishness], :prerequisite_count 1, :college :mind-control, :ref "Basic Set p. 250; Magic p. 135"}
             {:name :game-addict, :prerequisites [:charm], :prerequisite_count 0, :college :mind-control, :ref "Classic: Technomancer p. 25"}
             {:name :glib-tongue, :prerequisites [:suggestion], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 141"}
             {:name :great-geas, :prerequisites [[:skills/magery 3] [15 :mind] :lesser-geas], :prerequisite_count 15, :college :mind-control, :ref "Magic p. 141; Social Engineering: Back to School, p. 24"}
             {:name :great-hallucination, :prerequisites [[:skills/magery 2] :hallucination], :prerequisite_count 8, :college :mind-control, :ref "Magic p. 141"}
             {:name :hallucination, :prerequisites [:madness :suggestion], :prerequisite_count 7, :college :mind-control, :ref "Magic p. 140"}
             {:name :hypnotize, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :keen, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic p. 133"}
             {:name :keyfinder, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :know-thyself, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :lesser-geas, :prerequisites [[:skills/magery 2] [10 :mind]], :prerequisite_count 10, :college :mind-control, :ref "Magic p. 140; Social Engineering: Back to School, p. 24"}
             {:name :literary-hunger, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :loyalty, :prerequisites [:bravery [2 :other]], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 136"}
             {:name :lure, :prerequisites [:emotion-control], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 137/Classic: Grimoire p 76"}
             {:name :madness, :prerequisites [#{:forgetfulness :drunkenness}], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 136"}
             {:name :mass-charm, :prerequisites [[:skills/magery 2] [:attributes/int 13] :charm], :prerequisite_count 2, :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 31"}
             {:name :mass-daze, :prerequisites [:daze [:attributes/int 13]], :prerequisite_count 3, :college :mind-control, :ref "Basic Set p. 251; Magic p. 137"}
             {:name :mass-hallucination, :prerequisites [[:skills/magery 2] [:attributes/int 13] :hallucination], :prerequisite_count 8, :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 32"}
             {:name :mass-mutilation, :prerequisites [[:skills/magery 4] [10 :mind] :madness :mass-suggestion], :prerequisite_count 10, :college :mind-control, :ref "Magic: Artillery Spells p. 20"}
             {:name :mass-sleep, :prerequisites [:sleep [:attributes/int 13]], :prerequisite_count 3, :college :mind-control, :ref "Basic Set p. 251; Magic p. 137"}
             {:name :mass-suggestion, :prerequisites [:suggestion], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 141"}
             {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 105; Social Engineering: Back to School, p. 24"}
             {:name :mental-stun, :prerequisites [#{:daze :stun}], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 135"}
             {:name :mind-killer, :prerequisites [[:skills/magery 3] :sickness :strengthen-will], :prerequisite_count 0, :college :mind-control, :ref "Magic: Death Spells, p. 17"}
             {:name :mindlessness, :prerequisites [[:skills/magery 2] :forgetfulness], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 137"}
             {:name :nightmare, :prerequisites [[:skills/magery 2] :death-vision :fear :sleep], :prerequisite_count 5, :college :mind-control, :ref "Magic p. 140"}
             {:name :oath, :prerequisites [[:skills/magery 1] :emotion-control], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 138"}
             {:name :pacify, :prerequisites [[:skills/magery 2] :persuasion :relieve-madness], :prerequisite_count 0, :college :mind-control, :ref "Magic Styles: Dungeon Magic, p. 24"}
             {:name :panic, :prerequisites [:fear], :prerequisite_count 1, :college :mind-control, :ref "Magic p. 134"}
             {:name :patience, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :peaceful-sleep, :prerequisites [:sleep :silence], :prerequisite_count 5, :college :mind-control, :ref "Magic p. 138"}
             {:name :permanent-forgetfulness, :prerequisites [[:skills/magery 2] :forgetfulness [:attributes/int 13]], :prerequisite_count 2, :college :mind-control, :ref "Magic p. 138"}
             {:name :permanent-madness, :prerequisites [[:skills/magery 2] :madness [:attributes/int 13]], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 139"}
             {:name :rear-vision, :prerequisites [:alertness], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 134"}
             {:name :recall, :prerequisites [[:skills/magery 2] :memorize :history], :prerequisite_count 9, :college :mind-control, :ref "Magic p. 104"}
             {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :prerequisite_count 9, :college :mind-control, :ref "Magic p. 92"}
             {:name :sickness, :prerequisites [#{:drunkenness :pestilence}], :prerequisite_count 3, :college :mind-control, :ref "Magic p. 138"}
             {:name :sleep, :prerequisites [:daze], :prerequisite_count 2, :college :mind-control, :ref "Basic Set p. 251; Magic p. 135"}
             {:name :speed-reading, :prerequisites [#{[:attributes/int 12] :gift-of-letters}], :prerequisite_count 0, :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :stabbing-party, :prerequisites [[:skills/magery 4] [10 :mind] :comm :mass-suggestion], :prerequisite_count 10, :college :mind-control, :ref "Magic: Artillery Spells p. 20-21"}
             {:name :startle, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 13"}
             {:name :strengthen-will, :prerequisites [[:skills/magery 1] [6 :mind]], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 136"}
             {:name :suggestion, :prerequisites [:emotion-control :forgetfulness], :prerequisite_count 5, :college :mind-control, :ref "Magic p. 140"}
             {:name :sweet-oblivion, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 11"}
             {:name :transfer-loyalty, :prerequisites [:bravery #{[2 :mind-control] :enchantment}], :prerequisite_count 0, :college :mind-control, :ref "Classic: Magic Items 3 p 33"}
             {:name :terror, :prerequisites [:fear], :prerequisite_count 1, :college :mind-control, :ref "Magic p. 134"}
             {:name :vigil, :prerequisites [[:skills/magery 2] :sleep :lend-energy], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 138"}
             {:name :volatility, :prerequisites [], :prerequisite_count 0, :college :mind-control, :ref "Magic: The Least of Spells p. 14"}
             {:name :weaken-will, :prerequisites [[:skills/magery 1] :foolishness], :prerequisite_count 1, :college :mind-control, :ref "Magic p. 136"}
             {:name :will-lock, :prerequisites [:emotion-control], :prerequisite_count 4, :college :mind-control, :ref "Magic p. 138"}
             {:name :wisdom, :prerequisites [[6 :other]], :prerequisite_count 6, :college :mind-control, :ref "Magic p. 135; Social Engineering: Back to School, p. 24"}
             {:name :writer's-block, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :mind-control, :ref "Pyramid 3/48: Secret Magic, p. 22"}
             {:name :air-vortex, :prerequisites [[:skills/magery 2] :body-of-air :windstorm], :prerequisite_count 5, :college :movement, :ref "Magic p. 26"}
             {:name :apportation, :prerequisites [[:skills/magery 1]], :prerequisite_count 0, :college :movement, :ref "Basic Set, p. 251; Magic p. 142"}
             {:name :beacon, :prerequisites [:teleport :timeport :or-plane-shift], :prerequisite_count 5, :college :movement, :ref "Magic p. 83"}
             {:name :blink, :prerequisites [:teleport], :prerequisite_count 5, :college :movement, :ref "Magic p. 148"}
             {:name :blink-other, :prerequisites [:blink], :prerequisite_count 6, :college :movement, :ref "Magic p. 148"}
             {:name :cloud-vaulting, :prerequisites [[:skills/magery 2] :jump :walk-on-air], :prerequisite_count 12, :college :movement, :ref "Magic p. 148"}
             {:name :cloud-walking, :prerequisites [:walk-on-air :walk-on-water], :prerequisite_count 9, :college :movement, :ref "Magic p. 148"}
             {:name :collision, :prerequisites [[:skills/magery 4] [10 :movement] :poltergeist :pull], :prerequisite_count 10, :college :movement, :ref "Magic: Artillery Spells p. 21"}
             {:name :crushing-fist, :prerequisites [[:skills/magery 4] [10 :movement] :distant-blow :wizard-han], :prerequisite_count 10, :college :movement, :ref "Magic: Artillery Spells p. 21"}
             {:name :cushion, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :dancing-object, :prerequisites [[:skills/magery 2] :apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 144, Classic Magic p 61"}
             {:name :deflect-missile, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref ""}
             {:name :disruption, :prerequisites [[:skills/magery 3] :any- [0 :movement] :manipulate :undo], :prerequisite_count 10, :college :movement, :ref "Magic: Death Spells, p. 17"}
             {:name :distant-blow, :prerequisites [[:skills/magery 2] :apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 144"}
             {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :prerequisite_count 6, :college :movement, :ref "Magic p. 84"}
             {:name :ethereal-body, :prerequisites [[6 :movement] :or-magery-3 :body-of-air], :prerequisite_count 4, :college :movement, :ref "Magic p. 146"}
             {:name :flee, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :flight, :prerequisites [[:skills/magery 2] :levitation], :prerequisite_count 2, :college :movement, :ref "Magic p. 145; Fantasy, p. 171"}
             {:name :flying-carpet, :prerequisites [:flight :or-magery-2 :walk-on-air], :prerequisite_count 3, :college :movement, :ref "Magic p. 145"}
             {:name :force-ball, :prerequisites [[:skills/magery 4] :catch-spell :force-dome :sense-foes], :prerequisite_count 0, :college :movement, :ref "Magic: Artillery Spells p. 24-25"}
             {:name :freedom, :prerequisites [[3 :body] [3 :movement] :3-protectio  :warning], :prerequisite_count 9, :college :movement, :ref "Magic p. 148"}
             {:name :glue, :prerequisites [:haste], :prerequisite_count 1, :college :movement, :ref "Magic p. 142"}
             {:name :grease, :prerequisites [:haste], :prerequisite_count 1, :college :movement, :ref "Magic p. 142; Classic: Grimoire p 79"}
             {:name :great-deflect-missile, :prerequisites [[:skills/magery 2] :deflect-missile], :prerequisite_count 2, :college :movement, :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magic Styles: Dungeon Magic"}
             {:name :great-haste, :prerequisites [[:skills/magery 1] [:attributes/int 12] :haste], :prerequisite_count 1, :college :movement, :ref "Basic Set, p. 251; Magic p. 146"}
             {:name :hail-of-lead, :prerequisites [:haste :immediate-action], :prerequisite_count 0, :college :movement, :ref "Classic: Technomancer p 26"}
             {:name :haste, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Basic Set, p. 251; Magic p. 142"}
             {:name :hawk-flight, :prerequisites [:flight], :prerequisite_count 3, :college :movement, :ref "Magic p. 146"}
             {:name :hinder, :prerequisites [#{:clumsiness :haste}], :prerequisite_count 1, :college :movement, :ref "Basic Set, p. 244; Magic p. 36"}
             {:name :hold-fast, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143"}
             {:name :homing-missile, :prerequisites [:q-13+ :seeker :curse-missile :explosive-fireball :fireball :high-explosive-fireball :ice-dagger :ice-sphere :shaped-charge-fireball #{:stone-missile :winged-knife}], :prerequisite_count 0, :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :increase-burden, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143; Classic: Grimoire p. 79"}
             {:name :jump, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143"}
             {:name :levitation, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143, Fantasy, p. 171/Classic: Magic p 70"}
             {:name :ley-float, :prerequisites [[:skilmager3] :enchant :ley-supply], :prerequisite_count 12, :college :movement, :ref "Thaumatology: Urban Magics, p. 20"}
             {:name :ley-running, :prerequisites [:seek-ley-line :haste], :prerequisite_count 1, :college :movement, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :ley-vehicle, :prerequisites [:ley-float :ley-running], :prerequisite_count 0, :college :movement, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :light-tread, :prerequisites [:apportation :shape-earth], :prerequisite_count 3, :college :movement, :ref "Magic p. 145"}
             {:name :lighten-burden, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143; Fantasy, p. 171"}
             {:name :lockmaster, :prerequisites [[:skills/magery 2] :apportation], :prerequisite_count 1, :college :movement, :ref "Basic Set, p. 251; Magic p. 144"}
             {:name :locksmith, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 143"}
             {:name :long-march, :prerequisites [[:attributes/magery 1] #{:clumsiness :debility}], :prerequisite_count 1, :college :movement, :ref "Magic p. 143"}
             {:name :magic-bullet, :prerequisites [:poltergeist], :prerequisite_count 0, :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :manipulate, :prerequisites [:locksmith], :prerequisite_count 2, :college :movement, :ref "Magic p. 145"}
             {:name :open-door, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :quarter, :prerequisites [[:attributes/magery 3] :any- [0 :movement] :pull :repel], :prerequisite_count 10, :college :movement, :ref "Magic: Death Spells, p. 18"}
             {:name :quick-march, :prerequisites [[:attributes/magery 1] :haste], :prerequisite_count 1, :college :movement, :ref "Magic p. 144; Fantasy, p. 171"}
             {:name :poltergeist, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 144"}
             {:name :pull, :prerequisites [[:skills/magery 2] [4 :movement] :levitation], :prerequisite_count 4, :college :movement, :ref "Magic p. 146"}
             {:name :rapid-journey, :prerequisites [[:attributes/magery 3] #{:teleport :timeport}], :prerequisite_count 5, :college :movement, :ref "Magic p. 82"}
             {:name :reduce-recoil, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :prerequisite_count 0, :college :movement, :ref "GURPS Bio-Tech, p. 32"}
             {:name :repel, :prerequisites [[:skills/magery 2] [4 :movement] :levitation], :prerequisite_count 4, :college :movement, :ref "Magic p. 146"}
             {:name :reorient, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Magic: The Least of Spells p. 10"}
             {:name :sink, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Magic: The Least of Spells p. 14"}
             {:name :slasher, :prerequisites [[:attributes/magery 4] [10 :movement] :dancing-object :winged-knife], :prerequisite_count 10, :college :movement, :ref "Magic: Artillery Spells p. 22"}
             {:name :slide, :prerequisites [:apportation :grease], :prerequisite_count 3, :college :movement, :ref "Magic p. 145"}
             {:name :slow, :prerequisites [[:attributes/magery 1] :haste :hinder], :prerequisite_count 2, :college :movement, :ref "Magic p. 145"}
             {:name :slow-fall, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 144"}
             {:name :steady-hand, :prerequisites [], :prerequisite_count 0, :college :movement, :ref "Classic: Technomancer p. 26"}
             {:name :swim, :prerequisites [:shape-water :levitation], :prerequisite_count 6, :college :movement, :ref "Magic p. 147"}
             {:name :transfer-pregnancy, :prerequisites [[:skills/magery 2] :remove-fetus], :prerequisite_count 0, :college :movement, :ref "GURPS Bio-Tech, p. 32"}
             {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :prerequisite_count 4, :college :movement, :ref "Magic p. 147; Fantasy, p. 171"}
             {:name :teleport-other, :prerequisites [[:attributes/magery 3] :teleport], :prerequisite_count 5, :college :movement, :ref "Magic p. 147"}
             {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :prerequisite_count 5, :college :movement, :ref "Magic p. 84"}
             {:name :undo, :prerequisites [:locksmith], :prerequisite_count 2, :college :movement, :ref "Magic p. 145"}
             {:name :wallwalker, :prerequisites [:apportation], :prerequisite_count 1, :college :movement, :ref "Magic p. 144"}
             {:name :winged-knife, :prerequisites [:poltergeist], :prerequisite_count 2, :college :movement, :ref "Magic p. 145"}
             {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :prerequisite_count 4, :college :movement, :ref "Magic p. 104"}
             {:name :affect-spirits, :prerequisites [:solidify], :prerequisite_count 4, :college :necromantic, :ref "Magic p. 151"}
             {:name :age, :prerequisites [#{:youth [6 :necromantic]}], :prerequisite_count 6, :college :necromantic, :ref "Magic p. 154"}
             {:name :animate-shadow, :prerequisites [:skull-spirit :shape-darkness], :prerequisite_count 9, :college :necromantic, :ref "Magic p. 154"}
             {:name :animation, :prerequisites [:summon-spirit], :prerequisite_count 2, :college :necromantic, :ref "Magic p. 150"}
             {:name :astral-block, :prerequisites [:summon-spirit :repel-spirits], :prerequisite_count 16, :college :necromantic, :ref "Magic p. 159"}
             {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :prerequisite_count 6, :college :necromantic, :ref "Magic p. 105"}
             {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :prerequisite_count 3, :college :necromantic, :ref "Magic p. 115"}
             {:name :banish, :prerequisites [[:attributes/magery 1] :1-spell-each-from-10-colleges], :prerequisite_count 10, :college :necromantic, :ref "Magic p. 156"}
             {:name :bind-spirit, :prerequisites [:comm :spirit :soul-jar], :prerequisite_count 12, :college :necromantic, :ref "Magic p. 158"}
             {:name :burning-death, :prerequisites [[:skills/magery 2] :heat :sickness], :prerequisite_count 10, :college :necromantic, :ref "Magic p. 76"}
             {:name :command-spirit, :prerequisites [:summon-spirit :turn-spirit], :prerequisite_count 5, :college :necromantic, :ref "Magic p. 153"}
             {:name :control-zombie, :prerequisites [:zombie], :prerequisite_count 5, :college :necromantic, :ref "Magic p. 152"}
             {:name :death-vision, :prerequisites [[:attributes/magery 1]], :prerequisite_count 0, :college :necromantic, :ref "Basic Set, p. 251; Magic p. 149"}
             {:name :dramatic-departure, :prerequisites [], :prerequisite_count 0, :college :necromantic, :ref "Magic: The Least of Spells p. 14"}
             {:name :entrap-spirit, :prerequisites [[:attributes/magery 1] :soul-jar :turn-spirit], :prerequisite_count 5, :college :necromantic, :ref "Magic p. 157"}
             {:name :evisceration, :prerequisites [[:attributes/magery 3] :apportation :steal-vitality], :prerequisite_count 6, :college :necromantic, :ref "Magic p. 154"}
             {:name :final-rest, :prerequisites [#{[:attributes/magery 1] :spirit-empathy}], :prerequisite_count 0, :college :necromantic, :ref "Magic p. 89"}
             {:name :grasping-doom, :prerequisites [:mass-zombie], :prerequisite_count 0, :college :necromantic, :ref "Magic Styles: Dungeon Magic, p. 15"}
             {:name :hellspawn, :prerequisites [:summon-demon], :prerequisite_count 11, :college :necromantic, :ref "GURPS Bio-Tech, p. 32; Technomander p. 27"}
             {:name :invoke, :prerequisites [], :prerequisite_count 0, :college :necromantic, :ref "Magic: The Least of Spells p. 14-15"}
             {:name :lich, :prerequisites [[:attributes/magery 3] [:attributes/int 13] :enchant :soul-jar :zombie], :prerequisite_count 19, :college :necromantic, :ref "Magic p. 159"}
             {:name :mass-zombie, :prerequisites [:zombie :charisma-2+], :prerequisite_count 5, :college :necromantic, :ref "Magic p. 153; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :materialize, :prerequisites [:summon-spirit], :prerequisite_count 2, :college :necromantic, :ref "Magic p. 150"}
             {:name :pestilence, :prerequisites [[:attributes/magery 1] :steal-vitality :decay], :prerequisite_count 7, :college :necromantic, :ref "Magic p. 154"}
             {:name :plant-zombie, :prerequisites [:zombie [4 :plant]], :prerequisite_count 0, :college :necromantic, :ref "Pyramid 3/68: Natural Magic, p. 10"}
             {:name :punishment-circle, :prerequisites [[:attributes/magery 3] #{:pentagram :repel-spirits}], :prerequisite_count 0, :college :necromantic, :ref "Magic: Artillery Spells p. 19-20"}
             {:name :repel-spirits, :prerequisites [:banish :turn-spirit], :prerequisite_count 14, :college :necromantic, :ref "Magic p. 158"}
             {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :prerequisite_count 9, :college :necromantic, :ref "Magic p. 94"}
             {:name :reverie-of-ruin, :prerequisites [], :prerequisite_count 0, :college :necromantic, :ref "Magic: The Least of Spells p. 15"}
             {:name :rotting-death, :prerequisites [[:skills/magery 2] :sickness :pestilence], :prerequisite_count 9, :college :necromantic, :ref "Magic p. 154"}
             {:name :self-destruct, :prerequisites [[:attributes/magery 1] #{:one-spell-from-each-of-10-different-colleges :from-fire} :meta :necromantic-college-possibly :explode], :prerequisite_count 10, :college :necromantic, :ref "Magic: Artillery Spells p. 23"}
             {:name :sense-spirit, :prerequisites [:death-vision], :prerequisite_count 1, :college :necromantic, :ref "Basic Set, p. 252; Magic p. 149"}
             {:name :skull-spirit, :prerequisites [[4 :necromantic]], :prerequisite_count 0, :college :necromantic, :ref "Magic p. 151"}
             {:name :slow-healing, :prerequisites [[:attributes/magery 1] :frailty :steal-vitality], :prerequisite_count 6, :college :necromantic, :ref "Magic p. 153"}
             {:name :solidify, :prerequisites [:materialize], :prerequisite_count 3, :college :necromantic, :ref "Magic p. 151"}
             {:name :soul-jar, :prerequisites [[:attributes/magery 1] [6 :necromantic] :steal-vitality], :prerequisite_count 6, :college :necromantic, :ref "Magic p. 154"}
             {:name :soul-prison, :prerequisites [[:attributes/magery 3] :banish :soul-jar :banish :soul-jar :any-four-of-animate-shadow :possession :repel-spirits :divination :mass-zombie :summon-demon :pentagram :summon-earth-elemental :phase-other] :college :necromantic :ref ""}
             {:name :mass-resist-lightning, :prerequisites [[:attributes/int 13] :resist-lightning], :prerequisite_count 9, :college :protection-and-warning, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
             {:name :mass-resist-poison, :prerequisites [[:attributes/int 13] :resist-poison], :prerequisite_count 4, :college :protection-and-warning, :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
             {:name :mass-shade, :prerequisites [[:attributes/int 12] :shade], :prerequisite_count 2, :college :protection-and-warning, :ref "Pyramid 3/76: Dungeon Fantasy IV p. 14"}
             {:name :missile-shield, :prerequisites [[:attributes/magery 2] #{:apportation :shield}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 168; Thaumatology: Urban Magics, p. 33"}
             {:name :mystic-mist, :prerequisites [[:attributes/magery 1] #{:watchdog :shield}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :nightingale, :prerequisites [:sense-danger], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 167"}
             {:name :oven-mitts, :prerequisites [], :prerequisite_count 0, :college :protection-and-warning, :ref "Magic: The Least of Spells p. 9"}
             {:name :prismatic-mist-area, :prerequisites [:mystic-mist :sand-jet], :prerequisite_count 0, :college :protection-and-warning, :ref "Classic: Technomancer p. 27"}
             {:name :protect-animal, :prerequisites [:armor :watchdog], :prerequisite_count 7, :college :protection-and-warning, :ref "Magic, p. 32"}
             {:name :reflect-gaze, :prerequisites [:mirror], :prerequisite_count 3, :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :resist-acid, :prerequisites [:create-acid], :prerequisite_count 8, :college :protection-and-warning, :ref "Magic p. 190"}
             {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :prerequisite_count 3, :college :protection-and-warning, :ref "Magic p. 90"}
             {:name :resist-lightning, :prerequisites [[6 :air]], :prerequisite_count 8, :college :protection-and-warning, :ref "Magic p. 196"}
             {:name :resist-poison, :prerequisites [:vigor], :prerequisite_count 3, :college :protection-and-warning, :ref "Magic p. 91"}
             {:name :resist-pressure, :prerequisites [:weather-dome], :prerequisite_count 9, :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :resist-radiation, :prerequisites [[3 :radiation]], :prerequisite_count 7, :college :protection-and-warning, :ref "Magic p. 182"}
             {:name :resist-sound, :prerequisites [[4 :sound]], :prerequisite_count 4, :college :protection-and-warning, :ref "Magic p. 173"}
             {:name :resist-water, :prerequisites [#{:umbrella :shape-water} :destroy-water], :prerequisite_count 2, :college :protection-and-warning, :ref "Magic p. 186"}
             {:name :return-missile, :prerequisites [:catch-missile], :prerequisite_count 3, :college :protection-and-warning, :ref "Magic p. 168"}
             {:name :reverse-missiles, :prerequisites [#{:missile-shield :force-dome}], :prerequisite_count 2, :college :protection-and-warning, :ref "Magic p. 168; Pyramid 3/60: Dungeon Fantasy III p. 5"}
             {:name :selective-hearing, :prerequisites [], :prerequisite_count 0, :college :protection-and-warning, :ref "Magic: The Least of Spells p. 15"}
             {:name :sense-danger, :prerequisites [#{:sense-foes :danger-sense}], :prerequisite_count 0, :college :protection-and-warning, :ref "Magic p. 166"}
             {:name :sense-observation, :prerequisites [#{:sense-danger :scryguard}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 167"}
             {:name :shade, :prerequisites [#{:continual-light :shield}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :shield, :prerequisites [[:skills/magery 2]], :prerequisite_count 0, :college :protection-and-warning, :ref "Basic Set, p. 252; Magic p. 167"}
             {:name :spoof-sensor, :prerequisites [:blind-sensor], :prerequisite_count 0, :college :protection-and-warning, :ref "Classic: Technomancer p. 27"}
             {:name :stinkguard, :prerequisites [], :prerequisite_count 0, :college :protection-and-warning, :ref "Magic: The Least of Spells p. 6"}
             {:name :storm-shelter, :prerequisites [], :prerequisite_count 0, :college :protection-and-warning, :ref "Magic: The Least of Spells p. 17"}
             {:name :teleport-shield, :prerequisites [:watchdog #{:spell-shield :teleport}], :prerequisite_count 7, :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :turn-blade, :prerequisites [#{:apportation :spasm}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 167"}
             {:name :umbrella, :prerequisites [#{:shape-water :shield}], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 185"}
             {:name :utter-dome, :prerequisites [[:skills/magery 2] :force-dome :spell-shield], :prerequisite_count 14, :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :utter-wall, :prerequisites [:utter-dome :spell-wall], :prerequisite_count 16, :college :protection-and-warning, :ref "Magic p. 170"}
             {:name :warmth, :prerequisites [:heat], :prerequisite_count 4, :college :protection-and-warning, :ref "Magic p. 74"}
             {:name :watchdog, :prerequisites [:sense-danger], :prerequisite_count 1, :college :protection-and-warning, :ref "Magic p. 167; Thaumatology: Urban Magics, p. 33"}
             {:name :weather-dome, :prerequisites [:2-from-each-of-4-elements], :prerequisite_count 8, :college :protection-and-warning, :ref "Magic p. 169"}
             {:name :alter-voice, :prerequisites [[4 :body] [4 :sound]], :prerequisite_count 8, :college :sound, :ref "Magic p. 41"}
             {:name :call, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic: The Least of Spells p. 6"}
             {:name :concussion, :prerequisites [:shape-air :thunderclap], :prerequisite_count 5, :college :sound, :ref "Magic p. 26"}
             {:name :converse, :prerequisites [[:attributes/magery 1] :garble :silence], :prerequisite_count 4, :college :sound, :ref "Magic p. 173"}
             {:name :delayed-message, :prerequisites [[:attributes/magery 1] :voices :sense-life], :prerequisite_count 3, :college :sound, :ref "Magic p. 173"}
             {:name :disrupt, :prerequisites [[:skills/magery 2] :concussion :sound-jet :secret-spell], :prerequisite_count 0, :college :sound, :ref "Magic Styles: Dungeon Magic p. 23"}
             {:name :echoes-of-the-past, :prerequisites [[:skills/magery 2] :history :voices], :prerequisite_count 7, :college :sound, :ref "Magic p. 107"}
             {:name :far-hearing, :prerequisites [[:attributes/magery 1] [4 :sound]], :prerequisite_count 4, :college :sound, :ref "Magic p. 173"}
             {:name :garble, :prerequisites [:voices], :prerequisite_count 2, :college :sound, :ref "Magic p. 172"}
             {:name :great-voice, :prerequisites [:voices :thunderclap], :prerequisite_count 3, :college :sound, :ref "Magic p. 173"}
             {:name :hush, :prerequisites [:silence], :prerequisite_count 2, :college :sound, :ref "Magic p. 172"}
             {:name :imitate-voice, :prerequisites [:voices], :prerequisite_count 2, :college :sound, :ref "Magic p. 172"}
             {:name :improved-concussion, :prerequisites [[:attributes/magery 4] [7 :sound] :concussion :great-voice], :prerequisite_count 7, :college :sound, :ref "Magic: Artillery Spells p. 25"}
             {:name :invisible-wizard-ear, :prerequisites [:wizard-ear :invisibility], :prerequisite_count 10, :college :sound, :ref "Magic p. 174"}
             {:name :ley-speech, :prerequisites [:seek-ley-line :voices], :prerequisite_count 0, :college :sound, :ref "Thaumatology: Urban Magics p. 19"}
             {:name :fatal-frequency, :prerequisites [[:attributes/magery 3] :concussion :sound-jet], :prerequisite_count 0, :college :sound, :ref "Magic: Death Spells p. 20"}
             {:name :keen-hearing, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic p. 133"}
             {:name :mage-stealth, :prerequisites [:hush], :prerequisite_count 3, :college :sound, :ref "Magic p. 172"}
             {:name :mer-speech, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic: The Least of Spells p. 17"}
             {:name :message, :prerequisites [:great-voice :seeker], :prerequisite_count 7, :college :sound, :ref "Magic p. 173"}
             {:name :musical-scribe, :prerequisites [:scribe], :prerequisite_count 5, :college :sound, :ref "Magic p. 174"}
             {:name :noise, :prerequisites [:wall-of-silence], :prerequisite_count 3, :college :sound, :ref "Magic p. 173"}
             {:name :perilous-pulsations, :prerequisites [[:attributes/magery 4] [7 :sound] :concussion :sound-jet], :prerequisite_count 7, :college :sound, :ref "Magic: Artillery Spells p. 24"}
             {:name :resist-sound, :prerequisites [[4 :sound]], :prerequisite_count 0, :college :sound, :ref "Magic p. 173"}
             {:name :scribe, :prerequisites [:voices :dancing-object #{:1-written-language-at-accented :better}], :prerequisite_count 4, :college :sound, :ref "Magic p. 174"}
             {:name :selective-hearing, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic: The Least of Spells p. 15"}
             {:name :silence, :prerequisites [:sound], :prerequisite_count 1, :college :sound, :ref "Magic p. 171; Fantasy p. 172"}
             {:name :silver-tongue, :prerequisites [:voices :emotion-control], :prerequisite_count 6, :college :sound, :ref "Magic p. 174"}
             {:name :sound, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic p. 171; Fantasy p. 172"}
             {:name :sound-jet, :prerequisites [:great-voice], :prerequisite_count 4, :college :sound, :ref "Magic p. 173"}
             {:name :sound-vision, :prerequisites [#{:keen-hearing :acute-hearing}], :prerequisite_count 0, :college :sound, :ref "Magic p. 171"}
             {:name :squeak, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic: The Least of Spells p. 15"}
             {:name :throw-voice, :prerequisites [], :prerequisite_count 0, :college :sound, :ref "Magic: The Least of Spells p. 16"}
             {:name :thunderclap, :prerequisites [:sound], :prerequisite_count 1, :college :sound, :ref "Magic p. 171"}
             {:name :voices, :prerequisites [:sound], :prerequisite_count 1, :college :sound, :ref "Magic p. 172"}
             {:name :volume-control, :prerequisites [:great-voice], :prerequisite_count 0, :college :sound, :ref "Classic: Technomancer p. 28"}
             {:name :wail-of-the-banshee, :prerequisites [[:attributes/magery 3] :any- [0 :sound] :message], :prerequisite_count 10, :college :sound, :ref "Magic: Death Spells p. 20"}
             {:name :wall-of-silence, :prerequisites [:silence], :prerequisite_count 2, :college :sound, :ref "Magic p. 172"}
             {:name :withering-wail, :prerequisites [[:attributes/magery 4] [10 :sound] :great-voice :noise], :prerequisite_count 10, :college :sound, :ref "Magic: Artillery Spells p. 25"}
             {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :prerequisite_count 6, :college :sound, :ref "Magic p. 174"}
             {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :prerequisite_count 7, :college :sound, :ref "Magic p. 104"}
             {:name :animate-machine, :prerequisites [:machine-control #{:animation :animate-object}], :prerequisite_count 15, :college :technological, :ref "Magic p. 177"}
             {:name :awaken-building, :prerequisites [], :prerequisite_count 8, :college :technological, :ref "Thaumatology: Urban Magics, p. 33"}
             {:name :awaken-computer, :prerequisites [:animation :wisdom], :prerequisite_count 10, :college :technological, :ref "Magic p. 178"}
             {:name :blind-sensor, :prerequisites [:glitch :seek-emitter], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 27"}
             {:name :confound-firearm, :prerequisites [:glitch], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 34"}
             {:name :create-mana-co-processor, :prerequisites [:awaken-computer :enchant], :prerequisite_count 0, :college :technological, :ref "Classic: Magic Items 3 p 30"}
             {:name :delete-commercials, :prerequisites [[:world/tl 7]], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p 18"}
             {:name :essential-paper, :prerequisites [], :prerequisite_count 0, :college :technological, :ref "Pyramid 3/48: Secret Magic, p. 21"}
             {:name :glitch, :prerequisites [:machine-control], :prerequisite_count 12, :college :technological, :ref "Magic p. 178"}
             {:name :guide-missile, :prerequisites [:machine-control :any-'seek'-spell], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 34"}
             {:name :ley-vehicle, :prerequisites [:ley-float :ley-running], :prerequisite_count 0, :college :technological, :ref "Thaumatology: Urban Magics, p. 19"}
             {:name :machine-control, :prerequisites [:reveal-function :locksmith :lightning], :prerequisite_count 11, :college :technological, :ref "Magic p. 176"}
             {:name :machine-possession, :prerequisites [:machine-control #{:rider-within :soul-rider}], :prerequisite_count 16, :college :technological, :ref "Magic p. 178"}
             {:name :machine-speech, :prerequisites [:machine-summoning], :prerequisite_count 13, :college :technological, :ref "Magic p. 176"}
             {:name :machine-summoning, :prerequisites [:machine-control], :prerequisite_count 12, :college :technological, :ref "Magic, p. 176"}
             {:name :mad-machine, :prerequisites [:machine-control #{:animation :summon-demon}], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 35"}
             {:name :malfunction, :prerequisites [[:skills/magery 2] :glitch], :prerequisite_count 13, :college :technological, :ref "Magic p. 177"}
             {:name :magnetic-finger, :prerequisites [], :prerequisite_count 0, :college :technological, :ref "Magic: The Least of Spells p. 16"}
             {:name :manipulate-dna, :prerequisites [:sequence-dna :apportation :or-create-chimera], :prerequisite_count 4, :college :technological, :ref "Bio-Tech, p. 32"}
             {:name :permanent-machine-possession, :prerequisites [[:attributes/magery 3] :machine-possession], :prerequisite_count 17, :college :technological, :ref "Magic p. 178"}
             {:name :program, :prerequisites [:machine-speech--17+ :or-machine-control], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 33"}
             {:name :purify-signal, :prerequisites [:purify-air :tl6+], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 17"}
             {:name :rebuild, :prerequisites [[:attributes/magery 3] :repair :create-object [:3-of-each-element]], :prerequisite_count 22, :college :technological, :ref "Magic p. 177"}
             {:name :reckless-reconstitution, :prerequisites [:rebuild], :prerequisite_count 23, :college :technological, :ref "Magic: Death Spells, p. 21"}
             {:name :remote-start, :prerequisites [], :prerequisite_count 0, :college :technological, :ref "Magic: The Least of Spells p. 16"}
             {:name :reveal-function, :prerequisites [:seek-machine], :prerequisite_count 1, :college :technological, :ref "Magic p. 176"}
             {:name :schematic, :prerequisites [:reveal-function :history], :prerequisite_count 7, :college :technological, :ref "Magic p. 177"}
             {:name :seek-machine, :prerequisites [], :prerequisite_count 0, :college :technological, :ref "Magic p. 175"}
             {:name :sense-nano, :prerequisites [:sense-disease [:attributes/int 15] :or-seek-machine :small-vision], :prerequisite_count 2, :college :technological, :ref "Bio-Tech, p. 32"}
             {:name :sequence-dna, :prerequisites [[:skills/magery 2] :divination :analyze-heredity], :prerequisite_count 2, :college :technological, :ref "Bio-Tech, p. 32"}
             {:name :spoof-sensor, :prerequisites [:blind-sensor], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 27"}
             {:name :televisomancy, :prerequisites [#{[:6 :technological] [:skills/electronics-operation_communications 15]}], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p 23"}
             {:name :upgrade-computer, :prerequisites [:inscribe :repair #{:schematic [:skills/electronics_computers 15]}], :prerequisite_count 0, :college :technological, :ref "Classic: Technomancer p. 35"}
             {:name :wizardly-workshop, :prerequisites [], :prerequisite_count 0, :college :technological, :ref "Magic: The Least of Spells p. 12"}
             {:name :acid-ball, :prerequisites [[:skills/magery 2] :create-acid], :prerequisite_count 8, :college :water, :ref "Magic p. 191"}
             {:name :acid-jet, :prerequisites [[:skills/magery 2] :water-jet :create-acid], :prerequisite_count 10, :college :water, :ref "Magic p. 192"}
             {:name :arctic-blast, :prerequisites [[:attributes/magery 4] :frostbite :icy-breath], :prerequisite_count 0, :college :water, :ref "Magic: Artillery Spells p. 27"}
             {:name :alkahest-jet, :prerequisites [[:attributes/magery 4] :essential-acid :acid-jet], :prerequisite_count 0, :college :water, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :alkahest-sphere, :prerequisites [[:attributes/magery 4] :essential-acid :acid-ball], :prerequisite_count 0, :college :water, :ref "Pyramid 3/25: Epic Magic, p. 18"}
             {:name :boil-water, :prerequisites [:shape-water :heat], :prerequisite_count 8, :college :water, :ref "Magic p. 192"}
             {:name :breathe-air, :prerequisites [:create-water :destroy-air], :prerequisite_count 6, :college :water, :ref "Magic p. 26"}
             {:name :breathe-steam, :prerequisites [[:attributes/magery 1] :steam-jet :resist-fire], :prerequisite_count 14, :college :water, :ref "Magic p. 192"}
             {:name :breathe-water, :prerequisites [:create-air :destroy-water], :prerequisite_count 6, :college :water, :ref "Basic Set, p. 243; Magic p. 189"}
             {:name :body-of-ice, :prerequisites [[:skills/magery 2] :body-of-water :freeze], :prerequisite_count 6, :college :water, :ref "Magic p. 189"}
             {:name :body-of-water, :prerequisites [:shape-water], :prerequisite_count 4, :college :water, :ref "Magic p. 185"}
             {:name :boil-water, :prerequisites [:shape-water :heat], :prerequisite_count 8, :college :water, :ref "Magic p. 189"}
             {:name :cloud, :prerequisites [], :prerequisite_count 0, :college :water, :ref "Magic: The Least of Spells p. 17"}
             {:name :condense-steam, :prerequisites [#{:cold :boil-water}], :prerequisite_count 5, :college :water, :ref "Magic p. 189"}
             {:name :cone-of-corrosion, :prerequisites [[:attributes/magery 4] :acid-jet], :prerequisite_count 11, :college :water, :ref "Magic: Artillery Spells p. 27"}
             {:name :control-water-elemental, :prerequisites [:summon-water-elemental], :prerequisite_count 9, :college :water, :ref "Magic p. 28"}
             {:name :coolness, :prerequisites [:cold], :prerequisite_count 5, :college :water, :ref "Magic p. 187"}
             {:name :create-acid, :prerequisites [:create-water :create-earth], :prerequisite_count 7, :college :water, :ref "Magic p. 190; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-ice, :prerequisites [:freeze], :prerequisite_count 5, :college :water, :ref "Magic p. 188; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-spring, :prerequisites [:dry-spring :shape-water], :prerequisite_count 8, :college :water, :ref "Magic p. 190"}
             {:name :create-steam, :prerequisites [:boil-water], :prerequisite_count 9, :college :water, :ref "Magic p. 190"}
             {:name :create-water, :prerequisites [:purify-water], :prerequisite_count 0, :college :water, :ref "Basic Set, p. 253; Magic p. 184; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :create-water-elemental, :prerequisites [[:skills/magery 2] :control-water-elemental], :prerequisite_count 0, :college :water, :ref "Magic p. 22"}
             {:name :current, :prerequisites [[6 :water]], :prerequisite_count 6, :college :water, :ref "Magic p. 194"}
             {:name :dehydrate, :prerequisites [[5 :water] :destroy-water], :prerequisite_count 5, :college :water, :ref "Magic p. 188"}
             {:name :destroy-water, :prerequisites [:create-water], :prerequisite_count 3, :college :water, :ref "Basic Set, p. 253; Magic p. 185"}
             {:name :dissipate, :prerequisites [#{[[:attributes/magery 3] #{:body-of-water :earth-to-water :flesh-to-ice} :melt-ice] [[:attributes/magery 3] :body-of-fluid :earth-to-fluid]}] :prerequisite_count 0, :college :water, :ref "Magic: Death Spells, p. 21 and Magical Styles: Dungeon Magic, p.8"}
             {:name :distill, :prerequisites [:mature :destroy-water], :prerequisite_count 7, :college :water, :ref "[1]"}
             {:name :drown, :prerequisites [[:attributes/magery 3] :breathe-air :breathe-water], :prerequisite_count 0, :college :water, :ref "Magic: Death Spells, p. 21"}
             {:name :dry-spring, :prerequisites [:destroy-water :shape-earth], :prerequisite_count 6, :college :water, :ref "Magic p. 188"}
             {:name :earth-to-water, :prerequisites [[:attributes/magery 1] :create-water :shape-earth], :prerequisite_count 5, :college :water, :ref "Magic p. 52"}
             {:name :elemental-plumbing, :prerequisites [:control-water-elemental], :prerequisite_count 0, :college :water, :ref "Classic: Technomancer p. 38"}
             {:name :essential-acid, :prerequisites [[:attributes/magery 3] :all [6 :acid]], :prerequisite_count 13, :college :water, :ref "Magic p. 192; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :essential-water, :prerequisites [[6 :water]], :prerequisite_count 6, :college :water, :ref "Magic p. 189; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
             {:name :flow, :prerequisites [:body-of-fluid], :prerequisite_count 0, :college :water, :ref "Magical Styles: Dungeon Magic, p.9"}
             {:name :flesh-to-ice, :prerequisites [[:attributes/magery 1] :frostbite :body-of-water], :prerequisite_count 8, :college :water, :ref "Magic p. 190"}
             {:name :fog, :prerequisites [:shape-water], :prerequisite_count 4, :college :water, :ref "Basic Set, p. 253; Magic p. 193"}
             {:name :foul-water, :prerequisites [:purify-water :decay], :prerequisite_count 4, :college :water, :ref "Magic p. 185"}
             {:name :freeze, :prerequisites [:shape-water], :prerequisite_count 4, :college :water, :ref "Magic p. 185"}
             {:name :frost, :prerequisites [#{:create-water :cold}], :prerequisite_count 3, :college :water, :ref "Magic p. 193"}
             {:name :frostbite, :prerequisites [:frost :freeze], :prerequisite_count 6, :college :water, :ref "Magic p. 189"}
             {:name :geyser, :prerequisites [[6 :water] :create-spring #{[4 :earth] [4 :fire]}], :prerequisite_count 9, :college :water, :ref "Magic p. 190"}
             {:name :hail, :prerequisites [:snow], :prerequisite_count 8, :college :water, :ref "Magic p. 195"}
             {:name :ice-dagger, :prerequisites [#{:ice-sphere :water-jet}], :prerequisite_count 5, :college :water, :ref "Magic p. 188"}
             {:name :ice-slick, :prerequisites [:frost], :prerequisite_count 4, :college :water, :ref "Magic p. 186"}
             {:name :ice-sphere, :prerequisites [:shape-water], :prerequisite_count 4, :college :water, :ref "Magic p. 186"}
             {:name :ice-vision, :prerequisites [:shape-water], :prerequisite_count 0, :college :water, :ref "Classic: Magic p. 37"}
             {:name :icy-breath, :prerequisites [[:attributes/magery 1] :snow-jet :resist-cold], :prerequisite_count 12, :college :water, :ref "Magic p. 192"}
             {:name :ice-storm, :prerequisites [[:attributes/magery 4] :hail :storm], :prerequisite_count 0, :college :water, :ref "Magic: Artillery Spells p. 29"}
             {:name :icy-missile, :prerequisites [:icy-weapon], :prerequisite_count 4, :college :water, :ref "Magic p. 186"}
             {:name :icy-touch, :prerequisites [[:attributes/magery 1] [5 :water]], :prerequisite_count 4, :college :water, :ref "Magic p. 188"}
             {:name :icy-weapon, :prerequisites [:create-water], :prerequisite_count 3, :college :water, :ref "Basic Set, p. 253; Magic p. 185"}
             {:name :infiltrate, :prerequisites [:body-of-fluid], :prerequisite_count 0, :college :water, :ref "Magical Styles: Dungeon Magic, p. 9"}
             {:name :mass-coolness, :prerequisites [[:attributes/int 12] :coolness], :prerequisite_count 0, :college :water, :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}])

(defn kebab-case [s]
  (when s
    (-> s
        str
        (clojure.string/replace #"([a-z])([A-Z])" "$1-$2")
        (clojure.string/replace #"([A-Z]+)([A-Z][a-z])" "$1-$2")
        clojure.string/lower-case
        (clojure.string/replace #"\s+" "-")
        (clojure.string/replace #"[-]+$" ""))))

(def spells-by-college
  {:fire '(:balor's-eye-fire :blast-ball :body-of-flames :breathe-fire :burning-death :burning-touch :cold :control-fire-elemental :control-lava-lizard :create-fire :create-fire-elemental :cremate :deflect-energy :detonate :ember :essential-flame :explosive-fireball :explosive-hellfire-orb :extinguish-fire :fast-fire :fire-cloud :fire-swarm :fireball :fireproof :flame-jet :flameturning :flaming-armor :flaming-missiles :flaming-weapon :great-deflect-energy :heat :hellfire-breath :hellfire-jet :hellfire-orb :hellfire-rain :high-explosive-fireball :ignite-fire :improved-explosive-fireball :mass-detonate :mass-resist-fire :oven-mitts :phantom-flame :puff :rain-of-fire :resist-cold :resist-fire :shaped-charge-fireball :self-destruct :seek-fire :shape-fire :slow-fire :smoke :snuff-life's-flame :summon-fire-elemental :summon-lava-lizard :towering-inferno :warmth :balor's-eye-fire :blast-ball :body-of-flames :breathe-fire :burning-death :burning-touch :cold :control-fire-elemental :control-lava-lizard :create-fire :create-fire-elemental :cremate :deflect-energy :detonate :ember :essential-flame :explosive-fireball :explosive-hellfire-orb :extinguish-fire :fast-fire :fire-cloud :fire-swarm :fireball :fireproof :flame-jet :flameturning :flaming-armor :flaming-missiles :flaming-weapon :great-deflect-energy :heat :hellfire-breath :hellfire-jet :hellfire-orb :hellfire-rain :high-explosive-fireball :ignite-fire :improved-explosive-fireball :mass-detonate :mass-resist-fire :oven-mitts :phantom-flame :puff :rain-of-fire :resist-cold :resist-fire :shaped-charge-fireball :self-destruct :seek-fire :shape-fire :slow-fire :smoke :snuff-life's-flame :summon-fire-elemental :summon-lava-lizard :towering-inferno :warmth :balor's-eye-fire :blast-ball :body-of-flames :breathe-fire :burning-death :burning-touch :cold :control-fire-elemental :control-lava-lizard :create-fire :create-fire-elemental :cremate :deflect-energy :detonate :ember :essential-flame :explosive-fireball :explosive-hellfire-orb :extinguish-fire :fast-fire :fire-cloud :fire-swarm :fireball :fireproof :flame-jet :flameturning :flaming-armor :flaming-missiles :flaming-weapon :great-deflect-energy :heat :hellfire-breath :hellfire-jet :hellfire-orb :hellfire-rain :high-explosive-fireball :ignite-fire :improved-explosive-fireball :mass-detonate :mass-resist-fire :oven-mitts :phantom-flame :puff :rain-of-fire :resist-cold :resist-fire :shaped-charge-fireball :self-destruct :seek-fire :shape-fire :slow-fire :smoke :snuff-life's-flame :summon-fire-elemental :summon-lava-lizard :towering-inferno :warmth)
   :necromantic '(:affect-spirits :age :animate-shadow :animation :astral-block :astral-vision :awaken-craft-spirit :banish :bind-spirit :burning-death :command-spirit :control-zombie :death-vision :dramatic-departure :entrap-spirit :evisceration :final-rest :grasping-doom :hellspawn :invoke :lich :mass-zombie :materialize :pestilence :plant-zombie :punishment-circle :repel-spirits :resurrection :reverie-of-ruin :rotting-death :self-destruct :sense-spirit :skull-spirit :slow-healing :solidify :soul-jar :soul-prison)
   :movement '(:air-vortex :apportation :beacon :blink :blink-other :cloud-vaulting :cloud-walking :collision :crushing-fist :cushion :dancing-object :deflect-missile :disruption :distant-blow :divert-teleport :ethereal-body :flee :flight :flying-carpet :force-ball :freedom :glue :grease :great-deflect-missile :great-haste :hail-of-lead :haste :hawk-flight :hinder :hold-fast :homing-missile :increase-burden :jump :levitation :ley-float :ley-running :ley-vehicle :light-tread :lighten-burden :lockmaster :locksmith :long-march :magic-bullet :manipulate :open-door :quarter :quick-march :poltergeist :pull :rapid-journey :reduce-recoil :remove-fetus :repel :reorient :sink :slasher :slide :slow :slow-fall :steady-hand :swim :transfer-pregnancy :teleport :teleport-other :trace-teleport :undo :wallwalker :winged-knife :wizard-hand)
   :sound '(:alter-voice :call :concussion :converse :delayed-message :disrupt :echoes-of-the-past :far-hearing :garble :great-voice :hush :imitate-voice :improved-concussion :invisible-wizard-ear :ley-speech :fatal-frequency :keen-hearing :mage-stealth :mer-speech :message :musical-scribe :noise :perilous-pulsations :resist-sound :scribe :selective-hearing :silence :silver-tongue :sound :sound-jet :sound-vision :squeak :throw-voice :thunderclap :voices :volume-control :wail-of-the-banshee :wall-of-silence :withering-wail :wizard-ear :wizard-mouth)
   :knowledge '(:air-vision :alarm :analyze-magic :analyze-heredity :ancient-history :astral-vision :aura :detect-magic :divination :earth-vision :echoes-of-the-past :far-feeling :far-hearing :far-tasting :find-direction :forbidden-wisdom :glass-wall :history :identify-loot :identify-spell :images-of-the-past :invisible-wizard-eye :keyfinder :know-location :know-recipe :know-thyself :know-true-shape :mage-sense :mage-sight :measurement :memorize :metal-vision :mind-over-matter :necrovision :pathfinder :plant-vision :plastic-vision :prehistory :projection :recall :reconstruct-spell :remember-path :retro-reading :scents-of-the-past :schematic :see-secrets :seek-ley-line :seek-magic :seek-navy :seek-number :seeker :sense-mana :small-vision :summon-shade :sweet-oblivion :televisomancy :tell-position :tell-time :test :test-load :thaumatomancy :trace :vision-of-doom :water-vision :wizard-ear :wizard-eye :wizard-hand :wizard-mouth :wizard-nose :air-vision :alarm :analyze-magic :analyze-heredity :ancient-history :astral-vision :aura :detect-magic :divination :earth-vision :echoes-of-the-past :far-feeling :far-hearing :far-tasting :find-direction :forbidden-wisdom :glass-wall :history :identify-loot :identify-spell :images-of-the-past :invisible-wizard-eye :keyfinder :know-location :know-recipe :know-thyself :know-true-shape :mage-sense :mage-sight :measurement :memorize :metal-vision :mind-over-matter :necrovision :pathfinder :plant-vision :plastic-vision :prehistory :projection :recall :reconstruct-spell :remember-path :retro-reading :scents-of-the-past :schematic :see-secrets :seek-ley-line :seek-magic :seek-navy :seek-number :seeker :sense-mana :small-vision :summon-shade :sweet-oblivion :televisomancy :tell-position :tell-time :test :test-load :thaumatomancy :trace :vision-of-doom :water-vision :wizard-ear :wizard-eye :wizard-hand :wizard-mouth :wizard-nose)
   :meta '(:bless :catch-spell :charge-powerstone :conceal-magic :counterspell :curse :dispel-magic :dispel-spark :displace-spell :drain-magery :drain-mana :dread-curse :end-scene :false-aura :great-ward :hang-spell :internalize-elixir :lend-spell :ley-buffer :ley-line-creation :ley-supply :magic-resistance :mana-storm :mana-vortex :maintain-spell :penetrating-spell :pentagram :preemptive-experience :punishment-circle :raise-cone-of-power :reflect :remove-aura :remove-curse :restore-mana :scryfool :scryguard :scrywall :seek-magic :self-destruct :sovereign-countermagic :sovereign-ward :spell-shield :spell-wall :spellguard :steal-spell :suspend-curse :suspend-magery :suspend-magic :suspend-mana :suspend-spell :telecast :thaumatomancy :throw-spell :use-item :void-bolt :ward :bless :catch-spell :charge-powerstone :conceal-magic :counterspell :curse :dispel-magic :dispel-spark :displace-spell :drain-magery :drain-mana :dread-curse :end-scene :false-aura :great-ward :hang-spell :internalize-elixir :lend-spell :ley-buffer :ley-line-creation :ley-supply :magic-resistance :mana-storm :mana-vortex :maintain-spell :penetrating-spell :pentagram :preemptive-experience :punishment-circle :raise-cone-of-power :reflect :remove-aura :remove-curse :restore-mana :scryfool :scryguard :scrywall :seek-magic :self-destruct :sovereign-countermagic :sovereign-ward :spell-shield :spell-wall :spellguard :steal-spell :suspend-curse :suspend-magery :suspend-magic :suspend-mana :suspend-spell :telecast :thaumatomancy :throw-spell :use-item :void-bolt :ward)
   :air '(:air-jet :air-vision :air-vortex :atmosphere-dome :ball-of-lightning :body-of-air :body-of-lightning :body-of-wind :breathe-air :breathe-water :chain-lightning :cloud :cloud-of-doom :clouds :concussion :cool :control-air-elemental :create-air :create-air-elemental :destroy-air :devitalize-air :diver's-blessing :earth-to-air :electric-armor :electric-missiles :electric-weapon :embolism :essential-air :explosive-lightning :falling-sky :improved-concussion :improved-explosive-lightning :jolt :lightning :lightning-armor :lightning-missiles :lightning-stare :lightning-weapon :lightning-whip :mighty-breath :mass-resist-lightning :no-smell :odor :phlogiston-arc :phlogiston-detonation :phlogiston-discharge :phlogiston-sphere :phlogiston-stare :phlogiston-touch :predict-weather :purify-air :purify-signal :rain :resist-lightning :safe-boarding :sandstorm :seek-air :seek-emitter :shape-air :shocking-touch :snow :spark-cloud :spark-storm :static-charge :steal-breath :stench :stinkguard :storm :storm-shelter :stroke-of-lightning :summon-air-elemental :twisting-terror :walk-on-air :wall-of-lightning :wall-of-wind :warm :wind :windstorm :air-jet :air-vision :air-vortex :atmosphere-dome :ball-of-lightning :body-of-air :body-of-lightning :body-of-wind :breathe-air :breathe-water :chain-lightning :cloud :cloud-of-doom :clouds :concussion :cool :control-air-elemental :create-air :create-air-elemental :destroy-air :devitalize-air :diver's-blessing :earth-to-air :electric-armor :electric-missiles :electric-weapon :embolism :essential-air :explosive-lightning :falling-sky :improved-concussion :improved-explosive-lightning :jolt :lightning :lightning-armor :lightning-missiles :lightning-stare :lightning-weapon :lightning-whip :mighty-breath :mass-resist-lightning :no-smell :odor :phlogiston-arc :phlogiston-detonation :phlogiston-discharge :phlogiston-sphere :phlogiston-stare :phlogiston-touch :predict-weather :purify-air :purify-signal :rain :resist-lightning :safe-boarding :sandstorm :seek-air :seek-emitter :shape-air :shocking-touch :snow :spark-cloud :spark-storm :static-charge :steal-breath :stench :stinkguard :storm :storm-shelter :stroke-of-lightning :summon-air-elemental :twisting-terror :walk-on-air :wall-of-lightning :wall-of-wind :warm :wind :windstorm :air-jet :air-vision :air-vortex :atmosphere-dome :ball-of-lightning :body-of-air :body-of-lightning :body-of-wind :breathe-air :breathe-water :chain-lightning :cloud :cloud-of-doom :clouds :concussion :cool :control-air-elemental :create-air :create-air-elemental :destroy-air :devitalize-air :diver's-blessing :earth-to-air :electric-armor :electric-missiles :electric-weapon :embolism :essential-air :explosive-lightning :falling-sky :improved-concussion :improved-explosive-lightning :jolt :lightning :lightning-armor :lightning-missiles :lightning-stare :lightning-weapon :lightning-whip :mighty-breath :mass-resist-lightning :no-smell :odor :phlogiston-arc :phlogiston-detonation :phlogiston-discharge :phlogiston-sphere :phlogiston-stare :phlogiston-touch :predict-weather :purify-air :purify-signal :rain :resist-lightning :safe-boarding :sandstorm :seek-air :seek-emitter :shape-air :shocking-touch :snow :spark-cloud :spark-storm :static-charge :steal-breath :stench :stinkguard :storm :storm-shelter :stroke-of-lightning :summon-air-elemental :twisting-terror :walk-on-air :wall-of-lightning :wall-of-wind :warm :wind :windstorm)
   :enchantment '(:adjustable-clothing :amulet :compulsive-reader :costume :create-chimera :curse-virus :doom-wish :doppelganger :dwarfish-reinforcement :electric-power :emergency-staff :enchant :ensorcel :golem :great-wish :hex :hideaway :impart-skill :impression-blocker :leak :lesser-wish :ley-line-creation :live-libram :malefice :magician's-minion :mana-warhead :mortal-malefice :narrative-conveyance :power :remove-enchantment :resilient-golem :resist-enchantment :scroll :simulacrum :sorcerer's-stand-in :soul-golem :speed :spell-stone :spellbook-enchantment :spellgraft :spellprocessor :suspend-enchantment :talisman :temporary-enchantment :vengeful-staff :wish :adjustable-clothing :amulet :compulsive-reader :costume :create-chimera :curse-virus :doom-wish :doppelganger :dwarfish-reinforcement :electric-power :emergency-staff :enchant :ensorcel :golem :great-wish :hex :hideaway :impart-skill :impression-blocker :leak :lesser-wish :ley-line-creation :live-libram :malefice :magician's-minion :mana-warhead :mortal-malefice :narrative-conveyance :power :remove-enchantment :resilient-golem :resist-enchantment :scroll :simulacrum :sorcerer's-stand-in :soul-golem :speed :spell-stone :spellbook-enchantment :spellgraft :spellprocessor :suspend-enchantment :talisman :temporary-enchantment :vengeful-staff :wish :adjustable-clothing :amulet :compulsive-reader :costume :create-chimera :curse-virus :doom-wish :doppelganger :dwarfish-reinforcement :electric-power :emergency-staff :enchant :ensorcel :golem :great-wish :hex :hideaway :impart-skill :impression-blocker :leak :lesser-wish :ley-line-creation :live-libram :malefice :magician's-minion :mana-warhead :mortal-malefice :narrative-conveyance :power :remove-enchantment :resilient-golem :resist-enchantment :scroll :simulacrum :sorcerer's-stand-in :soul-golem :speed :spell-stone :spellbook-enchantment :spellgraft :spellprocessor :suspend-enchantment :talisman :temporary-enchantment :vengeful-staff :wish)
   :healing '(:aid :aide :analgesic :archmagi's-recuperation :awaken :bender-defender :birth-control :body-reading :cleansing :cure-addiction :cure-dehydration :cure-disease :cure-insanity :cure-radiation :cure-starvation :detect-poison :disinfect :ease-labor :euthanize :final-rest :great-healing :halt-aging :healing-slumber :instant-neutralize-poison :instant-regeneration :instant-restoration :lend-energy :lend-vitality :major-healing :mass-resist-disease :mass-resist-poison :minor-healing :neutralize-poison :recover-energy :regeneration :relieve-addiction :relieve-madness :relieve-paralysis :relieve-sickness :remove-contagion :remove-fetus :resist-disease :resist-poison :restoration :restore-hearing :restore-memory :restore-sight :restore-speech :resurrection :resuscitate :sea-legs :sense-disease :share-energy :share-vitality :stop-bleeding :stop-paralysis :stop-spasm :suspended-animation :test :transfer-pregnancy :transference-bolt :youth :aid :aide :analgesic :archmagi's-recuperation :awaken :bender-defender :birth-control :body-reading :cleansing :cure-addiction :cure-dehydration :cure-disease :cure-insanity :cure-radiation :cure-starvation :detect-poison :disinfect :ease-labor :euthanize :final-rest :great-healing :halt-aging :healing-slumber :instant-neutralize-poison :instant-regeneration :instant-restoration :lend-energy :lend-vitality :major-healing :mass-resist-disease :mass-resist-poison :minor-healing :neutralize-poison :recover-energy :regeneration :relieve-addiction :relieve-madness :relieve-paralysis :relieve-sickness :remove-contagion :remove-fetus :resist-disease :resist-poison :restoration :restore-hearing :restore-memory :restore-sight :restore-speech :resurrection :resuscitate :sea-legs :sense-disease :share-energy :share-vitality :stop-bleeding :stop-paralysis :stop-spasm :suspended-animation :test :transfer-pregnancy :transference-bolt :youth)
   :light-and-darkness '(:blackout :blur :body-of-shadow :bright-vision :cleansing-light :coherent-light-jet :colors :continual-light :continual-mage-light :continual-sunlight :dark-vision :darkness :disruption-bolt :flash :gloom :glow :goggles :hawk-vision :hide :images-of-the-past :infrared-flash :infravision :invisibility :invisible-sunbolt :light :light-jet :mage-light :mass-invisibility :mass-shade :mirror :night-vision :phosphorescence :remove-reflection :remove-shadow :see-invisible :shadowplay :shadow-slay :shade :shape-darkness :shape-light :small-vision :sunbolt :sunburst :sunlight :twinkle :wall-of-light :blackout :blur :body-of-shadow :bright-vision :cleansing-light :coherent-light-jet :colors :continual-light :continual-mage-light :continual-sunlight :dark-vision :darkness :disruption-bolt :flash :gloom :glow :goggles :hawk-vision :hide :images-of-the-past :infrared-flash :infravision :invisibility :invisible-sunbolt :light :light-jet :mage-light :mass-invisibility :mass-shade :mirror :night-vision :phosphorescence :remove-reflection :remove-shadow :see-invisible :shadowplay :shadow-slay :shade :shape-darkness :shape-light :small-vision :sunbolt :sunburst :sunlight :twinkle :wall-of-light)
   :communication-and-empathy '(:absorb-book :accursed-triangle :ack :bedtime-reading :borrow-language :borrow-number :borrow-skill :broadcast-spell :communication :compel-lie :compel-truth :compel-written-truth :control-person :delete-commercials :dispel-possession :drama :dream-projection :dream-sending :dream-viewing :exchange-bodies :gift-of-letters :gift-of-tongues :hide-emotion :hide-thoughts :identify-caller :illuminated-writing :insignificance :lend-language :lend-skill :machine-speech :magic-switchboard :message :mer-speech :mind-reading :mind-search :mind-sending :mind-whip :permanent-possession :persuasion :possession :presence :retrogression :seek-number :sense-emotion :sense-foes :sense-life :sorcerous-signal :soul-rider :speed-data :switch-bodies :telepathic-overload :telepathy :truthsayer :vexation :wrong-number :absorb-book :accursed-triangle :ack :bedtime-reading :borrow-language :borrow-number :borrow-skill :broadcast-spell :communication :compel-lie :compel-truth :compel-written-truth :control-person :delete-commercia :dispel-possession :drama :dream-projection :dream-sending :dream-viewing :exchange-bodies :gift-of-letters :gift-of-tongues :hide-emotion :hide-thoughts :identify-caller :illuminated-writing :insignificance :lend-language :lend-skill :machine-speech :magic-switchboard :message :mer-speech :mind-reading :mind-search :mind-sending :mind-whip :permanent-possession :persuasion :possession :presence :retrogression :seek-number :sense-emotion :sense-foes :sense-life :sorcerous-signal :soul-rider :speed-data :switch-bodies :telepathic-overload :telepathy :truthsayer :vexation :wrong-number :absorb-book :accursed-triangle :ack :bedtime-reading :borrow-language :borrow-number :borrow-skill :broadcast-spell :communication :compel-lie :compel-truth :compel-written-truth :control-person :delete-commercia :dispel-possession :drama :dream-projection :dream-sending :dream-viewing :exchange-bodies :gift-of-letters :gift-of-tongues :hide-emotion :hide-thoughts :identify-caller :illuminated-writing :insignificance :lend-language :lend-skill :machine-speech :magic-switchboard :message :mer-speech :mind-reading :mind-search :mind-sending :mind-whip :permanent-possession :persuasion :possession :presence :retrogression :seek-number :sense-emotion :sense-foes :sense-life :sorcerous-signal :soul-rider :speed-data :switch-bodies :telepathic-overload :telepathy :truthsayer :vexation :wrong-number)
   :earth '(:adamant-hail :adamant-missile :alter-terrain :badger-paws :body-of-stone :boulder-barrage :control-earth-elemental :control-lava-lizard :create-earth :create-earth-elemental :dust-to-dust :earth-to-air :earth-to-stone :earth-to-water :earth-vision :earthquake :entombment :essential-earth :flesh-to-adamant :flesh-to-stone :gargoyle-skin :heart-of-stone :move-terrain :mud-jet :orichalcum-edge :orichalcum-missiles :partial-petrification :pebble :predict-earth-movement :purify-earth :rain-of-stones :sand-blast :sand-jet :sandstorm :seek-earth :seek-pass :seismic-shock :shape-earth :shape-stone :spotless-hands :steelwraith :stone-missile :stone-to-earth :stone-to-flesh :summon-earth-elemental :summon-lava-lizard :volcano :walk-through-earth :adamant-hail :adamant-missile :alter-terrain :badger-paws :body-of-stone :boulder-barrage :control-earth-elemental :control-lava-lizard :create-earth :create-earth-elemental :dust-to-dust :earth-to-air :earth-to-stone :earth-to-water :earth-vision :earthquake :entombment :essential-earth :flesh-to-adamant :flesh-to-stone :gargoyle-skin :heart-of-stone :move-terrain :mud-jet :orichalcum-edge :orichalcum-missiles :partial-petrification :pebble :predict-earth-movement :purify-earth :rain-of-stones :sand-blast :sand-jet :sandstorm :seek-earth :seek-pass :seismic-shock :shape-earth :shape-stone :spotless-hands :steelwraith :stone-missile :stone-to-earth :stone-to-flesh :summon-earth-elemental :summon-lava-lizard :volcano :walk-through-earth :adamant-hail :adamant-missile :alter-terrain :badger-paws :body-of-stone :boulder-barrage :control-earth-elemental :control-lava-lizard :create-earth :create-earth-elemental :dust-to-dust :earth-to-air :earth-to-stone :earth-to-water :earth-vision :earthquake :entombment :essential-earth :flesh-to-adamant :flesh-to-stone :gargoyle-skin :heart-of-stone :move-terrain :mud-jet :orichalcum-edge :orichalcum-missiles :partial-petrification :pebble :predict-earth-movement :purify-earth :rain-of-stones :sand-blast :sand-jet :sandstorm :seek-earth :seek-pass :seismic-shock :shape-earth :shape-stone :spotless-hands :steelwraith :stone-missile :stone-to-earth :stone-to-flesh :summon-earth-elemental :summon-lava-lizard :volcano :walk-through-earth)
   :gate '(:accelerate-time :beacon :blink :blink-other :control-gate :create-door :create-gate :dimensional-dissection :divert-teleport :easy-rider :hell-zone :hide-object :invoke :null-sphere :phase :phase-other :planar-summons :planar-visit :plane-shift :plane-shift-other :rapid-journey :reorient :sanctuary :scry-gate :seek-gate :slow-time :splat :suspend-time :teleport :teleport-other :teleport-shield :time-out :timeport :timeport-other :timeslip :timeslip-other :trace-teleport :underworld-imprisonment :accelerate-time :beacon :blink :blink-other :control-gate :create-door :create-gate :dimensional-dissection :divert-teleport :easy-rider :hell-zone :hide-object :invoke :null-sphere :phase :phase-other :planar-summons :planar-visit :plane-shift :plane-shift-other :rapid-journey :reorient :sanctuary :scry-gate :seek-gate :slow-time :splat :suspend-time :teleport :teleport-other :teleport-shield :time-out :timeport :timeport-other :timeslip :timeslip-other :trace-teleport :underworld-imprisonment)
   :animal '(:abominable-alteration :animal-control :beast-link :beast-possession :beast-rouser :beast-soother :beast-seeker :beast-speech :beast-summoning :call :creeping-plague :great-shapeshift :groom :hybrid-control :insect-repellent :master :merging-shapeshifting :partial-shapeshifting :permanent-beast-possession :permanent-shapeshifting :protect-animal :repel-animal :repel-hybrids :rider :rider-within :shapeshift-others :shapeshifting :spider-silk :thousand-legged-demise :abominable-alteration :animal-control :beast-link :beast-possession :beast-rouser :beast-soother :beast-seeker :beast-speech :beast-summoning :call :creeping-plague :great-shapeshift :groom :hybrid-control :insect-repellent :master :merging-shapeshifting :partial-shapeshifting :permanent-beast-possession :permanent-shapeshifting :protect-animal :repel-animal :repel-hybrids :rider :rider-within :shapeshift-others :shapeshifting :spider-silk :thousand-legged-demise :abominable-alteration :animal-control :beast-link :beast-possession :beast-rouser :beast-soother :beast-seeker :beast-speech :beast-summoning :call :creeping-plague :great-shapeshift :groom :hybrid-control :insect-repellent :master :merging-shapeshifting :partial-shapeshifting :permanent-beast-possession :permanent-shapeshifting :protect-animal :repel-animal :repel-hybrids :rider :rider-within :shapeshift-others :shapeshifting :spider-silk :thousand-legged-demise)
   :making-and-breaking '(:animate-object :annihilation :awaken-craft-spirit :clean :contract-object :copy :destabilization :disintegrate :draw-together-shards :dye :enlarge-object :explode :explosive-mine :extend-object :fasten :find-weakness :immediate-action :inscribe :inspired-creation :knot :mapmaker :minefield :mystic-mark :rebuild :rejoin :repair :reshape :restore :rive :ruin :self-repairing :sharpen :shatter :shatterproof :shrink-object :soilproof :soul-creation :stiffen :tack :toughen :transfigure-object :transform-object :transparency :weaken :weapon-self :wizardly-workshop :animate-object :annihilation :awaken-craft-spirit :clean :contract-object :copy :destabilization :disintegrate :draw-together-shards :dye :enlarge-object :explode :explosive-mine :extend-object :fasten :find-weakness :immediate-action :inscribe :inspired-creation :knot :mapmaker :minefield :mystic-mark :rebuild :rejoin :repair :reshape :restore :rive :ruin :self-repairing :sharpen :shatter :shatterproof :shrink-object :soilproof :soul-creation :stiffen :tack :toughen :transfigure-object :transform-object :transparency :weaken :weapon-self :wizardly-workshop)
   :protection-and-warning '(:mass-resist-lightning :mass-resist-poison :mass-shade :missile-shield :mystic-mist :nightingale :oven-mitts :prismatic-mist-area :protect-animal :reflect-gaze :resist-acid :resist-disease :resist-lightning :resist-poison :resist-pressure :resist-radiation :resist-sound :resist-water :return-missile :reverse-missiles :selective-hearing :sense-danger :sense-observation :shade :shield :spoof-sensor :stinkguard :storm-shelter :teleport-shield :turn-blade :umbrella :utter-dome :utter-wall :warmth :watchdog :weather-dome)
   :water '(:acid-ball :acid-jet :arctic-blast :alkahest-jet :alkahest-sphere :boil-water :breathe-air :breathe-steam :breathe-water :body-of-ice :body-of-water :boil-water :cloud :condense-steam :cone-of-corrosion :control-water-elemental :coolness :create-acid :create-ice :create-spring :create-steam :create-water :create-water-elemental :current :dehydrate :destroy-water :dissipate :distill :drown :dry-spring :earth-to-water :elemental-plumbing :essential-acid :essential-water :flow :flesh-to-ice :fog :foul-water :freeze :frost :frostbite :geyser :hail :ice-dagger :ice-slick :ice-sphere :ice-vision :icy-breath :ice-storm :icy-missile :icy-touch :icy-weapon :infiltrate :mass-coolness)
   :mind-control '(:adjuration :alertness :avoid :berserker :boost-intelligence :bravery :charm :coma :command :compel-lie :confuse-memory :daze :disbelieve :discord :disorient :drama :dream-projection :dream-sending :drunkenness :dull :dullness :ecstasy :emotion-control :encrypt :enslave :enthrall :false-memory :fascinate :fear :foolishness :forgetfulness :game-addict :glib-tongue :great-geas :great-hallucination :hallucination :hypnotize :keen :keyfinder :know-thyself :lesser-geas :literary-hunger :loyalty :lure :madness :mass-charm :mass-daze :mass-hallucination :mass-mutilation :mass-sleep :mass-suggestion :memorize :mental-stun :mind-killer :mindlessness :nightmare :oath :pacify :panic :patience :peaceful-sleep :permanent-forgetfulness :permanent-madness :rear-vision :recall :relieve-madness :sickness :sleep :speed-reading :stabbing-party :startle :strengthen-will :suggestion :sweet-oblivion :transfer-loyalty :terror :vigil :volatility :weaken-will :will-lock :wisdom :writer's-block)
   :illusion-and-creation '(:blend-in :complex-illusion :control-creation :control-illusion :create-animal :create-foreign-body :create-mount :create-object :create-servant :create-trap :create-warrior :disbelieve :dispel-creation :dispel-illusion :duplicate :gargoyle-skin :illusion-disguise :illusion-shell :image :independence :initiative :inscribe :know-illusion :mirror :perfect-illusion :phantom :phantom-flame :phantom-killer :shadowplay :simple-illusion :stand-out :blend-in :complex-illusion :control-creation :control-illusion :create-animal :create-foreign-body :create-mount :create-object :create-servant :create-trap :create-warrior :disbelieve :dispel-creation :dispel-illusion :duplicate :gargoyle-skin :illusion-disguise :illusion-shell :image :independence :initiative :inscribe :know-illusion :mirror :perfect-illusion :phantom :phantom-flame :phantom-killer :shadowplay :simple-illusion :stand-out)
   :body-control '(:accelerate-pregnancy :ache :agonize :alter-body :alter-visage :alter-voice :ambidexterity :analgesic :balance :belch :birth-control :blend-in :boost-dexterity :boost-health :boost-strength :cadence :choke :climbing :clumsiness :control-limb :corpulence :curse-missile :death :death-field :deathtouch :debility :decapitation :despoil-seed :diver's-blessing :doomtouch :ease-labor :eat-crow :elvish-grace :enlarge :enlarge-other :ether-static :flexibility :frailty :fumble :gauntness :grace :hair-growth :haircut :hinder :hold-breath :hunger :imp-face :itch :lengthen-limb :ley-running :mark-of-thieves :might :mouth-goes-away :nauseate :pain :paralyze-limb :partial-mechamorphosis :perfume :plague-touch :reflexes :remove-fetus :resist-pain :retch :rooted-feet :roundabout :seek-emitter :sensitize :shrink :shrink-other :sickness :spasm :stand-out :strike-anosmic :stop-spasm :stifle :strike-barren :strike-blind :strike-deaf :strike-dumb :strike-numb :stun :tanglefoot :thirst :throw-voice :tickle :total-paralysis :touch :transfer-pregnancy :transform-body :transform-other :transmogrification :vigor :warp-fetus :weaken-blood :wither-limb :accelerate-pregnancy :ache :agonize :alter-body :alter-visage :alter-voice :ambidexterity :analgesic :balance :belch :birth-control :blend-in :boost-dexterity :boost-health :boost-strength :cadence :choke :climbing :clumsiness :control-limb :corpulence :curse-missile :death :death-field :deathtouch :debility :decapitation :despoil-seed :diver's-blessing :doomtouch :ease-labor :eat-crow :elvish-grace :enlarge :enlarge-other :ether-static :flexibility :frailty :fumble :gauntness :grace :hair-growth :haircut :hinder :hold-breath :hunger :imp-face :itch :lengthen-limb :ley-running :mark-of-thieves :might :mouth-goes-away :nauseate :pain :paralyze-limb :partial-mechamorphosis :perfume :plague-touch :reflexes :remove-fetus :resist-pain :retch :rooted-feet :roundabout :seek-emitter :sensitize :shrink :shrink-other :sickness :spasm :stand-out :strike-anosmic :stop-spasm :stifle :strike-barren :strike-blind :strike-deaf :strike-dumb :strike-numb :stun :tanglefoot :thirst :throw-voice :tickle :total-paralysis :touch :transfer-pregnancy :transform-body :transform-other :transmogrification :vigor :warp-fetus :weaken-blood :wither-limb :accelerate-pregnancy :ache :agonize :alter-body :alter-visage :alter-voice :ambidexterity :analgesic :balance :belch :birth-control :blend-in :boost-dexterity :boost-health :boost-strength :cadence :choke :climbing :clumsiness :control-limb :corpulence :curse-missile :death :death-field :deathtouch :debility :decapitation :despoil-seed :diver's-blessing :doomtouch :ease-labor :eat-crow :elvish-grace :enlarge :enlarge-other :ether-static :flexibility :frailty :fumble :gauntness :grace :hair-growth :haircut :hinder :hold-breath :hunger :imp-face :itch :lengthen-limb :ley-running :mark-of-thieves :might :mouth-goes-away :nauseate :pain :paralyze-limb :partial-mechamorphosis :perfume :plague-touch :reflexes :remove-fetus :resist-pain :retch :rooted-feet :roundabout :seek-emitter :sensitize :shrink :shrink-other :sickness :spasm :stand-out :strike-anosmic :stop-spasm :stifle :strike-barren :strike-blind :strike-deaf :strike-dumb :strike-numb :stun :tanglefoot :thirst :throw-voice :tickle :total-paralysis :touch :transfer-pregnancy :transform-body :transform-other :transmogrification :vigor :warp-fetus :weaken-blood :wither-limb)
   :technological '(:animate-machine :awaken-building :awaken-computer :blind-sensor :confound-firearm :create-mana-co-processor :delete-commercials :essential-paper :glitch :guide-missile :ley-vehicle :machine-control :machine-possession :machine-speech :machine-summoning :mad-machine :malfunction :magnetic-finger :manipulate-dna :permanent-machine-possession :program :purify-signal :rebuild :reckless-reconstitution :remote-start :reveal-function :schematic :seek-machine :sense-nano :sequence-dna :spoof-sensor :televisomancy :upgrade-computer :wizardly-workshop)})

(comment

  (->> spells
       (group-by :college)
       (map #(do {(key %) (map (fn [e] (:name e)) (val %))})))

  (defn get-unique-maps [key coll]
    (->> coll
         (group-by #(get % key))
         (vals)
         (map first)))

  ;; (-> :parsed
  ;;     (map #(str "(def ^:private '(symbol (keyword (kebab-case (get % :name)))) '" % ")"))
  ;;     (map cljs.reader/read-string))
  )
