package racingcar.view

import racingcar.domain.Car

object OutputView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
