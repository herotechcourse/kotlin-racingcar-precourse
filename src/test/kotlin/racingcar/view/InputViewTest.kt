package racingcar.view

import camp.nextstep.edu.missionutils.Console
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*

class InputViewTest {

    private val standardOut = System.out
    private val standardIn = System.`in`
    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setUpStreams() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(standardOut)
        System.setIn(standardIn)
    }

    private fun resetConsoleScanner() {
        val consoleClass = Console::class.java
        val scannerField = consoleClass.getDeclaredField("scanner")
        scannerField.isAccessible = true
        scannerField.set(null, Scanner(System.`in`))
    }

    @Test
    @DisplayName("given valid input when inputCarName then returns raw input and prints prompt")
    fun `given valid input when inputCarName then returns raw input and prints prompt`() {
        // given
        val simulatedInput = "pobi,woni,jun\n"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        resetConsoleScanner()

        // when
        val result = InputView.inputCarName()

        // then
        assertEquals("pobi,woni,jun", result)
        assertEquals("Enter the names of the cars (comma-separated):\n", outContent.toString())
    }

    @Test
    @DisplayName("given valid numeric input when inputPlayRound then returns raw input and prints prompt")
    fun `given valid numeric input when inputPlayRound then returns raw input and prints prompt`() {
        // given
        val simulatedInput = "5\n"
        System.setIn(ByteArrayInputStream(simulatedInput.toByteArray()))
        resetConsoleScanner()

        // when
        val result = InputView.inputPlayRound()

        // then
        assertEquals("5", result)
        assertEquals("How many rounds will be played?\n", outContent.toString())
    }
}