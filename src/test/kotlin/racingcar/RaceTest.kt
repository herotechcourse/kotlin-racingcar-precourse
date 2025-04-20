package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `All cars move forward`() {
        val initialCars = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )
        val movedCars = playRound(initialCars) { true }
        assertThat(movedCars).isEqualTo(
            listOf(
                Car("pobi", 1),
                Car("woni", 1),
                Car("jun", 1)
            )
        )
    }

    @Test
    fun `All cars stay still`() {
        val initialCars = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )
        val movedCars = playRound(initialCars) { false }
        assertThat(movedCars).isEqualTo(
            listOf(
                Car("pobi", 0),
                Car("woni", 0),
                Car("jun", 0)
            )
        )
    }

    @Test
    fun `Run race for multiple rounds`() {
        val initialCars = listOf(
            Car("pobi", 0),
            Car("woni", 0),
            Car("jun", 0)
        )

        val raceResults = runRace(initialCars, 3) { true }
        assertThat(raceResults[2]).isEqualTo(
            listOf(
                Car("pobi", 3),
                Car("woni", 3),
                Car("jun", 3)
            )
        )
    }
}
