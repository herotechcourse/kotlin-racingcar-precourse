package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputFormatterTest {

    @Test
    fun `formatResults prints car names with correct progress`() {
        val car1 = Car("yugo", position = 2)
        val car2 = Car("audi", position = 4)

        val output = captureOutput {
            OutputFormatter.formatResults(listOf(car1, car2))
        }

        assertThat(output).contains("yugo : --")
        assertThat(output).contains("audi : ----")
    }

    @Test
    fun `formatFinalWinners prints all winner car names`() {
        val car1 = Car("yugo", position = 5)
        val car2 = Car("audi", position = 5)

        val output = captureOutput {
            OutputFormatter.formatFinalWinners(listOf(car1, car2))
        }

        assertThat(output).contains("Winners : yugo, audi")
    }

    private fun captureOutput(block: () -> Unit): String {
        val output = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(output))
        try {
            block()
        } finally {
            System.setOut(originalOut)
        }
        return output.toString().trim()
    }
}
