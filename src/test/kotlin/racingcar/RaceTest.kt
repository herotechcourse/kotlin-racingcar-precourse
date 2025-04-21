// RaceTest.kt
package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `The most forward car is the winner`() {
        val pobi = Car("pobi").apply { repeat(3) { move(4) } }
        val woni = Car("woni").apply { repeat(1) { move(4) } }
        val race = Race(listOf(pobi, woni))

        val winners = race.findWinners()
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `There can be multiple winners`() {
        val pobi = Car("pobi").apply { repeat(2) { move(4) } }
        val jun = Car("jun").apply { repeat(2) { move(4) } }
        val race = Race(listOf(pobi, jun))

        val winners = race.findWinners()
        assertThat(winners).containsExactlyInAnyOrder("pobi", "jun")
    }
}
