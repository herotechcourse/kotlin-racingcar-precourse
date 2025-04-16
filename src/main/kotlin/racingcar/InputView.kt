package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {

    fun parseCarNamesInput(carNamesInput: String): List<String> {
        val names = carNamesInput.split(",").map { it.trim() }

        if (names.isEmpty()) throw IllegalArgumentException("At least one car name must be provided")

        names.forEach{
            if (it.isEmpty()) throw IllegalArgumentException("Cars name cannot be empty")
            if (it.length > 5) throw IllegalArgumentException("Car names cannot exceed 5 characters. Car '$it' has ${it.length} characters")
        }
        return names
    }

    fun readCarNamesInput(): String {
        println("Enter the names of the cars (comma-separated):")
        return Console.readLine()
    }

    fun readAndParseRoundCountInput(): Int {

        println("Number of rounds:")
        val roundCount = Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("Please enter a valid positive number")
        if (roundCount<=0) throw IllegalArgumentException("Number of rounds must be positive")
        return roundCount

    }
}