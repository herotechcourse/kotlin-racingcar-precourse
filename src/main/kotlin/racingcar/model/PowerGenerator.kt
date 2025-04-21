package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

fun interface PowerGenerator {
    fun generate(): Int
}

object RandomPowerGenerator : PowerGenerator {

    private const val MIN_POWER = 0
    private const val MAX_POWER = 9

    override fun generate(): Int = Randoms.pickNumberInRange(MIN_POWER, MAX_POWER)
}
