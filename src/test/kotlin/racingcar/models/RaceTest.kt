package racingcar.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `cars should move only when random number is 4 or more`() {
        val race = Race(listOf("a", "b", "c"))

        val inputs = listOf(4, 3, 9)
        inputs.forEachIndexed { index, value ->
            race.getCars()[index].move(value)
        }

        val positions = race.getCars().map { it.getPosition() }
        assertThat(positions).containsExactly(1, 0, 1)
    }

    @Test
    fun `cars with maximum position should be winner`() {
        val race = Race(listOf("car1", "car2", "car3"))

        val cars = race.getCars()
        cars[0].move(4)
        cars[1].move(4)
        cars[2].move(3)

        val winners = race.findWinners()
        assertThat(winners).containsExactlyInAnyOrder("car1", "car2")
    }

    @Test
    fun `no winners if all cars stay still`() {
        val race = Race(listOf("x", "y", "z"))

        val cars = race.getCars()
        cars.forEach { it.move(2) }

        val winners = race.findWinners()
        assertThat(winners).containsExactlyInAnyOrder("x", "y", "z")
    }
}
