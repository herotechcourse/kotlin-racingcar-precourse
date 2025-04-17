package racingcar.validation

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CarNameValidatorTest {

    @Test
    fun `should pass for valid car name within length limit`() {
        val validCarName = listOf("benz")
        CarNameValidator.validateAll(validCarName)
    }

    @Test
    fun `should pass for list of valid car names`() {
        val validCarNames = listOf("bmw", "audi", "tesla")
        CarNameValidator.validateAll(validCarNames)
    }

    @Test
    fun `should throw IllegalArgumentException for empty input`() {
        val invalidCarName = listOf("")  // Empty name

        assertThatThrownBy { CarNameValidator.validateAll(invalidCarName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be null or blank")
    }

    @Test
    fun `should throw IllegalArgumentException for list with one blank car name`() {
        val invalidCarNames = listOf("bmw", "", "audi")

        assertThatThrownBy { CarNameValidator.validateAll(invalidCarNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot be null or blank")
    }

    @Test
    fun `should throw IllegalArgumentException for car name longer than 5 characters`() {
        val invalidCarName = listOf("mustang")  // Name with more than 5 characters

        assertThatThrownBy { CarNameValidator.validateAll(invalidCarName) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exceeds max length")
    }

    @Test
    fun `should throw IllegalArgumentException for list with one invalid car name`() {
        val invalidCarNames = listOf("bmw", "mustang", "audi")

        assertThatThrownBy { CarNameValidator.validateAll(invalidCarNames) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exceeds max length")
    }

    @Test
    fun `should throw IllegalArgumentException for car names with special characters`() {
        val input = "tesla. bmw. ford"

        assertThatThrownBy { CarNameValidator.validateSeparator(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid character detected")
    }

    @Test
    fun `should throw IllegalArgumentException for car names with spaces in between`() {
        val input = "tes la, ford mustang"

        assertThatThrownBy { CarNameValidator.validateAll(input.split(",")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("contains spaces in-between")
    }

}