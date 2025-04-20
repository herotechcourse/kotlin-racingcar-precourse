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

    println("How many rounds will be played?")
    val roundInput = Console.readLine()

    val rounds = try {
        val number = roundInput.toInt()
        require(number > 0) { "Number of rounds must be greater than 0." }
        number
    } catch (e: Exception) {
        println("Invalid input: ${e.message}")
        throw IllegalArgumentException("Invalid number of rounds.")
    }

    // TEMP output to test
    println("Rounds to play: $rounds")
}
