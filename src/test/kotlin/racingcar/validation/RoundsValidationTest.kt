package racingcar.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import racingcar.util.Validator

class RoundsValidationTest {
    @Test
    fun `returns number when input is valid`() {
        val result = Validator.validateRoundNumber("3")
        assertEquals(3, result)
    }

    @Test
    fun `throws exception when input is zero`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRoundNumber("0")
        }
    }

    @Test
    fun `throws exception when input is negative`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRoundNumber("-1")
        }
    }

    @Test
    fun `throws exception when input is float`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRoundNumber("2.3")
        }
    }

    @Test
    fun `throws exception when input is bigger than integer`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRoundNumber("2147483648")
        }
    }

    @Test
    fun `throws exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateRoundNumber("abc")
        }
    }
}