package racingcar.view

import racingcar.domain.Car
import racingcar.domain.RacingCars

object OutputView {

    fun printRaceStart() {
        println("\nRace Results")
    }

    fun printRound(racingCars: RacingCars) {
        racingCars.printRound()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}