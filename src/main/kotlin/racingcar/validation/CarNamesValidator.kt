package racingcar.validation

import racingcar.constant.CarNamesError

fun validateCarNames(carNames: List<String>): Boolean {
    if (carNames.size == 1) {
        throw IllegalArgumentException(CarNamesError.INVALID_NAME_COUNT)
    }

    if (carNames.distinct().size != carNames.size) {
        throw IllegalArgumentException(CarNamesError.DUPLICATION_NOT_ALLOWED)
    }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException(CarNamesError.INVALID_NAME_LENGTH)
    }

    return true
}