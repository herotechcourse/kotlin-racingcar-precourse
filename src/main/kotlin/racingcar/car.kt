package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position = 0

    init {
        require(name.isNotBlank() && name.length <= 5) {
            "Car name must be non-empty and up to 5 characters."
        }
    }

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun getPosition(): Int = position

    fun display(): String = "$name : ${"-".repeat(position)}"
}
