package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `no car name exception test`(){
        val validator = InputValidator("", 5)
        val exception = assertThrows<IllegalArgumentException> { validator.validateCarNames() }
        assert(exception.message == "At least one car name must be provided")
    }

    @Test
    fun `car name length exception test`(){
        val validator = InputValidator("car123", 5)
        val exception = assertThrows<IllegalArgumentException> { validator.validateCarNames() }
        assert(exception.message == "Car names must not exceed 5 characters")
    }

    @Test
    fun `no duplicate car name test`(){
        val validator = InputValidator("car1,car1", 5)
        val exception = assertThrows<IllegalArgumentException> { validator.validateCarNames() }
        assert(exception.message == "Each car must have a unique name")
    }

    @Test
    fun `validate positive integer round test`(){
        val validator = InputValidator("car1,car2,car3", 5)
        assertDoesNotThrow { validator.validateRound() }
        assert(validator.validateRound() == 5)
    }

    @Test
    fun `negative integer round test`(){
        val validator = InputValidator("car1,car2", -2)
        val exception = assertThrows<IllegalArgumentException> { validator.validateRound()}
        assert(exception.message == "Number of rounds must be a non-negative integer")
    }
}
