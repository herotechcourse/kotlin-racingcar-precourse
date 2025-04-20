package racingcar.controller

import racingcar.domain.RacingCar
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCar: RacingCar
) {
    fun run() {
        // input
        val carNames = inputView.inputCarNames()
        val roundCount = inputView.inputRoundCount()

        // play
        carNames.forEach { racingCar.addCar(Car(it)) }
        outputView.printResultGuide()
        repeat(roundCount) {
            racingCar.moveCars()
            outputView.printProcess(racingCar.allCars)
        }

        // output
        outputView.printWinner(racingCar.findWinner())
    }
}