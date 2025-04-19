package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printResultTitle() {
        println("Racing Result")
    }

    fun printRoundResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    fun printWinner(winner: List<String>) {
        println("${winner.joinToString(", ") + "is winner."}")
    }
}