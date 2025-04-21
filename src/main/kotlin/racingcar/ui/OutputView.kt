package racingcar.ui

import racingcar.domain.Car

class OutputView {
    fun printRaceResults(cars: List<Car>) {
        //println("\nRace Results")
        cars.forEach { println(it) }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}