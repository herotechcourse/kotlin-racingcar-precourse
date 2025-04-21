package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    @Test
    fun `should create a car with valid name`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
    }

    @Test
    fun `should throw exception when car name is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("")
        }
        assertThat(exception.message).isEqualTo("Car name cannot be blank.")
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("longname")
        }
        assertThat(exception.message).isEqualTo("Car name 'longname' should not exceed 5 characters.")
    }
}