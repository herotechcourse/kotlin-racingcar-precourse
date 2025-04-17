package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RaceGameTest {

    @Test
    @DisplayName("All Cars move by the fixed engine")
    fun raceAllRound() {
        // given
        val engine = FixedEngine(1)
        val cars = listOf(
            Car("pobi", 0, engine),
            Car("woni", 0, engine)
        )
        val roundNumber = 3
        val raceGame = RaceGame(cars, roundNumber)

        // when
        val result = raceGame.raceAllRound()

        // then
        for (car in result) {
            assertEquals(3, car.getPosition())
        }
    }

    @Test
    @DisplayName("Car does not move when round is 0")
    fun edgeRound() {
        val engine = FixedEngine(5)
        val cars = listOf(Car("jun", 0, engine))
        val raceGame = RaceGame(cars, 0)

        val result = raceGame.raceAllRound()

        assertEquals(0, result[0].getPosition())
    }
}

class FixedEngine(private val fixedValue: Int) : Engine {
    override fun move(): Int = fixedValue
}
