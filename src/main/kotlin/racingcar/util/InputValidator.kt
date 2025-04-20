package racingcar.util

object InputValidator {

    fun validateCarName(names: List<String>) {
        if (names.isEmpty()) {
            throw IllegalArgumentException("Car name input cannot be empty.")
        }

        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException("Car names must not be blank.")
        }

        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("Car names must be 5 characters or fewer.")
        }

        if (names.size != names.toSet().size) {
            throw IllegalArgumentException("Duplicate car names are not allowed.")
        }

        if (names.any { it != it.trim() }) {
            throw IllegalArgumentException("Car name must not contain leading or trailing whitespace.")
        }
    }

    fun validateRounds(rounds: String): Int {
        val number = rounds.toIntOrNull()
            ?: throw IllegalArgumentException("Number of rounds must be a valid integer.")

        if (rounds.isBlank()) {
            throw IllegalArgumentException("Number of rounds cannot be empty")
        }

        if (number <= 0) {
            throw IllegalArgumentException("Number of rounds must be greater than 0.")
        }

        return number
    }
}