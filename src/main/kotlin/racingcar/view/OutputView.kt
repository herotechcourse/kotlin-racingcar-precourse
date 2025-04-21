package racingcar.view

import racingcar.constants.OutputMessages
import racingcar.dto.CarSnapshot

object OutputView {

    fun printResultIntro() {
        println(OutputMessages.RESULT)
    }

    fun printResults(roundSnapshot: List<CarSnapshot>) {
        roundSnapshot.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}