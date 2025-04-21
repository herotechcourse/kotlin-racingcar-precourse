package racingcar.io

import racingcar.model.Car

class OutputHandler {
    fun displayRaceHeader() {
        println("\nRace Results")
    }
    
    fun displayRoundResults(cars: List<Car>) {
        cars.forEach { car ->
            val position = "-".repeat(car.getPosition())
            println("${car.name} : $position")
        }
        println()
    }

    fun displayWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
} 