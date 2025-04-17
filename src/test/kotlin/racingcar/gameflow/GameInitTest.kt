package racingcar.gameflow

/**
 *  GameInit()
 *  = The step to create and initialize the list of car objects,
 *    based on the data, received from GameStartResult.
 *
 *  [ Specification for Test ]
 *  1. Check, carNames are splited by comma correctly.
 *     and make Car object for each name.
 *  2. Return GameInitResult (list of cars, num of rounds)
 *      Check, if GameInitResult object constructed properly.
 */
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals

/** [ Why ]
 *  Why did I write 'GameStartResult' Class again here?
 *  = Ensuring independence of tests.
 *    game-init tests should not depend on 'game-start'
 */
data class GameStartResult(val carNames: String, val rounds: String)
data class Car(val name: String, var position: Int = 0)
data class GameInitResult(val cars: List<Car>, val rounds: Int)

// Not yet implemented (RED)
fun gameInit(input: GameStartResult): GameInitResult {
    TODO("Not yet implemented")
}

class GameInitTest {

    @Test
    fun `1 should create a list of Car objects from carNames`() {
        val input = GameStartResult("pobi,woni,jun", "7")
        val result = gameInit(input)
        // result.cars -> list type
        // result.rounds -> int type

        assertAll(
            { assertEquals(3, result.cars.size) },
            { assertEquals("pobi", result.cars[0].name) },
            { assertEquals("woni", result.cars[1].name) },
            { assertEquals("jun", result.cars[2].name) }
        )
    }

    @Test
    fun `2 should parse the round number as int`() {
        val input = GameStartResult("pobi,woni,jun", "7")
        val result = gameInit(input)

        assertEquals(7, result.rounds)
    }
}