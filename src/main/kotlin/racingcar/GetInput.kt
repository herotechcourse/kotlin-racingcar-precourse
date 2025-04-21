package racingcar

import camp.nextstep.edu.missionutils.Console

fun getInputNames(): List<String> {
    println("Names of the cars (comma-separated):")
    val input = Console.readLine()
    validateInput(input)
    val names: List<String> = input.split(',').map { it.trim() }
    println("${names.joinToString(", ") { it }}")
    validateCarsCount(names)
    return names
}

fun getInputRounds(): Int {
    println("Number of rounds:")
    val inputString = Console.readLine()
    println(inputString)
    val numRounds =
            try {
                inputString.toInt()
            } catch (error: Throwable) {
                throw IllegalArgumentException("Input must be a positive integer")
            }
    validateRoundsCount(numRounds)
    return numRounds
}

private fun validateInput(input: String) {
    require(input.isNotBlank()) { "Input must not be empty" }
}

private fun validateCarsCount(names: List<String>) {
    require(names.size > 1) { "There must be more than one car" }
}

private fun validateRoundsCount(rounds: Int) {
    require(rounds > 0) { "Number of rounds must be positive" }
    require(rounds <= maxRounds) { "Maximum rounds is $maxRounds" }
}
