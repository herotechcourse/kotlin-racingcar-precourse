package racingcar

import camp.nextstep.edu.missionutils.Console

// Extracted Console.readLine() to keep parsing logic testable
fun getValidCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return parseCarNames(input)
}

fun getValidRoundCount(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine().trim()
    return parseRoundCount(input)
}

internal fun parseCarNames(input: String): List<String> {
    if (input.isBlank()) throw IllegalArgumentException("Input cannot be empty.")

    val carNames = input.split(",").map { it.trim() }

    if (carNames.any { it.isBlank() }) {
        throw IllegalArgumentException("Each car must have a name. No blanks allowed between commas.")
    }

    val invalidNames = carNames.filter { it.length > 5 }
    if (invalidNames.isNotEmpty()) {
        throw IllegalArgumentException("Car names must be 1–5 characters long. Invalid name: ${invalidNames.joinToString()}")
    }

    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("Car names must be unique.")
    }

    return carNames
}

internal fun parseRoundCount(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("Please enter a positive integer.")
    }

    val round = input.toIntOrNull()
        ?: throw IllegalArgumentException("Only numeric values are allowed. Please enter a positive integer.")

    if (round <= 0) {
        throw IllegalArgumentException("Round count must be a positive integer.")
    }

    return round
}

