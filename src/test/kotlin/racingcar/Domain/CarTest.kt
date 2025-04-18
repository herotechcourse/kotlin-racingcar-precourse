package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    @DisplayName("Car name should not exceed 5 characters")
    fun carNameShouldNotExceedFiveCharacters() {
        // When & Then
        assertThatThrownBy { Car("longername") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }

    @Test
    @DisplayName("Car name should not be blank")
    fun carNameShouldNotBeBlank() {
        // When & Then
        assertThatThrownBy { Car("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be blank")
    }

    @Test
    @DisplayName("Car should have initial position of 0")
    fun carShouldHaveInitialPositionOfZero() {
        // Given
        val car = Car("pobi")

        // When & Then
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    @DisplayName("Car position display should show the correct number of dashes")
    fun positionDisplayShouldShowCorrectDashes() {
        // Given
        val car = Car("pobi")
        val expectedInitialDisplay = ""

        // When & Then
        assertThat(car.getPositionDisplay()).isEqualTo(expectedInitialDisplay)

        // Manually set position by using reflection (for testing purposes only)
        val positionField = Car::class.java.getDeclaredField("position")
        positionField.isAccessible = true
        positionField.set(car, 3)

        // Assert that the display now shows 3 dashes
        assertThat(car.getPositionDisplay()).isEqualTo("---")
    }

    // Note: Testing the move() method is challenging because it depends on random numbers.
    // In a real-world scenario, we would mock the random number generator or use dependency injection.
    // For this exercise, we'll test it indirectly in the ApplicationTest class.
}