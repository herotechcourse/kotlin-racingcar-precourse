package racingcar.view

class InputParser {
    fun parseCarNames(input: String): List<String> {
        validateEmptyInput(input)
        return input.split(",").map { it.trim() }
    }

    fun parseNumberOfRounds(input: String): Int {
        validateEmptyInput(input)
        val trimmed = input.trim()
        validateMultipleInputs(trimmed)
        val numberOfRounds = trimmed.toIntOrNull()
            ?: throw IllegalArgumentException("The Round number input is not possible, not numbers.")
        validateGreaterThanZero(numberOfRounds)
        return numberOfRounds
    }

    private fun validateGreaterThanZero(numberOfRounds: Int) {
        if (numberOfRounds <= 0) {
            throw IllegalArgumentException("The round number input should be larger than zero.")
        }
    }

    private fun validateMultipleInputs(trimmed: String) {
        val tokens = trimmed.split(Regex("\\s+"))
        if (tokens.size > 1) {
            throw IllegalArgumentException("Only one number of rounds can be entered.")
        }
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Input must not be empty.")
        }
    }
}
