package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `change car position after move`() {
        val car = Car("car")
        assertTrue(car.position == 0)
        car.move()
        assertTrue(car.position == 1)
    }

    @Test
    fun `print car result just after initializing`() {
        val car = Car("car")
        assertThat(car.toString()).isEqualTo("car : ")
    }

    @Test
    fun `print car result after car moved once`() {
        val car = Car("car")
        car.move()
        assertThat(car.toString()).isEqualTo("car : -")
    }

    @Test
    fun `print car result after car moved two times`() {
        val car = Car("car")
        repeat(2) {
            car.move()
        }
        assertThat(car.toString()).isEqualTo("car : --")
    }
}