package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.IllegalArgumentException

fun main() {
    val cars = readCarNamesFromConsole()
    val rounds = readRoundsFromConsole()
    performCarRace(cars, rounds)
    val winners = findWinners(cars)
}
fun readCarNamesFromConsole(): List<Car> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null")
    return parseCarNames(input)
}

fun parseCarNames(input: String): List<Car> {
    val names = input.split(",").map { it.trim() }
    if (names.any { it.isBlank() }) {
        throw IllegalArgumentException("Car names cannot be empty.")
    }
    return names.map { Car(it) }
}

data class Car(val name: String, var position: Int = 0) {
    init {
        validateName(name)
    }
}

fun validateName(name: String) {
    if (name.isBlank() || name.length > 5) {
        throw IllegalArgumentException("Car name must be non-empty and name cannot exceed 5 characters")
    }
}

fun readRoundsFromConsole(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val rounds = input.trim().toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number")
    if (rounds >= 0) return rounds else throw IllegalArgumentException("Rounds must be a positive number.")
}

fun performCarRace(cars: List<Car>, rounds: Int) {
    println("\nRace Results")
    repeat(rounds) {
        cars.forEach { moveCar(it) }
        cars.forEach { printCarProgress(it) }
        println()
    }
}
fun moveCar(car: Car) {
    if (shouldMove()) {
        car.position += 1
    }
}
fun printCarProgress(car: Car) {
    val progress = "-".repeat(car.position)
    println("${car.name} : $progress")
}
fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4

fun findWinners(cars: List<Car>): List<Car> {
    val maxPosition = cars.maxOf { it.position }
    return cars.filter { it.position == maxPosition }
}