package racingcar.view

import racingcar.domain.race.Cars

class OutputView {

    fun showResult(allRoundCars: List<Cars>) {
        println(RESULT_MESSAGE)
        allRoundCars.forEach { showEachRound(it) }
    }

    private fun showEachRound(cars: Cars) {
        cars.cars.forEach { println(RESULT_FORMAT.format(it.getName(), POSITION_SYMBOL.repeat(it.getPosition()))) }
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
