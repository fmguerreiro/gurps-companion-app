#!/usr/bin/env python3

import re

spell_type_matcher = re.compile(
    r"^(Special|Regular|Information|Area|Blocking|Missile|Enchantment|Melee)(\n|; .*)$"
)
section_end_matcher = re.compile(
    r"^(Duration:|Base cost:|Cost:|Energy cost to create:|Energy cost to cast:|Energy cost to activate:|Time to build body:|Energy Cost:|Time to cast:|Prerequisites?:|Item\n|As listed under )"
)
cost_start_matcher = re.compile(
    r"^(Base cost:|Cost:|Energy cost to create:|Energy cost to cast:|Energy cost to activate:|Energy Cost:)"
)
time_start_matcher = re.compile(r"^(Time to cast:|Time to build body:)")
duration_start_matcher = re.compile(r"^Duration:")

# should return 837 spells


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
    path = "./magic_book.txt"
    output = "./magic_book_out.txt"

    # first (re-)create the output file
    with open(output, "w"):
        pass

    with open(path) as f:
        lines = f.readlines()
        i = 0
        try:
            while i < len(lines):
                line = lines[i]
                j = 1
                print(line)
                if spell_type_matcher.match(line):
                    name = lines[i - 1].strip()
                    is_vh = "true" if "(VH)" in name else ""

                    was_p = False
                    if name == "Fog":
                        was_p = True
                        print(name)
                        print(
                            str_replace(name.lower())
                            .replace("/tl", "")
                            .replace(" ", "-")
                        )
                        print(str_replace(line))

                    name = str_replace(name.lower()).replace("/tl", "")
                    hyphenated_name = name.lower().replace(" ", "-")
                    type = str_replace(line)

                    description = ""
                    # continue fetching the next lines until the `^Duration:|Cost:|...`
                    # line is found. that will be the description
                    while not section_end_matcher.match(lines[i + j]):
                        description += lines[i + j]
                        j += 1
                    description = str_replace(description)

                    duration = ""
                    if duration_start_matcher.match(lines[i + j]):
                        duration += lines[i + j]
                        j += 1
                        while not section_end_matcher.match(lines[i + j]):
                            duration += lines[i + j]
                            j += 1
                    duration = str_replace(duration)

                    cost = ""
                    if cost_start_matcher.match(lines[i + j]):
                        cost += lines[i + j]
                        j += 1
                        while not section_end_matcher.match(lines[i + j]):
                            cost += lines[i + j]
                            j += 1
                    cost = str_replace(cost)

                    time = ""
                    if time_start_matcher.match(lines[i + j]):
                        time += lines[i + j]
                        j += 1
                        while not section_end_matcher.match(lines[i + j]):
                            time += lines[i + j]
                            j += 1
                    time = str_replace(time)

                    # if is_vh:
                    #     print(f"{hyphenated_name}")

                    with open(output, "a") as file:
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
