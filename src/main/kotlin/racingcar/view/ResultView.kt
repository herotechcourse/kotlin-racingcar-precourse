package racingcar.view

import racingcar.model.Car

object ResultView {
    fun printResultTitle() {
        println("\nRace Results")
    }

    fun printRoundResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}