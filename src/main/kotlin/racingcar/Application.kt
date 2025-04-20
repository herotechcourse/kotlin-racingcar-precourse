package racingcar

import java.lang.IllegalArgumentException

val maxRounds: UInt = 200u

fun main() {
    // TODO: Implement the program
    try {
        val names: List<String> = getUserInputNames()
        val cars: List<Car> = makeCars(names)
        val numRounds: UInt = getUserInputRounds()
    } catch (error: IllegalArgumentException) {
        println("Error: ${error.message}")
    }
}

fun makeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}

