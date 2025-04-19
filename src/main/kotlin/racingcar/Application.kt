package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    println("How many rounds will be played?")
    val input = Console.readLine() ?: ""

    val carNames = input.split(",").map { it.trim() }
    carNames.forEach {
        if (it.length > 5) {
            throw IllegalArgumentException("Car name cannot exceed 5 characters: $it")
        }
    }


    println("Race Results")
}

data class Car(val name: String, var position: Int = 0) {
    fun move() {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) {
            position++
        }
    }
}
