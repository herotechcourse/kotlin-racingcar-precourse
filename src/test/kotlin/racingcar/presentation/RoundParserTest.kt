package racingcar.presentation

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RoundParserTest {

    @Test
    fun `parse returns integer when input is numeric`() {
        // given
        val rawInput = "5"

        // when
        val result = RoundParser.parse(rawInput)

        // then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `parse throws IllegalArgumentException when input is not numeric`() {
        // given
        val rawInput = "abc"

        // when / then
        assertThatThrownBy { RoundParser.parse(rawInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.ROUND_NOT_INTEGER)
    }
}
