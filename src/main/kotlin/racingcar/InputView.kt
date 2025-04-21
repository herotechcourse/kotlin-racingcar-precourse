package racingcar

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val CAR_NAME_DELIMITER = ","

    fun readCarNames(): List<String> {
        println("Enter the names of the cars to race, separated by commas (,)")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
        val names = input.split(CAR_NAME_DELIMITER).map { it.trim() }
        validateCarNames(names)
        return names
    }

    fun readTryCount(): Int {
        println("How many rounds will the race last?")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
        return validateAndParseTryCount(input)
    }

    private fun validateCarNames(names: List<String>) {
        if (names.isEmpty() || names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car names cannot be blank or empty.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters.")
        }
        if (names.size != names.distinct().size) {
            throw IllegalArgumentException("Car names cannot be duplicated.")
        }
    }

    private fun validateAndParseTryCount(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("The number of rounds must be a number.")
        if (count <= 0) {
            throw IllegalArgumentException("The number of rounds must be greater than 0.")
        }
        return count
    }
}
