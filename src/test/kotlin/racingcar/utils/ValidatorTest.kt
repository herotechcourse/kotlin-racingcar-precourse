import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.junit.jupiter.params.provider.CsvSource
import org.assertj.core.api.Assertions.*

import racingcar.utils.Validator


class ValidatorTest {
    @Nested
    @DisplayName("Round validation tests")
    inner class RoundValidationTests {
        @ParameterizedTest
        @CsvSource("1, 1", "3, 3", "23, 23", "1024, 1024")
        @DisplayName("Should return valid round integer when input is a bigger than zero")
        fun validatePositiveRounds(input: String, expected: Int) {
            val result = Validator.validateRounds(input)
            assertThat(result).isEqualTo(expected)
        }

        @ParameterizedTest
        @ValueSource(strings = ["0", "-1", "-2147483647"])
        @DisplayName("Should throw IllegalArgumentException when round count is zero or negative")
        fun validateNonPositiveRounds(input: String) {
            assertThatThrownBy { validator.validateRounds(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Round count must be positive")
        }

        @ParameterizedTest
        @ValueSource(strings = ["foo", "1.5", "3a", " "])
        @DisplayName("Should throw when round count is not a number")
        fun validateNonNumberRounds(input: String) {
            assertThatThrownBy { validator.validateRounds(input) }
                .isInstance(IllegalArgumentException::class.java)
                .hasMessage("Round count must be a number")
        }
    }

    @Nested
    @DisplayName("Car name validation tests")
    inner class CarNameValidationTests {
        @ParameterizedTest
        @CsvSource("car1|car1", "car1,car2|car1,car2", "pobi,woni,jun|pobi,woni,jun")
        @DisplayName("Should return valid car names when input is correct")
        fun validateCorrectCarNames(input: String, expectedString: String) {
            val expected = expectedString.split(",")
            val result = Validator.validateCarNames(input)
            assertThat(result).containsExaclyElementsOf(expected)
        }

        @Test
        @DisplayName("Should trim whitespace from car names")
        fun validateTrimmedCarNames() {
            val result = Validator.validateCarNames(" car1 , car2 , car3 ")
            assertThat(result).containsExactly("car1", "car2", "car3")
        }

        @Test
        @DisplayName("Should throw when input is empty")
        fun validateEmptyInput() {
            assertThatThrownBy { Validator.validateCarNames("") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("At least one car name must be provider")
        }

        @ParameterizedTest
        @ValueSource(strings = [",", " , ", ",,"])
        @DisplayName("Should throw when car name is empty")
        fun validateEmptyCarName(input: String) {
            assertThatThrownBy { Validator.validateCarNames(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car name cannot be empty")
        }

        @ParameterizedTest
        @ValueSource(strings = ["123456789", "longcarname", "abcdef"])
        @DisplayName("Should throw when car name exceeds 5 characters")
        fun validateTooLongCarName(input: String) {
            assertThatThrownBy { Validator.validateCarNames(input) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car name cannot exceed 5 characters")
        }

        @Test
        @DisplayName("Should throw when one car name in list exceeds 5 characters")
        fun validateOneInvalidLenCarName() {
            assertThatThrownBy { Validator.validatehcaranames("car1,123456,car3") }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("Car name cannot exceed 5 characters")
        }
    }
}