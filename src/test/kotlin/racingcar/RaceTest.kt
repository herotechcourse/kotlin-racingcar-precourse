package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `cars move forward when number is 4 or more`() {
        val cars = listOf(Car("a"), Car("b"), Car("c"))
        val race = Race(cars)
        race.playOneRound { 5 }

        assertThat(cars.all { it.getPosition() == 1 }).isTrue()
    }

    @Test
    fun `cars stay still when number is less than 4`() {
        val cars = listOf(Car("a"), Car("b"))
        val race = Race(cars)
        race.playOneRound { 3 }

        assertThat(cars.all { it.getPosition() == 0 }).isTrue()
    }

    @Test
    fun `returns single winner with max position`() {
        val cars = listOf(Car("a"), Car("b"))
        cars[0].move(4) // only "a" moves
        val race = Race(cars)

        val winners = race.getWinners().map { it.getName() }
        assertThat(winners).containsExactly("a")
    }

    @Test
    fun `returns multiple winners if tied`() {
        val cars = listOf(Car("a"), Car("b"))
        cars.forEach { it.move(4) } // both move once
        val race = Race(cars)

        val winners = race.getWinners().map { it.getName() }
        assertThat(winners).containsExactlyInAnyOrder("a", "b")
    }

}