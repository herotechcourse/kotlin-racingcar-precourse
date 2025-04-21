package racingcar.support.extensions

import racingcar.domain.RacingGame
import racingcar.domain.strategy.MoveStrategy

fun RacingGame.moveAllCarsWith(strategies: List<MoveStrategy>) {
	val cars = getCarsForTesting()
	cars.forEachIndexed { index, car ->
		val shouldMove = strategies[index].shouldMove()
		car.moveIf(shouldMove)
	}
}