package racingcar.view

import racingcar.domain.Car

/**
 * Handles the output display for the racing car game.
 * This class is responsible for formatting and printing the race results.
 */
object OutputView {
    /**
     * Prints the race results for a single round.
     *
     * @param round The current round number
     * @param cars The list of cars participating in the race
     */
    fun printRaceResults(round: Int, cars: List<Car>) {
        printRaceResultsHeader(round)
        printCarPositions(cars)
        println()
    }

    /**
     * Prints the winner(s) of the race.
     *
     * @param winners The list of cars that won the race
     */
    fun printWinners(winners: List<Car>) {
        val winnerNames = formatWinnerNames(winners)
        println("$WINNERS_PREFIX : $winnerNames")
    }

    private fun printRaceResultsHeader(round: Int) {
        if (round == 1) {
            println("\n$RACE_RESULTS_HEADER")
        }
    }

    private fun printCarPositions(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.getPositionDisplay()}")
        }
    }

    private fun formatWinnerNames(winners: List<Car>): String {
        return winners.joinToString(", ") { it.name }
    }

    private const val RACE_RESULTS_HEADER = "Race Results"
    private const val WINNERS_PREFIX = "Winners"
}