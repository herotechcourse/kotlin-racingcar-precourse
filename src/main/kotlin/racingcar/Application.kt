package racingcar

import camp.nextstep.edu.missionutils.Console

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",")
    val isInvalid = names.any { it.isBlank() || it.length > 5 }

    if (isInvalid) {
        throw IllegalArgumentException("Each car name must be 1–5 characters long.")
    }
    return names
}

fun readRound(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    val round: Int
    try {
        round = input.toInt()
    } catch (_: NumberFormatException) {
        throw IllegalArgumentException("Round must be an integer.")
    }

    if (round <= 0) {
        throw IllegalArgumentException("Round must be positive.")
    }
    return round
}

fun main() {
    readCarNames()
    readRound()
}
