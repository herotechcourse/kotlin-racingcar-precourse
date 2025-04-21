package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var distance: String = ""
        private set

    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) {
            distance += "-"
        }
    }
}
