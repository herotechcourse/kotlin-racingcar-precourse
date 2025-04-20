package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class OutputViewTest {

    @Test
    fun `print car position`() {
        val output = captureOutput {
            val car = Car("pobi").apply { repeat(2) { move() } }
            OutputView.printPosition(listOf(car))
        }

        assertThat(output).contains("pobi :")
    }

    private fun captureOutput(block: () -> Unit): String {
        val out = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(out))
        try {
            block()
        } finally {
            System.setOut(originalOut)
        }
        return out.toString().trim()
    }
}
