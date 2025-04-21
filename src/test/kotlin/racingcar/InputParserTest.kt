package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun `should parse valid car names`() {
        val result = parseCarNames("pobi, woni, jun")
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `should throw exception for empty input`() {
        assertThrows<IllegalArgumentException> {
            parseCarNames("")
        }
    }

    @Test
    fun `should throw exception for name over 5 chars`() {
        assertThrows<IllegalArgumentException> {
            parseCarNames("pobi,superman,jun")
        }
    }

    @Test
    fun `should throw exception for empty name between commas`() {
        assertThrows<IllegalArgumentException> {
            parseCarNames("pobi, ,jun")
        }
    }

    @Test
    fun `should throw if car names are duplicated`() {
        assertThrows<IllegalArgumentException> {
            parseCarNames("pobi,jun,pobi")
        }
    }

    @Test
    fun `should parse valid round count`() {
        val result = parseRoundCount("3")
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `should throw for blank round input`() {
        assertThrows<IllegalArgumentException> {
            parseRoundCount("")
        }
    }

    @Test
    fun `should throw for non-numeric round input`() {
        assertThrows<IllegalArgumentException> {
            parseRoundCount("abc")
        }
    }

    @Test
    fun `should throw if round count is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            parseRoundCount("-1")
        }

        assertThrows<IllegalArgumentException> {
            parseRoundCount("0")
        }
    }


}