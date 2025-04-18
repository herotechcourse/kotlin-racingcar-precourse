package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomEngine: Engine {
    override fun move(): Int {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return 1;
        }
        return 0;
    }
}