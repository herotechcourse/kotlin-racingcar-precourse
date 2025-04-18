package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",")
    val isInvalid = names.any { it.isBlank() || it.length > 5 }

    if (isInvalid) {
        throw IllegalArgumentException("Each car name must be 1–5 characters long.")
    }
    if (names.size < 2) {
        throw IllegalArgumentException("Number of cars must be more than 1")
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

fun printResult(names: List<String>) {
    for (name in names) {
        if (racingResult()) {
            println("$name : -")
        } else println("$name :  ")
    }
}

fun racingResult(): Boolean {
    val number = Randoms.pickNumberInRange(0, 9)
    return number >= 4
}

fun main() {
    val carNames = readCarNames()
    readRound()
    printResult(carNames)
}
