package racingcar.util

object InputValidator {

    fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) {
            "There must be at least one car name in input"
        }

        require(names.all { it == it.trim() && it.isNotEmpty() }) {
            "Car names must not be blank and must not have leading or trailing whitespace."
        }

        require(names.all { it.length <= 5 }) {
            "Each car name must be at most 5 characters long."
        }

        require(names.toSet().size == names.size) {
            "Car names must be unique."
        }
    }

    fun validateRoundCount(input: String): Int {
        require(input.isNotBlank()) {
            "Input cannot be blank"
        }

        val count = input.toIntOrNull()
            ?: throw IllegalArgumentException("Input must be a valid integer.")

        require(count > 0) { "Round count must be a positive number." }

        return count
    }
}