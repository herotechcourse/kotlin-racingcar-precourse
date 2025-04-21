package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundsInputTest {

    @Test
    fun `parseRounds returns integer on valid input`() {
        assertThat(parseRounds("5")).isEqualTo(5)
    }

    @Test
    fun `parseRounds throws on non-numeric input`() {
        assertThrows<IllegalArgumentException> {
            parseRounds("abc")
        }
    }

    @Test
    fun `parseRounds throws on non-positive input`() {
        assertThrows<IllegalArgumentException> {
            parseRounds("0")
        }
    }
}
