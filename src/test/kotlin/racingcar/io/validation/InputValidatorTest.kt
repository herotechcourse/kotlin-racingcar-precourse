package racingcar.io.validation

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class InputValidatorTest {
    /*
    * TIP: follow arrange, action, assert format for tests
    */

    //############################ Test for carNames ############################
    @Test
    fun `validateCarNames should return list of valid car names`(){
        val carNames = "pobi, woni, jun"
        val result = InputValidator.validateCarNames(carNames)
        Assertions.assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `validateCarNames should handle whitespaces`(){
        val carNames = " pobi, woni ,  juni"
        val result = InputValidator.validateCarNames(carNames)
        Assertions.assertThat(result).containsExactly("pobi", "woni", "juni")
    }

    @Test
    fun `validateCarNames should throw IllegalArgumentException for empty input`(){
        val carNames = ""
        assertThrows<IllegalArgumentException> { InputValidator.validateCarNames(carNames) }
    }

    @Test
    fun `validateCarNames should throw throw IllegalArgumentException for names exceeding length of 5 characters`(){
        val carNames = "pobi, woni, juniiiiiiii"
        assertThrows<IllegalArgumentException> { InputValidator.validateCarNames(carNames) }
    }

    @Test
    fun `validateCarNames should throw IllegalArgumentException for less than 2 cars`(){
        val carNames = "pobi"
        assertThrows<IllegalArgumentException> { InputValidator.validateCarNames(carNames) }
    }

    @Test
    fun `validateCarNames should throw IllegalArgumentException for duplicates names`(){
        val carNames = "pobi, pobi, juni"
        assertThrows<IllegalArgumentException> { InputValidator.validateCarNames(carNames) }
    }

    //############################ Test for numberOfRounds ############################
    @Test
    fun `validateNumberOfRounds should return valid number`(){
        val numberOfRounds = "5"
        val result = InputValidator.validateNumberOfRounds(numberOfRounds)
        Assertions.assertThat(result).isEqualTo(5)
    }

    @Test
    fun `validateNumberOfRounds should throw IllegalArgumentException for empty input`(){
        val numberOfRounds = ""
        assertThrows<IllegalArgumentException> { InputValidator.validateNumberOfRounds(numberOfRounds) }
    }

    @Test
    fun `validateNumberOfRounds should throw IllegalArgumentException for numeric input`(){
        val numberOfRounds = "notAllowed:/"
        assertThrows<IllegalArgumentException> { InputValidator.validateNumberOfRounds(numberOfRounds) }
    }

    @Test
    fun `validateNumberOfRounds should throw IllegalArgumentException for less than 1 round`(){
        val numberOfRounds = "0"
        assertThrows<IllegalArgumentException> { InputValidator.validateNumberOfRounds(numberOfRounds) }
    }

    @Test
    fun `validateNumberOfRounds should throw IllegalArgumentException for negative input`(){
        val numberOfRounds = "-5"
        assertThrows<IllegalArgumentException> { InputValidator.validateNumberOfRounds(numberOfRounds) }
    }
}