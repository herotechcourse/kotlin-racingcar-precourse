package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(var name: String) {
    var position = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position += 1
        }
    }
}