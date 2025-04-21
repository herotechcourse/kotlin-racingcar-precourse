package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidationTest {

    @Test
    fun `throws when car name is blank or longer than 5 characters`() {
        assertThatThrownBy {
            Validator.validateCarNames(listOf("pobi", "longname"))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `throws when round count is 0 or negative`() {
        assertThatThrownBy {
            Validator.validateRoundCount(0)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `passes for valid car names and rounds`() {
        Validator.validateCarNames(listOf("pobi", "jun"))
        Validator.validateRoundCount(3)

    }
    @Test
    fun `throws when car names list is empty`() {
        assertThatThrownBy {
            Validator.validateCarNames(emptyList())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
    @Test
    fun `throws when car name is all whitespace`() {
        assertThatThrownBy {
            Validator.validateCarNames(listOf("pobi", "   "))
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

}
