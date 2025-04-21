package racingcar.domain.strategy

interface MoveStrategy {
	fun shouldMove(): Boolean
}