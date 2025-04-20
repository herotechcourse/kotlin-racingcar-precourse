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

    fun validateDuplicateCarNames(carNameList: List<String>) {
        val distinctCount = carNameList.distinct().size
        if (distinctCount != carNameList.size) {
            throw IllegalArgumentException(RacingError.CAR_NAME_DUPLICATE.message)
        }
    }


    fun validateMinimumNumberOfCars(carNameList: List<String>) {
        if (carNameList.size < 2) {
            throw IllegalArgumentException(RacingError.INSUFFICIENT_CARS.message)
        }
    }
}