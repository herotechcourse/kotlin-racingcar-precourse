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
}
