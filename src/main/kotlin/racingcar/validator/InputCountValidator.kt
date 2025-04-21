package racingcar.validator

import racingcar.exception.InputCountExceptionMessage

class InputCountValidator {

    fun validate(tryCount: String) {
        isNotBlankTryCount(tryCount)
        isPossibleConvertNumber(tryCount)
        isValidScope(tryCount)

        val parsedCount = tryCount.toInt()
        isAboveMinimumTryCount(parsedCount)
    }

    private fun isNotBlankTryCount(tryCount: String) {
        require(tryCount.isNotBlank()) {
            InputCountExceptionMessage.BLANK_COUNT.toString()
        }
    }

    private fun isPossibleConvertNumber(tryCount: String) {
        require(tryCount.matches(Regex("\\d+"))) {
            InputCountExceptionMessage.IMPOSSIBLE_CONVERT_NUMBER.toString()
        }
    }

    private fun isValidScope(tryCount: String) {
        try {
            tryCount.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(InputCountExceptionMessage.INVALID_INTEGER_SCOPE.toString())
        }
    }

    private fun isAboveMinimumTryCount(tryCount: Int) {
        require(tryCount >= MINIMUM_TRY_COUNT) {
            InputCountExceptionMessage.UNDER_MINIMUM_COUNT.toString()
        }
    }

    companion object {
        private const val MINIMUM_TRY_COUNT = 1
    }
}
