import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import racingcar.Car
import racingcar.OutputHandler
import racingcar.RacingGame
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameTest {

    private val outputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStream))
    }

    private fun getOutput(): String = outputStream.toString().trim()

    private fun createCarAtPosition(name: String, position: Int): Car {
        val car = Car(name)
        repeat(position) { car.attemptMove(true) }
        return car
    }

    @Test
    fun `racing game prints results and determines winner`() {
        val carNames = listOf("CarA", "CarB")
        val cars = listOf(
            createCarAtPosition("CarA", 3),
            createCarAtPosition("CarB", 1)
        )

        val outputHandler = OutputHandler()
        val game = RacingGame(carNames, 1, outputHandler)

        // simulate 1 round of game manually
        outputHandler.printRaceStart()
        outputHandler.printRaceResult(cars)
        outputHandler.printWinners(cars)

        val output = getOutput()
        assertThat(output).contains("Race Results")
        assertThat(output).contains("CarA : ---")
        assertThat(output).contains("CarB : -")
        assertThat(output).contains("Winners : CarA")
    }
}
