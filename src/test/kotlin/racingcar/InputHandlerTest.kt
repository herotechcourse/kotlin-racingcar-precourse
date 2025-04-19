package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class InputHandlerTest {

    @Test
    fun `parses valid car names`() {
        val input = "Car1, Max, Zed"
        val result = InputHandler.parseCarNames(input)
        assertThat(result).containsExactly("Car1", "Max", "Zed")
    }

    @Test
    fun `throws if any name exceeds 5 characters`() {
        val input = "Range rover, Maxi"
        assertThatThrownBy {
            InputHandler.parseCarNames(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Each car name must be at most 5 characters.")
    }

    @Test
    fun `throws if all names are empty or blank`() {
        val input = " , , "
        assertThatThrownBy {
            InputHandler.parseCarNames(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("No car names were entered.")
    }

    @Test
    fun `ignores empty or blank entries`() {
        val input = "Car1, , Max"
        assertThatThrownBy {
            InputHandler.parseCarNames(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Individual car name cannot be blank")
    }

    @Test
    fun `parses valid number of rounds`() {
        val input = " 5 "
        val result = InputHandler.parseRounds(input)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun `throws if rounds input is not a number`() {
        val input = "five"
        assertThatThrownBy {
            InputHandler.parseRounds(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be a valid integer.")
    }

    @Test
    fun `throws if rounds is zero`() {
        val input = "0"
        assertThatThrownBy {
            InputHandler.parseRounds(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be greater than 0.")
    }

    @Test
    fun `throws if rounds is negative`() {
        val input = "-3"
        assertThatThrownBy {
            InputHandler.parseRounds(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be greater than 0.")
    }

    @Test
    fun `throws if rounds input is blank`() {
        val input = "   "
        assertThatThrownBy {
            InputHandler.parseRounds(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Rounds must be a valid integer.")
    }

}
