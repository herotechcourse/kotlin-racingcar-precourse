package racingcar.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    private const val MAX_NAME_LENGTH = 5

    fun readCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()?.trim()
            ?: throw IllegalArgumentException("[ERROR] Car name input cannot be null or blank.")

        val names = input.split(",").map { it.trim() }

        if (names.isEmpty()) {
            throw IllegalArgumentException("[ERROR] You must provide at least one car name.")
        }

        names.forEachIndexed { index, name ->
            if (name.isBlank()) {
                throw IllegalArgumentException("[ERROR] Car name at position ${index + 1} is blank. Blank names are not allowed.")
            }
            if (name.length > MAX_NAME_LENGTH) {
                throw IllegalArgumentException("[ERROR] Car name '${name}' exceeds the maximum length of $MAX_NAME_LENGTH characters.")
            }
        }

        return names
    }

    fun readRoundCount(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()?.trim()
            ?: throw IllegalArgumentException("[ERROR] Round count input cannot be null or blank.")

        val roundCount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Round count must be a valid number.")

        if (roundCount <= 0) {
            throw IllegalArgumentException("[ERROR] Round count must be greater than 0.")
        }

        return roundCount
    }
}
