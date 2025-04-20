package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import racingcar.view.InputView

class InputViewTest {
    @Test
    fun `parseCarNames test - convert a string of car names separated by comma into a list`() {
        val input = "pobi, woni, jun "
        val result = InputView.parseCarNames(input)

        assertThat(result).containsExactly("pobi", " woni", " jun ")
    }

    @Test
    fun `validateCarNames test - throw exception if the list of name is empty`() {
        val names = emptyList<String>()
        val exception = assertThrows<IllegalArgumentException> { InputView.validateCarNames(names) }

        assertEquals(
            "No names are entered.",
            exception.message
        )
    }

    @Test
    fun `validateCarNames test - pass if the list of name has a name`() {
        val names = listOf("test")
        InputView.validateCarNames(names)
    }

    @Test
    fun `validateCarNames test - pass if the list of name has names`() {
        val names = listOf("a", "b", "test")
        InputView.validateCarNames(names)
    }

    @Test
    fun `validateCarNames test - throw exception if a name is blank`() {
        val invalidNames = listOf("", " ", "    ")
        invalidNames.forEach { name ->
            val exception = assertThrows<IllegalArgumentException> { InputView.isNameNotBlankOrLessThanFive(name) }
            assertEquals(
                "Car names must be between 1 and 5 characters. Input value: '$name'",
                exception.message
            )
        }
    }

    @Test
    fun `validateCarNames test - throw exception if a name longer than 5`() {
        val invalidNames = listOf(" a    ", "a bb a", "  ab  ")
        invalidNames.forEach { name ->
            val exception = assertThrows<IllegalArgumentException> { InputView.isNameNotBlankOrLessThanFive(name) }
            assertEquals(
                "Car names must be between 1 and 5 characters. Input value: '$name'",
                exception.message
            )
        }
    }

    @Test
    fun `convertRoundCount test - throw exception if the number of rounds is not a number`() {
        val invalidInputs = listOf("", " ", "a", "race", "  b  ", "3333333333", "3.14")
        invalidInputs.forEach { input ->
            val exception = assertThrows<IllegalArgumentException> { InputView.convertRoundCount(input) }
            assertEquals(
                "The number of rounds should be a number.",
                exception.message
            )
        }
    }

    @Test
    fun `validateRoundCount test - throw exception if the number of rounds is less than or equal to 0`() {
        val invalidNumbers = listOf(0, -1, -2147483648)
        invalidNumbers.forEach { number ->
            val exception = assertThrows<IllegalArgumentException> { InputView.validateRoundCount(number) }
            assertEquals(
                "The number of rounds must be a number greater than or equal to 1.",
                exception.message
            )
        }
    }

    @Test
    fun `validateRoundCount test - pass with the valid number of rounds`() {
        val inputs = listOf("1", "12", "  3", "4  ", "  5  ", "01", "0012", "2147483647")
        inputs.forEach { input ->
            val count = InputView.convertRoundCount(input.trim())
            InputView.validateRoundCount(count)
        }
    }
}