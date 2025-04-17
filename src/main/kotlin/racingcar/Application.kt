package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * Validates that all car names are unique.
 * Throws an IllegalArgumentException if any duplicate is found.
 */
fun validateUniqueCarNames(names: List<String>) {
    if (names.toSet().size != names.size) {
        throw IllegalArgumentException("Car names must be unique.")
    }
}

/**
 * Validates car name list:
 * - Must contain at least two names
 * - Names must be unique
 * - Each name must be 5 characters or fewer
 */
fun validateCarNames(names: List<String>) {
    require(names.size >= 2) {
        "At least two cars are required to start the race."
    }

    validateUniqueCarNames(names)

    names.forEach { name ->
        require(name.length <= 5) {
            "Car name ($name) cannot exceed 5 characters"
        }
    }
}

/**
 * Validates the number of rounds entered as a string.
 * Must be a numeric string representing an integer ≥ 1.
 */
fun validateRounds(rounds: String) {
    if (rounds.isBlank() || rounds.any { !it.isDigit() }) {
        throw IllegalArgumentException("Number of rounds must be a positive number.")
    }

    val value = rounds.toInt()
    if (value < 1) {
        throw IllegalArgumentException("Number of rounds must be at least 1.")
    }
}

/**
 * Splits comma-separated car names and trims any whitespace.
 */
fun splitInputToCarNames(input: String): List<String> {
    return input.split(",").map { it.trim() }
}

/**
 * Reads car names from the user, validates them, and returns a list.
 */
fun getValidatedCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = splitInputToCarNames(input)
    validateCarNames(names)
    return names
}

/**
 * Reads the number of rounds from the user, validates it, and returns it as an Int.
 */
fun inputRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    validateRounds(input)
    return input.toInt()
}

/**
 * Generates a random number between 0 and 9 (inclusive) using the mission utility.
 */
fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

/**
 * Prints the current race progress:
 * Each car is displayed with its name and movement (as '-' for each successful move).
 */
fun customPrint(raceData: MutableMap<String, Int>) {
    for ((car, steps) in raceData) {
        val progress = "-".repeat(steps)
        println("$car : $progress")
    }
    println("\n")
}

/**
 * Runs the race for the given cars over the specified number of rounds.
 * Each round, cars may move forward based on random number generation.
 * Prints the race state after each round and returns the full race data.
 */
fun startRace(cars: List<String>, rounds: Int): MutableMap<String, Int> {
    val carMap = mutableMapOf<String, Int>()

    // Initialize each car's round data with 0s
    for (car in cars) {
        carMap[car] = 0
    }

    // Simulate each round
    for (i in 0 until rounds) {
        for (car in cars) {
            if (generateRandomNumber() >= 4) {
                carMap[car] = (carMap[car] ?: 0) + 1 // Move forward in this round
            }
        }
        customPrint(carMap) // Show progress after each round
    }

    return carMap
}

/**
 * Determines the winner(s) by checking which car(s) moved the most.
 * Returns a list of winner names.
 */
fun findWinners(raceData: MutableMap<String, Int>): List<String> {
    val scores = raceData.mapValues { it.value } // moves for each car
    val maxScore = scores.maxOf { it.value } // highest score

    return scores.filterValues { it == maxScore }.keys.toList()
}

/**
 * Application entry point.
 * Reads input, runs the race, determines winners, and displays them.
 */
fun main() {
    val names = getValidatedCarNames()
    val rounds = inputRounds()
    val raceResults = startRace(names, rounds)
    val winners = findWinners(raceResults)
    println("Winners : ${winners.joinToString(", ")}")
}
