package view

import racingcar.model.Car

class OutputView {
    fun printRoundResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : ${"-".repeat(car.position)}")    
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        println("Winners : ${winners.joinToString(", ")}")
    }
}