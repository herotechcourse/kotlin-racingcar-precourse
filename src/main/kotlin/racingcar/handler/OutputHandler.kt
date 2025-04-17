package racingcar.handler

import racingcar.model.Car

object OutputHandler {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun announceWinners(winners: List<Car>) {
        if (winners.isEmpty()) {
            println("Winners : none")
            return
        }
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}
