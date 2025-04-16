package racingcar.handler

import camp.nextstep.edu.missionutils.Console

object InputHandler {
    fun getValidatedCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine().trim()
        require(input.isNotBlank()) { "Car names cannot be blank." }

        val names = input.split(",").map { it.trim() }
        require(names.all { it.length in 1..5 }) { "Each car name must be 1-5 characters long." }

        return names
    }

    fun getValidatedRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("Input must be a number.")
        require(count > 0) { "Round count must be a positive integer." }

        return count
    }
}
