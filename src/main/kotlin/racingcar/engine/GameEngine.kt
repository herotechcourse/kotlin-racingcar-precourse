package racingcar.engine

import racingcar.view.InputView
import racingcar.model.Car
import racingcar.model.Race
import racingcar.movement.RandomMovement
import racingcar.view.OutputView

/**
 * Controls the overall execution flow of the racing game.
 * Reads input, runs the race, prints the results.
 */
class GameEngine {
    /**
     * Launches the game:
     * - Reads car names and rounds
     * - Instantiates the race
     * - Runs all rounds, printing progress
     * - Prints the race winners at the end
     */
    fun start() {
        val carNames = InputView.readCarNames()
        val totalRounds = InputView.readTotalRounds()
        val race = Race(
            cars = carNames.map { Car(it) },
            totalRounds = totalRounds,
            movementStrategy = RandomMovement()
        )

        println("\nRace Results")
        while (!race.isFinished()) {
            race.playRound()
            OutputView.printRoundResult(race.getCurrentStatus())
        }
        OutputView.printWinners(race.findWinners())
    }
}
