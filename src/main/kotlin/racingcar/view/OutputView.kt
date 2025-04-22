package racingcar.view

import racingcar.constants.MessageConstants
import racingcar.model.Car

object OutputView {

    fun printRaceStatus(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${it.getProgress()}") }
        println()
    }

    fun printWinners(winnerNames: List<String>) {
        println("${MessageConstants.MESSAGE_WINNER_ANNOUNCEMENT}${winnerNames.joinToString(", ")}")
    }
}
