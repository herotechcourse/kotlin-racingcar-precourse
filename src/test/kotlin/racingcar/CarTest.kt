package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car should move when condition is true`() {
        val car = Car("test")
        car.move(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car should not move when condition is false`() {
        val car = Car("test")
        car.move(false)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `position display should show correct number of dashes`() {
        val car = Car("test")
        car.position = 3
        assertThat(car.getPositionDisplay()).isEqualTo("---")
    }

    @Test
    fun `car should have zero initial position`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }
}