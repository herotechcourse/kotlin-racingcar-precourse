package racingcar.util

import racingcar.model.Cars
import racingcar.model.Game
import racingcar.enums.ErrorMessage

object Validator {
    private const val VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$"
    private const val PRINTABLE_PATTERN = "\\p{Print}+"

    fun carNamesValidate(carNames: List<String>) {
        validateCarListSize(carNames)
        validateCarNames(carNames)
        checkForDuplicateNames(carNames)
    }

    private fun validateCarListSize(carNames: List<String>) {
        if (carNames.isEmpty() || carNames.size > Cars.MAX_CAR_COUNT) {
            throw IllegalArgumentException(ErrorMessage.ERR_INVALID_CAR_LIST.message)
        }
    }

    private fun validateCarNames(carNames: List<String>) {
        carNames.forEach { validateCarName(it) }
    }

    private fun validateCarName(carName: String?) {
        if (carName.isNullOrBlank()) {
            throw IllegalArgumentException(ErrorMessage.ERR_CAR_NAME_ISNULL.message)
        }
        if (carName.length > 5) {
            throw IllegalArgumentException(ErrorMessage.ERR_INVALID_CAR_NAME_LENGTH.message)
        }
        if (!Regex(VALID_NAME_PATTERN).matches(carName) || !Regex(PRINTABLE_PATTERN).matches(carName)) {
            throw IllegalArgumentException(ErrorMessage.ERR_CAR_NAME_CONTAIN_INVALID_CHARACTER.message)
        }
    }

    private fun checkForDuplicateNames(carNames: List<String>) {
        if (carNames.toSet().size < carNames.size) {
            throw IllegalArgumentException(ErrorMessage.ERR_NOT_ALLOW_DUPLICATED_NAME.message)
        }
    }

    fun gameRoundValidate(input: String?) {
        validateNullOrBlank(input)
        val number = parseToDouble(input!!)
        validatePositiveInteger(number)
        validateWithinMaxLimit(number)
    }

    private fun validateNullOrBlank(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(ErrorMessage.ERR_NOT_ALLOW_NUMBER_INPUT.message)
        }
    }

    private fun parseToDouble(input: String): Double {
        return input.toDoubleOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.ERR_INPUT_NUMBER_IS_NOT_VALID.message)
    }

    private fun validatePositiveInteger(number: Double) {
        if (number <= 0 || number != number.toInt().toDouble()) {
            throw IllegalArgumentException(ErrorMessage.ERR_NUMBER_MUST_BE_POSITIVE_NUMBER.message)
        }
    }

    private fun validateWithinMaxLimit(number: Double) {
        if (number > Game.MAX_GAME_ROUND) {
            throw IllegalArgumentException(ErrorMessage.ERR_NUMBER_CANT_OVER_MAX_LIMIT.message)
        }
    }
}
