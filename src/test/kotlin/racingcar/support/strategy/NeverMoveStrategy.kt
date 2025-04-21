package racingcar.support.strategy

import racingcar.domain.strategy.MoveStrategy

class NeverMoveStrategy : MoveStrategy {
	override fun shouldMove() = false
}