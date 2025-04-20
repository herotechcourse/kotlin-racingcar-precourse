package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position = 0
        private set

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must not be blank and must be 5 characters or fewer."
        }
    }

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun display(): String = "$name : ${"-".repeat(position)}"
}
