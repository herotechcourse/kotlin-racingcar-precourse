package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    private const val MIN_NUMBER_RANGE = 0
    private const val MAX_NUMBER_RANGE = 9
    fun generateRandomNumber(): Int {
        val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
        return randomNumber
    }
}