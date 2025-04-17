package racingcar


object Validator {
    private const val MAX_NAME_LENGTH = 5
    private const val ERROR_EMPTY_NAMES = "At least one car name must be provided."
    private const val ERROR_BLANK_NAME = "Car name cannot be blank."
    private const val ERROR_NAME_TOO_LONG = "Car name cannot exceed $MAX_NAME_LENGTH characters."

    fun validateNames(names: List<String>) {
        validateNotEmpty(names)
        names.forEach { name ->
            validateNotBlank(name)
            validateNameLength(name)
        }
    }

    private fun validateNotEmpty(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException(ERROR_EMPTY_NAMES)
        }
    }

    private fun validateNotBlank(name: String) {
        if (name.isBlank()) {
            throw IllegalArgumentException(ERROR_BLANK_NAME)
        }
    }

    private fun validateNameLength(name: String) {
        if (name.length > MAX_NAME_LENGTH) {
            throw IllegalArgumentException("$ERROR_NAME_TOO_LONG (input: '$name')")
        }
    }
}