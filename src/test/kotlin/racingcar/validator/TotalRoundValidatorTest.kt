package racingcar.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.constant.ErrorMessage.TOTAL_ROUND_BLANK
import racingcar.constant.ErrorMessage.TOTAL_ROUND_NOT_NUMERIC
import racingcar.constant.ErrorMessage.TOTAL_ROUND_NOT_POSITIVE

class TotalRoundValidatorTest {
    @Test
    @DisplayName("Throw exception when round input is blank")
    fun validateNonBlankRoundInput() {
        assertThatThrownBy { TotalRoundValidator.validate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(TOTAL_ROUND_BLANK)
    }

    @Test
    @DisplayName("Throw exception when round input is not a positive integer")
    fun validateOnlyDigitsRoundInput() {
        assertThatThrownBy { TotalRoundValidator.validate("2.5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(TOTAL_ROUND_NOT_NUMERIC)
    }

    @Test
    @DisplayName("Throw exception when round input is 0 or less")
    fun validatePositiveRoundInput() {
        assertThatThrownBy { TotalRoundValidator.validate("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(TOTAL_ROUND_NOT_POSITIVE)
    }
}