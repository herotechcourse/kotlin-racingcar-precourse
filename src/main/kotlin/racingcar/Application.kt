package racingcar

import racingcar.model.Car
import racingcar.validation.CarNameValidator

fun main() {
    // TODO: Implement the program
    print("Car names : ")
    val input = readln()

    val carNames = input.split(",")
    val cars: List<Car> = CarNameValidator().validateCarNames(carNames)

    println("등록된 자동차: ${cars.map { it.name }}")
}
