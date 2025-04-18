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

    fun readRounds(): Int {
        println("How many rounds will be played?")

        val input: String
        try {
            input = Console.readLine()
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Input cannot be empty")
        }

        if (input.isNullOrBlank()) {
            throw IllegalArgumentException("Input cannot be empty")
        }

        val rounds: Int
        try {
            rounds = input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Number of rounds must be a positive integer")
        }

        if (rounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be a positive integer")
        }

        return rounds
    }
}
