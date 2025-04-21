package racingcar.support.strategy

import racingcar.domain.strategy.MoveStrategy

class PatternMoveStrategy(val pattern: List<Boolean>) : MoveStrategy {
	private var index = 0
	override fun shouldMove(): Boolean {
		require(index < pattern.size) {
			"Pattern exhausted: index $index exceeds size ${pattern.size}"
		}
		return pattern[index++]
	}
}