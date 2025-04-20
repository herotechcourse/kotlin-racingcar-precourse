package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

/**
 * Represents a car in a racing game with a name and position.
 *
 * @property name The name of the car. Must have a length between [MIN_NAME_LENGTH] and [MAX_NAME_LENGTH].
 * @property position The current position of the car in the race. Defaults to 0.
 */
class Car(val name: String, var position: Int = 0) {

    companion object {
        const val  MAX_NAME_LENGTH = 5
        const val MIN_NAME_LENGTH= 1
        const val THRESHOLD_MOVE = 4
        const val MIN_RANDOM_RANGE = 0
        const val MAX_RANDOM_RANGE = 9
    }

    init {
        require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH) {"Car name length must be between $MIN_NAME_LENGTH and $MAX_NAME_LENGTH"}
    }

    fun move()  {
        if (Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE) >= THRESHOLD_MOVE) {
            position ++
        }
    }
    fun printPosition() : String {
        return "$name : ${"-".repeat(position)}"
    }
}