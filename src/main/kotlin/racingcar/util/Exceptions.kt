package racingcar.util

import racingcar.util.Constant.CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE
import racingcar.util.Constant.CAR_NAME_EXCEED_ERROR_MESSAGE
import racingcar.util.Constant.MAX_CAR_NAME_SIZE
import racingcar.util.Constant.ROUND_COUNT_TYPE_ERROR_MESSAGE

object Exceptions {
    fun String.validateCarNameLength() = require(this.length <= MAX_CAR_NAME_SIZE) { CAR_NAME_EXCEED_ERROR_MESSAGE }
    fun String.validateNotBlank() = require(this.isNotBlank()) { CAR_NAME_CANNOT_BLANK_ERROR_MESSAGE }
    fun String.validateInteger() = require(this.toIntOrNull() != null) { ROUND_COUNT_TYPE_ERROR_MESSAGE }
}
