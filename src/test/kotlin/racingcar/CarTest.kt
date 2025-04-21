package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class CarTest {

    @RepeatedTest(10)
    fun `car should move forward when random number is 4 or more`() {
        val car = Car("pobi")
        // Simulate movement up to 10 times due to randomness
        car.move()
        assertThat(car.position).isBetween(0, 1)
    }

    @Test
    fun `car name should not be longer than 5 characters`() {
        val longName = "longerName"
        assertThatThrownBy { Car(longName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be non-empty and up to 5 characters.")
    }
}
