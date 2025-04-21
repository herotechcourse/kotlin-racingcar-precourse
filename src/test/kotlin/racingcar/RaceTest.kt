package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `all cars move if number is always 5`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val generator = NumberGenerator { 5 }
        val race = Race(cars, generator)
        race.run(3)
        assertThat(race.getCars().map { it.position }).containsExactly(3, 3, 3)
    }

    @Test
    fun `no car moves if number is always 2`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val generator = NumberGenerator { 2 }
        val race = Race(cars, generator)
        race.run(5)
        assertThat(race.getCars().map { it.position }).containsExactly(0, 0)
    }

    @Test
    fun `one clear winner is selected correctly`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        var counter = 0
        val generator = NumberGenerator {
            if (counter++ % 2 == 0) 5 else 3
        }
        val race = Race(cars, generator)
        race.run(3)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `multiple winners when all cars reach the same highest position`() {
        val cars = listOf(Car("a"), Car("b"), Car("c"))
        val generator = NumberGenerator { 9 }
        val race = Race(cars, generator)
        race.run(2)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("a", "b", "c")
    }

    @Test
    fun `multiple cars reach the same highest position`() {
        val cars = listOf(Car("a"), Car("b"), Car("c"))
        var counter = 0
        val generator = NumberGenerator {
            when (counter++ % 3) {
                0 -> 5
                1 -> 5
                else -> 2
            }
        }
        val race = Race(cars, generator)
        race.run(2)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("a", "b")
    }

    @Test
    fun `getWinners returns empty list if no cars present`() {
        val generator = NumberGenerator { 5 }
        val race = Race(emptyList(), generator)
        val winners = race.getWinners()
        assertThat(winners).isEmpty()
    }

    @Test
    fun `race run with zero rounds results in no movement`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val generator = NumberGenerator { 9 }
        val race = Race(cars, generator)
        race.run(0)
        assertThat(race.getCars().map { it.position }).containsExactly(0, 0)
    }
}
