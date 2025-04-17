package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    validateCarNames(carNames)

    println("How many rounds will be played?")
    val roundCountInput = Console.readLine()
    val roundCount = parseRounds(roundCountInput)

    val cars = carNames.map { Car(it) }
    val game = RacingGame(cars)

    println("\nRace Results")
    repeat(roundCount) {
        game.playRound()
        game.printProgress()
        println()
    }

    val winners = game.findWinners()
    println("Winners : ${winners.joinToString(", ")}")
}

fun validateCarNames(carNames: List<String>) {
    if (carNames.isEmpty()) throw IllegalArgumentException("No car names provided.")

    carNames.forEach {
        if (it.isEmpty() || it.length > 5) {
            throw IllegalArgumentException("Car name must be non-empty and at most 5 characters: '$it'")
        }
    }
}

fun parseRounds(input: String): Int {
    return input.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Round count must be a positive integer.")
}

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            position++
        }
    }

    fun progress(): String = "-".repeat(position)
}

class RacingGame(private val cars: List<Car>) {

    fun playRound() {
        cars.forEach { it.move() }
    }

    fun printProgress() {
        cars.forEach {
            println("${it.name} : ${it.progress()}")
        }
    }

    fun findWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}
