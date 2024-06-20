#!/usr/bin/env python3

# "5, 6, 7, or 8 points"
# "6 points/level"
# "1 point/level"
# "5 points per +1 ST"
# "0 or 5 points"
# "100 points"
# "1 point"
# "Variable"
# "30 points + 5 points per point of Tunneling Move"
# "30 points + 5 points per extra HP drained"
# "5 points / +1 reaction"

import re

type_matcher = re.compile(r"^(Mental|Physical|Social)(\n|; .*)$")


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


def scrape():
    input = "./advantages.txt"
    output = "./advantages_out.txt"

    # first (re-)create the output file
    with open(output, "w"):
        pass

    with open(input) as f:
        lines = f.readlines()
        i = 0
        try:
            while i < len(lines):
                line = lines[i]
                j = 1

                if type_matcher.match(line):
                    name = lines[i - 1].strip()

                    name = str_replace(name.lower()).replace("/tl", "")
                    hyphenated_name = name.lower().replace(" ", "-")
                    type = str_replace(line)

                    i += 1
                    cost = str_replace(lines[i])

                    description = ""
                    # continue fetching the next lines until the next type
                    while not type_matcher.match(lines[i + j]):
                        description += lines[i + j]
                        j += 1
                    description = str_replace(description)

                    # print translations
                    with open(output, "a") as file:
                        print(
                            f'"advantage-{hyphenated_name}-type": "{type}",', file=file
                        )
                        print(
                            f'"advantage-{hyphenated_name}-description": "{description}",',
                            file=file,
                        )
                        print(
                            f'"advantage-{hyphenated_name}-cost": "{cost}",', file=file
                        )

                    # TODO: print clojure code
                i += j
        except IndexError:
            j = 2


if __name__ == "__main__":
    scrape()
