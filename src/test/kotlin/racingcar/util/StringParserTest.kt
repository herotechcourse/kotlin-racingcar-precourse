package racingcar.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @Test
    fun `should parse string by delimiter`() {
        // given
        val input = "pobi,woni,jii"
        val delimiter = ","
        // when
        val result = StringParser.parseByDelimiter(input, delimiter)
        // then
        assertAll(
            { assertThat(result).hasSize(3) },
            { assertThat(result.containsAll(listOf("pobi", "woni", "jii"))) }
        )
    }

    @Test
    fun `should parse string to int`() {
        // given
        val input = "7"
        // when
        val result = StringParser.parseToInt(input)
        // then
        assertThat(result).isEqualTo(7)
    }

    @ParameterizedTest
    @ValueSource(strings = ["o", "l", " "])
    fun `throw exception when the input is not a number`(input: String) {
        assertThatThrownBy { StringParser.parseToInt(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Input value must be a number.")
    }
}
