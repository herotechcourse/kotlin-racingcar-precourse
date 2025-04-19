package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameTest {

    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    private fun getOutput(): String = outputStream.toString().trim()

    @Test
    fun `racing1 game prints results and determines winner`() {
        val carNames = listOf("CarA", "CarB")
        val outputHandler = OutputHandler()
        val game = RacingGame(carNames, 1, outputHandler)

        game.run()

        val output = getOutput()
        assertThat(output).contains("Race Results")
        assertThat(output).contains("CarA")
        assertThat(output).contains("CarB")
        assertThat(output).contains("Winners")
    }

}
