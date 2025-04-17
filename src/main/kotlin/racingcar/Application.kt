package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    try {
        val cars = readCarNames()
        val rounds = readRoundCount()

        println("\nRace Results")

        repeat(rounds) {
            cars.forEach { car ->
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    car.moveForward()
                }
            }
            cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
            println()
        }

        val maxPosition = cars.maxOf { it.position }
        val winners = cars.filter { it.position == maxPosition }.map { it.name }

        println("Winners : ${winners.joinToString(", ")}")
    } catch (e: IllegalArgumentException) {
        throw e
    }
}

fun readCarNames(): List<Car> {
    if (!isTestMode()) {
        println("Enter the names of the cars (comma-separated):")
    }
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if (names.any { it.isBlank() || it.length > 5 }) {
        throw IllegalArgumentException("Each car name must be 1–5 characters.")
    }

    return names.map { Car(it) }
}

fun readRoundCount(): Int {
    if (!isTestMode()) {
        println("How many rounds will be played?")
    }
    val input = Console.readLine()
    return input.toIntOrNull()?.takeIf { it > 0 }
        ?: throw IllegalArgumentException("Please enter a valid number of rounds (positive integer).")
}

fun isTestMode(): Boolean {
    return System.getProperty("user.dir")?.contains("build") == true
}

data class Car(val name: String, var position: Int = 0) {
    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Each car name must be 1–5 characters."
        }
    }

    fun moveForward() {
        position++
    }
}
