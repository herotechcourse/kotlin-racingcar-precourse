package racingcar.modelTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.model.Car
import racingcar.model.RacingGame

class WinnerSelectionTest {

    @Test
    fun `single car wins when there is only participant`() {

        val car = Car("loli")
        val game = RacingGame(listOf(car), 3)
        val winner = game.getWinners()

        assertThat(winner.map { it.name }).containsExactly("loli")
    }

    @Test
    fun `all cars are winners when they are tied`() {

        val car1 = Car("loli")
        val car2 = Car("moni")
        val car3 = Car("toti")
        val game = RacingGame(listOf(car1, car2, car3), 2)
        car1.move(true)
        car2.move(true)
        car3.move(true)
        val winner = game.getWinners()

        assertThat(winner.map { it.name }).containsExactly("loli", "moni", "toti")
    }

    @Test
    fun `single winner is selected`() {

        val car1 = Car("loli")
        val car2 = Car("moni")
        val car3 = Car("toti")
        val game = RacingGame(listOf(car1, car2, car3), 2)
        car1.move(false)
        car2.move(false)
        car3.move(true)
        val winner = game.getWinners()

        assertThat(winner.map { it.name }).containsExactly("toti")
    }
}
