package racingcar

import racingcar.validation.*

fun main() {
    try {
        // Read Input
        val roundsInput = readRoundsInput()

        // Process the input to get a valid number
        val numberOfRounds = processRoundsInput(roundsInput)

        // Print the valid number of rounds
        println("Number of rounds: $numberOfRounds")

    } catch (e: IllegalArgumentException) {
        // Print Validation error
        println("Error: ${e.message}")
    }
}