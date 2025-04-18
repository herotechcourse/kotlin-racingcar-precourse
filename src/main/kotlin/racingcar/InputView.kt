package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        if (names.any { it.length > 5 || it.isBlank() }) {
            throw IllegalArgumentException("Car names must be non-empty and up to 5 characters.")
        }

        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        return input.toIntOrNull()
            ?: throw IllegalArgumentException("Round count must be a valid number.")
    }
}
