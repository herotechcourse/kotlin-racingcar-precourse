package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {

    fun generateNumber(): Int {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE)
    }

    companion object {
        private const val START_RANGE: Int = 0
        private const val END_RANGE: Int = 9
    }
}
