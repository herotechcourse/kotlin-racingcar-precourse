package racingcar.view

import racingcar.view.exception.InputMessage.EXCEED_INT_RANGE
import racingcar.view.exception.InputMessage.IS_NOT_NUMERIC

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
    if (input < Int.MIN_VALUE || input > Int.MAX_VALUE) {
        throw IllegalArgumentException(EXCEED_INT_RANGE)
    }
}