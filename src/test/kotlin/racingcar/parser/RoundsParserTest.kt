package racingcar.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RoundsParserTest {
    private val roundsParser = RoundsParser()
    @Test
    @DisplayName("Valid number of rounds should be parsed correctly")
    fun parseValidRounds() {
        val validInput = "14"
        val result = roundsParser.parse(validInput)
        assertThat(result).isEqualTo(14)
    }

    @Test
    @DisplayName("Throw exception for empty input")
    fun throwExceptionForEmptyInput() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            roundsParser.parse(input)
        }
        assertEquals("The number of rounds cannot be empty and must be a valid number", exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-10"])
    @DisplayName("Throw exception for rounds less than 1")
    fun throwExceptionTooSmallRounds(invalidInput: String) {
        val exception = assertThrows<IllegalArgumentException> {
            roundsParser.parse(invalidInput)
        }
        assertThat(exception.message).isEqualTo("Rounds must be more than 0")
    }

    @ParameterizedTest
    @ValueSource(strings = ["16", "20", "100"])
    @DisplayName("Throw exception for rounds more than 15")
    fun throwExceptionForTooLargeRounds(invalidInput: String) {
        val exception = assertThrows<IllegalArgumentException> {
            roundsParser.parse(invalidInput)
        }
        assertThat(exception.message).isEqualTo("Rounds must be less than 15")
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "14bcd"])
    @DisplayName("Throw exception for non-numeric input")
    fun parseNonNumericRounds(invalidInput: String) {
        val exception = assertThrows<IllegalArgumentException> {
            roundsParser.parse(invalidInput)
        }
        assertThat(exception.message).isEqualTo("Rounds must be a number")
    }
}