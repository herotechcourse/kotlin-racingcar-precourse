package racingcar.io

import racingcar.model.Car

class OutputHandler {
    fun printRaceHeader() {
        println("\nRace Results")
    }
    
    fun printRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            val position = "-".repeat(car.getPosition())
            println("${car.name} : $position")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
} 