package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Car(val name: String, var progress: Int = 0) {
    fun tryMove() {
        val random = Randoms.pickNumberInRange(0, 9)
        if (random >= 4) progress++
    }

    fun displayStatus(): String {
        return "$name : ${printDashes(progress)}"
    }
}
