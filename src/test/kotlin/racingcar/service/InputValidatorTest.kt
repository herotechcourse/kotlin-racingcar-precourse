package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.ExceptionMessage

class InputValidatorTest {
    @Test
    fun `car name is empty string`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(listOf(""))
        }
        assertThat(exception.message).isEqualTo(ExceptionMessage.EMPTY_CAR_NAME.message)
    }

    @Test
    fun `car name contains whitespace`() {
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(listOf("po bi"))
        }
        assertThat(exception.message).isEqualTo(ExceptionMessage.WHITESPACE_IN_CAR_NAME.message)
    }

}