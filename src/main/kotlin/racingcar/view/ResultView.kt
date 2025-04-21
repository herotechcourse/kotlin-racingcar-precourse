package racingcar.view

import racingcar.domain.Car

object ResultView {
    private const val MOVE_SYMBOL = "-"
    private const val WINNER_SEPARATOR = ", "

    fun printRound(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${MOVE_SYMBOL.repeat(it.position)}")
        }

        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(WINNER_SEPARATOR)}")
    }
}