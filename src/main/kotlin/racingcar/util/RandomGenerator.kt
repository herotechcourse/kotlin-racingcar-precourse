package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {
    fun generate(): Int = Randoms.pickNumberInRange(0, 9)
}