package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("Enter the names of the cars (comma-separated):")
    val names= Console.readLine().split(",").map {it.trim()}

    println("How many rounds will be played?")
    val input = Console.readLine()
    validateRoundsInput(input)
    val rounds = input.toInt()

    val cars = names.map {Car(it)}
}

fun validateRoundsInput(input: String) {
    require(input.toIntOrNull() != null) { "Round count must be a valid integer." }
    require(input.toInt() > 0) { "Round count must be greater than 0." }
}

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotBlank()) { "Car name must not be blank." }
        require(name.length <= 5) { "Car name must be 5 characters or less." }
    }

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
    fun getPositionSymbol(): String = "-".repeat(position)
}
