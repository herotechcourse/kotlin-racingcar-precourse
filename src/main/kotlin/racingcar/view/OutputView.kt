package racingcar.view

import racingcar.model.Car

object OutputView {
    fun showRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println(car.displayProgress())
        }
        println("\n")
    }

    fun showWinners(carNames: List<String>) {
        println("Winners : ${carNames.joinToString(", ")}")
    }
}