package racingcar

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class OutputHandlerTest {
    private fun captureOutput(block: () -> Unit): String {
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        try {
            block()
        } finally {
            System.setOut(originalOut)
        }

        return outputStream.toString().trim()
    }

    private fun createCarAtPosition(name: String, position: Int): Car {
        val car = Car(name)
        repeat(position) {
            car.attemptMove(true) // move forward
        }
        return car
    }


    @Test
    fun `prints race start correctly`() {
        val handler = OutputHandler()
        val output = captureOutput { handler.printRaceStart() }
        assertThat(output).isEqualTo("Race Results")
    }


    @Test
    fun `prints race results for all cars`() {
        val handler = OutputHandler()
        val cars = listOf(
            createCarAtPosition("CarA", 3),
            createCarAtPosition("CarB", 1)
        )

        val output = captureOutput { handler.printRaceResult(cars) }

        assertThat(output.lines()).containsExactly(
            "CarA : ---",
            "CarB : -"
        )
    }

    @Test
    fun `prints single winner correctly`() {
        val handler = OutputHandler()
        val cars = listOf(
            createCarAtPosition("Zed", 2),
            createCarAtPosition("Max", 5),
            createCarAtPosition("Ana", 4)
        )

        val output = captureOutput { handler.printWinners(cars) }
        assertThat(output).isEqualTo("Winners : Max")
    }

    @Test
    fun `prints multiple winners correctly`() {
        val handler = OutputHandler()
        val cars = listOf(
            createCarAtPosition("Car1", 5),
            createCarAtPosition("Car2", 3),
            createCarAtPosition("Car3", 5)
        )

        val output = captureOutput { handler.printWinners(cars) }
        assertThat(output).isEqualTo("Winners : Car1, Car3")
    }
}