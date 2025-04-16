package racingcar.handler

import racingcar.model.Car

object OutputHandler {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun announceWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}
