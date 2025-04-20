package racingcar.service

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car

/**
 * Reads and validates a list of car names from console input.
 * Each car name must be between 1 and 5 characters and must be unique.
 *
 * @return A mutable list containing the validated car names.
 * @throws IllegalArgumentException if any car name is empty, exceeds 5 characters, or if there are duplicate names.
 */

fun getCarNames(): MutableList<String> {
    println("Enter the names of the cars, separated by a comma:")
    val carNames = Console.readLine()!!.split(",").map { it.trim() }

    // Validation of carNames
    if (carNames.any { it.length > 5 || it.isEmpty() } || carNames.size != carNames.map{it.lowercase()}.toSet().size) {
        throw IllegalArgumentException("Error: Each car name must be between 1 and 5 characters and must be unique.")
    }
    else return carNames.toMutableList()
}

/**
 * Create list of cars from input car names
 */

fun createCars(carNames: MutableList<String>): MutableList<Car> {
    return carNames.map { Car(it) }.toMutableList()
}

/**
 * Reads and validates the number of rounds for the racing game from console input.
 * The input must be a positive integer.
 *
 * @return The number of rounds as a positive integer.
 * @throws IllegalArgumentException if the input is not a positive integer.
 */

fun getNumberOfRounds(): Int {
    print("Enter the number of rounds:")
    val numberOfRounds = Console.readLine()!!.toIntOrNull()

    //Validation of rounds

    if (numberOfRounds == null || numberOfRounds <= 0) {
        throw IllegalArgumentException("Error: Number of rounds must be a positive integer")
    }
    return numberOfRounds
}