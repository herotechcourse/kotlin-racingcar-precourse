package racingcar

import racingcar.factory.CarFactory
import racingcar.input.ConsoleView
import racingcar.input.InputView
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator
import racingcar.view.RaceView
import racingcar.view.ResultView

fun main() {
    // TODO: Implement the program

    val carNames = ConsoleView.readCarNames()
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    val roundInput = ConsoleView.readRound()
    val n = InputNumberValidator.validateInputNumber(roundInput)

    RaceView.printResultPerRound(n, cars)

    val winner = Winner(cars)
    winner.findWinners()

    ResultView.displayWinners(winner.winners)
}

