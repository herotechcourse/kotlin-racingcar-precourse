package racingcar.util

import racingcar.constants.ErrorMessages
import racingcar.constants.MessageConstants
import racingcar.exception.InputValidationException

class CarNameValidator(private val names: List<String>) {

    fun validate(): List<String> {
        if (names.isEmpty()) {
            throw InputValidationException(ErrorMessages.EMPTY_NAME_LIST)
        }

        names.forEach { name ->
            if (name.isBlank()) {
                throw InputValidationException(ErrorMessages.BLANK_CAR_NAME)
            }
            if (name.length > MessageConstants.MAX_CAR_NAME_LENGTH) {
                throw InputValidationException(ErrorMessages.carNameTooLong(name))
            }
        }

        return names
    }
}
	