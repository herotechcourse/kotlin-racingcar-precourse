package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `move forward when number is greater than or equal to 4`() {
        val car = Car("pobi", 0)
        val moved = car.move(4)
        assertThat(moved.position).isEqualTo(1)
    }

    @Test
    fun `stay still when number is less than 4`() {
        val car = Car("pobi", 0)
        val moved = car.move(3)
        assertThat(moved.position).isEqualTo(0)
    }

    @Test
    fun `throw exception when name is longer than 5 characters`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            Car("toolong")
        }
    }
}
