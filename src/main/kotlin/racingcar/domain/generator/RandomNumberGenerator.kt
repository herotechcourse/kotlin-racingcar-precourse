package racingcar.domain.generator

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {

    override fun nextInt(min: Int, max: Int): Int =
        Randoms.pickNumberInRange(0, 9)
}
