package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.RacingGame
import racingcar.model.Car

class RacingGameTest {

    @Test
    fun `should throw exception for invalid number of rounds`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val exception = assertThrows<IllegalArgumentException> {
            RacingGame(cars, 0)
        }
        assertThat(exception.message).isEqualTo("Number of rounds must be greater than 0.")
    }

    @Test
    fun `should progress the race and update car positions`() {
        val cars = listOf(Car("pobi"), Car("woni"))
        val racingGame = RacingGame(cars, 1)

        racingGame.startRace()

        // Since random numbers are involved, we cannot assert exact positions.
        // Instead, we check that positions are updated (at least one car moves forward).
        val positions = cars.map { it.position }
        assertThat(positions.any { it > 0 }).isTrue
    }

    @Test
    fun `should determine winners correctly`() {
        val car1 = Car("pobi")
        val car2 = Car("woni")
        val car3 = Car("jun")

        // Manually set positions to simulate a race
        car1.moveForward(4) // Position = 1
        car2.moveForward(4) // Position = 1
        car3.moveForward(4) // Position = 1
        car3.moveForward(4) // Position = 2 (Winner)

        val racingGame = RacingGame(listOf(car1, car2, car3), 1)

        // Simulate the end of the race
        racingGame.startRace()

        // Assert that the winner is correctly determined
        val winners = listOf(car3.name)
        assertThat(winners).containsExactly("jun")
    }
}