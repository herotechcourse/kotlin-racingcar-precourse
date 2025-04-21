package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var position: Int = 0
        private set

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}
