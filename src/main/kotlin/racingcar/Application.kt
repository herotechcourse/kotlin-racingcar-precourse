package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in the racing game.
 */
data class Car(
    val name: String,
    var position: Int = 0
) {
    /**
     * Moves the car forward with a 60% chance (random number ≥ 4).
     */
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    /**
     * Returns a string of dashes corresponding to the current position.
     */
    fun progress(): String = "-".repeat(position)
}

/**
 * Main application for running the car racing game.
 */
class Application {
    fun run() {
        // Read and validate car names
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }
        if (carNames.isEmpty() || carNames.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Car names must be non-empty and at most 5 characters.")
        }

        // Read and validate number of rounds
        println("How many rounds will be played?")
        val rounds = Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("Invalid number of rounds.")
        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive.")
        }

        // Initialize cars
        val cars = carNames.map { Car(it) }

        // Execute race
        println("\nRace Results")
        repeat(rounds) {
            cars.forEach(Car::move)
            cars.forEach { println("${it.name} : ${it.progress()}") }
            println()
        }

        // Determine and display winners
        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }
        println("Winners : ${winners.joinToString(", ")}")
    }
}

/**
 * Entry point.
 */
fun main() {
    try {
        Application().run()
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
