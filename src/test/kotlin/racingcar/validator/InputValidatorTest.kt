package racingcar.validator

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.constants.Constants

class InputValidatorTest {

    // Input empty check
    @Test
    fun `success - input is not empty`() {
        assertThatCode {
            InputValidator.checkEmptyInput("moon")
        }.doesNotThrowAnyException()
    }

    @Test
    fun `exception -  input is empty`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.checkEmptyInput("")
        }
        assertThrows<IllegalArgumentException> {
            InputValidator.checkEmptyInput(null)
        }
    }

    // Check max car limit
    @Test
    fun `success - car count not exceeds max`() {
        val names = List(Constants.MAX_CAR_COUNT) { "car$it" }
        assertThatCode {
            InputValidator.validateCarNames(names)
        }.doesNotThrowAnyException()

        assertThatCode {
            InputValidator.validateCarNames(listOf("one"))
        }.doesNotThrowAnyException()

    }

    @Test
    fun `exception - car count exceeds max`() {
        val names = List(Constants.MAX_CAR_COUNT + 1) { "car$it" }
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }


    // Check car name length
    @Test
    fun `success - car name length is valid`() {
        val names = listOf("1", "12", "123", "1234", "12345")
        assertThatCode {
            InputValidator.validateCarNames(names)
        }.doesNotThrowAnyException()
    }

    @Test
    fun `exception - car name is too long`() {
        val names = listOf("123456", "1234567")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }

    // Check car name only letter And number
    @Test
    fun `success - car name has only letter And number`() {
        val names = listOf("moon", "a123")
        assertThatCode {
            InputValidator.validateCarNames(names)
        }.doesNotThrowAnyException()
    }

    @Test
    fun `exception - car name has special characters`() {
        val names = listOf("kim!", "moon")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }

    // Check car name duplication
    @Test
    fun `exception - car names are duplicated`() {
        val names = listOf("moon", "m", "moon")
        assertThrows<IllegalArgumentException> {
            InputValidator.validateCarNames(names)
        }
    }


    // Check valid number
    @Test
    fun `success - round count is valid number`() {
        assertThatCode {
            InputValidator.validateRoundCount("5")
        }.doesNotThrowAnyException()

        assertThatCode {
            InputValidator.validateRoundCount(Int.MAX_VALUE.toString())
        }.doesNotThrowAnyException()


    }

    @Test
    fun `exception - round count is invalid`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount("12a4")
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount("0")
        }

        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount("-1")
        }

        val overMaxInt = (Int.MAX_VALUE.toLong() + 1).toString()
        assertThrows<IllegalArgumentException> {
            InputValidator.validateRoundCount(overMaxInt)
        }
    }
}
