package racingcar

import kotlin.random.Random

class Car() {
    var name: String = ""
    var result: String =""


    // Set the name
    fun setName(name: String) {
        if (name.isNotBlank() && name.length < 5) {
            this.name =name
        } else {
            throw IllegalArgumentException("Name must be between 1 and 5")
        }
    }

    // Generate a random number
    fun generateNumber(): Int {
        return Random.nextInt(0,10)
    }

    // Move(update the result)
    fun moveCar(move: Int) {
        if (move>=4){
            result += "-".repeat(move)
        }
    }
}