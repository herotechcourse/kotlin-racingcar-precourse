package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

// Car class
class Car(val name: String) {
    // Current position of the car
    private var position: Int = 0

    init {
        validateName(name)
    }

    // Validate the car's name
    private fun validateName(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }
        if (name.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters.")
        }
    }

    /**
     * Move the car forward unconditionally
     * - Used in tests (e.g., repeat(n) { move() })
     */
    fun move() {
        position++
    }

    /**
     * Move the car forward only if the random number is 4 or higher
     * - Used in actual race
     */
    fun moveByRandom(randomNumber: Int = Randoms.pickNumberInRange(0, 9)) {
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getPosition(): Int = position
}

// Application entry point
object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        runCarRacing()
    }
}

// Main game logic
fun runCarRacing() {
    // 1) Get car names
    println("Enter the names of the cars (comma-separated):")
    val cars = createCars(Console.readLine())

    // 2) Get number of rounds
    println("How many rounds will be played?")
    val rounds = readRounds(Console.readLine())

    // 3) Start the race
    println("\nRace Results")
    repeat(rounds) {
        // Move each car by random
        cars.forEach { it.moveByRandom() }
        // Print current positions
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.getPosition())}")
        }
        println()
    }

    // 4) Determine and print the winners
    val maxPosition = cars.maxOfOrNull { it.getPosition() } ?: 0
    val winners = findWinners(cars, maxPosition)
    println("Winners : ${winners.joinToString(", ")}")
}

// Create car list and validate names
fun createCars(input: String): List<Car> {
    if (input.isBlank()) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }
    val names = input.split(",").map { it.trim() }
    if (names.any { it.isBlank() }) {
        throw IllegalArgumentException("Car name cannot be empty.")
    }
    if (names.distinct().size != names.size) {
        throw IllegalArgumentException("Car names cannot be duplicated.")
    }
    return names.map { Car(it) }
}

// Read and validate number of rounds
fun readRounds(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("Round number cannot be empty.")
    }
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("Round number must be a positive integer.")
    }
    val rounds = input.toInt()
    if (rounds <= 0) {
        throw IllegalArgumentException("Round number must be greater than 0.")
    }
    return rounds
}

// Return the list of winner names based on maxPosition
fun findWinners(cars: List<Car>, maxPosition: Int): List<String> {
    return cars
        .filter { it.getPosition() == maxPosition }
        .map { it.name }
}
