package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return input.split(",").map { name ->
            val trimmedName = name.trim()
            require(trimmedName.isNotEmpty() && trimmedName.length <= 5) {
                "Car names must be between 1 and 5 characters."
            }
            trimmedName
        }
    }

    fun readNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException()
    }
}