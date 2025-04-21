package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `car should move forward when number is 4 or greater`() {
        val car = Car("test")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car should not move when number is less than 4`() {
        val car = Car("test")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `car should accumulate position when moving multiple times`() {
        val car = Car("test")
        car.move(4)
        car.move(5)
        car.move(6)
        assertThat(car.position).isEqualTo(3)
    }
} 