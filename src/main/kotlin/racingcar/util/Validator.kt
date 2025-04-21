package racingcar.util

import racingcar.domain.MAX_NAME_LENGTH
import racingcar.domain.MIN_CARS

object Validator {

    // Validates a single car name.
    fun validateName(name: String) {
        validateNotEmptyName(name)
        validateNameLength(name)
    }

    // Validates a list of car names.
    fun validateCars(names: List<String>) {
        require(names.size >= MIN_CARS) {
            "[ERROR] At least $MIN_CARS cars are required for the race."
        }
        validateUniqueCarNames(names)
        names.forEach { validateName(it) }
    }

    // Validates the number of the tries (must be a positive integer).
    fun validateTries(input: String?) {
        requireNotNull(input) { "[ERROR] Tries input cannot be null." }
        val number = input.toIntOrNull()

        require(number != null && number > 0) {
            "[ERROR] The number of tries must be a positive integer."
        }
    }

    // Private helper to check if a name is not empty or just whitespace.
    private fun validateNotEmptyName(name: String) {
        require(name.isNotBlank()) { "[ERROR] Car name cannot be empty or blank." }
    }

    // Private helper to check if a name does not exceed the maximum length
    private fun validateNameLength(name: String) {
        require(name.length <= MAX_NAME_LENGTH) {
            "[ERROR] Car name cannot exceed $MAX_NAME_LENGTH characters."
        }
    }

    // Private helper to check if all car names in the list are unique.
    private fun validateUniqueCarNames(names: List<String>) {
        val uniqueNames = names.toSet()
        require(uniqueNames.size == names.size) {
            "[ERROR] Car names must be unique."
        }
    }
}