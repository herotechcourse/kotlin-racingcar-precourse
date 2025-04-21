package racingcar.utils

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `input is empty - fail`() {
        val names = listOf("pobi", "", "jun")
        assertThrows<IllegalArgumentException> {
            Validator.carValidate(names)
        }
    }

    @Test
    fun `input is valid - success`() {
        val names = listOf("pobi", "woni", "jun")
        assertThatCode {
            Validator.carValidate(names)
        }.doesNotThrowAnyException()
    }
}