package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * Main application class to run the car racing game.
 *
 * This class handles user input, validates it, and coordinates the race execution.
 */
class Application {
    /**
     * Entry point of the application. Manages the flow of the game.
     */
    fun main() {
        println("Enter the names of the cars (comma-separated):")
        val carNames = parseCarNamesInput(Console.readLine())
        val cars = carNames.map { Car(it) }

        println("How many rounds will be played?")
        val rounds = validateRoundsInput(Console.readLine())

        val race = Race(cars, rounds)
        race.runTheRace()

        printRaceResults(cars, race.getPositions())
        printRaceWinners(race.getWinners())
    }

    /**
     * Parses and validates the car names input by the user.
     *
     * @param input the raw input string containing car names
     * @return a list of  car names
     * @throws IllegalArgumentException if the input format is invalid
     */
    private fun parseCarNamesInput(input: String): List<String> {
        if (!input.contains(",")) {
            throw IllegalArgumentException("Car names should be comma-separated.")
        }
        val carNames = input.split(",").map { it.trim() }
        return carNames
    }

    /**
     * Validates the number of rounds input by the user.
     *
     * @param input the raw input string for the number of rounds
     * @return the validated number of rounds
     * @throws IllegalArgumentException if the input is not a valid positive integer
     */
    private fun validateRoundsInput(input: String): Int {
        val rounds: Int
        try {
            rounds = input.toInt()
            if (rounds <= 0) {
                throw IllegalArgumentException("Number of rounds must be greater than 0.")
            }
            if (rounds > 1_000) {
                throw IllegalArgumentException("Number of rounds must not exceed 1,000.")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input. Please enter a valid integer for the number of rounds.")
        }
        return rounds
    }

    /**
     * Prints the race results in a formatted way.
     *
     * @param results the list of cars participating in the race
     * @param positions the list of positions corresponding to each car
     */
    private fun printRaceResults(results: List<Car>, positions: List<Int>) {
        println("Race Results")
        results.forEachIndexed { index, car -> println("${car.name} : ${"-".repeat(positions[index])}") }
    }

    /**
     * Prints the winners of the race.
     *
     * @param winners the list of cars that won the race
     */
    private fun printRaceWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}

/**
 * Main function to start the application.
 */
fun main() {
    val game = Application()
    game.main()
}
