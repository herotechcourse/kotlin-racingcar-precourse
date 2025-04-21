// ValidatorTest.kt
package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `throw exception when car name is more than 5 characters`() {
        val names = listOf("pobi", "woni", "junwoo")
        assertThatThrownBy { Validator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은")
    }

    @Test
    fun `throw exception when there is duplicate car name`() {
        val names = listOf("pobi", "pobi", "jun")
        assertThatThrownBy { Validator.validateCarNames(names) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("중복된")
    }

    @Test
    fun `throw exception when round count is not a number`() {
        assertThatThrownBy { Validator.validateRoundCount("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자")
    }

    @Test
    fun `throw exception when round count is less than 1`() {
        assertThatThrownBy { Validator.validateRoundCount("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("1 이상")
    }
}
