package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `Car name list must not be empty`() {
        assertThatThrownBy { Validator.validateCarNames("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("At least one car name")
    }

    @Test
    fun `Car name must not be empty or blank`() {
        assertThatThrownBy { Validator.validateCarNames("pobi, ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be empty")
    }

    @Test
    fun `Car name must not exceed 5 characters`() {
        assertThatThrownBy { Validator.validateCarNames("abcdef") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("longer than 5")
    }

    @Test
    fun `Round input must be a valid positive number`() {
        assertThatThrownBy { Validator.validateRounds("-1") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("greater than 0")

        assertThatThrownBy { Validator.validateRounds("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be a number")
    }
}
