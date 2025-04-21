package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        val car1 = Car("car1")
        val car2 = Car("car2")
        val cars = Cars(listOf(car1, car2))
        game = Game(cars, 5)
    }

    @Test
    @DisplayName("Test that the game round count is returned correctly")
    fun getGameRoundTest() {
        val gameRound = game.getGameRound()
        assertThat(gameRound).isEqualTo(5)
    }
}
