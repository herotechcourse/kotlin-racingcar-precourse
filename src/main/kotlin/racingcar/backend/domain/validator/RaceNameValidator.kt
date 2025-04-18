package racingcar.backend.domain.validator

import racingcar.backend.exception.RacingError

object RaceNameValidator {
    fun validateCarNameIsBlank(carName: String) {
        if (carName.isBlank()) {
            throw IllegalArgumentException(RacingError.CAR_NAME_BLANK.message)
        }
    }

    fun validateCarNameLength(carName: String) {
        if (carName.length > 5) {
            throw IllegalArgumentException(RacingError.CAR_NAME_TOO_LONG.message)
        }
    }
}