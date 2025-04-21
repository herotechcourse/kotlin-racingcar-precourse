package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }

        require(names.all { it.isNotBlank() && it.length <= 5 }) {
            "Car names must not be blank and must be 5 characters or less."
        }

        println(names.joinToString(", "))
        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()

        val roundCount = input.toIntOrNull() ?: throw IllegalArgumentException("Invalid number input.")
        println(roundCount)
        return roundCount
    }
}


