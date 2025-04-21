package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `initial position is zero`() {
        val car = Car("TestCar")
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car does not move when shouldMove is false`() {
        val car = Car("NoMoveCar")
        car.attemptMove(false)
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `car moves forward when shouldMove is true`() {
        val car = Car("MoveCar")
        car.attemptMove(true)
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `car can move multiple times`() {
        val car = Car("MultiMoveCar")
        repeat(3) { car.attemptMove(true) }
        assertThat(car.getPosition()).isEqualTo(3)
    }

    @Test
    fun `car position only increases when shouldMove is true`() {
        val car = Car("ConditionalMoveCar")
        car.attemptMove(true)
        car.attemptMove(false)
        car.attemptMove(true)
        assertThat(car.getPosition()).isEqualTo(2)
    }
}
