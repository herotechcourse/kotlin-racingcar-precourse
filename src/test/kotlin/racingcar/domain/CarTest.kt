package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `car should move forward by increasing position by 1`() {
        val car = Car("john")

        car.moveForward()

        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `car's initial position should be 0`() {
        val car = Car("steve")

        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car should move multiple times and position should increase accordingly`() {
        val car = Car("bell")

        repeat(3) {
            car.moveForward()
        }

        assertThat(car.getPosition()).isEqualTo(3)
    }
}