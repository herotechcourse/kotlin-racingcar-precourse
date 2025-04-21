package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printRaceResult(histories: List<List<RacingCar>>, winners: List<String>) {
        println("\nRace Results")
        printHistories(histories)
        printWinners(winners)
    }

    private fun printHistories(histories: List<List<RacingCar>>) {
        histories.forEach {
            printRoundProgress(it)
        }
    }

    private fun printRoundProgress(history: List<RacingCar>) {
        history.forEach {
            println("${it.name} : " + "-".repeat(it.progress))
        }
        println()
    }

    private fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
