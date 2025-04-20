package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val input = Console.readLine()
    val carNames = input.split(",").map { it.trim() }

    val cars = try {
        carNames.map { Car(it) }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        throw e
    }

    // TEMP: Just to verify input works
    println("Cars entered:")
    cars.forEach { println(it.name) }

    // TODO: Ask for number of rounds
}
