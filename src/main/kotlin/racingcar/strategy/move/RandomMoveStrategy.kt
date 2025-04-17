package racingcar.strategy.move

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Rules

class RandomMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean {
        return randomNumberPassesThreshold()
    }

    private fun randomNumberPassesThreshold(): Boolean {
        return Randoms.pickNumberInRange(Rules.RANDOM_MIN, Rules.RANDOM_MAX) >= Rules.MOVE_THRESHOLD
    }
}