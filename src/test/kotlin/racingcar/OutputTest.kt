package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputTest {

    private val outputStream = ByteArrayOutputStream()
    private val originalOut = System.out

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(originalOut)
    }

    @Test
    fun `Output prints car progress correctly`() {
        val cars = listOf(Car("pobi", 2), Car("woni", 3))
        Output.printRoundResult(cars)

        val output = outputStream.toString().trim()
        assertThat(output).contains("pobi : --", "woni : ---")
    }

    @Test
    fun `Output prints correct winner`() {
        val cars = listOf(Car("pobi", 3), Car("woni", 5), Car("jun", 5))
        Output.printWinners(cars)

        val output = outputStream.toString().trim()
        assertThat(output).contains("Winners : woni, jun")
    }
}
