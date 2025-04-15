package racingcar

import camp.nextstep.edu.missionutils.Console

object InputHandler {

    fun readCarNames(): String {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        if (input.isNullOrBlank()) throw IllegalArgumentException("Input cannot be blank.")
        val names = input.split(",").map { it.trim() }
        if (names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1 to 5 characters.")
        }
        return input
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Input must be a valid integer.")
        if (rounds <= 0) throw IllegalArgumentException("Number of rounds must be positive.")
        return rounds
    }
}