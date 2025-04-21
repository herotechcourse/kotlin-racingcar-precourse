package racingcar.validator

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class RoundsValidatorTest {

    private val validator = RoundsValidator()

    @Test
    @DisplayName("valid positive integer string returns integer")
    fun `validate returns integer on valid input`() {
        assertThat(validator.validate("5")).isEqualTo(5)
    }

    @Test
    @DisplayName("zero rounds throws IllegalArgumentException")
    fun `validate throws on zero`() {
        assertThatThrownBy { validator.validate("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be a positive integer.")
    }

    @Test
    @DisplayName("negative number throws IllegalArgumentException")
    fun `validate throws on negative number`() {
        assertThatThrownBy { validator.validate("-3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be a positive integer.")
    }

    @Test
    @DisplayName("non‑integer input throws IllegalArgumentException")
    fun `validate throws on non integer`() {
        assertThatThrownBy { validator.validate("three") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be a positive integer.")
    }
}