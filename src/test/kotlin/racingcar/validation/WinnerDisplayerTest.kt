package racingcar.results

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerDisplayerTest {

    private val displayer = WinnerDisplayer()

    @Test
    fun `should display single winner correctly`() {
        val winners = listOf("audi")

        val result = displayer.formatWinners(winners)

        assertEquals("Winners : audi", result)
    }

    @Test
    fun `should display multiple winners correctly`() {
        val winners = listOf("audi", "benz")

        val result = displayer.formatWinners(winners)

        assertEquals("Winners : audi, benz", result)
    }

    @Test
    fun `should handle no winners gracefully`() {
        val winners = emptyList<String>()

        val result = displayer.formatWinners(winners)

        assertEquals("Winners : ", result)
    }
}