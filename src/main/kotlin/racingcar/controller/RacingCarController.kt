package racingcar.controller

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
) {
    fun startGame() {
        val carNames = InputView.readCarNames()
        val rounds = InputView.readRound()
        val cars = carNames.map { racingcar.model.Car(it) }

        println()

        OutputView.printResultMessage()

        val racingGame = RacingGame(cars)
        repeat(rounds) {
            racingGame.play()
            OutputView.printCarPositions(cars)
        }

        val winners = racingGame.getWinners()
        OutputView.printWinner(winners)
    }

}
