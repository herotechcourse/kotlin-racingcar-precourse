package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class CarTest {

    @Test
    fun `car moves when random number is 4 or greater`() {
        val car = Car("test", randomNumberGenerator = { 4 })

        car.moveIfPossible()

        assertThat(car.movement).isEqualTo(1)
    }

    @Test
    fun `car does not move when random number is less than 4`() {
        val car = Car("test", randomNumberGenerator = { 3 })

        car.moveIfPossible()

        assertThat(car.movement).isEqualTo(0)
    }
}