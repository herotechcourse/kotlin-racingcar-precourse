package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.GameResult
import racingcar.model.GameRoundResult

class OutputView {

    companion object {
        private const val RUN_RESULT = "\nRace Results"
    }

    fun printRoundResult(gameResult: GameResult) {
        val roundResults = gameResult.getRoundResults()
        roundResults.forEach { printSingleRoundResult(it) }
    }

    private fun printSingleRoundResult(roundResult: GameRoundResult) {
        val cars = roundResult.getCars()
        cars.getCars().forEach { printCarProgress(it) }
        println()
    }

    private fun printCarProgress(car: Car) {
        print("${car.getName()} : ")
        println("-".repeat(car.getMoveCount()))
    }

    fun printResultNoticeMessage() {
        println(RUN_RESULT)
    }

    fun printWinner(winners: Cars) {
        val winnerNames = winners.getCars().joinToString(", ") { it.getName() }
        print("Winners : $winnerNames")
    }

    fun printErrorMessage(message: String) {
        System.err.println(message)
    }
}
