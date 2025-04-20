package racingcar.controller

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.util.RandomsWrapper
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameControllerTest {

    private val standardOut = System.out
    private val standardIn = System.`in`
    private lateinit var outContent: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        RandomsWrapper.provider = { 5 }
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
        System.setIn(standardIn)
    }

    @Test
    @DisplayName("given valid input when run then full race flow is printed")
    fun `given valid input when run then full race flow is printed`() {
        // given: simulate user input for names and rounds
        val input = "pobi,jun\n2\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))
        resetConsoleScanner()

        // when
        RacingGameController().run()

        // then: verify full output
        val expected = buildString {
            append("Enter the names of the cars (comma-separated):\n")
            append("How many rounds will be played?\n")
            append("\n")
            append("Race Results\n")
            append("pobi : -\n")
            append("jun : -\n")
            append("\n")
            append("pobi : --\n")
            append("jun : --\n")
            append("\n")
            append("Winners : pobi, jun\n")
        }
        assertEquals(expected, outContent.toString())
    }

    private fun resetConsoleScanner() {
        val consoleClass = Class.forName("camp.nextstep.edu.missionutils.Console")
        val field = consoleClass.getDeclaredField("scanner")
        field.isAccessible = true
        field.set(null, java.util.Scanner(System.`in`))
    }
}