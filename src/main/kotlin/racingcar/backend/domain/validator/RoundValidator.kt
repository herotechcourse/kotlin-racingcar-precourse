package racingcar.backend.domain.validator

import racingcar.backend.exception.RacingError

object RoundValidator {
    fun validateRound(round: String) {
        try {
            round.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(RacingError.INVALID_ROUND.message)
        }
    }

    fun validatePositiveRound(round: Int){
        if(round < 1){
            throw IllegalArgumentException(RacingError.INVALID_ROUND.message)
        }
    }
}