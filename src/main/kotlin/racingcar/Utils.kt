package racingcar

import camp.nextstep.edu.missionutils.Console

fun readInput(message: String): String {
    print(message)
    return Console.readLine()
}

fun prompt(message: String): String {
    val input = readInput(message)
    require(input.isNotBlank()) { "Input is empty." }
    return input
}

fun validateCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    require(names.all { it.length in 1..5 }) { "must be between 1 and 5 chars" }
    require(names.toSet().size == names.size) { "Car names must be unique." }
    return names
}

fun validateRounds(input: String): Int {
    val rounds = input.toIntOrNull()
    require(rounds != null) { "Input must be a valid number." }
    require(rounds > 0) { "Rounds must be a positive number." }
    return rounds
}

fun printDashes(count: Int): String {
    return "-".repeat(count)
}