package racingcar.view

import racingcar.model.Car
import racingcar.model.Constants

object OutputView {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun printRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            val positionDisplay = Constants.POSITION_MARKER.repeat(n = car.getPosition())
            println("${car.name} : $positionDisplay")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnersNames = winners.joinToString(", ") {it.name}
        println("Winners : $winnersNames")
    }

    fun printError(message: String) {
        println(message)
    }
}