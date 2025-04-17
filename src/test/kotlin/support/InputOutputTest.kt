package support

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputOutputTest : IOTest() {
    private fun readNameAndGreet(): String {
        val name = Console.readLine() ?: return "No name"
        return "Hello, $name"
    }

    @Test
    fun `input test`() {
        // Given
        val input = "Kotlin"

        // When
        val result = run(input) { readNameAndGreet() }

        // Then
        Assertions.assertThat(result).isEqualTo("Hello, Kotlin")
    }

    @Test
    fun `output test`() {
        // When
        val output = run { println("Hello, Kotlin!") }

        // Then
        Assertions.assertThat(output).isEqualTo("Hello, Kotlin!")
    }
}