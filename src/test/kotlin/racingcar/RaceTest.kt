package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Race

class RaceTest {

    @Test
    fun `race creates cars from names`() {
        val race = Race(listOf("a", "b", "c"))
        val names = race.getCars().map { it.name }
        assertThat(names).containsExactly("a", "b", "c")
    }

    @Test
    fun `race returns only one winner`() {
        val race = Race(listOf("car1", "car2", "car3"))

        val cars = race.getCars()
        cars[0].position = 2
        cars[1].position = 3
        cars[2].position = 4

        val winners = race.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("car3")
    }

    @Test
    fun `race returns multiple winners`() {
        val race = Race(listOf("car1", "car2", "car3"))

        val cars = race.getCars()
        cars[0].position = 2
        cars[1].position = 3
        cars[2].position = 3

        val winners = race.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("car2", "car3")
    }
}