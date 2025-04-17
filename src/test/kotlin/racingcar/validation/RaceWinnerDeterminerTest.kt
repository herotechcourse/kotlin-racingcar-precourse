import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

import racingcar.results.RaceWinnerDeterminer
import racingcar.results.CarResult

class RaceWinnerDeterminerTest {

    private val determiner = RaceWinnerDeterminer()

    @Test
    fun `should return single winner when one car is ahead`() {
        val results = listOf(
            CarResult("Car A", 2),
            CarResult("Car B", 5),
            CarResult("Car C", 3)
        )

        val winners = determiner.determineWinners(results)

        assertEquals(listOf("Car B"), winners)
    }

    @Test
    fun `should return all winners in case of tie`() {
        val results = listOf(
            CarResult("Car A", 4),
            CarResult("Car B", 6),
            CarResult("Car C", 6)
        )

        val winners = determiner.determineWinners(results)

        assertEquals(listOf("Car B", "Car C"), winners)
    }
}