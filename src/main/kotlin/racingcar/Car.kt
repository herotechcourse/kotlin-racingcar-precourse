package racingcar

import kotlin.random.Random

class Car(var name: String, var result: String) {
    var move: Int = 0

    // Generate a random number
    fun generateNumber() {
        move = Random.nextInt(0,10)
    }

    // Move(update the result)
    fun moveCar() {
        result += "-".repeat(move)
    }
}