package racingcar.utils

import camp.nextstep.edu.missionutils.Console

object InputUtils {
    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")

        val input: String
        try {
            input = Console.readLine()
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Input cannot be empty")
        }

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Input cannot be empty")
        }

        val carNames = input.split(",")
        for (carName in carNames) {
            if (carName.isBlank()) {
                throw IllegalArgumentException("Car names cannot be empty")
            }
            if (carName.length > 5) {
                throw IllegalArgumentException("Car names cannot exceed 5 characters")
            }
        }

        return carNames
    }
}
