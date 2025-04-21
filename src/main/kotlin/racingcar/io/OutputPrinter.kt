package racingcar.io

import racingcar.constants.Constants

object OutputPrinter {
    fun printCarPosition(carName: String, position: Int) {
        val movement = Constants.MOVEMENT_SYMBOL.repeat(position)
        println("$carName : $movement")
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString("${Constants.DELIMITER} ")}")
    }

    fun printRoundSeparator() {
        println()
    }
}