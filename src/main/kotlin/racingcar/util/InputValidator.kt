package racingcar.util

object InputValidator {

    fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) {
            "There must be at least one car name in input"
        }

        val trimmedNames = names.map { it.trim() }

        require(trimmedNames.none { it.isEmpty() }) {
            "Car names must not be blank or only spaces"
        }

        require(trimmedNames.all { it.length <= 5 }) {
            "Car names must be 1 to 5 characters"
        }

        require(trimmedNames.toSet().size == trimmedNames.size) {
            "Car names must be unique"
        }
    }

    fun validateRoundCount(input: String): Int {
        require(input.isNotBlank()) {
            "Input cannot be blank"
        }

        require(input.all { it.isDigit() }) {
            "Input must be a digit"
        }

        val count = input.toInt()
        require(count > 0) { "Round count must be positive number" }

        return count
    }
}