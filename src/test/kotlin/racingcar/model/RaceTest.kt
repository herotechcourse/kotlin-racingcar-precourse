package racingcar.model

import racingcar.movement.MovementStrategy
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class RaceTest {

    @Test
    fun `cars move forward when shouldMove is always true`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val alwaysMove = object : MovementStrategy {
            override fun shouldMove() = true
        }
        val race = Race(cars, 3, alwaysMove)

        repeat(3) { race.playRound() }

        assertThat(cars.map { it.position }).containsExactly(3, 3)
    }

    @Test
    fun `cars never move when shouldMove is always false`() {
        val cars = listOf(Car("pobi"), Car("woni", 2))
        val neverMove = object : MovementStrategy {
            override fun shouldMove() = false
        }
        val race = Race(cars, 5, neverMove)

        repeat(5) { race.playRound() }

        assertThat(cars.map { it.position }).containsExactly(0, 2)
    }

    @Test
    fun `race with a single car always returns that car as winner`() {
        val cars = listOf(Car("jun"))
        val race = Race(cars, 1, object : MovementStrategy { override fun shouldMove() = false })

        race.playRound()

        assertThat(race.findWinners()).hasSize(1).extracting("name").containsExactly("jun")
    }

    @Test
    fun `if initial positions are different, winner is car with highest initial position even if no one moves`() {
        val cars = listOf(
            Car("pobi", 2),
            Car("woni", 5),
            Car("jun", 5),
            Car("abcde", 1)
        )
        val race = Race(cars, 1, object : MovementStrategy { override fun shouldMove() = false })

        race.playRound()

        assertThat(race.findWinners().map { it.name }).containsExactlyInAnyOrder("woni", "jun")
    }

    @Test
    fun `cannot play after race finished`() {
        val cars = listOf(Car("jun"))
        val race = Race(cars, 1, object : MovementStrategy { override fun shouldMove() = false })

        race.playRound()

        assertThatThrownBy { race.playRound() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `getCurrentStatus returns current car objects after a round`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val alwaysMove = object : MovementStrategy { override fun shouldMove() = true }
        val race = Race(cars, 1, alwaysMove)

        race.playRound()

        val status = race.getCurrentStatus()
        assertThat(status.map { it.position }).containsExactly(1, 1)
    }

    @Test
    fun `all cars win when positions are tied`() {
        val cars = listOf(Car("pobi", 3), Car("woni", 3), Car("jun", 3))
        val race = Race(cars, 2, object : MovementStrategy { override fun shouldMove() = false })

        assertThat(race.findWinners()).hasSize(3)
    }
}
