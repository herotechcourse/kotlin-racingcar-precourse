package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.stub.StubNumberGenerator

class RacingGameTest {

    @Test
    fun `play moves all cars each round when strategy always moves`() {
        // given
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars(names)
        val round = Round(2)
        val strategy = RandomMoveStrategy(StubNumberGenerator(4))
        val racingGame = RacingGame(cars, round, strategy)

        // when
        val playResults = racingGame.play()

        //then
        assertThat(playResults).hasSize(2)
        assertThat(playResults[0]).containsExactly(
            "pobi" to 1, "woni" to 1, "jun" to 1
        )
        assertThat(playResults[1]).containsExactly(
            "pobi" to 2, "woni" to 2, "jun" to 2
        )
    }

    @Test
    fun `getWinners returns multiple winners in input order when positions tie`() {
        // given
        val names = listOf("pobi", "woni", "jun")
        val cars = Cars(names)
        cars.cars[0].move(2)
        cars.cars[1].move(2)
        cars.cars[2].move(1)
        val round = Round(5)
        val strategy = RandomMoveStrategy(StubNumberGenerator(3))
        val racingGame = RacingGame(cars, round, strategy)

        // when
        val winners = racingGame.getWinners()

        //then
        assertThat(winners).containsExactly("pobi", "woni")
    }
}
