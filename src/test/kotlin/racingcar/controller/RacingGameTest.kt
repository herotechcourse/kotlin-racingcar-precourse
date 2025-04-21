package racingcar.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameTest {
    @Test
    fun `Game runs for the given number of rounds and displays results`() {
        val carNames = listOf("pobi", "woni", "jun")
        val roundCnt = 4

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val game = RacingGame(carNames, roundCnt)

        game.play()

        val printed = output.toString().trim()
        val roundAppearances = printed.split("\n").count { it.contains(":")}
        assertThat(roundAppearances).isGreaterThanOrEqualTo(roundCnt * carNames.size)
    }


}