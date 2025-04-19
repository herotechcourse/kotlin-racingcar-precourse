import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.assertj.core.api.Assertions.*

import java.io.ByteArrayOutputStream
import java.io.PrintStream

import racingcar.view.OutputView

class OutputViewTest {
    private val originalOut = System.out
    private lateinit var outputStream: ByteArrayOutputStream

    @BeforeEach
    fun setup() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun teardown() {
        System.setOut(originalOut)
    }

    @Test
    @DisplayName("Should display race history with car progression")
    fun displayRaceHistory() {
        val raceHistory = listOf(
            listOf("car1" to 2, "car2" to 1),
            listOf("car1" to 3, "car2" to 0)
        )

        OutputView.displayRace(raceHistory)
        val output = outputStream.toString()

        assertThat(output).contains("Race Result\n")
        assertThat(output).contains("car1 : --\n")
        assertThat(output).contains("car2 : -\n")
        assertThat(output).contains("car1 : ---\n")
        assertThat(output).contains("car2 : \n")
    }

    @Test
    @DisplayName("Should display a single winner")
    fun displaySingleWinner() {
        OutputView.announceWinners(listOf("pobi"))
        val output = outputStream.toString()

        assertThat(output).isEqualTo("Winners : pobi\n")
    }

    @Test
    @DisplayName("Should display mutiple winners")
    fun displayMultipleWinners() {
        OutputView.announceWinners(listOf("pobi", "woni", "jun"))
        val output = outputStream.toString()

        assertThat(output).isEqualTo("Winners : pobi, woni, jun\n")
    }

}