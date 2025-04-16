package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class Car(val name: String, var progress: Int = 0) {
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            progress++
        }
    }

    fun getProgress(): String {
        return "-".repeat(progress)
    }
}

fun main() {
    // receive car names from user
    println("Enter the names of the cars (comma-separated):")
    val carNames = Console.readLine();
    val carNamesList = carNames.split(",").map { it.trim() }

    // receive round count from user
    val roundCount = Console.readLine().toInt()
    println("How many rounds will be played?")

    val cars = carNamesList.map { Car(it) }


}
