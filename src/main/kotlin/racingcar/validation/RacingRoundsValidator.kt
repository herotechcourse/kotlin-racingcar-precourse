package racingcar.validation

import racingcar.constant.RacingRoundsError

fun validateRacingRounds(racingRound: String): Boolean {
    if (!(racingRound.matches("\\d+".toRegex()))) {
        throw IllegalArgumentException(RacingRoundsError.INVALID_TYPE)
    }

    return true
}