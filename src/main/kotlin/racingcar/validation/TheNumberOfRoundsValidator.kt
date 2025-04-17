package racingcar.validation

import racingcar.constant.TheNumberOfRoundsError

fun validateTheNumberOfRounds(theNumberOfRounds: String): Boolean {
    if (!(theNumberOfRounds.matches("\\d".toRegex()))) {
        throw IllegalArgumentException(TheNumberOfRoundsError.INVALID_TYPE)
    }

    return true
}