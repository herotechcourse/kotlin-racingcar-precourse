package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomImpl(): RandomGenerator{
    override fun randoms(): Int {
        return Randoms.pickNumberInRange(0,9)
    }

}