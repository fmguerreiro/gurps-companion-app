#!/usr/bin/env python3


import re

type_matcher = re.compile(r"^(Mental|Physical|Social)(\n|; .*)$")

fixed_cost_matcher = re.compile(r"^-\d+ points?\*?$")
or_cost_matcher = re.compile(r"^-\d+,?( -\d+,)* or -\d+ points?\*?$")
per_lvl_cost_matcher = re.compile(r"^-\d+ points?/level\*?$")


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
    input = "./disadvantages.txt"
    output = "./disadvantages_out.txt"

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
                    # remove text after the last period
                    description = description[: description.rfind(".")] + "."

                    # print translations to file
                    with open(output, "a") as file:
                        print(f'"disadvantage-{hyphenated_name}": "{name}",', file=file)
                        print(
                            f'"disadvantage-{hyphenated_name}-type": "{type}",',
                            file=file,
                        )
                        print(
                            f'"disadvantage-{hyphenated_name}-description": "{description}",',
                            file=file,
                        )
                        print(
                            f'"disadvantage-{hyphenated_name}-cost": "{cost}",',
                            file=file,
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
