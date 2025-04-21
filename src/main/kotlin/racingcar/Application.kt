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
    val maxPosition = 0
    val winners = mutableListOf<String>()

    for (i in 1..rounds) {
        for (car in cars) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                carPositions[car] = carPositions[car]!! + 1
                println("$car : ${"-".repeat(carPositions[car]!!)}")
            } else {
                println("$car : ")
            }
        }

        val currentMaxPosition = carPositions.values.maxOrNull() ?: 0
        if (currentMaxPosition > maxPosition) {
            winners.clear()
            winners.addAll(carPositions.filter { it.value == currentMaxPosition }.keys)
        }
    }

    println("Winners : ${winners.joinToString(", ")}")
}
