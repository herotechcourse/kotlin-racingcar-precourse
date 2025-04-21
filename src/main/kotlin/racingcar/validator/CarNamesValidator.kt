package racingcar.validator

import racingcar.constant.ErrorMessage.CAR_NAME_BLANK
import racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATE
import racingcar.constant.ErrorMessage.CAR_NAME_TOO_LONG
import racingcar.constant.ErrorMessage.MINIMUM_CAR_COUNT

object CarNamesValidator {

    fun validate(carNames: List<String>) {
        requireMinimumCarCount(carNames)
        requireNoBlankNames(carNames)
        requireNoDuplicateNames(carNames)
        requireNameLengthLimit(carNames)
    }

    private fun requireMinimumCarCount(carNames: List<String>) {
        require(carNames.size >= 2) {
            MINIMUM_CAR_COUNT
        }
    }

    private fun requireNoBlankNames(carNames: List<String>) {
        require(carNames.none { it.isBlank() }) {
            CAR_NAME_BLANK
        }
    }

    private fun requireNoDuplicateNames(carNames: List<String>) {
        require(carNames.distinct().size == carNames.size) {
            CAR_NAME_DUPLICATE
        }
    }

    private fun requireNameLengthLimit(carNames: List<String>) {
        require(carNames.all { it.length <= 5 }) {
            CAR_NAME_TOO_LONG
        }
    }
}