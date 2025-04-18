package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarRacingTest {

    private val carRacing = CarRacing()

    @Test
    fun `should return one winner`() {
        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))

        cars[0].move()
        cars[0].move()
        cars[1].move()

        val winners = carRacing.getRaceWinners(cars)

        assertThat(winners).isEqualTo("car1")
    }

    @Test
    fun `should return multiple winners`() {
        val cars = listOf(Car("car1"), Car("car2"), Car("car3"))

        cars[0].move()
        cars[1].move()

        val winners = carRacing.getRaceWinners(cars)

        assertThat(winners).isEqualTo("car1, car2")
    }
}