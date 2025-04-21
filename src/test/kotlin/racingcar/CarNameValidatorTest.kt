package racingcar

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.InputValidationException
import racingcar.util.CarNameValidator

@DisplayName("CarNameValidator Tests")
class CarNameValidatorTest {

    @Test
    @DisplayName("Return name list if valid")
    fun returnNameListIfValid() {
        val validator = CarNameValidator(listOf("pobi", "woni"))
        assertThat(validator.validate()).containsExactly("pobi", "woni")
    }

    @Nested
    @DisplayName("Invalid name cases")
    inner class InvalidNameCases {

        @Test
        @DisplayName("Throw exception if name is blank")
        fun throwIfNameIsBlank() {
            val validator = CarNameValidator(listOf("pobi", ""))
            assertThatThrownBy { validator.validate() }
                .isInstanceOf(InputValidationException::class.java)
        }

        @ParameterizedTest
        @ValueSource(strings = ["abcdef", "longname", "2324521"])
        @DisplayName("Throw exception when name exceeds max length")
        fun throwIfNameTooLong(name: String) {
            val validator = CarNameValidator(listOf(name))
            assertThatThrownBy { validator.validate() }
                .isInstanceOf(InputValidationException::class.java)
        }
    }
}
