package racingcar.view

import racingcar.view.exception.InputMessage.IS_BLANK
import racingcar.view.exception.InputMessage.IS_NOT_NUMERIC
import racingcar.view.exception.InputMessage.OUT_OF_VALID_RANGE

const val MINIMUM_RANGE = 1
const val MAXIMUM_RANGE = Int.MAX_VALUE

fun validateEmpty(input: String): String {
    require(input.isNotBlank()) { IS_BLANK }
    return input
}

fun parseAndValidateInt(input: String): Int {
    val numberInput = input.toLongOrNull()
    validateNumeric(numberInput)
    validateIntRange(numberInput!!)
    return input.toInt()
}

private fun validateNumeric(input: Long?) {
    if (input == null) {
        throw IllegalArgumentException(IS_NOT_NUMERIC)
    }
}

private fun validateIntRange(input: Long) {
    if (input < MINIMUM_RANGE || input > MAXIMUM_RANGE) {
        throw IllegalArgumentException(OUT_OF_VALID_RANGE)
    }
}