package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `car has a name that does not exceed 5 characters`() {
        val name = "herotech"
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot exceed 5 characters, current name length: ${name.length}")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 9])
    fun `car can move forward`(randomNumber: Int) {
        val car = Car("hero")
        car.move(randomNumber)
        assertThat(car.position()).isEqualTo(1)
    }
}
