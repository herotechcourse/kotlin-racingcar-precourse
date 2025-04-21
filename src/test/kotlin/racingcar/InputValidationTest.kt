package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidationTest {

    @Test
    fun `validateCarName throws when name is empty`() {
        assertThrows<IllegalArgumentException> {
            validateCarName("")
        }
    }

    @Test
    fun `validateCarName throws when name is longer than 5 characters`() {
        assertThrows<IllegalArgumentException> {
            validateCarName("abcdef")
        }
    }

    @Test
    fun `validateCarName accepts valid name`() {
        // should not throw
        validateCarName("jun")
    }
}
