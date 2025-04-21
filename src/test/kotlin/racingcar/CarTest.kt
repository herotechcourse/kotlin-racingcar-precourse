package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("Car initializes with correct name and zero position")
    fun initialize() {
        val carName = "testCar1"
        val car = Car(carName)

        assertThat(car.name).isEqualTo(carName)
        assertThat(car.position).isZero()
    }

    @Test
    @DisplayName("Increases position by one")
    fun moveForward() {
        val car = Car("testCar1")

        car.moveForward()
        assertThat(car.position).isEqualTo(1)

        car.moveForward()
        assertThat(car.position).isEqualTo(2)
    }
}