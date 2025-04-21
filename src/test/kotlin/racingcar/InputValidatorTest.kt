package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `should throw exception when car name is blank`() {
        val names = listOf("pobi", "  ")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        val names = listOf("abcdef")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }

    @Test
    fun `should throw exception for duplicate car names`() {
        val names = listOf("pobi", "pobi")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }

    @Test
    fun `should throw exception for invalid round count input`() {
        val input = "abc"
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount(input)
        }
    }

    @Test
    fun `should throw exception when round count is zero or negative`() {
        val input = "-1"
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount(input)
        }
    }
}