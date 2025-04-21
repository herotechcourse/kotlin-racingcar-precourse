package racingcar

import racingcar.factory.CarFactory
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator
import racingcar.view.RaceView

fun main() {
    // TODO: Implement the program
    println("Enter the names of the cars (comma-separated): ")
    val carInput = readln()

    val carNames = carInput.split(",")
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    println("How many rounds will be played?")
    val roundInput = readln()

    val n = InputNumberValidator.validateInputNumber(roundInput)

    RaceView.printResultPerRound(n, cars)

    val winner = Winner(cars)
    winner.findWinners()
    winner.displayWinners()
}

