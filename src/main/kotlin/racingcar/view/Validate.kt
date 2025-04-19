package racingcar.view

class Validator {
    fun validateNames(names: List<String>): String? {
        if (names.any { it.isBlank() }) return INVALID_NAMES_BLANK
        if (names.any { it.length > 5 }) return INVALID_NAMES_LENGTH
        if (names.size < 2) return INVALID_NAMES_NUMBER
        if (names.size != names.toSet().size) return INVALID_NAMES_DUPLICATES
        return null
    }

    fun validateRounds(rounds: String): String? {
        val roundsInt = rounds.toIntOrNull() ?: return INVALID_ROUNDS
        if (roundsInt < 1) return INVALID_ROUNDS_MIN
        return null
    }

    companion object {
        const val INVALID_NAMES_BLANK = "Error: Car name cannot be blank"
        const val INVALID_NAMES_DUPLICATES = "Error: Car names duplicated"
        const val INVALID_NAMES_NUMBER = "Error: There should be at least two cars"
        const val INVALID_NAMES_LENGTH = "Error: Car name must be 5 characters or shorter"
        const val INVALID_ROUNDS = "Error: The number of rounds must be a digit"
        const val INVALID_ROUNDS_MIN = "Error: The number of rounds must be 1 or greater"
    }
}