package racingcar

import camp.nextstep.edu.missionutils.Console


fun getCars(): List<String> {
    println("Please enter the names of the cars (comma separated):")
    val input = Console.readLine()
    return input.split(",").map { it.trim() }
}

fun getNumberOfRounds(): Int {
    println("Please enter the number of rounds:")
    val input = Console.readLine()
    // validate that the input is a number
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
}
