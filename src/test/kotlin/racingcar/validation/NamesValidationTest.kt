package racingcar.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.util.Validator

class NamesValidationTest {

    @Test
    fun `throws exception when there is one empty string`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(listOf(""))
        }
    }

    @Test
    fun `throws exception when there is an empty name`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(listOf("Pipi", "Coti", "", "Lali"))
        }
    }

    @Test
    fun `throws exception when a name is longer than 5 characters`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(listOf("Pipi", "Lali", "Panchi"))
        }
    }

    @Test
    fun `throws exception when there are duplicates`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateNames(listOf("Pipi", "Lali", "Pipi"))
        }
    }
}