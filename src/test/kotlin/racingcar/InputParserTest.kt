package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun parseCarNames_validInput_returnsTrimmedNames() {
        val input = "pobi, jun, kim"
        val result = InputParser.parseCarNames(input)
        assertThat(result).containsExactly("pobi", "jun", "kim")
    }

    @Test
    fun parseCarNames_nameTooLong_throwsException() {
        val input = "pobi,javaji"
        assertThrows<IllegalArgumentException> {
            InputParser.parseCarNames(input)
        }
    }

    @Test
    fun parseCarNames_blankInput_throwsException() {
        assertThrows<IllegalArgumentException> {
            InputParser.parseCarNames("  ")
        }
    }

    @Test
    fun parseTotalRounds_validInput_returnsInteger() {
        val input = "5"
        val result = InputParser.parseTotalRounds(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun parseTotalRounds_invalidInput_throwsException() {
        val input = "abc"
        assertThrows<IllegalArgumentException> {
            InputParser.parseTotalRounds(input)
        }
    }

    @Test
    fun parseTotalRounds_zeroRounds_throwsException() {
        assertThrows<IllegalArgumentException> {
            InputParser.parseTotalRounds("0")
        }
    }
}
