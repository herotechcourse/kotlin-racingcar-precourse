package racingcar.view

import racingcar.service.Car

object OutputView {
    fun printRaceIntro() {
        println("\nRace Results")
    }

    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}
