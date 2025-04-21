package racingcar.view

import racingcar.model.Car

open class OutputView {
    open fun printRaceHeader() {
        println("\nRace Results")
    }
    
    open fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            val positionMarkers = "-".repeat(car.position)
            println("${car.name} : $positionMarkers")
        }
        println()
    }
    
    open fun printWinners(winners: List<Car>) {
        // Check if there are duplicate names among winners
        val hasDuplicateNames = winners.map { it.name }.distinct().size < winners.size
        
        val winnerNames = if (hasDuplicateNames) {
            // If there are duplicates, include the ID to differentiate
            winners.joinToString(", ") { "${it.name}(${it.id})" }
        } else {
            // Otherwise, use the original format with just names
            winners.joinToString(", ") { it.name }
        }
        
        println("Winners : $winnerNames")
    }
}
