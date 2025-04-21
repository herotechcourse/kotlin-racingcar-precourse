package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class Car(
    val name: String
) {
    var position = 0
        private set

    init {
        require(name.isNotBlank() && name.length <= MAX_NAME_LENGTH) {
            "Car name must not be empty and should be at most 5 characters."
        }
    }

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            position++
        }
    }

    companion object {
        const val MAX_NAME_LENGTH = 5
        const val MOVE_THRESHOLD = 4
    }
}