package racingcar.util

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

/**
 * Prompts the user to enter car names and returns a list of trimmed names.
 */
fun getCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val inputNames = Console.readLine()
    return inputNames.split(",").map { it.trim() }
}

/**
 * Creates a list of Car objects from the given car names.
 * Throws an exception if any car name is invalid.
 */
fun createCars(carNames: List<String>): List<Car> {
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
fun getNumberOfRounds(): Int {
    println("How many rounds will be played?")
    val roundInput = Console.readLine()
    return roundInput.toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")
}