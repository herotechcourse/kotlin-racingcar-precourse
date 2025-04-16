package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator: NumberGenerator{

    override fun generate(): Int = Randoms.pickNumberInRange(0, 9)
}