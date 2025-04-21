package racingcar.utils

import racingcar.utils.Error.EMPTY_NAME
import racingcar.utils.Error.MAXIMUM_CAR_LENGTH

object Validator {

    fun carValidate(carNames: List<String>) {
        if (carNames.isEmpty() || carNames.any{it.isBlank()}) {
            throw IllegalArgumentException(EMPTY_NAME)
        }

        for(car in carNames) {
            if (car.length > Number.MAXIMUM_NAME_LENGTH) {
                throw IllegalArgumentException(MAXIMUM_CAR_LENGTH)
            }
        }
    }
}