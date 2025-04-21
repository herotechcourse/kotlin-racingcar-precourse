package racingcar.domain

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `round must be positive integer`() {
        assertThrows(IllegalArgumentException::class.java) {
            Round.from("abc")
        }

        assertThrows(IllegalArgumentException::class.java) {
            Round.from("-5")
        }
    }
}