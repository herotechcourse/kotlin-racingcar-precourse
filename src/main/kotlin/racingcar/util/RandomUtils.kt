package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomUtils {
    fun randomNumber(start: Int, end: Int): Int = Randoms.pickNumberInRange(start, end)
}