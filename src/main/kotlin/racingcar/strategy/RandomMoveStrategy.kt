package racingcar.strategy

import camp.nextstep.edu.missionutils.Randoms

private const val MIN_ACCEPTABLE_NUM = 4
private const val MIN_RANGE = 0
private const val MAX_RANGE = 9

object RandomMoveStrategy : MoveStrategy {
    override fun canMove() = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE) >= MIN_ACCEPTABLE_NUM
}