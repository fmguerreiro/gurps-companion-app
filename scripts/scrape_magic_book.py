#!/usr/bin/env python3

example = """
Control Zombie
Regular; Resisted by Zombie
spell
Take control of an undead creature
raised with the Zombie spell by some
other wizard. If the caster wins a
Quick Contest of Spells with the original Zombie spell, the undead in question will obey the caster as if he had
raised it. The Zombie spell resists at
+2 if the original caster is within 100
yards, and at -2 if he is dead.
Duration: Permanent.

Zombie spell; DR does not protect. In
addition, roll 1d for each zombie. On a
1, it turns and flees from the caster.

Cost: 3.
Prerequisite: Zombie.

Item
Staff, wand, or jewelry. Usable only
by a mage. It does not give the ability
to cast the spell, but gives +2 skill to
one who knows the spell. Energy cost
to create: 500.

Turn Zombie

Duration: Successfully turned
undead will avoid the caster for one
day.
Base cost: 2. Cannot be maintained;
must be recast.
Time to cast: 4 seconds.
Prerequisite: Zombie, or “holy
status” (GM’s discretion).

Area
Inflicts 1d of injury on anything in
the area that was animated using the

Undead Templates
The following templates demonstrate three possible types of undead created with the Zombie spell. A normal dead
body produces a zombie; a corpse rotted away to bones produces a skeleton (indeed, zombies rot away to skeletons
over time); and a desiccated cadaver, or a properly embalmed body, becomes a mummy.

Mummy
-107 points
Attribute Modifiers: ST+1 [10].
Secondary Characteristic Modifiers: HP+4 [8].
Advantages: Doesn’t Breathe [20]; Doesn’t Eat or Drink
[10]; Doesn’t Sleep [20]; High Pain Threshold [10];
Immunity to Metabolic Hazards [30]; Immunity (All
mind control) [30]; Indomitable [15]; Injury
Tolerance (No Blood, No Brains, No Vitals, Unliving)
[35]; Single-Minded [5]; Temperature Tolerance 10
[10]; Unaging [15]; Unfazeable [15].
Disadvantages: Appearance (Monstrous; Universal,
+25%) [-25]; Automaton [-85]; Cannot Learn [-30];
Dependency (Mana; common, constantly) [-50];
Disturbing Voice [-10]; Fragile (Combustible) [-5];
Fragile (Unnatural) [-50]; Reprogrammable [-10];
Social Stigma (Dead) [-20]; Unhealing (Total) [-30];
Wealth (Dead Broke) [-25].
Features: Affected by Control Zombie, Pentagram, and
Turn Zombie; No mental skills; Sterile.

Skeleton
-162 points
Attribute Modifiers: ST-1 [-10]; DX+2 [40]; IQ-2 [-40].
Secondary Characteristic Modifiers: Basic Speed+1
[20].
Advantages: Doesn’t Breathe [20]; Doesn’t Eat or Drink
[10]; Doesn’t Sleep [20]; DR 2 [10]; High Pain
Threshold [10]; Immunity to Metabolic Hazards
[30]; Immunity (All mind control) [30]; Indomitable
[15]; Injury Tolerance (No Blood, No Brain, No Eyes,
No Vitals, Unliving) [40]; Single-Minded [5];
Temperature Tolerance 10 [10]; Unaging [15];
Unfazeable [15]; Vacuum Support [5].
Disadvantages: Appearance (Monstrous; Universal,
+25%) [-25]; Automaton [-85]; Cannot Learn [-30];

152

Dependency (Mana; common, constantly) [-50];
Fragile (Brittle) [-15]; Fragile (Unnatural) [-50];
Mute [-25]; No Sense of Smell/Taste [-5];
Reprogrammable [-10]; Skinny [-5]; Social Stigma
(Dead) [-20]; Unhealing (Total) [-30]; Vulnerability
(Crushing Attacks; ¥2) [-30]; Wealth (Dead Broke)
[-25].
Quirks: Cannot Float; Sexless. [-2]
Features: Affected by Control Zombie, Pentagram, and
Turn Zombie; No mental skills; Skull has only 2 total
DR.

Zombie
-168 points
Attribute Modifiers: ST+1 [10]; IQ-2 [-40].
Secondary Characteristic Modifiers: HP+4 [8].
Advantages: Doesn’t Breathe [20]; Doesn’t Eat or Drink
[10]; Doesn’t Sleep [20]; High Pain Threshold [10];
Immunity to Metabolic Hazards [30]; Immunity (All
mind control) [30]; Indomitable [15]; Injury
Tolerance (No Blood, Unliving) [25]; Single-Minded
[5]; Temperature Tolerance 10 [10]; Unaging [15];
Unfazeable [15].
Disadvantages: Appearance (Monstrous; Universal,
+25%) [-25]; Automaton [-85]; Bad Smell [-10];
Cannot Learn [-30]; Dependency (Mana; common,
constantly) [-50]; Disturbing Voice [-10]; Fragile
(Unnatural) [-50]; No Sense of Smell/Taste [-5];
Reprogrammable [-10]; Social Stigma (Dead) [-20];
Unhealing (Total) [-30]; Wealth (Dead Broke) [-25].
Quirks: Sexless. [-1]
Features: Affected by Control Zombie, Pentagram, and
Turn Zombie; No mental skills; Will become a
Skeleton.

NECROMANTIC SPELLS

Item
Staff, wand, or jewelry. At the GM’s
option, this item may work only for a
person with Blessed or Power
Investiture. Energy cost to create: 600.
"""

import re

spell_type_matcher = re.compile(
    r"^(Special|Regular|Information|Area|Blocking|Missile|Enchantment|Regular or Blocking|Melee);?$"
)
section_end_matcher = re.compile(
    r"^(Duration:|Base cost:|Cost:|Energy cost to create:|Energy cost to cast:|Energy cost to activate:|Time to build body:|Energy Cost:|Time to cast:|Prerequisites?:|Item\n|As listed under )"
)
cost_start_matcher = re.compile(
    r"^(Base cost:|Cost:|Energy cost to create:|Energy cost to cast:|Energy cost to activate:|Energy Cost:)"
)
time_start_matcher = re.compile(r"^(Time to cast:|Time to build body:)")
duration_start_matcher = re.compile(r"^Duration:")


def str_replace(s):
    return (
        s.replace("\n", " ")
        .replace('"', "'")
        .replace("“", "'")
        .replace("”", "'")
        .replace("’", "'")
        .replace(". . .", "...")
        .replace("(vh)", "")
        .strip()
    )


def scrape_gurps_magic_book():
    with open("../../Downloads/GURPS 4th Magic.txt") as f:
        lines = f.readlines()
        i = 0
        try:
            while i < len(lines):
                line = lines[i]
                next_line = lines[i + 1]
                j = 2
                if spell_type_matcher.match(next_line):
                    name = line.strip()
                    hyphenated_name = name.lower().replace(" ", "-")
                    is_vh = "true" if "(VH)" in line else ""
                    type = str_replace(next_line)

                    next_line = lines[i + j]
                    description = ""
                    # continue fetching the next lines until the `^Duration:`
                    # line is found. that will be the description
                    while not section_end_matcher.match(next_line):
                        description += next_line
                        j += 1
                        next_line = lines[i + j]
                    description = str_replace(description)

                    duration = ""
                    if duration_start_matcher.match(next_line):
                        duration += next_line
                        j += 1
                        next_line = lines[i + j]
                        while not section_end_matcher.match(next_line):
                            duration += next_line
                            j += 1
                            next_line = lines[i + j]
                    duration = str_replace(duration)

                    cost = ""
                    if cost_start_matcher.match(next_line):
                        cost += next_line
                        j += 1
                        next_line = lines[i + j]
                        while not section_end_matcher.match(next_line):
                            cost += next_line
                            j += 1
                            next_line = lines[i + j]
                    cost = str_replace(cost)

                    time = ""
                    if time_start_matcher.match(next_line):
                        time += next_line
                        j += 1
                        next_line = lines[i + j]
                        while not section_end_matcher.match(next_line):
                            time += next_line
                            j += 1
                            next_line = lines[i + j]
                    time = str_replace(time)

                    if is_vh:
                        print(f"{hyphenated_name} is vh")

                    with open("spells.txt", "a") as file:
                        print(f'"spell-{hyphenated_name}-type": "{type}",', file=file)
                        if duration:
                            duration = duration.split(":")[1].strip()
                            print(
                                f'"spell-{hyphenated_name}-duration": "{duration}",',
                                file=file,
                            )

                        if cost:
                            cost = cost.split(":")[1].strip()
                            print(
                                f'"spell-{hyphenated_name}-cost": "{cost}",', file=file
                            )

                        if time:
                            time = time.split(":")[1].strip()
                            print(
                                f'"spell-{hyphenated_name}-time": "{time}",', file=file
                            )
                i += j
        except IndexError:
            print(i, j)
            j = 2


if __name__ == "__main__":
    scrape_gurps_magic_book()
