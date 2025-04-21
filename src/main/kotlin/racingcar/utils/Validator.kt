package racingcar.utils

import racingcar.utils.Error.EMPTY_NAME
import racingcar.utils.Error.EMPTY_ROUND
import racingcar.utils.Error.MAXIMUM_CAR_LENGTH
import racingcar.utils.Error.MINIMUM_ROUND
import racingcar.utils.Error.NUMERIC_ROUND

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

    fun roundValidate(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(EMPTY_ROUND)
        }

        val round = input.toIntOrNull()
            ?: throw IllegalArgumentException(NUMERIC_ROUND)

        if (round <= Number.MINIMUM_ROUND_NUMBER) {
            throw IllegalArgumentException(MINIMUM_ROUND)
        }
    }
}