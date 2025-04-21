package racingcar

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
        org.assertj.core.api.Assertions.assertThat(output).contains("Enter the names of the cars (comma-separated):")
        org.assertj.core.api.Assertions.assertThat(output).contains("How many rounds will be played?")
        org.assertj.core.api.Assertions.assertThat(output).contains("Race Results")
        org.assertj.core.api.Assertions.assertThat(output).contains("Winners :")
    }
}