package racingcar.view

import racingcar.model.Car

/**
 * Handles all output related to race progress and results.
 */
object OutputView {
    /**
     * Prints the current positions of all cars after each round.
     */
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }

    /**
     * Prints the names of the winning car(s) at the end of the race.
     */
    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}
