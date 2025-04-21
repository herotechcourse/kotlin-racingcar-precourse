package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class InputTest {

    @Test
    fun `should PASS if car name is normal`() {
        val input = listOf("pobi", "woni", "jun")
        assertDoesNotThrow {
            InputView.validateName(input)
        }
    }


    @Test
    fun `should throw if car name is BLANK`() {
        val input = listOf("pobi", " ", "jun")
        assertThrows<IllegalArgumentException> {
            InputView.validateName(input)
        }
    }

    @Test
    fun `should throw if car name exceeds 5 characters`() {
        val input = listOf("pobi", "wooooooni")
        assertThrows<IllegalArgumentException> {
            InputView.validateName(input)
        }
    }

    @Test
    fun `should throw if car name is duplicate`() {
        val input = listOf("pobi", "pobi", "pobu")
        assertThrows<IllegalArgumentException> {
            InputView.validateName(input)
        }
    }

    @Test
    fun `should pass if round is positive`() {
        assertDoesNotThrow {
            InputView.validateRound(1)
        }
        assertDoesNotThrow {
            InputView.validateRound(5)
        }
    }

    @Test
    fun `should throw if round is zero`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateRound(0)
        }
    }

    @Test
    fun `should throw if round is negative`() {
        assertThrows<IllegalArgumentException> {
            InputView.validateRound(-1)
        }
    }

}
