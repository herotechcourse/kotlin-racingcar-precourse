package racingcar.car

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) > 3
    }

}