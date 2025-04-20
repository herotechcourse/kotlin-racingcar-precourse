package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

interface ValueGenerator {
    fun generateNumber(): Int
}

object RandomValueGenerator : ValueGenerator {
    override fun generateNumber(): Int = Randoms.pickNumberInRange(0, 9)
}

object TestMoveValueGenerator : ValueGenerator {
    override fun generateNumber(): Int = 9
}

object TestDoNotMoveValueGenerator : ValueGenerator {
    override fun generateNumber(): Int = 0
}