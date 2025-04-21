package racingcar.randomNumber

import camp.nextstep.edu.missionutils.Randoms

/**
 * @packageName    : racingcar
 * @fileName       : RandomNumber
 * @author         : yong
 * @date           : 4/19/25
 */
class RandomNumberImpl: RandomNumber {
    override fun generate(carsCount: Int): List<Int> {
        return List(carsCount) { Randoms.pickNumberInRange(0, 9) }
    }
}