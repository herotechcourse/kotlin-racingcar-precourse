package racingcar.validation

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class RoundsInputTest {

    @Test
    fun `test valid number of rounds`() {
        val input = "5"
        val rounds = validateRoundsInput(input)
        assertThat(rounds).isEqualTo(5)
    }

    @Test
    fun `test invalid input with non-numeric characters`() {
        val input = "six"
        assertThatThrownBy { validateRoundsInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("valid integer")
    }

    @Test
    fun `test invalid input with negative number`() {
        val input = "-5"
        assertThatThrownBy { validateRoundsInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("greater than 0")
    }

    @Test
    fun `test invalid input with zero`() {
        val input = "0"
        assertThatThrownBy { validateRoundsInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("greater than 0")
    }
}