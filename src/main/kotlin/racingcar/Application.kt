package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
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
