package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

data class Car(val carName: String, var progress: Int = 0) {
    companion object {
        var progressChar = '-'
    }
    fun moveForward() {
        if (Randoms.pickNumberInRange(0,9) >= 4) progress++
    }
}
