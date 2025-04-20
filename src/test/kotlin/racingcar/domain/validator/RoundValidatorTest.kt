package racingcar.domain.validator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.backend.domain.validator.RoundValidator
import racingcar.backend.exception.RacingError

class RoundValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "\n", "\t", "a", "%", "3 "])
    fun `should throw exception when round input is not a valid number`(input: String) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            RoundValidator.validateRound(input)
        }
        assertEquals(RacingError.INVALID_ROUND.message, exception.message)
    }

    @Test
    fun `should not throw exception when round input is a valid number`() {
        assertDoesNotThrow {
            RoundValidator.validateRound("5")
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `should throw exception when round is not positive`(input: Int) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            RoundValidator.validatePositiveRound(input)
        }
        assertEquals(RacingError.INVALID_ROUND.message, exception.message)
    }

    @Test
    fun `should not throw exception when round is positive`() {
        assertDoesNotThrow {
            RoundValidator.validatePositiveRound(1)
        }
    }
}
