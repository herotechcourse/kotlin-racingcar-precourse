package racingcar

import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `single winner test`() {
        val carNames = listOf("car1", "car2", "car3")
        // setting noOfRounds to 0 to override the car positions
        val game = RacingGame(carNames, 0)
        val cars = game.cars

        cars[0].moveForward(MOVING_FORWARD)
        cars[1].moveForward(STOP)
        cars[2].moveForward(STOP)

        val winners = game.getWinners()
        assert(listOf("car1") == winners)
    }

    @Test
    fun `multiple winners test`() {
        val carNames = listOf("car1", "car2", "car3")
        // setting noOfRounds to 0 to override the car positions
        val game = RacingGame(carNames, 0)
        val cars = game.cars

        cars[0].moveForward(MOVING_FORWARD)
        cars[1].moveForward(MOVING_FORWARD)
        cars[2].moveForward(STOP)

        val winners = game.getWinners()
        assert(listOf("car1", "car2") == winners)
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}
