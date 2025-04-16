package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = readCarNames()
    val raceCount = readRaceCount()
    val cars = carNames.map { Car(it) }

    println("\nRace Results")
    repeat(raceCount) {
        cars.forEach { it.move(Randoms.pickNumberInRange(0, 9)) }
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }
}

fun readCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")
    val names = input.split(",").map { it.trim() }

    if (names.any { it.isEmpty() || it.length > 5 }) {
        throw IllegalArgumentException("Each name must be 1 to 5 characters long.")
    }

    return names
}

fun readRaceCount(): Int {
    println("How many rounds will be played?")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null")

    val number = input.toIntOrNull() ?: throw IllegalArgumentException("Must be a valid number.")
    if (number <= 0) {
        throw IllegalArgumentException("Must be a positive integer.")
    }

    return number
}
