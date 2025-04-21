package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `car names are valid and trimmed`() {
        val input = " pobi , woni ,jun "
        val result = InputValidator.validateCarNames(input)
        assertThat(result).containsExactly("pobi", "woni", "jun")
    }

    @Test
    fun `car names must not be null or blank`() {
        val input = "   "
        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `car names must not contain blank name after split`() {
        val input = "pobi,,jun"
        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `car names must not exceed max length`() {
        val input = "pobi,susususupernova"
        assertThatThrownBy { InputValidator.validateCarNames(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `round input must be a number`() {
        val input = "abc"
        assertThatThrownBy { InputValidator.validateRoundInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `round input must be a positive integer`() {
        val input = "0"
        assertThatThrownBy { InputValidator.validateRoundInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `valid round input is parsed to Int`() {
        val input = "5"
        val result = InputValidator.validateRoundInput(input)
        assertThat(result).isEqualTo(5)
    }
}
