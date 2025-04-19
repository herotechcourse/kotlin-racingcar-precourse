package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car initializes with correct name and zero position`() {
        val carName = "testCar1"
        val car = Car(carName)

        assertThat(car.name).isEqualTo(carName)
        assertThat(car.position).isZero()
    }

    @Test
    fun `moveForward increases position by one`() {
        val car = Car("testCar1")

        car.moveForward()
        assertThat(car.position).isEqualTo(1)

        car.moveForward()
        assertThat(car.position).isEqualTo(2)
    }
}