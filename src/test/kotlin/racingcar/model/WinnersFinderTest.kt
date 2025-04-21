package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnersFinderTest {
    @Test
    fun `should return winner with highest progress in final round`() {
        // given
        val carName = listOf("jin", "bum", "yeji")
        val progressList = listOf(
            listOf(0, 0, 1),
            listOf(1, 1, 2),
            listOf(1, 2, 3),
        )

        // when
        val result = findWinners(carName, progressList)

        // then
        assertEquals(listOf("yeji"), result)
    }

    @Test
    fun `should return multiple winners when cars have same highest progress in final round`() {
        // given
        val carName = listOf("jin", "bum", "yeji")
        val progressList = listOf(
            listOf(0, 0, 1),
            listOf(1, 1, 2),
            listOf(1, 2, 2),
        )

        // when
        val result = findWinners(carName, progressList)

        // then
        assertEquals(listOf("bum", "yeji"), result)
    }
}
