import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

import racingcar.engine.GameEngine
import racingcar.model.Car

class GameEngineTest {

    // Mock random movement (For Testing Purposes)
    private fun mockRandomMovement(car: Car) {
        car.position += 1
    }

    @Test
    fun `should start race and update car positions`() {
        // Create a list of cars
        val cars = listOf(Car("Car A"), Car("Car B"))

        // Start Game
        val gameEngine = GameEngine.startGameEngine(cars, totalRounds = 3, randomMovement = ::mockRandomMovement)

        // Get the Rounds results
        val roundResults = gameEngine.getRoundResults()

        // Validate the race run instances for the correct number of rounds
        assertEquals(3, roundResults.size)

        // Validate each car's position that it has increased after each round
        roundResults.forEach { round ->
            round.forEach { result ->
                assertTrue(result.position > 0)
            }
        }
    }

    @Test
    fun `should store the correct round results`() {
        // Create a list of cars
        val cars = listOf(Car("Car A"), Car("Car B"))

        // Start Game
        val gameEngine = GameEngine.startGameEngine(cars, totalRounds = 2, randomMovement = ::mockRandomMovement)

        // Get the Rounds results
        val roundResults = gameEngine.getRoundResults()

        // Validate round 1
        assertEquals(2, roundResults[0].size)  // Total Number of Cards = 2
        assertEquals("Car A", roundResults[0][0].name)
        assertEquals(1, roundResults[0][0].position) // Car A moved to position 1 after first round
        assertEquals("Car B", roundResults[0][1].name)
        assertEquals(1, roundResults[0][1].position) // Car B moved to position 1 after first round

        // Validate round 2
        assertEquals(2, roundResults[1].size)  // Total Number of Cards = 2
        assertEquals("Car A", roundResults[1][0].name)
        assertEquals(2, roundResults[1][0].position) // Car A moved to position 2 after second round
        assertEquals("Car B", roundResults[1][1].name)
        assertEquals(2, roundResults[1][1].position) // Car B moved to position 2 after second round
    }

    @Test
    fun `should handle no rounds correctly`() {
        // Create a list of cars
        val cars = listOf(Car("Car A"), Car("Car B"))

        // Start Game
        val gameEngine = GameEngine.startGameEngine(cars, totalRounds = 0, randomMovement = ::mockRandomMovement)

        // Get the Rounds results
        val roundResults = gameEngine.getRoundResults()

        // Validate that no rounds were executed
        assertEquals(0, roundResults.size)
    }
}