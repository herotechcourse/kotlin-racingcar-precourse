package racingcar

import camp.nextstep.edu.missionutils.Randoms
import kotlin.random.Random

class Car() {
    var name: String = ""
        private set
    var result: String =""
        private set


    // Set the name
    fun setName(name: String) {
        if (name.isNotBlank() && name.length <= 5) {
            this.name =name
        } else {
            throw IllegalArgumentException("Name must be between 1 and 5. Current name is ${name}")
        }
    }

    // Generate a random number
    fun generateNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    // Move(update the result)
    fun moveCar(move: Int) {
        if (move>=4){
            result += "-".repeat(move)
        }
    }
}