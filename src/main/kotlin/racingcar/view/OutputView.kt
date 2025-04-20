package racingcar.view

import racingcar.domain.Cars

class OutputView {

    fun showResultMessage() {
        println(RESULT_MESSAGE)
    }

    fun showEachRound(cars: Cars) {
        for (car in cars.cars) {
            println(RESULT_FORMAT.format(car.getName(), POSITION_SYMBOL.repeat(car.getPosition())))
        }
        println()
    }

    fun showWinner(winner: List<String>) {
        println(WINNER_MESSAGE + winner.joinToString(WINNER_SEPARATOR))
    }

    companion object {
        private const val RESULT_MESSAGE = "\nRace Results"
        private const val WINNER_MESSAGE = "Winners : "

        private const val RESULT_FORMAT = "%s : %s"
        private const val POSITION_SYMBOL = "-"
        private const val WINNER_SEPARATOR = ", "
    }
}
