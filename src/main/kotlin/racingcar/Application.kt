package racingcar

import racingcar.factory.CarFactory
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator

fun main() {
    // TODO: Implement the program
    print("Names of the cars: ")
    val input = readln()

    val carNames = input.split(",")
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    print("Number of rounds: ")
    val n = readln().toInt()

    InputNumberValidator.validateInputNumber(n)

    print("round input: $n")
}

