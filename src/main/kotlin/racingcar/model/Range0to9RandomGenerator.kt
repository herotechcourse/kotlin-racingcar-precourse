package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Range0to9RandomGenerator : RandomNumberGenerator {
    override fun generate(): Int = Randoms.pickNumberInRange(0, 9)
}