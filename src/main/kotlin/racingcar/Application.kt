package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

// The main function where the program starts
fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = parseCarNames(carNamesInput)

    println("How many rounds will be played?")
    val roundsInput = Console.readLine()
    val rounds = parseRounds(roundsInput)

    val cars = carNames.map { Car(it) }

    println("\nRace Results")
    repeat(rounds) {
        cars.forEach { it.move() }
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }

    val maxPosition = cars.maxOf { it.position }
    val winners = cars.filter { it.position == maxPosition }.map { it.name }

    println("Winners : ${winners.joinToString(", ")}")
}

// Function to parse and validate car names
fun parseCarNames(input: String): List<String> {
    val names = input.split(",").map { it.trim() }
    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be 1 to 5 characters long.")
    }
    return names
}

// Function to parse and validate number of rounds
fun parseRounds(input: String): Int {
    return input.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Rounds must be a positive integer.")
}

// Car class with name and position
class Car(val name: String) {
    var position = 0

    // Move the car forward if random number is >= 4
    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            position++
        }
    }
}
