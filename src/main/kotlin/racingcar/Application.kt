package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val namesOfCars = readValidatedCarNames()
    val gameRounds = readValidatedGameRounds()

    val cars = namesOfCars.map { Car(it) }

    println("\nGame Results")
    repeat(gameRounds) {
        cars.forEach { it.moveCar() }
        printGameRound(cars)
    }

    val winners = determineWinners(cars)
    println("Winners : ${winners.joinToString(", ")}")
}

// --- Input Fns ---

fun readValidatedCarNames(): List<String> {
    println("Enter the names of the cars (separated by commas':")
    val namesOfCars = Console.readLine().split(",").map { it.trim() }

    if (namesOfCars.any { it.length > 5 }) {
        throw IllegalArgumentException("Name of car must not exceed 5 characters")
    }

    return namesOfCars
}

fun readValidatedGameRounds(): Int {
    println("How many rounds will be played?")
    val gameRounds = Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("Rounds must be a number")

    if (gameRounds <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0")
    }

    return gameRounds
}

// ---Logic that runs the game ---

fun determineWinners(cars: List<Car>): List<String> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }.map { it.name }
}

fun printGameRound(cars: List<Car>) {
    for (car in cars) {
        println("${car.name} : ${car.getGameProgress()}")
    }
    println()
}

// -----------Class for our Car ---

class Car(val name: String) {
    var position: Int = 0
        private set

    fun moveCar() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position++
        }
    }

    fun getGameProgress(): String {
        return "-".repeat(position)
    }
}
