package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomsWrapper {
    var provider: () -> Int = { Randoms.pickNumberInRange(0, 9) }
    fun next(): Int = provider()
}