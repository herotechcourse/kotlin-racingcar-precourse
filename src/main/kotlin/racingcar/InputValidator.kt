package racingcar

import camp.nextstep.edu.missionutils.Console

object InputValidator {

    private const val MAX_CAR_NAME_LENGTH = 5
    private const val MIN_ROUNDS = 1

    fun getValidCarNames(): List<String> {
        println("Enter the names of the cars (comma-separated):")
        val input = Console.readLine()
        return validateCarNamesInput(input)
    }

    fun getValidRoundsNumber(): Int {
        println("How many rounds will be played?")
        val input = Console.readLine()
        return validateRoundsInput(input)
    }

    fun validateCarNamesInput(input: String): List<String> {
        val carNames = input.split(",").map { it.trim() }
        carNames.forEach { validateCarName(it) }
        validateUniqueCarName(carNames)
        return carNames
    }

    fun validateRoundsInput(input: String): Int {
        val rounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Rounds must be a number between 0 and 9.")
        if (rounds < MIN_ROUNDS) {
            throw IllegalArgumentException("Rounds number must be greater than or equal to $MIN_ROUNDS.")
        }
        return rounds
    }

    private fun validateCarName(carName: String) {
        if (carName.length > MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException("Car names cannot exceed $MAX_CAR_NAME_LENGTH characters long.")
        }
        if (carName.isEmpty()) {
            throw IllegalArgumentException("Car name cannot be empty.")
        }
    }

    private fun validateUniqueCarName(carNames: List<String>) {
        val uniqueCarNames = carNames.toSet()
        if (uniqueCarNames.size != carNames.size) {
            throw IllegalArgumentException("Car names must be unique.")
        }
    }
}
