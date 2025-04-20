package racingcar

import camp.nextstep.edu.missionutils.Console

fun getUserInputNames(): List<String> {
    println("Names of the cars (comma-separated):\n")

    val input = Console.readLine()
    validateInput(input)
    val names: List<String> = input.split(',').map { it.trim() }
    validateCarsCount(names)
    return names
}

private fun validateInput(input: String) {
    if (input.isBlank()) throw IllegalArgumentException("Input must not be empty")
}

private fun validateCarsCount(names: List<String>) {
    if (names.size <= 1) throw IllegalArgumentException("There must be more than one car")
}

fun getUserInputRounds(): Int {
    println("Number of rounds:")
    val numRounds =
            try {
                Console.readLine().toInt()
            } catch (error: Throwable) {
                throw IllegalArgumentException("Input must be a positive integer")
            }
    validateRoundsCount(numRounds)
    return numRounds
}

private fun validateRoundsCount(rounds: Int) {
    require(rounds > 0) { "Number of rounds must be positive" }
    require(rounds <= maxRounds) { "Maximum rounds is $maxRounds" }
}
