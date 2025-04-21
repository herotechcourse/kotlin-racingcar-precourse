package racingcar

import racingcar.model.Car

fun main() {
    // TODO: Implement the program
    print("Car names : ")
    val input = readln()
    val carNames = input.split(",")

    val cars = mutableListOf<Car>()
    for (name in carNames) {
        cars.add(Car(name.trim()))
    }

    println("등록된 자동차: ${cars.map { it.name }}")
}
