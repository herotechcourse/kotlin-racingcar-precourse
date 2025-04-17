package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.view.exception.InputMessage.EXCEED_INT_RANGE
import racingcar.view.exception.InputMessage.IS_NOT_NUMERIC

class InputValidatorTest {
    @Test
    @DisplayName("[Exception] when provided none numeric")
    fun `test type validation`() {
        val stringInput = "howareu"
        Assertions.assertThatThrownBy {
            parseAndValidateInt(stringInput)
        }.hasMessage(IS_NOT_NUMERIC)
    }

    @Test
    @DisplayName("[Exception] when exceeded integer range")
    fun `test range validation`() {
        val longInput = "4545454111102334888"
        Assertions.assertThatThrownBy {
            parseAndValidateInt(longInput)
        }.hasMessage(EXCEED_INT_RANGE)
    }
}