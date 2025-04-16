package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {

    var position = 0

    fun move() {
        if (canMove())
        position++
    }

    private fun canMove(): Boolean {
        val num = Randoms.pickNumberInRange(0, 9)
        return num >= 4
    }


}
