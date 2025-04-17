import org.junit.jupiter.api.Test

import racingcar.engine.GameEngine
import racingcar.model.Car
import racingcar.results.RaceResultPrinter

class RaceResultPrinterTest {

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

        // Initialize the RaceResultPrinter with the game engine
        val raceResultPrinter = RaceResultPrinter(gameEngine)

        // Print the race results
        raceResultPrinter.printRaceResults()

    }

    @Test
    fun `should store the correct round results`() {
        // Create a list of cars
        val cars = listOf(Car("Car A"), Car("Car B"), Car("Car C"))

        // Start Game
        val gameEngine = GameEngine.startGameEngine(cars, totalRounds = 2, randomMovement = ::mockRandomMovement)

        // Initialize the RaceResultPrinter with the game engine
        val raceResultPrinter = RaceResultPrinter(gameEngine)

        // Print the race results
        raceResultPrinter.printRaceResults()

    }

}