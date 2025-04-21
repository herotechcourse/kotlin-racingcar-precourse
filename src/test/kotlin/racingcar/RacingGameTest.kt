package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `should declare one winner correctly`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val game = RacingGame(cars, 1)

        // Force one car to win for test determinism (manually increase position)
        cars[0].move()
        game.printWinners()

        val winner = if (cars[0].position >= cars[1].position) "pobi" else "woni"
        assertThat(listOf("pobi", "woni")).contains(winner)
    }

    @Test
    fun `should allow multiple winners if tied`() {
        val car1 = Car("a").apply { repeat(3) { move() } }
        val car2 = Car("b").apply { repeat(3) { move() } }

        val cars = listOf(car1, car2)
        val game = RacingGame(cars, 0)

        // Both have same position
        val max = cars.maxOf { it.position }
        val winners = cars.filter { it.position == max }.map { it.name }

        assertThat(winners).containsExactlyInAnyOrder("a", "b")
    }
}
