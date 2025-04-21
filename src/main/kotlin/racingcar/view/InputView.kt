package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Car names cannot be empty.")
        }
        return input.split(",").map { it.trim() }
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException("Input must be a number.")

        require(input > 0) {
            "Number of rounds must be a positive integer."
        }

        return input
    }
}