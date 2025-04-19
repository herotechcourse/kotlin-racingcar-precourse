package racingcar

import racingcar.models.Car
import racingcar.utils.InputUtils

fun main() {
    // Make sure program runs with Kotlin 1.9.24 - TODO: delete before submission
    print("Kotlin version: ")
    println(KotlinVersion.CURRENT)

    val carNames = InputUtils.readCarNames()
    println("carNames: $carNames") // TODO: delete before submission

    val rounds = InputUtils.readRounds()
    println("rounds: $rounds") // TODO: delete before submission

    val cars = Car.createCars(carNames)
    // TODO: delete below prints before submission
    println("cars: $cars")
    print("car.name: ")
    for (car in cars) {
        print(car.name)
        print(" ")
    }
    println()

    Car.raceCars(cars, rounds)
}
