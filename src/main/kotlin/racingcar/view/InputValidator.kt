package racingcar.view

object InputValidator {
    private const val MAX_NAME_LENGTH = 5

    fun validateCarNames(input: String?): List<String> {
        require(!input.isNullOrBlank()) {
            "Car names cannot be empty."
        }
        val names = input.split(",").map { it.trim() }

        require(names.all { it.isNotBlank() && it.length <= MAX_NAME_LENGTH }) {
            "Each car name must be non-blank and not exceed $MAX_NAME_LENGTH characters."
        }
        return names
    }

    fun validateRoundInput(input: String?): Int {
        val number = input?.toIntOrNull()
            ?: throw IllegalArgumentException("Input must be a number.")

        require(number > 0) {
            "Number of rounds must be a positive integer."
        }
        return number
    }
}
