package racingcar

import racingcar.model.Car

fun main() {
    // TODO: Implement the program
    print("Car names : ")
    val input = readln()
    val carNames = input.split(",")

    val cars = mutableListOf<Car>()
    for (name in carNames) {
        val trimmedName = name.trim()
        if (trimmedName.length > 5) {
            throw IllegalArgumentException("Each name allowed up to 5 characters: '$trimmedName'")
        }
        cars.add(Car(trimmedName))
    }
    println("등록된 자동차: ${cars.map { it.name }}")
}
