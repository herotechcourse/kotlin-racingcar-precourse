package racingcar.util

import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    @Test
    @DisplayName("Throws exception if car name exceeds 5 characters")
    fun carNameLengthTest() {
        val carNames = listOf("pobi", "polar", "ihavelongname")
        assertThatThrownBy { Validator.carNamesValidate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("Throws exception if there are duplicate car names")
    fun carNameDuplicateTest() {
        val carNames = listOf("pobi", "pobi", "ihavelongname")
        assertThatThrownBy { Validator.carNamesValidate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    @DisplayName("Throws exception if car name is blank")
    fun carNameIsBlankTest(input: String) {
        val carNames = listOf(input)
        assertThatThrownBy { Validator.carNamesValidate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["한글자동차", ";;;"])
    @DisplayName("Throws exception if car name contains non-alphanumeric characters")
    fun carNameMatchPatternTest(input: String) {
        val carNames = listOf(input)
        assertThatThrownBy { Validator.carNamesValidate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    @DisplayName("Throws exception if car name contains non-printable characters")
    fun carNameWithNonPrintableTest() {
        val carNames = listOf("pobi", "car1", "bear", "\u0007")
        assertThatThrownBy { Validator.carNamesValidate(carNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1000", "500"])
    @DisplayName("No exception for valid game round inputs")
    fun gameRoundValidateWithValidInput(input: String) {
        assertThatNoException().isThrownBy { Validator.gameRoundValidate(input) }
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Throws exception when game round input is null or empty")
    fun gameRoundIsEmptyTest(input: String?) {
        assertThatThrownBy { Validator.gameRoundValidate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "1.1"])
    @DisplayName("Throws exception when game round input is not a positive integer")
    fun gameRoundWithNegativeNumberTest(input: String) {
        assertThatThrownBy { Validator.gameRoundValidate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["10001", "1001", "000010000"])
    @DisplayName("Throws exception when game round input exceeds 1000")
    fun gameRoundIsBigNumberTest(input: String) {
        assertThatThrownBy { Validator.gameRoundValidate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
