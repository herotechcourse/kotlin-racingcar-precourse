package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = inputCarNames()
    val tryCount = inputTryCount()

    val cars = carNames.map { Car(it) }
    val race = Race(cars, tryCount)

    println("\nRace Results")
    race.start()
    println("Winners : ${race.winners().joinToString(", ")}")
}

private fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = input.split(",").map { it.trim() }

    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Car names must be 1-5 characters long and not empty.")
    }
    if (names.size != names.toSet().size) {
        throw IllegalArgumentException("Duplicate car names are not allowed.")
    }
    return names
}

private fun inputTryCount(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    val count = input.toIntOrNull()
        ?: throw IllegalArgumentException("Input must be a valid integer.")

    if (count <= 0) {
        throw IllegalArgumentException("Number of rounds must be greater than 0.")
    }

    return count
}
