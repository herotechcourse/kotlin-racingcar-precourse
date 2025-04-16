package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : Fuel {
    override fun isEnough(): Boolean {
        return (Randoms.pickNumberInRange(0, 9) >= 4)
    }
}
