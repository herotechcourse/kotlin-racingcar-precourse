package support

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InputOutputTest : IOTest() {
    @Test
    fun `should return Hello Kotlin when input is Kotlin`() {
        // Given
        val input = "Kotlin"

        // When
        val result = run(input) { readNameAndGreet() }

        // Then
        Assertions.assertThat(result).isEqualTo("Hello, Kotlin")
    }

    @Test
    fun `should print Hello Kotlin message when println is called`() {
        // When
        val output = run { println("Hello, Kotlin!") }

        // Then
        Assertions.assertThat(output).isEqualTo("Hello, Kotlin!")
    }

    private fun readNameAndGreet(): String {
        val name = Console.readLine() ?: return "No name"
        return "Hello, $name"
    }
}