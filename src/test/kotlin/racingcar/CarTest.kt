package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car has a name that does not exceed 5 characters`() {
        val name = "herotech"
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot exceed 5 characters, current name length: ${name.length}")
    }

    @Test
    fun `car can move forward`() {
        val car  = Car("hero")
        car.move()
        assertThat(car.position()).isEqualTo(1)
    }

}
