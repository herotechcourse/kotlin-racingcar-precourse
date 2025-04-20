package racingcar

import camp.nextstep.edu.missionutils.Console

/**
 * Entry point of the racing car game application.
 * Handles user input, validates it, and starts the game.
 */
fun main() {
    val carNames = readCarNames()
    val rounds = readNumberOfRounds()
    val cars = carNames.map { Car(it) }
    val game = Game(cars, rounds)
    game.start()
}

/**
 * Reads car names from the console and splits them into a list.
 *
 * @return List of car names.
 * @throws IllegalArgumentException if input is empty.
 */
fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }.also { names ->
        require(names.all { it.isNotBlank() && it.length <= 5 }) {
            "All car names must be non-empty and at most 5 characters long."
        }
    }
}

/**
 * Reads the number of rounds from the console.
 *
 * @return The number of rounds.
 * @throws IllegalArgumentException if the input is not a valid positive integer.
 */
fun readNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    return input.toIntOrNull()?.also {
        require(it > 0) { "The number of rounds must be greater than zero." }
    } ?: throw IllegalArgumentException("Invalid input: not a number.")
}