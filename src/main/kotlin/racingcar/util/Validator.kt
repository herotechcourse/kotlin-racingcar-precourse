package racingcar.util

object Validator {
    fun validateCarNames(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car name cannot be longer than 5 characters")
        }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException("Car names must be unique")
        }
    }

    fun validateRoundCount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException("Invalid input. Please enter a valid number.")
        if (number <= 0) {
            throw IllegalArgumentException("Round count must be greater than 0")
        }
        return number
    }
}