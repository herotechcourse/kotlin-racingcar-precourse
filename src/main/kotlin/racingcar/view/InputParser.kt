package racingcar.view

class InputParser {
    fun parseCarNames(input: String): List<String> {
        validateEmptyInput(input)
        return input.split(",").map { it.trim() }
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("Input must not be empty.")
        }
    }
}
