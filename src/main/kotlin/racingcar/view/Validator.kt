package racingcar.view

import racingcar.exception.ExceptionMessage

object Validator {
    private const val MAX_CAR_COUNT = 100
    private const val MAX_ROUND_COUNT = 500
    private val validCarNameRegex = Regex("^[a-zA-Z0-9]+$")

    fun validateCarNames(carNames: List<String>) {
        if (hasEmptyOrBlank(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.EMPTY_CAR_NAME.message)
        }

        if (hasWhitespace(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.CAR_NAME_WITH_WHITESPACE.message)
        }

        if (exceedsMaxLength(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.TOO_LONG_CAR_NAME.message)
        }

        if (hasDuplicate(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.DUPLICATE_CAR_NAME.message)
        }

        if (containsInvalidCharacters(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_CHARACTER_IN_CAR_NAME.message)
        }

        if (exceedsMaxCount(carNames)) {
            throw IllegalArgumentException(ExceptionMessage.EXCEED_MAX_CAR_COUNT.message)
        }
    }

    fun validateRoundCount(roundCount: Int) {
        if (isNotPositive(roundCount)) {
            throw IllegalArgumentException(ExceptionMessage.INVALID_ROUND_COUNT.message)
        }

        if (exceedsMaxRoundCount(roundCount)) {
            throw IllegalArgumentException(ExceptionMessage.EXCEED_MAX_ROUND_COUNT.message)
        }
    }

    private fun hasEmptyOrBlank(names: List<String>) =
        names.isEmpty() || names.any { it.isBlank() }

    private fun hasWhitespace(names: List<String>) =
        names.any { it.contains(" ") }

    private fun exceedsMaxLength(names: List<String>) =
        names.any { it.length > 5 }

    private fun hasDuplicate(names: List<String>) =
        names.toSet().size != names.size

    private fun containsInvalidCharacters(names: List<String>) =
        names.any { !validCarNameRegex.matches(it) }

    private fun exceedsMaxCount(names: List<String>) =
        names.size > MAX_CAR_COUNT

    private fun isNotPositive(count: Int) =
        count <= 0

    private fun exceedsMaxRoundCount(count: Int) =
        count > MAX_ROUND_COUNT
}