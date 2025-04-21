package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.InputValidationException
import racingcar.util.NumberValidator

@DisplayName("NumberValidator Tests")
class NumberValidatorTest {

    @Test
    @DisplayName("Return number if valid")
    fun returnNumberIfValid() {
        val validator = NumberValidator("3")
        assertThat(validator.validate()).isEqualTo(3)
    }

    @Nested
    @DisplayName("Validation input cases")
    inner class InvalidInputs {

        @ParameterizedTest
        @ValueSource(strings = ["abc", "", " "])
        @DisplayName("Throw exception when input is not a valid number")
        fun throwIfNotNumber(input: String) {
            val validator = NumberValidator(input)
            assertThatThrownBy { validator.validate() }
                .isInstanceOf(InputValidationException::class.java)
        }

        @ParameterizedTest
        @ValueSource(strings = ["0", "-1", "-100"])
        @DisplayName("Throw exception when number is zero or negative")
        fun throwIfNumberNonPositive(input: String) {
            val validator = NumberValidator(input)
            assertThatThrownBy { validator.validate() }
                .isInstanceOf(InputValidationException::class.java)
        }
    }
}
