package racingcar

import racingcar.models.Car
import racingcar.utils.InputUtils

fun main() {
    val carNames = InputUtils.readCarNames()
    val rounds = InputUtils.readRounds()

    val cars = Car.createCars(carNames)

    Car.raceCars(cars, rounds)
    Car.printWinners(cars)
}
