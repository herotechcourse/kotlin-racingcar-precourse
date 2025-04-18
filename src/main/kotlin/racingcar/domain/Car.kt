package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String) {
    var progression: Int = 0
      private set

    fun progress() {
        if (canMove()) {
            ++progression
        }
    }

    private fun canMove(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }
}