package racingcar.view

import racingcar.domain.Car

/**
 * Handles display output
 */
class OutputView {
    
    /**
     * Prints race results for each round
     * @param results Car status for all rounds
     */
    fun printResults(results: List<List<Car>>) {
        println("Race Results")
        
        results.forEach { cars ->
            cars.forEach { car ->
                printCarStatus(car)
            }
            println()
        }
    }
    
    /**
     * Prints status of a single car
     * @param car Car object
     */
    private fun printCarStatus(car: Car) {
        val position = "-".repeat(car.getPosition())
        println("${car.name} : $position")
    }
    
    /**
     * Prints winners
     * @param winners List of winners
     */
    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("Winners : $winnerNames")
    }
} 