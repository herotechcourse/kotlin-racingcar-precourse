package racingcar.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameParserTest {

    private val parser = CarNameParser()

    @Nested
    inner class `When input is valid` {

        @Test
        fun `it should return list of CarNames when comma-separated names are given`() {
            val input = "pobi,woni"
            val result = parser.parse(input)

            assertThat(result).hasSize(2)
            assertThat(result.map { it.value() }).containsExactly("pobi", "woni")
        }
    }

    @Nested
    inner class `When input is invalid` {

        @ParameterizedTest(name = "not comma-separated: {0}")
        @ValueSource(strings = ["pobi", "pobi woni", "pobi|woni", "pobi/woni"])
        fun `should throw when input is not comma-separated`(input: String) {
            val exception = assertThrows<IllegalArgumentException> {
                parser.parse(input)
            }
            assertThat(exception.message).isEqualTo(CarNameParser.ERROR_MUST_BE_COMMA_SEPARATED)
        }

        @ParameterizedTest(name = "contains blank name: {0}")
        @ValueSource(strings = ["pobi,", ",pobi", ",", "pobi, ", " ,woni", "pobi,,woni", " , "])
        fun `should throw when any name is blank`(input: String) {
            val exception = assertThrows<IllegalArgumentException> {
                parser.parse(input)
            }
            assertThat(exception.message).isEqualTo(CarNameParser.ERROR_BLANK_NAME)
        }
    }
}
