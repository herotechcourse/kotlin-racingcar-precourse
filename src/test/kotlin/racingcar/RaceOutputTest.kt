package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

private fun captureOutput(block: () -> Unit): String {
    val originalOut = System.out
    val outputStream = ByteArrayOutputStream()
    System.setOut(PrintStream(outputStream))

    try {
        block()
        return outputStream.toString().trim()
    } finally {
        System.setOut(originalOut)
    }
}

class RaceOutputTest {
    fun Car.withPosition(position: Int): Car {
        repeat(position) { this.moveForward() }
        return this
    }

    @Test
    @DisplayName("Correctly display cars with their positions")
    fun raceDisplay() {
        val raceOutput = RaceOutput()
        val cars = listOf(
            Car("car1").withPosition (2),
            Car("car2").withPosition (6),
            Car("car3").withPosition (3)
        )

        val output = captureOutput {
            raceOutput.raceDisplay(cars)
        }
        assertThat(output).contains("car1 : --")
        assertThat(output).contains("car2 : ------")
        assertThat(output).contains("car3 : ---")

    }

    @Test
    @DisplayName("Announce single winner correctly")
    fun announceWinner() {
        // Given
        val raceOutput = RaceOutput()
        val cars = listOf(
            Car("car1").withPosition (2),
            Car("car2").withPosition (6),
            Car("car3").withPosition (3)
        )

        val output = captureOutput {
            raceOutput.announceWinners(cars)
        }

        assertThat(output).isEqualTo("Winners : car2")
    }

    @Test
    @DisplayName("Announce multiple winners correctly")
    fun announceWinners() {
        // Given
        val raceOutput = RaceOutput()
        val cars = listOf(
            Car("car1").withPosition (2),
            Car("car2").withPosition (6),
            Car("car3").withPosition (6)
        )

        val output = captureOutput {
            raceOutput.announceWinners(cars)
        }

        assertThat(output).isEqualTo("Winners : car2, car3")
    }
}