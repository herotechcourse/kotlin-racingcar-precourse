package racingcar.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.parser.RoundParser.Companion.NOT_A_NUMBER

class RoundParserTest {

    private val parser = RoundParser()

    @Nested
    inner class `Success` {

        @ParameterizedTest(name = "valid number input: {0}")
        @ValueSource(strings = ["1", "3", "10", "999"])
        fun `should return integer when input is numeric`(input: String) {
            val result = parser.parse(input)
            assertThat(result).isEqualTo(input.toInt())
        }
    }

    @Nested
    inner class `Failure` {

        @ParameterizedTest(name = "invalid input: {0}")
        @ValueSource(strings = ["a", "1a", "", " ", "-", "1.5"])
        fun `should throw exception when input is not numeric`(input: String) {
            val exception = assertThrows<IllegalArgumentException> {
                parser.parse(input)
            }
            assertThat(exception.message).isEqualTo(NOT_A_NUMBER)
        }
    }
}
