package racingcar

import racingcar.factory.CarFactory
import racingcar.input.CarInput
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator
import racingcar.view.RaceView
import racingcar.view.ResultView

fun main() {
    // TODO: Implement the program

    val carNames = CarInput.readCarNames()
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    println("How many rounds will be played?")
    val roundInput = readln()

    val n = InputNumberValidator.validateInputNumber(roundInput)

    RaceView.printResultPerRound(n, cars)

    val winner = Winner(cars)
    winner.findWinners()

    ResultView.displayWinners(winner.winners)
}

