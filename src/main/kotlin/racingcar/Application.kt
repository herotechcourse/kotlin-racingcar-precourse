package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// Interface to abstract input handling, making the code testable and flexible
interface InputHandler {
    fun readLine(): String
}

// Implementation of InputHandler that reads input from the console
class ConsoleInputHandler : InputHandler {
    override fun readLine(): String {
        return Console.readLine()
    }
}

// Default implementation of RandomNumberGenerator that uses the Randoms utility
class DefaultRandomNumberGenerator : RandomNumberGenerator {
    override fun generate(min: Int, max: Int): Int {
        return Randoms.pickNumberInRange(min, max)
    }
}

// Interface to abstract random number generation, making the code testable and flexible
interface RandomNumberGenerator {
    fun generate(min: Int, max: Int): Int
}

data class Car(val name: String, var position: Int = 0) {
    fun move(randomNumber: Int) {
        if (randomNumber >= 4) {
            position++
        }
    }
}

// simulateRace helps to simulate the car race
fun simulateRace(cars: List<Car>, rounds: Int, generator: RandomNumberGenerator) {
    repeat(rounds) { round ->
        moveCars(cars, generator)
        displayProgress(cars) // Display progress after each round
        println()
    }
}

// Extracted function to handle car movement
fun moveCars(cars: List<Car>, generator: RandomNumberGenerator) {
    cars.forEach { car ->
        val randomNumber = generateRandomNumber(generator)
        car.move(randomNumber)
    }
}

// Extracted function to generate a random number
fun generateRandomNumber(generator: RandomNumberGenerator): Int {
    return generator.generate(0, 9)
}

// displayProgress prints the final result for now, to be updated in the
// progress display feature
fun displayProgress(cars: List<Car>) {
    cars.forEach { car ->
        println("${car.name} : ${"-".repeat(car.position)}")
    }
}

// Function to determine the winners based on their positions
fun determineWinners(cars: List<Car>): String {
    val maxPosition = cars.maxOf { it.position }

    val winners = cars.filter { it.position == maxPosition }.map { it.name }
    return winners.joinToString(", ")
}

fun main() {
    // Create an instance of ConsoleInputHandler to handle user input
    val inputHandler = ConsoleInputHandler()
    // Create an instance of DefaultRandomNumberGenerator to generate random numbers
    val randomNumberGenerator = DefaultRandomNumberGenerator()

    try {
        // Step 1: Input Handling
        // Get car names and number of rounds from the user
        val carNames = getCarNames(inputHandler)
        val rounds = getNumberOfRounds(inputHandler)

        // Step 2: Initialize Cars
        val cars = carNames.map { Car(it) }
        println()
        // Step 3,4: Simulate the Race
        // Display Progress
        println("Race Results")
        simulateRace(cars, rounds, randomNumberGenerator)

        // Step 5: Determine and display the winners
        val winners = determineWinners(cars)
        println("Winners : $winners")
    } catch (e: IllegalArgumentException) {
        // Handle invalid input by displaying an error message
        println("Error: ${e.message}")
        throw e // Re-throw the exception for testing purposes
    }
}

// Function to get and validate car names from the user
fun getCarNames(inputHandler: InputHandler): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val carNames = inputHandler.readLine().split(",").map { it.trim() }

    // Validate that each car name is non-empty and at most 5 characters long
    if (carNames.any { it.isEmpty() }) {
        throw IllegalArgumentException("Car names must not be empty.")
    }
    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be at most 5 characters long.")
    }

    // Validate that all car names are unique
    if (carNames.size != carNames.toSet().size) {
        throw IllegalArgumentException("Car names must be unique.")
    }

    return carNames
}

// Function to get and validate the number of rounds from the user
fun getNumberOfRounds(inputHandler: InputHandler): Int {
    println("How many rounds will be played?")
    val rounds = inputHandler.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")
    // Validate that the number of rounds is greater than 0
    if (rounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }
    return rounds
}