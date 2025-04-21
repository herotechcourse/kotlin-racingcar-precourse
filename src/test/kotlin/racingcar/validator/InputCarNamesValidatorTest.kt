package racingcar.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputCarNamesValidatorTest {

    private val validator = InputCarNamesValidator()

    @Test
    fun `throws exception when car name is blank`() {
        assertThrows<IllegalArgumentException> {
            validator.validate(listOf("pobi", ""))
        }
    }

    @Test
    fun `throws exception when car names are duplicated`() {
        assertThrows<IllegalArgumentException> {
            validator.validate(listOf("pobi", "pobi"))
        }
    }

    @Test
    fun `throws exception when car name exceeds 5 characters`() {
        assertThrows<IllegalArgumentException> {
            validator.validate(listOf("pobi", "abcdefgh"))
        }
    }
}
