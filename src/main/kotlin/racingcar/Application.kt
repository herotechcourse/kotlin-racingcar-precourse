package racingcar

import java.lang.IllegalArgumentException
import camp.nextstep.edu.missionutils.Randoms

val maxRounds: UInt = 200u

fun main() {
    for (i in 0 until 5 step 2) println(i)
    // for (i in 10 until 5) println(i)


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

// fun raceThem(cars: List<Car>, nRounds: UInt)
// {
    
// }

