package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {

    private val validator = Validator()

    @Test
    @DisplayName("Should accept valid car names")
    fun acceptValidCarNames() {
        // No exception expected
        validator.validateCarNames("car,a,ab,abc,abcde")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    @DisplayName("Should reject empty input")
    fun rejectEmptyInput(input: String) {
        assertThatThrownBy { validator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be empty")
    }

    @Test
    @DisplayName("Should reject empty car names")
    fun rejectEmptyCarNames() {
        assertThatThrownBy { validator.validateCarNames("car,,abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be empty")
    }

    @Test
    @DisplayName("Should reject car names exceeding 5 characters")
    fun rejectLongCarNames() {
        assertThatThrownBy { validator.validateCarNames("car,toolong,abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }

    @Test
    @DisplayName("Should accept valid round count")
    fun acceptValidRoundCount() {
        // No exception expected
        validator.validateRoundCount("5")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "-5"])
    @DisplayName("Should reject non-positive round count")
    fun rejectNonPositiveRoundCount(input: String) {
        assertThatThrownBy { validator.validateRoundCount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number of rounds must be positive")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "abc", "1.5"])
    @DisplayName("Should reject invalid integer format")
    fun rejectInvalidIntegerFormat(input: String) {
        assertThatThrownBy { validator.validateRoundCount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number of rounds must be a valid integer")
    }
}