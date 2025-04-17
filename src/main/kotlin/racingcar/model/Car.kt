package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var progress: Int = 0) {
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            progress++
        }
    }

    fun getProgress(): String {
        return "-".repeat(progress)
    }
}
