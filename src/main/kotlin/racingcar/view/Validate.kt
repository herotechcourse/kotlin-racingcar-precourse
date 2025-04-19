package racingcar.view

class Validator {
    fun validateNames(names: List<String>) {
        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException(INVALID_NAMES_BLANK)
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException(INVALID_NAMES_LENGTH)
        }
        if (names.size < 2) {
            throw IllegalArgumentException(INVALID_NAMES_NUMBER)
        }
        if (names.size != names.toSet().size) {
            throw IllegalArgumentException(INVALID_NAMES_DUPLICATES)
        }
    }

    fun validateRounds(rounds: String) {
        val roundsInt = rounds.toIntOrNull()
        if (roundsInt == null)
            throw IllegalArgumentException(INVALID_ROUNDS)
        if (roundsInt < 2) {
            throw IllegalArgumentException(INVALID_ROUNDS_MIN)
        }
    }

    companion object {
        const val INVALID_NAMES_BLANK = "Error: Car name cannot be blank"
        const val INVALID_NAMES_DUPLICATES = "Error: Car names duplicated"
        const val INVALID_NAMES_NUMBER = "Error: There should be at least two cars"
        const val INVALID_NAMES_LENGTH = "Error: Car name must be 5 characters or shorter"
        const val INVALID_ROUNDS = "Error: The number of rounds must be a digit"
        const val INVALID_ROUNDS_MIN = "Error: The number of rounds must be greater than 1"
    }
}
