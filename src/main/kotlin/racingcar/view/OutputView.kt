package racingcar.view

import racingcar.model.Car

class OutputView {
    fun printRaceHeader() {
        println("\nRace Results")
    }
    
    fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            val positionMarkers = "-".repeat(car.position)
            println("${car.name} : $positionMarkers")
        }
        println()
    }
    
    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
}
