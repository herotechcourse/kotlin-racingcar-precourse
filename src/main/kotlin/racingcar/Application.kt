package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    // Read car names from user input
    println("Enter the names of the cars (comma-separated, max 5 characters per name):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    // Validate car names
    carNames.forEach {
        if (it.isEmpty() || it.length > 5) {
            throw IllegalArgumentException("Car names must be non-empty and no more than 5 characters.")
        }
    }

    // Read number of rounds
    println("Enter the number of rounds:")
    val roundsInput = Console.readLine()
    val numberOfRounds = roundsInput.toIntOrNull()
        ?: throw IllegalArgumentException("Please enter a valid number.")

    // Create car objects
    val cars = carNames.map { Car(it) }

    // Run the race
    println("\nRace Results:")
    repeat(numberOfRounds) {
        cars.forEach { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moveForward()
            }
        }

        // Print results of this round
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
        println() // Blank line between rounds
    }

    // Determine winners (cars with the max position)
    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }

    // Print final winners in the format required by the test
    println("Winners : ${winners.joinToString(", ")}")
}

// Car class to store name and position
class Car(val name: String) {
    var position: Int = 0
        private set

    fun moveForward() {
        position++
    }
}

