package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.validation.CarNameValidator

class CarNameValidatorTest {
    @Test fun `valid names parse correctly`() {
        val list = CarNameValidator.validate("pobi,woni,jun")
        assertEquals(listOf("pobi","woni","jun"), list)
    }
    @Test fun `empty input throws`() {
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate("")
        }
    }
    @Test fun `duplicate names throw`() {
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate("pobi,pobi")
        }
    }
    @Test fun `invalid chars throw`() {
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate("pobi,wo@ni")
        }
    }
    @Test fun `too long name throws`() {
        assertThrows<IllegalArgumentException> {
            CarNameValidator.validate("longname,ok")
        }
    }
}
