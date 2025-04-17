package racingcar.generator

import camp.nextstep.edu.missionutils.Randoms

object DefaultRandomNumberGenerator : RandomNumberGenerator {

    private const val START_RANGE = 0
    private const val END_RANGE = 9

    override fun generate(): Int {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE)
    }

}