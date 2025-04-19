package racingcar.controllers

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRaceControllerTest {

    @Test
    fun `should run race and print results`() {
        val input = "pobi,woni,jun\n3\n"
        val inputStream = ByteArrayInputStream(input.toByteArray())
        val outputStream = ByteArrayOutputStream()
        val originalIn = System.`in`
        val originalOut = System.out

        System.setIn(inputStream)
        System.setOut(PrintStream(outputStream))

        CarRaceController().startCarRace()

        System.setIn(originalIn)
        System.setOut(originalOut)

        val output = outputStream.toString().trim()

        assertThat(output).contains("Enter the names of the cars")
        assertThat(output).contains("How many rounds will be played?")
        assertThat(output).contains("Race Results")
        assertThat(output).contains("Winners :")
    }
}
