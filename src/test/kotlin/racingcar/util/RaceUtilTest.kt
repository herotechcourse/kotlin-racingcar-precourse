package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RaceUtilTest {
    private val raceUtil = RaceUtil()

    @Test
    @DisplayName("readRounds should return valid rounds when input and validation are successful")
    fun readRounds_ValidInput_ReturnsValidatedValue() {
        // Given
        val inputProvider: () -> String? = { "5" }
        val validator: (Int?) -> Result<Int> = { Result.success(it!!) }

        // When
        val result = raceUtil.readRounds(inputProvider, validator)

        // Then
        assertThat(result).isEqualTo(5)
    }

    @Test
    @DisplayName("readRounds should call validator with null when input is null")
    fun readRounds_NullInput_PassesNullToValidator() {
        // Given
        val inputProvider: () -> String? = { null }
        var validatorInput: Int? = null

        val validator: (Int?) -> Result<Int> = { input ->
            validatorInput = input
            Result.success(10)
        }

        // When
        val result = raceUtil.readRounds(inputProvider, validator)

        // Then
        assertThat(validatorInput).isNull()
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("readRounds should call validator with null when input is not a valid number")
    fun readRounds_InvalidNumericInput_PassesNullToValidator() {
        // Given
        val inputProvider: () -> String? = { "not a number" }
        var validatorInput: Int? = null

        val validator: (Int?) -> Result<Int> = { input ->
            validatorInput = input
            Result.success(10)
        }

        // When
        val result = raceUtil.readRounds(inputProvider, validator)

        // Then
        assertThat(validatorInput).isNull()
        assertThat(result).isEqualTo(10)
    }

    @Test
    @DisplayName("readRounds should throw exception when validator returns failure")
    fun readRounds_ValidationFailure_ThrowsException() {
        // Given
        val inputProvider: () -> String? = { "5" }
        val expectedException = IllegalArgumentException("Invalid rounds")
        val validator: (Int?) -> Result<Int> = { Result.failure(expectedException) }

        // When/Then
        assertThatThrownBy { raceUtil.readRounds(inputProvider, validator) }.isEqualTo(expectedException)
    }

    @Test
    @DisplayName("readRounds should print the correct prompt message")
    fun readRounds_PrintsCorrectPrompt() {
        // Given
        val inputProvider: () -> String? = { "5" }
        val validator: (Int?) -> Result<Int> = { Result.success(it!!) }
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        try {
            // When
            raceUtil.readRounds(inputProvider, validator)

            // Then
            assertThat(outputStream.toString()).contains("How many rounds will be played?")
        } finally {
            System.setOut(originalOut)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "10", "100"])
    @DisplayName("readRounds should handle different valid numeric inputs")
    fun readRounds_DifferentValidInputs_ReturnsCorrectValue(input: String) {
        // Given
        val inputProvider: () -> String? = { input }
        val validator: (Int?) -> Result<Int> = { Result.success(it!!) }

        // When
        val result = raceUtil.readRounds(inputProvider, validator)

        // Then
        assertThat(result).isEqualTo(input.toInt())
    }
}
