package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var cars: List<String> = emptyList()
var rounds: Int = 0
val carPositions: MutableMap<String, Int> = mutableMapOf()

fun main() {
    validateCarName()
    rounds = inputRoundCount()
    initializeCarPositions()
    repeat(rounds) {
        moveCars()
        displayRoundResults()
        println()
    }
    announceWinners()
    val finalResults = generateFinalResults()
    println(finalResults)
}

fun inputCarNames(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val cars = Console.readLine()
    return cars.split(",").map { it.trim() }
}

fun validateCarName() {
    cars = inputCarNames()
    for (i in cars) {
        if (i.length > 5) {
            throw IllegalArgumentException("Car name cannot be more than 5 characters")
        }
    }
    return
}

fun inputRoundCount(): Int {
    println("How many rounds will be played?")
    val rounds = Console.readLine()
    return rounds.toIntOrNull() ?: 0
}

fun initializeCarPositions() {
    for (car in cars) {
        carPositions[car] = 0
    }
}

fun movement(): Boolean {
    val randomValue = Randoms.pickNumberInRange(0, 9)
    return randomValue >= 4
}

fun moveCars() {
    for (car in cars) {
        if (movement()) {
            carPositions[car] = carPositions[car]!! + 1
        }
    }
}

fun displayRoundResults() {
    for ((car, position) in carPositions) {
        println("$car: ${"-".repeat(position)}")
    }
}

fun announceWinners() {
    val maxPosition = carPositions.values.maxOrNull() ?: 0
    val winners = carPositions.filter { it.value == maxPosition }.keys
    println("Winners: ${winners.joinToString(", ")}")
}

fun generateFinalResults(): List<String> {
    val results = mutableListOf<String>()

    // Add each car's result to the list
    for ((car, position) in carPositions) {
        results.add("$car : ${"-".repeat(position)}")
    }

    // Add the winners to the list
    val maxPosition = carPositions.values.maxOrNull() ?: 0
    val winners = carPositions.filter { it.value == maxPosition }.keys
    results.add("Winners : ${winners.joinToString(", ")}")

    return results
}