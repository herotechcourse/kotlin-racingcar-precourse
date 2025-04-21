package racingcar.domain

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `round must be numeric`() {
        assertThrows(IllegalArgumentException::class.java) {
            Round.from("abc")
        }
    }

    @Test
    fun `round must be positive number`() {
        assertThrows(IllegalArgumentException::class.java) {
            Round.from("-5")
        }
    }
}