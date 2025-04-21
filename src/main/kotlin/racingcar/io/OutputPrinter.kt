package racingcar.io

import racingcar.car.Messages
import racingcar.constants.Constants

object OutputPrinter {
    fun printCarPosition(carName: String, position: Int) {
        val movement = Constants.MOVEMENT_SYMBOL.repeat(position)
        println("$carName : $movement")
    }

    fun printWinners(winners: List<String>) {
        println("${Messages.Output.WINNERS_LABEL} ${winners.joinToString("${Constants.DELIMITER} ")}")
    }

    fun printRoundSeparator() {
        println()
    }

    fun printResultHeader() {
        println()
        println(Messages.Output.RESULT_TITLE)
    }
}