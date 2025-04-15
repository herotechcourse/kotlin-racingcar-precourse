package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val cars = inputCars()
    val rounds = inputRounds()
    val leaderBoard = cars.associateWith { 0 }
}

fun inputRounds(): Int {
    println("How many rounds will be played?")
    val input = Console.readLine()
    return parsePositiveInt(input)
}

fun inputCars(): List<String> {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    return parseCarNames(input)
}

private fun parsePositiveInt(input: String): Int {
    val number = input.toIntOrNull()
    if (number != null && number > 0) {
        return number
    } else {
        throw IllegalArgumentException("Rounds should be a positive integer")
    }
}

private fun parseCarNames(input: String): List<String> {
    return input.split(",")
        .map {
            validateCarName(it)
        }
}

private fun validateCarName(key: String): String {
    if (key.length > 5 || key.isEmpty()) {
        throw IllegalArgumentException("Car name should be less than or equal to 5 characters and not empty")
    }
    return key
}