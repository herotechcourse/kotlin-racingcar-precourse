package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `createCarsFromInput should create a RacingGame instance with correct cars`() {

        val names = listOf("chang", "seo", "deok")
        val game = RacingGame(emptyList()).createCarsFromInput(names)

        assertThat(game.findWinner().map { it.name }).containsExactlyInAnyOrder("chang", "seo", "deok")
    }

    @Test
    fun `executeRound should move all cars forward if random number is greater than or equal to 4`() {

        val cars = listOf(
            Car("chang") { 5 },
            Car("deok") { 6 },
            Car("seo") { 7 }
        )
        val game = RacingGame(cars)

        game.executeRound()

        cars.forEach {
            assertThat(it.getPosition()).isEqualTo(1)
        }
        assertThat(game.curRoundNum).isEqualTo(1)
    }
}
