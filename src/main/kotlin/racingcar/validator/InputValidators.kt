package racingcar.validator

import racingcar.car.Messages
import racingcar.constants.Constants

object InputValidator {
    fun checkEmptyInput(input: String?) {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException(Messages.Error.EMPTY_INPUT)
        }
    }

    fun validateCarNames(carNames: List<String>) {
        checkMaxCarLimit(carNames)

        carNames.forEach { carName ->
            checkCarNameLength(carName)
            checkCarNameOnlyLetterAndNumber(carName)
        }
        checkDuplicateCarNames(carNames)
    }

    fun validateRoundCount(roundCount: String) {
        checkEmptyInput(roundCount)
        checkValidNumber(roundCount)
    }

    private fun checkMaxCarLimit(cars: List<String>) {
        if (cars.size > Constants.MAX_CAR_COUNT) {
            throw IllegalArgumentException(Messages.Error.MAX_CAR_LIMIT.format(Constants.MAX_CAR_COUNT))
        }
    }

    private fun checkCarNameLength(carName: String) {
        if (carName.length < Constants.MIN_CAR_NAME_LENGTH || carName.length > Constants.MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(
                Messages.Error.INVALID_CAR_NAME_LENGTH.format(
                    Constants.MIN_CAR_NAME_LENGTH,
                    Constants.MAX_CAR_NAME_LENGTH
                )
            )
        }
    }

    private fun checkCarNameOnlyLetterAndNumber(carName: String) {
        if (!carName.all { it.isLetterOrDigit() }) {
            throw IllegalArgumentException(Messages.Error.INVALID_CAR_NAME_FORMAT)
        }
    }

    private fun checkDuplicateCarNames(carNames: List<String>) {
        if (carNames.size != carNames.toSet().size) {
            throw IllegalArgumentException(Messages.Error.DUPLICATE_CAR_NAMES)
        }
    }

    private fun checkValidNumber(input: String) {
        val number = input.toIntOrNull()
        if (number == null || number <= 0) {
            throw IllegalArgumentException(Messages.Error.INVALID_ROUND_NUMBER)
        }
    }
}