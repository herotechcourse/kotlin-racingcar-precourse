package racingcar.util

import racingcar.util.Constant.ROUND_COUNT_TYPE_ERROR_MESSAGE

object Exceptions {
    fun String.validateInteger() = require(this.toIntOrNull() != null) { ROUND_COUNT_TYPE_ERROR_MESSAGE }
}
