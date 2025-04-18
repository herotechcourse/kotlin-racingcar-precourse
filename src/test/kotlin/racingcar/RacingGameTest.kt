package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.util.TestCarFactory


class RacingGameTest {

    private lateinit var mockRacingGame: MockRacingGame

    @Test
    fun `should call move once per car`() {
        val cars = listOf(Car("pobi"), Car("woni"))

        mockRacingGame = MockRacingGame(cars)

        mockRacingGame.startGame()

        assertEquals(mockRacingGame.moveCallCount, cars.size)

    }

    @Test
    fun `should return the single winner when one car has highest position`() {
        val car1 = TestCarFactory.buildCar("pobi", 3)
        val car2 = TestCarFactory.buildCar("woni", 2)
        mockRacingGame = MockRacingGame(listOf(car1, car2))

        val winners = mockRacingGame.findWinner()

        assertEquals(winners.size, 1)
        assertEquals(winners[0].name, "pobi")
    }

    @Test
    fun `should return all cars when all have same position`() {
        val car1 = TestCarFactory.buildCar("pobi", 3)
        val car2 = TestCarFactory.buildCar("woni", 3)
        mockRacingGame = MockRacingGame(listOf(car1, car2))

        val winners = mockRacingGame.findWinner()

        assertEquals(winners.size, 2)
        assertTrue(winners.contains(car1))
        assertTrue(winners.contains(car2))
    }

}