package racingcar.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow

class TheNumberOfRoundsInputTest {
    @Test
    fun `does not throw exception when entering number type`() {
        //given
        val input = "5"

        // when & then
        assertDoesNotThrow {
            validateTheNumberOfRounds(input)
        }
    }

    @Test
    fun `throw exception when entering string type`() {
        //given
        val input = "Five"

        // when & then
        assertThrows<IllegalArgumentException> {
            validateTheNumberOfRounds(input)
        }
    }
}
