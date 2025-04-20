import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.backend.domain.validator.RaceNameValidator
import racingcar.backend.exception.RacingError

class RaceNameValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n", "\t"])
    fun `should throw exception when car name is blank`(input: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            RaceNameValidator.validateCarNameIsBlank(input)
        }
        assertEquals(RacingError.CAR_NAME_BLANK.message, exception.message)
    }

    @Test
    fun `should not throw exception when car name is not blank`() {
        assertDoesNotThrow {
            RaceNameValidator.validateCarNameIsBlank("pobi")
        }
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            RaceNameValidator.validateCarNameLength("abcdef")
        }
        assertEquals(RacingError.CAR_NAME_TOO_LONG.message, exception.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
    fun `should not throw exception when car name is 5 characters or fewer`(name: String) {
        assertDoesNotThrow {
            RaceNameValidator.validateCarNameLength(name)
        }
    }
}
