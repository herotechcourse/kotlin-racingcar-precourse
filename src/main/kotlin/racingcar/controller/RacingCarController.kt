package racingcar.controller

import racingcar.model.Car
import racingcar.model.RacingGame
import racingcar.model.random.DefaultRandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun start() {
        val cars = inputView.readCarNames().map { Car(it) }
        val numberOfRounds = inputView.readNumberOfRounds()
        val racingGame = RacingGame(cars, DefaultRandomNumberGenerator())
        playRace(numberOfRounds, racingGame, cars)
        decideWinner(racingGame)
    }

    private fun playRace(
        numberOfRounds: Int,
        racingGame: RacingGame,
        cars: List<Car>,
    ) {
        outputView.printRaceResultsMessage()
        repeat(numberOfRounds) {
            racingGame.moveCars()
            outputView.printRaceResults(cars)
        }
    }

    private fun decideWinner(racingGame: RacingGame) {
        val winners = racingGame.decideWinner()
        outputView.printWinners(winners)
    }
}
