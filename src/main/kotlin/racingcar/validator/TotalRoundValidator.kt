package racingcar.validator

import racingcar.constant.ErrorMessage.TOTAL_ROUND_BLANK
import racingcar.constant.ErrorMessage.TOTAL_ROUND_NOT_NUMERIC
import racingcar.constant.ErrorMessage.TOTAL_ROUND_NOT_POSITIVE

object TotalRoundValidator {

    private const val MIN_TOTAL_ROUND = 1

    fun validate(totalRound: String) {
        requireNotBlank(totalRound)
        requireOnlyDigits(totalRound)
        requirePositive(totalRound)
    }

    private fun requireNotBlank(totalRound: String) {
        require(totalRound.isNotBlank()) { TOTAL_ROUND_BLANK }
    }

    private fun requireOnlyDigits(totalRound: String) {
        require(totalRound.all { it.isDigit() }) { TOTAL_ROUND_NOT_NUMERIC }
    }

    private fun requirePositive(totalRound: String) {
        require(totalRound.toInt() >= MIN_TOTAL_ROUND) { TOTAL_ROUND_NOT_POSITIVE }
    }
}