package racingcar.sub_application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.RacingGame
import racingcar.support.strategy.PatternMoveStrategy
import racingcar.support.extensions.moveAllCarsWith

class MoveSimulation {
	@Test
	fun `cars move according to predefined boolean pattern`() {
		val guri = Car("guri")
		val mina = Car("mina")
		val game = RacingGame(listOf(guri, mina))

		val guriStrategy = PatternMoveStrategy(listOf(true, true, false, true))
		val minaStrategy = PatternMoveStrategy(listOf(true, true, false, false))
		repeat(4) {
			game.moveAllCarsWith(listOf(guriStrategy, minaStrategy))
		}
		assertThat(guri.totalDistance()).isEqualTo(3)
		assertThat(mina.totalDistance()).isEqualTo(2)
	}
}