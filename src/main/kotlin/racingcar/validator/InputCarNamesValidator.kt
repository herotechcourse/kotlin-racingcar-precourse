package racingcar.validator

import racingcar.exception.InputCarNamesExceptionMessage

class InputCarNamesValidator {

    fun validate(carNames: List<String>) {
        require(carNames.isNotEmpty()) {
            InputCarNamesExceptionMessage.BLANK_CAR_NAME.toString()
        }

        val seen = mutableSetOf<String>()

        carNames.forEach { name ->
            require(name.isNotBlank()) {
                InputCarNamesExceptionMessage.BLANK_CAR_NAME.toString()
            }

            require(name.length <= MAX_NAME_LENGTH) {
                InputCarNamesExceptionMessage.INVALID_CAR_NAME.toString()
            }

            require(!seen.contains(name)) {
                InputCarNamesExceptionMessage.DUPLICATED_CAR_NAME.toString()
            }

            seen.add(name)
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
