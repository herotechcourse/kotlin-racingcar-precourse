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
}
