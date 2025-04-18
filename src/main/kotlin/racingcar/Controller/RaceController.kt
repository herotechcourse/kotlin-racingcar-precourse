package racingcar.controller

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.OutputView

/**
 * Controller class that orchestrates the car racing game.
 * Connects the domain models with the views.
 */
class RaceController {
    /**
     * Starts the car racing game by getting input, creating the race,
     * executing rounds, and displaying the results.
     */
    fun start() {
        try {
            val cars = getCarsFromUserInput()
            val rounds = getRoundsFromUserInput()

            executeRaceWithRounds(cars, rounds)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun getCarsFromUserInput(): List<Car> {
        val carNames = InputView.readCarNames()
        return createCars(carNames)
    }

    private fun getRoundsFromUserInput(): Int {
        val roundsInput = InputView.readRounds()
        return parseRounds(roundsInput)
    }

    private fun executeRaceWithRounds(cars: List<Car>, rounds: Int) {
        val race = Race(cars, rounds)
        runRaceAndDisplayResults(race)
    }

    /**
     * Creates Car objects from the comma-separated car names input.
     *
     * @param input Comma-separated string of car names
     * @return List of Car objects
     * @throws IllegalArgumentException if any car name is invalid
     */
    private fun createCars(input: String): List<Car> {
        val carNames = input.split(",").map { it.trim() }
        validateCarNames(carNames)

        return carNames.map { Car(it) }
    }

    private fun validateCarNames(carNames: List<String>) {
        require(carNames.isNotEmpty()) { "At least one car name must be provided." }
    }

    /**
     * Parses the rounds input to an integer.
     *
     * @param input String representation of the number of rounds
     * @return Number of rounds as an integer
     * @throws IllegalArgumentException if the input is not a positive integer
     */
    private fun parseRounds(input: String): Int {
        val rounds = input.toIntOrNull()
        require(rounds != null && rounds > 0) { "Number of rounds must be a positive integer." }

        return rounds
    }

    /**
     * Executes all rounds of the race and displays the results.
     *
     * @param race The Race object to execute
     */
    private fun runRaceAndDisplayResults(race: Race) {
        executeAllRounds(race)
        announceWinners(race)
    }

    private fun executeAllRounds(race: Race) {
        repeat(race.rounds) { round ->
            race.executeRound()
            OutputView.printRaceResults(round + 1, race.cars)
        }
    }

    private fun announceWinners(race: Race) {
        val winners = race.findWinners()
        OutputView.printWinners(winners)
    }
}