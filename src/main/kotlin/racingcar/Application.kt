package racingcar

import racingcar.factory.CarFactory
import racingcar.input.ConsoleInput
import racingcar.input.InputView
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator
import racingcar.view.ConsoleOutput
import racingcar.view.OutputView

fun main() {
    // TODO: Implement the program
    val inputView: InputView = ConsoleInput
    val outputView: OutputView = ConsoleOutput

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

