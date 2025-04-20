package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Car(
    var name: String,
    var position: Int = INITIAL_POSITION,
) {
    companion object {
        private const val INITIAL_POSITION = 0
        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 9
        private const val MIN_MOVABLE_NUMBER = 4

        fun fromNames(names: List<String>): List<Car> {
            return names.map { Car(it) }
        }
    }

    fun moveForward() {
        position++
    }

    fun moveRandomly() {
        if (Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MIN_MOVABLE_NUMBER) {
            moveForward()
        }
    }
}