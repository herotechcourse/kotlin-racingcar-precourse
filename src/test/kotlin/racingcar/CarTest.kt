package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.Car

class CarTest {
    @Test
    fun `should create a car with valid name and default position`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `should throw exception for blank car name`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("")
        }
        assertThat(exception.message).isEqualTo("Car name must not be blank.")
    }

    @Test
    fun `should throw exception for car name exceeding max length`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("tooolongname")
        }
        assertThat(exception.message).isEqualTo("Car name must be at most 5 characters.")
    }

    @Test
    fun `should move forward when random number is 4 or greater`() {
        val car = Car("pobi")
        car.moveForward(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `should not move forward when random number is less than 4`() {
        val car = Car("pobi")
        car.moveForward(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `should return correct progress representation`() {
        val car = Car("pobi")
        car.moveForward(4)
        car.moveForward(4)
        assertThat(car.progress()).isEqualTo("--")
    }
}