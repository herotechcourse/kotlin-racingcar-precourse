package racingcar.controller

import racingcar.domain.RacingCarGame
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCarGame: RacingCarGame
) {
    fun run() {
        // input
        val carNames = inputView.inputCarNames()
        val roundCount = inputView.inputRoundCount()

        // play
        carNames.forEach { racingCarGame.addCar(Car(it)) }
        outputView.printResultGuide()
        repeat(roundCount) {
            racingCarGame.moveCars()
            outputView.printProcess(racingCarGame.allCars)
        }

        // output
        outputView.printWinner(racingCarGame.findWinner())
    }
}