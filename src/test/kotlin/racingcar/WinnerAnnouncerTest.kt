package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WinnerAnnouncerTest {

    @Test
    @DisplayName("announceWinners prints single winner correctly")
    fun announceWinnersSingleWinner() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val cars = listOf(
            Car("pobi", position = 3),
            Car("duc",  position = 1)
        )

        WinnerAnnouncer.announceWinners(cars)

        val output = outputStream.toString()
        assertThat(output).contains(
            "Winners :",
            "pobi"
        )
    }

    @Test
    @DisplayName("announceWinners prints multiple winners in comma-separated list")
    fun announceWinnersMultipleWinners() {
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val cars = listOf(
            Car("pobi", position = 4),
            Car("duc",  position = 4),
            Car("jun",  position = 2)
        )

        WinnerAnnouncer.announceWinners(cars)

        val output = outputStream.toString()
        assertThat(output).contains(
            "Winners :",
            "pobi, duc"
        )
    }
}
