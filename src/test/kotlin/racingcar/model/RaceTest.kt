package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `winner is determined correctly`() {
        val bob = Car("bob")
        val dan = Car("dan")

        repeat(3) { bob.move(9) }
        repeat(1) { dan.move(9) }

        val race = Race(listOf(bob, dan), 3)
        val winners = race.findWinners()

        assertThat(winners).containsExactly(bob)
    }

}