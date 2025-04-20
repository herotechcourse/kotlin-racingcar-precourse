package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0

    fun moveForward() {
        val randomNumber: Int = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position += randomNumber
        }
    }

    fun displayPosition() {
        println("$name : ${"-".repeat(position)}")
    }
}