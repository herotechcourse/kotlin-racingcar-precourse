package racingcar.engine

import racingcar.race.Race
import racingcar.car.Car

// Temp Class definition (For Testing purposes)
//data class Car(val name: String, var position: Int = 0)
//data class Race(val cars: List<Car>, val totalRounds: Int)

class GameEngine(private val race: Race, private val randomMovement: (Car) -> Unit) {

    //Create a Mutable list to save state
    private val roundResults = mutableListOf<List<Car>>()

    // Start the race for the given rounds
    fun startRace() {
        repeat(race.totalRounds) {
            race.cars.forEach { car ->
                randomMovement(car)
            }
            // Save the data of the current state of cars after this round
            val stateOfRounds = race.cars.map { it.copy() }
            roundResults.add(stateOfRounds)
        }
    }

    // Get the round results after the race has finished
    fun getRoundResults(): List<List<Car>> = roundResults
}
