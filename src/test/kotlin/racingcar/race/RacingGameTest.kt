package racingcar.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.strategy.MoveStrategy

class RacingGameTest {

    private val alwaysMove = MoveStrategy { true }
    private val neverMove = MoveStrategy { false }

    @Test
    fun `race with alwaysMove should advance each car by rounds`() {
        val car1 = Car("pobi")
        val car2 = Car("woni", position = 2)
        val rounds = 3
        RacingGame(listOf(car1, car2), rounds, alwaysMove).race()

        assertThat(car1.position())
            .`as`("0 + 3 rounds = 3")
            .isEqualTo(3)
        assertThat(car2.position())
            .`as`("2 + 3 rounds = 5")
            .isEqualTo(5)
    }

    @Test
    fun `race with neverMove should leave all cars in place`() {
        val car1 = Car("pobi")
        val car2 = Car("woni", position = 5)
        RacingGame(listOf(car1, car2), rounds = 4, neverMove).race()

        assertThat(car1.position()).isZero
        assertThat(car2.position()).isEqualTo(5)
    }

    @Test
    fun `winners returns all cars if they tie`() {
        val cars = listOf(
            Car("pobi", position = 3),
            Car("woni", position = 3)
        )
        // no rounds needed since positions are equal
        val winners = RacingGame(cars, rounds = 0, alwaysMove).winners()

        assertThat(winners)
            .`as`("both cars have the same position, so both win")
            .containsExactlyInAnyOrderElementsOf(cars)
    }

    @Test
    fun `winners returns the single leader`() {
        val carA = Car("woni", position = 1)
        val carB = Car("pobi", position = 4)
        val game = RacingGame(listOf(carA, carB), rounds = 2, alwaysMove)
        game.race()
        val winners = game.winners()

        assertThat(winners)
            .`as`("Car pobi leads with position 6 vs. 3, so only pobi wins")
            .containsExactly(carB)
    }
}