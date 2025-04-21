package racingcar.view

import racingcar.constants.ErrorMessages

object Validator {
    private const val MAX_CAR_NAME_LENGTH = 5
    private const val MIN_ROUND_COUNT = 1

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
            if (name.length > MAX_CAR_NAME_LENGTH) throw IllegalArgumentException(ErrorMessages.Name.CANNOT_BE_TOO_LONG)
        }
    }

    fun validateRounds(rounds: Int): Int {
        if (rounds < MIN_ROUND_COUNT) throw IllegalArgumentException(ErrorMessages.Round.MUST_BE_AT_LEAST_ONE)
        return rounds
    }
}