package racingcar

import racingcar.model.Car

fun main() {
    // TODO: Implement the program
    print("Car names : ")
    val input = readln()
    if (input.isEmpty()){
        throw IllegalArgumentException("At least one name required")
    }
    val carNames = input.split(",")

    val cars = mutableListOf<Car>()
    for (name in carNames) {
        val trimmedName = name.trim()
        if (trimmedName.isEmpty()) {
            throw IllegalArgumentException("Car name cannot be empty")
        }
        if (trimmedName.length > 5) {
            throw IllegalArgumentException("Each name allowed up to 5 characters: '$trimmedName'")
        }
        cars.add(Car(trimmedName))
    }
    println("등록된 자동차: ${cars.map { it.name }}")
}
