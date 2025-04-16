package racingcar.model

import racingcar.exception.ExceptionMessage

data class CarName(val name: String) {
    init {
        require(name.isNotBlank()) { ExceptionMessage.EMPTY_CAR_NAME.message}
        require(name.length <= 5) { ExceptionMessage.TOO_LONG_CAR_NAME.message}
    }

    override fun toString(): String=name
}