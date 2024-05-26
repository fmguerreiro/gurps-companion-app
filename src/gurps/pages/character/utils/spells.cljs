(ns gurps.pages.character.utils.spells)

(def ^:private
  parsed-spells [{:name "Air Jet" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vision" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vortex" :prerequisites "Magery 2, Body of Air, and Windstorm" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Atmosphere Dome" :prerequisites "Purify Air and Weather Dome" :prerequisite_count 9 :college "Air" :ref "Magic p. 169"}
                 {:name "Ball of Lightning" :prerequisites "Apportation and Lightning" :prerequisite_count 8 :college "Air" :ref "Magic p. 197"}
                 {:name "Body of Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Body of Lightning" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Body of Wind" :prerequisites "Magery 3, Body of Air-16+, Windstorm-16+ and 1 spell from each of 5 different colleges besides Air" :prerequisite_count 10 :college "Air" :ref "Magic p. 27"}
                 {:name "Breathe Air" :prerequisites "Create Water and Destroy Air" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Breathe Water" :prerequisites "Create Air and Destroy Water" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 250; Magic p. 189"}
                 {:name "Chain Lightning" :prerequisites "Magery 4, Ball of Lightning, and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Cloud (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Cloud of Doom" :prerequisites "Magery 4 and at least 10 Air spells, including Devitalize Air and Stench" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Clouds" :prerequisites "2 Water spells and 2 Air spells" :prerequisite_count 4 :college "Air" :ref "Magic p. 194"}
                 {:name "Concussion" :prerequisites "Shape Air and Thunderclap" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Cool" :prerequisites "Cold and 4 Air spells" :prerequisite_count 9 :college "Air" :ref "Magic p. 195"}
                 {:name "Control Air Elemental" :prerequisites "Summon Air Elemental" :prerequisite_count 9 :college "Air" :ref "Magic p. 28"}
                 {:name "Create Air" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 23"}
                 {:name "Create Air Elemental" :prerequisites "Magery 2 and Control Air Elemental" :prerequisite_count 10 :college "Air" :ref "Magic p. 22"}
                 {:name "Destroy Air" :prerequisites "Purify Air" :prerequisite_count 2 :college "Air" :ref "Magic p. 43"}
                 {:name "Devitalize Air" :prerequisites "Destroy Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Diver's Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Electric Armor" :prerequisites "Magery, Lightning and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Missiles" :prerequisites "Electric Weapon" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Weapon" :prerequisites "Magery 2, Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 28"}
                 {:name "Embolism" :prerequisites "Magery 3, Body of Air, and Essential Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Essential Air" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Explosive Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Falling Sky" :prerequisites "Magery 4 and at least eight Air spells, including Concussion and Destroy Air" :prerequisite_count 8 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Improved Concussion;" :prerequisites "Magery 4 and at least seven Sound spells including Concussion and Great Voice" :prerequisite_count 7 :college "Air" :ref "Magic: Artillery Spells p. 25"}
                 {:name "Improved Explosive Lightning" :prerequisites "Magery 4 and at least 10 Air spells or 10 Weather spells, including Explosive Lightning" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Jolt (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Lightning" :prerequisites "Magery 1 and 6 other Air spells" :prerequisite_count 6 :college "Air" :ref "Basic Set p. 244; Magic p. 196"}
                 {:name "Lightning Armor" :prerequisites "6 Lightning spells including Resist Lightning" :prerequisite_count 12 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Missiles" :prerequisites "Lightning Weapon" :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Stare" :prerequisites "Lightning, Resist Lightning." :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Weapon" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Whip" :prerequisites "Lightning" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Mighty Breath (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Mass Resist Lightning" :prerequisites "IQ 13+, Secret Spell (Mass Resist Lightning), and Resist Lightning" :prerequisite_count nil :college "Air" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
                 {:name "No-Smell" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Odor" :prerequisites "No-Smell" :prerequisite_count 2 :college "Air" :ref "Magic p. 24"}
                 {:name "Phlogiston Arc" :prerequisites "Magery 4, Essential Air, and Lightning Whip" :prerequisite_count 7 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Detonation" :prerequisites "Magery 4, Essential Air, and Explosive Lightning" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Discharge" :prerequisites "Magery 4, Essential Air, and Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Sphere" :prerequisites "Magery 4, Essential Air, and Ball of Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Stare" :prerequisites "Magery 4, Essential Air, and Lightning Stare" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Touch" :prerequisites "Magery 4, Essential Air, and Shocking Touch" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Predict Weather" :prerequisites "4 Air spells" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 193"}
                 {:name "Purify Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
                 {:name "Purify Signal" :prerequisites "Purify Air, TL 6+" :prerequisite_count 1 :college "Air" :ref "Classic: Technomanser p 17"}
                 {:name "Rain" :prerequisites "Clouds" :prerequisite_count 5 :college "Air" :ref "Magic p. 195; Fantasy p. 168"}
                 {:name "Resist Lightning" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Safe Boarding" :prerequisites "Secret Spell (Safe Boarding) and 8 Second-Level spells" :prerequisite_count nil :college "Air" :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Seek Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic p. 23"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Air" :ref "Classic: Technomancer p. 17"}
                 {:name "Shape Air" :prerequisites "Create Air" :prerequisite_count 2 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Shocking Touch" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Snow" :prerequisites "Clouds and Frost" :prerequisite_count 2 :college "Air" :ref "Magic p. 193"}
                 {:name "Spark Cloud" :prerequisites "Shape Air and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Spark Storm" :prerequisites "Windstorm and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Static Charge" :prerequisites "Purify Air + 1 other Air spell" :prerequisite_count 2 :college "Air" :ref "Classic: Technomancer p 17"}
                 {:name "Steal Breath" :prerequisites "Magery 3 and any 7 Air spells, including Devitalize Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Stench" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 244; Magic p. 23"}
                 {:name "Stinkguard (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Storm" :prerequisites "Rain and Hail" :prerequisite_count 10 :college "Air" :ref "Magic p. 195"}
                 {:name "Storm Shelter (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Stroke of Lightning" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Stroke of Lightning)" :prerequisite_count nil :college "Air" :ref "Magic Styles: Dungeon Magic p. 19"}
                 {:name "Summon Air Elemental" :prerequisites "Magery 1 and either 8 Air spells or 4 Air spells and another Summon Elemental spell" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Twisting Terror" :prerequisites "Magery 4 and at least 10 Air spells, including Windstorm" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 10"}
                 {:name "Walk on Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Wall of Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 197"}
                 {:name "Wall of Wind" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Warm" :prerequisites "Heat and 4 Air spells" :prerequisite_count 8 :college "Air" :ref "Magic p. 195"}
                 {:name "Wind" :prerequisites "Windstorm" :prerequisite_count 4 :college "Air" :ref "Magic p. 193"}
                 {:name "Windstorm" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Abominable Alteration" :prerequisites "Magery 3, Alter Body, and Shapeshift Others for the appropriate animal" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 9)"}
                 {:name "(Animal) Control" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Link" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Possession" :prerequisites "Rider Within or Possession" :prerequisite_count 4 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast-Rouser" :prerequisites "Vexation or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast-Soother" :prerequisites "Persuasion or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 29"}
                 {:name "Beast Seeker" :prerequisites "either Beast Summoning and 2 Seek spells, or Seeker" :prerequisite_count 3 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast Speech" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Beast Summoning" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Call (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Creeping Plague" :prerequisites "Magery 5, Beast-Summoning, and Vermin Control or Magery 4 and Create Animal" :prerequisite_count 13 :college "Animal" :ref "Magic: Artillery Spells p. 10-11"}
                 {:name "Great Shapeshift" :prerequisites "Magery 3, Alter Body, 4 Shapeshifting spells, and 10 other spells" :prerequisite_count 15 :college "Animal" :ref "Magic p. 34"}
                 {:name "Groom (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Hybrid Control" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30; Classic: Grimoire p 9"}
                 {:name "Insect Repellent" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Master" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Merging Shapeshifting" :prerequisites "Magery 3, 2 Shapeshift Other, 2 Body Control, 2 (Animal) Control" :prerequisite_count 0 :college "Animal" :ref "Classic: Technomancer p 12"}
                 {:name "Partial Shapeshifting" :prerequisites "Magery 3, Alter Body, and appropriate Shapeshifting" :prerequisite_count 12 :college "Animal" :ref "Magic p. 34"}
                 {:name "Permanent Beast Possession" :prerequisites "Magery 2 and Beast Possession" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Permanent Shapeshifting" :prerequisites "Magery 3 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Protect Animal" :prerequisites "Armor, Watchdog, and Animal spells" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Repel (Animal)" :prerequisites "the appropriate (Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Repel Hybrids" :prerequisites "Hybrid Control" :prerequisite_count 4 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider" :prerequisites "(Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider Within" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Shapeshift Others" :prerequisites "Magery 2 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Shapeshifting" :prerequisites "Magery 1 and 6 other spells" :prerequisite_count 6 :college "Animal" :ref "Magic p. 32-33"}
                 {:name "Spider Silk" :prerequisites "Magery 1 and 2 Animal spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 32"}
                 {:name "Thousand-Legged Demise" :prerequisites "Magery 3, Vermin Control, and any one Shapeshift Others spell" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 10)"}
                 {:name "Accelerate Pregnancy" :prerequisites "Ease Labor and Haste" :prerequisite_count 0 :college "Body_Control" :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
                 {:name "Ache (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Agonize" :prerequisites "Magery 2 and Sensitize" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Alter Body" :prerequisites "Alter Visage" :prerequisite_count 10 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Visage" :prerequisites "Magery 1, (Shapeshifting or Perfect Illusion), and 8 Body Control spells" :prerequisite_count 9 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Voice" :prerequisites "4 Body Control spells and 4 Sound spells" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Ambidexterity" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Analgesic (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Balance" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Belch (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Birth Control (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Blend In (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Boost (Attribute) Dexterity" :prerequisites "Grace" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Health" :prerequisites "Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Strength" :prerequisites "Might" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Cadence" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Choke" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Climbing" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Clumsiness" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Control Limb" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40; Classic Grimoire p 14"}
                 {:name "Corpulence" :prerequisites "Magery 2, Create Earth, Create Water, Alter Body, and 3 other Body Control spells" :prerequisite_count 16 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Curse Missile" :prerequisites "Magery 2, spell used in missile" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Magic p 24"}
                 {:name "Death" :prerequisites "Magery 3, Choke, and Deathtouch (Magery 3, and Choke as well as any five of Entombment, Rotting Death, Curse Evisceration, Steal Beauty, Deathtouch, Frostbite, Steal Skill, Dehydrate, Pestilence, or Stop Healing and Secret Spell (Death) according to Magic Styles: Dungeon Magic)" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
                 {:name "Death Field" :prerequisites "Magery 4 and at least 10 Body Control spells, including Deathtouch" :prerequisite_count 10 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Deathtouch" :prerequisites "Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Basic Set, p. 245; Magic, p. 41"}
                 {:name "Debility" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Decapitation" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Despoil Seed" :prerequisites "Magery 1, Alter Body, and Strike Barren" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Diver’s Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Doomtouch" :prerequisites "Magery 3, Deathtouch, and Weaken Blood" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ease Labor" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
                 {:name "Eat Crow (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Elvish Grace" :prerequisites "Clumsiness and Secret Spell (Elvish Grace)" :prerequisite_count 3 :college "Body_Control" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Enlarge" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Enlarge Other" :prerequisites "Magery 3 and Enlarge" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Ether Static/TL" :prerequisites "Purify Signal or Static Charge" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Technomancer p. 17"}
                 {:name "Flexibility (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Frailty" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Fumble" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Gauntness" :prerequisites "Magery 2, Earth to Air, Destroy Water, Hunger, and 3 other Body Control spells" :prerequisite_count 15 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Grace" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Hair Growth" :prerequisites "5 Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Haircut" :prerequisites "Hair Growth" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hinder" :prerequisites "Clumsiness or Haste" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Hold Breath" :prerequisites "Magery 1 and Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hunger" :prerequisites "Magery 1, Debility, and Decay" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Imp Face" :prerequisites "Magery 1, Planar Summons, and Alter Visage" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Itch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Lengthen Limb" :prerequisites "Magery 3 and Shapeshifting" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
                 {:name "Ley Running" :prerequisites "Seek Ley Line and Haste" :prerequisite_count 1 :college "Body_Control" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Mark of Thieves" :prerequisites "Magery 1, Pestilence" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Might" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Mouth-Goes-Away" :prerequisites "Magery 1, Alter Visage, and four Body Control spells" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Nauseate" :prerequisites "Perfume and 1 other Body Control spell" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Pain" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Paralyze Limb" :prerequisites "Magery 1, Pain, and 4 other Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Partial Mechamorphosis/TL" :prerequisites "Magery 2, Alter Body, Machine Control, TL7+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomancer p 17"}
                 {:name "Perfume" :prerequisites "Odor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Plague Touch" :prerequisites "Magery 4, Deathtouch, Pestilence, and Sense Foes" :prerequisite_count 9 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Reflexes" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32"}
                 {:name "Resist Pain" :prerequisites "Magery 2 and Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Retch" :prerequisites "Nauseate and Spasm" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Rooted Feet" :prerequisites "Hinder" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Roundabout" :prerequisites "Tanglefoot" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomanser p 17"}
                 {:name "Sensitize" :prerequisites "Magery 1 and Stun" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Shrink" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Shrink Other" :prerequisites "Magery 3 and Shrink" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Sickness" :prerequisites "Drunkenness or Magery 1 and Pestilence" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 138"}
                 {:name "Spasm" :prerequisites "Itch" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Stand Out (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Anosmic" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Grimoire p 14"}
                 {:name "Stop Spasm" :prerequisites "Spasm or Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Stifle (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Barren" :prerequisites "Magery 1, Steal Vitality, and Decay" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Strike Blind" :prerequisites "Spasm and 2 Light and Darkness spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Deaf" :prerequisites "Spasm and 2 Sound spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Dumb" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Numb" :prerequisites "Resist Pain" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Stun" :prerequisites "Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Tanglefoot" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Thirst" :prerequisites "Magery 1, Debility, and Destroy Water" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Throw Voice (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Tickle" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Total Paralysis" :prerequisites "Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Touch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
                 {:name "Transform Body" :prerequisites "Alter Body and 3 Shapeshifting spells" :prerequisite_count 13 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transform Other" :prerequisites "Shapeshift Others and appropriate Transform Body" :prerequisite_count 14 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transmogrification" :prerequisites "Magery 3, Transform Other, Transform Object, and Flesh to Stone." :prerequisite_count 32 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Vigor" :prerequisites "Lend Vitality or Frailty" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Warp Fetus" :prerequisites "Strike Barren or Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Bio-Tech, p. 33"}
                 {:name "Weaken Blood" :prerequisites "Magery 1, Sickness or Steal Vitality" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Wither Limb" :prerequisites "Magery 2 and Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Absorb Book" :prerequisites "IQ 13+ or Gift of Letters" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Accursed Triangle" :prerequisites "Magery 3 and Exchange Bodies" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ack (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Bedtime Reading" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Borrow Language" :prerequisites "Lend Language" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Borrow Number/TL" :prerequisites "Seek Number" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Borrow Skill" :prerequisites "Lend Skill" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Broadcast Spell/TL" :prerequisites "Magery 3, Telepathy, Mass Suggestion, TL6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomander p. 19"}
                 {:name "Communication" :prerequisites "Wizard Eye, Far-Hearing, Voices, and Simple Illusion" :prerequisite_count 9 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Compel Lie" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 137"}
                 {:name "Compel Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Compel Written Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Control Person" :prerequisites "Soul Rider or Telepathy" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Delete Commercials/TL" :prerequisites "TL 7+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Dispel Possession" :prerequisites "Soul Rider or Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic p. 49"}
                 {:name "Drama (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Dream Projection" :prerequisites "Dream Sending" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Dream Sending" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Dream Viewing" :prerequisites "Truthsayer or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Exchange Bodies" :prerequisites "Permanent Possession and Soul Jar" :prerequisite_count 17 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Gift of Letters" :prerequisites "Borrow Language and 3 Languages written at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Gift of Tongues" :prerequisites "Borrow Language and 3 Languages spoken at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Hide Emotion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Hide Thoughts" :prerequisites "Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46"}
                 {:name "Identify Caller/TL" :prerequisites "Mind Reading, Seek Number." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Illuminated Writing" :prerequisites "Magery 2 and one of Mind-Sending, Fascinate, or Writing-12+" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Insignificance" :prerequisites "Persuasion and Avoid" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Lend Language" :prerequisites "Beast Speech or 3 Communication and Empathy spells" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Lend Skill" :prerequisites "Mind-Sending and IQ 11+" :prerequisite_count 11 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Machine Speech/TL" :prerequisites "Machine Summoning" :prerequisite_count 13 :college "Communication_and_Empathy" :ref "Magic, p. 176"}
                 {:name "Magic Switchboard/TL" :prerequisites "Identify Caller" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 17"}
                 {:name "Message" :prerequisites "Great Voice and Seeker" :prerequisite_count 7 :college "Communication_and_Empathy" :ref "Magic, p. 173"}
                 {:name "Mer-Speech (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Mind-Reading" :prerequisites "Truthsayer or Borrow Language" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Search" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Mind-Sending" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Whip" :prerequisites "Magery 2, Telepathy, Thunderclap, and Secret Spell (Mind-Whip)." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic Styles: Dungeon Magic, p. 24"}
                 {:name "Permanent Possession" :prerequisites "Magery 3 and Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Persuasion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Possession" :prerequisites "Magery 1 and either Control Person or Beast Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Presence" :prerequisites "Persuasion and Lure" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Retrogression" :prerequisites "Mind-Search and Mind-Sending" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Seek Number/TL" :prerequisites "Magery, TL 6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Sense Emotion" :prerequisites "Sense Foes" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
                 {:name "Sense Foes" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 44"}
                 {:name "Sense Life" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Sorcerous Signal (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Soul Rider" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Speed Data/TL" :prerequisites "TL7+; Haste or Lightning" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Switch Bodies" :prerequisites "Permanent Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "4e spell chart"}
                 {:name "Telepathic Overload" :prerequisites "Magery 3, and any 10 Communication and Empathy spells, including Telepathy" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 9"}
                 {:name "Telepathy" :prerequisites "Mind-Sending" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Truthsayer" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45"}
                 {:name "Vexation" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Wrong Number/TL" :prerequisites "TL6+; Sense Foes or Seek Number." :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Adamant Hail" :prerequisites "Magery 4, Essential Earth, and Rain of Stones" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Adamant Missile" :prerequisites "Magery 4, Essential Earth, and Stone Missile" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Alter Terrain" :prerequisites "Magery 3 and all 4 elemental Shape spells and Shape Stone" :prerequisite_count 11 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Badger Paws (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Body of Stone" :prerequisites "Stone to Flesh" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Boulder Barrage" :prerequisites "Magery 4 and at least 10 Earth spells, including Rain of Stones and Stone Missile" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Control Earth Elemental" :prerequisites "Summon Earth Elemental" :prerequisite_count 9 :college "Earth" :ref "Magic, p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Earth" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Earth Elemental" :prerequisites "Magery 2 and Control Earth Elemental" :prerequisite_count 10 :college "Earth" :ref "Magic, p. 22"}
                 {:name "Dust to Dust" :prerequisites "Magery 3, Earth to Air, and Flesh to Stone" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Earth" :ref "Basic Set, p. 243; Magic, p. 25"}
                 {:name "Earth to Stone" :prerequisites "Magery 1 and Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Earth to Water" :prerequisites "Magery 1, Create Water, and Shape Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Earth Vision" :prerequisites "Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Earthquake" :prerequisites "Magery 2 and 6 Earth spells including Earth Vision" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Entombment" :prerequisites "Magery 2 and 5 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Essential Earth" :prerequisites "6 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Flesh to Adamant" :prerequisites "Magery 4, Essential Earth, and Flesh to Stone" :prerequisite_count 7 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Flesh to Stone" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Gargoyle Skin (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Heart of Stone" :prerequisites "Magery 3 and Partial Petrification" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Move Terrain" :prerequisites "Alter Terrain and Hide Object" :prerequisite_count 29 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Mud Jet" :prerequisites "Water Jet and Create Earth, or Create Water and Sand Jet" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Orichalcum Edge" :prerequisites "Magery 4, Essential Earth, and Earth to Stone" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Orichalcum Missiles" :prerequisites "Orichalcum Edge" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Partial Petrification" :prerequisites "Magery 2 and Flesh to Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Pebble (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Predict Earth Movement" :prerequisites "4 Earth spells" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Purify Earth" :prerequisites "Apportation and Shape Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
                 {:name "Rain of Stones" :prerequisites "Magery 2 and Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 53"}
                 {:name "Sand Blast" :prerequisites "Magery 4, Sand Jet, and Sandstorm" :prerequisite_count 0 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Sand Jet" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Seek Earth" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Seek Pass" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Seismic Shock" :prerequisites "Magery 4 and at least 10 Earth spells, including Earthquake" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 13"}
                 {:name "Shape Earth" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Shape Stone" :prerequisites "Shape Earth and 3 other Earth spells" :prerequisite_count 5 :college "Earth" :ref "Fantasy, p. 169"}
                 {:name "Spotless Hands (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Steelwraith" :prerequisites "Magery 2 and Walk through Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Stone Missile" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Stone to Earth" :prerequisites "Earth to Stone or 4 Earth spells" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Stone to Flesh" :prerequisites "Magery 2, Flesh to Stone, and Stone to Earth" :prerequisite_count 5 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Summon Earth Elemental" :prerequisites "Magery 1 and either 8 Earth spells or 4 Earth spells and another Summon Elemental spell" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Volcano" :prerequisites "Earthquake and 6 Fire spells" :prerequisite_count 13 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Walk through Earth" :prerequisites "Shape Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Adjustable Clothing" :prerequisites "Enchant and Reshape" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
                 {:name "Amulet" :prerequisites "Talisman for the appropriate spell" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Compulsive Reader" :prerequisites "Enchant and 3 Mind Control spells or Writing-15+" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Costume" :prerequisites "Adjustable Clothing" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Item 3 p 30"}
                 {:name "Create Chimera" :prerequisites "Analyze Heredity, Enchant, and either Alter Body or Lightning" :prerequisite_count 0 :college "Enchantment" :ref "Bio-Tech, p. 31"}
                 {:name "Curse Virus/TL" :prerequisites "Spellprocessor and Animate Machine, Awaken Computer, Curse, Glitch, Mad Machine or Malfunction" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Tenchnomancer p. 20"}
                 {:name "Doom Wish" :prerequisites "Magery 3, Wish, and IQ + Magery of 23+" :prerequisite_count 18 :college "Enchantment" :ref "Magic: Artillery Spells p. 13-14"}
                 {:name "Doppelgänger" :prerequisites "Magery 3, Golem, History, and Enslave" :prerequisite_count 29 :college "Enchantment" :ref "Magic p. 62; Classic: Magic p 40"}
                 {:name "Dwarfish Reinforcement" :prerequisites "Enchant and Secret Spell (Dwarvish Reinforcement)" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Electric Power/TL" :prerequisites "Lend Power, Power, Steal Power" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 20"}
                 {:name "Emergency Staff (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Enchant" :prerequisites "Magery 2 and at least one spell from 10 other colleges" :prerequisite_count 10 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 56"}
                 {:name "Ensorcel" :prerequisites "Malefice" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Golem" :prerequisites "Enchant, Shape Earth, and Animation" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 59"}
                 {:name "Great Wish" :prerequisites "Magery 3, Wish, and (DX+IQ) 30+" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Hex" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Hideaway" :prerequisites "Enchant, Create Object, and Lighten" :prerequisite_count 15 :college "Enchantment" :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
                 {:name "Impart Skill" :prerequisites "Magery 3, Enchant, Lend Skill, Wisdom, Secret Spell (Impart Skill), and five Communication and Empathy spells" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Impression Blocker" :prerequisites "Enchant, Seeker, and Scrywall" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Leak" :prerequisites "Hideaway" :prerequisite_count 16 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Lesser Wish" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Ley Line Creation" :prerequisites "Seek Ley Line and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Thaumatology: Urban Magics, p. 21"}
                 {:name "Live Libram" :prerequisites "Enchant and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Malefice" :prerequisites "Enchant and Seeker" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Magician’s Minion (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8-9"}
                 {:name "Mana Warhead/TL" :prerequisites "Curse-Missile and spell in warhead" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 21"}
                 {:name "Mortal Malefice" :prerequisites "Magery 3, Malefice, and Soul Jar" :prerequisite_count 0 :college "Enchantment" :ref "Magic: Death Spells, p. 9"}
                 {:name "Narrative Conveyance" :prerequisites "Plane Shift, Timeport, and Writing-15+" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Power" :prerequisites "Enchant and Recover Energy" :prerequisite_count 12 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 57"}
                 {:name "Remove Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Resilient Golem" :prerequisites "Golem and Shatterproof" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Items 3 p 32"}
                 {:name "Resist Enchantment" :prerequisites "any Limiting Enchantment spell" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Scroll" :prerequisites "Magery 1 and 1 written Language at Accented or better" :prerequisite_count 0 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Simulacrum" :prerequisites "Magery 3, Golem, Perfect Illusion, and Illusion Disguise" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Sorcerer’s Stand-In (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Soul Golem" :prerequisites "Magery 3, Soul Jet, Golem, IQ 13+" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Grimoire p 42"}
                 {:name "Speed" :prerequisites "Enchant and Haste" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Spell Stone" :prerequisites "Enchant and Delay" :prerequisite_count 8 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Spellbook Enchantment" :prerequisites "Scroll" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Magic Items 2 p. 40"}
                 {:name "Spellgraft" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Bio-Tech, p. 32"}
                 {:name "Spellprocessor" :prerequisites "Scroll, Computer Programming-15+" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Technomancer p 19"}
                 {:name "Suspend Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Talisman" :prerequisites "Enchant and spell to be opposed" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Temporary Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 56; Fantasy, p. 23"}
                 {:name "Vengeful Staff" :prerequisites "Magery 3, Enchant, and Explode" :prerequisite_count 12 :college "Enchantment" :ref "Magic: Artillery Spells p. 14"}
                 {:name "Wish" :prerequisites "Lesser Wish and 1 spell each from 15 colleges" :prerequisite_count 17 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Balor's Eye Fire" :prerequisites "Magery 1, Flame Jet, Resist Fire, and either Secret Spell (Balor’s Eye Fire) or Tome of Power (Balor’s Treatise)" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Blast Ball" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Blast Ball)" :prerequisite_count 0 :college "Fire" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Body of Flames" :prerequisites "Breathe Fire" :prerequisite_count 8 :college "Fire" :ref "Magic p. 76"}
                 {:name "Breathe Fire" :prerequisites "Magery 1, Flame Jet, and Resist Fire" :prerequisite_count 7 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Death" :prerequisites "Magery 2, Heat, and Sickness" :prerequisite_count 10 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Touch" :prerequisites "Magery 2 and 6 Fire spells including Heat" :prerequisite_count 6 :college "Fire" :ref "Magic p. 76"}
                 {:name "Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
                 {:name "Control Fire Elemental" :prerequisites "Summon Fire Elemental" :prerequisite_count 9 :college "Fire" :ref "Magic p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Fire" :prerequisites "Ignite Fire or Seek Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 72"}
                 {:name "Create Fire Elemental" :prerequisites "Magery 2 and Control Fire Elemental" :prerequisite_count 10 :college "Fire" :ref "Magic p. 22"}
                 {:name "Cremate" :prerequisites "Magery 3, Burning Touch, Essential Flame, and Fast Fire" :prerequisite_count 0 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Deflect Energy" :prerequisites "Magery 1 and Shape Fire" :prerequisite_count 2 :college "Fire" :ref "Basic Set, p. 246; Magic p. 73"}
                 {:name "Detonate" :prerequisites "Ignite Fire, Shape Plastic" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ember (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Essential Flame" :prerequisites "6 Fire spells" :prerequisite_count 6 :college "Fire" :ref "Magic p. 75"}
                 {:name "Explosive Fireball" :prerequisites "Fireball" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 75"}
                 {:name "Explosive Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Explosive Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Extinguish Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 247; Magic p. 72"}
                 {:name "Fast Fire" :prerequisites "Slow Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Fire Cloud" :prerequisites "Shape Air and Fireball" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Fire Swarm" :prerequisites "Magery 4 and at least 10 Fire spells, including Fireball and Flame Jet" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Fireball" :prerequisites "Magery 1, Create Fire, and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Fireproof" :prerequisites "Extinguish Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flame Jet" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flameturning" :prerequisites "Resist Fire, or both Apportation and Shape Fire" :prerequisite_count 0 :college "Fire" :ref "Classic: Grimoire p. 30"}
                 {:name "Flaming Armor" :prerequisites "Magery 1, Resist Fire, and Flame Jet" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Missiles" :prerequisites "Flaming Weapon" :prerequisite_count 5 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Weapon" :prerequisites "Magery 2 and Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 75"}
                 {:name "Great Deflect Energy" :prerequisites "Magery 2, Secret Spell (Great Deflect Energy), and Deflect Energy" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
                 {:name "Heat" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Hellfire Breath" :prerequisites "Magery 4, Essential Flame, and Breathe Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Jet" :prerequisites "Magery 4, Essential Flame, and Flame Jet" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Hellfire Rain" :prerequisites "Magery 4, Essential Flame, and Rain of Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "High-Explosive Fireball" :prerequisites "Explosive Fireball, TL7+" :prerequisite_count 5 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ignite Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Improved Explosive Fireball" :prerequisites "Magery 4 and at least 10 Fire spells, including Explosive Fireball" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Mass Detonate" :prerequisites "Detonate" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Mass Resist Fire" :prerequisites "IQ 13+, Secret Spell (Mass Resist Fire), and Resist Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Oven Mitts (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Phantom Flame" :prerequisites "Shape Fire or Simple Illusion" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Puff (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Rain of Fire" :prerequisites "Magery 2 and Create Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Resist Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Resist Fire" :prerequisites "Extinguish Fire and Cold" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Shaped-Charge Fireball" :prerequisites "Magery, Fireball, Shape Metal" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p 21"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Seek Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic p. 72"}
                 {:name "Shape Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Slow Fire" :prerequisites "Extinguish Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 73"}
                 {:name "Smoke" :prerequisites "Shape Fire and Extinguish Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Snuff Life's Flame" :prerequisites "Magery 3 and Body of Flames" :prerequisite_count 9 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Summon Fire Elemental" :prerequisites "Magery 1 and either 8 Fire spells or 4 Fire spells and another Summon Elemental spell" :prerequisite_count 8 :college "Fire" :ref "Magic p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Towering Inferno" :prerequisites "Magery 4 and at least 7 Fire spells, including Fire Cloud and Rain of Fire" :prerequisite_count 7 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Warmth" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 74"}
                 {:name "Air Jet" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vision" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vortex" :prerequisites "Magery 2, Body of Air, and Windstorm" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Atmosphere Dome" :prerequisites "Purify Air and Weather Dome" :prerequisite_count 9 :college "Air" :ref "Magic p. 169"}
                 {:name "Ball of Lightning" :prerequisites "Apportation and Lightning" :prerequisite_count 8 :college "Air" :ref "Magic p. 197"}
                 {:name "Body of Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Body of Lightning" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Body of Wind" :prerequisites "Magery 3, Body of Air-16+, Windstorm-16+ and 1 spell from each of 5 different colleges besides Air" :prerequisite_count 10 :college "Air" :ref "Magic p. 27"}
                 {:name "Breathe Air" :prerequisites "Create Water and Destroy Air" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Breathe Water" :prerequisites "Create Air and Destroy Water" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 250; Magic p. 189"}
                 {:name "Chain Lightning" :prerequisites "Magery 4, Ball of Lightning, and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Cloud (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Cloud of Doom" :prerequisites "Magery 4 and at least 10 Air spells, including Devitalize Air and Stench" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Clouds" :prerequisites "2 Water spells and 2 Air spells" :prerequisite_count 4 :college "Air" :ref "Magic p. 194"}
                 {:name "Concussion" :prerequisites "Shape Air and Thunderclap" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Cool" :prerequisites "Cold and 4 Air spells" :prerequisite_count 9 :college "Air" :ref "Magic p. 195"}
                 {:name "Control Air Elemental" :prerequisites "Summon Air Elemental" :prerequisite_count 9 :college "Air" :ref "Magic p. 28"}
                 {:name "Create Air" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 23"}
                 {:name "Create Air Elemental" :prerequisites "Magery 2 and Control Air Elemental" :prerequisite_count 10 :college "Air" :ref "Magic p. 22"}
                 {:name "Destroy Air" :prerequisites "Purify Air" :prerequisite_count 2 :college "Air" :ref "Magic p. 43"}
                 {:name "Devitalize Air" :prerequisites "Destroy Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Diver's Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Electric Armor" :prerequisites "Magery, Lightning and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Missiles" :prerequisites "Electric Weapon" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Weapon" :prerequisites "Magery 2, Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 28"}
                 {:name "Embolism" :prerequisites "Magery 3, Body of Air, and Essential Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Essential Air" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Explosive Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Falling Sky" :prerequisites "Magery 4 and at least eight Air spells, including Concussion and Destroy Air" :prerequisite_count 8 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Improved Concussion;" :prerequisites "Magery 4 and at least seven Sound spells including Concussion and Great Voice" :prerequisite_count 7 :college "Air" :ref "Magic: Artillery Spells p. 25"}
                 {:name "Improved Explosive Lightning" :prerequisites "Magery 4 and at least 10 Air spells or 10 Weather spells, including Explosive Lightning" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Jolt (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Lightning" :prerequisites "Magery 1 and 6 other Air spells" :prerequisite_count 6 :college "Air" :ref "Basic Set p. 244; Magic p. 196"}
                 {:name "Lightning Armor" :prerequisites "6 Lightning spells including Resist Lightning" :prerequisite_count 12 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Missiles" :prerequisites "Lightning Weapon" :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Stare" :prerequisites "Lightning, Resist Lightning." :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Weapon" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Whip" :prerequisites "Lightning" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Mighty Breath (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Mass Resist Lightning" :prerequisites "IQ 13+, Secret Spell (Mass Resist Lightning), and Resist Lightning" :prerequisite_count nil :college "Air" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
                 {:name "No-Smell" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Odor" :prerequisites "No-Smell" :prerequisite_count 2 :college "Air" :ref "Magic p. 24"}
                 {:name "Phlogiston Arc" :prerequisites "Magery 4, Essential Air, and Lightning Whip" :prerequisite_count 7 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Detonation" :prerequisites "Magery 4, Essential Air, and Explosive Lightning" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Discharge" :prerequisites "Magery 4, Essential Air, and Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Sphere" :prerequisites "Magery 4, Essential Air, and Ball of Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Stare" :prerequisites "Magery 4, Essential Air, and Lightning Stare" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Touch" :prerequisites "Magery 4, Essential Air, and Shocking Touch" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Predict Weather" :prerequisites "4 Air spells" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 193"}
                 {:name "Purify Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
                 {:name "Purify Signal" :prerequisites "Purify Air, TL 6+" :prerequisite_count 1 :college "Air" :ref "Classic: Technomanser p 17"}
                 {:name "Rain" :prerequisites "Clouds" :prerequisite_count 5 :college "Air" :ref "Magic p. 195; Fantasy p. 168"}
                 {:name "Resist Lightning" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Safe Boarding" :prerequisites "Secret Spell (Safe Boarding) and 8 Second-Level spells" :prerequisite_count nil :college "Air" :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Seek Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic p. 23"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Air" :ref "Classic: Technomancer p. 17"}
                 {:name "Shape Air" :prerequisites "Create Air" :prerequisite_count 2 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Shocking Touch" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Snow" :prerequisites "Clouds and Frost" :prerequisite_count 2 :college "Air" :ref "Magic p. 193"}
                 {:name "Spark Cloud" :prerequisites "Shape Air and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Spark Storm" :prerequisites "Windstorm and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Static Charge" :prerequisites "Purify Air + 1 other Air spell" :prerequisite_count 2 :college "Air" :ref "Classic: Technomancer p 17"}
                 {:name "Steal Breath" :prerequisites "Magery 3 and any 7 Air spells, including Devitalize Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Stench" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 244; Magic p. 23"}
                 {:name "Stinkguard (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Storm" :prerequisites "Rain and Hail" :prerequisite_count 10 :college "Air" :ref "Magic p. 195"}
                 {:name "Storm Shelter (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Stroke of Lightning" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Stroke of Lightning)" :prerequisite_count nil :college "Air" :ref "Magic Styles: Dungeon Magic p. 19"}
                 {:name "Summon Air Elemental" :prerequisites "Magery 1 and either 8 Air spells or 4 Air spells and another Summon Elemental spell" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Twisting Terror" :prerequisites "Magery 4 and at least 10 Air spells, including Windstorm" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 10"}
                 {:name "Walk on Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Wall of Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 197"}
                 {:name "Wall of Wind" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Warm" :prerequisites "Heat and 4 Air spells" :prerequisite_count 8 :college "Air" :ref "Magic p. 195"}
                 {:name "Wind" :prerequisites "Windstorm" :prerequisite_count 4 :college "Air" :ref "Magic p. 193"}
                 {:name "Windstorm" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Abominable Alteration" :prerequisites "Magery 3, Alter Body, and Shapeshift Others for the appropriate animal" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 9)"}
                 {:name "(Animal) Control" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Link" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Possession" :prerequisites "Rider Within or Possession" :prerequisite_count 4 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast-Rouser" :prerequisites "Vexation or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast-Soother" :prerequisites "Persuasion or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 29"}
                 {:name "Beast Seeker" :prerequisites "either Beast Summoning and 2 Seek spells, or Seeker" :prerequisite_count 3 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast Speech" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Beast Summoning" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Call (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Creeping Plague" :prerequisites "Magery 5, Beast-Summoning, and Vermin Control or Magery 4 and Create Animal" :prerequisite_count 13 :college "Animal" :ref "Magic: Artillery Spells p. 10-11"}
                 {:name "Great Shapeshift" :prerequisites "Magery 3, Alter Body, 4 Shapeshifting spells, and 10 other spells" :prerequisite_count 15 :college "Animal" :ref "Magic p. 34"}
                 {:name "Groom (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Hybrid Control" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30; Classic: Grimoire p 9"}
                 {:name "Insect Repellent" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Master" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Merging Shapeshifting" :prerequisites "Magery 3, 2 Shapeshift Other, 2 Body Control, 2 (Animal) Control" :prerequisite_count 0 :college "Animal" :ref "Classic: Technomancer p 12"}
                 {:name "Partial Shapeshifting" :prerequisites "Magery 3, Alter Body, and appropriate Shapeshifting" :prerequisite_count 12 :college "Animal" :ref "Magic p. 34"}
                 {:name "Permanent Beast Possession" :prerequisites "Magery 2 and Beast Possession" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Permanent Shapeshifting" :prerequisites "Magery 3 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Protect Animal" :prerequisites "Armor, Watchdog, and Animal spells" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Repel (Animal)" :prerequisites "the appropriate (Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Repel Hybrids" :prerequisites "Hybrid Control" :prerequisite_count 4 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider" :prerequisites "(Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider Within" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Shapeshift Others" :prerequisites "Magery 2 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Shapeshifting" :prerequisites "Magery 1 and 6 other spells" :prerequisite_count 6 :college "Animal" :ref "Magic p. 32-33"}
                 {:name "Spider Silk" :prerequisites "Magery 1 and 2 Animal spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 32"}
                 {:name "Thousand-Legged Demise" :prerequisites "Magery 3, Vermin Control, and any one Shapeshift Others spell" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 10)"}
                 {:name "Accelerate Pregnancy" :prerequisites "Ease Labor and Haste" :prerequisite_count 0 :college "Body_Control" :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
                 {:name "Ache (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Agonize" :prerequisites "Magery 2 and Sensitize" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Alter Body" :prerequisites "Alter Visage" :prerequisite_count 10 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Visage" :prerequisites "Magery 1, (Shapeshifting or Perfect Illusion), and 8 Body Control spells" :prerequisite_count 9 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Voice" :prerequisites "4 Body Control spells and 4 Sound spells" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Ambidexterity" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Analgesic (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Balance" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Belch (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Birth Control (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Blend In (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Boost (Attribute) Dexterity" :prerequisites "Grace" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Health" :prerequisites "Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Strength" :prerequisites "Might" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Cadence" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Choke" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Climbing" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Clumsiness" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Control Limb" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40; Classic Grimoire p 14"}
                 {:name "Corpulence" :prerequisites "Magery 2, Create Earth, Create Water, Alter Body, and 3 other Body Control spells" :prerequisite_count 16 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Curse Missile" :prerequisites "Magery 2, spell used in missile" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Magic p 24"}
                 {:name "Death" :prerequisites "Magery 3, Choke, and Deathtouch (Magery 3, and Choke as well as any five of Entombment, Rotting Death, Curse Evisceration, Steal Beauty, Deathtouch, Frostbite, Steal Skill, Dehydrate, Pestilence, or Stop Healing and Secret Spell (Death) according to Magic Styles: Dungeon Magic)" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
                 {:name "Death Field" :prerequisites "Magery 4 and at least 10 Body Control spells, including Deathtouch" :prerequisite_count 10 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Deathtouch" :prerequisites "Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Basic Set, p. 245; Magic, p. 41"}
                 {:name "Debility" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Decapitation" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Despoil Seed" :prerequisites "Magery 1, Alter Body, and Strike Barren" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Diver’s Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Doomtouch" :prerequisites "Magery 3, Deathtouch, and Weaken Blood" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ease Labor" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
                 {:name "Eat Crow (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Elvish Grace" :prerequisites "Clumsiness and Secret Spell (Elvish Grace)" :prerequisite_count 3 :college "Body_Control" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Enlarge" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Enlarge Other" :prerequisites "Magery 3 and Enlarge" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Ether Static/TL" :prerequisites "Purify Signal or Static Charge" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Technomancer p. 17"}
                 {:name "Flexibility (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Frailty" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Fumble" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Gauntness" :prerequisites "Magery 2, Earth to Air, Destroy Water, Hunger, and 3 other Body Control spells" :prerequisite_count 15 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Grace" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Hair Growth" :prerequisites "5 Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Haircut" :prerequisites "Hair Growth" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hinder" :prerequisites "Clumsiness or Haste" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Hold Breath" :prerequisites "Magery 1 and Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hunger" :prerequisites "Magery 1, Debility, and Decay" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Imp Face" :prerequisites "Magery 1, Planar Summons, and Alter Visage" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Itch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Lengthen Limb" :prerequisites "Magery 3 and Shapeshifting" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
                 {:name "Ley Running" :prerequisites "Seek Ley Line and Haste" :prerequisite_count 1 :college "Body_Control" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Mark of Thieves" :prerequisites "Magery 1, Pestilence" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Might" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Mouth-Goes-Away" :prerequisites "Magery 1, Alter Visage, and four Body Control spells" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Nauseate" :prerequisites "Perfume and 1 other Body Control spell" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Pain" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Paralyze Limb" :prerequisites "Magery 1, Pain, and 4 other Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Partial Mechamorphosis/TL" :prerequisites "Magery 2, Alter Body, Machine Control, TL7+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomancer p 17"}
                 {:name "Perfume" :prerequisites "Odor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Plague Touch" :prerequisites "Magery 4, Deathtouch, Pestilence, and Sense Foes" :prerequisite_count 9 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Reflexes" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32"}
                 {:name "Resist Pain" :prerequisites "Magery 2 and Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Retch" :prerequisites "Nauseate and Spasm" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Rooted Feet" :prerequisites "Hinder" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Roundabout" :prerequisites "Tanglefoot" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomanser p 17"}
                 {:name "Sensitize" :prerequisites "Magery 1 and Stun" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Shrink" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Shrink Other" :prerequisites "Magery 3 and Shrink" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Sickness" :prerequisites "Drunkenness or Magery 1 and Pestilence" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 138"}
                 {:name "Spasm" :prerequisites "Itch" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Stand Out (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Anosmic" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Grimoire p 14"}
                 {:name "Stop Spasm" :prerequisites "Spasm or Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Stifle (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Barren" :prerequisites "Magery 1, Steal Vitality, and Decay" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Strike Blind" :prerequisites "Spasm and 2 Light and Darkness spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Deaf" :prerequisites "Spasm and 2 Sound spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Dumb" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Numb" :prerequisites "Resist Pain" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Stun" :prerequisites "Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Tanglefoot" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Thirst" :prerequisites "Magery 1, Debility, and Destroy Water" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Throw Voice (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Tickle" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Total Paralysis" :prerequisites "Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Touch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
                 {:name "Transform Body" :prerequisites "Alter Body and 3 Shapeshifting spells" :prerequisite_count 13 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transform Other" :prerequisites "Shapeshift Others and appropriate Transform Body" :prerequisite_count 14 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transmogrification" :prerequisites "Magery 3, Transform Other, Transform Object, and Flesh to Stone." :prerequisite_count 32 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Vigor" :prerequisites "Lend Vitality or Frailty" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Warp Fetus" :prerequisites "Strike Barren or Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Bio-Tech, p. 33"}
                 {:name "Weaken Blood" :prerequisites "Magery 1, Sickness or Steal Vitality" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Wither Limb" :prerequisites "Magery 2 and Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Absorb Book" :prerequisites "IQ 13+ or Gift of Letters" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Accursed Triangle" :prerequisites "Magery 3 and Exchange Bodies" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ack (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Bedtime Reading" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Borrow Language" :prerequisites "Lend Language" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Borrow Number/TL" :prerequisites "Seek Number" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Borrow Skill" :prerequisites "Lend Skill" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Broadcast Spell/TL" :prerequisites "Magery 3, Telepathy, Mass Suggestion, TL6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomander p. 19"}
                 {:name "Communication" :prerequisites "Wizard Eye, Far-Hearing, Voices, and Simple Illusion" :prerequisite_count 9 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Compel Lie" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 137"}
                 {:name "Compel Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Compel Written Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Control Person" :prerequisites "Soul Rider or Telepathy" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Delete Commercials/TL" :prerequisites "TL 7+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Dispel Possession" :prerequisites "Soul Rider or Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic p. 49"}
                 {:name "Drama (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Dream Projection" :prerequisites "Dream Sending" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Dream Sending" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Dream Viewing" :prerequisites "Truthsayer or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Exchange Bodies" :prerequisites "Permanent Possession and Soul Jar" :prerequisite_count 17 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Gift of Letters" :prerequisites "Borrow Language and 3 Languages written at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Gift of Tongues" :prerequisites "Borrow Language and 3 Languages spoken at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Hide Emotion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Hide Thoughts" :prerequisites "Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46"}
                 {:name "Identify Caller/TL" :prerequisites "Mind Reading, Seek Number." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Illuminated Writing" :prerequisites "Magery 2 and one of Mind-Sending, Fascinate, or Writing-12+" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Insignificance" :prerequisites "Persuasion and Avoid" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Lend Language" :prerequisites "Beast Speech or 3 Communication and Empathy spells" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Lend Skill" :prerequisites "Mind-Sending and IQ 11+" :prerequisite_count 11 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Machine Speech/TL" :prerequisites "Machine Summoning" :prerequisite_count 13 :college "Communication_and_Empathy" :ref "Magic, p. 176"}
                 {:name "Magic Switchboard/TL" :prerequisites "Identify Caller" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 17"}
                 {:name "Message" :prerequisites "Great Voice and Seeker" :prerequisite_count 7 :college "Communication_and_Empathy" :ref "Magic, p. 173"}
                 {:name "Mer-Speech (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Mind-Reading" :prerequisites "Truthsayer or Borrow Language" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Search" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Mind-Sending" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Whip" :prerequisites "Magery 2, Telepathy, Thunderclap, and Secret Spell (Mind-Whip)." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic Styles: Dungeon Magic, p. 24"}
                 {:name "Permanent Possession" :prerequisites "Magery 3 and Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Persuasion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Possession" :prerequisites "Magery 1 and either Control Person or Beast Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Presence" :prerequisites "Persuasion and Lure" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Retrogression" :prerequisites "Mind-Search and Mind-Sending" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Seek Number/TL" :prerequisites "Magery, TL 6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Sense Emotion" :prerequisites "Sense Foes" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
                 {:name "Sense Foes" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 44"}
                 {:name "Sense Life" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Sorcerous Signal (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Soul Rider" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Speed Data/TL" :prerequisites "TL7+; Haste or Lightning" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Switch Bodies" :prerequisites "Permanent Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "4e spell chart"}
                 {:name "Telepathic Overload" :prerequisites "Magery 3, and any 10 Communication and Empathy spells, including Telepathy" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 9"}
                 {:name "Telepathy" :prerequisites "Mind-Sending" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Truthsayer" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45"}
                 {:name "Vexation" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Wrong Number/TL" :prerequisites "TL6+; Sense Foes or Seek Number." :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Adamant Hail" :prerequisites "Magery 4, Essential Earth, and Rain of Stones" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Adamant Missile" :prerequisites "Magery 4, Essential Earth, and Stone Missile" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Alter Terrain" :prerequisites "Magery 3 and all 4 elemental Shape spells and Shape Stone" :prerequisite_count 11 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Badger Paws (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Body of Stone" :prerequisites "Stone to Flesh" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Boulder Barrage" :prerequisites "Magery 4 and at least 10 Earth spells, including Rain of Stones and Stone Missile" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Control Earth Elemental" :prerequisites "Summon Earth Elemental" :prerequisite_count 9 :college "Earth" :ref "Magic, p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Earth" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Earth Elemental" :prerequisites "Magery 2 and Control Earth Elemental" :prerequisite_count 10 :college "Earth" :ref "Magic, p. 22"}
                 {:name "Dust to Dust" :prerequisites "Magery 3, Earth to Air, and Flesh to Stone" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Earth" :ref "Basic Set, p. 243; Magic, p. 25"}
                 {:name "Earth to Stone" :prerequisites "Magery 1 and Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Earth to Water" :prerequisites "Magery 1, Create Water, and Shape Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Earth Vision" :prerequisites "Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Earthquake" :prerequisites "Magery 2 and 6 Earth spells including Earth Vision" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Entombment" :prerequisites "Magery 2 and 5 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Essential Earth" :prerequisites "6 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Flesh to Adamant" :prerequisites "Magery 4, Essential Earth, and Flesh to Stone" :prerequisite_count 7 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Flesh to Stone" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Gargoyle Skin (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Heart of Stone" :prerequisites "Magery 3 and Partial Petrification" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Move Terrain" :prerequisites "Alter Terrain and Hide Object" :prerequisite_count 29 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Mud Jet" :prerequisites "Water Jet and Create Earth, or Create Water and Sand Jet" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Orichalcum Edge" :prerequisites "Magery 4, Essential Earth, and Earth to Stone" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Orichalcum Missiles" :prerequisites "Orichalcum Edge" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Partial Petrification" :prerequisites "Magery 2 and Flesh to Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Pebble (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Predict Earth Movement" :prerequisites "4 Earth spells" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Purify Earth" :prerequisites "Apportation and Shape Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
                 {:name "Rain of Stones" :prerequisites "Magery 2 and Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 53"}
                 {:name "Sand Blast" :prerequisites "Magery 4, Sand Jet, and Sandstorm" :prerequisite_count 0 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Sand Jet" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Seek Earth" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Seek Pass" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Seismic Shock" :prerequisites "Magery 4 and at least 10 Earth spells, including Earthquake" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 13"}
                 {:name "Shape Earth" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Shape Stone" :prerequisites "Shape Earth and 3 other Earth spells" :prerequisite_count 5 :college "Earth" :ref "Fantasy, p. 169"}
                 {:name "Spotless Hands (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Steelwraith" :prerequisites "Magery 2 and Walk through Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Stone Missile" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Stone to Earth" :prerequisites "Earth to Stone or 4 Earth spells" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Stone to Flesh" :prerequisites "Magery 2, Flesh to Stone, and Stone to Earth" :prerequisite_count 5 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Summon Earth Elemental" :prerequisites "Magery 1 and either 8 Earth spells or 4 Earth spells and another Summon Elemental spell" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Volcano" :prerequisites "Earthquake and 6 Fire spells" :prerequisite_count 13 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Walk through Earth" :prerequisites "Shape Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Adjustable Clothing" :prerequisites "Enchant and Reshape" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
                 {:name "Amulet" :prerequisites "Talisman for the appropriate spell" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Compulsive Reader" :prerequisites "Enchant and 3 Mind Control spells or Writing-15+" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Costume" :prerequisites "Adjustable Clothing" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Item 3 p 30"}
                 {:name "Create Chimera" :prerequisites "Analyze Heredity, Enchant, and either Alter Body or Lightning" :prerequisite_count 0 :college "Enchantment" :ref "Bio-Tech, p. 31"}
                 {:name "Curse Virus/TL" :prerequisites "Spellprocessor and Animate Machine, Awaken Computer, Curse, Glitch, Mad Machine or Malfunction" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Tenchnomancer p. 20"}
                 {:name "Doom Wish" :prerequisites "Magery 3, Wish, and IQ + Magery of 23+" :prerequisite_count 18 :college "Enchantment" :ref "Magic: Artillery Spells p. 13-14"}
                 {:name "Doppelgänger" :prerequisites "Magery 3, Golem, History, and Enslave" :prerequisite_count 29 :college "Enchantment" :ref "Magic p. 62; Classic: Magic p 40"}
                 {:name "Dwarfish Reinforcement" :prerequisites "Enchant and Secret Spell (Dwarvish Reinforcement)" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Electric Power/TL" :prerequisites "Lend Power, Power, Steal Power" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 20"}
                 {:name "Emergency Staff (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Enchant" :prerequisites "Magery 2 and at least one spell from 10 other colleges" :prerequisite_count 10 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 56"}
                 {:name "Ensorcel" :prerequisites "Malefice" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Golem" :prerequisites "Enchant, Shape Earth, and Animation" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 59"}
                 {:name "Great Wish" :prerequisites "Magery 3, Wish, and (DX+IQ) 30+" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Hex" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Hideaway" :prerequisites "Enchant, Create Object, and Lighten" :prerequisite_count 15 :college "Enchantment" :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
                 {:name "Impart Skill" :prerequisites "Magery 3, Enchant, Lend Skill, Wisdom, Secret Spell (Impart Skill), and five Communication and Empathy spells" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Impression Blocker" :prerequisites "Enchant, Seeker, and Scrywall" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Leak" :prerequisites "Hideaway" :prerequisite_count 16 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Lesser Wish" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Ley Line Creation" :prerequisites "Seek Ley Line and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Thaumatology: Urban Magics, p. 21"}
                 {:name "Live Libram" :prerequisites "Enchant and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Malefice" :prerequisites "Enchant and Seeker" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Magician’s Minion (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8-9"}
                 {:name "Mana Warhead/TL" :prerequisites "Curse-Missile and spell in warhead" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 21"}
                 {:name "Mortal Malefice" :prerequisites "Magery 3, Malefice, and Soul Jar" :prerequisite_count 0 :college "Enchantment" :ref "Magic: Death Spells, p. 9"}
                 {:name "Narrative Conveyance" :prerequisites "Plane Shift, Timeport, and Writing-15+" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Power" :prerequisites "Enchant and Recover Energy" :prerequisite_count 12 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 57"}
                 {:name "Remove Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Resilient Golem" :prerequisites "Golem and Shatterproof" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Items 3 p 32"}
                 {:name "Resist Enchantment" :prerequisites "any Limiting Enchantment spell" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Scroll" :prerequisites "Magery 1 and 1 written Language at Accented or better" :prerequisite_count 0 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Simulacrum" :prerequisites "Magery 3, Golem, Perfect Illusion, and Illusion Disguise" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Sorcerer’s Stand-In (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Soul Golem" :prerequisites "Magery 3, Soul Jet, Golem, IQ 13+" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Grimoire p 42"}
                 {:name "Speed" :prerequisites "Enchant and Haste" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Spell Stone" :prerequisites "Enchant and Delay" :prerequisite_count 8 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Spellbook Enchantment" :prerequisites "Scroll" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Magic Items 2 p. 40"}
                 {:name "Spellgraft" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Bio-Tech, p. 32"}
                 {:name "Spellprocessor" :prerequisites "Scroll, Computer Programming-15+" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Technomancer p 19"}
                 {:name "Suspend Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Talisman" :prerequisites "Enchant and spell to be opposed" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Temporary Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 56; Fantasy, p. 23"}
                 {:name "Vengeful Staff" :prerequisites "Magery 3, Enchant, and Explode" :prerequisite_count 12 :college "Enchantment" :ref "Magic: Artillery Spells p. 14"}
                 {:name "Wish" :prerequisites "Lesser Wish and 1 spell each from 15 colleges" :prerequisite_count 17 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Balor's Eye Fire" :prerequisites "Magery 1, Flame Jet, Resist Fire, and either Secret Spell (Balor’s Eye Fire) or Tome of Power (Balor’s Treatise)" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Blast Ball" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Blast Ball)" :prerequisite_count 0 :college "Fire" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Body of Flames" :prerequisites "Breathe Fire" :prerequisite_count 8 :college "Fire" :ref "Magic p. 76"}
                 {:name "Breathe Fire" :prerequisites "Magery 1, Flame Jet, and Resist Fire" :prerequisite_count 7 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Death" :prerequisites "Magery 2, Heat, and Sickness" :prerequisite_count 10 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Touch" :prerequisites "Magery 2 and 6 Fire spells including Heat" :prerequisite_count 6 :college "Fire" :ref "Magic p. 76"}
                 {:name "Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
                 {:name "Control Fire Elemental" :prerequisites "Summon Fire Elemental" :prerequisite_count 9 :college "Fire" :ref "Magic p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Fire" :prerequisites "Ignite Fire or Seek Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 72"}
                 {:name "Create Fire Elemental" :prerequisites "Magery 2 and Control Fire Elemental" :prerequisite_count 10 :college "Fire" :ref "Magic p. 22"}
                 {:name "Cremate" :prerequisites "Magery 3, Burning Touch, Essential Flame, and Fast Fire" :prerequisite_count 0 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Deflect Energy" :prerequisites "Magery 1 and Shape Fire" :prerequisite_count 2 :college "Fire" :ref "Basic Set, p. 246; Magic p. 73"}
                 {:name "Detonate" :prerequisites "Ignite Fire, Shape Plastic" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ember (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Essential Flame" :prerequisites "6 Fire spells" :prerequisite_count 6 :college "Fire" :ref "Magic p. 75"}
                 {:name "Explosive Fireball" :prerequisites "Fireball" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 75"}
                 {:name "Explosive Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Explosive Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Extinguish Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 247; Magic p. 72"}
                 {:name "Fast Fire" :prerequisites "Slow Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Fire Cloud" :prerequisites "Shape Air and Fireball" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Fire Swarm" :prerequisites "Magery 4 and at least 10 Fire spells, including Fireball and Flame Jet" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Fireball" :prerequisites "Magery 1, Create Fire, and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Fireproof" :prerequisites "Extinguish Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flame Jet" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flameturning" :prerequisites "Resist Fire, or both Apportation and Shape Fire" :prerequisite_count 0 :college "Fire" :ref "Classic: Grimoire p. 30"}
                 {:name "Flaming Armor" :prerequisites "Magery 1, Resist Fire, and Flame Jet" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Missiles" :prerequisites "Flaming Weapon" :prerequisite_count 5 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Weapon" :prerequisites "Magery 2 and Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 75"}
                 {:name "Great Deflect Energy" :prerequisites "Magery 2, Secret Spell (Great Deflect Energy), and Deflect Energy" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
                 {:name "Heat" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Hellfire Breath" :prerequisites "Magery 4, Essential Flame, and Breathe Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Jet" :prerequisites "Magery 4, Essential Flame, and Flame Jet" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Hellfire Rain" :prerequisites "Magery 4, Essential Flame, and Rain of Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "High-Explosive Fireball" :prerequisites "Explosive Fireball, TL7+" :prerequisite_count 5 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ignite Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Improved Explosive Fireball" :prerequisites "Magery 4 and at least 10 Fire spells, including Explosive Fireball" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Mass Detonate" :prerequisites "Detonate" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Mass Resist Fire" :prerequisites "IQ 13+, Secret Spell (Mass Resist Fire), and Resist Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Oven Mitts (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Phantom Flame" :prerequisites "Shape Fire or Simple Illusion" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Puff (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Rain of Fire" :prerequisites "Magery 2 and Create Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Resist Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Resist Fire" :prerequisites "Extinguish Fire and Cold" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Shaped-Charge Fireball" :prerequisites "Magery, Fireball, Shape Metal" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p 21"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Seek Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic p. 72"}
                 {:name "Shape Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Slow Fire" :prerequisites "Extinguish Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 73"}
                 {:name "Smoke" :prerequisites "Shape Fire and Extinguish Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Snuff Life's Flame" :prerequisites "Magery 3 and Body of Flames" :prerequisite_count 9 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Summon Fire Elemental" :prerequisites "Magery 1 and either 8 Fire spells or 4 Fire spells and another Summon Elemental spell" :prerequisite_count 8 :college "Fire" :ref "Magic p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Towering Inferno" :prerequisites "Magery 4 and at least 7 Fire spells, including Fire Cloud and Rain of Fire" :prerequisite_count 7 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Warmth" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 74"}
                 {:name "Accelerate Time" :prerequisites "Magery 2, IQ 13+ and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Beacon" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Gate" :ref "Magic p. 83; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Blink" :prerequisites "Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 148"}
                 {:name "Blink Other" :prerequisites "Blink" :prerequisite_count 6 :college "Gate" :ref "Magic p. 148"}
                 {:name "Control Gate" :prerequisites "Magery 3 and Seek Gate" :prerequisite_count 12 :college "Gate" :ref "Magic p. 85"}
                 {:name "Create Door" :prerequisites "Teleport and any 1 Walk through spell" :prerequisite_count 10 :college "Gate" :ref "Magic p. 84"}
                 {:name "Create Gate" :prerequisites "Control Gate and either Teleport, Timeport, or Plane Shift" :prerequisite_count 14 :college "Gate" :ref "Magic p. 85/Classic: Grimoire p 50"}
                 {:name "Dimensional Dissection" :prerequisites "Magery 3 and one of Plane Shift Other, Teleport Other, or Timeport Other" :prerequisite_count 0 :college "Gate" :ref "Magic: Death Spells, p. 13"}
                 {:name "Divert Teleport" :prerequisites "Mager 3 and Trace Teleport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 84"}
                 {:name "Easy Rider (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Hell Zone" :prerequisites "Magery 4, Beacon, and Planar Summons for at leastone realm the GM deems “hostile." :prerequisite_count 0 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Hide Object" :prerequisites "Hideaway and Teleport" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Invoke (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 14-15"}
                 {:name "Null Sphere" :prerequisites "Magery 5 and Create Gate" :prerequisite_count 15 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Phase" :prerequisites "Magery 3 and either Plane Shift or Ethereal Body" :prerequisite_count 5 :college "Gate" :ref "Magic p. 83"}
                 {:name "Phase Other" :prerequisites "Phase" :prerequisite_count 6 :college "Gate" :ref "Magic p. 83"}
                 {:name "Planar Summons" :prerequisites "Magery 1 and at least 1 spell from 10 other colleges" :prerequisite_count 10 :college "Gate" :ref "Basic Set p. 247; Magic p. 82"}
                 {:name "Planar Visit" :prerequisites "Magery 2 and either Projection or Planar Summons" :prerequisite_count 11 :college "Gate" :ref "Magic p. 82"}
                 {:name "Plane Shift" :prerequisites "Planar Summons" :prerequisite_count 11 :college "Gate" :ref "Basic Set p. 247; Magic p. 83"}
                 {:name "Plane Shift Other" :prerequisites "Magery 3 and Plane Shift" :prerequisite_count 12 :college "Gate" :ref "Magic p. 83"}
                 {:name "Rapid Journey" :prerequisites "Magery 3 and either Teleport or Timeport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 82"}
                 {:name "Reorient (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Sanctuary" :prerequisites "Hide Object" :prerequisite_count 21 :college "Gate" :ref "Magic p. 86"}
                 {:name "Scry Gate" :prerequisites "Seek Gate" :prerequisite_count 11 :college "Gate" :ref "Magic p. 85"}
                 {:name "Seek Gate" :prerequisites "Magery 2, Seek Magic, and 1 spell from each of 10 colleges" :prerequisite_count 10 :college "Gate" :ref "Magic p. 85"}
                 {:name "Slow Time" :prerequisites "Magery 2, IQ 13+, and 2 spells from each of 10 colleges" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Splat" :prerequisites "Magery 4 and Create Door" :prerequisite_count 0 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Suspend Time" :prerequisites "Magery 3 and Slow Time" :prerequisite_count 21 :college "Gate" :ref "Magic p. 86"}
                 {:name "Teleport" :prerequisites "Hawk Flight or IQ 15+, and 1 spell from 10 colleges" :prerequisite_count 4 :college "Gate" :ref "Magic p. 147; Fantasy, p. 171"}
                 {:name "Teleport Other" :prerequisites "Magery 3 and Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 147"}
                 {:name "Teleport Shield" :prerequisites "Watchdog and either Spell Shield or Teleport" :prerequisite_count 7 :college "Gate" :ref "Magic p. 170"}
                 {:name "Time Out" :prerequisites "Magery 3 and Accelerate Time" :prerequisite_count 21 :college "Gate" :ref "Magic p. 87"}
                 {:name "Timeport" :prerequisites "Magery 3 and Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeport Other" :prerequisites "Timeport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeslip" :prerequisites "Timeport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeslip Other" :prerequisites "Timeslip" :prerequisite_count 7 :college "Gate" :ref "Magic p. 81"}
                 {:name "Trace Teleport" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Gate" :ref "Magic p. 84"}
                 {:name "Underworld Imprisonment" :prerequisites "Magery 3 and at least one Plane Shift Other spell" :prerequisite_count 13 :college "Gate" :ref "Magic: Death Spells, p. 13"}
                 {:name "Aid (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Aide (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Analgesic (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Archmagi's Recuperation" :prerequisites "Prerequisites: IQ 14+, Magery 4, Lend Energy, and Secret Spell (Archmagi’s Recuperation)" :prerequisite_count 0 :college "Healing" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Awaken" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Basic Set, p. 248; Magic p. 90"}
                 {:name "Bender Defender (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Birth Control (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Body-Reading" :prerequisites "Sense Life or Awaken" :prerequisite_count 1 :college "Healing" :ref "Magic p. 91"}
                 {:name "Cleansing" :prerequisites "Minor Healing and Purify Earth" :prerequisite_count 12 :college "Healing" :ref "Magic p. 94"}
                 {:name "Cure Addiction" :prerequisites "Relieve Addiction" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 55"}
                 {:name "Cure Dehydration" :prerequisites "Magery, Minor Healing, Create Water" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 52"}
                 {:name "Cure Disease" :prerequisites "Major Healing and Relieve Sickness" :prerequisite_count 5 :college "Healing" :ref "Magic p. 91; Fantasy, p. 170"}
                 {:name "Cure Insanity" :prerequisites "Major Healing, Relieve Madness, 5 Mind Control spells" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 55"}
                 {:name "Cure Radiation" :prerequisites "Resist Radiation and Major Healing" :prerequisite_count 12 :college "Healing" :ref "Magic p. 182"}
                 {:name "Cure Starvation" :prerequisites "Magery, Minor Healing, Create Food" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 52"}
                 {:name "Detect Poison" :prerequisites "Sense Danger or Test Food" :prerequisite_count 1 :college "Healing" :ref "Magic p. 166"}
                 {:name "Disinfect" :prerequisites "Magery 4 and at least 10 Healing spells, including Cure Disease and Remove Contagion" :prerequisite_count 10 :college "Healing" :ref "Magic: Artillery Spells p. 17"}
                 {:name "Ease Labor" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
                 {:name "Euthanize" :prerequisites "Any of Empathy, Magery 1, Spirit Empathy, or “holy” status" :prerequisite_count 0 :college "Healing" :ref "Magic: Death Spells, p. 14"}
                 {:name "Final Rest" :prerequisites "Magery 1 or Spirit Empathy" :prerequisite_count 0 :college "Healing" :ref "Magic p. 89"}
                 {:name "Great Healing" :prerequisites "Magery 3 and Major Healing" :prerequisite_count 4 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Halt Aging" :prerequisites "Magery 2 and 8 Healing spells" :prerequisite_count 8 :college "Healing" :ref "Magic p. 94"}
                 {:name "Healing Slumber" :prerequisites "Magery 2, Sleep, and Minor Healing" :prerequisite_count 6 :college "Healing" :ref "Magic p. 94"}
                 {:name "Instant Neutralize Poison" :prerequisites "Magery 2 and Neutralize Poison" :prerequisite_count 2 :college "Healing" :ref "Magic p. 92"}
                 {:name "Instant Regeneration" :prerequisites "Magery 3 and Regeneration" :prerequisite_count 6 :college "Healing" :ref "Magic p. 93"}
                 {:name "Instant Restoration" :prerequisites "Magery 2 and Restoration" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Lend Energy" :prerequisites "Magery 1 or Empathy" :prerequisite_count 0 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Lend Vitality (Health)" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Major Healing" :prerequisites "Magery 1 and Minor Healing" :prerequisite_count 3 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Mass Resist Disease" :prerequisites "IQ 13+, Secret Spell (Mass Resist Disease), and Resist Disease" :prerequisite_count 4 :college "Healing" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Mass Resist Poison" :prerequisites "IQ 13+, Secret Spell (Mass Resist Poison), and Resist Poison" :prerequisite_count 4 :college "Healing" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Minor Healing" :prerequisites "Lend Vitality" :prerequisite_count 0 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Neutralize Poison" :prerequisites "Cure Disease or Magery 3 and Test Food" :prerequisite_count 1 :college "Healing" :ref "Magic p. 92"}
                 {:name "Recover Energy" :prerequisites "Magery 1 and Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Regeneration" :prerequisites "Magery 2 and Restoration" :prerequisite_count 5 :college "Healing" :ref "Magic p. 93"}
                 {:name "Relieve Addiction" :prerequisites "Neutralize Poison" :prerequisite_count 2 :college "Healing" :ref "Magic p. 92|-"}
                 {:name "Relieve Madness" :prerequisites "Lend Vitality and Wisdom" :prerequisite_count 9 :college "Healing" :ref "Magic p. 92"}
                 {:name "Relieve Paralysis" :prerequisites "Stop Paralysis" :prerequisite_count 2 :college "Healing" :ref "Magic p. 93"}
                 {:name "Relieve Sickness" :prerequisites "Lend Vitality" :prerequisite_count 9 :college "Healing" :ref "Magic p. 90"}
                 {:name "Remove Contagion" :prerequisites "Decay, Clean, or Cure Disease" :prerequisite_count 2 :college "Healing" :ref "Magic p. 90"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Healing" :ref "Bio-Tech, p. 32; Technomancer p. 22"}
                 {:name "Resist Disease" :prerequisites "Remove Contagion or Vigor" :prerequisite_count 3 :college "Healing" :ref "Magic p. 90"}
                 {:name "Resist Poison" :prerequisites "Vigor" :prerequisite_count 3 :college "Healing" :ref "Magic p. 91"}
                 {:name "Restoration" :prerequisites "either Major Healing or 2 of Relieve Paralysis or Restore spells" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Restore Hearing" :prerequisites "Minor Healing and either Keen Hearing or Strike Deaf" :prerequisite_count 4 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Memory" :prerequisites "Awaken and IQ 11+" :prerequisite_count 3 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Sight" :prerequisites "Minor Healing and either Keen Vision or Strike Blind" :prerequisite_count 4 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Speech" :prerequisites "Minor Healing and either Great Voice or Strike Dumb" :prerequisite_count 6 :college "Healing" :ref "Magic p. 93"}
                 {:name "Resurrection" :prerequisites "Instant Regeneration and Summon Spirit" :prerequisite_count 9 :college "Healing" :ref "Magic p. 94"}
                 {:name "Resuscitate" :prerequisites "Magery 2, Awaken, and Stop Spasm" :prerequisite_count 0 :college "Healing" :ref "Magic: Death Spells, p. 14"}
                 {:name "Sea Legs (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Sense Disease" :prerequisites "Sense Life or 2 Healing spells" :prerequisite_count 1 :college "Healing" :ref "Bio-Tech, p. 32; Technomaner p 22"}
                 {:name "Share Energy" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Magic p. 89"}
                 {:name "Share Vitality" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 90"}
                 {:name "Stop Bleeding" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 91; Fantasy, p. 169"}
                 {:name "Stop Paralysis" :prerequisites "Minor Healing and Paralyze Limb, or Strike Dumb" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Stop Spasm" :prerequisites "Spasm or Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 35"}
                 {:name "Suspended Animation" :prerequisites "Sleep and 4 Healing spells" :prerequisite_count 7 :college "Healing" :ref "Magic p. 94"}
                 {:name "Test (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Healing" :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
                 {:name "Transference Bolt" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Transference Bolt)" :prerequisite_count 0 :college "Healing" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Youth" :prerequisites "Magery 3 and Halt Aging" :prerequisite_count 9 :college "Healing" :ref "Magic p. 94"}
                 {:name "Blend In (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Complex Illusion" :prerequisites "Sound and Simple Illusion" :prerequisite_count 2 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
                 {:name "Control Creation" :prerequisites "Create Animal or Create Servant" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Control Illusion" :prerequisites "Perfect Illusion" :prerequisite_count 2 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Create Animal" :prerequisites "Create Water, Create Object, and IQ 12+" :prerequisite_count 12 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Foreign Body" :prerequisites "Magery 3, Body-Reading, and Create Object" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Death Spells, p. 14"}
                 {:name "Create Mount" :prerequisites "Magery 3 and Create Animal" :prerequisite_count 13 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Create Object" :prerequisites "Magery 2, Create Earth, and Perfect Illusion" :prerequisite_count 8 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Servant" :prerequisites "Magery 3, IQ 12+, and Create Object" :prerequisite_count 9 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Trap" :prerequisites "Magery 4 and at least 10 Illusion and Creation spells, including Create Object" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic: Artillery Spells p. 17"}
                 {:name "Create Warrior" :prerequisites "Create Servant" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Disbelieve (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Dispel Creation" :prerequisites "Control Creation" :prerequisite_count 11 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Dispel Illusion" :prerequisites "Control Illusion" :prerequisite_count 5 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Duplicate" :prerequisites "Create Object and Copy" :prerequisite_count 15 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Gargoyle Skin (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Illusion Disguise" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170"}
                 {:name "Illusion Shell" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
                 {:name "Image (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Independence" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96"}
                 {:name "Initiative" :prerequisites "Independence and Wisdom" :prerequisite_count 9 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Inscribe" :prerequisites "Simple Illusion and Copy" :prerequisite_count 7 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Know Illusion" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Mirror, Mirror" :prerequisites "Magery 4, Initiative, and Phantom" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Artillery Spells p. 17-18"}
                 {:name "Perfect Illusion" :prerequisites "Magery 1 and Complex Illusion" :prerequisite_count 3 :college "Illusion_and_Creation" :ref "Magic p. 96; 'Social Engineering: Back to School, p. 24"}
                 {:name "Phantom" :prerequisites "Magery 2, Perfect Illusion, Hinder, and Apportation" :prerequisite_count 7 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Phantom Flame" :prerequisites "Shape Fire or Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 73"}
                 {:name "Phantom Killer" :prerequisites "Magery 3 and Phantom" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Death Spells, p. 14"}
                 {:name "Shadowplay (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Simple Illusion" :prerequisites "no Blindness and IQ 11+" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic p. 95; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
                 {:name "Stand Out (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Air Vision" :prerequisites "Shape Air" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 24"}
                 {:name "Alarm" :prerequisites "Tell Time" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Analyze Magic" :prerequisites "Identify Spell" :prerequisite_count 3 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 102"}
                 {:name "Analyze Heredity (Analyze Genetics)" :prerequisites "Seeker or Sense Life" :prerequisite_count 1 :college "Knowledge" :ref "Bio-Tech, p. 30; Technomancer p 23"}
                 {:name "Ancient History" :prerequisites "History" :prerequisite_count 5 :college "Knowledge" :ref "Magic, p. 106"}
                 {:name "Astral Vision" :prerequisites "Sense Spirit and See Invisible" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Aura" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 101"}
                 {:name "Detect Magic" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 101"}
                 {:name "Divination" :prerequisites "History, and other spells by specialty" :prerequisite_count nil :college "Knowledge" :ref "Magic, p. 108; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Earth Vision" :prerequisites "Shape Earth" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 51"}
                 {:name "Echoes of the Past" :prerequisites "Magery 2, History, and Voices" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 107"}
                 {:name "Far-Feeling" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Far-Hearing" :prerequisites "Magery 1 and 4 Sound spells; may not have Deafness or Hard of Hearing" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 173"}
                 {:name "Far-Tasting" :prerequisites "Magery 1 and either Seek Food or Seek Air; cannot have No Sense of Taste/Smell" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 77"}
                 {:name "Find Direction" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Forbidden Wisdom" :prerequisites "Magery 3, Recall, and See Secrets" :prerequisite_count 0 :college "Knowledge" :ref "Magic: Death Spells, p. 15"}
                 {:name "Glass Wall" :prerequisites "5 other Knowledge spells or Earth Vision" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 103"}
                 {:name "History" :prerequisites "Trace" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Identify Loot" :prerequisites "Magery 2, Secret Spell (Identify Loot), and 7 Fourth-Level spells" :prerequisite_count 0 :college "Knowledge" :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
                 {:name "Identify Spell" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 102"}
                 {:name "Images of the Past" :prerequisites "Magery 2, History, and Simple Illusion" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Invisible Wizard Eye" :prerequisites "Wizard Eye and Invisibility" :prerequisite_count 10 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Keyfinder (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Know Location" :prerequisites "Magery 1 and Tell Position" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 103"}
                 {:name "Know Recipe" :prerequisites "Far-Tasting and Season" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 78"}
                 {:name "Know Thyself (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Know True Shape" :prerequisites "Magery 1, 1 shifting spell, and either Aura or Know Illusion" :prerequisite_count 9 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Mage Sense" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Mage Sight" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Measurement" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Memorize" :prerequisites "Wisdom or 6 Knowledge spells" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105; Social Engineering: Back to School, p. 24"}
                 {:name "Metal Vision" :prerequisites "Shape Metal" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 183"}
                 {:name "Mind over Matter" :prerequisites "Magery 2, Divination (any), Mage Sight, and Secret Spell (Mind over Matter)." :prerequisite_count 0 :college "Knowledge" :ref "Magic Styles: Dungeon Magic, p. 27"}
                 {:name "Necrovision" :prerequisites "Lightning, Seek Emitter" :prerequisite_count 0 :college "Knowledge" :ref "Technomancer p 23"}
                 {:name "Pathfinder" :prerequisites "Magery 1, IQ 12+, and 2 Seek spells; also a license from Paizo" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Plant Vision" :prerequisites "Shape Plant" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 162"}
                 {:name "Plastic Vision" :prerequisites "Shape Plastic" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 183"}
                 {:name "Prehistory" :prerequisites "Ancient History" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Projection" :prerequisites "Sense Spirit and 4 Knowledge spells" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Recall" :prerequisites "Magery 2, Memorize, and History" :prerequisite_count 9 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Reconstruct Spell" :prerequisites "Magery 2, History, and Identify Spell" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Remember Path" :prerequisites "Find Direction and Memorize" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Retro-Reading" :prerequisites "Trace" :prerequisite_count 4 :college "Knowledge" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Scents of the Past" :prerequisites "Magery 2, History, and Odor" :prerequisite_count 8 :college "Knowledge" :ref "Magic, p. 107"}
                 {:name "Schematic/TL" :prerequisites "Reveal Function and History" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 177"}
                 {:name "See Secrets" :prerequisites "Seeker and Aura" :prerequisite_count 5 :college "Knowledge" :ref "Magic, p. 105; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Seek Ley Line" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Seek Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Seek Navy" :prerequisites "Secret Spell (Seek Navy) and 8 Third-Level spells" :prerequisite_count 0 :college "Knowledge" :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
                 {:name "Seek Number/TL" :prerequisites "Magery, TL 6+" :prerequisite_count 0 :college "Knowledge" :ref "Technomancer p. 18"}
                 {:name "Seeker" :prerequisites "Magery 1, IQ 12+, and 2 'Seek 'spells" :prerequisite_count 2 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 105"}
                 {:name "Sense Mana" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Small Vision" :prerequisites "Keen Vision or 5 Light and Darkness spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 111"}
                 {:name "Summon Shade" :prerequisites "Summon Spirit or Divination" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Sweet Oblivion (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Televisomancy" :prerequisites "Magery, and either six other Technological spells orElectronics Operation (Communications) 15+" :prerequisite_count 0 :college "Knowledge" :ref "Classic: Technomancer p 23"}
                 {:name "Tell Position" :prerequisites "Measurement" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Tell Time" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Test (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Test Load (Test Area)" :prerequisites "Measurement" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Thaumatomancy" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Trace" :prerequisites "Seeker" :prerequisite_count 3 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 106"}
                 {:name "Vision of Doom" :prerequisites "Magery 3 and Summon Shade" :prerequisite_count 0 :college "Knowledge" :ref "Magic: Death Spells, p. 15"}
                 {:name "Water Vision" :prerequisites "Shape Water" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 187"}
                 {:name "Wizard Ear" :prerequisites "Apportation, Far-Hearing, and Sound Vision" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Eye" :prerequisites "Apportation and Keen Vision" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Hand" :prerequisites "Manipulate and Far-Feeling" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Mouth" :prerequisites "Apportation, Far-Tasting, and Great Voice" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Nose" :prerequisites "Apportation and Far-Tasting" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Blackout" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Blur" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Basic Set p. 250; Magic p. 113"}
                 {:name "Body of Shadow" :prerequisites "Magery 2 and Shape Darkness" :prerequisite_count 4 :college "Light_and_Darkness" :ref "M114"}
                 {:name "Bright Vision" :prerequisites "Keen Vision or 5 Light spells; no Blindness" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Cleansing Light" :prerequisites "Magery 3 and 10 Light and Darkness spells, including Flash, Light Jet, and Sunbolt" :prerequisite_count 10 :college "Light_and_Darkness" :ref "Magic: Death Spells, p. 16"}
                 {:name "Coherent Light Jet" :prerequisites "Light Jet" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Colors" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 110"}
                 {:name "Continual Light" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Basic Set p. 249; Magic p. 110"}
                 {:name "Continual Mage Light" :prerequisites "Mage Light and Continual Light" :prerequisite_count 5 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Continual Sunlight" :prerequisites "Sunlight" :prerequisite_count 5 :college "Light_and_Darkness" :ref "Classic: Magic p 64/Magic, p. 114"}
                 {:name "Dark Vision" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Darkness" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Basic Set p. 250; Magic p. 111"}
                 {:name "Disruption Bolt" :prerequisites "Spectrum Vision, and any 6 Light and Darkness or Technological (Radiation) spells" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Technomancer p 24"}
                 {:name "Flash" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Gloom" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Glow" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Goggles (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Hawk Vision" :prerequisites "Keen Vision or 5 Light spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Hide" :prerequisites "Blur or Forgetfulness" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113; Fantasy, p. 170"}
                 {:name "Images of the Past" :prerequisites "Magery 2, History, and Simple Illusion" :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 105"}
                 {:name "Infrared Flash" :prerequisites "Flash, Colors" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Infravision" :prerequisites "Keen Vision or 5 Light spells" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Invisibility" :prerequisites "Magery 2, IQ 13+, Invisibility, and Secret Spell (Mass Invisibility." :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 114; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Invisible Sunbolt/TL" :prerequisites "Magery 3, Spectrum Vision, Sunbolt" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Light" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Basic Set p. 253; Magic p. 110"}
                 {:name "Light Jet" :prerequisites "Continual Light or Shape Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Mage Light" :prerequisites "Mage Sight and Light" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Mass Invisibility" :prerequisites "Magery 2, IQ 13+, Hallucination, and Secret Spell (Mass Hallucination" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic Styles: Dungeon Magic, p. 32"}
                 {:name "Mass Shade" :prerequisites "IQ 12+ and Shade and Secret Spell (Mass Shade" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Mirror" :prerequisites "Colors" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Night Vision" :prerequisites "5 Light and Darkness spells or Keen Vision" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111; Fantasy, p. 170"}
                 {:name "Phosphorescence (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Remove Reflection" :prerequisites "Remove Shadow" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Remove Shadow" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 110"}
                 {:name "See Invisible" :prerequisites "either Dark Vision and Infravision, or Invisibility" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Shadowplay" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Shadow-Slay" :prerequisites "Magery 3, Body of Shadow, and Remove Shadow" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: Death Spells, p. 16"}
                 {:name "Shade" :prerequisites "Continual Light or Shield" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 169"}
                 {:name "Shape Darkness" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Shape Light" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Small Vision" :prerequisites "Keen Vision or 5 Light and Darkness spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Sunbolt" :prerequisites "6 Light and Darkness spells including Sunlight" :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 114"}
                 {:name "Sunburst" :prerequisites "Magery 4 and at least 10 Light and Darkness spells, including Light Jet and Sunbolt" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: Artillery Spells p. 18"}
                 {:name "Sunlight" :prerequisites "Magery 1, Glow, and Colors" :prerequisite_count 4 :college "Light_and_Darkness" :ref "Magic p. 114"}
                 {:name "Twinkle (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Wall of Light" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Animate Object" :prerequisites "Magery 2 and 3 Shape spells" :prerequisite_count 6 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Annihilation" :prerequisites "Magery 3, Disintegrate, and either Deathtouch or Steal Vitality" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: Death Spells, p. 16"}
                 {:name "Awaken Craft Spirit" :prerequisites "Inspired Creation and Sense Spirit" :prerequisite_count 3 :college "Making_and_Breaking" :ref "Magic p. 115"}
                 {:name "Clean" :prerequisites "Restore" :prerequisite_count 2 :college "Making_and_Breaking" :ref "Magic p. 116; Classic: Technomancer p 25"}
                 {:name "Contract Object" :prerequisites "Magery 3 and Transform Object" :prerequisite_count 15 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Copy" :prerequisites "Dye and 1 written Language at Accented" :prerequisite_count 5 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Destabilization" :prerequisites "Magery 3, Annihilation, and Explode" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: Death Spells, p. 16"}
                 {:name "Disintegrate" :prerequisites "Magery 2, Shatter, Ruin, Earth to Air, Destroy Air, and Destroy Water" :prerequisite_count 17 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Draw Together Shards" :prerequisites "Repair, Trace, and Apportation" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Alphabet Arcane, p. 9"}
                 {:name "Dye" :prerequisites "Restore and Colors" :prerequisite_count 4 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Enlarge Object" :prerequisites "Extend Object" :prerequisite_count 16 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Explode" :prerequisites "Magery 2, Shatter, and Apportation" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Explosive Mine " :prerequisites "Magery 3 and at least 10 Making and Breaking spells, including Explode" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic: Artillery Spells p. 19"}
                 {:name "Extend Object" :prerequisites "Magery 3 and Transform Object" :prerequisite_count 15 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Fasten" :prerequisites "Knot" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Find Weakness" :prerequisites "1 spell from each of 4 elements" :prerequisite_count 4 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Immediate Action" :prerequisites "Apportation or Find Weakness" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Classic: Technomancer p. 25"}
                 {:name "Inscribe" :prerequisites "Simple Illusion and Copy" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 97"}
                 {:name "Inspired Creation" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic p. 115"}
                 {:name "Knot" :prerequisites "Stiffen" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Mapmaker" :prerequisites "Inscribe and Measurement" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Minefield " :prerequisites "Magery 4 and Explosive Mine" :prerequisite_count 11 :college "Making_and_Breaking" :ref "Magic: Artillery Spells p. 19"}
                 {:name "Mystic Mark" :prerequisites "Dye and Trace" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Rebuild/TL" :prerequisites "Magery 3, Repair, Create Object, and 3 spells of each element" :prerequisite_count 22 :college "Making_and_Breaking" :ref "Magic p. 177"}
                 {:name "Rejoin" :prerequisites "Weaken and Restore" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Repair" :prerequisites "Magery 2 and Rejoin" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Reshape" :prerequisites "Magery 1, Weaken, and either Shape Earth or Shape Plant" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Restore" :prerequisites "Find Weakness or Simple Illusion" :prerequisite_count 1 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Rive" :prerequisites "Magery 2 and Shatter" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Ruin" :prerequisites "Magery 1, Weaken, and Decay" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Self-Repairing" :prerequisites "Magery 2, Repair, and Secret Spell (Self-Repairing)" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
                 {:name "Sharpen" :prerequisites "Repair" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Shatter" :prerequisites "Magery 1 and Weaken" :prerequisite_count 6 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Shatterproof" :prerequisites "Repair and Shatter" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Shrink Object" :prerequisites "Contract Object" :prerequisite_count 16 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Soilproof" :prerequisites "Materialize" :prerequisite_count 3 :college "Making_and_Breaking" :ref "Magic p. 116; Thaumatology: Urban Magics, p. 33"}
                 {:name "Soul Creation" :prerequisites "Inspired Creation" :prerequisite_count 1 :college "Making_and_Breaking" :ref "Classic: Magic Items 3 p. 31"}
                 {:name "Stiffen" :prerequisites "Rejoin" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Tack (A)" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Toughen" :prerequisites "Shatterproof" :prerequisite_count 11 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Transfigure Object" :prerequisites "Magery 3, Transform Object, and Secret Spell (Transfigure Object)" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
                 {:name "Transform Object" :prerequisites "M2, Reshape, 4 Create spells" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Transparency" :prerequisites "Dye and Stone to Earth" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Weaken" :prerequisites "Find Weakness" :prerequisite_count 5 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Weapon Self" :prerequisites "Magery 2, Apportation, and 6 Making and Breaking spells including Reshape" :prerequisite_count 12 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Wizardly Workshop (A)" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Bless" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 129"}
                 {:name "Catch Spell" :prerequisites "Magery 2, DX 12+, and Return Missile" :prerequisite_count 2 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Charge Powerstone" :prerequisites "Magery 3, Powerstone, and Lend Energy" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 126/Classic: Grimoire p. 74"}
                 {:name "Conceal Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122, Thaumatology: Urban Magics"}
                 {:name "Counterspell" :prerequisites "Magery 1 and spell being countered" :prerequisite_count 0 :college "Meta-Spell" :ref "Basic Set, p. 250; Magic p. 121"}
                 {:name "Curse" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 129"}
                 {:name "Dispel Magic" :prerequisites "Counterspell and at least 12 other spells" :prerequisite_count 13 :college "Meta-Spell" :ref "Basic Set, p. 250; Magic p. 126"}
                 {:name "Dispel Spark" :prerequisites "Magery 3, Drain Mana, and Remove Aura" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Death Spells, p. 17"}
                 {:name "Displace Spell" :prerequisites "Suspend Magic" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic p. 124, Thaumatology: Urban Magics"}
                 {:name "Drain Magery" :prerequisites "Magery 3 and Suspend Magery" :prerequisite_count 21 :college "Meta-Spell" :ref "Magic p. 130"}
                 {:name "Drain Mana" :prerequisites "Dispel Magic and Suspend Mana" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Dread Curse" :prerequisites "Magery 3 and Curse" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Death Spells, p. 17"}
                 {:name "End Scene" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 37"}
                 {:name "False Aura" :prerequisites "Conceal Magic and Aura" :prerequisite_count 5 :college "Meta-Spell" :ref "Magic p. 122"}
                 {:name "Great Ward" :prerequisites "Magery 2 and Ward" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122"}
                 {:name "Hang Spell" :prerequisites "Delay" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 128; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
                 {:name "Internalize Elixir" :prerequisites "Magery 1, Detect Magic, and Know Recipie" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 10"}
                 {:name "Lend Spell" :prerequisites "Magery 1, Lend Skill, and 1 spell each from 6 colleges" :prerequisite_count 11 :college "Meta-Spell" :ref "Magic p. 126"}
                 {:name "Ley Buffer" :prerequisites "Magery 1 and Ley Tap" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 20"}
                 {:name "Ley Line Creation" :prerequisites "Seek Ley Line and Apportation" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 21"}
                 {:name "Ley Supply" :prerequisites "Ley Tap and either Lend Energy or Minor Draw Power" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 20"}
                 {:name "Magic Resistance" :prerequisites "Magery 1 and 1 spell each from 7 colleges" :prerequisite_count 7 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Mana Storm" :prerequisites "Magery 4, Drain Mana, and Restore Man" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 19-20"}
                 {:name "Mana Vortex" :prerequisites "Magery 2, Lend Energy, Sense Danger, Sense Mana, and Secret Spell (Mana Vortex)." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 27; Thaumatology: Urban Magics"}
                 {:name "Maintain Spell" :prerequisites "Link" :prerequisite_count 17 :college "Meta-Spell" :ref "Magic p. 128; Thaumatology: Urban Magics"}
                 {:name "Penetrating Spell" :prerequisites "Delay and Find Weakness" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Pentagram" :prerequisites "Spell Shield" :prerequisite_count 9 :college "Meta-Spell" :ref "Magic p. 124; Thaumatology: Urban Magics"}
                 {:name "Preemptive Experience" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 37"}
                 {:name "Punishment Circle" :prerequisites "Magery 3 and either Pentagram or Repel Spirits" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 19-20"}
                 {:name "Raise Cone of Power" :prerequisites "Lend Energy and either Pentagram or Restore Mana" :prerequisite_count 0 :college "Meta-Spell" :ref "GURPS Thaumatology, p. 52"}
                 {:name "Reflect" :prerequisites "Ward" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics"}
                 {:name "Remove Aura" :prerequisites "Dispel Magic and Aura" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Remove Curse" :prerequisites "Magery 2 and 1 spell from each of 15 colleges" :prerequisite_count 15 :college "Meta-Spell" :ref "Magic p. 126; Thaumatology: Urban Magics"}
                 {:name "Restore Mana" :prerequisites "Dispel Magic and Suspend Mana" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 128; Thaumatology: Urban Magics"}
                 {:name "Scryfool" :prerequisites "Magery 2, Sense Observation, and Simple Illusion" :prerequisite_count 3 :college "Meta-Spell" :ref "Magic p. 123; Classic: Grimoire p 74"}
                 {:name "Scryguard" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "GURPS Fantasy, p. 170; Thaumatology: Urban Magics"}
                 {:name "Scrywall" :prerequisites "Scryguard" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics, p. 33"}
                 {:name "Seek Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 102"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Sovereign Countermagic" :prerequisites "Magery 3, Analyze Magic, Dispel Magic, and Secret Spell (Sovereign CountermagicThaumatology: Urban Magics." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 28"}
                 {:name "Sovereign Ward" :prerequisites "Magery 3, Dispel Magic, Ward, and Secret Spell (Sovereign WardThaumatology: Urban Magics." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 28"}
                 {:name "Spell Shield" :prerequisites "Magery 2, Scryguard, and Magic Resistance" :prerequisite_count 8 :college "Meta-Spell" :ref "Magic p. 124"}
                 {:name "Spell Wall" :prerequisites "Spell Shield" :prerequisite_count 9 :college "Meta-Spell" :ref "Magic p. 124; Thaumatology: Urban Magics"}
                 {:name "Spellguard" :prerequisites "Dispel Magic" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127; Thaumatology: Urban Magics"}
                 {:name "Steal Spell" :prerequisites "Lend Spell and Great Ward" :prerequisite_count 13 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Suspend Curse" :prerequisites "Magery 1 and 1 spell each from 12 colleges" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 125"}
                 {:name "Suspend Magery" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 130"}
                 {:name "Suspend Magic" :prerequisites "Suspend Spell and 8 other spells" :prerequisite_count 8 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Suspend Mana" :prerequisites "Suspend Magic and 1 spell each from 10 colleges" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic p. 125"}
                 {:name "Suspend Spell" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic p. 121; Thaumatology: Urban Magics"}
                 {:name "Telecast" :prerequisites "Magery 3, Teleport, Wizard Eye, and 1 spell each from 10 colleges" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 128"}
                 {:name "Thaumatomancy (A)" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Throw Spell" :prerequisites "Delay and Catch Spell" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 128"}
                 {:name "Use Item (A)" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: The Least of Spells p. 12-13"}
                 {:name "Void Bolt" :prerequisites "Magery 4, 4 Essential element spells of different colleges, and 4 missile spells, 1 from each of the Essential element spells taken as prerequisites" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/25: Epic Magic, p. 19"}
                 {:name "Ward" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics"}
                 {:name "Air Jet" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vision" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Air Vortex" :prerequisites "Magery 2, Body of Air, and Windstorm" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Atmosphere Dome" :prerequisites "Purify Air and Weather Dome" :prerequisite_count 9 :college "Air" :ref "Magic p. 169"}
                 {:name "Ball of Lightning" :prerequisites "Apportation and Lightning" :prerequisite_count 8 :college "Air" :ref "Magic p. 197"}
                 {:name "Body of Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 24"}
                 {:name "Body of Lightning" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Body of Wind" :prerequisites "Magery 3, Body of Air-16+, Windstorm-16+ and 1 spell from each of 5 different colleges besides Air" :prerequisite_count 10 :college "Air" :ref "Magic p. 27"}
                 {:name "Breathe Air" :prerequisites "Create Water and Destroy Air" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Breathe Water" :prerequisites "Create Air and Destroy Water" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 250; Magic p. 189"}
                 {:name "Chain Lightning" :prerequisites "Magery 4, Ball of Lightning, and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Cloud (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Cloud of Doom" :prerequisites "Magery 4 and at least 10 Air spells, including Devitalize Air and Stench" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Clouds" :prerequisites "2 Water spells and 2 Air spells" :prerequisite_count 4 :college "Air" :ref "Magic p. 194"}
                 {:name "Concussion" :prerequisites "Shape Air and Thunderclap" :prerequisite_count 5 :college "Air" :ref "Magic p. 26"}
                 {:name "Cool" :prerequisites "Cold and 4 Air spells" :prerequisite_count 9 :college "Air" :ref "Magic p. 195"}
                 {:name "Control Air Elemental" :prerequisites "Summon Air Elemental" :prerequisite_count 9 :college "Air" :ref "Magic p. 28"}
                 {:name "Create Air" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 23"}
                 {:name "Create Air Elemental" :prerequisites "Magery 2 and Control Air Elemental" :prerequisite_count 10 :college "Air" :ref "Magic p. 22"}
                 {:name "Destroy Air" :prerequisites "Purify Air" :prerequisite_count 2 :college "Air" :ref "Magic p. 43"}
                 {:name "Devitalize Air" :prerequisites "Destroy Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Diver's Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Electric Armor" :prerequisites "Magery, Lightning and Resist Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Missiles" :prerequisites "Electric Weapon" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 27"}
                 {:name "Electric Weapon" :prerequisites "Magery 2, Lightning" :prerequisite_count 0 :college "Air" :ref "Classic: Grimoire p 28"}
                 {:name "Embolism" :prerequisites "Magery 3, Body of Air, and Essential Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Essential Air" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 26"}
                 {:name "Explosive Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Falling Sky" :prerequisites "Magery 4 and at least eight Air spells, including Concussion and Destroy Air" :prerequisite_count 8 :college "Air" :ref "Magic: Artillery Spells p. 9"}
                 {:name "Improved Concussion;" :prerequisites "Magery 4 and at least seven Sound spells including Concussion and Great Voice" :prerequisite_count 7 :college "Air" :ref "Magic: Artillery Spells p. 25"}
                 {:name "Improved Explosive Lightning" :prerequisites "Magery 4 and at least 10 Air spells or 10 Weather spells, including Explosive Lightning" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Jolt (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Lightning" :prerequisites "Magery 1 and 6 other Air spells" :prerequisite_count 6 :college "Air" :ref "Basic Set p. 244; Magic p. 196"}
                 {:name "Lightning Armor" :prerequisites "6 Lightning spells including Resist Lightning" :prerequisite_count 12 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Missiles" :prerequisites "Lightning Weapon" :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Stare" :prerequisites "Lightning, Resist Lightning." :prerequisite_count 8 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Weapon" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 198"}
                 {:name "Lightning Whip" :prerequisites "Lightning" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Mighty Breath (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Mass Resist Lightning" :prerequisites "IQ 13+, Secret Spell (Mass Resist Lightning), and Resist Lightning" :prerequisite_count nil :college "Air" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13"}
                 {:name "No-Smell" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Odor" :prerequisites "No-Smell" :prerequisite_count 2 :college "Air" :ref "Magic p. 24"}
                 {:name "Phlogiston Arc" :prerequisites "Magery 4, Essential Air, and Lightning Whip" :prerequisite_count 7 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Detonation" :prerequisites "Magery 4, Essential Air, and Explosive Lightning" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Discharge" :prerequisites "Magery 4, Essential Air, and Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 15"}
                 {:name "Phlogiston Sphere" :prerequisites "Magery 4, Essential Air, and Ball of Lightning" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Stare" :prerequisites "Magery 4, Essential Air, and Lightning Stare" :prerequisite_count 9 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Phlogiston Touch" :prerequisites "Magery 4, Essential Air, and Shocking Touch" :prerequisite_count 8 :college "Air" :ref "Pyramid 3/25: Epic Magic p. 16"}
                 {:name "Predict Weather" :prerequisites "4 Air spells" :prerequisite_count 4 :college "Air" :ref "Basic Set p. 243; Magic p. 193"}
                 {:name "Purify Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Basic Set p. 243; Magic p. 23; Classic: Technomanser p 17"}
                 {:name "Purify Signal" :prerequisites "Purify Air, TL 6+" :prerequisite_count 1 :college "Air" :ref "Classic: Technomanser p 17"}
                 {:name "Rain" :prerequisites "Clouds" :prerequisite_count 5 :college "Air" :ref "Magic p. 195; Fantasy p. 168"}
                 {:name "Resist Lightning" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Air" :ref "Magic p. 196"}
                 {:name "Safe Boarding" :prerequisites "Secret Spell (Safe Boarding) and 8 Second-Level spells" :prerequisite_count nil :college "Air" :ref "Pyramid 3/64: Pirates and Swashbucklers p. 14"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Seek Air" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic p. 23"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Air" :ref "Classic: Technomancer p. 17"}
                 {:name "Shape Air" :prerequisites "Create Air" :prerequisite_count 2 :college "Air" :ref "Basic Set p. 243; Magic p. 24"}
                 {:name "Shocking Touch" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Snow" :prerequisites "Clouds and Frost" :prerequisite_count 2 :college "Air" :ref "Magic p. 193"}
                 {:name "Spark Cloud" :prerequisites "Shape Air and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Spark Storm" :prerequisites "Windstorm and Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 196"}
                 {:name "Static Charge" :prerequisites "Purify Air + 1 other Air spell" :prerequisite_count 2 :college "Air" :ref "Classic: Technomancer p 17"}
                 {:name "Steal Breath" :prerequisites "Magery 3 and any 7 Air spells, including Devitalize Air" :prerequisite_count 7 :college "Air" :ref "Magic: Death Spells p. 9"}
                 {:name "Stench" :prerequisites "Purify Air" :prerequisite_count 1 :college "Air" :ref "Basic Set p. 244; Magic p. 23"}
                 {:name "Stinkguard (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Storm" :prerequisites "Rain and Hail" :prerequisite_count 10 :college "Air" :ref "Magic p. 195"}
                 {:name "Storm Shelter (A)" :prerequisites "None" :prerequisite_count 0 :college "Air" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Stroke of Lightning" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Stroke of Lightning)" :prerequisite_count nil :college "Air" :ref "Magic Styles: Dungeon Magic p. 19"}
                 {:name "Summon Air Elemental" :prerequisites "Magery 1 and either 8 Air spells or 4 Air spells and another Summon Elemental spell" :prerequisite_count 8 :college "Air" :ref "Magic p. 27"}
                 {:name "Twisting Terror" :prerequisites "Magery 4 and at least 10 Air spells, including Windstorm" :prerequisite_count 10 :college "Air" :ref "Magic: Artillery Spells p. 10"}
                 {:name "Walk on Air" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Basic Set p. 243; Magic p. 25"}
                 {:name "Wall of Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Air" :ref "Magic p. 197"}
                 {:name "Wall of Wind" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Warm" :prerequisites "Heat and 4 Air spells" :prerequisite_count 8 :college "Air" :ref "Magic p. 195"}
                 {:name "Wind" :prerequisites "Windstorm" :prerequisite_count 4 :college "Air" :ref "Magic p. 193"}
                 {:name "Windstorm" :prerequisites "Shape Air" :prerequisite_count 3 :college "Air" :ref "Magic p. 25"}
                 {:name "Abominable Alteration" :prerequisites "Magery 3, Alter Body, and Shapeshift Others for the appropriate animal" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 9)"}
                 {:name "(Animal) Control" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Link" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast Possession" :prerequisites "Rider Within or Possession" :prerequisite_count 4 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast-Rouser" :prerequisites "Vexation or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 30"}
                 {:name "Beast-Soother" :prerequisites "Persuasion or Animal Empathy" :prerequisite_count 0 :college "Animal" :ref "Magic p. 29"}
                 {:name "Beast Seeker" :prerequisites "either Beast Summoning and 2 Seek spells, or Seeker" :prerequisite_count 3 :college "Animal" :ref "Magic p. 32"}
                 {:name "Beast Speech" :prerequisites "Beast Summoning" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Beast Summoning" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Call (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Creeping Plague" :prerequisites "Magery 5, Beast-Summoning, and Vermin Control or Magery 4 and Create Animal" :prerequisite_count 13 :college "Animal" :ref "Magic: Artillery Spells p. 10-11"}
                 {:name "Great Shapeshift" :prerequisites "Magery 3, Alter Body, 4 Shapeshifting spells, and 10 other spells" :prerequisite_count 15 :college "Animal" :ref "Magic p. 34"}
                 {:name "Groom (A)" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Hybrid Control" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 30; Classic: Grimoire p 9"}
                 {:name "Insect Repellent" :prerequisites "None" :prerequisite_count 0 :college "Animal" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Master" :prerequisites "Beast-Soother" :prerequisite_count 1 :college "Animal" :ref "Magic p. 30"}
                 {:name "Merging Shapeshifting" :prerequisites "Magery 3, 2 Shapeshift Other, 2 Body Control, 2 (Animal) Control" :prerequisite_count 0 :college "Animal" :ref "Classic: Technomancer p 12"}
                 {:name "Partial Shapeshifting" :prerequisites "Magery 3, Alter Body, and appropriate Shapeshifting" :prerequisite_count 12 :college "Animal" :ref "Magic p. 34"}
                 {:name "Permanent Beast Possession" :prerequisites "Magery 2 and Beast Possession" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Permanent Shapeshifting" :prerequisites "Magery 3 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Protect Animal" :prerequisites "Armor, Watchdog, and Animal spells" :prerequisite_count 7 :college "Animal" :ref "Magic p. 32"}
                 {:name "Repel (Animal)" :prerequisites "the appropriate (Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Repel Hybrids" :prerequisites "Hybrid Control" :prerequisite_count 4 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider" :prerequisites "(Animal) Control" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Rider Within" :prerequisites "2 (Animal) Control spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 31"}
                 {:name "Shapeshift Others" :prerequisites "Magery 2 and appropriate Shapeshifting" :prerequisite_count 7 :college "Animal" :ref "Magic p. 33"}
                 {:name "Shapeshifting" :prerequisites "Magery 1 and 6 other spells" :prerequisite_count 6 :college "Animal" :ref "Magic p. 32-33"}
                 {:name "Spider Silk" :prerequisites "Magery 1 and 2 Animal spells" :prerequisite_count 2 :college "Animal" :ref "Magic p. 32"}
                 {:name "Thousand-Legged Demise" :prerequisites "Magery 3, Vermin Control, and any one Shapeshift Others spell" :prerequisite_count 0 :college "Animal" :ref "Magic: Death Spells p. 10)"}
                 {:name "Accelerate Pregnancy" :prerequisites "Ease Labor and Haste" :prerequisite_count 0 :college "Body_Control" :ref "Spell: Bio-Tech, p. 30; Item: Classic: Technomancer pg 17"}
                 {:name "Ache (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Agonize" :prerequisites "Magery 2 and Sensitize" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Alter Body" :prerequisites "Alter Visage" :prerequisite_count 10 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Visage" :prerequisites "Magery 1, (Shapeshifting or Perfect Illusion), and 8 Body Control spells" :prerequisite_count 9 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Alter Voice" :prerequisites "4 Body Control spells and 4 Sound spells" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Ambidexterity" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Analgesic (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Balance" :prerequisites "Grace" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Belch (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Birth Control (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Blend In (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Boost (Attribute) Dexterity" :prerequisites "Grace" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Health" :prerequisites "Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Boost (Attribute) Strength" :prerequisites "Might" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Cadence" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Choke" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Climbing" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Clumsiness" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Control Limb" :prerequisites "Magery 1 and 5 Body Control spells including Spasm" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40; Classic Grimoire p 14"}
                 {:name "Corpulence" :prerequisites "Magery 2, Create Earth, Create Water, Alter Body, and 3 other Body Control spells" :prerequisite_count 16 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Curse Missile" :prerequisites "Magery 2, spell used in missile" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Magic p 24"}
                 {:name "Death" :prerequisites "Magery 3, Choke, and Deathtouch (Magery 3, and Choke as well as any five of Entombment, Rotting Death, Curse Evisceration, Steal Beauty, Deathtouch, Frostbite, Steal Skill, Dehydrate, Pestilence, or Stop Healing and Secret Spell (Death) according to Magic Styles: Dungeon Magic)" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 10 and 'Magic Styles: Dungeon Magic, p. 15"}
                 {:name "Death Field" :prerequisites "Magery 4 and at least 10 Body Control spells, including Deathtouch" :prerequisite_count 10 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Deathtouch" :prerequisites "Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Basic Set, p. 245; Magic, p. 41"}
                 {:name "Debility" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Decapitation" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Despoil Seed" :prerequisites "Magery 1, Alter Body, and Strike Barren" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Diver’s Blessing (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Doomtouch" :prerequisites "Magery 3, Deathtouch, and Weaken Blood" :prerequisite_count 0 :college "Body_Control" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ease Labor" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Bio-Tech, p. 31; Classic Technomancer p 22"}
                 {:name "Eat Crow (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Elvish Grace" :prerequisites "Clumsiness and Secret Spell (Elvish Grace)" :prerequisite_count 3 :college "Body_Control" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Enlarge" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Enlarge Other" :prerequisites "Magery 3 and Enlarge" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 43; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Ether Static/TL" :prerequisites "Purify Signal or Static Charge" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Technomancer p. 17"}
                 {:name "Flexibility (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Frailty" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Fumble" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Gauntness" :prerequisites "Magery 2, Earth to Air, Destroy Water, Hunger, and 3 other Body Control spells" :prerequisite_count 15 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Grace" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Hair Growth" :prerequisites "5 Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Haircut" :prerequisites "Hair Growth" :prerequisite_count 8 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hinder" :prerequisites "Clumsiness or Haste" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Hold Breath" :prerequisites "Magery 1 and Vigor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Hunger" :prerequisites "Magery 1, Debility, and Decay" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Imp Face" :prerequisites "Magery 1, Planar Summons, and Alter Visage" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Itch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Lengthen Limb" :prerequisites "Magery 3 and Shapeshifting" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 42; b: Classic Grimoire p. 18"}
                 {:name "Ley Running" :prerequisites "Seek Ley Line and Haste" :prerequisite_count 1 :college "Body_Control" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Mark of Thieves" :prerequisites "Magery 1, Pestilence" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Might" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Mouth-Goes-Away" :prerequisites "Magery 1, Alter Visage, and four Body Control spells" :prerequisite_count 0 :college "Body_Control" :ref "Alphabet Arcane, p. 17"}
                 {:name "Nauseate" :prerequisites "Perfume and 1 other Body Control spell" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Pain" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Paralyze Limb" :prerequisites "Magery 1, Pain, and 4 other Body Control spells" :prerequisite_count 5 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Partial Mechamorphosis/TL" :prerequisites "Magery 2, Alter Body, Machine Control, TL7+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomancer p 17"}
                 {:name "Perfume" :prerequisites "Odor" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Plague Touch" :prerequisites "Magery 4, Deathtouch, Pestilence, and Sense Foes" :prerequisite_count 9 :college "Body_Control" :ref "Magic: Artillery Spells p. 11"}
                 {:name "Reflexes" :prerequisites "Grace and Haste" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32"}
                 {:name "Resist Pain" :prerequisites "Magery 2 and Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Retch" :prerequisites "Nauseate and Spasm" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Rooted Feet" :prerequisites "Hinder" :prerequisite_count 2 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 36"}
                 {:name "Roundabout" :prerequisites "Tanglefoot" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Seek Emitter/TL" :prerequisites "TL 6+" :prerequisite_count 0 :college "Body_Control" :ref "Classic: Technomanser p 17"}
                 {:name "Sensitize" :prerequisites "Magery 1 and Stun" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 39"}
                 {:name "Shrink" :prerequisites "Magery 2 and Alter Body" :prerequisite_count 11 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Shrink Other" :prerequisites "Magery 3 and Shrink" :prerequisite_count 12 :college "Body_Control" :ref "Magic, p. 42"}
                 {:name "Sickness" :prerequisites "Drunkenness or Magery 1 and Pestilence" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 138"}
                 {:name "Spasm" :prerequisites "Itch" :prerequisite_count 1 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 35"}
                 {:name "Stand Out (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Anosmic" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Classic: Grimoire p 14"}
                 {:name "Stop Spasm" :prerequisites "Spasm or Lend Vitality" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Stifle (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Strike Barren" :prerequisites "Magery 1, Steal Vitality, and Decay" :prerequisite_count 7 :college "Body_Control" :ref "Magic, p. 41"}
                 {:name "Strike Blind" :prerequisites "Spasm and 2 Light and Darkness spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Deaf" :prerequisites "Spasm and 2 Sound spells" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Dumb" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Strike Numb" :prerequisites "Resist Pain" :prerequisite_count 4 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Stun" :prerequisites "Pain" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Tanglefoot" :prerequisites "Clumsiness" :prerequisite_count 3 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Thirst" :prerequisites "Magery 1, Debility, and Destroy Water" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 38"}
                 {:name "Throw Voice (A)" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Tickle" :prerequisites "Spasm" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 36"}
                 {:name "Total Paralysis" :prerequisites "Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Touch" :prerequisites "None" :prerequisite_count 0 :college "Body_Control" :ref "Magic, p. 35"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Body_Control" :ref "Bio-Tech, p. 32; Classic: Technomancer p. 22"}
                 {:name "Transform Body" :prerequisites "Alter Body and 3 Shapeshifting spells" :prerequisite_count 13 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transform Other" :prerequisites "Shapeshift Others and appropriate Transform Body" :prerequisite_count 14 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Transmogrification" :prerequisites "Magery 3, Transform Other, Transform Object, and Flesh to Stone." :prerequisite_count 32 :college "Body_Control" :ref "Magic, p. 43"}
                 {:name "Vigor" :prerequisites "Lend Vitality or Frailty" :prerequisite_count 2 :college "Body_Control" :ref "Magic, p. 37"}
                 {:name "Warp Fetus" :prerequisites "Strike Barren or Wither Limb" :prerequisite_count 7 :college "Body_Control" :ref "Bio-Tech, p. 33"}
                 {:name "Weaken Blood" :prerequisites "Magery 1, Sickness or Steal Vitality" :prerequisite_count 5 :college "Body_Control" :ref "Magic, p. 40"}
                 {:name "Wither Limb" :prerequisites "Magery 2 and Paralyze Limb" :prerequisite_count 6 :college "Body_Control" :ref "Basic Set, p. 244; Magic, p. 40"}
                 {:name "Absorb Book" :prerequisites "IQ 13+ or Gift of Letters" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Accursed Triangle" :prerequisites "Magery 3 and Exchange Bodies" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 11"}
                 {:name "Ack (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Bedtime Reading" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 20"}
                 {:name "Borrow Language" :prerequisites "Lend Language" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Borrow Number/TL" :prerequisites "Seek Number" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Borrow Skill" :prerequisites "Lend Skill" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Broadcast Spell/TL" :prerequisites "Magery 3, Telepathy, Mass Suggestion, TL6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomander p. 19"}
                 {:name "Communication" :prerequisites "Wizard Eye, Far-Hearing, Voices, and Simple Illusion" :prerequisite_count 9 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Compel Lie" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 137"}
                 {:name "Compel Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Compel Written Truth" :prerequisites "Magery 2 and Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Control Person" :prerequisites "Soul Rider or Telepathy" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Delete Commercials/TL" :prerequisites "TL 7+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 18"}
                 {:name "Dispel Possession" :prerequisites "Soul Rider or Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic p. 49"}
                 {:name "Drama (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Dream Projection" :prerequisites "Dream Sending" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Dream Sending" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Dream Viewing" :prerequisites "Truthsayer or Sleep" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Exchange Bodies" :prerequisites "Permanent Possession and Soul Jar" :prerequisite_count 17 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Gift of Letters" :prerequisites "Borrow Language and 3 Languages written at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Gift of Tongues" :prerequisites "Borrow Language and 3 Languages spoken at Accented or better" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Hide Emotion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Hide Thoughts" :prerequisites "Truthsayer" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46"}
                 {:name "Identify Caller/TL" :prerequisites "Mind Reading, Seek Number." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Illuminated Writing" :prerequisites "Magery 2 and one of Mind-Sending, Fascinate, or Writing-12+" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Insignificance" :prerequisites "Persuasion and Avoid" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Lend Language" :prerequisites "Beast Speech or 3 Communication and Empathy spells" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Lend Skill" :prerequisites "Mind-Sending and IQ 11+" :prerequisite_count 11 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Machine Speech/TL" :prerequisites "Machine Summoning" :prerequisite_count 13 :college "Communication_and_Empathy" :ref "Magic, p. 176"}
                 {:name "Magic Switchboard/TL" :prerequisites "Identify Caller" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 17"}
                 {:name "Message" :prerequisites "Great Voice and Seeker" :prerequisite_count 7 :college "Communication_and_Empathy" :ref "Magic, p. 173"}
                 {:name "Mer-Speech (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Mind-Reading" :prerequisites "Truthsayer or Borrow Language" :prerequisite_count 3 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 46; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Search" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 46"}
                 {:name "Mind-Sending" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 47; Fantasy, p. 169; Social Engineering: Back to School, p. 24"}
                 {:name "Mind-Whip" :prerequisites "Magery 2, Telepathy, Thunderclap, and Secret Spell (Mind-Whip)." :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic Styles: Dungeon Magic, p. 24"}
                 {:name "Permanent Possession" :prerequisites "Magery 3 and Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Persuasion" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Possession" :prerequisites "Magery 1 and either Control Person or Beast Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Presence" :prerequisites "Persuasion and Lure" :prerequisite_count 8 :college "Communication_and_Empathy" :ref "Magic, p. 48"}
                 {:name "Retrogression" :prerequisites "Mind-Search and Mind-Sending" :prerequisite_count 6 :college "Communication_and_Empathy" :ref "Magic, p. 47"}
                 {:name "Seek Number/TL" :prerequisites "Magery, TL 6+" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Sense Emotion" :prerequisites "Sense Foes" :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45; Social Engineering: Back to School, p. 24"}
                 {:name "Sense Foes" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 44"}
                 {:name "Sense Life" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Sorcerous Signal (A)" :prerequisites "None" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Soul Rider" :prerequisites "Mind-Reading" :prerequisite_count 4 :college "Communication_and_Empathy" :ref "Magic, p. 49"}
                 {:name "Speed Data/TL" :prerequisites "TL7+; Haste or Lightning" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Classic: Technomancer p 19"}
                 {:name "Switch Bodies" :prerequisites "Permanent Possession" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "4e spell chart"}
                 {:name "Telepathic Overload" :prerequisites "Magery 3, and any 10 Communication and Empathy spells, including Telepathy" :prerequisite_count 0 :college "Communication_and_Empathy" :ref "Magic: Death Spells, p. 9"}
                 {:name "Telepathy" :prerequisites "Mind-Sending" :prerequisite_count 5 :college "Communication_and_Empathy" :ref "Magic, p. 47; Social Engineering: Back to School, p. 24"}
                 {:name "Truthsayer" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Basic Set, p. 245; Magic, p. 45"}
                 {:name "Vexation" :prerequisites "Sense Emotion" :prerequisite_count 2 :college "Communication_and_Empathy" :ref "Magic, p. 45"}
                 {:name "Wrong Number/TL" :prerequisites "TL6+; Sense Foes or Seek Number." :prerequisite_count 1 :college "Communication_and_Empathy" :ref "Classic: Technomancer p. 18"}
                 {:name "Adamant Hail" :prerequisites "Magery 4, Essential Earth, and Rain of Stones" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Adamant Missile" :prerequisites "Magery 4, Essential Earth, and Stone Missile" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Alter Terrain" :prerequisites "Magery 3 and all 4 elemental Shape spells and Shape Stone" :prerequisite_count 11 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Badger Paws (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Body of Stone" :prerequisites "Stone to Flesh" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Boulder Barrage" :prerequisites "Magery 4 and at least 10 Earth spells, including Rain of Stones and Stone Missile" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Control Earth Elemental" :prerequisites "Summon Earth Elemental" :prerequisite_count 9 :college "Earth" :ref "Magic, p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Earth" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Earth Elemental" :prerequisites "Magery 2 and Control Earth Elemental" :prerequisite_count 10 :college "Earth" :ref "Magic, p. 22"}
                 {:name "Dust to Dust" :prerequisites "Magery 3, Earth to Air, and Flesh to Stone" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Earth to Air" :prerequisites "Create Air and Shape Earth" :prerequisite_count 4 :college "Earth" :ref "Basic Set, p. 243; Magic, p. 25"}
                 {:name "Earth to Stone" :prerequisites "Magery 1 and Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Earth to Water" :prerequisites "Magery 1, Create Water, and Shape Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Earth Vision" :prerequisites "Shape Earth" :prerequisite_count 2 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Earthquake" :prerequisites "Magery 2 and 6 Earth spells including Earth Vision" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Entombment" :prerequisites "Magery 2 and 5 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Essential Earth" :prerequisites "6 Earth spells" :prerequisite_count 6 :college "Earth" :ref "Magic, p. 53; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Flesh to Adamant" :prerequisites "Magery 4, Essential Earth, and Flesh to Stone" :prerequisite_count 7 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 16"}
                 {:name "Flesh to Stone" :prerequisites "Earth to Stone" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Gargoyle Skin (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Heart of Stone" :prerequisites "Magery 3 and Partial Petrification" :prerequisite_count 0 :college "Earth" :ref "Magic: Death Spells, p. 11"}
                 {:name "Move Terrain" :prerequisites "Alter Terrain and Hide Object" :prerequisite_count 29 :college "Earth" :ref "Magic, p. 55"}
                 {:name "Mud Jet" :prerequisites "Water Jet and Create Earth, or Create Water and Sand Jet" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Orichalcum Edge" :prerequisites "Magery 4, Essential Earth, and Earth to Stone" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Orichalcum Missiles" :prerequisites "Orichalcum Edge" :prerequisite_count 0 :college "Earth" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Partial Petrification" :prerequisites "Magery 2 and Flesh to Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Pebble (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Predict Earth Movement" :prerequisites "4 Earth spells" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Purify Earth" :prerequisites "Apportation and Shape Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 54; GURPS Fantasy, p. 169"}
                 {:name "Rain of Stones" :prerequisites "Magery 2 and Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 53"}
                 {:name "Sand Blast" :prerequisites "Magery 4, Sand Jet, and Sandstorm" :prerequisite_count 0 :college "Earth" :ref "Magic: Artillery Spells p. 12"}
                 {:name "Sand Jet" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Sandstorm" :prerequisites "Windstorm and Create Earth" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Seek Earth" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Seek Pass" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Magic, p. 51"}
                 {:name "Seismic Shock" :prerequisites "Magery 4 and at least 10 Earth spells, including Earthquake" :prerequisite_count 10 :college "Earth" :ref "Magic: Artillery Spells p. 13"}
                 {:name "Shape Earth" :prerequisites "Seek Earth" :prerequisite_count 1 :college "Earth" :ref "Basic Set, p. 245; Magic, p. 50"}
                 {:name "Shape Stone" :prerequisites "Shape Earth and 3 other Earth spells" :prerequisite_count 5 :college "Earth" :ref "Fantasy, p. 169"}
                 {:name "Spotless Hands (A)" :prerequisites "None" :prerequisite_count 0 :college "Earth" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Steelwraith" :prerequisites "Magery 2 and Walk through Earth" :prerequisite_count 5 :college "Earth" :ref "Magic, p. 54; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Stone Missile" :prerequisites "Create Earth" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52"}
                 {:name "Stone to Earth" :prerequisites "Earth to Stone or 4 Earth spells" :prerequisite_count 3 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 51"}
                 {:name "Stone to Flesh" :prerequisites "Magery 2, Flesh to Stone, and Stone to Earth" :prerequisite_count 5 :college "Earth" :ref "Basic Set, p. 246; Magic, p. 53"}
                 {:name "Summon Earth Elemental" :prerequisites "Magery 1 and either 8 Earth spells or 4 Earth spells and another Summon Elemental spell" :prerequisite_count 8 :college "Earth" :ref "Magic, p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Earth" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Volcano" :prerequisites "Earthquake and 6 Fire spells" :prerequisite_count 13 :college "Earth" :ref "Magic, p. 54"}
                 {:name "Walk through Earth" :prerequisites "Shape Stone" :prerequisite_count 4 :college "Earth" :ref "Magic, p. 52; GURPS Fantasy, p. 169; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Adjustable Clothing" :prerequisites "Enchant and Reshape" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 58; Thaumatology: Urban Magics, p. 33"}
                 {:name "Amulet" :prerequisites "Talisman for the appropriate spell" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Compulsive Reader" :prerequisites "Enchant and 3 Mind Control spells or Writing-15+" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Costume" :prerequisites "Adjustable Clothing" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Item 3 p 30"}
                 {:name "Create Chimera" :prerequisites "Analyze Heredity, Enchant, and either Alter Body or Lightning" :prerequisite_count 0 :college "Enchantment" :ref "Bio-Tech, p. 31"}
                 {:name "Curse Virus/TL" :prerequisites "Spellprocessor and Animate Machine, Awaken Computer, Curse, Glitch, Mad Machine or Malfunction" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Tenchnomancer p. 20"}
                 {:name "Doom Wish" :prerequisites "Magery 3, Wish, and IQ + Magery of 23+" :prerequisite_count 18 :college "Enchantment" :ref "Magic: Artillery Spells p. 13-14"}
                 {:name "Doppelgänger" :prerequisites "Magery 3, Golem, History, and Enslave" :prerequisite_count 29 :college "Enchantment" :ref "Magic p. 62; Classic: Magic p 40"}
                 {:name "Dwarfish Reinforcement" :prerequisites "Enchant and Secret Spell (Dwarvish Reinforcement)" :prerequisite_count 11 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Electric Power/TL" :prerequisites "Lend Power, Power, Steal Power" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 20"}
                 {:name "Emergency Staff (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Enchant" :prerequisites "Magery 2 and at least one spell from 10 other colleges" :prerequisite_count 10 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 56"}
                 {:name "Ensorcel" :prerequisites "Malefice" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Golem" :prerequisites "Enchant, Shape Earth, and Animation" :prerequisite_count 14 :college "Enchantment" :ref "Magic p. 59"}
                 {:name "Great Wish" :prerequisites "Magery 3, Wish, and (DX+IQ) 30+" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Hex" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Hideaway" :prerequisites "Enchant, Create Object, and Lighten" :prerequisite_count 15 :college "Enchantment" :ref "Magic p. 66; Thaumatology: Urban Magics, p. 33"}
                 {:name "Impart Skill" :prerequisites "Magery 3, Enchant, Lend Skill, Wisdom, Secret Spell (Impart Skill), and five Communication and Empathy spells" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Impression Blocker" :prerequisites "Enchant, Seeker, and Scrywall" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Leak" :prerequisites "Hideaway" :prerequisite_count 16 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Lesser Wish" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Ley Line Creation" :prerequisites "Seek Ley Line and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Thaumatology: Urban Magics, p. 21"}
                 {:name "Live Libram" :prerequisites "Enchant and Apportation" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Malefice" :prerequisites "Enchant and Seeker" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Magician’s Minion (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 8-9"}
                 {:name "Mana Warhead/TL" :prerequisites "Curse-Missile and spell in warhead" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Technomancer p. 21"}
                 {:name "Mortal Malefice" :prerequisites "Magery 3, Malefice, and Soul Jar" :prerequisite_count 0 :college "Enchantment" :ref "Magic: Death Spells, p. 9"}
                 {:name "Narrative Conveyance" :prerequisites "Plane Shift, Timeport, and Writing-15+" :prerequisite_count 0 :college "Enchantment" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Power" :prerequisites "Enchant and Recover Energy" :prerequisite_count 12 :college "Enchantment" :ref "Basic Set, p. 480; Magic p. 57"}
                 {:name "Remove Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Resilient Golem" :prerequisites "Golem and Shatterproof" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Magic Items 3 p 32"}
                 {:name "Resist Enchantment" :prerequisites "any Limiting Enchantment spell" :prerequisite_count 12 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Scroll" :prerequisites "Magery 1 and 1 written Language at Accented or better" :prerequisite_count 0 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Simulacrum" :prerequisites "Magery 3, Golem, Perfect Illusion, and Illusion Disguise" :prerequisite_count 18 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Sorcerer’s Stand-In (A)" :prerequisites "None" :prerequisite_count 0 :college "Enchantment" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Soul Golem" :prerequisites "Magery 3, Soul Jet, Golem, IQ 13+" :prerequisite_count 0 :college "Enchantment" :ref "Classic: Grimoire p 42"}
                 {:name "Speed" :prerequisites "Enchant and Haste" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 57"}
                 {:name "Spell Stone" :prerequisites "Enchant and Delay" :prerequisite_count 8 :college "Enchantment" :ref "Magic p. 60"}
                 {:name "Spellbook Enchantment" :prerequisites "Scroll" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Magic Items 2 p. 40"}
                 {:name "Spellgraft" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Bio-Tech, p. 32"}
                 {:name "Spellprocessor" :prerequisites "Scroll, Computer Programming-15+" :prerequisite_count 1 :college "Enchantment" :ref "Classic: Technomancer p 19"}
                 {:name "Suspend Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Talisman" :prerequisites "Enchant and spell to be opposed" :prerequisite_count nil :college "Enchantment" :ref "Magic p. 58"}
                 {:name "Temporary Enchantment" :prerequisites "Enchant" :prerequisite_count 11 :college "Enchantment" :ref "Magic p. 56; Fantasy, p. 23"}
                 {:name "Vengeful Staff" :prerequisites "Magery 3, Enchant, and Explode" :prerequisite_count 12 :college "Enchantment" :ref "Magic: Artillery Spells p. 14"}
                 {:name "Wish" :prerequisites "Lesser Wish and 1 spell each from 15 colleges" :prerequisite_count 17 :college "Enchantment" :ref "Magic p. 61"}
                 {:name "Balor's Eye Fire" :prerequisites "Magery 1, Flame Jet, Resist Fire, and either Secret Spell (Balor’s Eye Fire) or Tome of Power (Balor’s Treatise)" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Blast Ball" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Blast Ball)" :prerequisite_count 0 :college "Fire" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Body of Flames" :prerequisites "Breathe Fire" :prerequisite_count 8 :college "Fire" :ref "Magic p. 76"}
                 {:name "Breathe Fire" :prerequisites "Magery 1, Flame Jet, and Resist Fire" :prerequisite_count 7 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Death" :prerequisites "Magery 2, Heat, and Sickness" :prerequisite_count 10 :college "Fire" :ref "Magic p. 76"}
                 {:name "Burning Touch" :prerequisites "Magery 2 and 6 Fire spells including Heat" :prerequisite_count 6 :college "Fire" :ref "Magic p. 76"}
                 {:name "Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74/Classic: Technomancer p. 21"}
                 {:name "Control Fire Elemental" :prerequisites "Summon Fire Elemental" :prerequisite_count 9 :college "Fire" :ref "Magic p. 28"}
                 {:name "Control Lava Lizard" :prerequisites "Summon Lava Lizard" :prerequisite_count 9 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Create Fire" :prerequisites "Ignite Fire or Seek Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 72"}
                 {:name "Create Fire Elemental" :prerequisites "Magery 2 and Control Fire Elemental" :prerequisite_count 10 :college "Fire" :ref "Magic p. 22"}
                 {:name "Cremate" :prerequisites "Magery 3, Burning Touch, Essential Flame, and Fast Fire" :prerequisite_count 0 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Deflect Energy" :prerequisites "Magery 1 and Shape Fire" :prerequisite_count 2 :college "Fire" :ref "Basic Set, p. 246; Magic p. 73"}
                 {:name "Detonate" :prerequisites "Ignite Fire, Shape Plastic" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ember (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Essential Flame" :prerequisites "6 Fire spells" :prerequisite_count 6 :college "Fire" :ref "Magic p. 75"}
                 {:name "Explosive Fireball" :prerequisites "Fireball" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 75"}
                 {:name "Explosive Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Explosive Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Extinguish Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 247; Magic p. 72"}
                 {:name "Fast Fire" :prerequisites "Slow Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Fire Cloud" :prerequisites "Shape Air and Fireball" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Fire Swarm" :prerequisites "Magery 4 and at least 10 Fire spells, including Fireball and Flame Jet" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Fireball" :prerequisites "Magery 1, Create Fire, and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Fireproof" :prerequisites "Extinguish Fire" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flame Jet" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Flameturning" :prerequisites "Resist Fire, or both Apportation and Shape Fire" :prerequisite_count 0 :college "Fire" :ref "Classic: Grimoire p. 30"}
                 {:name "Flaming Armor" :prerequisites "Magery 1, Resist Fire, and Flame Jet" :prerequisite_count 7 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Missiles" :prerequisites "Flaming Weapon" :prerequisite_count 5 :college "Fire" :ref "Magic p. 75"}
                 {:name "Flaming Weapon" :prerequisites "Magery 2 and Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 75"}
                 {:name "Great Deflect Energy" :prerequisites "Magery 2, Secret Spell (Great Deflect Energy), and Deflect Energy" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9"}
                 {:name "Heat" :prerequisites "Create Fire and Shape Fire" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Hellfire Breath" :prerequisites "Magery 4, Essential Flame, and Breathe Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Jet" :prerequisites "Magery 4, Essential Flame, and Flame Jet" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Hellfire Orb" :prerequisites "Magery 4, Essential Flame, and Fireball" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 17"}
                 {:name "Hellfire Rain" :prerequisites "Magery 4, Essential Flame, and Rain of Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "High-Explosive Fireball" :prerequisites "Explosive Fireball, TL7+" :prerequisite_count 5 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Ignite Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Improved Explosive Fireball" :prerequisites "Magery 4 and at least 10 Fire spells, including Explosive Fireball" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Mass Detonate" :prerequisites "Detonate" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p. 21"}
                 {:name "Mass Resist Fire" :prerequisites "IQ 13+, Secret Spell (Mass Resist Fire), and Resist Fire" :prerequisite_count 0 :college "Fire" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Oven Mitts (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Phantom Flame" :prerequisites "Shape Fire or Simple Illusion" :prerequisite_count 1 :college "Fire" :ref "Magic p. 73"}
                 {:name "Puff (A)" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Rain of Fire" :prerequisites "Magery 2 and Create Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 74; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Resist Cold" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Resist Fire" :prerequisites "Extinguish Fire and Cold" :prerequisite_count 3 :college "Fire" :ref "Basic Set, p. 247; Magic p. 74"}
                 {:name "Shaped-Charge Fireball" :prerequisites "Magery, Fireball, Shape Metal" :prerequisite_count 0 :college "Fire" :ref "Classic: Technomancer p 21"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Fire" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Seek Fire" :prerequisites "None" :prerequisite_count 0 :college "Fire" :ref "Magic p. 72"}
                 {:name "Shape Fire" :prerequisites "Ignite Fire" :prerequisite_count 1 :college "Fire" :ref "Basic Set, p. 246; Magic p. 72"}
                 {:name "Slow Fire" :prerequisites "Extinguish Fire" :prerequisite_count 2 :college "Fire" :ref "Magic p. 73"}
                 {:name "Smoke" :prerequisites "Shape Fire and Extinguish Fire" :prerequisite_count 3 :college "Fire" :ref "Magic p. 73"}
                 {:name "Snuff Life's Flame" :prerequisites "Magery 3 and Body of Flames" :prerequisite_count 9 :college "Fire" :ref "Magic: Death Spells, p. 12"}
                 {:name "Summon Fire Elemental" :prerequisites "Magery 1 and either 8 Fire spells or 4 Fire spells and another Summon Elemental spell" :prerequisite_count 8 :college "Fire" :ref "Magic p. 27"}
                 {:name "Summon Lava Lizard" :prerequisites "Magery 1, four Earth spells, and four Fire spells" :prerequisite_count 8 :college "Fire" :ref "Dungeon Fantasy Monsters 3: Born of Myth & Magic, p. 12"}
                 {:name "Towering Inferno" :prerequisites "Magery 4 and at least 7 Fire spells, including Fire Cloud and Rain of Fire" :prerequisite_count 7 :college "Fire" :ref "Magic: Artillery Spells p. 14-15"}
                 {:name "Warmth" :prerequisites "Heat" :prerequisite_count 4 :college "Fire" :ref "Magic p. 74"}
                 {:name "Accelerate Time" :prerequisites "Magery 2, IQ 13+ and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Beacon" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Gate" :ref "Magic p. 83; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Blink" :prerequisites "Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 148"}
                 {:name "Blink Other" :prerequisites "Blink" :prerequisite_count 6 :college "Gate" :ref "Magic p. 148"}
                 {:name "Control Gate" :prerequisites "Magery 3 and Seek Gate" :prerequisite_count 12 :college "Gate" :ref "Magic p. 85"}
                 {:name "Create Door" :prerequisites "Teleport and any 1 Walk through spell" :prerequisite_count 10 :college "Gate" :ref "Magic p. 84"}
                 {:name "Create Gate" :prerequisites "Control Gate and either Teleport, Timeport, or Plane Shift" :prerequisite_count 14 :college "Gate" :ref "Magic p. 85/Classic: Grimoire p 50"}
                 {:name "Dimensional Dissection" :prerequisites "Magery 3 and one of Plane Shift Other, Teleport Other, or Timeport Other" :prerequisite_count 0 :college "Gate" :ref "Magic: Death Spells, p. 13"}
                 {:name "Divert Teleport" :prerequisites "Mager 3 and Trace Teleport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 84"}
                 {:name "Easy Rider (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Hell Zone" :prerequisites "Magery 4, Beacon, and Planar Summons for at leastone realm the GM deems “hostile." :prerequisite_count 0 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Hide Object" :prerequisites "Hideaway and Teleport" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Invoke (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 14-15"}
                 {:name "Null Sphere" :prerequisites "Magery 5 and Create Gate" :prerequisite_count 15 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Phase" :prerequisites "Magery 3 and either Plane Shift or Ethereal Body" :prerequisite_count 5 :college "Gate" :ref "Magic p. 83"}
                 {:name "Phase Other" :prerequisites "Phase" :prerequisite_count 6 :college "Gate" :ref "Magic p. 83"}
                 {:name "Planar Summons" :prerequisites "Magery 1 and at least 1 spell from 10 other colleges" :prerequisite_count 10 :college "Gate" :ref "Basic Set p. 247; Magic p. 82"}
                 {:name "Planar Visit" :prerequisites "Magery 2 and either Projection or Planar Summons" :prerequisite_count 11 :college "Gate" :ref "Magic p. 82"}
                 {:name "Plane Shift" :prerequisites "Planar Summons" :prerequisite_count 11 :college "Gate" :ref "Basic Set p. 247; Magic p. 83"}
                 {:name "Plane Shift Other" :prerequisites "Magery 3 and Plane Shift" :prerequisite_count 12 :college "Gate" :ref "Magic p. 83"}
                 {:name "Rapid Journey" :prerequisites "Magery 3 and either Teleport or Timeport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 82"}
                 {:name "Reorient (A)" :prerequisites "None" :prerequisite_count 0 :college "Gate" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Sanctuary" :prerequisites "Hide Object" :prerequisite_count 21 :college "Gate" :ref "Magic p. 86"}
                 {:name "Scry Gate" :prerequisites "Seek Gate" :prerequisite_count 11 :college "Gate" :ref "Magic p. 85"}
                 {:name "Seek Gate" :prerequisites "Magery 2, Seek Magic, and 1 spell from each of 10 colleges" :prerequisite_count 10 :college "Gate" :ref "Magic p. 85"}
                 {:name "Slow Time" :prerequisites "Magery 2, IQ 13+, and 2 spells from each of 10 colleges" :prerequisite_count 20 :college "Gate" :ref "Magic p. 86"}
                 {:name "Splat" :prerequisites "Magery 4 and Create Door" :prerequisite_count 0 :college "Gate" :ref "Magic: Artillery Spells p. 16"}
                 {:name "Suspend Time" :prerequisites "Magery 3 and Slow Time" :prerequisite_count 21 :college "Gate" :ref "Magic p. 86"}
                 {:name "Teleport" :prerequisites "Hawk Flight or IQ 15+, and 1 spell from 10 colleges" :prerequisite_count 4 :college "Gate" :ref "Magic p. 147; Fantasy, p. 171"}
                 {:name "Teleport Other" :prerequisites "Magery 3 and Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 147"}
                 {:name "Teleport Shield" :prerequisites "Watchdog and either Spell Shield or Teleport" :prerequisite_count 7 :college "Gate" :ref "Magic p. 170"}
                 {:name "Time Out" :prerequisites "Magery 3 and Accelerate Time" :prerequisite_count 21 :college "Gate" :ref "Magic p. 87"}
                 {:name "Timeport" :prerequisites "Magery 3 and Teleport" :prerequisite_count 5 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeport Other" :prerequisites "Timeport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeslip" :prerequisites "Timeport" :prerequisite_count 6 :college "Gate" :ref "Magic p. 81"}
                 {:name "Timeslip Other" :prerequisites "Timeslip" :prerequisite_count 7 :college "Gate" :ref "Magic p. 81"}
                 {:name "Trace Teleport" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Gate" :ref "Magic p. 84"}
                 {:name "Underworld Imprisonment" :prerequisites "Magery 3 and at least one Plane Shift Other spell" :prerequisite_count 13 :college "Gate" :ref "Magic: Death Spells, p. 13"}
                 {:name "Aid (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Aide (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Analgesic (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Archmagi's Recuperation" :prerequisites "Prerequisites: IQ 14+, Magery 4, Lend Energy, and Secret Spell (Archmagi’s Recuperation)" :prerequisite_count 0 :college "Healing" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 13"}
                 {:name "Awaken" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Basic Set, p. 248; Magic p. 90"}
                 {:name "Bender Defender (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Birth Control (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Body-Reading" :prerequisites "Sense Life or Awaken" :prerequisite_count 1 :college "Healing" :ref "Magic p. 91"}
                 {:name "Cleansing" :prerequisites "Minor Healing and Purify Earth" :prerequisite_count 12 :college "Healing" :ref "Magic p. 94"}
                 {:name "Cure Addiction" :prerequisites "Relieve Addiction" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 55"}
                 {:name "Cure Dehydration" :prerequisites "Magery, Minor Healing, Create Water" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 52"}
                 {:name "Cure Disease" :prerequisites "Major Healing and Relieve Sickness" :prerequisite_count 5 :college "Healing" :ref "Magic p. 91; Fantasy, p. 170"}
                 {:name "Cure Insanity" :prerequisites "Major Healing, Relieve Madness, 5 Mind Control spells" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 55"}
                 {:name "Cure Radiation" :prerequisites "Resist Radiation and Major Healing" :prerequisite_count 12 :college "Healing" :ref "Magic p. 182"}
                 {:name "Cure Starvation" :prerequisites "Magery, Minor Healing, Create Food" :prerequisite_count 0 :college "Healing" :ref "Classic: Grimoire p. 52"}
                 {:name "Detect Poison" :prerequisites "Sense Danger or Test Food" :prerequisite_count 1 :college "Healing" :ref "Magic p. 166"}
                 {:name "Disinfect" :prerequisites "Magery 4 and at least 10 Healing spells, including Cure Disease and Remove Contagion" :prerequisite_count 10 :college "Healing" :ref "Magic: Artillery Spells p. 17"}
                 {:name "Ease Labor" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Bio-Tech, p. 31; Classic: Tecnomancer p. 22"}
                 {:name "Euthanize" :prerequisites "Any of Empathy, Magery 1, Spirit Empathy, or “holy” status" :prerequisite_count 0 :college "Healing" :ref "Magic: Death Spells, p. 14"}
                 {:name "Final Rest" :prerequisites "Magery 1 or Spirit Empathy" :prerequisite_count 0 :college "Healing" :ref "Magic p. 89"}
                 {:name "Great Healing" :prerequisites "Magery 3 and Major Healing" :prerequisite_count 4 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Halt Aging" :prerequisites "Magery 2 and 8 Healing spells" :prerequisite_count 8 :college "Healing" :ref "Magic p. 94"}
                 {:name "Healing Slumber" :prerequisites "Magery 2, Sleep, and Minor Healing" :prerequisite_count 6 :college "Healing" :ref "Magic p. 94"}
                 {:name "Instant Neutralize Poison" :prerequisites "Magery 2 and Neutralize Poison" :prerequisite_count 2 :college "Healing" :ref "Magic p. 92"}
                 {:name "Instant Regeneration" :prerequisites "Magery 3 and Regeneration" :prerequisite_count 6 :college "Healing" :ref "Magic p. 93"}
                 {:name "Instant Restoration" :prerequisites "Magery 2 and Restoration" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Lend Energy" :prerequisites "Magery 1 or Empathy" :prerequisite_count 0 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Lend Vitality (Health)" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Major Healing" :prerequisites "Magery 1 and Minor Healing" :prerequisite_count 3 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Mass Resist Disease" :prerequisites "IQ 13+, Secret Spell (Mass Resist Disease), and Resist Disease" :prerequisite_count 4 :college "Healing" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Mass Resist Poison" :prerequisites "IQ 13+, Secret Spell (Mass Resist Poison), and Resist Poison" :prerequisite_count 4 :college "Healing" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Minor Healing" :prerequisites "Lend Vitality" :prerequisite_count 0 :college "Healing" :ref "Basic Set, p. 248; Magic p. 91"}
                 {:name "Neutralize Poison" :prerequisites "Cure Disease or Magery 3 and Test Food" :prerequisite_count 1 :college "Healing" :ref "Magic p. 92"}
                 {:name "Recover Energy" :prerequisites "Magery 1 and Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Basic Set, p. 248; Magic p. 89"}
                 {:name "Regeneration" :prerequisites "Magery 2 and Restoration" :prerequisite_count 5 :college "Healing" :ref "Magic p. 93"}
                 {:name "Relieve Addiction" :prerequisites "Neutralize Poison" :prerequisite_count 2 :college "Healing" :ref "Magic p. 92|-"}
                 {:name "Relieve Madness" :prerequisites "Lend Vitality and Wisdom" :prerequisite_count 9 :college "Healing" :ref "Magic p. 92"}
                 {:name "Relieve Paralysis" :prerequisites "Stop Paralysis" :prerequisite_count 2 :college "Healing" :ref "Magic p. 93"}
                 {:name "Relieve Sickness" :prerequisites "Lend Vitality" :prerequisite_count 9 :college "Healing" :ref "Magic p. 90"}
                 {:name "Remove Contagion" :prerequisites "Decay, Clean, or Cure Disease" :prerequisite_count 2 :college "Healing" :ref "Magic p. 90"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Healing" :ref "Bio-Tech, p. 32; Technomancer p. 22"}
                 {:name "Resist Disease" :prerequisites "Remove Contagion or Vigor" :prerequisite_count 3 :college "Healing" :ref "Magic p. 90"}
                 {:name "Resist Poison" :prerequisites "Vigor" :prerequisite_count 3 :college "Healing" :ref "Magic p. 91"}
                 {:name "Restoration" :prerequisites "either Major Healing or 2 of Relieve Paralysis or Restore spells" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Restore Hearing" :prerequisites "Minor Healing and either Keen Hearing or Strike Deaf" :prerequisite_count 4 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Memory" :prerequisites "Awaken and IQ 11+" :prerequisite_count 3 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Sight" :prerequisites "Minor Healing and either Keen Vision or Strike Blind" :prerequisite_count 4 :college "Healing" :ref "Magic p. 92"}
                 {:name "Restore Speech" :prerequisites "Minor Healing and either Great Voice or Strike Dumb" :prerequisite_count 6 :college "Healing" :ref "Magic p. 93"}
                 {:name "Resurrection" :prerequisites "Instant Regeneration and Summon Spirit" :prerequisite_count 9 :college "Healing" :ref "Magic p. 94"}
                 {:name "Resuscitate" :prerequisites "Magery 2, Awaken, and Stop Spasm" :prerequisite_count 0 :college "Healing" :ref "Magic: Death Spells, p. 14"}
                 {:name "Sea Legs (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Sense Disease" :prerequisites "Sense Life or 2 Healing spells" :prerequisite_count 1 :college "Healing" :ref "Bio-Tech, p. 32; Technomaner p 22"}
                 {:name "Share Energy" :prerequisites "Lend Energy" :prerequisite_count 1 :college "Healing" :ref "Magic p. 89"}
                 {:name "Share Vitality" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 90"}
                 {:name "Stop Bleeding" :prerequisites "Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 91; Fantasy, p. 169"}
                 {:name "Stop Paralysis" :prerequisites "Minor Healing and Paralyze Limb, or Strike Dumb" :prerequisite_count 4 :college "Healing" :ref "Magic p. 93"}
                 {:name "Stop Spasm" :prerequisites "Spasm or Lend Vitality" :prerequisite_count 2 :college "Healing" :ref "Magic p. 35"}
                 {:name "Suspended Animation" :prerequisites "Sleep and 4 Healing spells" :prerequisite_count 7 :college "Healing" :ref "Magic p. 94"}
                 {:name "Test (A)" :prerequisites "None" :prerequisite_count 0 :college "Healing" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Healing" :ref "Bio-Tech p. 32-33; Classic: Technomancer p. 22"}
                 {:name "Transference Bolt" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Transference Bolt)" :prerequisite_count 0 :college "Healing" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Youth" :prerequisites "Magery 3 and Halt Aging" :prerequisite_count 9 :college "Healing" :ref "Magic p. 94"}
                 {:name "Blend In (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Complex Illusion" :prerequisites "Sound and Simple Illusion" :prerequisite_count 2 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
                 {:name "Control Creation" :prerequisites "Create Animal or Create Servant" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Control Illusion" :prerequisites "Perfect Illusion" :prerequisite_count 2 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Create Animal" :prerequisites "Create Water, Create Object, and IQ 12+" :prerequisite_count 12 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Foreign Body" :prerequisites "Magery 3, Body-Reading, and Create Object" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Death Spells, p. 14"}
                 {:name "Create Mount" :prerequisites "Magery 3 and Create Animal" :prerequisite_count 13 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Create Object" :prerequisites "Magery 2, Create Earth, and Perfect Illusion" :prerequisite_count 8 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Servant" :prerequisites "Magery 3, IQ 12+, and Create Object" :prerequisite_count 9 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Create Trap" :prerequisites "Magery 4 and at least 10 Illusion and Creation spells, including Create Object" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic: Artillery Spells p. 17"}
                 {:name "Create Warrior" :prerequisites "Create Servant" :prerequisite_count 10 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Disbelieve (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Dispel Creation" :prerequisites "Control Creation" :prerequisite_count 11 :college "Illusion_and_Creation" :ref "Magic p. 99"}
                 {:name "Dispel Illusion" :prerequisites "Control Illusion" :prerequisite_count 5 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Duplicate" :prerequisites "Create Object and Copy" :prerequisite_count 15 :college "Illusion_and_Creation" :ref "Magic p. 98"}
                 {:name "Gargoyle Skin (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 8"}
                 {:name "Illusion Disguise" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170"}
                 {:name "Illusion Shell" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96; Fantasy, p. 170; Thaumatology: Urban Magics, p. 33"}
                 {:name "Image (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Independence" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 96"}
                 {:name "Initiative" :prerequisites "Independence and Wisdom" :prerequisite_count 9 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Inscribe" :prerequisites "Simple Illusion and Copy" :prerequisite_count 7 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Know Illusion" :prerequisites "Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Mirror, Mirror" :prerequisites "Magery 4, Initiative, and Phantom" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Artillery Spells p. 17-18"}
                 {:name "Perfect Illusion" :prerequisites "Magery 1 and Complex Illusion" :prerequisite_count 3 :college "Illusion_and_Creation" :ref "Magic p. 96; 'Social Engineering: Back to School, p. 24"}
                 {:name "Phantom" :prerequisites "Magery 2, Perfect Illusion, Hinder, and Apportation" :prerequisite_count 7 :college "Illusion_and_Creation" :ref "Magic p. 97"}
                 {:name "Phantom Flame" :prerequisites "Shape Fire or Simple Illusion" :prerequisite_count 1 :college "Illusion_and_Creation" :ref "Magic p. 73"}
                 {:name "Phantom Killer" :prerequisites "Magery 3 and Phantom" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: Death Spells, p. 14"}
                 {:name "Shadowplay (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Simple Illusion" :prerequisites "no Blindness and IQ 11+" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic p. 95; Fantasy, p. 170; 'Social Engineering: Back to School, p. 24"}
                 {:name "Stand Out (A)" :prerequisites "None" :prerequisite_count 0 :college "Illusion_and_Creation" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Air Vision" :prerequisites "Shape Air" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 24"}
                 {:name "Alarm" :prerequisites "Tell Time" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Analyze Magic" :prerequisites "Identify Spell" :prerequisite_count 3 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 102"}
                 {:name "Analyze Heredity (Analyze Genetics)" :prerequisites "Seeker or Sense Life" :prerequisite_count 1 :college "Knowledge" :ref "Bio-Tech, p. 30; Technomancer p 23"}
                 {:name "Ancient History" :prerequisites "History" :prerequisite_count 5 :college "Knowledge" :ref "Magic, p. 106"}
                 {:name "Astral Vision" :prerequisites "Sense Spirit and See Invisible" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Aura" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 101"}
                 {:name "Detect Magic" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 101"}
                 {:name "Divination" :prerequisites "History, and other spells by specialty" :prerequisite_count nil :college "Knowledge" :ref "Magic, p. 108; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Earth Vision" :prerequisites "Shape Earth" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 51"}
                 {:name "Echoes of the Past" :prerequisites "Magery 2, History, and Voices" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 107"}
                 {:name "Far-Feeling" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Far-Hearing" :prerequisites "Magery 1 and 4 Sound spells; may not have Deafness or Hard of Hearing" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 173"}
                 {:name "Far-Tasting" :prerequisites "Magery 1 and either Seek Food or Seek Air; cannot have No Sense of Taste/Smell" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 77"}
                 {:name "Find Direction" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Forbidden Wisdom" :prerequisites "Magery 3, Recall, and See Secrets" :prerequisite_count 0 :college "Knowledge" :ref "Magic: Death Spells, p. 15"}
                 {:name "Glass Wall" :prerequisites "5 other Knowledge spells or Earth Vision" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 103"}
                 {:name "History" :prerequisites "Trace" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Identify Loot" :prerequisites "Magery 2, Secret Spell (Identify Loot), and 7 Fourth-Level spells" :prerequisite_count 0 :college "Knowledge" :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
                 {:name "Identify Spell" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 102"}
                 {:name "Images of the Past" :prerequisites "Magery 2, History, and Simple Illusion" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Invisible Wizard Eye" :prerequisites "Wizard Eye and Invisibility" :prerequisite_count 10 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Keyfinder (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Know Location" :prerequisites "Magery 1 and Tell Position" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 103"}
                 {:name "Know Recipe" :prerequisites "Far-Tasting and Season" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 78"}
                 {:name "Know Thyself (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Know True Shape" :prerequisites "Magery 1, 1 shifting spell, and either Aura or Know Illusion" :prerequisite_count 9 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Mage Sense" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Mage Sight" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Measurement" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Memorize" :prerequisites "Wisdom or 6 Knowledge spells" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105; Social Engineering: Back to School, p. 24"}
                 {:name "Metal Vision" :prerequisites "Shape Metal" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 183"}
                 {:name "Mind over Matter" :prerequisites "Magery 2, Divination (any), Mage Sight, and Secret Spell (Mind over Matter)." :prerequisite_count 0 :college "Knowledge" :ref "Magic Styles: Dungeon Magic, p. 27"}
                 {:name "Necrovision" :prerequisites "Lightning, Seek Emitter" :prerequisite_count 0 :college "Knowledge" :ref "Technomancer p 23"}
                 {:name "Pathfinder" :prerequisites "Magery 1, IQ 12+, and 2 Seek spells; also a license from Paizo" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Plant Vision" :prerequisites "Shape Plant" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 162"}
                 {:name "Plastic Vision" :prerequisites "Shape Plastic" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 183"}
                 {:name "Prehistory" :prerequisites "Ancient History" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Projection" :prerequisites "Sense Spirit and 4 Knowledge spells" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Recall" :prerequisites "Magery 2, Memorize, and History" :prerequisite_count 9 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Reconstruct Spell" :prerequisites "Magery 2, History, and Identify Spell" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Remember Path" :prerequisites "Find Direction and Memorize" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 105"}
                 {:name "Retro-Reading" :prerequisites "Trace" :prerequisite_count 4 :college "Knowledge" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Scents of the Past" :prerequisites "Magery 2, History, and Odor" :prerequisite_count 8 :college "Knowledge" :ref "Magic, p. 107"}
                 {:name "Schematic/TL" :prerequisites "Reveal Function and History" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 177"}
                 {:name "See Secrets" :prerequisites "Seeker and Aura" :prerequisite_count 5 :college "Knowledge" :ref "Magic, p. 105; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Seek Ley Line" :prerequisites "Magery 1" :prerequisite_count 0 :college "Knowledge" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Seek Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Seek Navy" :prerequisites "Secret Spell (Seek Navy) and 8 Third-Level spells" :prerequisite_count 0 :college "Knowledge" :ref "Pyramid 3/64: Pirates and Swashbucklers, p. 14"}
                 {:name "Seek Number/TL" :prerequisites "Magery, TL 6+" :prerequisite_count 0 :college "Knowledge" :ref "Technomancer p. 18"}
                 {:name "Seeker" :prerequisites "Magery 1, IQ 12+, and 2 'Seek 'spells" :prerequisite_count 2 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 105"}
                 {:name "Sense Mana" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Small Vision" :prerequisites "Keen Vision or 5 Light and Darkness spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 111"}
                 {:name "Summon Shade" :prerequisites "Summon Spirit or Divination" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 102"}
                 {:name "Sweet Oblivion (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Televisomancy" :prerequisites "Magery, and either six other Technological spells orElectronics Operation (Communications) 15+" :prerequisite_count 0 :college "Knowledge" :ref "Classic: Technomancer p 23"}
                 {:name "Tell Position" :prerequisites "Measurement" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Tell Time" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic, p. 100"}
                 {:name "Test (A)" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Test Load (Test Area)" :prerequisites "Measurement" :prerequisite_count 1 :college "Knowledge" :ref "Magic, p. 101"}
                 {:name "Thaumatomancy" :prerequisites "None" :prerequisite_count 0 :college "Knowledge" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Trace" :prerequisites "Seeker" :prerequisite_count 3 :college "Knowledge" :ref "Basic Set, p. 249; Magic, p. 106"}
                 {:name "Vision of Doom" :prerequisites "Magery 3 and Summon Shade" :prerequisite_count 0 :college "Knowledge" :ref "Magic: Death Spells, p. 15"}
                 {:name "Water Vision" :prerequisites "Shape Water" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 187"}
                 {:name "Wizard Ear" :prerequisites "Apportation, Far-Hearing, and Sound Vision" :prerequisite_count 6 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Eye" :prerequisites "Apportation and Keen Vision" :prerequisite_count 2 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Hand" :prerequisites "Manipulate and Far-Feeling" :prerequisite_count 4 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Mouth" :prerequisites "Apportation, Far-Tasting, and Great Voice" :prerequisite_count 7 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Wizard Nose" :prerequisites "Apportation and Far-Tasting" :prerequisite_count 3 :college "Knowledge" :ref "Magic, p. 104"}
                 {:name "Blackout" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Blur" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Basic Set p. 250; Magic p. 113"}
                 {:name "Body of Shadow" :prerequisites "Magery 2 and Shape Darkness" :prerequisite_count 4 :college "Light_and_Darkness" :ref "M114"}
                 {:name "Bright Vision" :prerequisites "Keen Vision or 5 Light spells; no Blindness" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Cleansing Light" :prerequisites "Magery 3 and 10 Light and Darkness spells, including Flash, Light Jet, and Sunbolt" :prerequisite_count 10 :college "Light_and_Darkness" :ref "Magic: Death Spells, p. 16"}
                 {:name "Coherent Light Jet" :prerequisites "Light Jet" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Colors" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 110"}
                 {:name "Continual Light" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Basic Set p. 249; Magic p. 110"}
                 {:name "Continual Mage Light" :prerequisites "Mage Light and Continual Light" :prerequisite_count 5 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Continual Sunlight" :prerequisites "Sunlight" :prerequisite_count 5 :college "Light_and_Darkness" :ref "Classic: Magic p 64/Magic, p. 114"}
                 {:name "Dark Vision" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Darkness" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Basic Set p. 250; Magic p. 111"}
                 {:name "Disruption Bolt" :prerequisites "Spectrum Vision, and any 6 Light and Darkness or Technological (Radiation) spells" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Technomancer p 24"}
                 {:name "Flash" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Gloom" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Glow" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Goggles (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Hawk Vision" :prerequisites "Keen Vision or 5 Light spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Hide" :prerequisites "Blur or Forgetfulness" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113; Fantasy, p. 170"}
                 {:name "Images of the Past" :prerequisites "Magery 2, History, and Simple Illusion" :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 105"}
                 {:name "Infrared Flash" :prerequisites "Flash, Colors" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Infravision" :prerequisites "Keen Vision or 5 Light spells" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Invisibility" :prerequisites "Magery 2, IQ 13+, Invisibility, and Secret Spell (Mass Invisibility." :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 114; Fantasy, p. 170; Pyramid 3/60: Dungeon Fantasy III, p. 5"}
                 {:name "Invisible Sunbolt/TL" :prerequisites "Magery 3, Spectrum Vision, Sunbolt" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Classic: Technomancer p. 24"}
                 {:name "Light" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Basic Set p. 253; Magic p. 110"}
                 {:name "Light Jet" :prerequisites "Continual Light or Shape Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Mage Light" :prerequisites "Mage Sight and Light" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Mass Invisibility" :prerequisites "Magery 2, IQ 13+, Hallucination, and Secret Spell (Mass Hallucination" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic Styles: Dungeon Magic, p. 32"}
                 {:name "Mass Shade" :prerequisites "IQ 12+ and Shade and Secret Spell (Mass Shade" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Mirror" :prerequisites "Colors" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 112"}
                 {:name "Night Vision" :prerequisites "5 Light and Darkness spells or Keen Vision" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111; Fantasy, p. 170"}
                 {:name "Phosphorescence (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Remove Reflection" :prerequisites "Remove Shadow" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Remove Shadow" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 110"}
                 {:name "See Invisible" :prerequisites "either Dark Vision and Infravision, or Invisibility" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Shadowplay" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Shadow-Slay" :prerequisites "Magery 3, Body of Shadow, and Remove Shadow" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: Death Spells, p. 16"}
                 {:name "Shade" :prerequisites "Continual Light or Shield" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 169"}
                 {:name "Shape Darkness" :prerequisites "Darkness" :prerequisite_count 3 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Shape Light" :prerequisites "Light" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Small Vision" :prerequisites "Keen Vision or 5 Light and Darkness spells; subject cannot have Blindness or Bad Sight" :prerequisite_count 1 :college "Light_and_Darkness" :ref "Magic p. 111"}
                 {:name "Sunbolt" :prerequisites "6 Light and Darkness spells including Sunlight" :prerequisite_count 6 :college "Light_and_Darkness" :ref "Magic p. 114"}
                 {:name "Sunburst" :prerequisites "Magery 4 and at least 10 Light and Darkness spells, including Light Jet and Sunbolt" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: Artillery Spells p. 18"}
                 {:name "Sunlight" :prerequisites "Magery 1, Glow, and Colors" :prerequisite_count 4 :college "Light_and_Darkness" :ref "Magic p. 114"}
                 {:name "Twinkle (A)" :prerequisites "None" :prerequisite_count 0 :college "Light_and_Darkness" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Wall of Light" :prerequisites "Continual Light" :prerequisite_count 2 :college "Light_and_Darkness" :ref "Magic p. 113"}
                 {:name "Animate Object" :prerequisites "Magery 2 and 3 Shape spells" :prerequisite_count 6 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Annihilation" :prerequisites "Magery 3, Disintegrate, and either Deathtouch or Steal Vitality" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: Death Spells, p. 16"}
                 {:name "Awaken Craft Spirit" :prerequisites "Inspired Creation and Sense Spirit" :prerequisite_count 3 :college "Making_and_Breaking" :ref "Magic p. 115"}
                 {:name "Clean" :prerequisites "Restore" :prerequisite_count 2 :college "Making_and_Breaking" :ref "Magic p. 116; Classic: Technomancer p 25"}
                 {:name "Contract Object" :prerequisites "Magery 3 and Transform Object" :prerequisite_count 15 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Copy" :prerequisites "Dye and 1 written Language at Accented" :prerequisite_count 5 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Destabilization" :prerequisites "Magery 3, Annihilation, and Explode" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: Death Spells, p. 16"}
                 {:name "Disintegrate" :prerequisites "Magery 2, Shatter, Ruin, Earth to Air, Destroy Air, and Destroy Water" :prerequisite_count 17 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Draw Together Shards" :prerequisites "Repair, Trace, and Apportation" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Alphabet Arcane, p. 9"}
                 {:name "Dye" :prerequisites "Restore and Colors" :prerequisite_count 4 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Enlarge Object" :prerequisites "Extend Object" :prerequisite_count 16 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Explode" :prerequisites "Magery 2, Shatter, and Apportation" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Explosive Mine " :prerequisites "Magery 3 and at least 10 Making and Breaking spells, including Explode" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic: Artillery Spells p. 19"}
                 {:name "Extend Object" :prerequisites "Magery 3 and Transform Object" :prerequisite_count 15 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Fasten" :prerequisites "Knot" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Find Weakness" :prerequisites "1 spell from each of 4 elements" :prerequisite_count 4 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Immediate Action" :prerequisites "Apportation or Find Weakness" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Classic: Technomancer p. 25"}
                 {:name "Inscribe" :prerequisites "Simple Illusion and Copy" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 97"}
                 {:name "Inspired Creation" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic p. 115"}
                 {:name "Knot" :prerequisites "Stiffen" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Mapmaker" :prerequisites "Inscribe and Measurement" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Minefield " :prerequisites "Magery 4 and Explosive Mine" :prerequisite_count 11 :college "Making_and_Breaking" :ref "Magic: Artillery Spells p. 19"}
                 {:name "Mystic Mark" :prerequisites "Dye and Trace" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Rebuild/TL" :prerequisites "Magery 3, Repair, Create Object, and 3 spells of each element" :prerequisite_count 22 :college "Making_and_Breaking" :ref "Magic p. 177"}
                 {:name "Rejoin" :prerequisites "Weaken and Restore" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Repair" :prerequisites "Magery 2 and Rejoin" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Reshape" :prerequisites "Magery 1, Weaken, and either Shape Earth or Shape Plant" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Restore" :prerequisites "Find Weakness or Simple Illusion" :prerequisite_count 1 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Rive" :prerequisites "Magery 2 and Shatter" :prerequisite_count 7 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Ruin" :prerequisites "Magery 1, Weaken, and Decay" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Self-Repairing" :prerequisites "Magery 2, Repair, and Secret Spell (Self-Repairing)" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
                 {:name "Sharpen" :prerequisites "Repair" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Shatter" :prerequisites "Magery 1 and Weaken" :prerequisite_count 6 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Shatterproof" :prerequisites "Repair and Shatter" :prerequisite_count 10 :college "Making_and_Breaking" :ref "Magic p. 118"}
                 {:name "Shrink Object" :prerequisites "Contract Object" :prerequisite_count 16 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Soilproof" :prerequisites "Materialize" :prerequisite_count 3 :college "Making_and_Breaking" :ref "Magic p. 116; Thaumatology: Urban Magics, p. 33"}
                 {:name "Soul Creation" :prerequisites "Inspired Creation" :prerequisite_count 1 :college "Making_and_Breaking" :ref "Classic: Magic Items 3 p. 31"}
                 {:name "Stiffen" :prerequisites "Rejoin" :prerequisite_count 8 :college "Making_and_Breaking" :ref "Magic p. 117"}
                 {:name "Tack (A)" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Toughen" :prerequisites "Shatterproof" :prerequisite_count 11 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Transfigure Object" :prerequisites "Magery 3, Transform Object, and Secret Spell (Transfigure Object)" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 15"}
                 {:name "Transform Object" :prerequisites "M2, Reshape, 4 Create spells" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic p. 120"}
                 {:name "Transparency" :prerequisites "Dye and Stone to Earth" :prerequisite_count 9 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Weaken" :prerequisites "Find Weakness" :prerequisite_count 5 :college "Making_and_Breaking" :ref "Magic p. 116"}
                 {:name "Weapon Self" :prerequisites "Magery 2, Apportation, and 6 Making and Breaking spells including Reshape" :prerequisite_count 12 :college "Making_and_Breaking" :ref "Magic p. 119"}
                 {:name "Wizardly Workshop (A)" :prerequisites "None" :prerequisite_count 0 :college "Making_and_Breaking" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Bless" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 129"}
                 {:name "Catch Spell" :prerequisites "Magery 2, DX 12+, and Return Missile" :prerequisite_count 2 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Charge Powerstone" :prerequisites "Magery 3, Powerstone, and Lend Energy" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 126/Classic: Grimoire p. 74"}
                 {:name "Conceal Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122, Thaumatology: Urban Magics"}
                 {:name "Counterspell" :prerequisites "Magery 1 and spell being countered" :prerequisite_count 0 :college "Meta-Spell" :ref "Basic Set, p. 250; Magic p. 121"}
                 {:name "Curse" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 129"}
                 {:name "Dispel Magic" :prerequisites "Counterspell and at least 12 other spells" :prerequisite_count 13 :college "Meta-Spell" :ref "Basic Set, p. 250; Magic p. 126"}
                 {:name "Dispel Spark" :prerequisites "Magery 3, Drain Mana, and Remove Aura" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Death Spells, p. 17"}
                 {:name "Displace Spell" :prerequisites "Suspend Magic" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic p. 124, Thaumatology: Urban Magics"}
                 {:name "Drain Magery" :prerequisites "Magery 3 and Suspend Magery" :prerequisite_count 21 :college "Meta-Spell" :ref "Magic p. 130"}
                 {:name "Drain Mana" :prerequisites "Dispel Magic and Suspend Mana" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Dread Curse" :prerequisites "Magery 3 and Curse" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Death Spells, p. 17"}
                 {:name "End Scene" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 37"}
                 {:name "False Aura" :prerequisites "Conceal Magic and Aura" :prerequisite_count 5 :college "Meta-Spell" :ref "Magic p. 122"}
                 {:name "Great Ward" :prerequisites "Magery 2 and Ward" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122"}
                 {:name "Hang Spell" :prerequisites "Delay" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 128; Pyramid 3/60: Dungeon Fantasy III, p. 6; Thaumatology: Urban Magics"}
                 {:name "Internalize Elixir" :prerequisites "Magery 1, Detect Magic, and Know Recipie" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 10"}
                 {:name "Lend Spell" :prerequisites "Magery 1, Lend Skill, and 1 spell each from 6 colleges" :prerequisite_count 11 :college "Meta-Spell" :ref "Magic p. 126"}
                 {:name "Ley Buffer" :prerequisites "Magery 1 and Ley Tap" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 20"}
                 {:name "Ley Line Creation" :prerequisites "Seek Ley Line and Apportation" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 21"}
                 {:name "Ley Supply" :prerequisites "Ley Tap and either Lend Energy or Minor Draw Power" :prerequisite_count 0 :college "Meta-Spell" :ref "Thaumatology: Urban Magics, p. 20"}
                 {:name "Magic Resistance" :prerequisites "Magery 1 and 1 spell each from 7 colleges" :prerequisite_count 7 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Mana Storm" :prerequisites "Magery 4, Drain Mana, and Restore Man" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 19-20"}
                 {:name "Mana Vortex" :prerequisites "Magery 2, Lend Energy, Sense Danger, Sense Mana, and Secret Spell (Mana Vortex)." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 27; Thaumatology: Urban Magics"}
                 {:name "Maintain Spell" :prerequisites "Link" :prerequisite_count 17 :college "Meta-Spell" :ref "Magic p. 128; Thaumatology: Urban Magics"}
                 {:name "Penetrating Spell" :prerequisites "Delay and Find Weakness" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Pentagram" :prerequisites "Spell Shield" :prerequisite_count 9 :college "Meta-Spell" :ref "Magic p. 124; Thaumatology: Urban Magics"}
                 {:name "Preemptive Experience" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/28: Thaumatology II, p. 37"}
                 {:name "Punishment Circle" :prerequisites "Magery 3 and either Pentagram or Repel Spirits" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 19-20"}
                 {:name "Raise Cone of Power" :prerequisites "Lend Energy and either Pentagram or Restore Mana" :prerequisite_count 0 :college "Meta-Spell" :ref "GURPS Thaumatology, p. 52"}
                 {:name "Reflect" :prerequisites "Ward" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics"}
                 {:name "Remove Aura" :prerequisites "Dispel Magic and Aura" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Remove Curse" :prerequisites "Magery 2 and 1 spell from each of 15 colleges" :prerequisite_count 15 :college "Meta-Spell" :ref "Magic p. 126; Thaumatology: Urban Magics"}
                 {:name "Restore Mana" :prerequisites "Dispel Magic and Suspend Mana" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 128; Thaumatology: Urban Magics"}
                 {:name "Scryfool" :prerequisites "Magery 2, Sense Observation, and Simple Illusion" :prerequisite_count 3 :college "Meta-Spell" :ref "Magic p. 123; Classic: Grimoire p 74"}
                 {:name "Scryguard" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "GURPS Fantasy, p. 170; Thaumatology: Urban Magics"}
                 {:name "Scrywall" :prerequisites "Scryguard" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics, p. 33"}
                 {:name "Seek Magic" :prerequisites "Detect Magic" :prerequisite_count 1 :college "Meta-Spell" :ref "Magic p. 102"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Sovereign Countermagic" :prerequisites "Magery 3, Analyze Magic, Dispel Magic, and Secret Spell (Sovereign CountermagicThaumatology: Urban Magics." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 28"}
                 {:name "Sovereign Ward" :prerequisites "Magery 3, Dispel Magic, Ward, and Secret Spell (Sovereign WardThaumatology: Urban Magics." :prerequisite_count 0 :college "Meta-Spell" :ref "Magic Styles: Dungeon Magic, p. 28"}
                 {:name "Spell Shield" :prerequisites "Magery 2, Scryguard, and Magic Resistance" :prerequisite_count 8 :college "Meta-Spell" :ref "Magic p. 124"}
                 {:name "Spell Wall" :prerequisites "Spell Shield" :prerequisite_count 9 :college "Meta-Spell" :ref "Magic p. 124; Thaumatology: Urban Magics"}
                 {:name "Spellguard" :prerequisites "Dispel Magic" :prerequisite_count 14 :college "Meta-Spell" :ref "Magic p. 127; Thaumatology: Urban Magics"}
                 {:name "Steal Spell" :prerequisites "Lend Spell and Great Ward" :prerequisite_count 13 :college "Meta-Spell" :ref "Magic p. 127"}
                 {:name "Suspend Curse" :prerequisites "Magery 1 and 1 spell each from 12 colleges" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 125"}
                 {:name "Suspend Magery" :prerequisites "Magery 2 and 2 spells each from 10 colleges" :prerequisite_count 20 :college "Meta-Spell" :ref "Magic p. 130"}
                 {:name "Suspend Magic" :prerequisites "Suspend Spell and 8 other spells" :prerequisite_count 8 :college "Meta-Spell" :ref "Magic p. 123"}
                 {:name "Suspend Mana" :prerequisites "Suspend Magic and 1 spell each from 10 colleges" :prerequisite_count 10 :college "Meta-Spell" :ref "Magic p. 125"}
                 {:name "Suspend Spell" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic p. 121; Thaumatology: Urban Magics"}
                 {:name "Telecast" :prerequisites "Magery 3, Teleport, Wizard Eye, and 1 spell each from 10 colleges" :prerequisite_count 12 :college "Meta-Spell" :ref "Magic p. 128"}
                 {:name "Thaumatomancy (A)" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Throw Spell" :prerequisites "Delay and Catch Spell" :prerequisite_count 16 :college "Meta-Spell" :ref "Magic p. 128"}
                 {:name "Use Item (A)" :prerequisites "None" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic: The Least of Spells p. 12-13"}
                 {:name "Void Bolt" :prerequisites "Magery 4, 4 Essential element spells of different colleges, and 4 missile spells, 1 from each of the Essential element spells taken as prerequisites" :prerequisite_count 0 :college "Meta-Spell" :ref "Pyramid 3/25: Epic Magic, p. 19"}
                 {:name "Ward" :prerequisites "Magery 1" :prerequisite_count 0 :college "Meta-Spell" :ref "Magic p. 122; Thaumatology: Urban Magics"}
                 {:name "Adjuration (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 13"}
                 {:name "Alertness" :prerequisites "Magery 2 and Create Acid" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 133; Classic: Magic p 69"}
                 {:name "Avoid" :prerequisites "Hide, Fear, and Forgetfulness" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 140"}
                 {:name "Berserker" :prerequisites "Bravery" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Boost (Attribute) Intelligence" :prerequisites "Wisdom" :prerequisite_count nil :college "Mind_Control" :ref "Magic p. 37"}
                 {:name "Bravery" :prerequisites "Fear" :prerequisite_count 1 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Charm" :prerequisites "Magery 1, Loyalty, and 7 other Mind Control spells" :prerequisite_count 8 :college "Mind_Control" :ref "Magic p. 139"}
                 {:name "Coma" :prerequisites "Magery 3, Lesser Geas, and Sleep" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: Death Spells, p. 17"}
                 {:name "Command" :prerequisites "Magery 2 and Forgetfulness" :prerequisite_count 2 :college "Mind_Control" :ref "Basic Set'', p. 251; Magic p. 136"}
                 {:name "Compel Lie" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 137"}
                 {:name "Confuse Memory" :prerequisites "Foolishness" :prerequisite_count 1 :college "Mind_Control" :ref "Pyramid 3/48: Secret Magic, p. 14"}
                 {:name "Daze" :prerequisites "Foolishness" :prerequisite_count 1 :college "Mind_Control" :ref "Basic Set'', p. 250; Magic p. 134"}
                 {:name "Disbelieve (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Discord" :prerequisites "Magery 2, Emotion Control, Vexation, and Secret Spell (Discord)" :prerequisite_count 0 :college "Mind_Control" :ref "Magic Styles: Dungeon Magic, p. 31"}
                 {:name "Disorient" :prerequisites "Foolishness" :prerequisite_count 1 :college "Mind_Control" :ref "Magic p. 135"}
                 {:name "Drama (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 7"}
                 {:name "Dream Projection" :prerequisites "Dream Sending" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 46"}
                 {:name "Dream Sending" :prerequisites "Dream Viewing or Sleep" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 45"}
                 {:name "Drunkenness" :prerequisites "Foolishness and Clumsiness" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 136"}
                 {:name "Dull (Sense)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic p. 133"}
                 {:name "Dullness" :prerequisites "2 Dull spells" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Ecstasy" :prerequisites "Magery 2 and Emotion Control" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 139"}
                 {:name "Emotion Control" :prerequisites "Loyalty or Mental Stun" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 137"}
                 {:name "Encrypt" :prerequisites "Daze" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 135"}
                 {:name "Enslave" :prerequisites "Charm and Telepathy" :prerequisite_count 14 :college "Mind_Control" :ref "Magic p. 141"}
                 {:name "Enthrall" :prerequisites "Forgetfulness, Daze, and Slow" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 139"}
                 {:name "False Memory" :prerequisites "Forgetfulness and 6 other Mind Control spells" :prerequisite_count 7 :college "Mind_Control" :ref "Magic p. 139"}
                 {:name "Fascinate" :prerequisites "Daze" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 135"}
                 {:name "Fear" :prerequisites "Sense Emotion or Empathy" :prerequisite_count 0 :college "Mind_Control" :ref "Magic p. 139; Fantasy, p. 171"}
                 {:name "Foolishness" :prerequisites "IQ 12+" :prerequisite_count 0 :college "Mind_Control" :ref "Basic Set p. 250; Magic p. 134"}
                 {:name "Forgetfulness" :prerequisites "Magery 1 and Foolishness" :prerequisite_count 1 :college "Mind_Control" :ref "Basic Set p. 250; Magic p. 135"}
                 {:name "Game Addict" :prerequisites "Charm" :prerequisite_count 0 :college "Mind_Control" :ref "Classic: Technomancer p. 25"}
                 {:name "Glib Tongue" :prerequisites "Suggestion" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 141"}
                 {:name "Great Geas" :prerequisites "Magery 3 and 15 Mind Control spells including Lesser Geas" :prerequisite_count 15 :college "Mind_Control" :ref "Magic p. 141; Social Engineering: Back to School, p. 24"}
                 {:name "Great Hallucination" :prerequisites "Magery 2 and Hallucination" :prerequisite_count 8 :college "Mind_Control" :ref "Magic p. 141"}
                 {:name "Hallucination" :prerequisites "Madness and Suggestion" :prerequisite_count 7 :college "Mind_Control" :ref "Magic p. 140"}
                 {:name "Hypnotize (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 13"}
                 {:name "Keen (Sense)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic p. 133"}
                 {:name "Keyfinder (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Know Thyself (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Lesser Geas" :prerequisites "Magery 2 and 10 Mind Control spells" :prerequisite_count 10 :college "Mind_Control" :ref "Magic p. 140; Social Engineering: Back to School, p. 24"}
                 {:name "Literary Hunger" :prerequisites "Magery 1" :prerequisite_count 0 :college "Mind_Control" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Loyalty" :prerequisites "Bravery and 2 other Mind Control spells" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 136"}
                 {:name "Lure" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 137/Classic: Grimoire p 76"}
                 {:name "Madness" :prerequisites "Forgetfulness or Drunkenness" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 136"}
                 {:name "Mass Charm" :prerequisites "Magery 2, IQ 13+, Charm, and Secret Spell (Mass Charm)" :prerequisite_count 2 :college "Mind_Control" :ref "Magic Styles: Dungeon Magic, p. 31"}
                 {:name "Mass Daze" :prerequisites "Daze and IQ 13+" :prerequisite_count 3 :college "Mind_Control" :ref "Basic Set p. 251; Magic p. 137"}
                 {:name "Mass Hallucination" :prerequisites "Magery 2, IQ 13+, Hallucination, and Secret Spell (Mass Hallucination)" :prerequisite_count 8 :college "Mind_Control" :ref "Magic Styles: Dungeon Magic, p. 32"}
                 {:name "Mass Mutilation" :prerequisites "Magery 4 and at least 10 Mind Control spells including Madness and Mass Suggestion" :prerequisite_count 10 :college "Mind_Control" :ref "Magic: Artillery Spells p. 20"}
                 {:name "Mass Sleep" :prerequisites "Sleep and IQ 13+" :prerequisite_count 3 :college "Mind_Control" :ref "Basic Set p. 251; Magic p. 137"}
                 {:name "Mass Suggestion" :prerequisites "Suggestion" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 141"}
                 {:name "Memorize" :prerequisites "Wisdom or 6 Knowledge spells" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 105; Social Engineering: Back to School, p. 24"}
                 {:name "Mental Stun" :prerequisites "Daze or Stun" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 135"}
                 {:name "Mind-Killer" :prerequisites "Magery 3, Sickness, and Strengthen Will" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: Death Spells, p. 17"}
                 {:name "Mindlessness" :prerequisites "Magery 2 and Forgetfulness" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 137"}
                 {:name "Nightmare" :prerequisites "Magery 2, Death Vision, Fear, and Sleep" :prerequisite_count 5 :college "Mind_Control" :ref "Magic p. 140"}
                 {:name "Oath" :prerequisites "Magery 1 and Emotion Control" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Pacify" :prerequisites "Magery 2, Persuasion, Relieve Madness, and Secret Spell (Pacify)" :prerequisite_count 0 :college "Mind_Control" :ref "Magic Styles: Dungeon Magic, p. 24"}
                 {:name "Panic" :prerequisites "Fear" :prerequisite_count 1 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Patience (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 13"}
                 {:name "Peaceful Sleep" :prerequisites "Sleep and Silence" :prerequisite_count 5 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Permanent Forgetfulness" :prerequisites "Magery 2, Forgetfulness, and IQ 13+" :prerequisite_count 2 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Permanent Madness" :prerequisites "Magery 2, Madness, and IQ 13+" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 139"}
                 {:name "Rear Vision" :prerequisites "Alertness" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Recall" :prerequisites "Magery 2, Memorize, and History" :prerequisite_count 9 :college "Mind_Control" :ref "Magic p. 104"}
                 {:name "Relieve Madness" :prerequisites "Lend Vitality and Wisdom" :prerequisite_count 9 :college "Mind_Control" :ref "Magic p. 92"}
                 {:name "Sickness" :prerequisites "Drunkenness or Pestilence" :prerequisite_count 3 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Sleep" :prerequisites "Daze" :prerequisite_count 2 :college "Mind_Control" :ref "Basic Set p. 251; Magic p. 135"}
                 {:name "Speed Reading" :prerequisites "IQ 12+ or Gift of Letters" :prerequisite_count 0 :college "Mind_Control" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Stabbing Party" :prerequisites "Magery 4 and at least 10 Mind Control spells including Command and Mass Suggestion" :prerequisite_count 10 :college "Mind_Control" :ref "Magic: Artillery Spells p. 20-21"}
                 {:name "Startle (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 13"}
                 {:name "Strengthen Will" :prerequisites "Magery 1 and 6 Mind Control spells" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 136"}
                 {:name "Suggestion" :prerequisites "Emotion Control and Forgetfulness" :prerequisite_count 5 :college "Mind_Control" :ref "Magic p. 140"}
                 {:name "Sweet Oblivion (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 11"}
                 {:name "Transfer Loyalty" :prerequisites "Bravery and two other Mind Controlspells, or any Limiting Enchantment" :prerequisite_count 0 :college "Mind_Control" :ref "Classic: Magic Items 3 p 33"}
                 {:name "Terror" :prerequisites "Fear" :prerequisite_count 1 :college "Mind_Control" :ref "Magic p. 134"}
                 {:name "Vigil" :prerequisites "Magery 2, Sleep, and Lend Energy" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Volatility (A)" :prerequisites "None" :prerequisite_count 0 :college "Mind_Control" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Weaken Will" :prerequisites "Magery 1 and Foolishness" :prerequisite_count 1 :college "Mind_Control" :ref "Magic p. 136"}
                 {:name "Will Lock" :prerequisites "Emotion Control" :prerequisite_count 4 :college "Mind_Control" :ref "Magic p. 138"}
                 {:name "Wisdom" :prerequisites "6 other Mind Control spells" :prerequisite_count 6 :college "Mind_Control" :ref "Magic p. 135; Social Engineering: Back to School, p. 24"}
                 {:name "Writer's Block" :prerequisites "Magery 1" :prerequisite_count 0 :college "Mind_Control" :ref "Pyramid 3/48: Secret Magic, p. 22"}
                 {:name "Air Vortex" :prerequisites "Magery 2, Body of Air, and Windstorm" :prerequisite_count 5 :college "Movement" :ref "Magic p. 26"}
                 {:name "Apportation" :prerequisites "Magery 1" :prerequisite_count 0 :college "Movement" :ref "Basic Set, p. 251; Magic p. 142"}
                 {:name "Beacon" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Movement" :ref "Magic p. 83"}
                 {:name "Blink" :prerequisites "Teleport" :prerequisite_count 5 :college "Movement" :ref "Magic p. 148"}
                 {:name "Blink Other" :prerequisites "Blink" :prerequisite_count 6 :college "Movement" :ref "Magic p. 148"}
                 {:name "Cloud-Vaulting" :prerequisites "Magery 2, Jump, and Walk on Air" :prerequisite_count 12 :college "Movement" :ref "Magic p. 148"}
                 {:name "Cloud-Walking" :prerequisites "Walk on Air and Walk on Water" :prerequisite_count 9 :college "Movement" :ref "Magic p. 148"}
                 {:name "Collision" :prerequisites "Magery 4 and at least 10 Movement spells including Poltergeist and Pull" :prerequisite_count 10 :college "Movement" :ref "Magic: Artillery Spells p. 21"}
                 {:name "Crushing Fist" :prerequisites "Magery 4 and at least 10 Movement spells, including Distant Blow and Wizard Han" :prerequisite_count 10 :college "Movement" :ref "Magic: Artillery Spells p. 21"}
                 {:name "Cushion (A)" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Dancing Object (Air-Golem)[note 1]" :prerequisites "Magery 2 and Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144Classic Magic p 61"}
                 {:name "Deflect Missile" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref ""}
                 {:name "Disruption" :prerequisites "Magery 3 and any 10 Movement spells, including Manipulate and Undo" :prerequisite_count 10 :college "Movement" :ref "Magic: Death Spells, p. 17"}
                 {:name "Distant Blow" :prerequisites "Magery 2 and Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144"}
                 {:name "Divert Teleport" :prerequisites "Mager 3 and Trace Teleport" :prerequisite_count 6 :college "Movement" :ref "Magic p. 84"}
                 {:name "Ethereal Body" :prerequisites "6 Movement spells, or Magery 3 and Body of Air" :prerequisite_count 4 :college "Movement" :ref "Magic p. 146"}
                 {:name "Flee (A)" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Flight" :prerequisites "Magery 2 and Levitation" :prerequisite_count 2 :college "Movement" :ref "Magic p. 145; Fantasy, p. 171"}
                 {:name "Flying Carpet" :prerequisites "Flight, or Magery 2 and Walk on Air" :prerequisite_count 3 :college "Movement" :ref "Magic p. 145"}
                 {:name "Force Ball" :prerequisites "Magery 4, Catch Spell, Force Dome, and Sense Foes" :prerequisite_count 0 :college "Movement" :ref "Magic: Artillery Spells p. 24-25"}
                 {:name "Freedom" :prerequisites "3 Body Control spells, 3 Movement spells, and 3 Protection and Warning spells" :prerequisite_count 9 :college "Movement" :ref "Magic p. 148"}
                 {:name "Glue" :prerequisites "Haste" :prerequisite_count 1 :college "Movement" :ref "Magic p. 142"}
                 {:name "Grease" :prerequisites "Haste" :prerequisite_count 1 :college "Movement" :ref "Magic p. 142; Classic: Grimoire p 79"}
                 {:name "Great Deflect Missile" :prerequisites "Magery 2, Secret Spell (Great Deflect Missile), and Deflect Missile" :prerequisite_count 2 :college "Movement" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magic Styles: Dungeon Magic"}
                 {:name "Great Haste" :prerequisites "Magery 1, IQ 12+, and Haste" :prerequisite_count 1 :college "Movement" :ref "Basic Set, p. 251; Magic p. 146"}
                 {:name "Hail of Lead" :prerequisites "Haste, Immediate Action" :prerequisite_count 0 :college "Movement" :ref "Classic: Technomancer p 26"}
                 {:name "Haste" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Basic Set, p. 251; Magic p. 142"}
                 {:name "Hawk Flight" :prerequisites "Flight" :prerequisite_count 3 :college "Movement" :ref "Magic p. 146"}
                 {:name "Hinder" :prerequisites "Clumsiness or Haste" :prerequisite_count 1 :college "Movement" :ref "Basic Set, p. 244; Magic p. 36"}
                 {:name "Hold Fast" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143"}
                 {:name "Homing Missile" :prerequisites "Q 13+, Seeker and Curse-Missile, Explosive Fireball, Fireball, High-Explosive Fireball, Ice Dagger, Ice Sphere, Shaped-Charge Fireball, Stone Missile or Winged Knife" :prerequisite_count 0 :college "Movement" :ref "Classic: Technomancer p. 26"}
                 {:name "Increase Burden" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143; Classic: Grimoire p. 79"}
                 {:name "Jump" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143"}
                 {:name "Levitation" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143, Fantasy, p. 171/Classic: Magic p 70"}
                 {:name "Ley Float" :prerequisites "Magery 3, Enchant, and Ley Supply" :prerequisite_count 12 :college "Movement" :ref "Thaumatology: Urban Magics, p. 20"}
                 {:name "Ley Running" :prerequisites "Seek Ley Line and Haste" :prerequisite_count 1 :college "Movement" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Ley Vehicle" :prerequisites "Ley Float and Ley Running" :prerequisite_count 0 :college "Movement" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Light Tread" :prerequisites "Apportation and Shape Earth" :prerequisite_count 3 :college "Movement" :ref "Magic p. 145"}
                 {:name "Lighten Burden" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143; Fantasy, p. 171"}
                 {:name "Lockmaster" :prerequisites "Magery 2 and Apportation" :prerequisite_count 1 :college "Movement" :ref "Basic Set, p. 251; Magic p. 144"}
                 {:name "Locksmith" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143"}
                 {:name "Long March" :prerequisites "Magery 1 and Clumsiness or Debility" :prerequisite_count 1 :college "Movement" :ref "Magic p. 143"}
                 {:name "Magic Bullet" :prerequisites "Poltergeist" :prerequisite_count 0 :college "Movement" :ref "Classic: Technomancer p. 26"}
                 {:name "Manipulate" :prerequisites "Locksmith" :prerequisite_count 2 :college "Movement" :ref "Magic p. 145"}
                 {:name "Open Door (A)" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Quarter" :prerequisites "Magery 3 and any 10 Movement spells, including Pull and Repel" :prerequisite_count 10 :college "Movement" :ref "Magic: Death Spells, p. 18"}
                 {:name "Quick March" :prerequisites "Magery 1 and Haste" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144; Fantasy, p. 171"}
                 {:name "Poltergeist" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144"}
                 {:name "Pull" :prerequisites "Magery 2 and 4 Movement spells including Levitation" :prerequisite_count 4 :college "Movement" :ref "Magic p. 146"}
                 {:name "Rapid Journey" :prerequisites "Magery 3 and either Teleport or Timeport" :prerequisite_count 5 :college "Movement" :ref "Magic p. 82"}
                 {:name "Reduce Recoil" :prerequisites "" :prerequisite_count 0 :college "Movement" :ref "Classic: Technomancer p. 26"}
                 {:name "Remove Fetus" :prerequisites "Ease Labor and either Minor Healing or Apportation" :prerequisite_count 0 :college "Movement" :ref "GURPS Bio-Tech, p. 32"}
                 {:name "Repel" :prerequisites "Magery 2 and 4 Movement spells including Levitation" :prerequisite_count 4 :college "Movement" :ref "Magic p. 146"}
                 {:name "Reorient (A)" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Sink (A)" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Slasher" :prerequisites "Magery 4 and at least 10 Movement spells including Dancing Object and Winged Knife" :prerequisite_count 10 :college "Movement" :ref "Magic: Artillery Spells p. 22"}
                 {:name "Slide" :prerequisites "Apportation and Grease" :prerequisite_count 3 :college "Movement" :ref "Magic p. 145"}
                 {:name "Slow" :prerequisites "Magery 1, Haste, and Hinder" :prerequisite_count 2 :college "Movement" :ref "Magic p. 145"}
                 {:name "Slow Fall" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144"}
                 {:name "Steady Hand" :prerequisites "None" :prerequisite_count 0 :college "Movement" :ref "Classic: Technomancer p. 26"}
                 {:name "Swim" :prerequisites "Shape Water and Levitation" :prerequisite_count 6 :college "Movement" :ref "Magic p. 147"}
                 {:name "Transfer Pregnancy" :prerequisites "Magery 2 and Remove Fetus" :prerequisite_count 0 :college "Movement" :ref "GURPS Bio-Tech, p. 32"}
                 {:name "Teleport" :prerequisites "Hawk Flight or IQ 15+, and at least 1 spell from 10 colleges" :prerequisite_count 4 :college "Movement" :ref "Magic p. 147; Fantasy, p. 171"}
                 {:name "Teleport Other" :prerequisites "Magery 3 and Teleport" :prerequisite_count 5 :college "Movement" :ref "Magic p. 147"}
                 {:name "Trace Teleport" :prerequisites "Teleport, Timeport, or Plane Shift" :prerequisite_count 5 :college "Movement" :ref "Magic p. 84"}
                 {:name "Undo" :prerequisites "Locksmith" :prerequisite_count 2 :college "Movement" :ref "Magic p. 145"}
                 {:name "Wallwalker" :prerequisites "Apportation" :prerequisite_count 1 :college "Movement" :ref "Magic p. 144"}
                 {:name "Winged Knife" :prerequisites "Poltergeist" :prerequisite_count 2 :college "Movement" :ref "Magic p. 145"}
                 {:name "Wizard Hand" :prerequisites "Manipulate and Far-Feeling" :prerequisite_count 4 :college "Movement" :ref "Magic p. 104"}
                 {:name "Affect Spirits" :prerequisites "Solidify" :prerequisite_count 4 :college "Necromantic" :ref "Magic p. 151"}
                 {:name "Age" :prerequisites "Youth or 6 Necromantic spells" :prerequisite_count 6 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Animate Shadow" :prerequisites "Skull-Spirit and Shape Darkness" :prerequisite_count 9 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Animation" :prerequisites "Summon Spirit" :prerequisite_count 2 :college "Necromantic" :ref "Magic p. 150"}
                 {:name "Astral Block" :prerequisites "Summon Spirit and Repel Spirits" :prerequisite_count 16 :college "Necromantic" :ref "Magic p. 159"}
                 {:name "Astral Vision" :prerequisites "Sense Spirit and See Invisible" :prerequisite_count 6 :college "Necromantic" :ref "Magic p. 105"}
                 {:name "Awaken Craft Spirit" :prerequisites "Inspired Creation and Sense Spirit" :prerequisite_count 3 :college "Necromantic" :ref "Magic p. 115"}
                 {:name "Banish" :prerequisites "Magery 1 and 1 spell each from 10 colleges" :prerequisite_count 10 :college "Necromantic" :ref "Magic p. 156"}
                 {:name "Bind Spirit" :prerequisites "Command Spirit and Soul Jar" :prerequisite_count 12 :college "Necromantic" :ref "Magic p. 158"}
                 {:name "Burning Death" :prerequisites "Magery 2, Heat, and Sickness" :prerequisite_count 10 :college "Necromantic" :ref "Magic p. 76"}
                 {:name "Command Spirit" :prerequisites "Summon Spirit and Turn Spirit" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 153"}
                 {:name "Control Zombie" :prerequisites "Zombie" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 152"}
                 {:name "Death Vision" :prerequisites "Magery 1" :prerequisite_count 0 :college "Necromantic" :ref "Basic Set, p. 251; Magic p. 149"}
                 {:name "Dramatic Departure (A)" :prerequisites "None" :prerequisite_count 0 :college "Necromantic" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Entrap Spirit" :prerequisites "Magery 1, Soul Jar, and Turn Spirit" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 157"}
                 {:name "Evisceration" :prerequisites "Magery 3, Apportation, and Steal Vitality" :prerequisite_count 6 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Final Rest" :prerequisites "Magery 1 or Spirit Empathy" :prerequisite_count 0 :college "Necromantic" :ref "Magic p. 89"}
                 {:name "Grasping Doom" :prerequisites "Mass Zombie and Secret Spell (Grasping Doom" :prerequisite_count 0 :college "Necromantic" :ref "Magic Styles: Dungeon Magic, p. 15"}
                 {:name "Hellspawn" :prerequisites "Summon Demon" :prerequisite_count 11 :college "Necromantic" :ref "GURPS Bio-Tech, p. 32; Technomander p. 27"}
                 {:name "Invoke (A)" :prerequisites "None" :prerequisite_count 0 :college "Necromantic" :ref "Magic: The Least of Spells p. 14-15"}
                 {:name "Lich" :prerequisites "Magery 3, IQ 13+, Enchant, Soul Jar, and Zombie" :prerequisite_count 19 :college "Necromantic" :ref "Magic p. 159"}
                 {:name "Mass Zombie" :prerequisites "Zombie and Charisma 2+" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 153; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Materialize" :prerequisites "Summon Spirit" :prerequisite_count 2 :college "Necromantic" :ref "Magic p. 150"}
                 {:name "Pestilence" :prerequisites "Magery 1, Steal Vitality, and Decay" :prerequisite_count 7 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Plant Zombie" :prerequisites "Zombie and at least four Plant spells" :prerequisite_count 0 :college "Necromantic" :ref "Pyramid 3/68: Natural Magic, p. 10"}
                 {:name "Punishment Circle" :prerequisites "Magery 3 and either Pentagram or Repel Spirits" :prerequisite_count 0 :college "Necromantic" :ref "Magic: Artillery Spells p. 19-20"}
                 {:name "Repel Spirits" :prerequisites "Banish and Turn Spirit" :prerequisite_count 14 :college "Necromantic" :ref "Magic p. 158"}
                 {:name "Resurrection" :prerequisites "Instant Regeneration and Summon Spirit" :prerequisite_count 9 :college "Necromantic" :ref "Magic p. 94"}
                 {:name "Reverie of Ruin (A)" :prerequisites "None" :prerequisite_count 0 :college "Necromantic" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Rotting Death" :prerequisites "Magery 2, Sickness, and Pestilence" :prerequisite_count 9 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Self-Destruct" :prerequisites "Magery 1 and at least one spell from each of 10 different colleges or from Fire, Meta-Spells, Necromantic College possibly including Explode" :prerequisite_count 10 :college "Necromantic" :ref "Magic: Artillery Spells p. 23"}
                 {:name "Sense Spirit" :prerequisites "Death Vision" :prerequisite_count 1 :college "Necromantic" :ref "Basic Set, p. 252; Magic p. 149"}
                 {:name "Skull-Spirit" :prerequisites "4 Necromantic spells" :prerequisite_count 0 :college "Necromantic" :ref "Magic p. 151"}
                 {:name "Slow Healing" :prerequisites "Magery 1, Frailty, and Steal Vitality" :prerequisite_count 6 :college "Necromantic" :ref "Magic p. 153"}
                 {:name "Solidify" :prerequisites "Materialize" :prerequisite_count 3 :college "Necromantic" :ref "Magic p. 151"}
                 {:name "Soul Jar" :prerequisites "Magery 1 and 6 Necromantic spells including Steal Vitality" :prerequisite_count 6 :college "Necromantic" :ref "Magic p. 154"}
                 {:name "Soul Prison" :prerequisites "Magery 3, Banish, and Soul Jar (Magery 3, Banish, Soul Jar, any four of Animate Shadow, Possession, Repel Spirits, Divination (Dactylomancy*, Mass Zombie, Summon Demon, Pentagram, Summon Earth Elemental, Phase Other, or Zombie Summoning and Secret Spell (Soul Prison according to Magic Styles: Dungeon Magic" :prerequisite_count 0 :college "Necromantic" :ref "Magic: Death Spells, p. 18 and Magic Styles: Dungeon Magic, p. 16"}
                 {:name "Spirit Incursion" :prerequisites "Magery 4 and at least 10 Necromantic spells including Skull-Spirit" :prerequisite_count 10 :college "Necromantic" :ref "Magic: Artillery Spells p. 22"}
                 {:name "Steal (Attribute)" :prerequisites "Magery 3 and varies" :prerequisite_count nil :college "Necromantic" :ref "Magic p. 158"}
                 {:name "Steal Beauty" :prerequisites "Magery 3, Alter Visage, and Steal Vitality" :prerequisite_count 15 :college "Necromantic" :ref "Magic p. 159"}
                 {:name "Steal Energy" :prerequisites "Minor Healing" :prerequisite_count 4 :college "Necromantic" :ref "Magic p. 150"}
                 {:name "Steal Skill" :prerequisites "Magery 3, Borrow Skill, and Daze" :prerequisite_count 9 :college "Necromantic" :ref "Magic p. 158"}
                 {:name "Steal Vitality" :prerequisites "Steal Energy" :prerequisite_count 4 :college "Necromantic" :ref "Magic p. 150"}
                 {:name "Steal Youth" :prerequisites "Youth, Age, and Steal Vitality" :prerequisite_count 13 :college "Necromantic" :ref "Magic p. 158"}
                 {:name "Stop Healing" :prerequisites "Slow Healing" :prerequisite_count 7 :college "Necromantic" :ref "Magic p. 153/Classic: Grimoire p. 84"}
                 {:name "Strike Barren" :prerequisites "Magery 1, Steal Vitality, and Decay" :prerequisite_count 7 :college "Necromantic" :ref "Magic p. 41"}
                 {:name "Suicide" :prerequisites "Magery 1" :prerequisite_count 0 :college "Necromantic" :ref "Magic: Death Spells, p. 19"}
                 {:name "Summon Demon" :prerequisites "Magery 1 and at least 1 spell from 10 colleges" :prerequisite_count 10 :college "Necromantic" :ref "Basic Set, p. 252; Magic p. 155"}
                 {:name "Summon Spirit" :prerequisites "Magery 2 and Death Vision" :prerequisite_count 1 :college "Necromantic" :ref "Basic Set, p. 252; Magic p. 150"}
                 {:name "Turn Spirit" :prerequisites "Fear and Sense Spirit" :prerequisite_count 3 :college "Necromantic" :ref "Magic p. 151"}
                 {:name "Turn Zombie" :prerequisites "Zombie or 'Holy'" :prerequisite_count 0 :college "Necromantic" :ref "Basic Set, p. 252; Magic p. 152"}
                 {:name "Weaken Blood" :prerequisites "Sickness or Steal Vitality" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 40"}
                 {:name "Wraith" :prerequisites "Magery 3, IQ 13+, Enchant, Halt Aging, and Soul Jar" :prerequisite_count 24 :college "Necromantic" :ref "Magic p. 160"}
                 {:name "Zombify" :prerequisites "Magery 3, Pestilence, and Zombie" :prerequisite_count 0 :college "Necromantic" :ref "Magic: Death Spells, p. 18"}
                 {:name "Zombie" :prerequisites "Summon Spirit and Lend Vitality" :prerequisite_count 4 :college "Necromantic" :ref "Basic Set p. 252; Magic p. 151; Pyramid 3/60: Dungeon Fantasy III p. 6/ Undead p. 41"}
                 {:name "Zombie Summoning" :prerequisites "Zombie" :prerequisite_count 5 :college "Necromantic" :ref "Magic p. 153"}
                 {:name "Animate Fungus" :prerequisites "Fungus Control" :prerequisite_count 7 :college "Plant" :ref "Magic p. 164 (Animate Plant); Magic: Plant Spells, p. 17"}
                 {:name "Bless Fungus" :prerequisites "Heal Fungus" :prerequisite_count 3 :college "Plant" :ref "Magic p. 161 (Bless Plants); Magic: Plant Spells, p. 17"}
                 {:name "Blight" :prerequisites "Fungus Growth" :prerequisite_count 4 :college "Plant" :ref "Magic p. 162; Magic: Plant Spells, p. 17"}
                 {:name "Body of Fungus" :prerequisites "Magery 2 and Fungus Form" :prerequisite_count 7 :college "Plant" :ref "Magic p. 165 (Body of Wood); Magic: Plant Spells, p. 17"}
                 {:name "Body of Slime" :prerequisites "Magery 2 and Fungus Form" :prerequisite_count 11 :college "Plant" :ref "Magic p. 165; Magic: Plant Spells, p. 17"}
                 {:name "Choke" :prerequisites "Magery 1 and Spore Cloud" :prerequisite_count 5 :college "Plant" :ref "Magic p. 40; Magic: Plant Spells, p. 17"}
                 {:name "Create Fungus" :prerequisites "Magery 1 and Fungus Growth" :prerequisite_count 4 :college "Plant" :ref "Magic p. 163 (Create Plant); Magic: Plant Spells, p. 17"}
                 {:name "Cure Disease" :prerequisites "Magery 3 and Identify Fungus" :prerequisite_count 5 :college "Plant" :ref "Magic p. 91; Magic: Plant Spells, p. 17"}
                 {:name "Decay" :prerequisites "Test Food" :prerequisite_count 1 :college "Plant" :ref "Magic p. 77"}
                 {:name "Foul Water" :prerequisites "Decay" :prerequisite_count 4 :college "Plant" :ref "Magic p. 185; Magic: Plant Spells, p. 17"}
                 {:name "Fungus Control" :prerequisites "6 Fungus spells" :prerequisite_count 6 :college "Plant" :ref "Magic p. 164 (Plant Control); Magic: Plant Spells, p. 17"}
                 {:name "Fungus Form" :prerequisites "Magery 1 and 6 Fungus Spells" :prerequisite_count 6 :college "Plant" :ref "Magic p. 164 (Plant Form); Magic: Plant Spells, p. 17"}
                 {:name "Fungus Form Other" :prerequisites "Magery 2 and Fungus Form" :prerequisite_count 7 :college "Plant" :ref "Magic p. 165 (Plant Form Other); Magic: Plant Spells, p. 17"}
                 {:name "Fungus Growth" :prerequisites "Heal Fungus" :prerequisite_count 3 :college "Plant" :ref "Magic p. 162 (Plant Growth); Magic: Plant Spells, p. 17"}
                 {:name "Fungus Speech" :prerequisites "Magery 1, Identify Fungus" :prerequisite_count 6 :college "Plant" :ref "Magic p. 164 (Plant Speech); Magic: Plant Spells, p. 17"}
                 {:name "Heal Fungus" :prerequisites "Identify Fungus" :prerequisite_count 2 :college "Plant" :ref "Magic p. 161 (Heal Plant); Magic: Plant Spells, p. 17"}
                 {:name "Identify Fungus" :prerequisites "Seek Fungus" :prerequisite_count 1 :college "Plant" :ref "Magic p. 161 (Identify Plant); Magic: Plant Spells, p. 17"}
                 {:name "Instant Neutralize Poison" :prerequisites "Neutralize Poison" :prerequisite_count 2 :college "Plant" :ref "Magic p. 92; Magic: Plant Spells, p. 17"}
                 {:name "Itch" :prerequisites "Fungus Growth" :prerequisite_count 0 :college "Plant" :ref "Magic p. 35; Magic: Plant Spells, p. 17"}
                 {:name "Mature" :prerequisites "Decay" :prerequisite_count 2 :college "Plant" :ref "Magic p. 78; Magic: Plant Spells, p. 17"}
                 {:name "Neutralize Poison" :prerequisites "Magery 3 and Identify Fungus" :prerequisite_count 1 :college "Plant" :ref "Magic p. 92; Magic: Plant Spells, p. 17"}
                 {:name "Pestilence" :prerequisites "Magery 1 and Sickness" :prerequisite_count 7 :college "Plant" :ref "Magic p. 154; Magic: Plant Spells, p. 17"}
                 {:name "Poison Food" :prerequisites "Decay" :prerequisite_count 3 :college "Plant" :ref "Magic p. 78; Magic: Plant Spells, p. 17"}
                 {:name "Rotting Death" :prerequisites "Magery 2 and Pestilence" :prerequisite_count 9 :college "Plant" :ref "Magic p. 154; Magic: Plant Spells, p. 17"}
                 {:name "Ruin" :prerequisites "Magery 1 and Decay" :prerequisite_count 8 :college "Plant" :ref "Magic p. 118; Magic: Plant Spells, p. 17"}
                 {:name "Seek Fungus" :prerequisites "None" :prerequisite_count 0 :college "Plant" :ref "Magic p. 161 (Seek Plant); Magic: Plant Spells, p. 17"}
                 {:name "Shape Fungus" :prerequisites "Identify Fungus" :prerequisite_count 2 :college "Plant" :ref "Magic p. 161 (Shape Plant); Magic: Plant Spells, p. 17"}
                 {:name "Sickness" :prerequisites "Itch" :prerequisite_count 1 :college "Plant" :ref "Magic p. 138; Magic: Plant Spells, p. 17"}
                 {:name "Spore Cloud" :prerequisites "Fungus Growth" :prerequisite_count 3 :college "Plant" :ref "Magic p. 162 (Pollen Cloud); Magic: Plant Spells, p. 17"}
                 {:name "Wither Plant" :prerequisites "Blight" :prerequisite_count 5 :college "Plant" :ref "Magic p. 163; Magic: Plant Spells, p. 17"}
                 {:name "Armor" :prerequisites "Magery 2 and Shield" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Basic Set, p. 253; Magic p. 167"}
                 {:name "Atmosphere Dome" :prerequisites "Purify Air and Weather Dome" :prerequisite_count 9 :college "Protection_and_Warning" :ref "Magic p. 169"}
                 {:name "Bender Defender (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 10"}
                 {:name "Black Sphere" :prerequisites "Magery 3 and Utter Dome" :prerequisite_count 15 :college "Protection_and_Warning" :ref "Magic: Death Spells p. 20"}
                 {:name "Bladeturning" :prerequisites "Shield or Turn Blade" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 168"}
                 {:name "Blind Sensor" :prerequisites "Glitch, Seek Emitter" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Classic: Technomancer p. 27"}
                 {:name "Block" :prerequisites "Magery 1" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic p. 166"}
                 {:name "Book Binding" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Pyramid 3/48: Secret Magic p. 20"}
                 {:name "Catch Missile" :prerequisites "Deflect Missile" :prerequisite_count 2 :college "Protection_and_Warning" :ref "Magic p. 168"}
                 {:name "Coolness" :prerequisites "Cold" :prerequisite_count 5 :college "Protection_and_Warning" :ref "Magic p. 187"}
                 {:name "Deflect Missile" :prerequisites "Apportation" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Basic Set, p. 251; Magic p. 143; Grimoire p 91"}
                 {:name "Detect Poison" :prerequisites "Sense Danger or Test Food" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 166"}
                 {:name "Diminishing Dome" :prerequisites "Magery 4 and Force Dome" :prerequisite_count 11 :college "Protection_and_Warning" :ref "Magic: Artillery Spells p. 24"}
                 {:name "Force Ball" :prerequisites "Magery 4, Catch Spell, Force Dome, and Sense Foes" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: Artillery Spells p. 24-25"}
                 {:name "Force Dome" :prerequisites "Magery 1, Weather Dome, and Apportation" :prerequisite_count 10 :college "Protection_and_Warning" :ref "Magic p. 170"}
                 {:name "Force Wall" :prerequisites "Force Dome" :prerequisite_count 11 :college "Protection_and_Warning" :ref "Magic p. 170"}
                 {:name "Force Guillotine" :prerequisites "Magery 3 and Force Wall" :prerequisite_count 12 :college "Protection_and_Warning" :ref "Magic: Death Spells p. 20"}
                 {:name "Freedom" :prerequisites "3 Body Control spells, 3 Movement spells, and 3 Protection and Warning spells" :prerequisite_count 9 :college "Protection_and_Warning" :ref "Magic p. 148"}
                 {:name "Goggles (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Great Deflect Missile" :prerequisites "Magery 2, Secret Spell (Great Deflect Missile), and Deflect Missile" :prerequisite_count 2 :college "Protection_and_Warning" :ref "Pyramid 3/4: Magic on the Battlefield p. 9"}
                 {:name "Hardiness" :prerequisites "Block" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 167"}
                 {:name "Iron Arm" :prerequisites "Resist Pain and DX 11+" :prerequisite_count 4 :college "Protection_and_Warning" :ref "Magic p. 169"}
                 {:name "Magelock" :prerequisites "Magery 1" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Basic Set, p. 253; Magic p. 166"}
                 {:name "Mass Coolness" :prerequisites "IQ 12+ and Coolness and Secret Spell (Mass Coolness)" :prerequisite_count 6 :college "Protection_and_Warning" :ref "Pyramid 3/76: Dungeon Fantasy IV p. 14"}
                 {:name "Mass Resist Acid" :prerequisites "IQ 13+, Secret Spell (Mass Resist Acid), and Resist Acid" :prerequisite_count 9 :college "Protection_and_Warning" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
                 {:name "Mass Resist Disease" :prerequisites "IQ 13+, Secret Spell (Mass Resist Disease), and Resist Disease" :prerequisite_count 4 :college "Protection_and_Warning" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
                 {:name "Mass Resist Lightning" :prerequisites "IQ 13+, Secret Spell (Mass Resist Lightning), and Resist Lightning" :prerequisite_count 9 :college "Protection_and_Warning" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
                 {:name "Mass Resist Poison" :prerequisites "IQ 13+, Secret Spell (Mass Resist Poison), and Resist Poison" :prerequisite_count 4 :college "Protection_and_Warning" :ref "Pyramid 3/4: Magic on the Battlefield p. 9 and Magical Styles: Dungeon Magic p. 13)"}
                 {:name "Mass Shade" :prerequisites "IQ 12+ and Shade and Secret Spell (Mass Shade)" :prerequisite_count 2 :college "Protection_and_Warning" :ref "Pyramid 3/76: Dungeon Fantasy IV p. 14"}
                 {:name "Missile Shield" :prerequisites "Magery 1/2, Apportation or Shield" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 168; Thaumatology: Urban Magics, p. 33"}
                 {:name "Mystic Mist" :prerequisites "Magery 1 and either Watchdog or Shield" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 168"}
                 {:name "Nightingale" :prerequisites "Sense Danger" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 167"}
                 {:name "Oven Mitts (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Prismatic Mist Area" :prerequisites "Mystic Mist, Sand Jet" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Classic: Technomancer p. 27"}
                 {:name "Protect Animal" :prerequisites "Armor, Watchdog, and Animal spells" :prerequisite_count 7 :college "Protection_and_Warning" :ref "Magic, p. 32"}
                 {:name "Reflect Gaze" :prerequisites "Mirror" :prerequisite_count 3 :college "Protection_and_Warning" :ref "Magic p. 168"}
                 {:name "Resist Acid" :prerequisites "Create Acid" :prerequisite_count 8 :college "Protection_and_Warning" :ref "Magic p. 190"}
                 {:name "Resist Disease" :prerequisites "Remove Contagion or Vigor" :prerequisite_count 3 :college "Protection_and_Warning" :ref "Magic p. 90"}
                 {:name "Resist Lightning" :prerequisites "6 Air Spells" :prerequisite_count 8 :college "Protection_and_Warning" :ref "Magic p. 196"}
                 {:name "Resist Poison" :prerequisites "Vigor" :prerequisite_count 3 :college "Protection_and_Warning" :ref "Magic p. 91"}
                 {:name "Resist Pressure" :prerequisites "Weather Dome" :prerequisite_count 9 :college "Protection_and_Warning" :ref "Magic p. 169"}
                 {:name "Resist Radiation" :prerequisites "3 Radiaition spells" :prerequisite_count 7 :college "Protection_and_Warning" :ref "Magic p. 182"}
                 {:name "Resist Sound" :prerequisites "4 Sound spells" :prerequisite_count 4 :college "Protection_and_Warning" :ref "Magic p. 173"}
                 {:name "Resist Water" :prerequisites "Umbrella, or Shape Water and Destroy Water" :prerequisite_count 2 :college "Protection_and_Warning" :ref "Magic p. 186"}
                 {:name "Return Missile" :prerequisites "Catch Missile" :prerequisite_count 3 :college "Protection_and_Warning" :ref "Magic p. 168"}
                 {:name "Reverse Missiles" :prerequisites "Missile Shield or Force Dome" :prerequisite_count 2 :college "Protection_and_Warning" :ref "Magic p. 168; Pyramid 3/60: Dungeon Fantasy III p. 5"}
                 {:name "Selective Hearing (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Sense Danger" :prerequisites "Sense Foes or Danger Sense" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic p. 166"}
                 {:name "Sense Observation" :prerequisites "Sense Danger or Scryguard" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 167"}
                 {:name "Shade" :prerequisites "Continual Light or Shield" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 169"}
                 {:name "Shield" :prerequisites "Magery 2" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Basic Set, p. 252; Magic p. 167"}
                 {:name "Spoof Sensor" :prerequisites "Blind Sensor" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Classic: Technomancer p. 27"}
                 {:name "Stinkguard (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Storm Shelter (A)" :prerequisites "None" :prerequisite_count 0 :college "Protection_and_Warning" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Teleport Shield" :prerequisites "Watchdog and either Spell Shield or Teleport" :prerequisite_count 7 :college "Protection_and_Warning" :ref "Magic p. 170"}
                 {:name "Turn Blade" :prerequisites "Apportation or Spasm" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 167"}
                 {:name "Umbrella" :prerequisites "Shape Water or Shield" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 185"}
                 {:name "Utter Dome" :prerequisites "Magery 2, Force Dome, and Spell Shield" :prerequisite_count 14 :college "Protection_and_Warning" :ref "Magic p. 170"}
                 {:name "Utter Wall" :prerequisites "Utter Dome and Spell Wall" :prerequisite_count 16 :college "Protection_and_Warning" :ref "Magic p. 170"}
                 {:name "Warmth" :prerequisites "Heat" :prerequisite_count 4 :college "Protection_and_Warning" :ref "Magic p. 74"}
                 {:name "Watchdog" :prerequisites "Sense Danger" :prerequisite_count 1 :college "Protection_and_Warning" :ref "Magic p. 167; Thaumatology: Urban Magics, p. 33"}
                 {:name "Weather Dome" :prerequisites "2 spells from each of 4 elements" :prerequisite_count 8 :college "Protection_and_Warning" :ref "Magic p. 169"}
                 {:name "Alter Voice" :prerequisites "4 Body Control spells and 4 Sound spells" :prerequisite_count 8 :college "Sound" :ref "Magic p. 41"}
                 {:name "Call (A)" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic: The Least of Spells p. 6"}
                 {:name "Concussion" :prerequisites "Shape Air and Thunderclap" :prerequisite_count 5 :college "Sound" :ref "Magic p. 26"}
                 {:name "Converse" :prerequisites "Magery 1, Garble, and Silence" :prerequisite_count 4 :college "Sound" :ref "Magic p. 173"}
                 {:name "Delayed Message" :prerequisites "Magery 1, Voices, and Sense Life" :prerequisite_count 3 :college "Sound" :ref "Magic p. 173"}
                 {:name "Disrupt" :prerequisites "Magery 2, Concussion, Sound Jet, and Secret Spell (Disrupt)." :prerequisite_count 0 :college "Sound" :ref "Magic Styles: Dungeon Magic p. 23"}
                 {:name "Echoes of the Past" :prerequisites "Magery 2, History, and Voices" :prerequisite_count 7 :college "Sound" :ref "Magic p. 107"}
                 {:name "Far-Hearing" :prerequisites "Magery 1 and 4 Sound spells; may not have Deafness or Hard of Hearing" :prerequisite_count 4 :college "Sound" :ref "Magic p. 173"}
                 {:name "Garble" :prerequisites "Voices" :prerequisite_count 2 :college "Sound" :ref "Magic p. 172"}
                 {:name "Great Voice" :prerequisites "Voices and Thunderclap" :prerequisite_count 3 :college "Sound" :ref "Magic p. 173"}
                 {:name "Hush" :prerequisites "Silence" :prerequisite_count 2 :college "Sound" :ref "Magic p. 172"}
                 {:name "Imitate Voice" :prerequisites "Voices" :prerequisite_count 2 :college "Sound" :ref "Magic p. 172"}
                 {:name "Improved Concussion;" :prerequisites "Magery 4 and at least seven Sound spells including Concussion and Great Voice" :prerequisite_count 7 :college "Sound" :ref "Magic: Artillery Spells p. 25"}
                 {:name "Invisible Wizard Ear" :prerequisites "Wizard Ear and Invisibility" :prerequisite_count 10 :college "Sound" :ref "Magic p. 174"}
                 {:name "Ley Speech" :prerequisites "Seek Ley Line and Voices" :prerequisite_count 0 :college "Sound" :ref "Thaumatology: Urban Magics p. 19"}
                 {:name "Fatal Frequency" :prerequisites "Magery 3, Concussion, and Sound Jet" :prerequisite_count 0 :college "Sound" :ref "Magic: Death Spells p. 20"}
                 {:name "Keen (Sense) Hearing" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic p. 133"}
                 {:name "Mage-Stealth" :prerequisites "Hush" :prerequisite_count 3 :college "Sound" :ref "Magic p. 172"}
                 {:name "Mer-Speech (A)" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Message" :prerequisites "Great Voice and Seeker" :prerequisite_count 7 :college "Sound" :ref "Magic p. 173"}
                 {:name "Musical Scribe" :prerequisites "Scribe" :prerequisite_count 5 :college "Sound" :ref "Magic p. 174"}
                 {:name "Noise" :prerequisites "Wall of Silence" :prerequisite_count 3 :college "Sound" :ref "Magic p. 173"}
                 {:name "Perilous Pulsations" :prerequisites "Magery 4 and at least seven Sound spells, including Concussion and Sound Jet" :prerequisite_count 7 :college "Sound" :ref "Magic: Artillery Spells p. 24"}
                 {:name "Resist Sound" :prerequisites "4 Sound spells" :prerequisite_count 0 :college "Sound" :ref "Magic p. 173"}
                 {:name "Scribe" :prerequisites "Voices, Dancing Object, and 1 written Language at Accented or better" :prerequisite_count 4 :college "Sound" :ref "Magic p. 174"}
                 {:name "Selective Hearing (A)" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Silence" :prerequisites "Sound" :prerequisite_count 1 :college "Sound" :ref "Magic p. 171; Fantasy p. 172"}
                 {:name "Silver Tongue" :prerequisites "Voices and Emotion Control" :prerequisite_count 6 :college "Sound" :ref "Magic p. 174"}
                 {:name "Sound" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic p. 171; Fantasy p. 172"}
                 {:name "Sound Jet" :prerequisites "Great Voice" :prerequisite_count 4 :college "Sound" :ref "Magic p. 173"}
                 {:name "Sound Vision" :prerequisites "Keen Hearing or Acute Hearing" :prerequisite_count 0 :college "Sound" :ref "Magic p. 171"}
                 {:name "Squeak (A)" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Throw Voice (A)" :prerequisites "None" :prerequisite_count 0 :college "Sound" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Thunderclap" :prerequisites "Sound" :prerequisite_count 1 :college "Sound" :ref "Magic p. 171"}
                 {:name "Voices" :prerequisites "Sound" :prerequisite_count 1 :college "Sound" :ref "Magic p. 172"}
                 {:name "Volume Control/TL" :prerequisites "Great Voice" :prerequisite_count 0 :college "Sound" :ref "Classic: Technomancer p. 28"}
                 {:name "Wail of the Banshee" :prerequisites "Magery 3 and any 10 Sound spells, including Message" :prerequisite_count 10 :college "Sound" :ref "Magic: Death Spells p. 20"}
                 {:name "Wall of Silence" :prerequisites "Silence" :prerequisite_count 2 :college "Sound" :ref "Magic p. 172"}
                 {:name "Withering Wail" :prerequisites "Magery 4 and at least 10 Sound spells, including Great Voice and Noise" :prerequisite_count 10 :college "Sound" :ref "Magic: Artillery Spells p. 25"}
                 {:name "Wizard Ear" :prerequisites "Apportation, Far-Hearing, and Sound Vision" :prerequisite_count 6 :college "Sound" :ref "Magic p. 174"}
                 {:name "Wizard Mouth" :prerequisites "Apportation, Far-Tasting, and Great Voice" :prerequisite_count 7 :college "Sound" :ref "Magic p. 104"}
                 {:name "Animate Machine/TL" :prerequisites "Machine Control and either Animation or Animate Object" :prerequisite_count 15 :college "Technological" :ref "Magic p. 177"}
                 {:name "Awaken Building/TL" :prerequisites "Animation; to cast, also 5 spells from a college appropriate to its main material" :prerequisite_count 8 :college "Technological" :ref "Thaumatology: Urban Magics, p. 33"}
                 {:name "Awaken Computer/TL" :prerequisites "Animation and Wisdom" :prerequisite_count 10 :college "Technological" :ref "Magic p. 178"}
                 {:name "Blind Sensor" :prerequisites "Glitch, Seek Emitter" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 27"}
                 {:name "Confound Firearm/TL" :prerequisites "Glitch" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 34"}
                 {:name "Create Mana Co-Processor" :prerequisites "Awaken Computer/TL and Enchant" :prerequisite_count 0 :college "Technological" :ref "Classic: Magic Items 3 p 30"}
                 {:name "Delete Commercials/TL" :prerequisites "TL 7+" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p 18"}
                 {:name "Essential Paper" :prerequisites "None" :prerequisite_count 0 :college "Technological" :ref "Pyramid 3/48: Secret Magic, p. 21"}
                 {:name "Glitch/TL" :prerequisites "Machine Control" :prerequisite_count 12 :college "Technological" :ref "Magic p. 178"}
                 {:name "Guide Missile/TL" :prerequisites "Machine Control and any 'Seek' spell" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 34"}
                 {:name "Ley Vehicle" :prerequisites "Ley Float and Ley Running" :prerequisite_count 0 :college "Technological" :ref "Thaumatology: Urban Magics, p. 19"}
                 {:name "Machine Control/TL" :prerequisites "Reveal Function, Locksmith, and Lightning" :prerequisite_count 11 :college "Technological" :ref "Magic p. 176"}
                 {:name "Machine Possession/TL" :prerequisites "Machine Control and either Rider Within or Soul Rider" :prerequisite_count 16 :college "Technological" :ref "Magic p. 178"}
                 {:name "Machine Speech/TL" :prerequisites "Machine Summoning" :prerequisite_count 13 :college "Technological" :ref "Magic p. 176"}
                 {:name "Machine Summoning/TL" :prerequisites "Machine Control" :prerequisite_count 12 :college "Technological" :ref "Magic, p. 176"}
                 {:name "Mad Machine/TL" :prerequisites "Machine Control, and either Animation or Summon Demon" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 35"}
                 {:name "Malfunction/TL" :prerequisites "Magery 2 and Glitch" :prerequisite_count 13 :college "Technological" :ref "Magic p. 177"}
                 {:name "Magnetic Finger (A)" :prerequisites "None" :prerequisite_count 0 :college "Technological" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Manipulate DNA " :prerequisites "Sequence DNA and Apportation, or Create Chimera" :prerequisite_count 4 :college "Technological" :ref "Bio-Tech, p. 32"}
                 {:name "Permanent Machine Possession" :prerequisites "Magery 3 and Machine Possession" :prerequisite_count 17 :college "Technological" :ref "Magic p. 178"}
                 {:name "Program/TL" :prerequisites "Machine Speech — 17+, or  Machine Control and Scribe at 17+." :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 33"}
                 {:name "Purify Signal/TL" :prerequisites "Purify Air, TL6+" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 17"}
                 {:name "Rebuild/TL" :prerequisites "Magery 3, Repair, Create Object, and 3 spells of each element" :prerequisite_count 22 :college "Technological" :ref "Magic p. 177"}
                 {:name "Reckless Reconstitution" :prerequisites "Rebuild" :prerequisite_count 23 :college "Technological" :ref "Magic: Death Spells, p. 21"}
                 {:name "Remote Start/TL (A)" :prerequisites "None" :prerequisite_count 0 :college "Technological" :ref "Magic: The Least of Spells p. 16"}
                 {:name "Reveal Function/TL" :prerequisites "Seek Machine" :prerequisite_count 1 :college "Technological" :ref "Magic p. 176"}
                 {:name "Schematic/TL" :prerequisites "Reveal Function and History" :prerequisite_count 7 :college "Technological" :ref "Magic p. 177"}
                 {:name "Seek Machine/TL" :prerequisites "None" :prerequisite_count 0 :college "Technological" :ref "Magic p. 175"}
                 {:name "Sense Nano" :prerequisites "Sense Disease and IQ 15+, or Seek Machine and Small Vision" :prerequisite_count 2 :college "Technological" :ref "Bio-Tech, p. 32"}
                 {:name "Sequence DNA" :prerequisites "Magery 2 and either Divination (Genomancy) or Analyze Heredity" :prerequisite_count 2 :college "Technological" :ref "Bio-Tech, p. 32"}
                 {:name "Spoof Sensor" :prerequisites "Blind Sensor" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 27"}
                 {:name "Televisomancy" :prerequisites "Magery, and either six other Technological spells or Electronics Operation (Communications) 15+" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p 23"}
                 {:name "Upgrade Computer/TL" :prerequisites "Inscribe, Repair and either Schematic or Electronics (Computers) — 15+" :prerequisite_count 0 :college "Technological" :ref "Classic: Technomancer p. 35"}
                 {:name "Wizardly Workshop/TL (A)" :prerequisites "None" :prerequisite_count 0 :college "Technological" :ref "Magic: The Least of Spells p. 12"}
                 {:name "Acid Ball" :prerequisites "Magery 2 and Create Acid" :prerequisite_count 8 :college "Water" :ref "Magic p. 191"}
                 {:name "Acid Jet" :prerequisites "Magery 2, Water Jet, and Create Acid" :prerequisite_count 10 :college "Water" :ref "Magic p. 192"}
                 {:name "Arctic Blast" :prerequisites "Magery 4, Frostbite, and Icy Breath" :prerequisite_count 0 :college "Water" :ref "Magic: Artillery Spells p. 27"}
                 {:name "Alkahest Jet" :prerequisites "Magery 4, Essential Acid, and Acid Jet" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Alkahest Sphere" :prerequisites "Magery 4, Essential Acid, and Acid Ball" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Boil Water" :prerequisites "Shape Water and Heat" :prerequisite_count 8 :college "Water" :ref "Magic p. 192"}
                 {:name "Breathe Air" :prerequisites "Create Water and Destroy Air" :prerequisite_count 6 :college "Water" :ref "Magic p. 26"}
                 {:name "Breathe Steam" :prerequisites "Magery 1, Steam Jet, and Resist Fire" :prerequisite_count 14 :college "Water" :ref "Magic p. 192"}
                 {:name "Breathe Water" :prerequisites "Create Air and Destroy Water" :prerequisite_count 6 :college "Water" :ref "Basic Set, p. 243; Magic p. 189"}
                 {:name "Body of Ice" :prerequisites "Magery 2, Body of Water, and Freeze" :prerequisite_count 6 :college "Water" :ref "Magic p. 189"}
                 {:name "Body of Water" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 185"}
                 {:name "Boil Water" :prerequisites "Shape Water and Heat" :prerequisite_count 8 :college "Water" :ref "Magic p. 189"}
                 {:name "Cloud (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Condense Steam" :prerequisites "Cold or Boil Water" :prerequisite_count 5 :college "Water" :ref "Magic p. 189"}
                 {:name "Cone of Corrosion" :prerequisites "Magery 4 and Acid Jet" :prerequisite_count 11 :college "Water" :ref "Magic: Artillery Spells p. 27"}
                 {:name "Control Water Elemental" :prerequisites "Summon Water Elemental" :prerequisite_count 9 :college "Water" :ref "Magic p. 28"}
                 {:name "Coolness" :prerequisites "Cold" :prerequisite_count 5 :college "Water" :ref "Magic p. 187"}
                 {:name "Create Acid" :prerequisites "Create Water and Create Earth" :prerequisite_count 7 :college "Water" :ref "Magic p. 190; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Ice" :prerequisites "Freeze" :prerequisite_count 5 :college "Water" :ref "Magic p. 188; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Spring" :prerequisites "Dry Spring and Shape Water" :prerequisite_count 8 :college "Water" :ref "Magic p. 190"}
                 {:name "Create Steam (Create Well)" :prerequisites "Boil Water" :prerequisite_count 9 :college "Water" :ref "Magic p. 190"}
                 {:name "Create Water" :prerequisites "Purify Water" :prerequisite_count 0 :college "Water" :ref "Basic Set, p. 253; Magic p. 184; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Create Water Elemental" :prerequisites "Magery 2 and Control Water Elemental" :prerequisite_count 0 :college "Water" :ref "Magic p. 22"}
                 {:name "Current" :prerequisites "6 Water spells" :prerequisite_count 6 :college "Water" :ref "Magic p. 194"}
                 {:name "Dehydrate" :prerequisites "5 Water spells, including Destroy Water" :prerequisite_count 5 :college "Water" :ref "Magic p. 188"}
                 {:name "Destroy Water" :prerequisites "Create Water" :prerequisite_count 3 :college "Water" :ref "Basic Set, p. 253; Magic p. 185"}
                 {:name "Dissipate" :prerequisites "Magery 3, plus either Body of Water and Earth to Water, or Flesh to Ice and Melt Ice. Alternatively, Magery 3, Body of Fluid, Earth to Fluid, and Secret Spell (Dissipate." :prerequisite_count 0 :college "Water" :ref "Magic: Death Spells, p. 21 and Magical Styles: Dungeon Magic, p.8"}
                 {:name "Distill" :prerequisites "Mature and Destroy Water" :prerequisite_count 7 :college "Water" :ref "[1]"}
                 {:name "Drown" :prerequisites "Magery 3, Breathe Air, and Breathe Water" :prerequisite_count 0 :college "Water" :ref "Magic: Death Spells, p. 21"}
                 {:name "Dry Spring" :prerequisites "Destroy Water and Shape Earth" :prerequisite_count 6 :college "Water" :ref "Magic p. 188"}
                 {:name "Earth to Water" :prerequisites "Magery 1, Create Water, and Shape Earth" :prerequisite_count 5 :college "Water" :ref "Magic p. 52"}
                 {:name "Elemental Plumbing" :prerequisites "Control Water Elemental" :prerequisite_count 0 :college "Water" :ref "Classic: Technomancer p. 38"}
                 {:name "Essential Acid" :prerequisites "Magery 3 and all 6 Acid spells" :prerequisite_count 13 :college "Water" :ref "Magic p. 192; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Essential Water" :prerequisites "6 Water spells" :prerequisite_count 6 :college "Water" :ref "Magic p. 189; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Flow" :prerequisites "Body of Fluid and Secret Spell (Flow)" :prerequisite_count 0 :college "Water" :ref "Magical Styles: Dungeon Magic, p.9"}
                 {:name "Flesh to Ice" :prerequisites "Magery 1, Frostbite, and Body of Water" :prerequisite_count 8 :college "Water" :ref "Magic p. 190"}
                 {:name "Fog" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Basic Set, p. 253; Magic p. 193"}
                 {:name "Foul Water" :prerequisites "Purify Water and Decay" :prerequisite_count 4 :college "Water" :ref "Magic p. 185"}
                 {:name "Freeze" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 185"}
                 {:name "Frost" :prerequisites "Create Water or Cold" :prerequisite_count 3 :college "Water" :ref "Magic p. 193"}
                 {:name "Frostbite" :prerequisites "Frost and Freeze" :prerequisite_count 6 :college "Water" :ref "Magic p. 189"}
                 {:name "Geyser" :prerequisites "6 Water spells including Create Spring, and either 4 Earth spells or 4 Fire spells" :prerequisite_count 9 :college "Water" :ref "Magic p. 190"}
                 {:name "Hail" :prerequisites "Snow" :prerequisite_count 8 :college "Water" :ref "Magic p. 195"}
                 {:name "Ice Dagger" :prerequisites "Ice Sphere or Water Jet" :prerequisite_count 5 :college "Water" :ref "Magic p. 188"}
                 {:name "Ice Slick" :prerequisites "Frost" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Ice Sphere" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Ice Vision" :prerequisites "Shape Water" :prerequisite_count 0 :college "Water" :ref "Classic: Magic p. 37"}
                 {:name "Icy Breath" :prerequisites "Magery 1, Snow Jet, and Resist Cold" :prerequisite_count 12 :college "Water" :ref "Magic p. 192"}
                 {:name "Ice Storm" :prerequisites "Magery 4, Hail, and Storm" :prerequisite_count 0 :college "Water" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Icy Missile" :prerequisites "Icy Weapon" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Icy Touch" :prerequisites "Magery 1 and 5 Water spells" :prerequisite_count 4 :college "Water" :ref "Magic p. 188"}
                 {:name "Icy Weapon" :prerequisites "Create Water" :prerequisite_count 3 :college "Water" :ref "Basic Set, p. 253; Magic p. 185"}
                 {:name "Infiltrate" :prerequisites "Body of Fluid and Secret Spell (Infiltrate." :prerequisite_count 0 :college "Water" :ref "Magical Styles: Dungeon Magic, p. 9"}
                 {:name "Mass Coolness" :prerequisites "IQ 12+ and Coolness and Secret Spell (Mass Coolness" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/76: Dungeon Fantasy IV, p. 14"}
                 {:name "Mass Resist Acid" :prerequisites "IQ 13+, Secret Spell (Mass Resist Acid, and Resist Acid" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13"}
                 {:name "Melt Ice" :prerequisites "Heat or Freeze" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Mer-Speech (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Mud Jet" :prerequisites "Water Jet and Create Earth, or Create Water and Sand Jet" :prerequisite_count 8 :college "Water" :ref "Magic p. 52"}
                 {:name "Purify Water" :prerequisites "Seek Water" :prerequisite_count 1 :college "Water" :ref "Basic Set, p. 253; Magic p. 184"}
                 {:name "Rain" :prerequisites "Clouds" :prerequisite_count 5 :college "Water" :ref "Magic p. 195"}
                 {:name "Rain of Acid" :prerequisites "Magery 2, Create Water, and Create Earth" :prerequisite_count 7 :college "Water" :ref "Magic p. 191"}
                 {:name "Rain of Alkahest" :prerequisites "Magery 4, Essential Acid, and Rain of Acid" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 19"}
                 {:name "Rain of Ice Daggers" :prerequisites "Magery 2, Hail, and Ice Dagger" :prerequisite_count 12 :college "Water" :ref "Magic p. 192"}
                 {:name "Resist Acid" :prerequisites "Create Acid" :prerequisite_count 8 :college "Water" :ref "Magic p. 190"}
                 {:name "Resist Water" :prerequisites "Umbrella, or Shape Water and Destroy Water" :prerequisite_count 2 :college "Water" :ref "Magic p. 186"}
                 {:name "Scald" :prerequisites "Magery 4, Create Steam, and Steam Jet" :prerequisite_count 0 :college "Water" :ref "Magic: Artillery Spells p. 27"}
                 {:name "Sea Legs (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Seek Coastline" :prerequisites "Seek Water" :prerequisite_count 1 :college "Water" :ref "Magic p. 184"}
                 {:name "Seek Water" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Basic Set, p. 253; Magic p. 184"}
                 {:name "Shape Water" :prerequisites "Create Water" :prerequisite_count 3 :college "Water" :ref "Basic Set, p. 253; Magic p. 185"}
                 {:name "Sink (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 14"}
                 {:name "Snow" :prerequisites "Clouds and Frost" :prerequisite_count 7 :college "Water" :ref "Magic p. 193"}
                 {:name "Snow Jet" :prerequisites "Water Jet and Freeze" :prerequisite_count 6 :college "Water" :ref "Magic p. 189"}
                 {:name "Snow Shoes" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Spit Acid" :prerequisites "Magery 3, Acid Jet, and Resist Acid" :prerequisite_count 12 :college "Water" :ref "Magic p. 192"}
                 {:name "Spit Alkahest" :prerequisites "Magery 4, Essential Flame, and Spit Acid" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 19"}
                 {:name "Sponge (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Squirt (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Steam Jet" :prerequisites "Water Jet and Boil Water" :prerequisite_count 10 :college "Water" :ref "Magic p. 191"}
                 {:name "Storm" :prerequisites "Rain and Hail" :prerequisite_count 10 :college "Water" :ref "Magic p. 195"}
                 {:name "Stygian Cold" :prerequisites "Magery 4, Essential Water, and Frostbite" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Stygian Ice Dagger" :prerequisites "Magery 4, Essential Water, and Ice Dagger" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Stygian Ice Sphere" :prerequisites "Magery 4, Essential Water, and Ice Sphere" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Stygian Touch" :prerequisites "Magery 4, Essential Water, and Icy Touch" :prerequisite_count 0 :college "Water" :ref "Pyramid 3/25: Epic Magic, p. 18"}
                 {:name "Summon Water Elemental" :prerequisites "Magery 1 and either 8 Water spells or 4 Water spells and another Summon Elemental spell" :prerequisite_count 8 :college "Water" :ref "Magic p. 27"}
                 {:name "Sweat (A)" :prerequisites "None" :prerequisite_count 0 :college "Water" :ref ""}
                 {:name "Swim" :prerequisites "Shape Water and Levitation" :prerequisite_count 6 :college "Water" :ref "Magic p. 147"}
                 {:name "Tide" :prerequisites "8 Water spells" :prerequisite_count 8 :college "Water" :ref "Magic p. 194"}
                 {:name "Transfer Water" :prerequisites "Magery 1 and Shape Water" :prerequisite_count 0 :college "Water" :ref "Thaumatology: Urban Magics, p. 34"}
                 {:name "Umbrella" :prerequisites "Shape Water or Shield" :prerequisite_count 1 :college "Water" :ref "Magic p. 185"}
                 {:name "Walk on Water" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 186"}
                 {:name "Walk through Water" :prerequisites "Magery 1 and Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 188"}
                 {:name "Water Jet" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 187"}
                 {:name "Water Vision" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 187"}
                 {:name "Waves" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 194"}
                 {:name "Whirlpool" :prerequisites "Shape Water" :prerequisite_count 4 :college "Water" :ref "Magic p. 187"}
                 {:name "Wilting" :prerequisites "Magery 4 and at least 10 Water spells, including Dehydrate" :prerequisite_count 10 :college "Water" :ref "Magic: Artillery Spells p. 28"}
                 {:name "Ball of Lightning" :prerequisites "Apportation and Lightning" :prerequisite_count 8 :college "Weather" :ref "Magic p. 197"}
                 {:name "Body of Lightning" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 198"}
                 {:name "Chain Lightning" :prerequisites "Magery 4, Ball of Lightning, and Resist Lightning" :prerequisite_count 0 :college "Weather" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Cloud (A)" :prerequisites "None" :prerequisite_count 0 :college "Weather" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Cloud-Vaulting" :prerequisites "Magery 2, Jump, and Walk on Air" :prerequisite_count 12 :college "Weather" :ref "Magic p. 148"}
                 {:name "Cloud-Walking" :prerequisites "Walk on Air and Walk on Water" :prerequisite_count 9 :college "Weather" :ref "Magic p. 148"}
                 {:name "Clouds" :prerequisites "2 Water spells and 2 Air spells" :prerequisite_count 4 :college "Weather" :ref "Magic p. 194"}
                 {:name "Cool" :prerequisites "Cold and 4 Air spells" :prerequisite_count 9 :college "Weather" :ref "Magic p. 195"}
                 {:name "Current" :prerequisites "6 Water spells" :prerequisite_count 6 :college "Weather" :ref "Magic p. 194"}
                 {:name "Explosive Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 196"}
                 {:name "Fog" :prerequisites "Shape Water" :prerequisite_count 4 :college "Weather" :ref "Magic p. 193"}
                 {:name "Frost" :prerequisites "Create Water or Cold" :prerequisite_count 3 :college "Weather" :ref "Magic p. 193"}
                 {:name "Hail" :prerequisites "Snow" :prerequisite_count 8 :college "Weather" :ref "Magic p. 195"}
                 {:name "Grave Grounding" :prerequisites "Magery 3, Body of Lightning, and Resist Lightning" :prerequisite_count 0 :college "Weather" :ref "Magic: Death Spells, p. 22"}
                 {:name "Jolt (A)" :prerequisites "None" :prerequisite_count 0 :college "Weather" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Ice Storm" :prerequisites "Magery 4, Hail, and Storm" :prerequisite_count 0 :college "Weather" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Improved Explosive Lightning" :prerequisites "Magery 4 and at least 10 Air spells or 10 Weather spells, including Explosive Lightning" :prerequisite_count 10 :college "Weather" :ref "Magic: Artillery Spells p. 29"}
                 {:name "Lethal Lightning" :prerequisites "Magery 3, Annihilation, and Explode" :prerequisite_count 0 :college "Weather" :ref "Magic: Death Spells, p. 22"}
                 {:name "Lightning" :prerequisites "Magery 1 and 6 other Air spells" :prerequisite_count 6 :college "Weather" :ref "Basic Set, p. 244; Magic p. 196"}
                 {:name "Lightning Armor" :prerequisites "6 Lightning spells including Resist Lightning" :prerequisite_count 12 :college "Weather" :ref "Magic p. 198"}
                 {:name "Lightning Missiles" :prerequisites "Lightning Weapon" :prerequisite_count 8 :college "Weather" :ref "Magic p. 198"}
                 {:name "Lightning Stare" :prerequisites "Lightning, Resist Lightning" :prerequisite_count 8 :college "Weather" :ref "Magic p. 198"}
                 {:name "Lightning Weapon" :prerequisites "Magery 2 and Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 198"}
                 {:name "Lightning Whip" :prerequisites "Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 196"}
                 {:name "Mass Resist Lightning" :prerequisites "IQ 13+, Secret Spell (Mass Resist Lightning), and Resist Lightning" :prerequisite_count 0 :college "Weather" :ref "Pyramid 3/4: Magic on the Battlefield, p. 9 and Magical Styles: Dungeon Magic, p. 13)"}
                 {:name "Predict Weather" :prerequisites "4 Air spells" :prerequisite_count 4 :college "Weather" :ref "Basic Set, p. 243; Magic p. 193"}
                 {:name "Rain" :prerequisites "Clouds" :prerequisite_count 5 :college "Weather" :ref "Magic p. 195; Fantasy, p. 168"}
                 {:name "Resist Lightning" :prerequisites "6 Air Spells" :prerequisite_count 6 :college "Weather" :ref "Magic p. 196"}
                 {:name "Shocking Touch" :prerequisites "Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 196"}
                 {:name "Snow" :prerequisites "Clouds and Frost" :prerequisite_count 7 :college "Weather" :ref "Magic p. 193"}
                 {:name "Spark Cloud" :prerequisites "Shape Air and Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 196"}
                 {:name "Spark Storm" :prerequisites "Windstorm and Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 196"}
                 {:name "Storm" :prerequisites "Rain and Hail" :prerequisite_count 10 :college "Weather" :ref "Magic p. 195"}
                 {:name "Storm Shelter (A)" :prerequisites "None" :prerequisite_count 0 :college "Weather" :ref "Magic: The Least of Spells p. 17"}
                 {:name "Stroke of Lightning" :prerequisites "Any three of Ball of Lightning, Flaming Armor, Rain of Acid, Breathe Fire, Flaming Missiles, Rain of Fire, Breathe Steam, Flaming Weapon Rive, Burning Touch, Lightning Armor, Shocking Touch, Continual Sunlight, Lightning Missiles, Spark Cloud, Explosive Fireball, Lightning Stare, Spark Storm, Explosive Lightning, Lightning Weapon, Spit Acid, Fire Cloud, Lightning Whip, Wall of Lightning and Secret Spell (Stroke of Lightning)" :prerequisite_count 0 :college "Weather" :ref "Magic Styles: Dungeon Magic, p. 19"}
                 {:name "Tide" :prerequisites "8 Water spells" :prerequisite_count 9 :college "Weather" :ref "Magic p. 194"}
                 {:name "Wall of Lightning" :prerequisites "Lightning" :prerequisite_count 7 :college "Weather" :ref "Magic p. 197"}
                 {:name "Warm" :prerequisites "Heat and 4 Air spells" :prerequisite_count 8 :college "Weather" :ref "Magic p. 195"}
                 {:name "Waves" :prerequisites "Shape Water" :prerequisite_count 4 :college "Weather" :ref "Magic p. 194"}
                 {:name "Weather Dome" :prerequisites "2 spells from each of 4 elements" :prerequisite_count 8 :college "Weather" :ref "Magic p. 169"}
                 {:name "Wind" :prerequisites "Windstorm" :prerequisite_count 4 :college "Weather" :ref "Magic p. 193"}
                 {:name "Butcher†" :prerequisites "Magery 3 and Prepare Game" :prerequisite_count  :college "Food_College" :ref "Magic: Death Spells, p. 12"}                 {:name "Cook" :prerequisites "Test Food and Create Food" :prerequisite_count 3 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Create Food" :prerequisites "Cook and Seek Food" :prerequisite_count 5 :college "Food_College" :ref "Magic p. 79; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Death's Banquet†" :prerequisites "Magery 3, Essential Food, and Poison Food" :prerequisite_count 7 :college "Food_College" :ref "Magic: Death Spells, p. 13"}
                 {:name "Decay" :prerequisites "Test Food" :prerequisite_count 1 :college "Food_College" :ref "Magic p. 77"}
                 {:name "Distill" :prerequisites "Mature and Destroy Water" :prerequisite_count 7 :college "Food_College" :ref "Magic p. 89"}
                 {:name "Eat Crow (A)" :prerequisites "None" :prerequisite_count 0 :college "Food_College" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Essential Food†" :prerequisites "6 Food spells including Create Food" :prerequisite_count 6 :college "Food_College" :ref "Magic p. 79; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Far-Tasting" :prerequisites "Magery 1 and either Seek Food or Seek Air; cannot have No Sense of Taste/Smell" :prerequisite_count 1 :college "Food_College" :ref "Magic p. 77"}
                 {:name "Find Ingredient (A)" :prerequisites "None" :prerequisite_count nil :college "Food_College" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Guns to Butter" :prerequisites "Create Food, Reshape" :prerequisite_count  :college "Food_College" :ref "Classic: Technomancer p. 22"}
                 {:name "Fool's Banquet" :prerequisites "Magery 1, Cook, and Foolishness" :prerequisite_count 5 :college "Food_College" :ref "Magic p. 79"}
                 {:name "Foul Water" :prerequisites "Purify Water and Decay" :prerequisite_count 4 :college "Food_College" :ref "Magic p. 185"}
                 {:name "Glutton’s Cheat (A)" :prerequisites "None" :prerequisite_count 0 :college "Food_College" :ref "Magic: The Least of Spells p. 9"}
                 {:name "Hunger" :prerequisites "Magery 1, Debility, and Decay" :prerequisite_count 3 :college "Food_College" :ref "Magic p. 38"}
                 {:name "Know Recipe" :prerequisites "Far-Tasting and Season" :prerequisite_count 4 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Mature" :prerequisites "Decay or Season" :prerequisite_count 2 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Monk’s Banquet" :prerequisites "Fool’s Banquet and Resist Pain" :prerequisite_count 10 :college "Food_College" :ref "Magic p. 79"}
                 {:name "Poison Food" :prerequisites "Purify Food and Decay" :prerequisite_count 3 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Prepare Game" :prerequisites "Purify Food" :prerequisite_count 3 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Preserve Food" :prerequisites "Decay" :prerequisite_count 2 :college "Food_College" :ref "Magic p. 79"}
                 {:name "Purify Food" :prerequisites "Decay" :prerequisite_count 2 :college "Food_College" :ref "Magic p. 78"}
                 {:name "Ritual of Reaping (A)" :prerequisites "None" :prerequisite_count 0 :college "Food_College" :ref "Magic: The Least of Spells p. 15"}
                 {:name "Scents of the Past" :prerequisites "Magery 2, History, and Odor" :prerequisite_count 8 :college "Food_College" :ref "Magic p. 107"}
                 {:name "Season" :prerequisites "Test Food" :prerequisite_count 1 :college "Food_College" :ref "Magic p. 77"}
                 {:name "Seek Food" :prerequisites "None" :prerequisite_count 0 :college "Food_College" :ref "Magic p. 77"}
                 {:name "Test Food" :prerequisites "None" :prerequisite_count 0 :college "Food_College" :ref "Magic p. 77; Fantasy, p. 169"}
                 {:name "Thirst" :prerequisites "Magery 1, Debility, and Destroy Water" :prerequisite_count 5 :college "Food_College" :ref "Magic p. 38"}
                 {:name "Water to Wine" :prerequisites "Purify Water and Mature" :prerequisite_count 5 :college "Food_College" :ref "Magic p. 79; Pyramid 3/60: Dungeon Fantasy III, p. 6"}
                 {:name "Wizard Mouth" :prerequisites "Apportation, Far-Tasting, and Great Voice" :prerequisite_count 7 :college "Food_College" :ref "Magic p. 104"}
                 {:name "Wizard Nose" :prerequisites "Apportation and Far-Tasting" :prerequisite_count 3 :college "Food_College" :ref "Magic p. 104"}])

(comment

  (defn get-unique-maps [key coll]
    (->> coll
         (group-by #(get % key))
         (vals)
         (map first)))

  (defn kebab-case [s]
    (when s
      (-> s
          str
          (clojure.string/replace #"([a-z])([A-Z])" "$1-$2")
          (clojure.string/replace #"([A-Z]+)([A-Z][a-z])" "$1-$2")
          clojure.string/lower-case
          (clojure.string/replace #"\s+" "-")
          (clojure.string/replace #"[-]+$" ""))))

  (->> parsed-spells
       (map :college)
       (map kebab-case)
       (map keyword)
       distinct)

  ;; TODO:
  ;; kebab -> keyword college
  ;; group by college
  ;; generate def for each college
  ;;
  ;; parse cast-time, duration, cost, prerequisites

  (->> parsed-spells
       (map #(str "(def ^:private '(symbol (keyword (kebab-case (get % :name)))) '" % ")"))
       (map cljs.reader/read-string))

  (+ 1 2))
