package racingcar.validation

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateRoundsTest {

    @Test
    fun `returns true when input is a positive integer`() {
        val input = "7"
        val result = isValidRounds(input)
        assertTrue(result)
    }

    @Test
    fun `returns false when input is zero`() {
        val input = "0"
        val result = isValidRounds(input)
        assertFalse(result)
    }

    @Test
    fun `returns false when input is a negative number`() {
        val input = "-7"
        val result = isValidRounds(input)
        assertFalse(result)
    }

    @Test
    fun `returns false when input contains non-digit chars`() {
        val input = "3a"
        val result = isValidRounds(input)
        assertFalse(result)
    }

    @Test
    fun `returns false when input is empty`() {
        val input = ""
        val result = isValidRounds(input)
        assertFalse(result)
    }
}
