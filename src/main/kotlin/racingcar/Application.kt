package racingcar

import racingcar.factory.CarFactory
import racingcar.validation.CarNameValidator

fun main() {
    // TODO: Implement the program
    print("Car names : ")
    val input = readln()

    val carNames = input.split(",")
    CarNameValidator.validateCarNames(carNames)
    val cars = CarFactory.createCars(carNames)

    println("등록된 자동차: ${cars.map { it.name }}")
}
