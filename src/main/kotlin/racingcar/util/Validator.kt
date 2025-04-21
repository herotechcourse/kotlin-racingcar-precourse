package racingcar.util

object Validator {
    fun validateCarNames(names: List<String>) {
        validateEmptyNames(names)
        validateNameLength(names)
        validateUniqueNames(names)
        validateNameFormat(names)
    }

    private fun validateEmptyNames(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException("Car names cannot be empty")
        }
    }

    private fun validateNameLength(names: List<String>) {
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car name cannot be longer than 5 characters")
        }
    }

    private fun validateUniqueNames(names: List<String>) {
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException("Car names must be unique")
        }
    }

    private fun validateNameFormat(names: List<String>) {
        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car name cannot be blank")
        }
        if (names.any { it.contains(",") }) {
            throw IllegalArgumentException("Car name cannot contain comma")
        }
    }

    fun validateRoundCount(input: String): Int {
        validateNumericInput(input)
        val number = input.toInt()
        validatePositiveNumber(number)
        return number
    }

    private fun validateNumericInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Round count cannot be blank")
        }
        if (!input.all { it.isDigit() }) {
            throw IllegalArgumentException("Invalid input. Please enter a valid number.")
        }
    }

    private fun validatePositiveNumber(number: Int) {
        if (number <= 0) {
            throw IllegalArgumentException("Round count must be greater than 0")
        }
    }
}