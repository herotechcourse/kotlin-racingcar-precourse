package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputHandlerTest {
    @Test
    @DisplayName("parseCarNames splits and trims valid input")
    fun parseCarNamesSplitsAndTrimsValidInput() {
        val names = InputHandler.parseCarNames("pobi, woni ,jun,duc")
        assertThat(names).containsExactly("pobi", "woni", "jun", "duc")
    }

    @Test
    @DisplayName("parseCarNames throws on empty raw string")
    fun parseCarNamesThrowsOnEmptyRawString() {
        assertThatThrownBy { InputHandler.parseCarNames("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must not be empty")
    }

    @Test
    @DisplayName("parseCarNames throws when any name too long")
    fun parseCarNamesThrowsWhenAnyNameTooLong() {
        assertThatThrownBy { InputHandler.parseCarNames("pobi,minhducnguyen") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("parseRoundCount parses a positive integer")
    fun parseRoundCountParsesAPositiveInteger() {
        assertThat(InputHandler.parseRoundCount("  8 ")).isEqualTo(8)
    }

    @Test
    @DisplayName("parseRoundCount throws on zero or negative")
    fun parseRoundCountThrowsOnZeroOrNegative() {
        assertThatThrownBy { InputHandler.parseRoundCount("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("parseRoundCount throws on non-integer")
    fun parseRoundCountThrowsOnNonInteger() {
        assertThatThrownBy { InputHandler.parseRoundCount("eight") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
