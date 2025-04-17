package racingcar.results

import racingcar.engine.CarResult
import racingcar.engine.GameEngine

class RaceResultPrinter(private val gameEngine: GameEngine) {

    // Initialize positions to an empty string for each car
    private fun initializeCarPositions(): MutableMap<String, String> {
        return mutableMapOf<String, String>().apply {
            gameEngine.cars.forEach { car -> this[car.name] = "" }
        }
    }

    // Update car positions based on the current round
    private fun updateCarPositions(round: List<CarResult>, carPositions: MutableMap<String, String>) {
        round.forEach { carResult ->
            carPositions[carResult.name] = "-".repeat(carResult.position)
        }
    }

    // Print the round results
    private fun printRoundResults(carPositions: MutableMap<String, String>) {
        // Print each car's position in the current round
        carPositions.forEach { (carName, position) ->
            println("$carName : $position")
        }
        println()
    }

    // Method to print the race results
    fun printRaceResults() {
        val roundResults = gameEngine.getRoundResults()

        // Initialize car positions
        val carPositions = initializeCarPositions()

        // Print the results for each round
        println("Race Results")
        roundResults.forEach { round ->
            updateCarPositions(round, carPositions)
            printRoundResults(carPositions)
        }
    }
}