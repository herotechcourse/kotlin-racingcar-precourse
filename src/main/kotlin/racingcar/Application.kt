package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.domain.RacingGame
import racingcar.model.Car

/**
 * Main function to start the racing car game.
 * Handles user input for car names and number of rounds, and initiates the game.
 */
fun main() {
    val carNames = getCarNames()
    val cars = createCars(carNames)
    val rounds = getNumberOfRounds()

    val game = RacingGame(cars, rounds)
    game.startRace()
}

/**
 * Prompts the user to enter car names and returns a list of trimmed names.
 */
private fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val inputNames = Console.readLine()
    return inputNames.split(",").map { it.trim() }
}

/**
 * Creates a list of Car objects from the given car names.
 * Throws an exception if any car name is invalid.
 */
private fun createCars(carNames: List<String>): List<Car> {
    return try {
        carNames.map { Car(it) }
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("Each car name must be 1 to 5 characters.")
    }
}

/**
 * Prompts the user to enter the number of rounds and returns it as an integer.
 * Throws an exception if the input is not a valid integer.
 */
private fun getNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val roundInput = Console.readLine()
    return roundInput.toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")
}
