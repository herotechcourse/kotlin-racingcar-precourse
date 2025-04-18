package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputHandlerTest {

    class FakeIO(private vararg val inputs: String) : IOInterface {
        private val inputQueue = inputs.toMutableList()
        val outputs = mutableListOf<String>()

        override fun read(): String = inputQueue.removeAt(0)

        override fun print(content: String) {
            outputs.add(content)
        }
    }

    @Test
    fun `readCarNames should return trimmed names when input is valid`() {
        // Given
        val io = FakeIO(" car1 ,car2 , car3 ")
        val handler = InputHandler(io)

        // When
        val result = handler.readCarNames()

        // Then
        assertThat(result).containsExactly("car1", "car2", "car3")
        assertThat(io.outputs).contains("Enter the names of the cars (comma-separated):")
    }

    @Test
    fun `readCarNames should throw when any name is empty`() {
        // Given
        val io = FakeIO("car1,,car3")
        val handler = InputHandler(io)

        // Then
        assertThatThrownBy { handler.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Each car name must be non-empty and up to 5 characters.")
    }

    @Test
    fun `readCarNames should throw when any name is longer than 5 characters`() {
        // Given
        val io = FakeIO("car123,car2")
        val handler = InputHandler(io)

        // Then
        assertThatThrownBy { handler.readCarNames() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Each car name must be non-empty and up to 5 characters.")
    }

    @Test
    fun `readRoundCount should return parsed integer when input is valid`() {
        // Given
        val io = FakeIO("3")
        val handler = InputHandler(io)

        // When
        val result = handler.readRoundCount()

        // Then
        assertThat(result).isEqualTo(3)
        assertThat(io.outputs).contains("How many rounds will be played?")
    }

    @Test
    fun `readRoundCount should throw when input is not a number`() {
        // Given
        val io = FakeIO("abc")
        val handler = InputHandler(io)

        // Then
        assertThatThrownBy { handler.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round count must be a valid number.")
    }

    @Test
    fun `readRoundCount should throw when input is zero or negative`() {
        // Given
        val io = FakeIO("0")
        val handler = InputHandler(io)

        // Then
        assertThatThrownBy { handler.readRoundCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Round count must be positive.")
    }
}
