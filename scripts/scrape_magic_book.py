#!/usr/bin/env python3

import re

spell_type_matcher = re.compile(
    r"^(Special|Regular|Information|Area|Blocking|Missile|Enchantment|Regular or Blocking|Melee);?"
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
                    is_vh = "true" if "(VH)" in line else ""

                    # if name == "Essential Acid (VH)":
                    # print(f"{name}")

                    name = str_replace(name.lower()).replace("/tl", "")
                    hyphenated_name = name.lower().replace(" ", "-")
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
                        print(f"{hyphenated_name}")

                    with open("spells.txt", "a") as file:
                        print(f'"spell-{hyphenated_name}-type": "{type}",', file=file)
                        print(
                            f'"spell-{hyphenated_name}-description": "{description}",',
                            file=file,
                        )
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
            j = 2


if __name__ == "__main__":
    scrape_gurps_magic_book()
