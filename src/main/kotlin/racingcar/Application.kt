package racingcar

import racingcar.model.Car
import racingcar.model.Race

import racingcar.engine.GameEngine

//import racingcar.engine.Car
//import racingcar.engine.Race

fun main() {

    println("Racing Car App Starting...")

    // Create a list of cars
    val cars = listOf(Car("Car A"), Car("Car B"))

    // Create a race with a total number of rounds
    val race = Race(cars = cars, totalRounds = 5)

    // Temp Movement strategy (For Testing)
    val randomMovement: (Car) -> Unit = { car ->
        car.position += 1  // Increment position by 1
    }

    // Create a GameEngine instance
    val gameEngine = GameEngine(race, randomMovement)

    // Start the race
    gameEngine.startRace()

    // Get the Rounds results
    val results = gameEngine.getRoundResults()

    // Print results ( For Testing Purposes )
    results.forEachIndexed { roundIndex, round ->
        println("Round ${roundIndex + 1}:")
        round.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println()
    }

}