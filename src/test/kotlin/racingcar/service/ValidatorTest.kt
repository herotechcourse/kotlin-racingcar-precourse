package racingcar.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `throws if round is zero`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePositiveRoundCount("0")
        }
    }

    @Test
    fun `throws if round is negative`() {
        assertThrows<IllegalArgumentException> {
            Validator.validatePositiveRoundCount("-5")
        }
    }

    @Test
    fun `throws if round is not a number`() {
        assertThrows<NumberFormatException> {
            Validator.validatePositiveRoundCount("abc")
        }
    }

    @Test
    fun `throws if car name is longer than 5`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateCarName("toolong")
        }
    }

    @Test
    fun `throws if car name is empty`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateCarName("")
        }
    }
}