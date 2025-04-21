package racingcar.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.constant.ErrorMessage.CAR_NAME_BLANK
import racingcar.constant.ErrorMessage.CAR_NAME_DUPLICATE
import racingcar.constant.ErrorMessage.CAR_NAME_TOO_LONG
import racingcar.constant.ErrorMessage.MINIMUM_CAR_COUNT

class CarNamesValidatorTest {
    @Test
    @DisplayName("Throw exception when less than two car names are provided")
    fun validateMinimumCarNames() {
        val carNames = listOf("pobi")
        assertThatThrownBy { CarNamesValidator.validate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(MINIMUM_CAR_COUNT)
    }

    @Test
    @DisplayName("Throw exception when a car name is blank")
    fun validateNonBlankCarNames() {
        val carNames = listOf("pobi", "")
        assertThatThrownBy { CarNamesValidator.validate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(CAR_NAME_BLANK)
    }

    @Test
    @DisplayName("Throw exception when car names are duplicated")
    fun validateUniqueCarNames() {
        val carNames = listOf("pobi", "pobi")
        assertThatThrownBy { CarNamesValidator.validate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(CAR_NAME_DUPLICATE)
    }

    @Test
    @DisplayName("Throw exception when a car name exceeds the maximum length")
    fun validateCarNameLength() {
        val carNames = listOf("pobi", "wonijun")
        assertThatThrownBy { CarNamesValidator.validate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(CAR_NAME_TOO_LONG)
    }
}