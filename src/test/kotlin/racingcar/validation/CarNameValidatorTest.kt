package racingcar.validation.CarNameValidatorTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.validation.validateCarName

private const val VALID_CAR_NAME = "Car";
private const val EMPTY_CAR_NAME = "";


class CarNameValidatorTest {
    @Test
    fun `valid car name test`() {
        assertDoesNotThrow {
            validateCarName(VALID_CAR_NAME);
        }
    }

    @Test
    fun `empty car name test`() {
        val exception = assertThrows<Exception> {
            validateCarName(EMPTY_CAR_NAME);
        }
        
    }
}
