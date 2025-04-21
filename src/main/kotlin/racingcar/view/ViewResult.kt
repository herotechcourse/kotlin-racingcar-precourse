package racingcar.view

import racingcar.domain.Car
import racingcar.domain.CarManager

object ViewResult {

    private fun showPosition(car: Car) {
        println("${car.name} : ${"-".repeat(car.position)}")
    }
    fun everyRoundResult(cars : List<Car>) {
        cars.forEach { showPosition(it) }
    }

    fun finalResult() {
        val winners = CarManager.winnerNames().joinToString(", ")
        print("Winners : $winners")
    }
}