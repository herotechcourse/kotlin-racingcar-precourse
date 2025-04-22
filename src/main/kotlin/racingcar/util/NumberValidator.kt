package racingcar.util

import racingcar.constants.ErrorMessages
import racingcar.exception.InputValidationException

class NumberValidator(private val input: String) {

    fun validate(): Int {
        val number = input.toIntOrNull()
            ?: throw InputValidationException(ErrorMessages.INVALID_NUMBER)

        if (number <= 0) {
            throw InputValidationException(ErrorMessages.NON_POSITIVE_ROUND)
        }

        return number
    }
}