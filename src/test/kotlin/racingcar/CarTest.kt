package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class CarTest {

    @Test
    fun `random number is 4 or higher → car should move forward`() {
        val car = Car("test", randomNumberGenerator = { 4 })

        car.moveIfPossible()

        assertThat(car.movement).isEqualTo(1)
    }

    @Test
    fun `random number is less than 4 → car should not move`() {
        val car = Car("test", randomNumberGenerator = { 3 })

        car.moveIfPossible()

        assertThat(car.movement).isEqualTo(0)
    }
}