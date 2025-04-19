package racingcar.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CarRaceServiceTest {

    @Test
    fun `should print race results and winners`() {
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        val service = CarRaceService()
        val carNames = listOf("car1", "car2")
        val roundCount = 1

        service.runCarRace(carNames, roundCount)

        System.setOut(originalOut)

        val output = outputStream.toString().trim()

        assertThat(output).contains("Race Results")
        assertThat(output).contains("car1")
        assertThat(output).contains("car2")
        assertThat(output).contains("Winners :")
    }
}
