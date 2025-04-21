package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomPowerGenerator : PowerGenerator {
    companion object {
        const val MIN_POWER = 0
        const val MAX_POWER = 9
    }

    override fun generate(): Int {
        return Randoms.pickNumberInRange(MIN_POWER, MAX_POWER)
    }
}
