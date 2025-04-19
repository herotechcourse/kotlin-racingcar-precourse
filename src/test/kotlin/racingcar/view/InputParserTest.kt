package racingcar.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputParserTest {
    private val parser = InputParser()

    @Test
    fun `Parse the car name input separated by commas`() {
        val input = "pobi, anna, tebah"

        val carNames = parser.parseCarNames(input)

        assertEquals(listOf("pobi", "anna", "tebah"), carNames)
    }

    @ParameterizedTest
    @ValueSource(strings = ["  ", ""])
    fun `Throws an exception if car names input is empty`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parseCarNames(input)
        }
        assertEquals("Input must not be empty.", exception.message)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "'5 ', 5",
        "'    6', 6",
        "'  10  ', 10"
    )
    fun `Parse the number of rounds`(input: String, expected: Int) {
        val result = parser.parseNumberOfRounds(input)
        assertEquals(expected, result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["  ", ""])
    fun `Throws an exception if number of rounds input is empty`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parseNumberOfRounds(input)
        }
        assertEquals("Input must not be empty.", exception.message)
    }

    @Test
    fun `Throws an exception if number of rounds input is not a number`() {
        val input = "one"

        val exception = assertThrows<IllegalArgumentException> {
            parser.parseNumberOfRounds(input)
        }
        assertEquals("The Round number input is not possible, not numbers.", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "0"])
    fun `Throws an exception if number of rounds input is less than zero`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            parser.parseNumberOfRounds(input)
        }
        assertEquals("The round number input should be larger than zero.", exception.message)
    }

    @Test
    fun `Throws an exception if there are multiple inputs`() {
        val input = "1 6"

        val exception = assertThrows<IllegalArgumentException> {
            parser.parseNumberOfRounds(input)
        }
        assertEquals("Only one number of rounds can be entered.", exception.message)
    }
}
