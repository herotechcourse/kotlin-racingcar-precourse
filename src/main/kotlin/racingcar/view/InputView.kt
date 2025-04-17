package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return parseCarNames(input)
    }

    private fun parseCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }

        if (names.any { it.isBlank() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be 1-5 characters long")
        }

        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        return Console.readLine()?.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("Rounds must be a positive number")
    }

}