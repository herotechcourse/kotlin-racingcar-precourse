package racingcar

import racingcar.input.CarNameInputReader
import racingcar.input.RoundsInputReader
import racingcar.input.processUserInput
import racingcar.validation.CarNameValidator
import racingcar.validation.validateRoundsInput
import racingcar.model.Car
import racingcar.movement.CarAdapter
import racingcar.engine.GameEngine
import racingcar.results.RaceResultPrinter
import racingcar.results.RaceWinnerDeterminer
import racingcar.results.WinnerDisplayer

fun main() {
    // Initialize Input Reader for Car Name and Rounds
    val carNameInputReader = CarNameInputReader()
    val roundsInputReader = RoundsInputReader()

    // Call the read method to get the data from the user
    val carNames = carNameInputReader.read()
    val rounds = roundsInputReader.read()

    // Validate Separator
    CarNameValidator.validateSeparator(carNames)

    // Process the car names input
    val processedCarNames = processUserInput(carNames)

    // Validate each individual Car Names
    CarNameValidator.validateAll(processedCarNames)

    // Validate the rounds input
    val validatedRounds = validateRoundsInput(rounds)

    println()

    // Create a list of Car objects
    val cars = processedCarNames.map { Car(name = it) }

    // Create a GameEngine instance and start the race
    val gameEngine = GameEngine.startGameEngine(cars, validatedRounds) { car ->
        val carAdapter = CarAdapter(car)
        carAdapter.updatePosition()
    }

    // Print the round results using RaceResultPrinter
    RaceResultPrinter(gameEngine).printRaceResults()

    // Determine the winner(s)
    val finalCarResults = gameEngine.getRoundResults().last() // Get the final round results
    val winners = RaceWinnerDeterminer().determineWinners(finalCarResults)

    // Format and display the winner(s)
    println(WinnerDisplayer().formatWinners(winners))
}