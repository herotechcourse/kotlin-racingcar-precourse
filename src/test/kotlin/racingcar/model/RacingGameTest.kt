package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `should move cars when all generated number is more than 4`() {
        val car1 = Car("pobi") { 4 }
        val car2 = Car("woni") { 4 }
        val racingGame = RacingGame(listOf(car1, car2))

        racingGame.play()
        assertThat(car1.position).isEqualTo(1)
        assertThat(car2.position).isEqualTo(1)
    }

    @Test
    fun `should get winners when all cars have the same position`() {
        val car1 = Car("pobi") { 4 }
        val car2 = Car("woni") { 4 }
        val racingGame = RacingGame(listOf(car1, car2))

        racingGame.play()
        val winners = racingGame.getWinners()

        assertThat(winners).containsExactlyInAnyOrder(car1, car2)
    }

    @Test
    fun `should get winners when one car has the highest position`() {
        val car1 = Car("pobi") { 4 }
        val car2 = Car("woni") { 3 }
        val racingGame = RacingGame(listOf(car1, car2))

        racingGame.play()
        val winners = racingGame.getWinners()

        assertThat(winners).containsExactly(car1)
    }
}
