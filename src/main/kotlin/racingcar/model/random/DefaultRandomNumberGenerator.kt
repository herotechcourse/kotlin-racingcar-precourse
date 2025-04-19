package racingcar.model.random

import camp.nextstep.edu.missionutils.Randoms

class DefaultRandomNumberGenerator : RandomNumberGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}
