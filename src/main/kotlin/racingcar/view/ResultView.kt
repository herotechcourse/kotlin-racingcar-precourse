package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printRace(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.drawPosition()}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("Winners : ${winners.joinToString(", ") { it.name }}")
    }
}