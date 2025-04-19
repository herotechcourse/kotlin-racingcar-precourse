package racingcar.validation

/**
 *  [ Condition ]
 *  1. Not exceed 5 characters.     // "abcdef"
 *  2. Not blank (null or empty)    // "" or " "
 *  3. Comma-separated format.      // "pobi,woni,jun"
 */
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ValidateCarNamesTest {

    @Test
    fun `returns true when input is a single valid name with no commas`() {
        val input = "pobi"
        val result = isValidCarNames(input)
        assertTrue(result)
    }

    @Test
    fun `returns false when any name exceeds 5 characters`() {
        val input = "pobi,woni,junjunjun"
        val result = isValidCarNames(input)
        assertFalse(result)
    }

    @Test
    fun `returns false when any name is blank`() {
        val input = "pobi, ,jun"
        val result = isValidCarNames(input)
        assertFalse(result)
    }

    @Test
    fun `returns false when input is an empty string`() {
        val input = ""
        val result = isValidCarNames(input)
        assertFalse(result)
    }

    @Test
    fun `returns true when all names are comma-separated and each is 5 chars or less`() {
        val input = "pobi,woni,jun"
        val result = isValidCarNames(input)
        assertTrue(result)
    }
}
