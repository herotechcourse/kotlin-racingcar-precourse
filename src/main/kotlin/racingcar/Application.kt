package racingcar

import kotlin.random.Random

fun main() {
    try {
        val carNames = inputCarNames()
        val numberOfRounds = inputNumberOfRounds()

        val cars = carNames.map { Car(it) }

        println("\nExecution Result")

        repeat(numberOfRounds) {
            cars.forEach { it.tryToMove() }
            cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
            println()
        }

        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
        println("Winners : $winners")

    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
        throw e
    }
}

// Input for car names
fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma separated):")
    val input = readLine() ?: throw IllegalArgumentException("No input provided.")
    val names = input.split(",").map { it.trim() }

    if (names.isEmpty() || names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each car must have a name and names must not exceed 5 characters.")
    }

    return names
}

// Input for number of rounds
fun inputNumberOfRounds(): Int {
    println("Enter the number of attempts:")
    val input = readLine()
    return input?.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Number of attempts must be a positive integer.")
}

// Car class
class Car(val name: String) {
    var position: Int = 0
        private set

    fun tryToMove() {
        val number = Random.nextInt(0, 10)
        if (number >= 4) {
            position++
        }
    }
}
