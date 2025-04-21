package racingcar.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputCountValidatorTest {

    private val validator = InputCountValidator()

    @Test
    fun `throws exception when input is blank`() {
        assertThrows<IllegalArgumentException> {
            validator.validate(" ")
        }
    }

    @Test
    fun `throws exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            validator.validate("abc")
        }
    }

    @Test
    fun `throws exception when input is zero or negative`() {
        assertThrows<IllegalArgumentException> {
            validator.validate("0")
        }
    }

    @Test
    fun `does not throw exception when input is valid`() {
        validator.validate("5")
    }
}
