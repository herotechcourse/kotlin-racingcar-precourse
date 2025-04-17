package racingcar.engine

import racingcar.car.Car
import racingcar.race.Race

import racingcar.results.CarResult

// Temp Class definition (For Testing purposes)
// data class Car(val name: String, var position: Int = 0)
// data class Race(val cars: List<Car>, val totalRounds: Int)
// data class CarResult(val name: String, val position: Int)

class GameEngine(private val race: Race, private val randomMovement: (Car) -> Unit) {

    //Create a Mutable list to save state
    private val roundResults = mutableListOf<List<CarResult>>()

    // Start the race for the given rounds
    fun startRace() {
        repeat(race.totalRounds) {
            race.cars.forEach { car ->
                randomMovement(car)
            }
            // Save the data of the current state of cars after this round
            val stateOfRounds = race.cars.map { CarResult(it.name, it.position) }
            roundResults.add(stateOfRounds)
        }
    }

    // Get the round results after the race has finished
    fun getRoundResults(): List<List<CarResult>> = roundResults

    // Companion object for Game Engine
    companion object {
        // Initialize Game Engine and start the race
        fun startGameEngine(cars: List<Car>, totalRounds: Int, randomMovement: (Car) -> Unit): GameEngine {

            // Create a race with a total number of rounds
            val race = Race(cars, totalRounds)

            // Create a GameEngine instance
            val gameEngine = GameEngine(race, randomMovement)

            // Start the race
            gameEngine.startRace()
            return gameEngine
        }
    }

}
