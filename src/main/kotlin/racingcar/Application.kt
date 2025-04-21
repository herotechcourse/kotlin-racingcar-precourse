package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.factory.CarFactory
import racingcar.model.Car
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

    println("Race Results")
    repeat(n) {
        for (car in cars) {
            car.move()
        }
        for (car in cars) {
            println("${car.name} : " + "-".repeat(car.position))
        }
        println()
    }

    val winners = mutableListOf<Car>()
    for (car in cars) {
        if (winners.isEmpty()) {
            winners.add(car)
            continue
        }
        if (car.position > winners.last().position) {
            winners.clear()
            winners.add(car)
        } else if (car.position == winners.last().position) {
            winners.add(car)
        } else if (car.position < winners.last().position && winners.size > 1) {
            winners.removeLast()
        } else {
            continue
        }
    }
    print("Winners : " + winners.joinToString(", ") { it.name })
}

