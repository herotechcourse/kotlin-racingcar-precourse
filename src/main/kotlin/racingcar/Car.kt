package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    private var distance: Int = 0

    val position get() = distance
    fun move() {
        val number = Randoms.pickNumberInRange(0, 9)
        if (number >= 4) {
            distance += 1
        }
    }
}
