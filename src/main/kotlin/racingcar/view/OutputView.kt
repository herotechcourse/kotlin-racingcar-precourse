package racingcar.view

import racingcar.model.Car

object OutputView {

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { println(it) }
        println()
    }
}