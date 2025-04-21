package racingcar.model

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun `car moves forward if shouldMove is true`() {
        val car = Car("pobi")
        car.move(true)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `car does not move if shouldMove is false`() {
        val car = Car("pobi", 3)
        car.move(false)
        assertThat(car.position).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "\n", "\t", "  \t\n  "])
    fun `blank names throw exception`(name: String) {
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name must not be blank.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `name length 1 ~ 5 is allowed`(length: Int) {
        val name = "a".repeat(length)
        assertThatCode { Car(name) }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(ints = [6, 7, 8, 9, 10])
    fun `name length over 5 is not allowed`(length: Int) {
        val name = "a".repeat(length)
        assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car name cannot exceed 5 characters.")
    }

    @Test
    fun `position is initialized to zero if not specified`() {
        val car = Car("pobi")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `position is correctly set when specified`() {
        val car = Car("pobi", 7)
        assertThat(car.position).isEqualTo(7)
    }
}
