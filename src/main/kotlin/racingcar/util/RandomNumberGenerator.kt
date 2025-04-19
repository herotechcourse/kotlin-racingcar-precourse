package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {

    private const val START_NUMBER = 0
    private const val END_NUMBER = 9

    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER)
    }
}