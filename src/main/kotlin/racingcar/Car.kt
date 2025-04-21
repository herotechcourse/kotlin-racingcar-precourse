package racingcar

import camp.nextstep.edu.missionutils.Randoms

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
            throw IllegalArgumentException("Each name must be non-blank and at most 5 characters.")
        }
    }

    // Generate a random number
    fun generateNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    // Move(update the result)
    fun moveCar(move: Int) {
        if (move>=4){
            result += "-"
        }
    }
}