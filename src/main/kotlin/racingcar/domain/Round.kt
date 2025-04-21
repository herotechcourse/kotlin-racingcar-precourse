package racingcar.domain

import racingcar.domain.ErrorMessages.ROUND_LESS_THAN_ONE

class Round(val round: Int) {

    init {
        if (round < 1) {
            throw IllegalArgumentException(ROUND_LESS_THAN_ONE)
        }
    }
}
