import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.InputValidator

class InputValidatorTest {

    @Test
    @DisplayName("Should return the valid car name as it is")
    fun validCarNameShouldReturnAsIs() {
        val result = InputValidator.validateCarName("pobi")
        assertEquals("pobi", result)
    }

    @Test
    @DisplayName("Should throw an exception when car name exceeds 5 characters")
    fun carNameExceedsFiveCharactersShouldThrow() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName("toolongname")
        }
    }

    @Test
    @DisplayName("Should throw an exception when car name is blank")
    fun blankCarNameShouldThrow() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarName("   ")
        }
    }

    @Test
    @DisplayName("Should return integer when round number input is valid")
    fun validRoundNumberShouldReturnInt() {
        val result = InputValidator.validateRoundNumber("5")
        assertEquals(5, result)
    }

    @Test
    @DisplayName("Should throw an exception when round number input is blank")
    fun blankRoundNumberShouldThrow() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundNumber(" ")
        }
    }

    @Test
    @DisplayName("Should throw an exception when round number input is not a number")
    fun nonNumericRoundNumberShouldThrow() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundNumber("abc")
        }
    }

    @Test
    @DisplayName("Should throw an exception when round number is zero or negative")
    fun zeroOrNegativeRoundNumberShouldThrow() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundNumber("0")
        }
    }
}
