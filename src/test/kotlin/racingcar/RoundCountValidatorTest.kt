package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validation.RoundCountValidator

class RoundCountValidatorTest {
    @Test fun `valid positive integer returns int`() {
        assertEquals(3, RoundCountValidator.validate("3"))
    }
    @Test fun `zero throws`() {
        assertThrows<IllegalArgumentException> {
            RoundCountValidator.validate("0")
        }
    }
    @Test fun `non-numeric throws`() {
        assertThrows<IllegalArgumentException> {
            RoundCountValidator.validate("abc")
        }
    }
}
