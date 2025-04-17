package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class InputValidatorTest {

    @Test
    fun `test valid car names returns trimmed list`() {
        val input = "yugo, opel, bmw"
        val result = InputValidator.validateCarNamesInput(input)
        assertThat(result).containsExactly("yugo", "opel", "bmw")
    }

    @Test
    fun `test car name too long throws exception`() {
        val input = "yugotel, opel, bmw"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNamesInput(input)
        }
        assertThat(exception).hasMessageContaining("Car names cannot exceed 5 characters long.")
    }

    @Test
    fun `test empty car name throws exception`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNamesInput(input)
        }
        assertThat(exception).hasMessageContaining("Car name cannot be empty.")
    }

    @Test
    fun `test duplicate car name throws exception`() {
        val input = "yugo, opel, opel"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNamesInput(input)
        }
        assertThat(exception).hasMessageContaining("Car names must be unique.")
    }

    @Test
    fun `test valid rounds returns number`() {
        val input = "5"
        val result = InputValidator.validateRoundsInput(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `test non-numeric rounds throws exception`() {
        val input = "bo"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundsInput(input)
        }
        assertThat(exception).hasMessageContaining("Rounds must be a number between 0 and 9.")
    }

    @Test
    fun `test less than 1 rounds throws exception`() {
        val input = "0"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundsInput(input)
        }
        assertThat(exception).hasMessageContaining("Rounds number must be greater than or equal to 1.")
    }
}
