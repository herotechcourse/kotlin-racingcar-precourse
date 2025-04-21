package racingcar.validation

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*

class RoundValidatorTest {

    @Test
    fun `minimum valid round count is 1`() {
        assertThatCode { RoundValidator.validate("1") }
            .doesNotThrowAnyException()
    }

    @Test
    fun `zero round count throw exception`() {
        assertThatThrownBy { RoundValidator.validate("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round count must be greater than 0.")
    }

    @Test
    fun `negative round count throw exception`() {
        assertThatThrownBy { RoundValidator.validate("-5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round count must be greater than 0.")
    }

    @Test
    fun `non-numeric input throw exception`() {
        assertThatThrownBy { RoundValidator.validate("5a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round count must be a valid integer.")
    }
}
