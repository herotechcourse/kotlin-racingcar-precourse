package racingcar.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import racingcar.model.Car

class WinnerFinderTest {

    @Test
    fun `should return single winner when one car has the farthest distance`() {
        val cars = listOf(
            Car("pobi", 2),
            Car("woni", 4),
            Car("jun", 3)
        )

        val winners = WinnerFinder.findWinners(cars)
        assertEquals(listOf("woni"), winners)
    }

    @Test
    fun `should return multiple winners when cars have the same max distance`() {
        val cars = listOf(
            Car("pobi", 4),
            Car("woni", 4),
            Car("jun", 3)
        )

        val winners = WinnerFinder.findWinners(cars)
        assertEquals(listOf("pobi", "woni"), winners)
    }
}