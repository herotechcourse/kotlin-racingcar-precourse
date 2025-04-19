package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `race with multiple winners`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        val race = Race(cars, NumberGenerator { 5 })
        race.run(3)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("pobi", "jun")
    }

    @Test
    fun `race with one clear winner`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        var count = 0
        val generator = NumberGenerator {
            if (count++ % 2 == 0) 5 else 1
        }
        val race = Race(cars, generator)
        race.run(3)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("pobi")
    }

    @Test
    fun `race with no movement`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        val race = Race(cars, NumberGenerator { 1 })
        race.run(3)
        assertThat(cars.all { it.position == 0 }).isTrue()
        assertThat(race.getWinners().map { it.name }).containsExactly("pobi", "jun")
    }

    @Test
    fun `race with zero rounds`() {
        val cars = listOf(Car("pobi"), Car("jun"))
        val race = Race(cars, NumberGenerator { 9 })
        race.run(0)
        assertThat(cars.all { it.position == 0 }).isTrue()
    }

    @Test
    fun `race with empty car list`() {
        val race = Race(emptyList(), NumberGenerator { 5 })
        race.run(3)
        assertThat(race.getWinners()).isEmpty()
    }

    @Test
    fun `race with duplicate names`() {
        val cars = listOf(Car("pobi"), Car("pobi"))
        val race = Race(cars, NumberGenerator { 6 })
        race.run(2)
        assertThat(race.getWinners().size).isEqualTo(2)
    }

    @Test
    fun `race with invalid car name throws exception`() {
        assertThatThrownBy {
            Validator.validateCarNames(listOf("pobi", "verylongname"))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `race with negative rounds throws exception`() {
        assertThatThrownBy {
            Validator.validateRoundCount(-1)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `race with whitespace car names throws exception`() {
        assertThatThrownBy {
            Validator.validateCarNames(listOf("pobi", " "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `single car race`() {
        val cars = listOf(Car("solo"))
        val race = Race(cars, NumberGenerator { 5 })
        race.run(4)
        val winners = race.getWinners().map { it.name }
        assertThat(winners).containsExactly("solo")
        assertThat(cars[0].position).isEqualTo(4)
    }
}
