package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomMoveStrategy : MoveStrategy {
    override fun isMovable(car: Car): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}