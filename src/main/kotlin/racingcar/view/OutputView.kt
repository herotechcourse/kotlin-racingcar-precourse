package racingcar.view

import racingcar.domain.Cars

class OutputView {

    private var isFirstRound = true

    fun printEachRound(cars: Cars) {
        printResultMessage()
        for (car in cars.cars) {
            println(RESULT_FORMAT.format(car.getName(), POSITION_SYMBOL.repeat(car.getPosition())))
        }
        println()
    }

    private fun printResultMessage() {
        if (isFirstRound) {
            println(PRINT_RESULT_MESSAGE)
            isFirstRound = false
        }
    }

    companion object {
        private const val PRINT_RESULT_MESSAGE = "\nRace Results"
        private const val RESULT_FORMAT = "%s : %s"
        private const val POSITION_SYMBOL = "-"
    }
}
