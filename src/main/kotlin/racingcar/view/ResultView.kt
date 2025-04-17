package racingcar.view

import racingcar.Car

object ResultView {
    fun printRoundResult(cars: List<Car>) {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }
}
