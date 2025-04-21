package racingcar.presentation

import racingcar.presentation.ErrorMessages.ROUND_NOT_INTEGER

object RoundParser {

    fun parse(rawInput: String): Int =
        rawInput.toIntOrNull() ?: throw IllegalArgumentException(ROUND_NOT_INTEGER)
}
