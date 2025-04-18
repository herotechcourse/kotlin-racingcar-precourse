package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Winner

class WinnerTest {

    @Test
    @DisplayName("When the result is single winner")
    fun singleWinnerTest() {
        val engine = FixedEngine(1)
        val cars = listOf(
            Car("pobi", 3, engine),
            Car("woni", 1, engine),
            Car("jun", 2, engine)
        )

        val result = Winner.findWinner(cars)

        assertEquals(listOf("pobi"), result)
    }

    @Test
    @DisplayName("When the result is multiple winner")
    fun multipleWinnersTest() {
        val engine = FixedEngine(1)
        val cars = listOf(
            Car("pobi", 3, engine),
            Car("woni", 3, engine),
            Car("jun", 2, engine)
        )

        val result = Winner.findWinner(cars)

        assertEquals(listOf("pobi", "woni"), result)
    }

    @Test
    @DisplayName("When the result is all")
    fun allSameDistanceTest() {
        val engine = FixedEngine(1)
        val cars = listOf(
            Car("pobi", 1, engine),
            Car("woni", 1, engine),
            Car("jun", 1, engine)
        )

        val result = Winner.findWinner(cars)

        assertEquals(listOf("pobi", "woni", "jun"), result)
    }
}
