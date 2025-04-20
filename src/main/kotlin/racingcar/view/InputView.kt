package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val userInput = Console.readLine()
        return parseCarNames(userInput)
    }

    fun parseCarNames(input: String): List<String> {
        val names = input.split(",")
        return validateCarNames(names)
    }

    fun validateCarNames(names: List<String>): List<String> {
        if (names.isEmpty()) {
            throw IllegalArgumentException("No names are entered.")
        }
        names.forEach { isNameNotBlankOrLessThanFive(it) }
        return names
    }

    fun isNameNotBlankOrLessThanFive(carName: String) {
        if (carName.isBlank() || carName.length > 5) {
            throw IllegalArgumentException("Car names must be between 1 and 5 characters. Input value: '$carName'")
        }
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val userInput = Console.readLine()
        val trimmedInput = userInput.trim()
        val count = convertRoundCount(trimmedInput)
        return validateRoundCount(count)
    }

    fun convertRoundCount(input: String): Int {
        val count =
            input.toIntOrNull() ?: throw IllegalArgumentException("The number of rounds should be a number.")
        return count
    }

    fun validateRoundCount(count: Int): Int {
        if (count <= 0) {
            throw IllegalArgumentException("The number of rounds must be a number greater than or equal to 1.")
        }
        return count
    }
}