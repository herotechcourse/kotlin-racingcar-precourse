package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Car class should be created with a name`() {
        val car = Car("pobi")
        assert(car.name == "pobi") { "Car name should be 'pobi'" }
    }

    @Test
    fun `Car class should not be created with a blank name`() {
        try {
            Car("")
        } catch (e: IllegalArgumentException) {
            assert(e.message == "Car name cannot be blank") { "Exception message should be 'Car name cannot be blank'" }
        }
    }

    @Test
    fun `Car class should not be created with a name longer than 5 characters`() {
        try {
            Car("abcdefg")
        } catch (e: IllegalArgumentException) {
            assert(e.message == "Car name cannot be longer than 5 characters") { "Exception message should be 'Car name cannot be longer than 5 characters'" }
        }
    }

    @Test
    fun `Car should move forward when the random number is greater than or equal to 4`() {
        val car = Car("pobi") {
            4
        }
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car should not move when the random number is less than 4`() {
        val car = Car("pobi") {
            3
        }
        car.move()
        assertThat(car.position).isEqualTo(0)
    }
}
