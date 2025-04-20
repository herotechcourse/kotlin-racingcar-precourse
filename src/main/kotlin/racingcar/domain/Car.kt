package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String,
    var position: Int = 0
) {
    fun moveIfPossible() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++
        }
    }
}
