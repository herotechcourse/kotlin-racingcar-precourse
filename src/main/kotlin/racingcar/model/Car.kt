package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, private var distance: Int = 0) {
    val position get() = distance
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) < 4) return
        distance += 1
    }
}
