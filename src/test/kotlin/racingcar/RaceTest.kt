package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `car that moves most should be the winner`() {
        val car1 = Car("pobi")
        val car2 = Car("woni")

        // Simulate race
        repeat(3) { car1.move(4) } // 3 moves
        repeat(2) { car2.move(4) } // 2 moves

        val race = Race(listOf(car1, car2), 3)
        val output = captureOutput {
            race.printWinners()
        }

        assertThat(output.trim()).contains("Winners : pobi")
    }

    @Test
    fun `both cars win when same number of moves`() {
        val car1 = Car("pobi")
        val car2 = Car("woni")

        repeat(2) {
            car1.move(4)
            car2.move(4)
        }

        val race = Race(listOf(car1, car2), 2)
        val output = captureOutput {
            race.printWinners()
        }

        assertThat(output.trim()).contains("Winners : pobi, woni")
    }

    // Capture and assert console output (for printWinners() function which is not returning anything
    private fun captureOutput(block: () -> Unit): String {
        val originalOut = System.out
        val outputStream = java.io.ByteArrayOutputStream()
        System.setOut(java.io.PrintStream(outputStream))

        block()

        System.setOut(originalOut)
        return outputStream.toString()
    }
}
