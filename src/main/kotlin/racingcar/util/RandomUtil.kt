package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomUtil {
    private const val MOVE_THRESHOLD = 4

    fun shouldMove(): Boolean {
        val number = Randoms.pickNumberInRange(0, 9)
        return number >= MOVE_THRESHOLD
    }
}