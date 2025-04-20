package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            position += 1
        }
    }

    fun getPositionRepresentation(): String {
        return "-".repeat(position)
    }
}