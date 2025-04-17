package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @DisplayName("Car should move forward when random number is 4 or greater")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun movesForwardWithNumberFourOrGreater(randomNumber: Int) {
        // given
        val car = Car("test")
        val initialPosition = car.getPosition()

        // when
        car.move(randomNumber)

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1)
    }

    @DisplayName("Car should not move when random number is less than 4")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun doesNotMoveWithNumberLessThanFour(randomNumber: Int) {
        // given
        val car = Car("test")
        val initialPosition = car.getPosition()

        // when
        car.move(randomNumber)

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition)
    }

    @Test
    @DisplayName("toString should format car name and position correctly")
    fun toStringFormatsNameAndPosition() {
        // given
        val car = Car("test")

        // when
        repeat(3) { car.move(4) } // Move the car 3 times

        // then
        assertThat(car.toString()).isEqualTo("test : ---")
    }
}