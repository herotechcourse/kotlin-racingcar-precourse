package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomPowerGenerator : PowerGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}
