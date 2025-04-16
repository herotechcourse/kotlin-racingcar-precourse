package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun validateUniqueCarNames(names: List<String>) {
    if (names.toSet().size != names.size) {
        throw IllegalArgumentException("Car names must be unique.")
    }
}

fun validateCarNames(names: List<String>) {
    require(names.size >= 2) {
        "At least two cars are required to start the race."
    }

    validateUniqueCarNames(names)

    names.forEach { name ->
        require(name.length <= 5) {
            "Car name ($name) cannot exceed 5 characters"
        }
    }
}

fun validateRounds(rounds: String) {
    if (rounds.isBlank() || rounds.any { !it.isDigit() }) {
        throw IllegalArgumentException("Number of rounds must be a positive number.")
    }

    val value = rounds.toInt()
    if (value < 1) {
        throw IllegalArgumentException("Number of rounds must be at least 1.")
    }
}

fun splitInputToCarNames(input: String): List<String> {
    return input.split(",").map { it.trim() }
}

fun generateRandomNumber(): Int {
    return Randoms.pickNumberInRange(0, 9)
}

fun customPrint(raceData: MutableMap<String, MutableList<Int>>) {
    for ((car, progressList) in raceData) {
        val progress = progressList.joinToString("") { if (it == 1) "-" else "" }
        println("$car : $progress")
    }
    println("\n")
}

fun startRace(cars: List<String>, rounds: Int): MutableMap<String, MutableList<Int>> {
    val carMap = mutableMapOf<String, MutableList<Int>>()

    // Initialize each car's round data with 0s
    for (car in cars) {
        carMap[car] = MutableList(rounds) { 0 }
    }

    // Simulate each round
    for (i in 0 until rounds) {
        for (car in cars) {
            if (generateRandomNumber() >= 4) {
                carMap[car]?.set(i, 1) // Move forward in this round
            }
        }
        customPrint(carMap)
    }

    return carMap
}

fun getValidatedCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val names = splitInputToCarNames(input)
    validateCarNames(names)
    return names
}

fun inputRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    validateRounds(input)
    return input.toInt()
}

fun main() {
    try {
        val names = getValidatedCarNames()
        val rounds = inputRounds()
        val raceResults = startRace(names, rounds)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
