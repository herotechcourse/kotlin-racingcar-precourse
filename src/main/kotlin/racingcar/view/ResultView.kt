package racingcar.view

import racingcar.domain.Car

object ResultView {
    fun printResultHeader() {
        println("\nRace Results")
    }

    fun printRound(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.getName()} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
