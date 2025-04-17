package racingcar.parser

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameParserTest {

    @Test
    @DisplayName("Parse comma separated car names correctly")
    fun parseCommaSeperatedCarNames() {
        val input = "joko,anis,bowo"
        val result = CarNameParser.parse(input)
        assertEquals(3, result.size)
        assertEquals("joko", result[0])
        assertEquals("anis", result[1])
        assertEquals("bowo", result[2])
    }

    @Test
    @DisplayName("Parse a single car name correctly")
    fun parseSingleCarName() {
        val input = "joko"
        val result = CarNameParser.parse(input)
        assertEquals(1, result.size)
        assertEquals("joko", result[0])
    }

    @Test
    @DisplayName("Throw exception for empty input")
    fun throwExceptionForEmptyInput() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Car names cannot be empty", exception.message)
    }

    @Test
    @DisplayName("Throw exception for blank input (only whitespace)")
    fun throwExceptionForBlankInput() {
        val input = "   "
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Car names cannot be empty", exception.message)
    }

    @Test
    @DisplayName("Throw exception for space-separated names instead of comma-separated")
    fun throwExceptionForSpaceSeperatedNames() {
        val input = "joko anis bowo"
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Multiple car names must be separated by commas, not spaces", exception.message)
    }

    @Test
    @DisplayName("Handle whitespace around input")
    fun handleSpacesAroundCommas() {
        val input = " joko, anis , bowo "
        val result = CarNameParser.parse(input)
        assertEquals(3, result.size)
        assertEquals("joko", result[0])
        assertEquals("anis", result[1])
        assertEquals("bowo", result[2])
    }

    @Test
    @DisplayName("Throw exception for empty car name")
    fun throwExceptionForEmptyCarName() {
        val input = "joko,,anis"
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Car name cannot be blank", exception.message)
    }

    @Test
    @DisplayName("Throw exception for car name exceeding 5 characters")
    fun throwExceptionForLongCarName() {
        val input = "joko,gibran,bowo"
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Car name cannot exceed 5 characters", exception.message)
    }

    @Test
    @DisplayName("Throw exception for duplicate car names")
    fun throwExceptionForDuplicateCarName() {
        val input = "joko,anis,joko"
        val exception = assertThrows<IllegalArgumentException> {
            CarNameParser.parse(input)
        }

        assertEquals("Duplicated car name : joko", exception.message)
    }
}