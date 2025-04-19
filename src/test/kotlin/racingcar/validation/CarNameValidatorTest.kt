package racingcar.validation;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

private const val VALID_CAR_NAME = "Car";
private const val EMPTY_CAR_NAME = "";
private const val LONG_CAR_NAME = "Carrrrrr";


class CarNameValidatorTest {
    @Test
    fun `valid car name test`() {
        assertDoesNotThrow {
            validateCarName(VALID_CAR_NAME);
        }
    }

    @Test
    fun `empty car name test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarName(EMPTY_CAR_NAME);
        }
        assertEquals(INVALID_LENGTH_MSG, exception.message);
    }

    @Test
    fun `long car name test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateCarName(LONG_CAR_NAME);
        }
        assertEquals(LONG_CAR_NAME, exception.message);
    }
}
