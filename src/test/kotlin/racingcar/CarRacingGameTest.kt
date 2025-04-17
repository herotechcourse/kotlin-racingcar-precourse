package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarRacingGameTest {

    @Test
    fun `should initialize player cars correctly`() {
        val names = listOf("pobi", "jun", "car")
        val game = CarRacingGame(names, 5)

        assertEquals(3, game.playerCars.size)
        assertEquals(listOf("pobi", "jun", "car"), game.playerCars.map { it.name })
    }

    @Test
    fun `should select all winners when multiple players have same max distance`() {
        val names = listOf("pobi", "jun")
        val game = CarRacingGame(names, 5)
        game.playerCars[0].apply { repeat(3) { movingForward(5) } }
        game.playerCars[1].apply { repeat(3) { movingForward(5) } }
        game.updateWinners()

        assertEquals(2, game.winners.size)
        assertTrue(game.winners.any { it.name == "pobi" })
        assertTrue(game.winners.any { it.name == "jun" })
    }
}