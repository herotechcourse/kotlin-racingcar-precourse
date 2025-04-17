package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class GameTest {

    @Test
    fun `test getWinner returns car with highest position`() {
        val car1 = Car("yugo", position = 3)
        val car2 = Car("audi", position = 5)
        val car3 = Car("opel", position = 2)

        val game = Game(listOf(car1, car2, car3), rounds = 5)
        val winners = game.getWinner()

        assertThat(winners).hasSize(1)
        assertThat(winners[0].carName).isEqualTo("audi")
    }

    @Test
    fun `test getWinner returns multiple winners if tied`() {
        val car1 = Car("yugo", position = 4)
        val car2 = Car("audi", position = 4)
        val car3 = Car("opel", position = 2)

        val game = Game(listOf(car1, car2, car3), rounds = 5)
        val winners = game.getWinner()

        assertThat(winners).hasSize(2)
        assertThat(winners.map { it.carName }).containsExactlyInAnyOrder("yugo", "audi")
    }
}
