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
        val race = Race(initialCars, 1, true)
        val movedCars = race.runRound()
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
        val race = Race(initialCars, 1, false)
        val movedCars = race.runRound()
        assertThat(movedCars).isEqualTo(
            listOf(
                Car("pobi", 0),
                Car("woni", 0),
                Car("jun", 0)
            )
        )
    }
}
