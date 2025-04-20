package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `creates car with valid name`() {
        val car = Car("pobi")
        assertThat(car.carName).isEqualTo("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `throws exception when car name is too long`() {
        val exception = assertThrows<IllegalArgumentException> {
            Car("abcdef")
        }
        assertThat(exception.message).contains("Car name length should not be more than 5")
    }

    @Test
    fun `car moves when random number is greater than or equal to 4`() {
        val car = Car("pobi")
        car.move(4)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car does not move when random number is less than 4`() {
        val car = Car("pobi")
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `getProgress returns correct progress string`() {
        val car = Car("pobi")
        repeat(3) { car.move(4) }  // Simulate 3 successful moves
        assertThat(car.getProgress()).isEqualTo("pobi : ---")
    }
}
