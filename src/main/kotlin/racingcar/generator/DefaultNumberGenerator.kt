package racingcar.generator

import camp.nextstep.edu.missionutils.Randoms

class DefaultNumberGenerator : NumberGenerator {
    override fun generate(): Int = Randoms.pickNumberInRange(1, 10)
}