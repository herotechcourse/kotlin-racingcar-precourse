package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var position: Int = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}
