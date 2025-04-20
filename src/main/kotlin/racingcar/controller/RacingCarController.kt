package racingcar.controller

import racingcar.model.RacingGame
import racingcar.model.random.DefaultRandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {
    fun start() {
        val cars = inputView.receiveCarNamesInput()
        val numberOfRounds = inputView.receiveNumberOfRounds()
        val racingGame = RacingGame(cars, DefaultRandomNumberGenerator())

        outputView.printRaceResultsMessage()
        repeat(numberOfRounds) {
            racingGame.moveCars()
            outputView.printRaceResults(cars)
        }
    }
}
