package racingcar

import camp.nextstep.edu.missionutils.Randoms

object Movement {
    private const val MOVING_FORWARD: Int = 4
    fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MOVING_FORWARD
    }
}
