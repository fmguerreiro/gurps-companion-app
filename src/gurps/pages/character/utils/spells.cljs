(ns gurps.pages.character.utils.spells)

(def spells
  [{:name :small-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :ref "Magic, p. 111"}
   {:name :phase-other, :prerequisites [:phase], :ref "Magic p. 83"}
   {:name :shape-air, :prerequisites [:create-air], :ref "Basic Set p. 243}; Magic p. 24"}
   {:name :hold-breath, :prerequisites [[:advantages/magery 1] :vigor], :ref "Magic, p. 39"}
   {:name :total-paralysis, :prerequisites [:paralyze-limb], :ref "Magic, p. 40"}
   {:name :repel-animal, :prerequisites [:animal-control], :ref "Magic p. 31"}
   {:name :exchange-bodies, :prerequisites [:permanent-possession :soul-jar], :ref "Magic, p. 49"}
   {:name :stone-to-earth, :prerequisites [#{[4 :earth] :earth-to-stone}], :ref "Basic Set, p. 246}; Magic, p. 51"}
   {:name :acid-ball, :prerequisites [[:advantages/magery 2] :create-acid], :ref "Magic p. 191"}
   {:name :curse-virus, :prerequisites [:spellprocessor :animate-machine :awaken-computer :curse :glitch #{:mad-machine :malfunction}], :ref "Classic: Tenchnomancer p. 20"}
   {:name :great-wish, :prerequisites [[:advantages/magery 3] :wish [:attributes/int 20]], :ref "Magic p. 61"}
   {:name :slow-healing, :prerequisites [[:advantages/magery 1] :frailty :steal-vitality], :ref "Magic p. 153"}
   {:name :hide-object, :prerequisites [:hideaway :teleport], :ref "Magic p. 86"}
   {:name :lightning-whip, :prerequisites [:lightning], :ref "Magic p. 196"}
   {:name :duplicate, :prerequisites [:create-object :copy], :ref "Magic p. 98"}
   {:name :mind-sending, :prerequisites [:mind-reading], :ref "Magic, p. 47}; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
   {:name :cook, :prerequisites [:test-food :create-food], :ref "GURPS Magic, p. 78"}
   {:name :weaken, :prerequisites [:find-weakness], :ref "Magic p. 116"}
   {:name :essential-earth, :prerequisites [[6 :earth]], :ref "Magic, p. 53}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :broadcast-spell, :prerequisites [[:advantages/magery 3] :telepathy :mass-suggestion [:world/tl 6]], :ref "Classic: Technomander p. 19"}
   {:name :control-earth-elemental, :prerequisites [:summon-earth-elemental], :ref "Magic, p. 28"}
   {:name :volcano, :prerequisites [:earthquake [6 :fire]], :ref "Magic, p. 54"}
   {:name :alter-terrain, :prerequisites [[:advantages/magery 3] :shape-fire :shape-stone :shape-water :shape-air], :ref "Magic, p. 55"}
   {:name :illusion-disguise, :prerequisites [:simple-illusion], :ref "Magic p. 96}; Fantasy, p. 170"}
   {:name :spellguard, :prerequisites [:dispel-magic], :ref "Magic p. 127}; Thaumatology: Urban Magics"}
   {:name :utter-wall, :prerequisites [:utter-dome :spell-wall], :ref "Magic p. 170"}
   ;;{:name :mass-charm, :prerequisites [[:advantages/magery 2] [:attributes/int 13] :charm], :ref "Magic Styles: Dungeon Magic, p. 31"}
   {:name :swim, :prerequisites [:shape-water :levitation], :ref "Magic p. 147"}
   {:name :partial-petrification, :prerequisites [[:advantages/magery 2] :flesh-to-stone], :ref "Magic, p. 52"}
   {:name :warmth, :prerequisites [:heat], :ref "Magic p. 74"}
   {:name :boost-strength, :prerequisites [:might], :ref "Magic, p. 37"}
   {:name :awaken-craft-spirit, :prerequisites [:inspired-creation :sense-spirit], :ref "Magic p. 115"}
   {:name :haircut, :prerequisites [:hair-growth], :ref "Magic, p. 39"}
   {:name :suspended-animation, :prerequisites [:sleep [4 :healing]], :ref "Magic p. 94"}
   {:name :great-shapeshift, :prerequisites [[:advantages/magery 3] :alter-body [4 :shapeshifting]], :ref "Magic p. 34"}
   {:name :sound, :prerequisites [], :ref "Magic p. 171}; Fantasy p. 172"}
   {:name :rooted-feet, :prerequisites [:hinder], :ref "Basic Set, p. 244}; Magic, p. 36"}
   {:name :itch, :prerequisites [], :ref "Basic Set, p. 244}; Magic, p. 35"}
   {:name :hallucination, :prerequisites [:madness :suggestion], :ref "Magic p. 140"}
   {:name :astral-vision, :prerequisites [:sense-spirit :see-invisible], :ref "Magic, p. 105"}
   {:name :alarm, :prerequisites [:tell-time], :ref "Magic, p. 100"}
   {:name :resist-fire, :prerequisites [:extinguish-fire :cold], :ref "Basic Set, p. 247}; Magic p. 74"}
   {:name :create-servant, :prerequisites [[:advantages/magery 3] [:attributes/int 12] :create-object], :ref "Magic p. 98"}
   {:name :soul-prison, :prerequisites [[:advantages/magery 3] :banish :soul-jar :banish :soul-jar :any-four-of-animate-shadow :possession :repel-spirits :divination :mass-zombie :summon-demon :pentagram :summon-earth-elemental :phase-other], :ref ""}
   {:name :wizard-ear, :prerequisites [:apportation :far-hearing :sound-vision], :ref "Magic, p. 104"}
   {:name :delayed-message, :prerequisites [[:advantages/magery 1] :voices :sense-life], :ref "Magic p. 173"}
   {:name :stop-spasm, :prerequisites [#{:spasm :lend-vitality}], :ref "Magic, p. 35"}
   {:name :icy-missile, :prerequisites [:icy-weapon], :ref "Magic p. 186"}
   {:name :move-terrain, :prerequisites [:alter-terrain :hide-object], :ref "Magic, p. 55"}
   {:name :repel-hybrids, :prerequisites [:hybrid-control], :ref "Magic p. 31"}
   {:name :permanent-madness, :prerequisites [[:advantages/magery 2] :madness [:attributes/int 13]], :ref "Magic p. 139"}
   {:name :suspend-magery, :prerequisites [[:advantages/magery 2] :2-each-from-10-colleges], :ref "Magic p. 130"}
   {:name :transfer-pregnancy, :prerequisites [[:advantages/magery 2] :remove-fetus], :ref "GURPS Bio-Tech, p. 32"}
   {:name :cloud-walking, :prerequisites [:walk-on-air :walk-on-water], :ref "Magic p. 148"}
   {:name :dehydrate, :prerequisites [[5 :water] :destroy-water], :ref "Magic p. 188"}
   {:name :counterspell, :prerequisites [[:advantages/magery 1] :spell-being-countered], :ref "Basic Set, p. 250}; Magic p. 121"}
   {:name :hang-spell, :prerequisites [:delay], :ref "Magic p. 128}; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
   {:name :predict-weather, :prerequisites [[4 :air]], :ref "Basic Set p. 243}; Magic p. 193"}
   {:name :alter-body, :prerequisites [:alter-visage], :ref "Magic, p. 41"}
   {:name :transmogrification, :prerequisites [[:advantages/magery 3] :transform-other :transform-object :flesh-to-stone.], :ref "Magic, p. 43"}
   {:name :copy, :prerequisites [:dye :1-written-language-at-accented], :ref "Magic p. 116"}
   {:name :far-hearing, :prerequisites [[:advantages/magery 1] [4 :sound]], :ref "Magic, p. 173"}
   {:name :condense-steam, :prerequisites [#{:boil-water :cold}], :ref "Magic p. 189"}
   ;;{:name :mass-invisibility, :prerequisites [[:advantages/magery 2] [:attributes/int 13] :hallucination], :ref "Magic Styles: Dungeon Magic, p. 32"}
   {:name :great-hallucination, :prerequisites [[:advantages/magery 2] :hallucination], :ref "Magic p. 141"}
   {:name :tell-time, :prerequisites [], :ref "Magic, p. 100"}
   {:name :protect-animal, :prerequisites [:armor :watchdog :animal-spells], :ref "Magic p. 32"}
   {:name :restore-mana, :prerequisites [:dispel-magic :suspend-mana], :ref "Magic p. 128}; Thaumatology: Urban Magics"}
   {:name :destroy-air, :prerequisites [:purify-air], :ref "Magic p. 43"}
   {:name :silver-tongue, :prerequisites [:voices :emotion-control], :ref "Magic p. 174"}
   {:name :blink, :prerequisites [:teleport], :ref "Magic p. 148"}
   {:name :enlarge, :prerequisites [[:advantages/magery 2] :alter-body], :ref "Magic, p. 42}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :far-feeling, :prerequisites [[:advantages/magery 1]], :ref "Magic, p. 100"}
   {:name :forgetfulness, :prerequisites [[:advantages/magery 1] :foolishness], :ref "Basic Set p. 250}; Magic p. 135"}
   {:name :ice-vision, :prerequisites [:shape-water], :ref "Classic: Magic p. 37"}
   {:name :body-of-ice, :prerequisites [[:advantages/magery 2] :body-of-water :freeze], :ref "Magic p. 189"}
   {:name :simulacrum, :prerequisites [[:advantages/magery 3] :golem :perfect-illusion :illusion-disguise], :ref "Magic p. 61"}
   {:name :shatterproof, :prerequisites [:repair :shatter], :ref "Magic p. 118"}
   {:name :knot, :prerequisites [:stiffen], :ref "Magic p. 117"}
   {:name :sense-danger, :prerequisites [#{:danger-sense :sense-foes}], :ref "Magic p. 166"}
   {:name :stiffen, :prerequisites [:rejoin], :ref "Magic p. 117"}
   {:name :lockmaster, :prerequisites [[:advantages/magery 2] :apportation], :ref "Basic Set, p. 251}; Magic p. 144"}
   {:name :pain, :prerequisites [:spasm], :ref "Magic, p. 36"}
   {:name :rain-of-stones, :prerequisites [[:advantages/magery 2] :create-earth], :ref "Magic, p. 53"}
   {:name :resist-sound, :prerequisites [[4 :sound]], :ref "Magic p. 173"}
   {:name :mystic-mist, :prerequisites [[:advantages/magery 1] #{:shield :watchdog}], :ref "Magic p. 168"}
   {:name :detect-magic, :prerequisites [[:advantages/magery 1]], :ref "Basic Set, p. 249}; Magic, p. 101"}
   {:name :animation, :prerequisites [:summon-spirit], :ref "Magic p. 150"}
   {:name :age, :prerequisites [#{[6 :necromantic] :youth}], :ref "Magic p. 154"}
   {:name :persuasion, :prerequisites [:sense-emotion], :ref "Magic, p. 45"}
   {:name :frost, :prerequisites [#{:create-water :cold}], :ref "Magic p. 193"}
   {:name :nightingale, :prerequisites [:sense-danger], :ref "Magic p. 167"}
   {:name :mass-suggestion, :prerequisites [:suggestion], :ref "Magic p. 141"}
   {:name :recover-energy, :prerequisites [[:advantages/magery 1] :lend-energy], :ref "Basic Set, p. 248}; Magic p. 89"}
   {:name :simple-illusion, :prerequisites [:no-blindness [:attributes/int 11]], :ref "Magic p. 95}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
   {:name :manipulate, :prerequisites [:locksmith], :ref "Magic p. 145"}
   {:name :transform-body, :prerequisites [:alter-body [3 :shapeshifting]], :ref "Magic, p. 43"}
   {:name :invisible-wizard-ear, :prerequisites [:wizard-ear :invisibility], :ref "Magic p. 174"}
   {:name :oath, :prerequisites [[:advantages/magery 1] :emotion-control], :ref "Magic p. 138"}
   {:name :mapmaker, :prerequisites [:inscribe :measurement], :ref "Magic p. 118"}
   {:name :reverse-missiles, :prerequisites [#{:force-dome :missile-shield}], :ref "Magic p. 168}; Pyramid 3/60: Dungeon Fantasy III p. 5"}
   {:name :suspend-enchantment, :prerequisites [:enchant], :ref "Magic p. 58"}
   {:name :transform-object, :prerequisites [:m2 :reshape [4 :create]], :ref "Magic p. 120"}
   {:name :cool, :prerequisites [:cold [4 :air]], :ref "Magic p. 195"}
   {:name :soilproof, :prerequisites [:materialize], :ref "Magic p. 116}; Thaumatology: Urban Magics, p. 33"}
   {:name :seek-fire, :prerequisites [], :ref "Magic p. 72"}
   {:name :spark-cloud, :prerequisites [:shape-air :lightning], :ref "Magic p. 196"}
   {:name :ward, :prerequisites [[:advantages/magery 1]], :ref "Magic p. 122}; Thaumatology: Urban Magics"}
   {:name :geyser, :prerequisites [[6 :water] :create-spring #{[4 :earth] [4 :fire]}], :ref "Magic p. 190"}
   {:name :pestilence, :prerequisites [[:advantages/magery 1] :steal-vitality :decay], :ref "Magic p. 154"}
   {:name :blink-other, :prerequisites [:blink], :ref "Magic p. 148"}
   {:name :shapeshift-others, :prerequisites [[:advantages/magery 2] :shapeshifting], :ref "Magic p. 33"}
   {:name :purify-earth, :prerequisites [:apportation :shape-earth], :ref "Magic, p. 54}; GURPS Fantasy, p. 169"}
   {:name :freeze, :prerequisites [:shape-water], :ref "Magic p. 185"}
   {:name :remove-contagion, :prerequisites [:decay :clean :or-cure-disease], :ref "Magic p. 90"}
   {:name :beast-summoning, :prerequisites [:beast-soother], :ref "Magic p. 30"}
   {:name :frostbite, :prerequisites [:frost :freeze], :ref "Magic p. 189"}
   {:name :lesser-wish, :prerequisites [:enchant], :ref "Magic p. 61"}
   {:name :earth-to-air, :prerequisites [:create-air :shape-earth], :ref "Basic Set p. 243}; Magic p. 25"}
   {:name :know-recipe, :prerequisites [:far-tasting :season], :ref "Magic, p. 78"}
   {:name :cleansing, :prerequisites [:minor-healing :purify-earth], :ref "Magic p. 94"}
   {:name :spider-silk, :prerequisites [[:advantages/magery 1] [2 :animal]], :ref "Magic p. 32"}
   {:name :panic, :prerequisites [:fear], :ref "Magic p. 134"}
   {:name :timeslip-other, :prerequisites [:timeslip], :ref "Magic p. 81"}
   {:name :dry-spring, :prerequisites [:destroy-water :shape-earth], :ref "Magic p. 188"}
   {:name :dye, :prerequisites [:restore :colors], :ref "Magic p. 116"}
   {:name :essential-food, :prerequisites [:create-food [6 :food]], :ref "GURPS Magic, p. 79}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :ruin, :prerequisites [[:advantages/magery 1] :weaken :decay], :ref "Magic p. 118"}
   {:name :wisdom, :prerequisites [[6 :other]], :ref "Magic p. 135}; Social Engineering: Back to School, p. 24"}
   {:name :timeport, :prerequisites [[:advantages/magery 3] :teleport], :ref "Magic p. 81"}
   {:name :alter-visage, :prerequisites [[:advantages/magery 1] #{:perfect-illusion :shapeshifting} [8 :body-control]], :ref "Magic, p. 41"}
   {:name :explosive-lightning, :prerequisites [:lightning], :ref "Magic p. 196"}
   {:name :imitate-voice, :prerequisites [:voices], :ref "Magic p. 172"}
   {:name :remove-curse, :prerequisites [[:advantages/magery 2] :1-spell-from-15-colleges], :ref "Magic p. 126}; Thaumatology: Urban Magics"}
   {:name :converse, :prerequisites [[:advantages/magery 1] :garble :silence], :ref "Magic p. 173"}
   {:name :identify-spell, :prerequisites [:detect-magic], :ref "Basic Set, p. 249}; Magic, p. 102"}
   {:name :fasten, :prerequisites [:knot], :ref "Magic p. 118"}
   {:name :charm, :prerequisites [[:advantages/magery 1] :loyalty [7 :other]], :ref "Magic p. 139"}
   {:name :distill, :prerequisites [:mature :destroy-water], :ref "GURPS Magic, p. 89"}
   {:name :create-mount, :prerequisites [[:advantages/magery 3] :create-animal], :ref "Magic p. 99"}
   {:name :malfunction, :prerequisites [[:advantages/magery 2] :glitch], :ref "Magic p. 177"}
   {:name :dispel-magic, :prerequisites [:counterspell [12 :other]], :ref "Basic Set, p. 250}; Magic p. 126"}
   {:name :mage-light, :prerequisites [:mage-sight :light], :ref "Magic p. 113"}
   {:name :flaming-missiles, :prerequisites [:flaming-weapon], :ref "Magic p. 75"}
   {:name :gloom, :prerequisites [:continual-light], :ref "Magic p. 112"}
   {:name :predict-earth-movement, :prerequisites [[4 :earth]], :ref "Magic, p. 51"}
   {:name :presence, :prerequisites [:persuasion :lure], :ref "Magic, p. 48"}
   {:name :great-haste, :prerequisites [[:advantages/magery 1] [:attributes/int 12] :haste], :ref "Basic Set, p. 251}; Magic p. 146"}
   {:name :ice-dagger, :prerequisites [#{:water-jet :ice-sphere}], :ref "Magic p. 188"}
   {:name :continual-mage-light, :prerequisites [:mage-light :continual-light], :ref "Magic p. 113"}
   {:name :beacon, :prerequisites [:teleport :timeport :plane-shift], :ref "Magic p. 83}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :dispel-creation, :prerequisites [:control-creation], :ref "Magic p. 99"}
   {:name :speed, :prerequisites [:enchant :haste], :ref "Magic p. 57"}
   {:name :doppelganger, :prerequisites [[:advantages/magery 3] :golem :history :enslave], :ref "Magic p. 62}; Classic: Magic p 40"}
   {:name :false-memory, :prerequisites [:forgetfulness [6 :mind-control]], :ref "Magic p. 139"}
   {:name :glue, :prerequisites [:haste], :ref "Magic p. 142"}
   {:name :analyze-magic, :prerequisites [:identify-spell], :ref "Basic Set, p. 249}; Magic, p. 102"}
   {:name :scryguard, :prerequisites [[:advantages/magery 1]], :ref "GURPS Fantasy, p. 170}; Thaumatology: Urban Magics"}
   {:name :missile-shield, :prerequisites [[:advantages/magery 2] #{:shield :apportation}], :ref "Magic p. 168}; Thaumatology: Urban Magics, p. 33"}
   {:name :awaken-computer, :prerequisites [:animation :wisdom], :ref "Magic p. 178"}
   {:name :essential-acid, :prerequisites [[:advantages/magery 3] :all [6 :acid]], :ref "Magic p. 192}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :phantom, :prerequisites [[:advantages/magery 2] :perfect-illusion :hinder :apportation], :ref "Magic p. 97"}
   {:name :control-illusion, :prerequisites [:perfect-illusion], :ref "Magic p. 97"}
   {:name :create-steam, :prerequisites [:boil-water], :ref "Magic p. 190"}
   {:name :paralyze-limb, :prerequisites [[:advantages/magery 1] :pain [4 :other]], :ref "Basic Set, p. 244}; Magic, p. 40"}
   {:name :icy-breath, :prerequisites [[:advantages/magery 1] :snow-jet :resist-cold], :ref "Magic p. 192"}
   {:name :shield, :prerequisites [[:advantages/magery 2]], :ref "Basic Set, p. 252}; Magic p. 167"}
   {:name :animate-machine, :prerequisites [:machine-control #{:animation :animate-object}], :ref "Magic p. 177"}
   {:name :bind-spirit, :prerequisites [:comm :spirit :soul-jar], :ref "Magic p. 158"}
   {:name :curse, :prerequisites [[:advantages/magery 2] :2-each-from-10-colleges], :ref "Magic p. 129"}
   {:name :hinder, :prerequisites [#{:clumsiness :haste}], :ref "Basic Set, p. 244}; Magic, p. 36"}
   {:name :switch-bodies, :prerequisites [:permanent-possession], :ref "4e spell chart"}
   {:name :rear-vision, :prerequisites [:alertness], :ref "Magic p. 134"}
   {:name :awaken, :prerequisites [:lend-vitality], :ref "Basic Set, p. 248}; Magic p. 90"}
   {:name :flow, :prerequisites [:body-of-fluid], :ref "Magical Styles: Dungeon Magic, p.9"}
   {:name :accelerate-pregnancy, :prerequisites [:ease-labor :haste], :ref "Spell: Bio-Tech, p. 30}; Item: Classic: Technomancer pg 17"}
   {:name :might, :prerequisites [:lend-energy], :ref "Magic, p. 37"}
   {:name :restore, :prerequisites [#{:simple-illusion :find-weakness}], :ref "Magic p. 116"}
   {:name :coolness, :prerequisites [:cold], :ref "Magic p. 187"}
   {:name :thunderclap, :prerequisites [:sound], :ref "Magic p. 171"}
   {:name :boost-dexterity, :prerequisites [:grace], :ref "Magic, p. 37"}
   {:name :silence, :prerequisites [:sound], :ref "Magic p. 171}; Fantasy p. 172"}
   {:name :remember-path, :prerequisites [:find-direction :memorize], :ref "Magic, p. 105"}
   {:name :catch-spell, :prerequisites [[:advantages/magery 2] [:attributes/dex 12] :return-missile], :ref "Magic p. 123"}
   {:name :rain-of-fire, :prerequisites [[:advantages/magery 2] :create-fire], :ref "Magic p. 74}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :ecstasy, :prerequisites [[:advantages/magery 2] :emotion-control], :ref "Magic p. 139"}
   {:name :summon-fire-elemental, :prerequisites [[:advantages/magery 1] #{[[8 :fire]] [[4 :fire] #{:summon-water-elemental :summon-air-elemental :summon-earth-elemental}]}], :ref "Magic p. 27"}
   {:name :raise-cone-of-power, :prerequisites [:lend-energy #{:restore-mana :pentagram}], :ref "GURPS Thaumatology, p. 52"}
   {:name :breathe-air, :prerequisites [:create-water :destroy-air], :ref "Magic p. 26"}
   {:name :decapitation, :prerequisites [[:advantages/magery 2] :alter-body], :ref "Magic, p. 42"}
   {:name :flying-carpet, :prerequisites [:flight :or-magery-2 :walk-on-air], :ref "Magic p. 145"}
   {:name :major-healing, :prerequisites [[:advantages/magery 1] :minor-healing], :ref "Basic Set, p. 248}; Magic p. 91"}
   {:name :create-animal, :prerequisites [:create-water :create-object [:attributes/int 12]], :ref "Magic p. 98"}
   {:name :hide-emotion, :prerequisites [:sense-emotion], :ref "Magic, p. 45"}
   {:name :spark-storm, :prerequisites [:windstorm :lightning], :ref "Magic p. 196"}
   {:name :summon-air-elemental, :prerequisites [[:advantages/magery 1] [4 :air] #{:summon-water-elemental :summon-fire-elemental :summon-earth-elemental}], :ref "Magic p. 27"}
   {:name :seek-magic, :prerequisites [:detect-magic], :ref "Magic, p. 102"}
   {:name :wall-of-light, :prerequisites [:continual-light], :ref "Magic p. 113"}
   {:name :acid-jet, :prerequisites [[:advantages/magery 2] :water-jet :create-acid], :ref "Magic p. 192"}
   {:name :gift-of-tongues, :prerequisites [:borrow-language], :ref "Magic, p. 46"}
   {:name :rapid-journey, :prerequisites [[:advantages/magery 3] #{:timeport :teleport}], :ref "Magic p. 82"}
   {:name :banish, :prerequisites [[:advantages/magery 1] :1-spell-from-10-colleges], :ref "Magic p. 156"}
   {:name :dream-viewing, :prerequisites [#{:truthsayer :sleep}], :ref "Magic, p. 45"}
   {:name :independence, :prerequisites [:simple-illusion], :ref "Magic p. 96"}
   {:name :initiative, :prerequisites [:independence :wisdom], :ref "Magic p. 97"}
   {:name :trace, :prerequisites [:seeker], :ref "Basic Set, p. 249}; Magic, p. 106"}
   {:name :relieve-paralysis, :prerequisites [:stop-paralysis], :ref "Magic p. 93"}
   {:name :control-person, :prerequisites [#{:telepathy :soul-rider}], :ref "Magic, p. 49"}
   {:name :relieve-madness, :prerequisites [:lend-vitality :wisdom], :ref "Magic p. 92"}
   {:name :hide-thoughts, :prerequisites [:truthsayer], :ref "Basic Set, p. 245}; Magic, p. 46"}
   {:name :frailty, :prerequisites [:lend-energy], :ref "Magic, p. 37"}
   {:name :curse-missile, :prerequisites [[:advantages/magery 2] :curse], :ref "Classic: Magic p 24"}
   {:name :lightning, :prerequisites [[:advantages/magery 1] [6 :other]], :ref "Basic Set p. 244}; Magic p. 196"}
   {:name :inspired-creation, :prerequisites [], :ref "Magic p. 115"}
   {:name :adjustable-clothing, :prerequisites [:enchant :reshape], :ref "Magic p. 58}; Thaumatology: Urban Magics, p. 33"}
   {:name :possession, :prerequisites [[:advantages/magery 1] #{:control-person :beast-possession}], :ref "Magic, p. 49"}
   ;;{:name :mass-hallucination, :prerequisites [[:advantages/magery 2] [:attributes/int 13] :hallucination], :ref "Magic Styles: Dungeon Magic, p. 32"}
   {:name :create-water-elemental, :prerequisites [[:advantages/magery 2] :control-water-elemental], :ref "Magic p. 22"}
   {:name :accelerate-time, :prerequisites [[:advantages/magery 2] [:attributes/int 13] :2-spell-from-10-colleges], :ref "Magic p. 86"}
   {:name :echoes-of-the-past, :prerequisites [[:advantages/magery 2] :history :voices], :ref "Magic, p. 107"}
   {:name :enslave, :prerequisites [:charm :telepathy], :ref "Magic p. 141"}
   {:name :halt-aging, :prerequisites [[:advantages/magery 2] [8 :healing]], :ref "Magic p. 94"}
   {:name :shatter, :prerequisites [[:advantages/magery 1] :weaken], :ref "Magic p. 116"}
   {:name :lengthen-limb, :prerequisites [[:advantages/magery 3] :shapeshifting], :ref "Magic, p. 42}; b: Classic Grimoire p. 18"}
   {:name :explosive-fireball, :prerequisites [:fireball], :ref "Basic Set, p. 247}; Magic p. 75"}
   {:name :seek-gate, :prerequisites [[:advantages/magery 2] :seek-magic :1-spell-from-10-colleges], :ref "Magic p. 85"}
   {:name :cure-disease, :prerequisites [:major-healing :relieve-sickness], :ref "Magic p. 91}; Fantasy, p. 170"}
   {:name :golem, :prerequisites [:enchant :shape-earth :animation], :ref "Magic p. 59"}
   {:name :bright-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :ref "Magic p. 111"}
   {:name :rejoin, :prerequisites [:weaken :restore], :ref "Magic p. 116"}
   {:name :locksmith, :prerequisites [:apportation], :ref "Magic p. 143"}
   {:name :water-to-wine, :prerequisites [:purify-water :mature], :ref "GURPS Magic, p. 79}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :levitation, :prerequisites [:apportation], :ref "Magic p. 143, Fantasy, p. 171/Classic: Magic p 70"}
   {:name :enthrall, :prerequisites [:forgetfulness :daze :slow], :ref "Magic p. 139"}
   {:name :continual-sunlight, :prerequisites [:sunlight], :ref "Classic: Magic p 64/Magic, p. 114"}
   {:name :freedom, :prerequisites [[3 :body] [3 :movement] [3 :protection-and-warning]], :ref "Magic p. 148"}
   {:name :dancing-object, :prerequisites [[:advantages/magery 2] :apportation], :ref "Magic p. 144, Classic Magic p 61"}
   {:name :gift-of-letters, :prerequisites [:borrow-language], :ref "Magic, p. 46"}
   {:name :animate-shadow, :prerequisites [:skull-spirit :shape-darkness], :ref "Magic p. 154"}
   {:name :mouth-goes-away, :prerequisites [[:advantages/magery 1] :alter-visage [4 :body-control]], :ref "Alphabet Arcane, p. 17"}
   {:name :climbing, :prerequisites [], :ref "Magic, p. 35"}
   {:name :flash, :prerequisites [:continual-light], :ref "Magic p. 112"}
   {:name :inscribe, :prerequisites [:simple-illusion :copy], :ref "Magic p. 97"}
   {:name :turn-blade, :prerequisites [#{:spasm :apportation}], :ref "Magic p. 167"}
   {:name :air-vortex, :prerequisites [[:advantages/magery 2] :body-of-air :windstorm], :ref "Magic p. 26"}
   {:name :storm, :prerequisites [:rain :hail], :ref "Magic p. 195"}
   {:name :ethereal-body, :prerequisites [[6 :movement] :or-magery-3 :body-of-air], :ref "Magic p. 146"}
   {:name :shrink, :prerequisites [[:advantages/magery 2] :alter-body], :ref "Magic, p. 42"}
   {:name :preserve-food, :prerequisites [:decay], :ref "GURPS Magic, p. 79"}
   {:name :alter-voice, :prerequisites [[4 :body-control] [4 :sound]], :ref "Magic, p. 41"}
   {:name :resist-lightning, :prerequisites [[6 :air]], :ref "Magic p. 196"}
   {:name :body-of-wind, :prerequisites [[:advantages/magery 3] [:body-of-air 16] [:windstorm 16] {:fire 1, :water 1, :earth 1, :ether 1}], :ref "Magic p. 27"}
   {:name :memorize, :prerequisites [#{:wisdom [6 :knowledge]}], :ref "Magic, p. 105}; Social Engineering: Back to School, p. 24"}
   {:name :boil-water, :prerequisites [:shape-water :heat], :ref "Magic p. 192"}
   {:name :repair, :prerequisites [[:advantages/magery 2] :rejoin], :ref "Magic p. 118"}
   {:name :command, :prerequisites [[:advantages/magery 2] :forgetfulness], :ref "Basic Set, p. 251}; Magic p. 136"}
   {:name :dispel-possession, :prerequisites [#{:possession :soul-rider}], :ref "Magic p. 49"}
   {:name :soul-jar, :prerequisites [[:advantages/magery 1] [6 :necromantic] :steal-vitality], :ref "Magic p. 154"}
   {:name :history, :prerequisites [:trace], :ref "Magic, p. 104"}
   {:name :create-door, :prerequisites [:teleport :any-1-walk-through-spell], :ref "Magic p. 84"}
   {:name :spasm, :prerequisites [:itch], :ref "Basic Set, p. 244}; Magic, p. 35"}
   {:name :suspend-time, :prerequisites [[:advantages/magery 3] :slow-time], :ref "Magic p. 86"}
   {:name :seek-earth, :prerequisites [], :ref "Basic Set, p. 245}; Magic, p. 50"}
   {:name :noise, :prerequisites [:wall-of-silence], :ref "Magic p. 173"}
   {:name :phase, :prerequisites [[:advantages/magery 3] #{:ethereal-body :plane-shift}], :ref "Magic p. 83"}
   {:name :perfume, :prerequisites [:odor], :ref "Magic, p. 35"}
   {:name :compel-lie, :prerequisites [:emotion-control], :ref "Magic, p. 137"}
   {:name :animate-object, :prerequisites [[:advantages/magery 2] [3 :shape]], :ref "Magic p. 117"}
   {:name :mystic-mark, :prerequisites [:dye :trace], :ref "Magic p. 119"}
   {:name :remove-fetus, :prerequisites [:ease-labor #{:minor-healing :apportation}], :ref "GURPS Bio-Tech, p. 32"}
   {:name :distant-blow, :prerequisites [[:advantages/magery 2] :apportation], :ref "Magic p. 144"}
   {:name :colors, :prerequisites [:light], :ref "Magic p. 110"}
   {:name :suggestion, :prerequisites [:emotion-control :forgetfulness], :ref "Magic p. 140"}
   {:name :vigor, :prerequisites [#{:frailty :lend-vitality}], :ref "Magic, p. 37"}
   {:name :strengthen-will, :prerequisites [[:advantages/magery 1] [6 :mind]], :ref "Magic p. 136"}
   {:name :sense-emotion, :prerequisites [:sense-foes], :ref "Basic Set, p. 245}; Magic, p. 45; Social Engineering: Back to School, p. 24"}
   {:name :tell-position, :prerequisites [:measurement], :ref "Magic, p. 101"}
   {:name :remove-shadow, :prerequisites [:light], :ref "Magic p. 110"}
   {:name :beast-speech, :prerequisites [:beast-summoning], :ref "Magic p. 31"}
   {:name :suspend-curse, :prerequisites [[:advantages/magery 1] :1-spell-from-12-colleges], :ref "Magic p. 125"}
   {:name :walk-on-air, :prerequisites [:shape-air], :ref "Basic Set p. 243}; Magic p. 25"}
   {:name :resist-radiation, :prerequisites [[3 :radiation]], :ref "Magic p. 182"}
   {:name :seek-pass, :prerequisites [:seek-earth], :ref "Magic, p. 51"}
   {:name :fool's-banquet, :prerequisites [[:advantages/magery 1] :cook :foolishness], :ref "GURPS Magic, p. 79"}
   {:name :hawk-flight, :prerequisites [:flight], :ref "Magic p. 146"}
   {:name :sand-jet, :prerequisites [:create-earth], :ref "Magic, p. 52"}
   {:name :slow-fire, :prerequisites [:extinguish-fire], :ref "Magic p. 73"}
   {:name :great-ward, :prerequisites [[:advantages/magery 2] :ward], :ref "Magic p. 122"}
   {:name :scrywall, :prerequisites [:scryguard], :ref "Magic p. 122}; Thaumatology: Urban Magics, p. 33"}
   {:name :purify-signal, :prerequisites [:purify-air [:world/tl 6]], :ref "Classic: Technomanser p 17"}
   {:name :plane-shift, :prerequisites [:planar-summons], :ref "Basic Set p. 247}; Magic p. 83"}
   {:name :windstorm, :prerequisites [:shape-air], :ref "Magic p. 25"}
   {:name :boost-intelligence, :prerequisites [:wisdom], :ref "Magic p. 37"}
   {:name :clumsiness, :prerequisites [:spasm], :ref "Basic Set, p. 244}; Magic, p. 36"}
   {:name :air-jet, :prerequisites [:shape-air], :ref "Magic p. 24"}
   {:name :deflect-energy, :prerequisites [[:advantages/magery 1] :shape-fire], :ref "Basic Set, p. 246}; Magic p. 73"}
   {:name :create-water, :prerequisites [:purify-water], :ref "Basic Set, p. 253}; Magic p. 184; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :purify-water :prerequisites [:seek-water] :ref "GURPS Basic Set, p. 253}; GURPS Magic, p. 184"}
   {:name :seek-water :prerequisites [] :ref "GURPS Basic Set, p. 253}; GURPS Magic, p. 184"}
   {:name :truthsayer, :prerequisites [:sense-emotion], :ref "Basic Set, p. 245}; Magic, p. 45"}
   {:name :wish, :prerequisites [:lesser-wish [:animal 1] [:light-and-darkness 1] [:body-control 1] [:communication-and-empathy 1] [:meta 1] [:mind-control 1] [:movement 1] [:food 1] [:gate 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:weather 1] [:protection-and-warning 1]], :ref "Magic p. 61"}
   {:name :telecast, :prerequisites [[:advantages/magery 3] :teleport :wizard-eye :1-spell-from-10-colleges], :ref "Magic p. 128"}
   {:name :false-aura, :prerequisites [:conceal-magic :aura], :ref "Magic p. 122"}
   {:name :scribe, :prerequisites [:voices :dancing-object #{:better :1-written-language-at-accented}], :ref "Magic p. 174"}
   {:name :encrypt, :prerequisites [:daze], :ref "Magic p. 135"}
   {:name :penetrating-spell, :prerequisites [:delay :find-weakness], :ref "Magic p. 123"}
   {:name :seek-machine, :prerequisites [], :ref "Magic p. 175"}
   {:name :drain-magery, :prerequisites [[:advantages/magery 3] :suspend-magery], :ref "Magic p. 130"}
   {:name :icy-touch, :prerequisites [[:advantages/magery 1] [5 :water]], :ref "Magic p. 188"}
   {:name :time-out, :prerequisites [[:advantages/magery 3] :accelerate-time], :ref "Magic p. 87"}
   {:name :resist-poison, :prerequisites [:vigor], :ref "Magic p. 91"}
   {:name :bless, :prerequisites [[:advantages/magery 2] :2-each-from-10-colleges], :ref "Magic p. 129"}
   {:name :mark-of-thieves, :prerequisites [[:advantages/magery 1] :pestilence], :ref "Alphabet Arcane, p. 17"}
   {:name :summon-shade, :prerequisites [#{:divination :summon-spirit}], :ref "Magic, p. 102"}
   {:name :wind, :prerequisites [:windstorm], :ref "Magic p. 193"}
   ;;{:name :disruption-bolt, :prerequisites [:spectrum-vision [6 :light-and-darkness] :radiation], :ref "Technomancer p 24"}
   {:name :know-location, :prerequisites [[:advantages/magery 1] :tell-position], :ref "Magic, p. 103"}
   {:name :repel-spirits, :prerequisites [:banish :turn-spirit], :ref "Magic p. 158"}
   {:name :entombment, :prerequisites [[:advantages/magery 2] [5 :earth]], :ref "Basic Set, p. 246}; Magic, p. 53"}
   {:name :shape-stone, :prerequisites [:shape-earth [3 :earth]], :ref "Fantasy, p. 169"}
   {:name :retrogression, :prerequisites [:mind-search :mind-sending], :ref "Magic, p. 47"}
   ;;{:name :pacify, :prerequisites [[:advantages/magery 2] :persuasion :relieve-madness], :ref "Magic Styles: Dungeon Magic, p. 24"}
   {:name :fire-cloud, :prerequisites [:shape-air :fireball], :ref "Magic p. 75"}
   {:name :ensorcel, :prerequisites [:malefice], :ref "Magic p. 60"}
   {:name :destroy-water, :prerequisites [:create-water], :ref "Basic Set, p. 253}; Magic p. 185"}
   {:name :trace-teleport, :prerequisites [:teleport :timeport :or-plane-shift], :ref "Magic p. 84"}
   {:name :amulet, :prerequisites [:talisman], :ref "Magic p. 58"}
   {:name :permanent-shapeshifting, :prerequisites [[:advantages/magery 3] :appropriate-shapeshifting], :ref "Magic p. 33"}
   {:name :phantom-flame, :prerequisites [#{:simple-illusion :shape-fire}], :ref "Magic p. 73"}
   {:name :return-missile, :prerequisites [:catch-missile], :ref "Magic p. 168"}
   {:name :vigil, :prerequisites [[:advantages/magery 2] :sleep :lend-energy], :ref "Magic p. 138"}
   {:name :strike-barren, :prerequisites [[:advantages/magery 1] :steal-vitality :decay], :ref "Magic, p. 41"}
   {:name :transform-other, :prerequisites [:shapeshift-others :appropriate-transform-body], :ref "Magic, p. 43"}
   {:name :dream-projection, :prerequisites [:dream-sending], :ref "Magic, p. 46"}
   {:name :borrow-skill, :prerequisites [:lend-skill], :ref "Magic, p. 47"}
   {:name :shape-earth, :prerequisites [:seek-earth], :ref "Basic Set, p. 245}; Magic, p. 50"}
   {:name :restore-speech, :prerequisites [:minor-healing #{:great-voice :strike-dumb}], :ref "Magic p. 93"}
   {:name :ancient-history, :prerequisites [:history], :ref "Magic, p. 106"}
   {:name :umbrella, :prerequisites [#{:shape-water :shield}], :ref "Magic p. 185"}
   {:name :shape-fire, :prerequisites [:ignite-fire], :ref "Basic Set, p. 246}; Magic p. 72"}
   {:name :peaceful-sleep, :prerequisites [:sleep :silence], :ref "Magic p. 138"}
   {:name :draw-together-shards, :prerequisites [:repair :trace :apportation], :ref "Alphabet Arcane, p. 9"}
   {:name :restore-hearing, :prerequisites [:minor-healing #{:strike-deaf :keen-hearing}], :ref "Magic p. 92"}
   {:name :restoration, :prerequisites [:major-healing :relieve-paralysis :restore], :ref "Magic p. 93"}
   {:name :partial-shapeshifting, :prerequisites [[:advantages/magery 3] :alter-body :shapeshifting], :ref "Magic p. 34"}
   {:name :recall, :prerequisites [[:advantages/magery 2] :memorize :history], :ref "Magic, p. 104"}
   {:name :dull, :prerequisites [], :ref "Magic p. 133"}
   {:name :roundabout, :prerequisites [:tanglefoot], :ref "Magic, p. 36"}
   {:name :agonize, :prerequisites [[:advantages/magery 2] :sensitize], :ref "Magic, p. 40"}
   {:name :hide, :prerequisites [#{:forgetfulness :blur}], :ref "Magic p. 113}; Fantasy, p. 170"}
   {:name :talisman, :prerequisites [:enchant], :ref "Magic p. 58"}
   {:name :know-illusion, :prerequisites [:simple-illusion], :ref "Magic p. 97"}
   {:name :haste, :prerequisites [], :ref "Basic Set, p. 251}; Magic p. 142"}
   {:name :reflect-gaze, :prerequisites [:mirror], :ref "Magic p. 168"}
   {:name :icy-weapon, :prerequisites [:create-water], :ref "Basic Set, p. 253}; Magic p. 185"}
   {:name :weaken-will, :prerequisites [[:advantages/magery 1] :foolishness], :ref "Magic p. 136"}
   {:name :tickle, :prerequisites [:spasm], :ref "Magic, p. 36"}
   ;;{:name :sovereign-countermagic, :prerequisites [[:advantages/magery 3] :analyze-magic :dispel-magic], :ref "Magic Styles: Dungeon Magic, p. 28"}
   {:name :create-object, :prerequisites [[:advantages/magery 2] :create-earth :perfect-illusion], :ref "Magic p. 98"}
   {:name :permanent-forgetfulness, :prerequisites [[:advantages/magery 2] :forgetfulness [:attributes/int 13]], :ref "Magic p. 138"}
   {:name :walk-through-earth, :prerequisites [:shape-stone], :ref "Magic, p. 52}; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :sharpen, :prerequisites [:repair], :ref "Magic p. 118"}
   {:name :relieve-sickness, :prerequisites [:lend-vitality], :ref "Magic p. 90"}
   {:name :great-geas, :prerequisites [[:advantages/magery 3] [15 :mind] :lesser-geas], :ref "Magic p. 141}; Social Engineering: Back to School, p. 24"}
   {:name :essential-air, :prerequisites [[6 :air]], :ref "Magic p. 26"}
   {:name :earth-vision, :prerequisites [:shape-earth], :ref "Magic, p. 51"}
   {:name :reflexes, :prerequisites [:grace :haste], :ref "Magic, p. 39"}
   {:name :astral-block, :prerequisites [:summon-spirit :repel-spirits], :ref "Magic p. 159"}
   {:name :mature, :prerequisites [#{:season :decay}], :ref "GURPS Magic, p. 78"}
   {:name :seek-food, :prerequisites [], :ref "GURPS Magic, p. 77"}
   {:name :divert-teleport, :prerequisites [:mager-3 :trace-teleport], :ref "Magic p. 84"}
   {:name :plastic-vision, :prerequisites [:shape-plastic], :ref "Magic, p. 183"}
   {:name :reveal-function, :prerequisites [:seek-machine], :ref "Magic p. 176"}
   {:name :create-acid, :prerequisites [:create-water :create-earth], :ref "Magic p. 190}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :rive, :prerequisites [[:advantages/magery 2] :shatter], :ref "Magic p. 117"}
   {:name :death-vision, :prerequisites [[:advantages/magery 1]], :ref "Basic Set, p. 251}; Magic p. 149"}
   {:name :atmosphere-dome, :prerequisites [:purify-air :weather-dome], :ref "Magic p. 169"}
   {:name :suspend-mana, :prerequisites [:suspend-magic :1-spell-from-10-colleges], :ref "Magic p. 125"}
   {:name :enlarge-object, :prerequisites [:extend-object], :ref "Magic p. 120"}
   {:name :hail, :prerequisites [:snow], :ref "Magic p. 195"}
   {:name :cadence, :prerequisites [:grace :haste], :ref "Magic, p. 39"}
   {:name :sound-jet, :prerequisites [:great-voice], :ref "Magic p. 173"}
   {:name :hush, :prerequisites [:silence], :ref "Magic p. 172"}
   {:name :final-rest, :prerequisites [#{[:advantages/magery 1] :spirit-empathy}], :ref "Magic p. 89"}
   {:name :disorient, :prerequisites [:foolishness], :ref "Magic p. 135"}
   {:name :snow, :prerequisites [:clouds :frost], :ref "Magic p. 193"}
   {:name :foul-water, :prerequisites [:purify-water :decay], :ref "GURPS Magic, p. 185"}
   {:name :slow-time, :prerequisites [[:advantages/magery 2] [:attributes/int 13] :2-from-each-of-10-colleges], :ref "Magic p. 86"}
   {:name :season, :prerequisites [:test-food], :ref "GURPS Magic, p. 77"}
   {:name :madness, :prerequisites [#{:forgetfulness :drunkenness}], :ref "Magic p. 136"}
   {:name :shrink-object, :prerequisites [:contract-object], :ref "Magic p. 120"}
   {:name :aura, :prerequisites [:detect-magic], :ref "Basic Set, p. 249}; Magic, p. 101"}
   {:name :stone-missile, :prerequisites [:create-earth], :ref "Magic, p. 52"}
   {:name :utter-dome, :prerequisites [[:advantages/magery 2] :force-dome :spell-shield], :ref "Magic p. 170"}
   {:name :infiltrate, :prerequisites [:body-of-fluid], :ref "Magical Styles: Dungeon Magic, p. 9"}
   {:name :entrap-spirit, :prerequisites [[:advantages/magery 1] :soul-jar :turn-spirit], :ref "Magic p. 157"}
   {:name :restore-memory, :prerequisites [:awaken [:attributes/int 11]], :ref "Magic p. 92"}
   {:name :warm, :prerequisites [:heat [4 :air]], :ref "Magic p. 195"}
   ;;{:name :blast-ball, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :ref "Magic Styles: Dungeon Magic, p. 19"}
   {:name :temporary-enchantment, :prerequisites [:enchant], :ref "Magic p. 56}; Fantasy, p. 23"}
   {:name :fireproof, :prerequisites [:extinguish-fire], :ref "Magic p. 73"}
   {:name :power, :prerequisites [:enchant :recover-energy], :ref "Basic Set, p. 480}; Magic p. 57"}
   {:name :sense-spirit, :prerequisites [:death-vision], :ref "Basic Set, p. 252}; Magic p. 149"}
   {:name :resist-pain, :prerequisites [[:advantages/magery 2] :pain], :ref "Magic, p. 38"}
   {:name :balance, :prerequisites [:grace], :ref "Magic, p. 39"}
   {:name :conceal-magic, :prerequisites [:detect-magic], :ref "Magic p. 122, Thaumatology: Urban Magics"}
   {:name :resist-disease, :prerequisites [#{:remove-contagion :vigor}], :ref "Magic p. 90"}
   {:name :light-tread, :prerequisites [:apportation :shape-earth], :ref "Magic p. 145"}
   {:name :beast-rouser, :prerequisites [#{:vexation :animal-empathy}], :ref "Magic p. 30"}
   {:name :rider-within, :prerequisites [[2 :animal]], :ref "Magic p. 31"}
   {:name :mage-sight, :prerequisites [:detect-magic], :ref "Magic, p. 102"}
   {:name :hex, :prerequisites [:enchant], :ref "Magic p. 57"}
   {:name :test-load, :prerequisites [:measurement], :ref "Magic, p. 101"}
   {:name :measurement, :prerequisites [], :ref "Magic, p. 100"}
   {:name :divination, :prerequisites [:skills/history], :ref "Magic, p. 108}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :sense-observation, :prerequisites [#{:sense-danger :scryguard}], :ref "Magic p. 167"}
   {:name :odor, :prerequisites [:no-smell], :ref "Magic p. 24"}
   {:name :control-zombie, :prerequisites [:zombie], :ref "Magic p. 152"}
   {:name :compel-truth, :prerequisites [[:advantages/magery 2] :truthsayer], :ref "Magic, p. 47"}
   {:name :shocking-touch, :prerequisites [:lightning], :ref "Magic p. 196"}
   {:name :lend-energy, :prerequisites [#{[:advantages/magery 1] :empathy}], :ref "Basic Set, p. 248}; Magic p. 89"}
   {:name :pentagram, :prerequisites [:spell-shield], :ref "Magic p. 124}; Thaumatology: Urban Magics"}
   {:name :stop-bleeding, :prerequisites [:lend-vitality], :ref "Magic p. 91}; Fantasy, p. 169"}
   {:name :invisible-wizard-eye, :prerequisites [:wizard-eye :invisibility], :ref "Magic, p. 104"}
   {:name :pathfinder, :prerequisites [[:advantages/magery 1] [:attributes/int 12] [2 :seek]], :ref "Magic, p. 105"}
   {:name :wizard-eye, :prerequisites [:apportation :keen-vision], :ref "Magic, p. 104"}
   {:name :solidify, :prerequisites [:materialize], :ref "Magic p. 151"}
   {:name :cloud-vaulting, :prerequisites [[:advantages/magery 2] :jump :walk-on-air], :ref "Magic p. 148"}
   {:name :body-of-air, :prerequisites [:shape-air], :ref "Magic p. 24"}
   {:name :far-tasting, :prerequisites [[:advantages/magery 1] #{:seek-food :seek-air}], :ref "Magic, p. 77"}
   {:name :images-of-the-past, :prerequisites [[:advantages/magery 2] :history :simple-illusion], :ref "Magic, p. 105"}
   {:name :ignite-fire, :prerequisites [], :ref "Basic Set, p. 246}; Magic p. 72"}
   {:name :permanent-possession, :prerequisites [[:advantages/magery 3] :possession], :ref "Magic, p. 49"}
   {:name :drunkenness, :prerequisites [:foolishness :clumsiness], :ref "Magic p. 136"}
   {:name :beast-seeker, :prerequisites [#{:beast-summoning :seeker}], :ref "Magic p. 32"}
   {:name :undo, :prerequisites [:locksmith], :ref "Magic p. 145"}
   {:name :weapon-self, :prerequisites [[:advantages/magery 2] :apportation :6-makin [:breaking :reshape]], :ref "Magic p. 119"}
   {:name :sound-vision, :prerequisites [#{:acute-hearing :keen-hearing}], :ref "Magic p. 171"}
   {:name :shrink-other, :prerequisites [[:advantages/magery 3] :shrink], :ref "Magic, p. 42"}
   {:name :resist-water, :prerequisites [#{:shape-water :umbrella} :destroy-water], :ref "Magic p. 186"}
   {:name :flaming-armor, :prerequisites [[:advantages/magery 1] :resist-fire :flame-jet], :ref "Magic p. 75"}
   {:name :mental-stun, :prerequisites [#{:daze :stun}], :ref "Magic p. 135"}
   {:name :costume, :prerequisites [:adjustable-clothing], :ref "Classic: Magic Item 3 p 30"}
   {:name :ambidexterity, :prerequisites [:grace], :ref "Magic, p. 39"}
   {:name :flesh-to-stone, :prerequisites [:earth-to-stone], :ref "Basic Set, p. 246}; Magic, p. 51"}
   {:name :timeslip, :prerequisites [:timeport], :ref "Magic p. 81"}
   {:name :slow, :prerequisites [[:advantages/magery 1] :haste :hinder], :ref "Magic p. 145"}
   {:name :hellspawn, :prerequisites [:summon-demon], :ref "GURPS Bio-Tech, p. 32}; Technomander p. 27"}
   {:name :nauseate, :prerequisites [:perfume [1 :other]], :ref "Magic, p. 38"}
   {:name :blur, :prerequisites [:darkness], :ref "Basic Set p. 250}; Magic p. 113"}
   {:name :create-fire-elemental, :prerequisites [[:advantages/magery 2] :control-fire-elemental], :ref "Magic p. 22"}
   {:name :rebuild, :prerequisites [[:advantages/magery 3] :repair :create-object [3 :air] [3 :water] [3 :fire] [3 :earth]], :ref "Magic p. 177"}
   {:name :body-of-stone, :prerequisites [:stone-to-flesh], :ref "Magic, p. 54"}
   {:name :emotion-control, :prerequisites [#{:mental-stun :loyalty}], :ref "Magic p. 137"}
   {:name :essential-water, :prerequisites [[6 :water]], :ref "Magic p. 189}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :remove-reflection, :prerequisites [:remove-shadow], :ref "Magic p. 113"}
   {:name :corpulence, :prerequisites [[:advantages/magery 2] :create-earth :create-water :alter-body [3 :body-control]], :ref "Magic, p. 43"}
   {:name :machine-control, :prerequisites [:reveal-function :locksmith :lightning], :ref "Magic p. 176"}
   {:name :planar-summons, :prerequisites [[:advantages/magery 1] :1-spell-from-10-colleges], :ref "Basic Set p. 247}; Magic p. 82"}
   {:name :sense-mana, :prerequisites [:detect-magic], :ref "Magic, p. 101"}
   ;;{:name :transference-bolt, :prerequisites [:any-three-of-ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :ref "Magic Styles: Dungeon Magic, p. 19"}
   {:name :avoid, :prerequisites [:hide :fear :forgetfulness], :ref "Magic p. 140"}
   {:name :suspend-magic, :prerequisites [:suspend-spell [8 :other]], :ref "Magic p. 123"}
   {:name :poltergeist, :prerequisites [:apportation], :ref "Magic p. 144"}
   {:name :share-energy, :prerequisites [:lend-energy], :ref "Magic p. 89"}
   {:name :scroll, :prerequisites [[:advantages/magery 1] [:skills/writing 12]], :ref "Magic p. 57"}
   {:name :contract-object, :prerequisites [[:advantages/magery 3] :transform-object], :ref "Magic p. 120"}
   {:name :mass-zombie, :prerequisites [:zombie :charisma-2+], :ref "Magic p. 153}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :glass-wall, :prerequisites [#{[5 :knowledge] :earth-vision}], :ref "Magic, p. 103"}
   {:name :slide, :prerequisites [:apportation :grease], :ref "Magic p. 145"}
   {:name :gauntness, :prerequisites [[:advantages/magery 2] :earth-to-air :destroy-water :hunger [3 :body-control]], :ref "Magic, p. 43"}
   {:name :prehistory, :prerequisites [:ancient-history], :ref "Magic, p. 104"}
   {:name :heat, :prerequisites [:create-fire :shape-fire], :ref "Basic Set, p. 247}; Magic p. 74"}
   {:name :beast-soother, :prerequisites [#{:persuasion :animal-empathy}], :ref "Magic p. 29"}
   {:name :mass-daze, :prerequisites [:daze [:attributes/int 13]], :ref "Basic Set p. 251}; Magic p. 137"}
   {:name :wizard-hand, :prerequisites [:manipulate :far-feeling], :ref "Magic, p. 104"}
   {:name :communication, :prerequisites [:wizard-eye :far-hearing :voices :simple-illusion], :ref "Magic, p. 48"}
   {:name :seek-emitter, :prerequisites [[:world/tl 6]], :ref "Classic: Technomanser p 17"}
   ;;{:name :stroke-of-lightning, :prerequisites [:ball-of-lightning :flaming-armor :rain-of-acid :breathe-fire :flaming-missiles :rain-of-fire :breathe-steam :flaming-weapon-rive :burning-touch :lightning-armor :shocking-touch :continual-sunlight :lightning-missiles :spark-cloud :explosive-fireball :lightning-stare :spark-storm :explosive-lightning :lightning-weapon :spit-acid :fire-cloud :lightning-whip :wall-of-lightning], :ref "Magic Styles: Dungeon Magic p. 19"}
   {:name :materialize, :prerequisites [:summon-spirit], :ref "Magic p. 150"}
   {:name :cure-radiation, :prerequisites [:resist-radiation :major-healing], :ref "Magic p. 182"}
   {:name :minor-healing, :prerequisites [:lend-vitality], :ref "Basic Set, p. 248}; Magic p. 91"}
   {:name :resist-cold, :prerequisites [:heat], :ref "Basic Set, p. 247}; Magic p. 74"}
   {:name :debility, :prerequisites [], :ref "Magic, p. 36"}
   {:name :breathe-steam, :prerequisites [[:advantages/magery 1] :steam-jet :resist-fire], :ref "Magic p. 192"}
   {:name :berserker, :prerequisites [:bravery], :ref "Magic p. 134"}
   {:name :magic-resistance, :prerequisites [[:advantages/magery 1] :1-spell-from-7-colleges], :ref "Magic p. 123"}
   {:name :devitalize-air, :prerequisites [:destroy-air], :ref "Magic p. 25"}
   {:name :deathtouch, :prerequisites [:wither-limb], :ref "Basic Set, p. 245}; Magic, p. 41"}
   {:name :sensitize, :prerequisites [[:advantages/magery 1] :stun], :ref "Magic, p. 39"}
   {:name :seeker, :prerequisites [[:advantages/magery 1] [:attributes/int 12] #{:seek-fire :seek-air :seek-earth :seek-water :seek-food :seek-pass :seek-gate :seek-magic :seek-plant :seek-machine :seek-power :seek-fuel :seek-radiation :seek-plastic :seek-coastline}], :ref "Basic Set, p. 249}; Magic, p. 105"}
   {:name :seek-plant :prerequisites [] :ref "GURPS Magic, p. 161}; GURPS Fantasy, p. 171"}
   {:name :maintain-spell, :prerequisites [:link], :ref "Magic p. 128}; Thaumatology: Urban Magics"}
   {:name :lend-language, :prerequisites [#{:beast-speech [3 :communication-and-empathy]}], :ref "Magic, p. 46"}
   {:name :cold, :prerequisites [:heat], :ref "Basic Set, p. 247}; Magic p. 74/Classic: Technomancer p. 21"}
   {:name :tanglefoot, :prerequisites [:clumsiness], :ref "Magic, p. 36"}
   {:name :perfect-illusion, :prerequisites [[:advantages/magery 1] :complex-illusion], :ref "Magic p. 96}; 'Social Engineering: Back to School, p. 24"}
   {:name :current, :prerequisites [[6 :water]], :ref "Magic p. 194"}
   {:name :invisibility, :prerequisites [[:advantages/magery 2] [:attributes/int 13]], :ref "Magic p. 114}; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :evisceration, :prerequisites [[:advantages/magery 3] :apportation :steal-vitality], :ref "Magic p. 154"}
   {:name :touch, :prerequisites [], :ref "Magic, p. 35"}
   {:name :scry-gate, :prerequisites [:seek-gate], :ref "Magic p. 85"}
   {:name :ice-slick, :prerequisites [:frost], :ref "Magic p. 186"}
   {:name :weaken-blood, :prerequisites [[:advantages/magery 1] #{:steal-vitality :sickness}], :ref "Magic, p. 40"}
   {:name :wall-of-lightning, :prerequisites [:lightning], :ref "Magic p. 197"}
   {:name :air-vision, :prerequisites [:shape-air], :ref "Magic p. 24"}
   {:name :choke, :prerequisites [[:advantages/magery 1] [5 :body-control] :spasm], :ref "Magic, p. 40"}
   {:name :despoil-seed, :prerequisites [[:advantages/magery 1] :alter-body :strike-barren], :ref "Alphabet Arcane, p. 17"}
   {:name :create-air, :prerequisites [:purify-air], :ref "Basic Set p. 243}; Magic p. 23"}
   {:name :great-voice, :prerequisites [:voices :thunderclap], :ref "Magic p. 173"}
   {:name :glitch, :prerequisites [:machine-control], :ref "Magic p. 178"}
   ;;{:name :necrovision, :prerequisites [:lightning :seek-emitter], :ref "Technomancer p 23"}
   {:name :telepathy, :prerequisites [:mind-sending], :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
   {:name :continual-light, :prerequisites [:light], :ref "Basic Set p. 249}; Magic p. 110"}
   {:name :reshape, :prerequisites [[:advantages/magery 1] :weaken #{:shape-earth :shape-plant}], :ref "Magic p. 117"}
   {:name :sickness, :prerequisites [#{[:advantages/magery 1] :drunkenness} :pestilence], :ref "Magic, p. 138"}
   {:name :animal-control, :prerequisites [:beast-soother], :ref "Magic p. 30"}
   {:name :lesser-geas, :prerequisites [[:advantages/magery 2] [10 :mind]], :ref "Magic p. 140}; Social Engineering: Back to School, p. 24"}
   {:name :body-of-water, :prerequisites [:shape-water], :ref "Magic p. 185"}
   {:name :create-food, :prerequisites [:cook :seek-food], :ref "GURPS Magic, p. 79}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :skull-spirit, :prerequisites [[4 :necromantic]], :ref "Magic p. 151"}
   {:name :youth, :prerequisites [[:advantages/magery 3] :halt-aging], :ref "Magic p. 94"}
   {:name :fascinate, :prerequisites [:daze], :ref "Magic p. 135"}
   {:name :concussion, :prerequisites [:shape-air :thunderclap], :ref "Magic p. 26"}
   ;;{:name :grasping-doom, :prerequisites [:mass-zombie], :ref "Magic Styles: Dungeon Magic, p. 15"}
   {:name :throw-spell, :prerequisites [:delay :catch-spell], :ref "Magic p. 128"}
   {:name :infravision, :prerequisites [#{:keen-vision [5 :light]}], :ref "Magic p. 111"}
   {:name :dream-sending, :prerequisites [#{:dream-viewing :sleep}], :ref "Magic, p. 45"}
   {:name :stench, :prerequisites [:purify-air], :ref "Basic Set p. 244}; Magic p. 23"}
   {:name :test-food, :prerequisites [], :ref "GURPS Magic, p. 77}; GURPS Fantasy, p. 169"}
   {:name :vexation, :prerequisites [:sense-emotion], :ref "Magic, p. 45"}
   {:name :remove-enchantment, :prerequisites [:enchant], :ref "Magic p. 58"}
   {:name :strike-blind, :prerequisites [:spasm [2 :light-and-darkness]], :ref "Magic, p. 38"}
   {:name :strike-numb, :prerequisites [:resist-pain], :ref "Magic, p. 40"}
   {:name :summon-earth-elemental, :prerequisites [[:advantages/magery 1] #{[[8 :earth]] [[4 :earth] #{:summon-water-elemental :summon-fire-elemental :summon-air-elemental}]}], :ref "Magic, p. 27"}
   {:name :lend-spell, :prerequisites [[:advantages/magery 1] :lend-skill :1-spell-from-6-colleges], :ref "Magic p. 126"}
   {:name :thirst, :prerequisites [[:advantages/magery 1] :debility :destroy-water], :ref "Magic, p. 38"}
   {:name :night-vision, :prerequisites [[5 :light-and-darkness] :keen-vision], :ref "Magic p. 111}; Fantasy, p. 170"}
   {:name :bravery, :prerequisites [:fear], :ref "Magic p. 134"}
   {:name :deflect-missile, :prerequisites [:apportation], :ref "GURPS Basic Set, p. 251}; GURPS Magic, p. 143"}
   {:name :lightning-stare, :prerequisites [:lightning :resist-lightning], :ref "Magic p. 198"}
   {:name :instant-regeneration, :prerequisites [[:advantages/magery 3] :regeneration], :ref "Magic p. 93"}
   {:name :foolishness, :prerequisites [[:attributes/int 12]], :ref "Basic Set p. 250}; Magic p. 134"}
   {:name :earthquake, :prerequisites [[:advantages/magery 2] [6 :earth] :earth-vision], :ref "Magic, p. 54"}
   {:name :control-fire-elemental, :prerequisites [:summon-fire-elemental], :ref "Magic p. 28"}
   {:name :shape-light, :prerequisites [:light], :ref "Magic p. 111"}
   {:name :share-vitality, :prerequisites [:lend-vitality], :ref "Magic p. 90"}
   {:name :glib-tongue, :prerequisites [:suggestion], :ref "Magic p. 141"}
   {:name :enchant, :prerequisites [[:advantages/magery 2] [:gate 1] [:body-control 1] [:movement 1] [:food 1] [:sound 1] [:illusion-and-creation 1] [:knowledge 1] [:protection-and-warning 1] [:meta 1] [:light-and-darkness 1]], :ref "Basic Set, p. 480}; Magic p. 56"}
   {:name :lightning-missiles, :prerequisites [:lightning-weapon], :ref "Magic p. 198"}
   {:name :mage-sense, :prerequisites [:detect-magic], :ref "Magic, p. 102"}
   {:name :scents-of-the-past, :prerequisites [[:advantages/magery 2] :history :odor], :ref "Magic, p. 107"}
   {:name :create-fire, :prerequisites [#{:seek-fire :ignite-fire}], :ref "Magic p. 72"}
   {:name :regeneration, :prerequisites [[:advantages/magery 2] :restoration], :ref "Magic p. 93"}
   {:name :shape-darkness, :prerequisites [:darkness], :ref "Magic p. 113"}
   {:name :leak, :prerequisites [:hideaway], :ref "Magic p. 61"}
   {:name :light-jet, :prerequisites [#{:continual-light :shape-light}], :ref "Magic p. 112"}
   {:name :burning-death, :prerequisites [[:advantages/magery 2] :heat :sickness], :ref "Magic p. 76"}
   {:name :mind-reading, :prerequisites [#{:truthsayer :borrow-language}], :ref "Basic Set, p. 245}; Magic, p. 46; Social Engineering: Back to School, p. 24"}
   {:name :insignificance, :prerequisites [:persuasion :avoid], :ref "Magic, p. 48"}
   {:name :winged-knife, :prerequisites [:poltergeist], :ref "Magic p. 145"}
   {:name :decay, :prerequisites [:test-food], :ref "GURPS Magic, p. 77"}
   {:name :create-spring, :prerequisites [:dry-spring :shape-water], :ref "Magic p. 190"}
   {:name :control-limb, :prerequisites [[:advantages/magery 1] [5 :body-control] :spasm], :ref "Magic, p. 40}; Classic Grimoire p 14"}
   {:name :smoke, :prerequisites [:shape-fire :extinguish-fire], :ref "Magic p. 73"}
   {:name :relieve-addiction, :prerequisites [:neutralize-poison], :ref "Magic p. 92|-"}
   {:name :illusion-shell, :prerequisites [:simple-illusion], :ref "Magic p. 96}; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
   ;;{:name :seek-number, :prerequisites [[:advantages/magery 1] [:world/tl 6]], :ref "Technomancer p. 18"}
   {:name :mage-stealth, :prerequisites [:hush], :ref "Magic p. 172"}
   {:name :disintegrate, :prerequisites [[:advantages/magery 2] :shatter :ruin :earth-to-air :destroy-air :destroy-water], :ref "Magic p. 120"}
   {:name :timeport-other, :prerequisites [:timeport], :ref "Magic p. 81"}
   {:name :teleport, :prerequisites [#{:hawk-flight [:attributes/int 15]} :1-spell-from-10-colleges], :ref "Magic p. 147}; Fantasy, p. 171"}
   {:name :terror, :prerequisites [:fear], :ref "Magic p. 134"}
   {:name :sandstorm, :prerequisites [:windstorm :create-earth], :ref "Magic p. 27"}
   {:name :know-true-shape, :prerequisites [[:advantages/magery 1] #{:shapeshifting :alter-visage :alter-body :plant-form :shrink :shrink-other} #{:know-illusion :aura}], :ref "Magic, p. 104"}
   {:name :wither-limb, :prerequisites [[:advantages/magery 2] :paralyze-limb], :ref "Basic Set, p. 244}; Magic, p. 40"}
   {:name :wizard-nose, :prerequisites [:apportation :far-tasting], :ref "Magic, p. 104"}
   {:name :neutralize-poison, :prerequisites [[:advantages/magery 3] #{:cure-disease :test-food}], :ref "Magic p. 92"}
   {:name :dispel-illusion, :prerequisites [:control-illusion], :ref "Magic p. 97"}
   {:name :detect-poison, :prerequisites [#{:sense-danger :test-food}], :ref "Magic p. 166"}
   {:name :impression-blocker, :prerequisites [:enchant :seeker :scrywall], :ref "Magic p. 60"}
   {:name :wizard-mouth, :prerequisites [:apportation :far-tasting :great-voice], :ref "Magic, p. 104"}
   {:name :fireball, :prerequisites [[:advantages/magery 1] :create-fire :shape-fire], :ref "Basic Set, p. 247}; Magic p. 74"}
   {:name :watchdog, :prerequisites [:sense-danger], :ref "Magic p. 167}; Thaumatology: Urban Magics, p. 33"}
   {:name :spell-wall, :prerequisites [:spell-shield], :ref "Magic p. 124}; Thaumatology: Urban Magics"}
   {:name :clouds, :prerequisites [[2 :water] [2 :air]], :ref "Magic p. 194"}
   {:name :beast-possession, :prerequisites [#{:possession :rider-within}], :ref "Magic p. 32"}
   {:name :grace, :prerequisites [:clumsiness], :ref "Magic, p. 37"}
   {:name :water-vision, :prerequisites [:shape-water], :ref "Magic, p. 187"}
   {:name :imp-face, :prerequisites [[:advantages/magery 1] :planar-summons :alter-visage], :ref "Alphabet Arcane, p. 17"}
   {:name :boost-health, :prerequisites [:vigor], :ref "Magic, p. 37"}
   {:name :loyalty, :prerequisites [:bravery [2 :mind-control]], :ref "Magic p. 136"}
   {:name :see-secrets, :prerequisites [:seeker :aura], :ref "Magic, p. 105}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :create-warrior, :prerequisites [:create-servant], :ref "Magic p. 98"}
   {:name :explode, :prerequisites [[:advantages/magery 2] :shatter :apportation], :ref "Magic p. 118"}
   {:name :teleport-shield, :prerequisites [:watchdog #{:teleport :spell-shield}], :ref "Magic p. 170"}
   {:name :create-ice, :prerequisites [:freeze], :ref "Magic p. 188}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :create-earth-elemental, :prerequisites [[:advantages/magery 2] :control-earth-elemental], :ref "Magic, p. 22"}
   {:name :daze, :prerequisites [:foolishness], :ref "Basic Set'', p. 250}; Magic p. 134"}
   {:name :flight, :prerequisites [[:advantages/magery 2] :levitation], :ref "Magic p. 145}; Fantasy, p. 171"}
   {:name :spell-stone, :prerequisites [:enchant :delay], :ref "Magic p. 60"}
   {:name :plane-shift-other, :prerequisites [[:advantages/magery 3] :plane-shift], :ref "Magic p. 83"}
   {:name :seek-air, :prerequisites [], :ref "Magic p. 23"}
   {:name :great-healing, :prerequisites [[:advantages/magery 3] :major-healing], :ref "Basic Set, p. 248}; Magic p. 91"}
   {:name :schematic, :prerequisites [:reveal-function :history], :ref "Magic, p. 177"}
   {:name :displace-spell, :prerequisites [:suspend-magic], :ref "Magic p. 124, Thaumatology: Urban Magics"}
   {:name :earth-to-water, :prerequisites [[:advantages/magery 1] :create-water :shape-earth], :ref "Magic, p. 52"}
   {:name :rotting-death, :prerequisites [[:advantages/magery 2] :sickness :pestilence], :ref "Magic p. 154"}
   {:name :lend-skill, :prerequisites [:mind-sending [:attributes/int 11]], :ref "Magic, p. 47}; Social Engineering: Back to School, p. 24"}
   {:name :see-invisible, :prerequisites [#{:invisibility :infravision :dark-vision}], :ref "Magic p. 113"}
   {:name :alertness, :prerequisites [[:advantages/magery 2] :create-acid], :ref "Magic p. 133}; Classic: Magic p 69"}
   {:name :machine-summoning, :prerequisites [:machine-control], :ref "Magic, p. 176"}
   {:name :permanent-beast-possession, :prerequisites [[:advantages/magery 2] :beast-possession], :ref "Magic p. 32"}
   {:name :master, :prerequisites [:beast-soother], :ref "Magic p. 30"}
   {:name :mud-jet, :prerequisites [#{[:water-jet :create-earth] [:create-water :sand-jet]}], :ref "Magic, p. 52"}
   {:name :water-jet :prerequisites [:shape-water] :ref "GURPS Magic, p. 187"}
   {:name :strike-dumb, :prerequisites [:spasm], :ref "Magic, p. 38"}
   {:name :mirror, :prerequisites [:colors], :ref "Magic p. 112"}
   {:name :planar-visit, :prerequisites [[:advantages/magery 2] #{:planar-summons :projection}], :ref "Magic p. 82"}
   {:name :apportation, :prerequisites [[:advantages/magery 1]], :ref "Basic Set, p. 251}; Magic p. 142"}
   {:name :control-air-elemental, :prerequisites [:summon-air-elemental], :ref "Magic p. 28"}
   {:name :stone-to-flesh, :prerequisites [[:advantages/magery 2] :flesh-to-stone :stone-to-earth], :ref "Basic Set, p. 246}; Magic, p. 53"}
   {:name :quick-march, :prerequisites [[:advantages/magery 1] :haste], :ref "Magic p. 144}; Fantasy, p. 171"}
   {:name :essential-flame, :prerequisites [[6 :fire]], :ref "Magic p. 75"}
   ;;{:name :mind-over-matter, :prerequisites [[:advantages/magery 2] [1 :divination]], :ref "Magic Styles: Dungeon Magic, p. 27"}
   {:name :sanctuary, :prerequisites [:hide-object], :ref "Magic p. 86"}
   {:name :light, :prerequisites [], :ref "Basic Set p. 253}; Magic p. 110"}
   {:name :pull, :prerequisites [[:advantages/magery 2] [4 :movement] :levitation], :ref "Magic p. 146"}
   {:name :spell-shield, :prerequisites [[:advantages/magery 2] :scryguard :magic-resistance], :ref "Magic p. 124"}
   {:name :flesh-to-ice, :prerequisites [[:advantages/magery 1] :frostbite :body-of-water], :ref "Magic p. 190"}
   {:name :drain-mana, :prerequisites [:dispel-magic :suspend-mana], :ref "Magic p. 127"}
   {:name :resist-acid, :prerequisites [:create-acid], :ref "Magic p. 190"}
   {:name :permanent-machine-possession, :prerequisites [[:advantages/magery 3] :machine-possession], :ref "Magic p. 178"}
   {:name :no-smell, :prerequisites [:purify-air], :ref "Basic Set p. 243}; Magic p. 24"}
   {:name :sense-life, :prerequisites [], :ref "Magic, p. 45"}
   {:name :create-earth, :prerequisites [:earth-to-stone], :ref "Basic Set, p. 246}; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :strike-deaf, :prerequisites [:spasm [2 :sound]], :ref "Magic, p. 38"}
   {:name :hideaway, :prerequisites [:enchant :create-object :lighten], :ref "Magic p. 66}; Thaumatology: Urban Magics, p. 33"}
   {:name :lightning-armor, :prerequisites [[6 :lightning] :resist-lightning], :ref "Magic p. 198"}
   {:name :body-of-flames, :prerequisites [:breathe-fire], :ref "Magic p. 76"}
   {:name :wall-of-silence, :prerequisites [:silence], :ref "Magic p. 172"}
   {:name :lend-vitality, :prerequisites [:lend-energy], :ref "Basic Set, p. 248}; Magic p. 89"}
   {:name :control-water-elemental, :prerequisites [:summon-water-elemental], :ref "Magic p. 28"}
   {:name :will-lock, :prerequisites [:emotion-control], :ref "Magic p. 138"}
   {:name :fog, :prerequisites [:shape-water], :ref "Basic Set, p. 253}; Magic p. 193"}
   {:name :suspend-spell, :prerequisites [[:advantages/magery 1]], :ref "Magic p. 121}; Thaumatology: Urban Magics"}
   {:name :stun, :prerequisites [:pain], :ref "Magic, p. 37"}
   ;;{:name :sovereign-ward, :prerequisites [[:advantages/magery 3] :dispel-magic :ward], :ref "Magic Styles: Dungeon Magic, p. 28"}
   {:name :garble, :prerequisites [:voices], :ref "Magic p. 172"}
   {:name :command-spirit, :prerequisites [:summon-spirit :turn-spirit], :ref "Magic p. 153"}
   {:name :nightmare, :prerequisites [[:advantages/magery 2] :death-vision :fear :sleep], :ref "Magic p. 140"}
   {:name :mass-sleep, :prerequisites [:sleep [:attributes/int 13]], :ref "Basic Set p. 251}; Magic p. 137"}
   {:name :flame-jet, :prerequisites [:create-fire :shape-fire], :ref "Magic p. 73"}
   {:name :musical-scribe, :prerequisites [:scribe], :ref "Magic p. 174"}
   {:name :hold-fast, :prerequisites [:apportation], :ref "Magic p. 143"}
   {:name :find-direction, :prerequisites [[:advantages/magery 1]], :ref "Magic, p. 101"}
   {:name :enlarge-other, :prerequisites [[:advantages/magery 3] :enlarge], :ref "Magic, p. 43}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :fear, :prerequisites [#{:sense-emotion :empathy}], :ref "Magic p. 139}; Fantasy, p. 171"}
   {:name :rider, :prerequisites [:animal-control], :ref "Magic p. 31"}
   {:name :sleep, :prerequisites [:daze], :ref "Basic Set p. 251}; Magic p. 135"}
   {:name :soul-rider, :prerequisites [:mind-reading], :ref "Magic, p. 49"}
   {:name :healing-slumber, :prerequisites [[:advantages/magery 2] :sleep :minor-healing], :ref "Magic p. 94"}
   {:name :keen-hearing, :prerequisites [], :ref "Magic p. 133"}
   {:name :darkness, :prerequisites [:continual-light], :ref "Basic Set p. 250}; Magic p. 111"}
   {:name :repel, :prerequisites [[:advantages/magery 2] [4 :movement] :levitation], :ref "Magic p. 146"}
   {:name :resist-pressure, :prerequisites [:weather-dome], :ref "Magic p. 169"}
   {:name :wall-of-wind, :prerequisites [:shape-air], :ref "Magic p. 25"}
   {:name :slow-fall, :prerequisites [:apportation], :ref "Magic p. 144"}
   {:name :control-gate, :prerequisites [[:advantages/magery 3] :seek-gate], :ref "Magic p. 85"}
   {:name :sense-foes, :prerequisites [], :ref "Basic Set, p. 245}; Magic, p. 44"}
   {:name :instant-neutralize-poison, :prerequisites [[:advantages/magery 2] :neutralize-poison], :ref "Magic p. 92"}
   {:name :beast-link, :prerequisites [:beast-summoning], :ref "Magic p. 30"}
   {:name :weather-dome, :prerequisites [:2-from-each-of-4-elements], :ref "Magic p. 169"}
   ;;{:name :mana-vortex, :prerequisites [[:advantages/magery 2] :lend-energy :sense-danger], :ref "Magic Styles: Dungeon Magic, p. 27}; Thaumatology: Urban Magics"}
   {:name :reconstruct-spell, :prerequisites [[:advantages/magery 2] :history :identify-spell], :ref "Magic, p. 104"}
   {:name :voices, :prerequisites [:sound], :ref "Magic p. 172"}
   {:name :fast-fire, :prerequisites [:slow-fire], :ref "Magic p. 73"}
   {:name :glow, :prerequisites [:continual-light], :ref "Magic p. 112"}
   {:name :sunbolt, :prerequisites [[6 :light-and-darkness] :sunlight], :ref "Magic p. 114"}
   {:name :shapeshifting, :prerequisites [[:advantages/magery 1] [6 :animal]], :ref "Magic p. 32-33"}
   {:name :purify-air, :prerequisites [], :ref "Basic Set p. 243}; Magic p. 23; Classic: Technomanser p 17"}
   {:name :instant-restoration, :prerequisites [[:advantages/magery 2] :restoration], :ref "Magic p. 93"}
   {:name :flaming-weapon, :prerequisites [[:advantages/magery 2] :heat], :ref "Magic p. 75"}
   {:name :extinguish-fire, :prerequisites [:ignite-fire], :ref "Basic Set, p. 247}; Magic p. 72"}
   {:name :hunger, :prerequisites [[:advantages/magery 1] :debility :decay], :ref "Magic, p. 38"}
   {:name :resist-enchantment, :prerequisites [], :ref "Magic p. 58"}
   {:name :dullness, :prerequisites [:dull], :ref "Magic p. 134"}
   {:name :jump, :prerequisites [:apportation], :ref "Magic p. 143"}
   {:name :teleport-other, :prerequisites [[:advantages/magery 3] :teleport], :ref "Magic p. 147"}
   {:name :machine-speech, :prerequisites [:machine-summoning], :ref "Magic, p. 176"}
   {:name :keen, :prerequisites [], :ref "Magic p. 133"}
   ;;{:name :discord, :prerequisites [[:advantages/magery 2] :emotion-control :vexation], :ref "Magic Styles: Dungeon Magic, p. 31"}
   {:name :ball-of-lightning, :prerequisites [:apportation :lightning], :ref "Magic p. 197"}
   {:name :resurrection, :prerequisites [:instant-regeneration :summon-spirit], :ref "Magic p. 94"}
   {:name :steelwraith, :prerequisites [[:advantages/magery 2] :walk-through-earth], :ref "Magic, p. 54}; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
   {:name :burning-touch, :prerequisites [[:advantages/magery 2] [6 :fire] :heat], :ref "Magic p. 76"}
   {:name :metal-vision, :prerequisites [:shape-metal], :ref "Magic, p. 183"}
   {:name :body-of-shadow, :prerequisites [[:advantages/magery 2] :shape-darkness], :ref "M114"}
   {:name :rain, :prerequisites [:clouds], :ref "Magic p. 195}; Fantasy p. 168"}
   {:name :control-creation, :prerequisites [#{:create-servant :create-animal}], :ref "Magic p. 99"}
   {:name :lich, :prerequisites [[:advantages/magery 3] [:attributes/int 13] :enchant :soul-jar :zombie], :ref "Magic p. 159"}
   {:name :find-weakness, :prerequisites [[1 :fire] [1 :water] [1 :air] [1 :earth]], :ref "Magic p. 116"}
   {:name :prepare-game, :prerequisites [:purify-food], :ref "GURPS Magic, p. 78"}
   {:name :shade, :prerequisites [#{:shield :continual-light}], :ref "Magic p. 169"}
   {:name :blackout, :prerequisites [:darkness], :ref "Magic p. 112"}
   {:name :breathe-water, :prerequisites [:create-air :destroy-water], :ref "Basic Set p. 250}; Magic p. 189"}
   {:name :projection, :prerequisites [:sense-spirit [4 :knowledge]], :ref "Magic, p. 105"}
   ;;{:name :mind-whip, :prerequisites [[:advantages/magery 2] :telepathy :thunderclap], :ref "Magic Styles: Dungeon Magic, p. 24"}
   {:name :reflect, :prerequisites [:ward], :ref "Magic p. 122}; Thaumatology: Urban Magics"}
   {:name :lightning-weapon, :prerequisites [[:advantages/magery 2] :lightning], :ref "Magic p. 198"}
   {:name :hair-growth, :prerequisites [[5 :body-control]], :ref "Magic, p. 39"}
   {:name :earth-to-stone, :prerequisites [[:advantages/magery 1] :shape-earth], :ref "Magic, p. 51}; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
   {:name :toughen, :prerequisites [:shatterproof], :ref "Magic p. 119"}
   {:name :body-of-lightning, :prerequisites [[:advantages/magery 2] :lightning], :ref "Magic p. 198"}
   {:name :plant-vision, :prerequisites [:shape-plant], :ref "Magic, p. 162"}
   {:name :remove-aura, :prerequisites [:dispel-magic :aura], :ref "Magic p. 127"}
   {:name :stop-paralysis, :prerequisites [#{[:minor-healing :paralyze-limb] :strike-dumb}], :ref "Magic p. 93"}
   {:name :poison-food, :prerequisites [:purify-food :decay], :ref "GURPS Magic, p. 78"}
   {:name :fumble, :prerequisites [:clumsiness], :ref "Magic, p. 38"}
   {:name :breathe-fire, :prerequisites [[:advantages/magery 1] :flame-jet :resist-fire], :ref "Magic p. 76"}
   {:name :message, :prerequisites [:great-voice :seeker], :ref "Magic, p. 173"}
   {:name :lighten-burden, :prerequisites [:apportation], :ref "Magic p. 143}; Fantasy, p. 171"}
   {:name :body-reading, :prerequisites [#{:awaken :sense-life}], :ref "Magic p. 91"}
   {:name :mindlessness, :prerequisites [[:advantages/magery 2] :forgetfulness], :ref "Magic p. 137"}
   {:name :transparency, :prerequisites [:dye :stone-to-earth], :ref "Magic p. 119"}
   {:name :machine-possession, :prerequisites [:machine-control #{:rider-within :soul-rider}], :ref "Magic p. 178"}
   {:name :ice-sphere, :prerequisites [:shape-water], :ref "Magic p. 186"}
   {:name :shape-water, :prerequisites [:create-water], :ref "Magic p. 186"}
   {:name :create-air-elemental, :prerequisites [[:advantages/magery 2] :control-air-elemental], :ref "Magic p. 22"}
   ;;{:name :disrupt, :prerequisites [[:advantages/magery 2] :concussion :sound-jet :secret-spell], :ref "Magic Styles: Dungeon Magic p. 23"}
   {:name :affect-spirits, :prerequisites [:solidify], :ref "Magic p. 151"}
   {:name :restore-sight, :prerequisites [:minor-healing #{:keen-vision :strike-blind}], :ref "Magic p. 92"}
   {:name :sunlight, :prerequisites [[:advantages/magery 1] :glow :colors], :ref "Magic p. 114"}
   {:name :dark-vision, :prerequisites [:continual-light], :ref "Magic p. 111"}
   {:name :steal-spell, :prerequisites [:lend-spell :great-ward], :ref "Magic p. 127"}
   {:name :malefice, :prerequisites [:enchant :seeker], :ref "Magic p. 60"}
   {:name :clean, :prerequisites [:restore], :ref "Magic p. 116}; Classic: Technomancer p 25"}
   {:name :extend-object, :prerequisites [[:advantages/magery 3] :transform-object], :ref "Magic p. 120"}
   {:name :long-march, :prerequisites [[:advantages/magery 1] #{:clumsiness :debility}], :ref "Magic p. 143"}
   {:name :borrow-language, :prerequisites [:lend-language], :ref "Magic, p. 46"}
   {:name :complex-illusion, :prerequisites [:sound :simple-illusion], :ref "Magic p. 96}; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
   {:name :wallwalker, :prerequisites [:apportation], :ref "Magic p. 144"}
   {:name :purify-food, :prerequisites [:decay], :ref "GURPS Magic, p. 78"}
   {:name :retch, :prerequisites [:nauseate :spasm], :ref "Magic, p. 38"}
   {:name :hawk-vision, :prerequisites [#{:keen-vision [5 :light-and-darkness]}], :ref "Magic p. 111"}
   {:name :wither-plant :prerequisites [:blight] :ref "GURPS Magic, p. 163"}
   {:name :walk-through-wood :prerequisites [:walk-through-plants] :ref "GURPS Magic, p. 164"}
   {:name :walk-through-plants :prerequisites [:hide-path :shape-plant] :ref "GURPS Magic, p. 163"}
   {:name :tangle-growth :prerequisites [:plant-growth] :ref "GURPS Magic, p. 162"}
   {:name :shape-plant :prerequisites [:identify-plant] :ref "GURPS Magic, p. 161"}
   {:name :seek-plant :prerequisites [] :ref "GURPS Magic, p. 161}; GURPS Fantasy, p. 171"}
   {:name :rejuvenate-plant :prerequisites [[:advantages/magery 1] :plant-growth] :ref "GURPS Magic, p. 163"}
   {:name :rain-of-nutes :prerequisites [[:advantages/magery 1] [6 :plant] :shape-plant] :ref "GURPS Magic, p. 165"}
   {:name :purify-earth :prerequisites [:create-earth :plant-growth] :ref "GURPS Magic, p. 54"}
   {:name :pollen-cloud :prerequisites [:shape-plant] :ref "GURPS Magic, p. 162"}
   {:name :plant-vision :prerequisites [:shape-plant] :ref "GURPS Magic, p. 162"}
   {:name :plant-speech :prerequisites [[:advantages/magery 1] :plant-sense] :ref "GURPS Magic, p. 164"}
   {:name :plant-sense :prerequisites [:forest-warning :hide-path] :ref "GURPS Magic, p. 163"}
   {:name :plant-growth :prerequisites [:heal-plant] :ref "GURPS Magic, p. 162"}
   {:name :plant-form-other :prerequisites [[:advantages/magery 2] :plant-form] :ref "GURPS Magic, p. 165"}
   {:name :plant-form :prerequisites [[:advantages/magery 1] [6 :plant]] :ref "GURPS Magic, p. 164"}
   {:name :plant-control :prerequisites [:plant-sense] :ref "GURPS Magic, p. 164"}
   {:name :identify-plant :prerequisites [:seek-plant] :ref "GURPS Magic, p. 161}; GURPS Fantasy, p. 171"}
   {:name :hide-path :prerequisites [:heal-plant] :ref "GURPS Magic, p. 162"}
   {:name :heal-plant :prerequisites [:identify-plant] :ref "GURPS Magic, p. 161}; GURPS Fantasy, p. 171"}
   {:name :forest-warning :prerequisites [#{:sense-danger [4 :plant]}] :ref "GURPS Magic, p. 162"}
   {:name :false-tracks :prerequisites [:shape-plant :shape-earth] :ref "GURPS Magic, p. 163"}
   {:name :essential-wood :prerequisites [[6 :plant]] :ref "GURPS Magic, p. 164"}
   {:name :create-plant :prerequisites [[:advantages/magery 1] :plant-growth] :ref "GURPS Magic, p. 163"}
   {:name :conceal :prerequisites [:plant-growth] :ref "GURPS Magic, p. 162"}
   {:name :body-of-wood :prerequisites [[:advantages/magery 2] :plant-form] :ref "GURPS Magic, p. 165"}
   {:name :body-of-slime :prerequisites [[:advantages/magery 2] :plant-form :shape-water] :ref "GURPS Magic, p. 165"}
   {:name :blossom :prerequisites [:plant-growth] :ref "GURPS Magic, p. 162"}
   {:name :blight :prerequisites [:plant-growht] :ref "GURPS Magic, p. 162"}
   {:name :bless-plants :prerequisites [:heal-plant] :ref "GURPS Magic, p. 161}; GURPS Fantasy, p. 172"}
   {:name :arboreal-immurement :prerequisites [[:advantages/magery 2] :walk-through-wood] :ref "GURPS Magic, p. 165"}
   {:name :animate-plant :prerequisites [[7 :plant]] :ref "GURPS Magic, p. 164"}
   {:name :mind-search, :prerequisites [:mind-reading], :ref "Magic, p. 46"}])

(def spells-by-name
  (reduce (fn [acc kv] (assoc acc (:name kv) (dissoc kv :name))) spells))

(def spells-by-college
  {:fire #{:warmth :resist-fire :seek-fire :flaming-missiles :rain-of-fire :summon-fire-elemental :explosive-fireball :slow-fire :deflect-energy :fire-cloud :phantom-flame :shape-fire :blast-ball :fireproof :ignite-fire :flaming-armor :create-fire-elemental :heat :resist-cold :cold :control-fire-elemental :create-fire :burning-death :smoke :fireball :essential-flame :body-of-flames :flame-jet :fast-fire :flaming-weapon :extinguish-fire :burning-touch :breathe-fire},
   :necromantic #{:slow-healing :awaken-craft-spirit :astral-vision :soul-prison :animation :age :pestilence :bind-spirit :banish :animate-shadow :soul-jar :repel-spirits :astral-block :death-vision :final-rest :entrap-spirit :sense-spirit :control-zombie :solidify :hellspawn :mass-zombie :materialize :evisceration :skull-spirit :grasping-doom :burning-death :rotting-death :command-spirit :resurrection :lich :affect-spirits},
   :movement #{:swim :transfer-pregnancy :cloud-walking :blink :lockmaster :manipulate :blink-other :great-haste :beacon :glue :hinder :flying-carpet :rapid-journey :locksmith :levitation :freedom :dancing-object :air-vortex :ethereal-body :remove-fetus :distant-blow :hawk-flight :trace-teleport :haste :divert-teleport :light-tread :cloud-vaulting :undo :slow :poltergeist :slide :wizard-hand :deflect-missile :winged-knife :teleport :flight :apportation :quick-march :pull :hold-fast :repel :slow-fall :jump :teleport-other :lighten-burden :long-march :wallwalker},
   :sound #{:sound :wizard-ear :delayed-message :far-hearing :silver-tongue :resist-sound :invisible-wizard-ear :imitate-voice :converse :thunderclap :silence :echoes-of-the-past :alter-voice :noise :scribe :sound-jet :hush :sound-vision :great-voice :concussion :mage-stealth :wizard-mouth :wall-of-silence :garble :musical-scribe :keen-hearing :voices :message :disrupt},
   :knowledge #{:small-vision :astral-vision :alarm :wizard-ear :far-hearing :tell-time :far-feeling :detect-magic :know-recipe :identify-spell :analyze-magic :remember-path :seek-magic :trace :echoes-of-the-past :memorize :history :tell-position :summon-shade :know-location :ancient-history :recall :earth-vision :plastic-vision :aura :mage-sight :test-load :measurement :divination :invisible-wizard-eye :pathfinder :wizard-eye :far-tasting :images-of-the-past :sense-mana :glass-wall :prehistory :wizard-hand :seeker :air-vision :necrovision :mage-sense :scents-of-the-past :seek-number :know-true-shape :wizard-nose :wizard-mouth :water-vision :see-secrets :schematic :mind-over-matter :find-direction :reconstruct-spell :metal-vision :projection :plant-vision},
   :meta #{:spellguard :suspend-magery :counterspell :hang-spell :restore-mana :ward :remove-curse :dispel-magic :scryguard :curse :catch-spell :raise-cone-of-power :seek-magic :suspend-curse :great-ward :scrywall :telecast :false-aura :penetrating-spell :drain-magery :bless :suspend-mana :conceal-magic :pentagram :suspend-magic :magic-resistance :maintain-spell :throw-spell :lend-spell :spell-wall :displace-spell :spell-shield :drain-mana :suspend-spell :sovereign-ward :mana-vortex :reflect :remove-aura :steal-spell},
   :air #{:shape-air :lightning-whip :predict-weather :destroy-air :cool :spark-cloud :earth-to-air :explosive-lightning :breathe-air :spark-storm :summon-air-elemental :lightning :air-vortex :storm :resist-lightning :body-of-wind :walk-on-air :purify-signal :windstorm :air-jet :wind :essential-air :atmosphere-dome :snow :warm :odor :shocking-touch :body-of-air :stroke-of-lightning :devitalize-air :wall-of-lightning :air-vision :create-air :concussion :stench :lightning-stare :lightning-missiles :sandstorm :clouds :seek-air :control-air-elemental :no-smell :lightning-armor :wall-of-wind :purify-air :ball-of-lightning :rain :breathe-water :lightning-weapon :body-of-lightning :create-air-elemental},
   :enchantment #{:curse-virus :great-wish :simulacrum :suspend-enchantment :lesser-wish :speed :doppelganger :adjustable-clothing :golem :wish :ensorcel :amulet :talisman :temporary-enchantment :power :hex :costume :scroll :remove-enchantment :enchant :leak :impression-blocker :spell-stone :hideaway :resist-enchantment :malefice},
   :healing #{:suspended-animation :stop-spasm :recover-energy :remove-contagion :cleansing :awaken :major-healing :relieve-paralysis :relieve-madness :halt-aging :cure-disease :resist-poison :restore-speech :restore-hearing :restoration :relieve-sickness :final-rest :restore-memory :resist-disease :lend-energy :stop-bleeding :transference-bolt :share-energy :cure-radiation :minor-healing :youth :instant-regeneration :share-vitality :regeneration :relieve-addiction :neutralize-poison :detect-poison :great-healing :lend-vitality :healing-slumber :instant-neutralize-poison :instant-restoration :resurrection :stop-paralysis :body-reading :restore-sight},
   :light-and-darkness #{:small-vision :mass-invisibility :mage-light :gloom :continual-mage-light :wall-of-light :bright-vision :continual-sunlight :flash :colors :remove-shadow :disruption-bolt :hide :images-of-the-past :blur :remove-reflection :invisibility :continual-light :infravision :night-vision :shape-light :shape-darkness :light-jet :see-invisible :mirror :light :darkness :glow :sunbolt :body-of-shadow :shade :blackout :sunlight :dark-vision :hawk-vision},
   :food #{:cook :know-recipe :essential-food :water-to-wine :preserve-food :fool's-banquet :mature :seek-food :foul-water :season :far-tasting :create-food :test-food :thirst :scents-of-the-past :decay :wizard-nose :wizard-mouth :hunger :prepare-game :poison-food :purify-food},
   :communication-and-empathy #{:exchange-bodies :mind-sending :broadcast-spell :persuasion :presence :switch-bodies :hide-emotion :gift-of-tongues :dream-viewing :control-person :hide-thoughts :possession :gift-of-letters :dispel-possession :compel-lie :sense-emotion :truthsayer :retrogression :dream-projection :borrow-skill :compel-truth :permanent-possession :communication :lend-language :telepathy :dream-sending :vexation :mind-reading :insignificance :lend-skill :sense-life :soul-rider :sense-foes :machine-speech :mind-whip :message :borrow-language :mind-search},
   :earth #{:stone-to-earth :essential-earth :control-earth-elemental :volcano :alter-terrain :partial-petrification :move-terrain :rain-of-stones :purify-earth :earth-to-air :predict-earth-movement :seek-earth :seek-pass :sand-jet :entombment :shape-stone :shape-earth :walk-through-earth :earth-vision :stone-missile :flesh-to-stone :body-of-stone :summon-earth-elemental :earthquake :sandstorm :create-earth-elemental :earth-to-water :mud-jet :stone-to-flesh :create-earth :steelwraith :earth-to-stone},
   :gate #{:phase-other :hide-object :blink :blink-other :timeslip-other :timeport :beacon :rapid-journey :accelerate-time :seek-gate :create-door :suspend-time :phase :plane-shift :time-out :trace-teleport :divert-teleport :slow-time :timeslip :planar-summons :scry-gate :timeport-other :teleport :teleport-shield :plane-shift-other :planar-visit :sanctuary :control-gate :teleport-other},
   :animal #{:repel-animal :great-shapeshift :repel-hybrids :protect-animal :shapeshift-others :beast-summoning :spider-silk :beast-speech :permanent-shapeshifting :partial-shapeshifting :beast-rouser :rider-within :beast-seeker :beast-soother :animal-control :beast-possession :permanent-beast-possession :master :rider :beast-link :shapeshifting},
   :making-and-breaking #{:weaken :awaken-craft-spirit :copy :shatterproof :knot :stiffen :mapmaker :transform-object :soilproof :dye :ruin :fasten :restore :inspired-creation :shatter :rejoin :inscribe :repair :animate-object :mystic-mark :draw-together-shards :sharpen :rive :enlarge-object :shrink-object :weapon-self :rebuild :contract-object :reshape :disintegrate :explode :find-weakness :toughen :transparency :clean :extend-object},
   :protection-and-warning #{:utter-wall :warmth :protect-animal :sense-danger :resist-sound :mystic-mist :nightingale :reverse-missiles :missile-shield :shield :turn-blade :resist-lightning :resist-radiation :resist-poison :return-missile :umbrella :reflect-gaze :utter-dome :resist-disease :sense-observation :resist-water :watchdog :teleport-shield :resist-acid :resist-pressure :weather-dome :shade},
   :water #{:shape-water :seek-water :purify-water :water-jet :acid-ball :icy-missile :dehydrate :condense-steam :ice-vision :body-of-ice :frost :geyser :freeze :frostbite :dry-spring :distill :ice-dagger :essential-acid :create-steam :icy-breath :flow :coolness :breathe-air :acid-jet :create-water-elemental :boil-water :create-water :icy-touch :destroy-water :icy-weapon :create-acid :hail :foul-water :infiltrate :essential-water :breathe-steam :current :ice-slick :body-of-water :create-spring :create-ice :earth-to-water :flesh-to-ice :control-water-elemental :fog :breathe-water :mud-jet :ice-sphere},
   :mind-control #{:mass-charm :hallucination :permanent-madness :great-hallucination :forgetfulness :mass-suggestion :oath :panic :wisdom :charm :false-memory :rear-vision :ecstasy :relieve-madness :mass-hallucination :enslave :enthrall :memorize :command :compel-lie :suggestion :strengthen-will :boost-intelligence :encrypt :pacify :vigil :dream-projection :peaceful-sleep :recall :dull :weaken-will :permanent-forgetfulness :great-geas :disorient :madness :drunkenness :mental-stun :emotion-control :avoid :mass-daze :berserker :sickness :lesser-geas :fascinate :dream-sending :bravery :foolishness :glib-tongue :terror :loyalty :daze :alertness :will-lock :nightmare :mass-sleep :fear :sleep :dullness :keen :discord :mindlessness},
   :illusion-and-creation #{:duplicate :illusion-disguise :create-servant :simple-illusion :create-mount :dispel-creation :phantom :control-illusion :create-animal :independence :initiative :inscribe :phantom-flame :know-illusion :create-object :perfect-illusion :illusion-shell :dispel-illusion :create-warrior :control-creation :complex-illusion},
   :body-control #{:hold-breath :total-paralysis :boost-strength :haircut :rooted-feet :itch :stop-spasm :alter-body :transmogrification :enlarge :pain :transform-body :alter-visage :paralyze-limb :hinder :accelerate-pregnancy :might :boost-dexterity :decapitation :frailty :curse-missile :lengthen-limb :mouth-goes-away :climbing :shrink :alter-voice :spasm :perfume :vigor :clumsiness :mark-of-thieves :strike-barren :transform-other :roundabout :agonize :tickle :reflexes :cadence :resist-pain :balance :shrink-other :ambidexterity :nauseate :corpulence :gauntness :seek-emitter :debility :deathtouch :sensitize :tanglefoot :touch :weaken-blood :choke :despoil-seed :sickness :strike-blind :strike-numb :thirst :control-limb :wither-limb :grace :imp-face :boost-health :strike-dumb :strike-deaf :stun :enlarge-other :hunger :hair-growth :fumble :retch},
   :plant #{:seek-plant :golem :wither-plant :walk-through-wood :walk-through-plants :tangle-growth :shape-plant :rejuvenate-plant :rain-of-nuts :purify-earth :pollen-cloud :plant-vision :plant-speech :plant-sense :plant-growth :plant-form-other :plant-form :identity-plant :hide-path :heal-plant :forest-warning :false-tracks :explode :essential-wood :create-plant :conceal :slow-fall :body-of-wood :body-of-slime :blossom :blight :bless-plants :arboreal-immurement :animate-plant}
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

  ;; TODO: order by nr of deps
  ;; (->> gurps.pages.character.utils.spells/spells
  ;;      (group-by
  ;;       (map #(do {(key %) (into #{} (map (fn [e] (:name e)) (val %)))}))
  ;;       (reduce into {})))

  (+ 1 2)

  (def deduped-spells
    (into [] (map first (vals (group-by :name spells))))))

;; (-> :parsed
  ;;     (map #(str "(def ^:private '(symbol (keyword (kebab-case (get % :name)))) '" % ")"))
  ;;     (map cljs.reader/read-string))
