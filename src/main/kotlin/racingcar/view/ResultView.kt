package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}
