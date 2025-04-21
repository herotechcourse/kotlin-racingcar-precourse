package racingcar.io

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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
        // When
        outputProcess.printRoundNumberInputMessage()

        // Then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("How many rounds will be played?")
    }
}