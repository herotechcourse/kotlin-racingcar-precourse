package racingcar.domain

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class RaceTest {

    @Test
    fun `runRound moves only qualifying cars` () {
        val cars = listOf(
            Car("a") { 4 }, // always moves
            Car("b") { 3 }, // never moves
        )
        val race = Race(cars)

        race.runRound()

        assertThat(cars[0].getPosition()).isEqualTo(1)
        assertThat(cars[1].getPosition()).isZero()
    }

    @Test
    fun `getWinners picks the single leader`() {
        val c1 = Car("x") { 4 }
        val c2 = Car("y") { 3 }
        val race = Race(listOf(c1, c2))
        repeat(2) { race.runRound() }

        val winners = race.getWinners()
        assertThat(winners).containsExactly(c1)
    }

    @Test
    fun `getWinners returns all ties`() {
        val c1 = Car("x") { 4 }
        val c2 = Car("y") { 4 }
        val race = Race(listOf(c1, c2))
        race.runRound()

        val winners = race.getWinners()
        assertThat(winners).containsExactlyInAnyOrder(c1, c2)
    }
}
