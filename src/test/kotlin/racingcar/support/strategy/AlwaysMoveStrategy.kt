package racingcar.support.strategy

import racingcar.domain.strategy.MoveStrategy

class AlwaysMoveStrategy : MoveStrategy {
	override fun shouldMove() = true
}