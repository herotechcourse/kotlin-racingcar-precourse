package racingcar

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

val maxRounds: Int = 200

fun main() {
    try {
        val names: List<String> = getUserInputNames()
        val cars: List<Car> = makeCars(names)
        val numRounds: Int = getUserInputRounds()
        raceThem(cars, numRounds)
    } catch (error: IllegalArgumentException) {
        println("Error: ${error.message}")
    }
}

fun makeCars(names: List<String>): List<Car> {
    return names.map { name -> Car(name) }
}

fun raceThem(cars: List<Car>, nRounds: Int) {
    for (i in 0 until nRounds) {
        cars.forEach { car ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) car.move()
            car.printRoundStatus()
        }
        println("")
    }
}
