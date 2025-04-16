package racingcar.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
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
    fun `Throws an exception if input is empty`(input: String) {
        assertThrows<IllegalArgumentException> {
            parser.parseCarNames(input)
        }
    }
}
