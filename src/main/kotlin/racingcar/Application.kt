package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun getCars(): List<String> {
    println("Please enter the names of the cars (comma separated):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }
}

fun getNumberOfRounds(): Int {
    println("Please enter the number of rounds:")
    val input = Console.readLine()
    if (!input.all { it.isDigit() }) {
        throw IllegalArgumentException("Invalid input")
    }
    return input.toInt()
}

fun getCarMovement(currentPosition: Int): Int {
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    return if (randomNumber >= 4) {
        currentPosition + 1
    } else {
        currentPosition
    }
}

fun playRound(cars: List<String>, carPositions: MutableMap<String, Int>, winners: MutableList<String>, maxPosition: Int): Int {
    for (car in cars) {
        val newPosition = getCarMovement(carPositions[car]!!)
        carPositions[car] = newPosition
        println("$car : ${"-".repeat(newPosition)}")
    }

    val currentMaxPosition = carPositions.values.maxOrNull() ?: 0
    if (currentMaxPosition > maxPosition) {
        winners.clear()
        winners.addAll(carPositions.filter { it.value == currentMaxPosition }.keys)
    }
    return currentMaxPosition
}

fun main() {
    val cars = getCars()
    val rounds = getNumberOfRounds()

    if (cars.isEmpty() || rounds <= 0) {
        throw IllegalArgumentException("Invalid input")
    }

    if (cars.any { it.length > 5 }) {
        throw IllegalArgumentException("Car names must be at most 5 characters")
    }

    val carPositions = cars.associateWith { 0 }.toMutableMap()
    var maxPosition = 0
    val winners = mutableListOf<String>()

    for (i in 1..rounds) {
        maxPosition = playRound(cars, carPositions, winners, maxPosition)
    }

    println("Winners : ${winners.joinToString(", ")}")
}
