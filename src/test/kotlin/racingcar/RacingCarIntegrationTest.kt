package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import camp.nextstep.edu.missionutils.Console
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingCarIntegrationTest {
    private val standardOut = System.out
    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        Console.close()
    }

    @Test
    fun `should run car racing game successfully`() {
        // Given
        val input = "pobi,woni,jun\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When
        main()

        // Then
        val output = outputStream.toString()
        assertThat(output).contains("Enter the names of the cars (comma-separated):")
        assertThat(output).contains("How many rounds will be played?")
        assertThat(output).contains("Race Results")
        assertThat(output).contains("Winners :")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ",", "car1,", ",car2"])
    fun `should throw exception for invalid car names input`(invalidInput: String) {
        // Given
        val input = "$invalidInput\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        // Given
        val input = "car1,toolong,car3\n5\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car name cannot exceed 5 characters")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "abc"])
    fun `should throw exception for invalid round count`(invalidRound: String) {
        // Given
        val input = "car1,car2,car3\n$invalidRound\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When/Then
        assertThatThrownBy { main() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}