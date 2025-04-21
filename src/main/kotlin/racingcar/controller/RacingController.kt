package racingcar.controller

import racingcar.factory.CarFactory
import racingcar.input.InputView
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator
import racingcar.view.OutputView

class RacingController(private val inputView: InputView, private val outputView: OutputView) {

    fun run() {
        val carNames = inputView.readCarNames()
        CarNameValidator.validateCarNames(carNames)
        val cars = CarFactory.createCars(carNames)

        val roundInput = inputView.readRound()
        val n = InputNumberValidator.validateInputNumber(roundInput)

        outputView.printResultPerRound(n, cars)

        val winner = Winner(cars)
        winner.findWinners()

        outputView.displayWinners(winner.winners)
    }
}