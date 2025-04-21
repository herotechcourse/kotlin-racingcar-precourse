package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.factory.CarFactory
import racingcar.model.Car
import racingcar.model.Winner
import racingcar.validation.CarNameValidator
import racingcar.validation.InputNumberValidator

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

    val winner = Winner(cars)
    winner.findWinners()
    winner.displayWinners()
}

