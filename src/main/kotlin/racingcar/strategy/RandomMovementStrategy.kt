package racingcar.strategy

import camp.nextstep.edu.missionutils.Randoms
import racingcar.config.Config

/**
 * Default movement strategy using random numbers.
 */
object RandomMovementStrategy : MovementStrategy {
    override fun shouldMove(): Boolean =
        Randoms.pickNumberInRange(Config.MIN_RANDOM, Config.MAX_RANDOM) >= Config.MOVE_THRESHOLD
}