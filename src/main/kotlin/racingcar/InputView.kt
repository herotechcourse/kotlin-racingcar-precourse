package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (separated by commas):")
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
        println("Enter the number of attempts:")
        return Console.readLine().toIntOrNull()
            ?: throw IllegalArgumentException("The number of rounds must be a valid number.")
    }
}