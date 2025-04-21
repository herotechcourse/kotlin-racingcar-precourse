package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun `should parse valid car names`() {
        val result = "Car1, Car2, Car3".toCars()

        assertEquals(3, result.size)
        assertEquals("Car1", result[0].name)
        assertEquals("Car2", result[1].name)
        assertEquals("Car3", result[2].name)
    }

    @Test
    fun `should throw exception for empty input`() {
        assertThrows<IllegalArgumentException> {
            "".toCars()
        }
    }

    @Test
    fun `should throw exception for name over 5 chars`() {
        assertThrows<IllegalArgumentException> {
            "pobi,superman,jun".toCars()
        }
    }

    @Test
    fun `should throw exception for empty name between commas`() {
        assertThrows<IllegalArgumentException> {
            "pobi, ,jun".toCars()
        }
    }

    @Test
    fun `should throw if car names are duplicated`() {
        assertThrows<IllegalArgumentException> {
            "pobi,jun,pobi".toCars()
        }
    }

    @Test
    fun `should parse valid round count`() {
        val result = "3".toNumberOfRounds()
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `should throw for blank round input`() {
        assertThrows<IllegalArgumentException> {
            "".toNumberOfRounds()
        }
    }

    @Test
    fun `should throw for non-numeric round input`() {
        assertThrows<IllegalArgumentException> {
            "abc".toNumberOfRounds()
        }
    }

    @Test
    fun `should throw if round count is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            "-1".toNumberOfRounds()
        }

        assertThrows<IllegalArgumentException> {
            "0".toNumberOfRounds()
        }
    }

}