package racingcar

import java.lang.IllegalArgumentException

val nameLen: Int = 5
val delim: Char = ','
val maxRounds: UInt = 200u

// var validator: (String) -> Boolean = {
//     name -> name.length <= 5
// }

fun main() {
    // TODO: Implement the program
    try {
        val carNames = getNames()
        val numRounds = getNumberOfRounds()
    } catch (error: IllegalArgumentException) {
        println("Error: ${error.message}")
    }
}

fun getNames(): List<String> {
    println("Names of the cars (comma-separated):\n")
    val input = readln()
    validateInput(input)
    val names: List<String> = input.split(delim).map { name -> name.trim() }
    validateNames(names)
    return (names)
}

fun getNumberOfRounds(): UInt {
    println("Number of rounds:")
    val numRounds =
            try {
                readln().toUInt()
            } catch (error: Throwable) {
                throw IllegalArgumentException("Input must be a positive integer")
            }
    validateRounds(numRounds)
    return numRounds
}

fun validateInput(input: String) {
    if (input.isBlank()) throw IllegalArgumentException("Input must not be empty")
}

fun validateNames(names: List<String>) {
    when {
        names.size <= 1 -> throw IllegalArgumentException("There must be more than one car")
        names.any { name -> name.isEmpty() } ->
                throw IllegalArgumentException("Each car must have a name")
        names.any { name -> (name.length > nameLen) } ->
                throw IllegalArgumentException("Names cannot exceed $nameLen characters")
    }
}

fun validateRounds(rounds: UInt) {
    when {
        rounds == 0u -> throw IllegalArgumentException("Number of rounds must be positive")
        rounds > maxRounds -> throw IllegalArgumentException("Maximum tounds exceeded")
    }
}
