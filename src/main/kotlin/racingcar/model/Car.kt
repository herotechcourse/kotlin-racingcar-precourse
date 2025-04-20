package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(
    var name: String,
    var position: Int = INITIAL_POSITION,
) {
    companion object {
        private const val INITIAL_POSITION = 0

        fun fromNames(names: List<String>): List<Car> {
            return names.map { Car(it) }
        }
    }

    fun moveForward() {
        position++
    }

    fun moveRandomly() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveForward()
        }
    }
}