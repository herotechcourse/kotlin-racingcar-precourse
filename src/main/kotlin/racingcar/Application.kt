package racingcar

import racingcar.factory.CarFactory
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator

fun main() {
    // TODO: Implement the program
    print("Names of the cars: ")
    val carInput = readln()

    val carNames = carInput.split(",")
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    print("Number of rounds: ")
    val roundInput = readln()

    val n = InputNumberValidator.validateInputNumber(roundInput)

    print("round input: $n")
}

