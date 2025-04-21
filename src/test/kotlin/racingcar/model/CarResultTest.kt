package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameResultTest {

    @Test
    @DisplayName("Test that GameResult returns the maximum move count correctly")
    fun findMaxMoveCountTest() {
        val car1 = Car("car1", 2)
        val car2 = Car("car2", 5)
        val car3 = Car("car3", 3)
        val cars = Cars(listOf(car1, car2, car3))

        val gameRoundResult = GameRoundResult(cars)

        val gameResult = GameResult()
        gameResult.saveRoundResult(gameRoundResult)

        val maxMoveCount = gameResult.findMaxMoveCount()

        assertThat(maxMoveCount).isEqualTo(5)
    }

    @Test
    @DisplayName("Test that GameResult returns Cars object of the final round")
    fun getCarsTest() {
        val car1 = Car("car1")
        val car2 = Car("car2")
        val cars = Cars(listOf(car1, car2))

        val gameRoundResult = GameRoundResult(cars)

        val gameResult = GameResult()
        gameResult.saveRoundResult(gameRoundResult)

        val resultCars = gameResult.getCarsAtFinalRound()

        assertThat(resultCars).isEqualTo(cars)
    }
}
