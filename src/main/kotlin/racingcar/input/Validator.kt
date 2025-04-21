package racingcar.input

import racingcar.constants.ErrorMessages

object Validator {
    fun validateNames(names: List<String>): List<String> {
        validateEmpty(names)
        validateLengthOfNames(names)
        return names
    }

    private fun validateEmpty(names: List<String>) {
        if (names.isEmpty()) throw IllegalArgumentException(ErrorMessages.Name.LIST_CANNOT_BE_EMPTY)
        for (name in names) {
            if (name.isBlank()) throw IllegalArgumentException(ErrorMessages.Name.CANNOT_BE_BLANK)
        }
    }

    private fun validateLengthOfNames(names: List<String>) {
        for (name in names) {
            if (name.length > 5) throw IllegalArgumentException(ErrorMessages.Name.CANNOT_BE_TOO_LONG)
        }
    }

    fun validateRounds(rounds: Int): Int {
        if (rounds < 1) throw IllegalArgumentException(ErrorMessages.Round.MUST_BE_AT_LEAST_ONE)
        return rounds
    }
}