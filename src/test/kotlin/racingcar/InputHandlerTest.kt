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
}
