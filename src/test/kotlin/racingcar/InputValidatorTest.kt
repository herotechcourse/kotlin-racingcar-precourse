package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `validateCarNames should throw exception for empty list`() {
        assertThatThrownBy { InputValidator.validateCarNames(emptyList()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names cannot be empty")
    }

    @ParameterizedTest
    @ValueSource(strings = ["toolong", "sixxxx", "abcdef"])
    fun `validateCarNames should throw exception when car name exceeds 5 characters`(longName: String) {
        assertThatThrownBy { InputValidator.validateCarNames(listOf("pobi", longName)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }

    @Test
    fun `validateRounds should throw exception for non-integer input`() {
        assertThatThrownBy { InputValidator.validateRounds("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be a valid integer")
    }

    @Test
    fun `validateRounds should throw exception for negative input`() {
        assertThatThrownBy { InputValidator.validateRounds("-5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be positive")
    }

    @Test
    fun `validateRounds should return integer for valid input`() {
        val result = InputValidator.validateRounds("5")
        assertThat(result).isEqualTo(5)
    }
}