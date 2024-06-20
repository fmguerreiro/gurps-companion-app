#!/usr/bin/env python3


import re

type_matcher = re.compile(r"^(Mental|Physical|Social)(\n|; .*)$")

fixed_cost_matcher = re.compile(r"^\d+ points?$")
or_cost_matcher = re.compile(r"^\d+,?( \d+,)* or \d+ points?$")
per_lvl_cost_matcher = re.compile(r"^\d+ points?/level$")


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
def cost_to_clj(cost):
    if fixed_cost_matcher.match(cost):
        return cost.split(" ")[0]
    elif per_lvl_cost_matcher.match(cost):
        return cost.split(" ")[0]
    elif or_cost_matcher.match(cost):
        return (
            "["
            + (
                cost.replace("point", "")
                .replace("s", "")
                .replace(",", "")
                .replace("or", "")
                .replace("  ", " ")
                .strip()
            )
            + "]"
        )
    else:
        return ":variable"


def str_replace(s):
    return (
        s.replace("\n", " ")
        .replace('"', "'")
        .replace("“", "'")
        .replace("”", "'")
        .replace("’", "'")
        .replace(". . .", "...")
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

                    hyphenated_name = str_replace(name.lower()).replace(" ", "-")
                    type = str_replace(line)

                    i += 1
                    cost = str_replace(lines[i])

                    description = ""
                    # continue fetching the next lines until the next type
                    while not type_matcher.match(lines[i + j]):
                        description += lines[i + j]
                        j += 1
                    description = str_replace(description)

                    # print translations to file
                    with open(output, "a") as file:
                        print(f'"advantage-{hyphenated_name}": "{name}",', file=file)
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

                    # print clojure code to stdout
                    type_1, *type_2 = type.split(";")
                    type_1 = str_replace(type_1.lower()).replace(" or ", "-")
                    type_2 = type_2[0] if type_2 else "mundane"
                    type_2 = str_replace(type_2.lower())
                    cost = cost_to_clj(cost)
                    print(
                        "{"
                        + f":name :{hyphenated_name} :type-1 :{type_1} :type-2 :{type_2} :cost {cost}"
                        + "}"
                    )
                i += j
        except IndexError:
            j = 2


if __name__ == "__main__":
    scrape()
