package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object RandomUtil {
    fun generate(): Int = Randoms.pickNumberInRange(0, 9)
}