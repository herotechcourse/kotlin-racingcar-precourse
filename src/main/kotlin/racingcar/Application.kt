package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val names= Console.readLine().split(",").map {it.trim()}

    val cars = names.map {Car(it)}
}

class Car(val name: String) {
    var position = 0
        private set

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
    fun getPositionSymbol(): String = "-".repeat(position)
}
