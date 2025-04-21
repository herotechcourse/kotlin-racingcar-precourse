package racingcar.domain

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class RoundTest {
    @Test
    fun `round must be a number`() {
        assertThrows(IllegalArgumentException::class.java) {
            Round.from("abc")
        }
    }
}