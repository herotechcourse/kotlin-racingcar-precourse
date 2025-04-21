package racingcar

import camp.nextstep.edu.missionutils.Randoms
import java.io.Console
import java.util.*


fun main() {
    val cars = getCarNames()
    val rounds = getRounds()

    println(cars)
    println(rounds)
}


fun getCarNames(): Map<String, String> {
    println("Enter the names of the cars (comma-separated):")
    val cars = mutableMapOf<String, String>()

    if (cars.isEmpty() || cars.any { it.value.isBlank() || it.value.length > 5 }) {
        throw IllegalArgumentException("Car names should be 1–5 characters.")
    }
    return cars
}

fun getRounds(): Int {
    println("How many rounds will be played?")
    return readln().toInt()
}

