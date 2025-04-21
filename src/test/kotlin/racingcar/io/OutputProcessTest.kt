package racingcar.io

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import racingcar.domain.Car

class OutputProcessTest {
    
    private lateinit var outputProcess: OutputProcess
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()
    
    @BeforeEach
    fun setUp() {
        outputProcess = OutputProcess()
        System.setOut(PrintStream(outputStreamCaptor))
    }
    
    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `printCarNameInputMessage should print correct message`() {

        outputProcess.printCarNameInputMessage()

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Enter the names of the cars (comma-separated):")
    }

    @Test
    fun `printRoundNumberInputMessage should print correct message`() {

        outputProcess.printRoundNumberInputMessage()

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("How many rounds will be played?")
    }

    @Test
    fun `printRaceResultsMessage should print correct message`() {

        outputProcess.printRaceResultsMessage()

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Race Results")
    }

    @Test
    fun `printRoundResult should print car names and positions`() {

        val car1 = Car("chang", 10)
        val car2 = Car("deok", 1)
        val car3 = Car("seo", 0)
        val cars = listOf(car1, car2, car3)

        outputProcess.printRoundResult(cars)

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("chang : ----------")
        assertThat(output).contains("deok : -")
        assertThat(output).contains("seo : ")
    }

    @Test
    fun `printWinners should print single winner correctly`() {

        val winner = Car("chang", 3)
        val winners = listOf(winner)

        outputProcess.printWinners(winners)


        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Winners : chang")
    }

    @Test
    fun `printWinners should print multiple winners correctly`() {

        val winner1 = Car("chang", 3)
        val winner2 = Car("deok", 3)
        val winners = listOf(winner1, winner2)

        outputProcess.printWinners(winners)

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Winners : chang, deok")
    }
}