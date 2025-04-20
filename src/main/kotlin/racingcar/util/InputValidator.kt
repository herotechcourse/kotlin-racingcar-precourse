package racingcar.util

object InputValidator {

    fun validateCarNames(input: String): List<String> {
        val names = input.split(",").map { it.trim() }
        if (names.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("Each car name must be between 1 and 5 characters long and not empty.")
        }
        return names
    }

    fun validateNumberOfRounds(input: String): Int {
        val numberOfRounds = input.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid number of rounds")

        if (numberOfRounds <= 0) {
            throw IllegalArgumentException("Number of rounds must be positive")
        }
        return numberOfRounds
    }
}