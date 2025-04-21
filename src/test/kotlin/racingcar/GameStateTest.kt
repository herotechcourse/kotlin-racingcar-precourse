package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.controller.GameState
import racingcar.model.Car

class GameStateTest {
    @Test
    fun `determine winner test`() {
        val car1 = Car("san", 5)
        val car2 = Car("river", 4)
        val car3 = Car("wind", 3)

        val game = GameState(listOf(car1, car2, car3))
        val winners = game.getWinners()

        assertThat(winners).containsOnly("san")
    }

    @Test
    fun `determine multiple winner test`() {
        val car1 = Car("san", 5)
        val car2 = Car("river", 4)
        val car3 = Car("wind", 5)

        val game = GameState(listOf(car1, car2, car3))
        val winners = game.getWinners()

        assertThat(winners).containsOnly("san", "wind")
    }
}
