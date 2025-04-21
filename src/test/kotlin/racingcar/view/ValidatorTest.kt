package racingcar.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `should throw exception when input is empty`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf())
        }
        assert(exception.message == "Car names cannot be empty")
    }

    @Test
    fun `should return exception when input is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf(" ", "pobi"))
        }
        assert(exception.message == "Car name cannot be blank")
    }

    @Test
    fun `should return exception when input is longer than 5 characters`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("pobi", "woni", "longname"))
        }
        assert(exception.message == "Car name cannot be longer than 5 characters")
    }

    @Test
    fun `should return exception when input is not unique`() {
        val exception = assertThrows<IllegalArgumentException> {
            Validator.validateCarNames(listOf("pobi", "woni", "pobi"))
        }
        assert(exception.message == "Each Car name must be unique")
    }
}
