package racingcar.service.movement

import camp.nextstep.edu.missionutils.Randoms

class RandomMovementStrategy : MovementStrategy {
    override fun shouldMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}
