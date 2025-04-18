package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    var distance: Int = 0
) {
    fun move() {
        if (canMove()) distance += 1
    }

    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}