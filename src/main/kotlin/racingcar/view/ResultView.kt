package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printRound(cars: List<Car>) {
        cars.forEach { car ->
            val track = "-".repeat(car.position)
            println("${car.name} : $track")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}