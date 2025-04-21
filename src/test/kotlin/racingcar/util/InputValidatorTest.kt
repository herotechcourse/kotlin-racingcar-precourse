package racingcar.util

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName

class InputValidatorTest {

    private val inputValidator = InputValidator()

    @Test
    @DisplayName("validateCars should return success with valid car names")
    fun validateCars_withValidCarNames_shouldReturnSuccess() {
        // Given
        val cars = listOf("car1", "car2", "car3")

        // When
        val result = inputValidator.validateCars(cars)

        // Then
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrNull()).isEqualTo(cars)
    }

    @Test
    @DisplayName("validateCars should return failure when cars is null")
    fun validateCars_withNullCars_shouldReturnFailure() {
        // When
        val result = inputValidator.validateCars(null)

        // Then
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result.exceptionOrNull()?.message).isEqualTo("Must provide a cars")
    }

    @Test
    @DisplayName("validateCars should return failure when cars is empty")
    fun validateCars_withEmptyCars_shouldReturnFailure() {
        // Given
        val emptyCars = emptyList<String>()

        // When
        val result = inputValidator.validateCars(emptyCars)

        // Then
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result.exceptionOrNull()?.message).isEqualTo("Must provide a cars")
    }

    @Test
    @DisplayName("validateCars should return failure when a car name exceeds 5 characters")
    fun validateCars_withLongCarName_shouldReturnFailure() {
        // Given
        val cars = listOf("car1", "car123456", "car3")

        // When
        val result = inputValidator.validateCars(cars)

        // Then
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result.exceptionOrNull()?.message).isEqualTo("Car name must be under 5 characters")
    }

    @Test
    @DisplayName("validateRounds should return success with valid rounds")
    fun validateRounds_withValidRounds_shouldReturnSuccess() {
        // Given
        val rounds = 5

        // When
        val result = inputValidator.validateRounds(rounds)

        // Then
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrNull()).isEqualTo(rounds)
    }

    @Test
    @DisplayName("validateRounds should return failure when rounds is null")
    fun validateRounds_withNullRounds_shouldReturnFailure() {
        // When
        val result = inputValidator.validateRounds(null)

        // Then
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result.exceptionOrNull()?.message).isEqualTo("Must provide a number")
    }

    @Test
    @DisplayName("validateRounds should return failure when rounds is negative")
    fun validateRounds_withNegativeRounds_shouldReturnFailure() {
        // Given
        val rounds = -1

        // When
        val result = inputValidator.validateRounds(rounds)

        // Then
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isInstanceOf(IllegalArgumentException::class.java)
        assertThat(result.exceptionOrNull()?.message).isEqualTo("Round must be greater than 0")
    }
}