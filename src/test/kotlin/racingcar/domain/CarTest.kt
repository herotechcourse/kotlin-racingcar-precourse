package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Throw IllegalArgumentException when carName is blank`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("   ")
        }
    }

    @Test
    fun `Throw IllegalArgumentException when carName exceed 5`() {
        assertThrows(IllegalArgumentException::class.java) {
            Car("abcdef")
        }
    }

    @Test
    fun `car moves when number is greater than or equal to threahold`() {
        val car = Car("abc")

        car.moveIfOverThreshold(MOVING_FORWARD)

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car do not move when number is less than threahold`() {
        val car = Car("abc")

        car.moveIfOverThreshold(STOP)

        assertThat(car.position).isEqualTo(0)
    }

    companion object {
        const val MOVING_FORWARD = 5
        const val STOP = 3
    }
}