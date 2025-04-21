package racingcar.domain

import racingcar.domain.strategy.MoveStrategy
import racingcar.support.strategy.AlwaysMoveStrategy
import racingcar.support.strategy.NeverMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

	@Test
	fun `cars should move forward in a round when AlwaysMoveStrategy is used`() {
		val cars = listOf(Car("pobi"), Car("woni"))
		val game = RacingGame(cars)

		game.moveAllCarsWith(AlwaysMoveStrategy())

		assertThat(cars.map { it.totalDistance() })
			.describedAs("All cars should have moved forward by 1 step")
			.containsOnly(1)
	}

	@Test
	fun `cars should not move when NeverMoveStrategy is used`() {
		val cars = listOf(Car("pobi"), Car("woni"))
		val game = RacingGame(cars)

		game.moveAllCarsWith(NeverMoveStrategy())

		assertThat(cars.map { it.totalDistance() })
			.describedAs("All cars should remain at position 0")
			.containsOnly(0)
	}
}