package racingcar.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import racingcar.view.exception.InputMessage.IS_NOT_NUMERIC
import racingcar.view.exception.InputMessage.OUT_OF_VALID_RANGE

class InputValidatorTest {
    @Test
    @DisplayName("[Exception] when provided none numeric")
    fun `test type validation`() {
        val stringInput = "howareu"
        Assertions.assertThatThrownBy {
            parseAndValidateInt(stringInput)
        }.hasMessage(IS_NOT_NUMERIC)
    }

    @Nested
    inner class RangeValidationTest {
        @Test
        @DisplayName("[Exception] when exceeded maximum value")
        fun `test maximum value`() {
            val longInput = "4545454111102334888"
            Assertions.assertThatThrownBy {
                parseAndValidateInt(longInput)
            }.hasMessage(OUT_OF_VALID_RANGE)
        }

        @Test
        @DisplayName("[Exception] when below the minimum value")
        fun `test minimum value`() {
            val outOfRangeInput = "0"
            Assertions.assertThatIllegalArgumentException().isThrownBy {
                parseAndValidateInt(outOfRangeInput)
            }.withMessage(OUT_OF_VALID_RANGE)
        }
    }
}