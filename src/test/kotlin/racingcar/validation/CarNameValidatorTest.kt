package racingcar.validation

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarNameValidatorTest {

    @Test
    fun `should pass for valid car name within length limit`() {
        val validCarName = "benz"

        // Simulate user input and validate
        CarNameValidator.validate(validCarName)
    }

    @Test
    fun `should throw IllegalArgumentException for car name longer than 5 characters`() {
        val invalidCarName = "mustang"  // Name with more than 5 characters

        assertThatThrownBy { CarNameValidator.validate(invalidCarName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exceeds max length")
    }


    @Test
    fun `should throw IllegalArgumentException for empty input`() {
        val invalidCarName = ""  // Empty name

        assertThatThrownBy { CarNameValidator.validate(invalidCarName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be null or blank")
    }
}
