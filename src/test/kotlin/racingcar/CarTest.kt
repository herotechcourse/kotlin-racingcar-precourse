package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.domain.Car

class CarTest {

    @Test
    fun `car moves forward when number is 4`() {
        val car = Car("pobi") { 4 }
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car does not move when random number is less than 4`() {
        val car = Car("pobi") { 3 }
        car.move()
        assertEquals(0, car.position)
    }

    @Test
    fun `car moves forward when number is bigger than 4`() {
        val car = Car("pobi") { 5 }
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car with valid name is created successfully`() {
        val car = Car("pobi")
        assertEquals("pobi", car.name)
        assertEquals(0, car.position)
    }

    @Test
    fun `car throws exception when name is longer than 5 characters`() {
        assertThatThrownBy { Car("speedy") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name must be 1-5 characters long")
    }

    @Test
    fun `car throws exception when name is blank`() {
        assertThatThrownBy { Car("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name must be 1-5 characters long")
    }
}