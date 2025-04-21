package racingcar

import camp.nextstep.edu.missionutils.Console

/**
 * This class is a controller for a car racing game
 */
object GameController {

    /**
     * This method is responsible for running the game by performing the following steps:
     *
     * - Reads car names from user input
     * - Reads number of rounds from user input
     * - Initializes and starts the game
     * - Retrieves and prints the winners
     */
    fun run() {
        val cars = readCarNames()
        val rounds = readRounds()
        val game = RacingGame(cars, rounds)

        game.startRace()

        val winners = game.getWinners()
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }

    /**
     * This method is responsible for reading and validating car names from user input.
     * Input should be a comma-separated list of car names with each name up to 5 characters.
     *
     * @return A list of valid car objects.
     * @throws IllegalArgumentException if input is empty or contains invalid names.
     */
    private fun readCarNames(): List<Car> {
        println("Enter car names (comma-separated, max 5 characters each):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        if (names.isEmpty() || names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Invalid car names.")
        }

        return names.map { Car(it) }
    }

    /**
     * This method is responsible for reading and validating the number of race rounds from user input.
     *
     * @return A positive integer representing the number of rounds.
     * @throws IllegalArgumentException if input is not a positive integer.
     */
    private fun readRounds(): Int {
        println("Enter number of rounds:")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it > 0 }
                ?: throw IllegalArgumentException("Invalid number of rounds.")
    }
}
