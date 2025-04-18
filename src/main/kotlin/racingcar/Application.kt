package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException

fun main() {
    val cars = readCarNamesFromConsole()
    val rounds = readRoundsFromConsole()
}
fun readCarNamesFromConsole(): List<Car> {
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
    val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val rounds = input.trim().toIntOrNull() ?: throw IllegalArgumentException("Rounds must be a number")
    return if (rounds >= 0) return rounds else throw IllegalArgumentException("Rounds must be a positive number.")
}
