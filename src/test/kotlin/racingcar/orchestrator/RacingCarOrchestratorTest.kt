import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.orchestrator.RacingCarOrchestrator
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingCarOrchestratorTest {

    private val standardOut = System.out
    private val standardIn = System.`in`
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        System.setIn(standardIn)
        Console.close()
    }

    @Test
    fun `should run the race and display result when input is valid`() {
        val input = "pobi,woni\n3\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val orchestrator = RacingCarOrchestrator()
        orchestrator.carRace()

        val output = outputStream.toString().trim()

        assertThat(output).contains("Race Results")
        assertThat(output).contains("pobi :")
        assertThat(output).contains("woni :")
        assertThat(output).contains("Winners :")
    }

    @Test
    fun `should throw exception when duplicate car names are given`() {
        val input = "pobi,pobi\n3\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val orchestrator = RacingCarOrchestrator()

        assertThatThrownBy {
            orchestrator.carRace()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Car names must be unique")
    }

    @Test
    fun `should throw exception when car name exceeds 5 characters`() {
        val input = "pobijava,woni\n3\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val orchestrator = RacingCarOrchestrator()

        assertThatThrownBy {
            orchestrator.carRace()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("CarName exceeds 5 characters")
    }

    @Test
    fun `should throw exception when rounds input is empty`() {
        val input = "pobi,woni\n\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val orchestrator = RacingCarOrchestrator()

        assertThatThrownBy {
            orchestrator.carRace()
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Rounds must not be empty")
    }
}
